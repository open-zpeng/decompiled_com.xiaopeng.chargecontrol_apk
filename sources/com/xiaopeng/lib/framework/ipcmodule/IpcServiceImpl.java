package com.xiaopeng.lib.framework.ipcmodule;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.TransactionTooLargeException;
import android.util.Log;
import com.xiaopeng.ipc.IPC;
import com.xiaopeng.ipc.IPCCallback;
import com.xiaopeng.ipc.IpcMessage;
import com.xiaopeng.lib.framework.moduleinterface.ipcmodule.IIpcService;
import java.security.InvalidParameterException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes.dex */
public class IpcServiceImpl implements IIpcService {
    public static final int IPC_MIN_REGISTER_INTERVAL = 500;
    public static final int IPC_SERVICE_BIND_INTERVAL = 1000;
    public static final int MSG_BIND_SERVICE = 1;
    public static final int MSG_UNBIND_SERVICE = 2;
    public static final String PACKAGE_SPLIT = ";";
    public static final String TAG = "IpcServiceImpl";
    public volatile IPC ipcService;
    public volatile Context mContext;
    public IBinder.DeathRecipient mDeathRecipient;
    public ExecutorService mExecutorService;
    public IpcHandler mHandler;
    public HandlerThread mHandlerThread;
    public IPCCallback mIPCCallback;
    public long mLastRegisterTime;
    public ConcurrentLinkedQueue<IPCData> mQueue;
    public Runnable mSendingRunnable;
    public ServiceConnection mServiceConnection;

    /* loaded from: classes.dex */
    public class IPCData {
        public String appIds;
        public IpcMessage data;

        public IPCData() {
        }

        public String getAppIds() {
            return this.appIds;
        }

        public IpcMessage getData() {
            return this.data;
        }

        public void setAppIds(String str) {
            this.appIds = str;
        }

        public void setData(IpcMessage ipcMessage) {
            this.data = ipcMessage;
        }

        public String toString() {
            StringBuilder a = jg.a("IPCData{data='");
            a.append(this.data);
            a.append('\'');
            a.append(", appIds='");
            a.append(this.appIds);
            a.append('\'');
            a.append('}');
            return a.toString();
        }
    }

    /* loaded from: classes.dex */
    public class IpcHandler extends Handler {
        public IpcHandler(Looper looper) {
            super(looper);
        }

        private void bindRemoteService() {
            StringBuilder a = jg.a("mContext = ");
            a.append(IpcServiceImpl.this.mContext);
            a.append(", ipcService = ");
            a.append(IpcServiceImpl.this.ipcService);
            Log.d(IpcServiceImpl.TAG, a.toString());
            if (IpcServiceImpl.this.mContext == null || IpcServiceImpl.this.ipcService != null) {
                return;
            }
            Intent intent = new Intent("com.xiaopeng.ipc.IPCAidl");
            intent.setPackage("com.xiaopeng.ipc");
            IpcServiceImpl.this.mContext.bindService(intent, IpcServiceImpl.this.mServiceConnection, 1);
        }

