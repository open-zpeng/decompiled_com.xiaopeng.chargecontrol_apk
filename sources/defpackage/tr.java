package defpackage;

import defpackage.nr;
import defpackage.ts;
import java.util.ArrayList;
import java.util.List;
/* compiled from: ChartData.java */
/* renamed from: tr  reason: default package */
/* loaded from: classes.dex */
public abstract class tr<T extends ts<? extends vr>> {
    public float a = -3.4028235E38f;
    public float b = Float.MAX_VALUE;
    public float c = -3.4028235E38f;
    public float d = Float.MAX_VALUE;
    public float e = -3.4028235E38f;
    public float f = Float.MAX_VALUE;
    public float g = -3.4028235E38f;
    public float h = Float.MAX_VALUE;
    public List<T> i = new ArrayList();

    public vr a(is isVar) {
        if (isVar.f >= this.i.size()) {
            return null;
        }
        return ((ur) this.i.get(isVar.f)).a(isVar.a, isVar.b);
    }

    public float b(nr.a aVar) {
        if (aVar == nr.a.LEFT) {
            float f = this.f;
            return f == Float.MAX_VALUE ? this.h : f;
        }
        float f2 = this.h;
        return f2 == Float.MAX_VALUE ? this.f : f2;
    }

    public void b(T t) {
        float f = this.a;
        ur urVar = (ur) t;
        float f2 = urVar.t;
        if (f < f2) {
            this.a = f2;
        }
        float f3 = this.b;
        float f4 = urVar.u;
        if (f3 > f4) {
            this.b = f4;
        }
        float f5 = this.c;
        float f6 = urVar.v;
        if (f5 < f6) {
            this.c = f6;
        }
        float f7 = this.d;
        float f8 = urVar.w;
        if (f7 > f8) {
            this.d = f8;
        }
        if (((rr) t).f == nr.a.LEFT) {
            float f9 = this.e;
            float f10 = urVar.t;
            if (f9 < f10) {
                this.e = f10;
            }
            float f11 = this.f;
            float f12 = urVar.u;
            if (f11 > f12) {
                this.f = f12;
                return;
            }
            return;
        }
        float f13 = this.g;
        float f14 = urVar.t;
        if (f13 < f14) {
            this.g = f14;
        }
        float f15 = this.h;
        float f16 = urVar.u;
        if (f15 > f16) {
            this.h = f16;
        }
    }

    public int a() {
        List<T> list = this.i;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public float a(nr.a aVar) {
        if (aVar == nr.a.LEFT) {
            float f = this.e;
            return f == -3.4028235E38f ? this.g : f;
        }
        float f2 = this.g;
        return f2 == -3.4028235E38f ? this.e : f2;
    }

    public T a(int i) {
        List<T> list = this.i;
        if (list == null || i < 0 || i >= list.size()) {
            return null;
        }
        return this.i.get(i);
    }

    public void a(T t) {
        if (t == null) {
            return;
        }
        b((tr<T>) t);
        this.i.add(t);
    }

    public int b() {
        int i = 0;
        for (T t : this.i) {
            i += t.n();
        }
        return i;
    }
}
