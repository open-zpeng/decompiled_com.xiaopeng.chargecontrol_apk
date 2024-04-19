package defpackage;

import android.app.ActivityThread;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import com.xiaopeng.chargecontrol.R;
import com.xiaopeng.lib.framework.moduleinterface.ipcmodule.IIpcService;
import com.xiaopeng.libconfig.ipc.IpcConfig;
import com.xiaopeng.libconfig.ipc.bean.MessageCenterBean;
import com.xiaopeng.libconfig.ipc.bean.MessageContentBean;
import com.xiaopeng.speech.vui.utils.LogUtils;
import defpackage.fa0;
import defpackage.jy;
import defpackage.my;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: TrunkPowerTask.java */
/* renamed from: j80  reason: default package */
/* loaded from: classes.dex */
public class j80 implements i80 {
    public boolean a = false;
    public ld0 b;

    public void a() {
        Log.i("TrunkPowerTask", "notifyAmbiguousTrunkPowerSwitch() called");
        this.a = false;
        Application currentApplication = ActivityThread.currentApplication();
        MessageContentBean createContent = MessageContentBean.createContent();
        createContent.setType(1);
        createContent.addTitle("");
        createContent.addTitle(currentApplication.getString(R.string.message_trunk_power_enable_title));
        createContent.setTts(currentApplication.getString(R.string.message_trunk_power_enable_title));
        createContent.setValidTime(TimeUnit.DAYS.toMillis(3L) + System.currentTimeMillis());
        createContent.addButton(MessageContentBean.MsgButton.create(currentApplication.getString(R.string.message_trunk_power_enable_button), "com.xiaopeng.chargecontrol", String.format("{\"%s\":%d}", "scene", 5011)));
        createContent.setComingSoundType(0);
        MessageCenterBean create = MessageCenterBean.create(5, createContent);
        create.setScene(5011);
        Bundle bundle = new Bundle();
        bundle.putString(IpcConfig.IPCKey.STRING_MSG, ca0.a(create));
        z90.a((int) IpcConfig.MessageCenterConfig.IPC_ID_APP_PUSH_MESSAGE, bundle, IpcConfig.App.MESSAGE_CENTER);
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onIgStatusChanged(qy qyVar) {
        if (1 == qyVar.a) {
            if (x90.x()) {
                x90.i(fa0.b.a.g());
            } else if (this.a) {
                a();
            }
        }
    }

    @tl0(threadMode = ThreadMode.MAIN)
    public void onIpcMessage(IIpcService.IpcMessageEvent ipcMessageEvent) {
        if (ipcMessageEvent.getMsgID() == 10011) {
            String string = ipcMessageEvent.getPayloadData().getString(IpcConfig.IPCKey.STRING_MSG);
            Log.i("TrunkPowerTask", "onIpcMessage: " + string);
            try {
                if (new JSONObject(string).getInt("scene") == 5011) {
                    x90.b(true);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onNedcRemainingDistanceChanged(my.h0 h0Var) {
        LogUtils.e("TrunkPowerTask", "onNedcRemainingDistanceChanged");
        if (((Integer) h0Var.a).intValue() >= 30 || !x90.x()) {
            return;
        }
        x90.b(false);
        e10 e10Var = new e10(ActivityThread.currentApplication(), u60.XDialogView);
        e10Var.c(2048);
        e10Var.d(R.string.toast_trunk_power_hint);
        e10Var.g(R.string.toast_trunk_power_auto_disable);
        e10Var.b(R.string.know_it);
        ld0 ld0Var = this.b;
        if (ld0Var != null) {
            ld0Var.a();
        }
        this.b = e10Var;
        e10Var.f(2008);
        e10Var.e();
    }

    @tl0(threadMode = ThreadMode.MAIN)
    public void onPhoneAppTrunkPowerStateChanged(jy.c cVar) {
        Log.d("TrunkPowerTask", "onPhoneAppTrunkPowerStateChanged() called with: event = [" + cVar + "]");
        if (((Integer) cVar.a).intValue() == 0) {
            if (((iz) x90.m()).a(0) == 1) {
                if (x90.x()) {
                    return;
                }
                a();
                return;
            }
            this.a = true;
            return;
        }
        this.a = false;
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onTrunkPowerStateChanged(jy.e eVar) {
        if (((Integer) eVar.a).intValue() == 3) {
            z90.d(R.string.toast_trunk_power_fault);
        }
    }

    @Override // defpackage.i80
    public void start() {
        iv.d(this);
    }

    @Override // defpackage.i80
    public void stop() {
        iv.e(this);
    }
}
