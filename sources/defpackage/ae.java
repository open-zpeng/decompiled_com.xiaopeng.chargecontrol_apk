package defpackage;

import android.annotation.SuppressLint;
import defpackage.vd;
import defpackage.x4;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
/* compiled from: LifecycleRegistry.java */
/* renamed from: ae  reason: default package */
/* loaded from: classes.dex */
public class ae extends vd {
    public final WeakReference<zd> c;
    public w4<yd, a> a = new w4<>();
    public int d = 0;
    public boolean e = false;
    public boolean f = false;
    public ArrayList<vd.b> g = new ArrayList<>();
    public vd.b b = vd.b.INITIALIZED;
    public final boolean h = true;

    /* compiled from: LifecycleRegistry.java */
    /* renamed from: ae$a */
    /* loaded from: classes.dex */
    public static class a {
        public vd.b a;
        public xd b;

        public a(yd ydVar, vd.b bVar) {
            this.b = ce.a(ydVar);
            this.a = bVar;
        }

        public void a(zd zdVar, vd.a aVar) {
            vd.b a = aVar.a();
            this.a = ae.a(this.a, a);
            this.b.a(zdVar, aVar);
            this.a = a;
        }
    }

    public ae(zd zdVar) {
        this.c = new WeakReference<>(zdVar);
    }

    public void a(vd.a aVar) {
        a("handleLifecycleEvent");
        a(aVar.a());
    }

    public void b(vd.b bVar) {
        a("setCurrentState");
        a(bVar);
    }

    public final vd.b c(yd ydVar) {
        w4<yd, a> w4Var = this.a;
        vd.b bVar = null;
        x4.c<yd, a> cVar = w4Var.g.containsKey(ydVar) ? w4Var.g.get(ydVar).f : null;
        vd.b bVar2 = cVar != null ? cVar.getValue().a : null;
        if (!this.g.isEmpty()) {
            ArrayList<vd.b> arrayList = this.g;
            bVar = arrayList.get(arrayList.size() - 1);
        }
        return a(a(this.b, bVar2), bVar);
    }

    public final void a(vd.b bVar) {
        if (this.b == bVar) {
            return;
        }
        this.b = bVar;
        if (!this.e && this.d == 0) {
            this.e = true;
            b();
            this.e = false;
            return;
        }
        this.f = true;
    }

    @Override // defpackage.vd
    public void b(yd ydVar) {
        a("removeObserver");
        this.a.remove(ydVar);
    }

    public final void b() {
        zd zdVar = this.c.get();
        if (zdVar == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
        }
        while (true) {
            w4<yd, a> w4Var = this.a;
            boolean z = true;
            if (w4Var.f != 0) {
                vd.b bVar = w4Var.c.getValue().a;
                vd.b bVar2 = this.a.d.getValue().a;
                if (bVar != bVar2 || this.b != bVar2) {
                    z = false;
                }
            }
            if (!z) {
                this.f = false;
                if (this.b.compareTo(this.a.c.getValue().a) < 0) {
                    w4<yd, a> w4Var2 = this.a;
                    x4.b bVar3 = new x4.b(w4Var2.d, w4Var2.c);
                    w4Var2.e.put(bVar3, false);
                    while (bVar3.hasNext() && !this.f) {
                        Map.Entry next = bVar3.next();
                        a aVar = (a) next.getValue();
                        while (aVar.a.compareTo(this.b) > 0 && !this.f && this.a.contains((yd) next.getKey())) {
                            vd.a a2 = vd.a.a(aVar.a);
                            if (a2 != null) {
                                this.g.add(a2.a());
                                aVar.a(zdVar, a2);
                                a();
                            } else {
                                StringBuilder a3 = jg.a("no event down from ");
                                a3.append(aVar.a);
                                throw new IllegalStateException(a3.toString());
                            }
                        }
                    }
                }
                x4.c<yd, a> cVar = this.a.d;
                if (!this.f && cVar != null && this.b.compareTo(cVar.getValue().a) > 0) {
                    x4<yd, a>.d a4 = this.a.a();
                    while (a4.hasNext() && !this.f) {
                        Map.Entry next2 = a4.next();
                        a aVar2 = (a) next2.getValue();
                        while (aVar2.a.compareTo(this.b) < 0 && !this.f && this.a.contains((yd) next2.getKey())) {
                            this.g.add(aVar2.a);
                            vd.a b = vd.a.b(aVar2.a);
                            if (b != null) {
                                aVar2.a(zdVar, b);
                                a();
                            } else {
                                StringBuilder a5 = jg.a("no event up from ");
                                a5.append(aVar2.a);
                                throw new IllegalStateException(a5.toString());
                            }
                        }
                    }
                }
            } else {
                this.f = false;
                return;
            }
        }
    }

    @Override // defpackage.vd
    public void a(yd ydVar) {
        zd zdVar;
        a("addObserver");
        vd.b bVar = this.b;
        vd.b bVar2 = vd.b.DESTROYED;
        if (bVar != bVar2) {
            bVar2 = vd.b.INITIALIZED;
        }
        a aVar = new a(ydVar, bVar2);
        if (this.a.b(ydVar, aVar) == null && (zdVar = this.c.get()) != null) {
            boolean z = this.d != 0 || this.e;
            vd.b c = c(ydVar);
            this.d++;
            while (aVar.a.compareTo(c) < 0 && this.a.g.containsKey(ydVar)) {
                this.g.add(aVar.a);
                vd.a b = vd.a.b(aVar.a);
                if (b != null) {
                    aVar.a(zdVar, b);
                    a();
                    c = c(ydVar);
                } else {
                    StringBuilder a2 = jg.a("no event up from ");
                    a2.append(aVar.a);
                    throw new IllegalStateException(a2.toString());
                }
            }
            if (!z) {
                b();
            }
            this.d--;
        }
    }

    public final void a() {
        ArrayList<vd.b> arrayList = this.g;
        arrayList.remove(arrayList.size() - 1);
    }

    @SuppressLint({"RestrictedApi"})
    public final void a(String str) {
        if (this.h && !t4.b().a()) {
            throw new IllegalStateException(jg.b("Method ", str, " must be called on the main thread"));
        }
    }

    public static vd.b a(vd.b bVar, vd.b bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }
}
