package defpackage;

import android.util.Log;
import defpackage.fa0;
import java.util.concurrent.TimeUnit;
/* compiled from: ChargeCompletePresenter.java */
/* renamed from: t20  reason: default package */
/* loaded from: classes.dex */
public class t20 extends i10<u20> {
    public kh0 b;

    /* JADX WARN: Type inference failed for: r10v1, types: [u20, V] */
    @Override // defpackage.i10
    public void a(u20 u20Var) {
        String str;
        String str2;
        this.a = u20Var;
        this.b = ah0.a(1L, TimeUnit.SECONDS).b(new sh0() { // from class: r20
            @Override // defpackage.sh0
            public final Object apply(Object obj) {
                Long l = (Long) obj;
                return new v60();
            }
        }).a(hh0.a()).b(new rh0() { // from class: q20
            @Override // defpackage.rh0
            public final void accept(Object obj) {
                t20.this.a((Integer) obj);
            }
        });
        long j = fa0.b.a.a.getLong("chargeCompleteTime", 0L);
        long j2 = fa0.b.a.a.getLong("chargeStartTime", 0L);
        if (0 != j && 0 != j2) {
            ((u20) this.a).b(j2, j);
            long millis = TimeUnit.SECONDS.toMillis(59L) + (j - j2);
            long hours = TimeUnit.MILLISECONDS.toHours(millis);
            long[] jArr = {hours, TimeUnit.MILLISECONDS.toMinutes(millis - TimeUnit.HOURS.toMillis(hours))};
            ((u20) this.a).a(jArr[0], jArr[1]);
        } else {
            Log.e("ChargeCompletePresenter", "Invalid charging started or finished timestamp.");
        }
        int c = x90.c(-1);
        if (c == 0) {
            str = "charging_started_mileage_nedc";
            str2 = "charging_finished_mileage_nedc";
        } else if (c == 1) {
            str = "charging_started_mileage_wltp";
            str2 = "charging_finished_mileage_wltp";
        } else {
            str = "charging_started_mileage_cltc";
            str2 = "charging_finished_mileage_cltc";
        }
        int i = fa0.b.a.a.getInt(str, -1);
        int i2 = fa0.b.a.a.getInt(str2, -1);
        int i3 = fa0.b.a.a.getInt("completeMileage", 0);
        if ((!a70.c() || i3 >= 0) && i >= 0 && i2 >= 0 && i != 1023 && i2 != 1023) {
            int i4 = fa0.b.a.a.getInt("startMileage", 0);
            int i5 = i3 - i4;
            int i6 = i2 - i;
            if (a70.c()) {
                ((u20) this.a).c(i5);
                Log.i("ChargeCompletePresenter", "updateChargeMileage complete = " + i3 + " start = " + i4);
                return;
            }
            StringBuilder a = jg.a("updateChargeMileage() called: start = [", i, "], end = [", i2, "], increased mileage = [");
            a.append(i6);
            a.append("]");
            Log.i("ChargeCompletePresenter", a.toString());
            ((u20) this.a).c(i6);
            return;
        }
        Log.e("ChargeCompletePresenter", "updateChargeMileage stop, can not get complete mileage! chargeCompleteMileage = " + i3);
        ((u20) this.a).c(0);
    }

    public /* synthetic */ void a(Integer num) {
        u20 u20Var = (u20) this.a;
        boolean z = false;
        if (num.intValue() == 1) {
            if (x90.f() == 1) {
                z = true;
            }
        }
        u20Var.i(z);
    }

    @Override // defpackage.i10
    public void a() {
        this.b.a();
        this.a = null;
    }
}
