package defpackage;

import android.content.Context;
import android.util.Log;
import defpackage.gy;
import java.util.Map;
/* compiled from: CarBcmControllerCompat.java */
/* renamed from: bz  reason: default package */
/* loaded from: classes.dex */
public class bz extends az {
    public ob0 f;
    public boolean g;

    /* compiled from: CarBcmControllerCompat.java */
    /* renamed from: bz$a */
    /* loaded from: classes.dex */
    public class a extends ob0 {
        public a() {
        }

        @Override // defpackage.ob0
        public void a(boolean z, sb0 sb0Var) {
            if (a70.i() && y90.b()) {
                bz.this.a(!z, sb0Var);
            } else {
                bz.this.a(z, sb0Var);
            }
        }
    }

    public bz(Context context) {
        super(context);
    }

    @Override // defpackage.az, defpackage.dz
    public void a(Map<Integer, d00<?>> map) {
        super.a(map);
        if (a70.k()) {
            this.g = true;
            if (a70.i() && y90.b()) {
                a(false, rb0.a(this.d).a(true));
            } else {
                a(true, rb0.a(this.d).a(true));
                a(false, rb0.a(this.d).a(false));
            }
            this.f = new a();
            rb0.a(this.d).a(this.f);
        }
    }

    @Override // defpackage.az
    public boolean b(boolean z) {
        if (!this.g) {
            return super.b(z);
        }
        if (a70.i() && y90.b()) {
            return rb0.a(this.d).n(!z);
        }
        return rb0.a(this.d).n(z);
    }

    @Override // defpackage.dz
    public void c() {
        super.c();
        if (this.f != null) {
            rb0.a(this.d).b(this.f);
        }
    }

    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Integer] */
    public final void a(boolean z, sb0 sb0Var) {
        int i;
        zy cVar;
        Log.d("CarBcmControllerCompat", "handleChargePortStatus: " + z + " " + sb0Var.toString());
        int ordinal = sb0Var.ordinal();
        if (ordinal != 0) {
            int i2 = 1;
            if (ordinal != 1) {
                i2 = 2;
                if (ordinal != 2) {
                    i2 = 3;
                    if (ordinal != 3) {
                        i = -1;
                    }
                }
            }
            i = i2;
        } else {
            i = 0;
        }
        if (z) {
            cVar = new gy.b();
        } else {
            cVar = new gy.c();
        }
        cVar.a = Integer.valueOf(i);
        iv.c(cVar);
    }
}
