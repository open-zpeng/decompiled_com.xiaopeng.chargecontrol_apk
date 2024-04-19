package defpackage;

import defpackage.nf;
/* compiled from: ViewInfoStore.java */
/* renamed from: sf  reason: default package */
/* loaded from: classes.dex */
public class sf {
    public final f5<nf.c0, a> a = new f5<>();
    public final c5<nf.c0> b = new c5<>();

    /* compiled from: ViewInfoStore.java */
    /* renamed from: sf$b */
    /* loaded from: classes.dex */
    public interface b {
    }

    public void a() {
        this.a.clear();
        this.b.a();
    }

    public void b(nf.c0 c0Var, nf.k.c cVar) {
        a orDefault = this.a.getOrDefault(c0Var, null);
        if (orDefault == null) {
            orDefault = a.a();
            this.a.put(c0Var, orDefault);
        }
        orDefault.b = cVar;
        orDefault.a |= 4;
    }

    public void c(nf.c0 c0Var) {
        a orDefault = this.a.getOrDefault(c0Var, null);
        if (orDefault == null) {
            return;
        }
        orDefault.a &= -2;
    }

    public void d(nf.c0 c0Var) {
        c5<nf.c0> c5Var = this.b;
        if (c5Var.c) {
            c5Var.b();
        }
        int i = c5Var.f - 1;
        while (true) {
            if (i < 0) {
                break;
            }
            c5<nf.c0> c5Var2 = this.b;
            if (c5Var2.c) {
                c5Var2.b();
            }
            if (c0Var == c5Var2.e[i]) {
                c5<nf.c0> c5Var3 = this.b;
                Object[] objArr = c5Var3.e;
                Object obj = objArr[i];
                Object obj2 = c5.g;
                if (obj != obj2) {
                    objArr[i] = obj2;
                    c5Var3.c = true;
                }
            } else {
                i--;
            }
        }
        a remove = this.a.remove(c0Var);
        if (remove != null) {
            a.a(remove);
        }
    }

    /* compiled from: ViewInfoStore.java */
    /* renamed from: sf$a */
    /* loaded from: classes.dex */
    public static class a {
        public static c9<a> d = new d9(20);
        public int a;
        public nf.k.c b;
        public nf.k.c c;

        public static a a() {
            a a = d.a();
            return a == null ? new a() : a;
        }

        public static void a(a aVar) {
            aVar.a = 0;
            aVar.b = null;
            aVar.c = null;
            d.a(aVar);
        }
    }

    public final nf.k.c a(nf.c0 c0Var, int i) {
        a e;
        nf.k.c cVar;
        int a2 = this.a.a(c0Var);
        if (a2 >= 0 && (e = this.a.e(a2)) != null) {
            int i2 = e.a;
            if ((i2 & i) != 0) {
                e.a = (~i) & i2;
                if (i == 4) {
                    cVar = e.b;
                } else if (i == 8) {
                    cVar = e.c;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((e.a & 12) == 0) {
                    this.a.d(a2);
                    a.a(e);
                }
                return cVar;
            }
        }
        return null;
    }

    public boolean b(nf.c0 c0Var) {
        a orDefault = this.a.getOrDefault(c0Var, null);
        return (orDefault == null || (orDefault.a & 1) == 0) ? false : true;
    }

    public void b() {
        do {
        } while (a.d.a() != null);
    }

    public void a(nf.c0 c0Var, nf.k.c cVar) {
        a orDefault = this.a.getOrDefault(c0Var, null);
        if (orDefault == null) {
            orDefault = a.a();
            this.a.put(c0Var, orDefault);
        }
        orDefault.c = cVar;
        orDefault.a |= 8;
    }

    public void a(nf.c0 c0Var) {
        a orDefault = this.a.getOrDefault(c0Var, null);
        if (orDefault == null) {
            orDefault = a.a();
            this.a.put(c0Var, orDefault);
        }
        orDefault.a |= 1;
    }
}
