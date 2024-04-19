package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import defpackage.g2;
import defpackage.h2;
import defpackage.p2;
import java.util.ArrayList;
/* compiled from: BaseMenuPresenter.java */
/* renamed from: u1  reason: default package */
/* loaded from: classes.dex */
public abstract class u1 implements g2 {
    public Context c;
    public Context d;
    public z1 e;
    public LayoutInflater f;
    public g2.a g;
    public int h;
    public int i;
    public h2 j;

    public u1(Context context, int i, int i2) {
        this.c = context;
        this.f = LayoutInflater.from(context);
        this.h = i;
        this.i = i2;
    }

    public void a(int i) {
    }

    @Override // defpackage.g2
    public void a(Context context, z1 z1Var) {
        this.d = context;
        LayoutInflater.from(this.d);
        this.e = z1Var;
    }

    @Override // defpackage.g2
    public boolean a(z1 z1Var, c2 c2Var) {
        return false;
    }

    @Override // defpackage.g2
    public boolean b(z1 z1Var, c2 c2Var) {
        return false;
    }

    @Override // defpackage.g2
    public void a(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.j;
        if (viewGroup == null) {
            return;
        }
        z1 z1Var = this.e;
        int i = 0;
        if (z1Var != null) {
            z1Var.a();
            ArrayList<c2> d = this.e.d();
            int size = d.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                c2 c2Var = d.get(i3);
                p2 p2Var = (p2) this;
                if (c2Var.d()) {
                    View childAt = viewGroup.getChildAt(i2);
                    c2 itemData = childAt instanceof h2.a ? ((h2.a) childAt).getItemData() : null;
                    View a = a(c2Var, childAt, viewGroup);
                    if (c2Var != itemData) {
                        a.setPressed(false);
                        a.jumpDrawablesToCurrentState();
                    }
                    if (a != childAt) {
                        ViewGroup viewGroup2 = (ViewGroup) a.getParent();
                        if (viewGroup2 != null) {
                            viewGroup2.removeView(a);
                        }
                        ((ViewGroup) this.j).addView(a, i2);
                    }
                    i2++;
                }
            }
            i = i2;
        }
        while (i < viewGroup.getChildCount()) {
            if (!a(viewGroup, i)) {
                i++;
            }
        }
    }

    public boolean a(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    @Override // defpackage.g2
    public void a(g2.a aVar) {
        this.g = aVar;
    }

    public View a(c2 c2Var, View view, ViewGroup viewGroup) {
        h2.a aVar;
        if (view instanceof h2.a) {
            aVar = (h2.a) view;
        } else {
            aVar = (h2.a) this.f.inflate(this.i, viewGroup, false);
        }
        p2 p2Var = (p2) this;
        aVar.a(c2Var, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) p2Var.j);
        if (p2Var.B == null) {
            p2Var.B = new p2.b();
        }
        actionMenuItemView.setPopupCallback(p2Var.B);
        return (View) aVar;
    }

    @Override // defpackage.g2
    public void a(z1 z1Var, boolean z) {
        g2.a aVar = this.g;
        if (aVar != null) {
            aVar.a(z1Var, z);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [z1] */
    @Override // defpackage.g2
    public boolean a(l2 l2Var) {
        g2.a aVar = this.g;
        l2 l2Var2 = l2Var;
        if (aVar != null) {
            if (l2Var == null) {
                l2Var2 = this.e;
            }
            return aVar.a(l2Var2);
        }
        return false;
    }
}
