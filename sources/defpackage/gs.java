package defpackage;

import defpackage.nr;
/* compiled from: BarHighlighter.java */
/* renamed from: gs  reason: default package */
/* loaded from: classes.dex */
public class gs extends hs<ms> {
    public gs(ms msVar) {
        super(msVar);
    }

    @Override // defpackage.hs, defpackage.ks
    public is a(float f, float f2) {
        is a = super.a(f, f2);
        if (a == null) {
            return null;
        }
        ut b = this.a.a(nr.a.LEFT).b(f, f2);
        qs qsVar = (qs) ((ms) this.a).getBarData().a(a.f);
        if (qsVar.h()) {
            return a(a, qsVar, (float) b.b, (float) b.c);
        }
        ut.d.a((wt<ut>) b);
        return a;
    }

    public is a(is isVar, qs qsVar, float f, float f2) {
        pr prVar = (pr) ((ur) qsVar).a(f, f2);
        if (prVar == null) {
            return null;
        }
        if (prVar.g == null) {
            return isVar;
        }
        ls[] lsVarArr = prVar.h;
        if (lsVarArr.length > 0) {
            if (lsVarArr.length != 0) {
                if (lsVarArr.length > 0) {
                    ls lsVar = lsVarArr[0];
                    throw null;
                }
                ls lsVar2 = lsVarArr[Math.max(lsVarArr.length - 1, 0)];
                throw null;
            }
            ((ms) this.a).a(((rr) qsVar).f);
            float f3 = isVar.a;
            ls lsVar3 = lsVarArr[0];
            throw null;
        }
        return null;
    }

    @Override // defpackage.hs
    public float a(float f, float f2, float f3, float f4) {
        return Math.abs(f - f3);
    }

    @Override // defpackage.hs
    public qr a() {
        return ((ms) this.a).getBarData();
    }
}
