package defpackage;

import android.view.View;
import android.view.ViewGroup;
import defpackage.nf;
import defpackage.ye;
/* compiled from: RecyclerView.java */
/* renamed from: of  reason: default package */
/* loaded from: classes.dex */
public class of implements ye.b {
    public final /* synthetic */ nf a;

    public of(nf nfVar) {
        this.a = nfVar;
    }

    public int a() {
        return this.a.getChildCount();
    }

    public void b(int i) {
        View childAt = this.a.getChildAt(i);
        if (childAt != null) {
            this.a.c(childAt);
            childAt.clearAnimation();
        }
        this.a.removeViewAt(i);
    }

    public void c(View view) {
        nf.c0 l = nf.l(view);
        if (l != null) {
            this.a.a(l, l.p);
            l.p = 0;
        }
    }

    public View a(int i) {
        return this.a.getChildAt(i);
    }

    public nf.c0 a(View view) {
        return nf.l(view);
    }

    public void a(View view, int i, ViewGroup.LayoutParams layoutParams) {
        nf.c0 l = nf.l(view);
        if (l != null) {
            if (!l.l() && !l.o()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Called attach on a child which is not detached: ");
                sb.append(l);
                throw new IllegalArgumentException(jg.a(this.a, sb));
            }
            l.j &= -257;
        }
        this.a.attachViewToParent(view, i, layoutParams);
    }

    public void b(View view) {
        nf.c0 l = nf.l(view);
        if (l != null) {
            nf nfVar = this.a;
            int i = l.q;
            if (i != -1) {
                l.p = i;
            } else {
                l.p = y9.f(l.a);
            }
            nfVar.a(l, 4);
        }
    }
}
