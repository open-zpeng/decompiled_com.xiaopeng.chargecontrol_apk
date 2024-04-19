package defpackage;

import android.util.Log;
import defpackage.nr;
/* compiled from: BarChart.java */
/* renamed from: ar  reason: default package */
/* loaded from: classes.dex */
public class ar extends br<or> implements ms {
    public boolean n0;
    public boolean o0;
    public boolean p0;
    public boolean q0;

    @Override // defpackage.cr
    public is a(float f, float f2) {
        if (this.d == 0) {
            Log.e("MPAndroidChart", "Can't select by touch. No data set.");
            return null;
        }
        is a = getHighlighter().a(f, f2);
        return (a == null || !c()) ? a : new is(a.a, a.b, a.c, a.d, a.f, -1, a.h);
    }

    @Override // defpackage.ms
    public boolean b() {
        return this.o0;
    }

    @Override // defpackage.ms
    public boolean c() {
        return this.n0;
    }

    @Override // defpackage.br, defpackage.cr
    public void g() {
        super.g();
        this.r = new ft(this, this.u, this.t);
        setHighlighter(new gs(this));
        getXAxis().C = 0.5f;
        getXAxis().D = 0.5f;
    }

    @Override // defpackage.ms
    public or getBarData() {
        return (or) this.d;
    }

    @Override // defpackage.br
    public void n() {
        if (this.q0) {
            mr mrVar = this.k;
            T t = this.d;
            mrVar.a(((or) t).d - (((or) t).j / 2.0f), (((or) t).j / 2.0f) + ((or) t).c);
        } else {
            mr mrVar2 = this.k;
            T t2 = this.d;
            mrVar2.a(((or) t2).d, ((or) t2).c);
        }
        this.V.a(((or) this.d).b(nr.a.LEFT), ((or) this.d).a(nr.a.LEFT));
        this.W.a(((or) this.d).b(nr.a.RIGHT), ((or) this.d).a(nr.a.RIGHT));
    }

    public void setDrawBarShadow(boolean z) {
        this.p0 = z;
    }

    public void setDrawValueAboveBar(boolean z) {
        this.o0 = z;
    }

    public void setFitBars(boolean z) {
        this.q0 = z;
    }

    public void setHighlightFullBarEnabled(boolean z) {
        this.n0 = z;
    }

    @Override // defpackage.ms
    public boolean a() {
        return this.p0;
    }
}
