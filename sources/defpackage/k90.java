package defpackage;

import android.content.Context;
import android.util.Log;
import java.util.List;
import java.util.concurrent.Callable;
/* compiled from: StatisticsRepositoryImpl.java */
/* renamed from: k90  reason: default package */
/* loaded from: classes.dex */
public class k90 {
    public final e90 a;
    public final b90 b;
    public final d90 c;

    public k90(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.a = new e90(applicationContext);
        this.b = new b90(applicationContext);
        this.c = new d90(applicationContext);
    }

    public void a(j90 j90Var) {
        StringBuilder a = jg.a("addDischargeData size");
        a.append(this.b.c().size());
        Log.i("DataRepository", a.toString());
        this.b.a((b90) j90Var);
        Log.i("DataRepository", "after addChargeData size" + this.b.c().size());
    }

    public void b(j90 j90Var) {
        StringBuilder a = jg.a("addDischargeData size");
        a.append(this.a.c().size());
        Log.i("DataRepository", a.toString());
        this.a.a((e90) j90Var);
        Log.i("DataRepository", "after addDischargeData size" + this.a.c().size());
    }

    public eh0<List<j90>> c() {
        StringBuilder a = jg.a("getAllChargeData size = ");
        a.append(this.b.c().size());
        Log.i("DataRepository", a.toString());
        final b90 b90Var = this.b;
        b90Var.getClass();
        return eh0.a(new Callable() { // from class: z80
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return b90.this.c();
            }
        });
    }

    public eh0<List<Float>> d() {
        final d90 d90Var = this.c;
        d90Var.getClass();
        return eh0.a(new Callable() { // from class: y80
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return d90.this.c();
            }
        });
    }

    public eh0<List<j90>> e() {
        StringBuilder a = jg.a("getAllDischargeData size");
        a.append(this.a.c().size());
        Log.i("DataRepository", a.toString());
        final e90 e90Var = this.a;
        e90Var.getClass();
        return eh0.a(new Callable() { // from class: q80
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return e90.this.c();
            }
        });
    }

    public void a() {
        StringBuilder a = jg.a("clearChargeData size");
        a.append(this.b.c().size());
        Log.i("DataRepository", a.toString());
        this.b.b();
    }

    public void b() {
        StringBuilder a = jg.a("clearDischargeData size");
        a.append(this.a.c().size());
        Log.i("DataRepository", a.toString());
        this.a.b();
    }
}
