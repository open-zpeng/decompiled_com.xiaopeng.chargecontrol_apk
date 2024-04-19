package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: ChainRun.java */
/* renamed from: d6  reason: default package */
/* loaded from: classes.dex */
public class d6 extends p6 {
    public ArrayList<p6> k;
    public int l;

    public d6(t5 t5Var, int i) {
        super(t5Var);
        t5 t5Var2;
        int i2;
        this.k = new ArrayList<>();
        this.f = i;
        t5 t5Var3 = this.b;
        t5 d = t5Var3.d(this.f);
        while (true) {
            t5 t5Var4 = d;
            t5Var2 = t5Var3;
            t5Var3 = t5Var4;
            if (t5Var3 == null) {
                break;
            }
            d = t5Var3.d(this.f);
        }
        this.b = t5Var2;
        this.k.add(t5Var2.e(this.f));
        t5 c = t5Var2.c(this.f);
        while (c != null) {
            this.k.add(c.e(this.f));
            c = c.c(this.f);
        }
        Iterator<p6> it = this.k.iterator();
        while (it.hasNext()) {
            p6 next = it.next();
            int i3 = this.f;
            if (i3 == 0) {
                next.b.b = this;
            } else if (i3 == 1) {
                next.b.c = this;
            }
        }
        if ((this.f == 0 && ((u5) this.b.W).z0) && this.k.size() > 1) {
            ArrayList<p6> arrayList = this.k;
            this.b = arrayList.get(arrayList.size() - 1).b;
        }
        if (this.f == 0) {
            i2 = this.b.m0;
        } else {
            i2 = this.b.n0;
        }
        this.l = i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:266:0x03c9, code lost:
        r2 = r2 - r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00c3, code lost:
        if (r3.e.j != false) goto L66;
     */
    @Override // defpackage.p6, defpackage.e6
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(defpackage.e6 r24) {
        /*
            Method dump skipped, instructions count: 1008
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.d6.a(e6):void");
    }

    @Override // defpackage.p6
    public void b() {
        for (int i = 0; i < this.k.size(); i++) {
            this.k.get(i).b();
        }
    }

    @Override // defpackage.p6
    public void c() {
        this.c = null;
        Iterator<p6> it = this.k.iterator();
        while (it.hasNext()) {
            it.next().c();
        }
    }

    @Override // defpackage.p6
    public long d() {
        int size = this.k.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            p6 p6Var = this.k.get(i);
            j = p6Var.i.f + p6Var.d() + j + p6Var.h.f;
        }
        return j;
    }

    @Override // defpackage.p6
    public boolean e() {
        int size = this.k.size();
        for (int i = 0; i < size; i++) {
            if (!this.k.get(i).e()) {
                return false;
            }
        }
        return true;
    }

    public final t5 f() {
        for (int i = 0; i < this.k.size(); i++) {
            t5 t5Var = this.k.get(i).b;
            if (t5Var.j0 != 8) {
                return t5Var;
            }
        }
        return null;
    }

    public final t5 g() {
        for (int size = this.k.size() - 1; size >= 0; size--) {
            t5 t5Var = this.k.get(size).b;
            if (t5Var.j0 != 8) {
                return t5Var;
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ChainRun ");
        sb.append(this.f == 0 ? "horizontal : " : "vertical : ");
        Iterator<p6> it = this.k.iterator();
        while (it.hasNext()) {
            sb.append("<");
            sb.append(it.next());
            sb.append("> ");
        }
        return sb.toString();
    }

    @Override // defpackage.p6
    public void a() {
        Iterator<p6> it = this.k.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        int size = this.k.size();
        if (size < 1) {
            return;
        }
        t5 t5Var = this.k.get(0).b;
        t5 t5Var2 = this.k.get(size - 1).b;
        if (this.f == 0) {
            s5 s5Var = t5Var.K;
            s5 s5Var2 = t5Var2.M;
            g6 a = a(s5Var, 0);
            int b = s5Var.b();
            t5 f = f();
            if (f != null) {
                b = f.K.b();
            }
            if (a != null) {
                g6 g6Var = this.h;
                g6Var.l.add(a);
                g6Var.f = b;
                a.k.add(g6Var);
            }
            g6 a2 = a(s5Var2, 0);
            int b2 = s5Var2.b();
            t5 g = g();
            if (g != null) {
                b2 = g.M.b();
            }
            if (a2 != null) {
                g6 g6Var2 = this.i;
                g6Var2.l.add(a2);
                g6Var2.f = -b2;
                a2.k.add(g6Var2);
            }
        } else {
            s5 s5Var3 = t5Var.L;
            s5 s5Var4 = t5Var2.N;
            g6 a3 = a(s5Var3, 1);
            int b3 = s5Var3.b();
            t5 f2 = f();
            if (f2 != null) {
                b3 = f2.L.b();
            }
            if (a3 != null) {
                g6 g6Var3 = this.h;
                g6Var3.l.add(a3);
                g6Var3.f = b3;
                a3.k.add(g6Var3);
            }
            g6 a4 = a(s5Var4, 1);
            int b4 = s5Var4.b();
            t5 g2 = g();
            if (g2 != null) {
                b4 = g2.N.b();
            }
            if (a4 != null) {
                g6 g6Var4 = this.i;
                g6Var4.l.add(a4);
                g6Var4.f = -b4;
                a4.k.add(g6Var4);
            }
        }
        this.h.a = this;
        this.i.a = this;
    }
}
