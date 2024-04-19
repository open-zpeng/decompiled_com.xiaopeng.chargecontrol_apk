package defpackage;

import android.app.ActivityThread;
import android.app.Application;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.xiaopeng.chargecontrol.R;
import com.xiaopeng.lib.apirouter.ApiRouter;
import com.xiaopeng.lib.framework.moduleinterface.configurationmodule.ConfigurationChangeEvent;
import com.xiaopeng.lib.framework.moduleinterface.configurationmodule.IConfigurationData;
import com.xiaopeng.libconfig.ipc.IpcConfig;
import com.xiaopeng.libconfig.ipc.bean.MessageCenterBean;
import com.xiaopeng.libconfig.ipc.bean.MessageContentBean;
import defpackage.fa0;
import defpackage.my;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.ThreadMode;
/* compiled from: LfpBatteryNotFullyChargedHintTask.java */
/* renamed from: f80  reason: default package */
/* loaded from: classes.dex */
public class f80 implements i80 {
    public int a = 30;
    public int b = 1500;
    public boolean c;
    public kh0 d;

    public final void a() {
        if (fa0.b.a.a.getString("lfp_unfull_charged_hint_message_id", "").isEmpty()) {
            return;
        }
        a(IpcConfig.AIAssistantConfig.IPC_MESSAGE_CLOSE, fa0.b.a.a.getString("lfp_unfull_charged_hint_message_id", ""));
        fa0.b.a.a.edit().putString("lfp_unfull_charged_hint_message_id", "").apply();
    }

    public /* synthetic */ void b() {
        if (((cz) x90.d()).a(-1) != 1) {
            return;
        }
        iv.d(this);
        float a = x90.a(-1.0f);
        boolean a2 = x90.d().a(false);
        Log.i("LfpBatteryNotFullyChargedHintTask", "start() totalmileage = " + a + ", isFull = " + a2);
    }

    public final void c() {
        Log.i("LfpBatteryNotFullyChargedHintTask", "toHint()");
        String format = new SimpleDateFormat("yyyy年MM月dd日").format(new Date(System.currentTimeMillis()));
        if (format.equals(fa0.b.a.a.getString("lfp_unfull_charged_hint_day", ""))) {
            Log.w("LfpBatteryNotFullyChargedHintTask", "LFP not full charged hinted today!");
            return;
        }
        fa0.b.a.a.edit().putString("lfp_unfull_charged_hint_day", format).apply();
        Log.i("LfpBatteryNotFullyChargedHintTask", "sendMessageCenter!");
        a();
        Application currentApplication = ActivityThread.currentApplication();
        MessageContentBean createContent = MessageContentBean.createContent();
        createContent.setType(1);
        createContent.addTitle(currentApplication.getString(R.string.message_lfp_not_full_charged_title));
        createContent.addTitle(currentApplication.getString(R.string.message_lfp_not_full_charged));
        createContent.setTts(currentApplication.getString(R.string.message_lfp_not_full_charged_tts));
        createContent.setValidTime(TimeUnit.DAYS.toMillis(1L) + System.currentTimeMillis());
        MessageContentBean.ShowRules showRules = new MessageContentBean.ShowRules();
        showRules.setGearLever("4");
        createContent.setShowRules(showRules);
        createContent.addButton(MessageContentBean.MsgButton.create(currentApplication.getString(R.string.message_lfp_not_full_charged_button), "com.xiaopeng.chargecontrol", String.format("{\"%s\":%d}", "scene", 5012)));
        createContent.setComingSoundType(0);
        MessageCenterBean create = MessageCenterBean.create(5, createContent);
        create.setScene(5012);
        fa0.b.a.a(create.getMessageId());
        if (a70.k()) {
            uu uuVar = new uu();
            uuVar.a(IpcConfig.IPCKey.STRING_MSG, ca0.a(create));
            a(IpcConfig.MessageCenterConfig.IPC_ID_APP_PUSH_MESSAGE, uuVar.toString(), "com.xiaopeng.aiassistant");
        } else {
            Bundle bundle = new Bundle();
            bundle.putString(IpcConfig.IPCKey.STRING_MSG, ca0.a(create));
            z90.a((int) IpcConfig.MessageCenterConfig.IPC_ID_APP_PUSH_MESSAGE, bundle, IpcConfig.App.MESSAGE_CENTER);
        }
        a(IpcConfig.MessageCenterConfig.IPC_ID_APP_PUSH_MESSAGE, ca0.a(create));
    }

