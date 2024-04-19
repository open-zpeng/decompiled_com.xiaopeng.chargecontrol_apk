package defpackage;

import android.util.Log;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog;
import com.xiaopeng.libconfig.ipc.event.CarEventConfig;
import defpackage.fa0;
import defpackage.my;
import defpackage.r70;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.ThreadMode;
/* compiled from: UploadChargeInfoTask.java */
/* renamed from: k80  reason: default package */
/* loaded from: classes.dex */
public class k80 implements i80 {
    public kh0 a;
    public kh0 b;
    public int c;

    public static /* synthetic */ boolean a(Long l) {
        return 2 != r70.b.a.b();
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onChargeGunStatusChanged(my.j jVar) {
        if (((Integer) jVar.a).intValue() == 0) {
            fa0.b.a.a.edit().putBoolean("start2chargeMsg", true).apply();
        }
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onStateChanged(q70 q70Var) {
        int o;
        int p;
        int i = q70Var.a;
        final int i2 = this.c;
        if (2 == i2 && 3 != i) {
            if (x90.v()) {
                Log.w("UploadChargeInfoTask", "还没拔枪  开始计时器 倒数60s 如果不在充电中发送充电中止消息");
                z90.a(this.a);
                this.a = ah0.a(60L, TimeUnit.SECONDS).a(new th0() { // from class: b80
                    @Override // defpackage.th0
                    public final boolean test(Object obj) {
                        return k80.a((Long) obj);
                    }
                }).a(hh0.a()).b(new rh0() { // from class: z70
                    @Override // defpackage.rh0
                    public final void accept(Object obj) {
                        k80.this.a(i2, (Long) obj);
                    }
                });
            } else {
                a(i2);
            }
        }
        int i3 = q70Var.a;
        if (i3 == 2) {
            final int p2 = x90.p();
            if (p2 != -1) {
                z90.a(this.b);
                this.b = ah0.a(60L, TimeUnit.SECONDS).a(new th0() { // from class: a80
                    @Override // defpackage.th0
                    public final boolean test(Object obj) {
                        boolean z;
                        Long l = (Long) obj;
                        z = fa0.b.a.a.getBoolean("start2chargeMsg", true);
                        return z;
                    }
                }).a(hh0.a()).b(new rh0() { // from class: c80
                    @Override // defpackage.rh0
                    public final void accept(Object obj) {
                        k80.this.b(p2, (Long) obj);
                    }
                });
            }
        } else if (i3 == 3 && (o = x90.o()) != -1 && (p = x90.p()) != -1) {
            a(CarEventConfig.EVENT_CHARGE_COMPLETE, o, p, -1);
        }
        this.c = q70Var.a;
    }

    @Override // defpackage.i80
    public void start() {
        this.c = r70.b.a.b();
        iv.d(this);
    }

    @Override // defpackage.i80
    public void stop() {
        iv.e(this);
        z90.a(this.b);
        z90.a(this.a);
    }

    public /* synthetic */ void a(int i, Long l) {
        a(i);
    }

    public /* synthetic */ void b(int i, Long l) {
        int o = x90.o();
        if (o == -1) {
            return;
        }
        int e = x90.e();
        if (e == -1) {
            e = 0;
        }
        a(CarEventConfig.EVENT_CHARGE_BEGIN, o, i, e);
        fa0.b.a.a.edit().putBoolean("start2chargeMsg", false).apply();
        Log.d("UploadChargeInfoTask", "发送开始充电消息到服务器 里程 = " + o + " 剩余时间 = " + e);
    }

    public final void a(int i) {
        int p;
        if (i != 2) {
            Log.w("UploadChargeInfoTask", "这次充电循环里已经记录过充电完成 不再发送充电中止消息");
            return;
        }
        int o = x90.o();
        if (o == -1 || (p = x90.p()) == -1) {
            return;
        }
        int k = ((oz) x90.s()).k(-1);
        a(k == 4 || k == 2 ? "CHARGE_EXCEPTION_PILE_ERROR" : CarEventConfig.EVENT_CHARGE_ERROR, o, p, -1);
    }

    public final void a(String str, int i, int i2, int i3) {
        Log.i("UploadChargeInfoTask", "upload() called with: type = [" + str + "], currentMileage = [" + i + "], currentSOC = [" + i2 + "], completeTime = [" + i3 + "]");
        IDataLog iDataLog = (IDataLog) Module.get(oa0.class).get(IDataLog.class);
        if (iDataLog == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{\"availableDrivingDistance\":");
        sb.append(i);
        sb.append(",\"batterySoc\":");
        sb.append(i2);
        if (i3 != -1) {
            sb.append(",\"timeToCompleteCharge\":");
            sb.append(i3);
        }
        sb.append("}");
        Log.i("UploadChargeInfoTask", "getUploadDataString = " + sb.toString());
        iDataLog.sendStatData(str, sb.toString());
    }
}
