package defpackage;

import android.content.Context;
import defpackage.d00;
import defpackage.ly;
import java.util.Map;
/* compiled from: CarTBoxControllerCompat.java */
/* renamed from: nz  reason: default package */
/* loaded from: classes.dex */
public class nz extends mz {
    public nz(Context context) {
        super(context);
    }

    @Override // defpackage.mz, defpackage.dz
    public void a(Map<Integer, d00<?>> map) {
        super.a(map);
        d00.b b = d00.b(new ly.b());
        b.d = true;
        map.put(557912099, b.a());
        d00.b b2 = d00.b(new ly.a());
        b2.d = true;
        map.put(557912138, b2.a());
    }

    public boolean b(boolean z) {
        boolean z2;
        try {
            if (!a70.c() && !a70.d()) {
                z2 = false;
                if (!z && z2) {
                    this.c.startSlowCharge();
                } else {
                    this.c.startCharge();
                }
                return true;
            }
            z2 = true;
            if (!z) {
            }
            this.c.startCharge();
            return true;
        } catch (Exception e) {
            StringBuilder a = jg.a("startCharge: ");
            a.append(e.getMessage());
            gb0.b("TBoxController", a.toString());
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0014  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0026 A[Catch: Exception -> 0x002e, TRY_LEAVE, TryCatch #0 {Exception -> 0x002e, blocks: (B:3:0x0001, B:5:0x0008, B:12:0x0016, B:13:0x001e, B:14:0x0026), top: B:19:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean c(boolean r4) {
        /*
            r3 = this;
            r0 = 0
            boolean r1 = defpackage.a70.c()     // Catch: java.lang.Exception -> L2e
            r2 = 1
            if (r1 != 0) goto L11
            boolean r1 = defpackage.a70.d()     // Catch: java.lang.Exception -> L2e
            if (r1 == 0) goto Lf
            goto L11
        Lf:
            r1 = r0
            goto L12
        L11:
            r1 = r2
        L12:
            if (r1 == 0) goto L26
            if (r4 == 0) goto L1e
            T extends android.car.hardware.CarEcuManager r4 = r3.c     // Catch: java.lang.Exception -> L2e
            android.car.hardware.tbox.CarTboxManager r4 = (android.car.hardware.tbox.CarTboxManager) r4     // Catch: java.lang.Exception -> L2e
            r4.stopSlowCharge()     // Catch: java.lang.Exception -> L2e
            goto L2d
        L1e:
            T extends android.car.hardware.CarEcuManager r4 = r3.c     // Catch: java.lang.Exception -> L2e
            android.car.hardware.tbox.CarTboxManager r4 = (android.car.hardware.tbox.CarTboxManager) r4     // Catch: java.lang.Exception -> L2e
            r4.stopFastCharge()     // Catch: java.lang.Exception -> L2e
            goto L2d
        L26:
            T extends android.car.hardware.CarEcuManager r4 = r3.c     // Catch: java.lang.Exception -> L2e
            android.car.hardware.tbox.CarTboxManager r4 = (android.car.hardware.tbox.CarTboxManager) r4     // Catch: java.lang.Exception -> L2e
            r4.stopCharge()     // Catch: java.lang.Exception -> L2e
        L2d:
            return r2
        L2e:
            r4 = move-exception
            java.lang.String r1 = "stopCharge: "
            java.lang.StringBuilder r1 = defpackage.jg.a(r1)
            java.lang.String r4 = r4.getMessage()
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            java.lang.String r1 = "TBoxController"
            defpackage.gb0.b(r1, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.nz.c(boolean):boolean");
    }
}
