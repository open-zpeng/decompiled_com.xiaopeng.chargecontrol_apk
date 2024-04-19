package defpackage;

import defpackage.nr;
import defpackage.ns;
import defpackage.ur;
import java.util.ArrayList;
import java.util.List;
/* compiled from: ChartHighlighter.java */
/* renamed from: hs  reason: default package */
/* loaded from: classes.dex */
public class hs<T extends ns> implements ks {
    public T a;
    public List<is> b = new ArrayList();

    public hs(T t) {
        this.a = t;
    }

    @Override // defpackage.ks
    public is a(float f, float f2) {
        ut b = this.a.a(nr.a.LEFT).b(f, f2);
        ut.d.a((wt<ut>) b);
        return a((float) b.b, f, f2);
    }

    public float a(List<is> list, float f, nr.a aVar) {
        float f2 = Float.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            is isVar = list.get(i);
            if (isVar.h == aVar) {
                float abs = Math.abs(isVar.d - f);
                if (abs < f2) {
                    f2 = abs;
                }
            }
        }
        return f2;
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [ts] */
    public is a(float f, float f2, float f3) {
        List<is> list;
        this.b.clear();
        qr a = a();
        if (a == null) {
            list = this.b;
        } else {
            int a2 = a.a();
            for (int i = 0; i < a2; i++) {
                ?? a3 = a.a(i);
                if (((rr) a3).g) {
                    this.b.addAll(a((ts) a3, i, f, ur.a.CLOSEST));
                }
            }
            list = this.b;
        }
        is isVar = null;
        if (list.isEmpty()) {
            return null;
        }
        nr.a aVar = a(list, f3, nr.a.LEFT) < a(list, f3, nr.a.RIGHT) ? nr.a.LEFT : nr.a.RIGHT;
        float maxHighlightDistance = this.a.getMaxHighlightDistance();
        for (int i2 = 0; i2 < list.size(); i2++) {
            is isVar2 = list.get(i2);
            if (aVar == null || isVar2.h == aVar) {
                float a4 = a(f2, f3, isVar2.a(), isVar2.d);
                if (a4 < maxHighlightDistance) {
                    isVar = isVar2;
                    maxHighlightDistance = a4;
                }
            }
        }
        return isVar;
    }

    public List<is> a(ts tsVar, int i, float f, ur.a aVar) {
        vr a;
        ArrayList arrayList = new ArrayList();
        ur urVar = (ur) tsVar;
        List<vr> b = urVar.b(f);
        if (b.size() == 0 && (a = urVar.a(f, Float.NaN, aVar)) != null) {
            b = urVar.b(a.b());
        }
        if (b.size() == 0) {
            return arrayList;
        }
        for (vr vrVar : b) {
            ut a2 = this.a.a(urVar.f).a(vrVar.b(), vrVar.a());
            arrayList.add(new is(vrVar.b(), vrVar.a(), (float) a2.b, (float) a2.c, i, urVar.f));
        }
        return arrayList;
    }

    public float a(float f, float f2, float f3, float f4) {
        return (float) Math.hypot(f - f3, f2 - f4);
    }

    public qr a() {
        return this.a.getData();
    }
}