    @tl0(threadMode = ThreadMode.BACKGROUND)
    public void onConfigurationChanged(ConfigurationChangeEvent configurationChangeEvent) {
        List<IConfigurationData> changeList = configurationChangeEvent.getChangeList();
        if (changeList != null) {
            for (IConfigurationData iConfigurationData : changeList) {
                if (iConfigurationData.getKey().equals("lfp_not_fully_charged_day")) {
                    try {
                        this.a = Integer.parseInt(iConfigurationData.getKey());
                        Log.i("LfpBatteryNotFullyChargedHintTask", "serverConfig onService ConfigurationChanged   :\tlfp_not_fully_charged_day");
                    } catch (Exception e) {
                        StringBuilder a = jg.a("LFP_NOT_FULLY_CHARGED_DAY ConfigurationChanged error");
                        a.append(e.getMessage());
                        Log.e("LfpBatteryNotFullyChargedHintTask", a.toString());
                    }
                } else if (iConfigurationData.getKey().equals("lfp_not_fully_charged_mileage")) {
                    try {
                        this.b = Integer.parseInt(iConfigurationData.getKey());
                        Log.i("LfpBatteryNotFullyChargedHintTask", "serverConfig onService ConfigurationChanged   :\tlfp_not_fully_charged_mileage");
                    } catch (Exception e2) {
                        StringBuilder a2 = jg.a("LFP_NOT_FULLY_CHARGED_MILEAGE ConfigurationChanged error");
                        a2.append(e2.getMessage());
                        Log.e("LfpBatteryNotFullyChargedHintTask", a2.toString());
                    }
                }
            }
        }
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onRealLevelChanged(my.k0 k0Var) {
        if (((Integer) k0Var.a).intValue() == 4) {
            try {
                this.a = Integer.parseInt(aa0.a("lfp_not_fully_charged_day", "30"));
            } catch (Exception e) {
                StringBuilder a = jg.a("LFP_NOT_FULLY_CHARGED_DAY Configuration error");
                a.append(e.getMessage());
                Log.e("LfpBatteryNotFullyChargedHintTask", a.toString());
            }
            try {
                this.b = Integer.parseInt(aa0.a("lfp_not_fully_charged_mileage", "1500"));
            } catch (Exception e2) {
                StringBuilder a2 = jg.a("LFP_NOT_FULLY_CHARGED_MILEAGE Configuration error");
                a2.append(e2.getMessage());
                Log.e("LfpBatteryNotFullyChargedHintTask", a2.toString());
            }
            StringBuilder a3 = jg.a("checkFullCharged() mIntervalDay = ");
            a3.append(this.a);
            a3.append(" , mIntervalMileage = ");
            a3.append(this.b);
            Log.i("LfpBatteryNotFullyChargedHintTask", a3.toString());
            if (fa0.b.a.j() && !fa0.b.a.i()) {
                Log.w("LfpBatteryNotFullyChargedHintTask", "checkFullCharged() LFP is unFull charged fist！");
                c();
                fa0.b.a.c(true);
            } else if (!fa0.b.a.i() && fa0.b.a.e() != 0) {
                Log.w("LfpBatteryNotFullyChargedHintTask", "checkFullCharged() LFP is Full charged fist！");
                fa0.b.a.c(true);
            } else if (fa0.b.a.e() == 0 && fa0.b.a.j()) {
                Log.w("LfpBatteryNotFullyChargedHintTask", "checkFullCharged() LFP is full charged never !");
                c();
            } else if (fa0.b.a.e() != 0) {
                float a4 = x90.a(-1.0f);
                float f = fa0.b.a.a.getFloat("lfp_full_charged_mileage", -1.0f);
                long e3 = fa0.b.a.e();
                boolean z = a4 - f >= ((float) this.b);
                long currentTimeMillis = System.currentTimeMillis();
                long j = (currentTimeMillis - e3) / 86400000;
                boolean z2 = j >= ((long) this.a);
                Log.i("LfpBatteryNotFullyChargedHintTask", "currentMileage = " + a4 + "currentTime = " + currentTimeMillis + " , isOverMileage = " + z + " , isOverDate = " + z2 + ", overDate = " + j + ", fullChargedMileage =" + f + ", fullChargedTime = " + e3 + ", mIntervalDay =" + this.a + ", mIntervalMileage = " + this.b);
                if (z || z2) {
                    c();
                }
            }
        }
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onStateChanged(q70 q70Var) {
        int i = q70Var.a;
        if (i == 2 || i != 3) {
            return;
        }
        this.d = ah0.a(0L, 4L, 1L, ActivityThread.currentApplication().getResources().getInteger(R.integer.lft_bms_st_retry_cycle), TimeUnit.MILLISECONDS).a(new rh0() { // from class: v70
            @Override // defpackage.rh0
            public final void accept(Object obj) {
                f80.this.a((Long) obj);
            }
        }).b(new th0() { // from class: t70
            @Override // defpackage.th0
            public final boolean test(Object obj) {
                return f80.this.b((Long) obj);
            }
        }).a(hh0.a()).b(new rh0() { // from class: u70
            @Override // defpackage.rh0
            public final void accept(Object obj) {
                f80.this.c((Long) obj);
            }
        });
    }

    @Override // defpackage.i80
    public void start() {
        jb0.a(1, new Runnable() { // from class: s70
            @Override // java.lang.Runnable
            public final void run() {
                f80.this.b();
            }
        }, 500L);
    }

    @Override // defpackage.i80
    public void stop() {
        iv.e(this);
        z90.a(this.d);
    }

    public /* synthetic */ boolean b(Long l) {
        return this.c;
    }

    public /* synthetic */ void a(Long l) {
        this.c = x90.d().a(false);
    }

    public final void a(int i, String str) {
        if (a70.k()) {
            uu uuVar = new uu();
            uuVar.a(IpcConfig.IPCKey.STRING_MSG, str);
            a(i, uuVar.toString(), "com.xiaopeng.aiassistant");
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString(IpcConfig.IPCKey.STRING_MSG, str);
        z90.a(i, bundle, IpcConfig.App.MESSAGE_CENTER);
    }

    public final void a(int i, String str, String str2) {
        Uri.Builder builder = new Uri.Builder();
        try {
            ApiRouter.route(builder.authority(str2 + ".IpcRouterService").path("onReceiverData").appendQueryParameter("id", String.valueOf(i)).appendQueryParameter("bundle", str).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public /* synthetic */ void c(Long l) {
        Log.i("LfpBatteryNotFullyChargedHintTask", "saveChargeCompleteValue()");
        try {
            if (x90.d().a(false)) {
                fa0.b.a.d(false);
                long currentTimeMillis = System.currentTimeMillis();
                fa0 fa0Var = fa0.b.a;
                fa0Var.a.edit().putLong("lfp_full_charged_time", System.currentTimeMillis()).apply();
                float a = x90.a(-1.0f);
                if (a != -1.0f) {
                    fa0.b.a.a.edit().putFloat("lfp_full_charged_mileage", a).apply();
                }
                a();
                Log.i("LfpBatteryNotFullyChargedHintTask", "lfp is full charged. totalMileage = " + a + " , time = " + currentTimeMillis);
                return;
            }
            fa0.b.a.d(true);
        } catch (Exception e) {
            StringBuilder a2 = jg.a("saveChargeCompleteValue error :");
            a2.append(e.getMessage());
            Log.e("LfpBatteryNotFullyChargedHintTask", a2.toString());
        }
    }
}
