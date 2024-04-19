package defpackage;

import android.app.ActivityThread;
import com.xiaopeng.chargecontrol.R;
import com.xiaopeng.speech.vui.utils.LogUtils;
import defpackage.my;
import org.greenrobot.eventbus.ThreadMode;
/* compiled from: BatteryKeepTempListenerTask.java */
/* renamed from: d80  reason: default package */
/* loaded from: classes.dex */
public class d80 implements i80 {
    public ld0 a;

    @tl0(threadMode = ThreadMode.MAIN)
    public void onBatteryKeepTempModeChanged(my.d dVar) {
        StringBuilder a = jg.a("onBatteryKeepTempModeChanged event=");
        a.append(dVar.a);
        LogUtils.i("BatteryKeepTempListenerTask", a.toString());
        switch (((Integer) dVar.a).intValue()) {
            case 1:
                z90.d(R.string.keep_temp_toast_started);
                return;
            case 2:
                e10 e10Var = new e10(ActivityThread.currentApplication(), u60.XDialogView);
                e10Var.d(R.string.keep_temp_done_dialog_title);
                e10Var.g(R.string.keep_temp_done_dialog_content);
                e10Var.b(R.string.know_it);
                ld0 ld0Var = this.a;
                if (ld0Var != null) {
                    ld0Var.a();
                }
                this.a = e10Var;
                e10Var.f(2008);
                e10Var.e();
                return;
            case 3:
                z90.d(R.string.keep_temp_toast_disable_reason_no_needs);
                return;
            case 4:
                z90.d(R.string.keep_temp_toast_disable_reason_charge_pile);
                return;
            case 5:
            case 6:
                e10 e10Var2 = new e10(ActivityThread.currentApplication(), u60.XDialogView);
                e10Var2.d(R.string.keep_temp_start_failed_dialog_title);
                e10Var2.g(R.string.keep_temp_start_failed_dialog_content);
                e10Var2.b(R.string.know_it);
                ld0 ld0Var2 = this.a;
                if (ld0Var2 != null) {
                    ld0Var2.a();
                }
                this.a = e10Var2;
                e10Var2.f(2008);
                e10Var2.e();
                return;
            case 7:
                z90.d(R.string.keep_temp_toast_stopped);
                return;
            default:
                return;
        }
    }

    @tl0(threadMode = ThreadMode.MAIN)
    public void onIgStatusChanged(qy qyVar) {
        if (1 == qyVar.a && ((oz) x90.s()).c(0) == 1) {
            z90.d(R.string.keep_temp_toast_started);
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