        private void unbindRemoteService() {
            if (IpcServiceImpl.this.mContext != null) {
                IpcServiceImpl.this.mContext.unbindService(IpcServiceImpl.this.mServiceConnection);
                IpcServiceImpl.this.mServiceConnection.onServiceDisconnected(null);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 1) {
                Log.d(IpcServiceImpl.TAG, "bind ServiceIntent");
                bindRemoteService();
            } else if (i != 2) {
            } else {
                Log.d(IpcServiceImpl.TAG, "unbind ServiceIntent");
                unbindRemoteService();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class IpcModuleServiceSingle {
        public static final IpcServiceImpl INSTANCE = new IpcServiceImpl();
    }

    public static IpcServiceImpl getInstance() {
        return IpcModuleServiceSingle.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerIpcClient(IPC ipc) {
        StringBuilder a = jg.a("registerIpcClient:\t service !=null:\t");
        a.append(ipc != null);
        a.append("");
        a.append(mb0.a());
        Log.i(TAG, a.toString());
        if (ipc != null) {
            ipc.registerClient(mb0.a(), this.mIPCCallback);
            this.mLastRegisterTime = System.currentTimeMillis();
        }
    }

    public void init(Context context) {
        Log.d(TAG, "init context:" + context);
        if (this.mContext == null) {
            this.mContext = context;
        }
        sendBindServiceMessage();
    }

    public void sendBindServiceMessage() {
        if (this.mHandler.hasMessages(1)) {
            this.mHandler.removeMessages(1);
        }
        this.mHandler.sendEmptyMessage(1);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.ipcmodule.IIpcService
    public void sendData(int i, Bundle bundle, String... strArr) {
        if (this.mContext != null) {
            if (strArr.length != 0) {
                StringBuilder sb = new StringBuilder();
                int length = strArr.length;
                int i2 = 0;
                for (String str : strArr) {
                    i2++;
                    sb.append(str);
                    if (i2 < length) {
                        sb.append(PACKAGE_SPLIT);
                    }
                }
                IPCData iPCData = new IPCData();
                IpcMessage ipcMessage = new IpcMessage();
                ipcMessage.setPackageName(this.mContext.getPackageName());
                ipcMessage.setMsgId(i);
                ipcMessage.setPayloadData(bundle);
                iPCData.setData(ipcMessage);
                iPCData.setAppIds(sb.toString());
                this.mQueue.offer(iPCData);
                this.mExecutorService.execute(this.mSendingRunnable);
                return;
            }
            throw new InvalidParameterException("destination is null");
        }
        throw new IllegalStateException("please init context");
    }

    public void sendUnbindServiceMessage() {
        if (this.mHandler.hasMessages(2)) {
            this.mHandler.removeMessages(2);
        }
        this.mHandler.sendEmptyMessage(2);
    }

    public IpcServiceImpl() {
        this.mLastRegisterTime = 0L;
        this.mQueue = new ConcurrentLinkedQueue<>();
        this.mExecutorService = Executors.newSingleThreadExecutor();
        this.mIPCCallback = new IPCCallback.Stub() { // from class: com.xiaopeng.lib.framework.ipcmodule.IpcServiceImpl.1
            @Override // com.xiaopeng.ipc.IPCCallback
            public void onReceive(IpcMessage ipcMessage) {
                StringBuilder a = jg.a("onReceive:\t sender ");
                a.append(ipcMessage.getPackageName());
                a.append("\thasSubscriberForEvent:\t");
                a.append(jl0.c().b(IIpcService.IpcMessageEvent.class));
                Log.i(IpcServiceImpl.TAG, a.toString());
                IIpcService.IpcMessageEvent ipcMessageEvent = new IIpcService.IpcMessageEvent();
                ipcMessageEvent.setPayloadData(ipcMessage.getPayloadData());
                ipcMessageEvent.setMsgID(ipcMessage.getMsgId());
                ipcMessageEvent.setSenderPackageName(ipcMessage.getPackageName());
                if (jl0.c().b(IIpcService.IpcMessageEvent.class)) {
                    Log.i(IpcServiceImpl.TAG, "post messageEvent");
                    jl0.c().b(ipcMessageEvent);
                    return;
                }
                Log.i(IpcServiceImpl.TAG, "postSticky messageEvent");
                jl0.c().c(ipcMessageEvent);
            }
        };
        this.mSendingRunnable = new Runnable() { // from class: com.xiaopeng.lib.framework.ipcmodule.IpcServiceImpl.2
            @Override // java.lang.Runnable
            public void run() {
                while (!IpcServiceImpl.this.mQueue.isEmpty()) {
                    if (IpcServiceImpl.this.ipcService != null) {
                        IPCData iPCData = (IPCData) IpcServiceImpl.this.mQueue.peek();
                        if (iPCData != null) {
                            try {
                                synchronized (IpcServiceImpl.class) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("sendData+ipcService!=null:\t");
                                    sb.append(IpcServiceImpl.this.ipcService != null);
                                    sb.append(":\tappIds:\t");
                                    sb.append(iPCData.getAppIds());
                                    sb.append("\tdata:\t");
                                    sb.append(iPCData.getData());
                                    Log.i(IpcServiceImpl.TAG, sb.toString());
                                    if (IpcServiceImpl.this.ipcService != null) {
                                        IpcServiceImpl.this.ipcService.sendData(iPCData.getAppIds(), iPCData.getData());
                                        IpcServiceImpl.this.mQueue.poll();
                                    }
                                }
                            } catch (RemoteException e) {
                                e.printStackTrace();
                                Log.e(IpcServiceImpl.TAG, "Send Data error, e-->" + e.getMessage());
                                if (e instanceof TransactionTooLargeException) {
                                    Log.e(IpcServiceImpl.TAG, "Too large data: " + iPCData);
                                    IpcServiceImpl.this.mQueue.poll();
                                }
                            }
                        }
                    } else {
                        IpcServiceImpl.this.sendBindServiceMessage();
                        try {
                            Thread.sleep(1000L);
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        };
        this.mDeathRecipient = new IBinder.DeathRecipient() { // from class: com.xiaopeng.lib.framework.ipcmodule.IpcServiceImpl.3
            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                synchronized (IpcServiceImpl.class) {
                    if (IpcServiceImpl.this.ipcService == null) {
                        return;
                    }
                    IpcServiceImpl.this.ipcService.asBinder().unlinkToDeath(IpcServiceImpl.this.mDeathRecipient, 0);
                    IpcServiceImpl.this.ipcService = null;
                    IpcServiceImpl.this.sendBindServiceMessage();
                }
            }
        };
        this.mServiceConnection = new ServiceConnection() { // from class: com.xiaopeng.lib.framework.ipcmodule.IpcServiceImpl.4
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Log.d(IpcServiceImpl.TAG, "onServiceConnected");
                synchronized (IpcServiceImpl.class) {
                    IpcServiceImpl.this.ipcService = IPC.Stub.asInterface(iBinder);
                    try {
                        IpcServiceImpl.this.registerIpcClient(IpcServiceImpl.this.ipcService);
                        iBinder.linkToDeath(IpcServiceImpl.this.mDeathRecipient, 0);
                    } catch (RemoteException e) {
                        Log.i(IpcServiceImpl.TAG, "onServiceConnected exception");
                        e.printStackTrace();
                    }
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                StringBuilder a = jg.a("onServiceDisconnected ipcService-->");
                a.append(IpcServiceImpl.this.ipcService);
                Log.d(IpcServiceImpl.TAG, a.toString());
                synchronized (IpcServiceImpl.class) {
                    if (IpcServiceImpl.this.ipcService == null) {
                        return;
                    }
                    try {
                        IpcServiceImpl.this.ipcService.unregisterClient(mb0.a(), IpcServiceImpl.this.mIPCCallback);
                        IpcServiceImpl.this.ipcService.asBinder().unlinkToDeath(IpcServiceImpl.this.mDeathRecipient, 0);
                    } catch (RemoteException e) {
                        Log.i(IpcServiceImpl.TAG, "onServiceDisconnected exception");
                        e.printStackTrace();
                    }
                    IpcServiceImpl.this.ipcService = null;
                }
            }
        };
        this.mHandlerThread = new HandlerThread("ipcmodule");
        this.mHandlerThread.start();
        this.mHandler = new IpcHandler(this.mHandlerThread.getLooper());
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.ipcmodule.IIpcService
    public void init() {
        boolean z = System.currentTimeMillis() - this.mLastRegisterTime > 500;
        Log.i(TAG, "init--> moreThanInterval:\t" + z);
        if (z) {
            try {
                synchronized (IpcServiceImpl.class) {
                    registerIpcClient(this.ipcService);
                }
            } catch (RemoteException e) {
                StringBuilder a = jg.a("registerIpcClient:\t exception");
                a.append(e.getMessage());
                Log.i(TAG, a.toString());
                e.printStackTrace();
            }
        }
    }
}
