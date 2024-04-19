package defpackage;

import android.view.View;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import defpackage.df;
import defpackage.nf;
/* compiled from: SimpleItemAnimator.java */
/* renamed from: qf  reason: default package */
/* loaded from: classes.dex */
public abstract class qf extends nf.k {
    public boolean g = true;

    public abstract boolean a(nf.c0 c0Var, int i, int i2, int i3, int i4);

    @Override // defpackage.nf.k
    public boolean a(nf.c0 c0Var, nf.k.c cVar, nf.k.c cVar2) {
        if (cVar != null && (cVar.a != cVar2.a || cVar.b != cVar2.b)) {
            return a(c0Var, cVar.a, cVar.b, cVar2.a, cVar2.b);
        }
        df dfVar = (df) this;
        dfVar.h(c0Var);
        c0Var.a.setAlpha(XToggleDrawable.LIGHT_RADIUS_DEFAULT);
        dfVar.i.add(c0Var);
        return true;
    }

    public final void b(nf.c0 c0Var, boolean z) {
    }

    @Override // defpackage.nf.k
    public boolean b(nf.c0 c0Var, nf.k.c cVar, nf.k.c cVar2) {
        int i = cVar.a;
        int i2 = cVar.b;
        View view = c0Var.a;
        int left = cVar2 == null ? view.getLeft() : cVar2.a;
        int top = cVar2 == null ? view.getTop() : cVar2.b;
        if (!c0Var.j() && (i != left || i2 != top)) {
            view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
            return a(c0Var, i, i2, left, top);
        }
        df dfVar = (df) this;
        dfVar.h(c0Var);
        dfVar.h.add(c0Var);
        return true;
    }

    @Override // defpackage.nf.k
    public boolean c(nf.c0 c0Var, nf.k.c cVar, nf.k.c cVar2) {
        if (cVar.a == cVar2.a && cVar.b == cVar2.b) {
            a(c0Var);
            return false;
        }
        return a(c0Var, cVar.a, cVar.b, cVar2.a, cVar2.b);
    }

    public final void d(nf.c0 c0Var) {
    }

    public final void e(nf.c0 c0Var) {
    }

    public final void f(nf.c0 c0Var) {
    }

    @Override // defpackage.nf.k
    public boolean a(nf.c0 c0Var, nf.c0 c0Var2, nf.k.c cVar, nf.k.c cVar2) {
        int i;
        int i2;
        int i3 = cVar.a;
        int i4 = cVar.b;
        if (c0Var2.o()) {
            int i5 = cVar.a;
            i2 = cVar.b;
            i = i5;
        } else {
            i = cVar2.a;
            i2 = cVar2.b;
        }
        df dfVar = (df) this;
        if (c0Var == c0Var2) {
            return dfVar.a(c0Var, i3, i4, i, i2);
        }
        float translationX = c0Var.a.getTranslationX();
        float translationY = c0Var.a.getTranslationY();
        float alpha = c0Var.a.getAlpha();
        dfVar.h(c0Var);
        c0Var.a.setTranslationX(translationX);
        c0Var.a.setTranslationY(translationY);
        c0Var.a.setAlpha(alpha);
        dfVar.h(c0Var2);
        c0Var2.a.setTranslationX(-((int) ((i - i3) - translationX)));
        c0Var2.a.setTranslationY(-((int) ((i2 - i4) - translationY)));
        c0Var2.a.setAlpha(XToggleDrawable.LIGHT_RADIUS_DEFAULT);
        dfVar.k.add(new df.e(c0Var, c0Var2, i3, i4, i, i2));
        return true;
    }

    public final void a(nf.c0 c0Var, boolean z) {
        nf.k.b bVar = this.a;
        if (bVar != null) {
            ((nf.l) bVar).a(c0Var);
        }
    }
}
