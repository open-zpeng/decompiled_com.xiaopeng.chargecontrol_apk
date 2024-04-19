package defpackage;

import android.view.View;
import android.view.ViewGroup;
import defpackage.nf;
/* compiled from: OrientationHelper.java */
/* renamed from: lf  reason: default package */
/* loaded from: classes.dex */
public class lf extends mf {
    public lf(nf.n nVar) {
        super(nVar, null);
    }

    @Override // defpackage.mf
    public int a() {
        return this.a.h();
    }

    @Override // defpackage.mf
    public int b() {
        return this.a.h() - this.a.n();
    }

    @Override // defpackage.mf
    public int c(View view) {
        nf.o oVar = (nf.o) view.getLayoutParams();
        return this.a.h(view) + ((ViewGroup.MarginLayoutParams) oVar).leftMargin + ((ViewGroup.MarginLayoutParams) oVar).rightMargin;
    }

    @Override // defpackage.mf
    public int d(View view) {
        return this.a.j(view) - ((ViewGroup.MarginLayoutParams) ((nf.o) view.getLayoutParams())).topMargin;
    }

    @Override // defpackage.mf
    public int e(View view) {
        this.a.a(view, true, this.c);
        return this.c.bottom;
    }

    @Override // defpackage.mf
    public int f() {
        return this.a.q();
    }

    @Override // defpackage.mf
    public int g() {
        return (this.a.h() - this.a.q()) - this.a.n();
    }

    @Override // defpackage.mf
    public void a(int i) {
        this.a.g(i);
    }

    @Override // defpackage.mf
    public int b(View view) {
        nf.o oVar = (nf.o) view.getLayoutParams();
        return this.a.g(view) + ((ViewGroup.MarginLayoutParams) oVar).topMargin + ((ViewGroup.MarginLayoutParams) oVar).bottomMargin;
    }

    @Override // defpackage.mf
    public int f(View view) {
        this.a.a(view, true, this.c);
        return this.c.top;
    }

    @Override // defpackage.mf
    public int a(View view) {
        return this.a.e(view) + ((ViewGroup.MarginLayoutParams) ((nf.o) view.getLayoutParams())).bottomMargin;
    }

    @Override // defpackage.mf
    public int c() {
        return this.a.n();
    }

    @Override // defpackage.mf
    public int d() {
        return this.a.i();
    }

    @Override // defpackage.mf
    public int e() {
        return this.a.t();
    }
}
