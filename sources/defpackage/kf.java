package defpackage;

import android.view.View;
import android.view.ViewGroup;
import defpackage.nf;
/* compiled from: OrientationHelper.java */
/* renamed from: kf  reason: default package */
/* loaded from: classes.dex */
public class kf extends mf {
    public kf(nf.n nVar) {
        super(nVar, null);
    }

    @Override // defpackage.mf
    public int a() {
        return this.a.s();
    }

    @Override // defpackage.mf
    public int b() {
        return this.a.s() - this.a.p();
    }

    @Override // defpackage.mf
    public int c(View view) {
        nf.o oVar = (nf.o) view.getLayoutParams();
        return this.a.g(view) + ((ViewGroup.MarginLayoutParams) oVar).topMargin + ((ViewGroup.MarginLayoutParams) oVar).bottomMargin;
    }

    @Override // defpackage.mf
    public int d(View view) {
        return this.a.f(view) - ((ViewGroup.MarginLayoutParams) ((nf.o) view.getLayoutParams())).leftMargin;
    }

    @Override // defpackage.mf
    public int e(View view) {
        this.a.a(view, true, this.c);
        return this.c.right;
    }

    @Override // defpackage.mf
    public int f() {
        return this.a.o();
    }

    @Override // defpackage.mf
    public int g() {
        return (this.a.s() - this.a.o()) - this.a.p();
    }

    @Override // defpackage.mf
    public void a(int i) {
        this.a.f(i);
    }

    @Override // defpackage.mf
    public int b(View view) {
        nf.o oVar = (nf.o) view.getLayoutParams();
        return this.a.h(view) + ((ViewGroup.MarginLayoutParams) oVar).leftMargin + ((ViewGroup.MarginLayoutParams) oVar).rightMargin;
    }

    @Override // defpackage.mf
    public int f(View view) {
        this.a.a(view, true, this.c);
        return this.c.left;
    }

    @Override // defpackage.mf
    public int a(View view) {
        return this.a.i(view) + ((ViewGroup.MarginLayoutParams) ((nf.o) view.getLayoutParams())).rightMargin;
    }

    @Override // defpackage.mf
    public int c() {
        return this.a.p();
    }

    @Override // defpackage.mf
    public int d() {
        return this.a.t();
    }

    @Override // defpackage.mf
    public int e() {
        return this.a.i();
    }
}
