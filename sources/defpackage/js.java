package defpackage;

import defpackage.nr;
import defpackage.ur;
import java.util.ArrayList;
import java.util.List;
/* compiled from: HorizontalBarHighlighter.java */
/* renamed from: js  reason: default package */
/* loaded from: classes.dex */
public class js extends gs {
    public js(ms msVar) {
        super(msVar);
    }

    @Override // defpackage.gs, defpackage.hs, defpackage.ks
    public is a(float f, float f2) {
        or barData = ((ms) this.a).getBarData();
        ut b = this.a.a(nr.a.LEFT).b(f2, f);
        is a = a((float) b.c, f2, f);
        if (a == null) {
            return null;
        }
        qs qsVar = (qs) barData.a(a.f);
        if (qsVar.h()) {
            return a(a, qsVar, (float) b.c, (float) b.b);
        }
        ut.d.a((wt<ut>) b);
        return a;
    }

    @Override // defpackage.hs
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
            ut a2 = ((ms) this.a).a(urVar.f).a(vrVar.a(), vrVar.b());
            arrayList.add(new is(vrVar.b(), vrVar.a(), (float) a2.b, (float) a2.c, i, urVar.f));
        }
        return arrayList;
    }

    @Override // defpackage.gs, defpackage.hs
    public float a(float f, float f2, float f3, float f4) {
        return Math.abs(f2 - f4);
    }
}
