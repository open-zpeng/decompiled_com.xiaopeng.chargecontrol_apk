package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.RemoteException;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEvent;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent;
import defpackage.eb0;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
/* compiled from: StatMqttDelegate.java */
/* renamed from: db0  reason: default package */
/* loaded from: classes.dex */
public class db0 extends xa0 implements Handler.Callback {
    public Handler c;

    /* compiled from: StatMqttDelegate.java */
    /* renamed from: db0$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ IStatEvent c;

        public a(IStatEvent iStatEvent) {
            this.c = iStatEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            StringBuilder a = jg.a("uploadCdu stat:");
            a.append(this.c.toString());
            gb0.a("StatMqttDelegate", a.toString());
            db0.this.b(this.c.toJson());
        }
    }

    /* compiled from: StatMqttDelegate.java */
    /* renamed from: db0$b */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public final /* synthetic */ IMoleEvent c;

        public b(IMoleEvent iMoleEvent) {
            this.c = iMoleEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            StringBuilder a = jg.a("uploadCdu mole:");
            a.append(this.c.toString());
            gb0.a("StatMqttDelegate", a.toString());
            db0.this.b(this.c.toJson());
        }
    }

    /* compiled from: StatMqttDelegate.java */
    /* renamed from: db0$c */
    /* loaded from: classes.dex */
    public class c {
        public ra0 a;
        public List<String> b;

        public c(db0 db0Var, ra0 ra0Var, List<String> list) {
            this.a = ra0Var;
            this.b = list;
        }
    }

    public db0(Context context) {
        super(context);
        ya0 f = ya0.f();
        f.b = context;
        f.a();
        HandlerThread handlerThread = new HandlerThread("StatMqttDelegate", 10);
        handlerThread.start();
        this.c = new Handler(handlerThread.getLooper(), this);
    }

    public final void b(String str) {
        if (!ya0.f().e()) {
            this.c.sendMessageDelayed(Message.obtain(this.c, 2, str), 1000L);
            return;
        }
        this.c.sendMessage(Message.obtain(this.c, 2, str));
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        boolean z = false;
        switch (message.what) {
            case 1:
                String str = (String) message.obj;
                ya0 f = ya0.f();
                eb0 eb0Var = f.a;
                if (eb0Var != null) {
                    try {
                        ((eb0.a.C0005a) eb0Var).a(str);
                        if (f.c.size() > 0) {
                            f.b();
                        }
                        z = true;
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
                if (!z) {
                    f.c.add(str);
                    if (f.c.size() >= 20) {
                        f.b();
                        break;
                    } else if (!f.f.hasMessages(1)) {
                        f.f.sendEmptyMessageDelayed(1, 60000L);
                        break;
                    }
                }
                break;
            case 2:
                ya0.f().a((String) message.obj);
                break;
            case 3:
                List list = (List) message.obj;
                String str2 = (String) list.get(0);
                String str3 = (String) list.get(1);
                eb0 eb0Var2 = ya0.f().a;
                if (eb0Var2 != null) {
                    try {
                        ((eb0.a.C0005a) eb0Var2).a(str2, str3);
                        z = true;
                    } catch (RemoteException e2) {
                        gb0.a("DataCollectorHelper", "uploadLogImmediately error!", e2);
                    }
                }
                if (!z && gb0.a(5)) {
                    gb0.a(5, "DataCollectorHelper", "uploadLogImmediately fail and ignore!", null, gb0.d);
                    break;
                }
                break;
            case 4:
                c cVar = (c) message.obj;
                ya0 f2 = ya0.f();
                jb0.a(new ab0(f2, f2.d(), cVar.b, cVar.a));
                break;
            case 5:
                List<String> list2 = (List) message.obj;
                eb0 eb0Var3 = ya0.f().a;
                if (eb0Var3 != null) {
                    try {
                        ((eb0.a.C0005a) eb0Var3).a(list2);
                        break;
                    } catch (RemoteException e3) {
                        e3.printStackTrace();
                        break;
                    }
                }
                break;
            case 6:
                List list3 = (List) message.obj;
                String str4 = (String) list3.get(0);
                String str5 = (String) list3.get(1);
                ya0 f3 = ya0.f();
                eb0 eb0Var4 = f3.a;
                if (eb0Var4 != null) {
                    try {
                        ((eb0.a.C0005a) eb0Var4).b(str4, str5);
                        if (f3.d.size() > 0) {
                            f3.c();
                        }
                        z = true;
                    } catch (RemoteException e4) {
                        e4.printStackTrace();
                    }
                }
                if (!z) {
                    f3.a((Map) f3.e.a(((IDataLog) Module.get(oa0.class).get(IDataLog.class)).buildStat().setEventName(str4).setProperty("data", str5).build().toJson(), new za0(f3).b));
                    break;
                }
                break;
        }
        return true;
    }

    @Override // defpackage.xa0
    public void a(IStatEvent iStatEvent) {
        jb0.a(0, new a(iStatEvent));
    }

    @Override // defpackage.xa0
    public void a(IMoleEvent iMoleEvent) {
        jb0.a(0, new b(iMoleEvent));
    }

    @Override // defpackage.xa0
    public void a(String str) {
        if (!ya0.f().e()) {
            this.c.sendMessageDelayed(Message.obtain(this.c, 1, str), 1000L);
            return;
        }
        this.c.sendMessage(Message.obtain(this.c, 1, str));
    }

    @Override // defpackage.xa0
    public void b(String str, String str2) {
        List asList = Arrays.asList(str, str2);
        if (!ya0.f().e()) {
            this.c.sendMessageDelayed(Message.obtain(this.c, 6, asList), 1000L);
        } else {
            this.c.sendMessage(Message.obtain(this.c, 6, asList));
        }
    }

    @Override // defpackage.xa0
    public void a(String str, String str2) {
        List asList = Arrays.asList(str, str2);
        if (!ya0.f().e()) {
            this.c.sendMessageDelayed(Message.obtain(this.c, 3, asList), 1000L);
        } else {
            this.c.sendMessage(Message.obtain(this.c, 3, asList));
        }
    }

    @Override // defpackage.xa0
    public void a(IStatEvent iStatEvent, List<String> list) {
        c cVar = new c(this, (ra0) iStatEvent, list);
        if (!ya0.f().e()) {
            this.c.sendMessageDelayed(Message.obtain(this.c, 4, cVar), 1000L);
            return;
        }
        this.c.sendMessage(Message.obtain(this.c, 4, cVar));
    }

    @Override // defpackage.xa0
    public void a(List<String> list) {
        if (!ya0.f().e()) {
            this.c.sendMessageDelayed(Message.obtain(this.c, 5, list), 1000L);
            return;
        }
        this.c.sendMessage(Message.obtain(this.c, 5, list));
    }

    @Override // defpackage.xa0
    public String a() {
        ya0 f = ya0.f();
        String str = f.d()[0];
        jb0.a(new bb0(f, str));
        return str;
    }
}
