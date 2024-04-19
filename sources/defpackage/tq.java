package defpackage;

import android.util.Log;
import defpackage.wq;
import java.util.List;
/* compiled from: FactoryPools.java */
/* renamed from: tq  reason: default package */
/* loaded from: classes.dex */
public final class tq {
    public static final e<Object> a = new a();

    /* compiled from: FactoryPools.java */
    /* renamed from: tq$a */
    /* loaded from: classes.dex */
    public class a implements e<Object> {
        @Override // defpackage.tq.e
        public void a(Object obj) {
        }
    }

    /* compiled from: FactoryPools.java */
    /* renamed from: tq$b */
    /* loaded from: classes.dex */
    public interface b<T> {
        T a();
    }

    /* compiled from: FactoryPools.java */
    /* renamed from: tq$d */
    /* loaded from: classes.dex */
    public interface d {
        wq e();
    }

    /* compiled from: FactoryPools.java */
    /* renamed from: tq$e */
    /* loaded from: classes.dex */
    public interface e<T> {
        void a(T t);
    }

    public static <T extends d> c9<T> a(int i, b<T> bVar) {
        return new c(new e9(i), bVar, a);
    }

    public static <T> c9<List<T>> a() {
        return a(new e9(20), new uq(), new vq());
    }

    public static <T> c9<T> a(c9<T> c9Var, b<T> bVar, e<T> eVar) {
        return new c(c9Var, bVar, eVar);
    }

    /* compiled from: FactoryPools.java */
    /* renamed from: tq$c */
    /* loaded from: classes.dex */
    public static final class c<T> implements c9<T> {
        public final b<T> a;
        public final e<T> b;
        public final c9<T> c;

        public c(c9<T> c9Var, b<T> bVar, e<T> eVar) {
            this.c = c9Var;
            this.a = bVar;
            this.b = eVar;
        }

        @Override // defpackage.c9
        public T a() {
            T a = this.c.a();
            if (a == null) {
                a = this.a.a();
                if (Log.isLoggable("FactoryPools", 2)) {
                    StringBuilder a2 = jg.a("Created new ");
                    a2.append(a.getClass());
                    Log.v("FactoryPools", a2.toString());
                }
            }
            if (a instanceof d) {
                ((wq.b) ((d) a).e()).a = false;
            }
            return a;
        }

        @Override // defpackage.c9
        public boolean a(T t) {
            if (t instanceof d) {
                ((wq.b) ((d) t).e()).a = true;
            }
            this.b.a(t);
            return this.c.a(t);
        }
    }
}
