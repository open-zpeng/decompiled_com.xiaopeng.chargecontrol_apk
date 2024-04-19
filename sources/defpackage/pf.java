package defpackage;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import defpackage.f9;
import java.util.Map;
import java.util.WeakHashMap;
/* compiled from: RecyclerViewAccessibilityDelegate.java */
/* renamed from: pf  reason: default package */
/* loaded from: classes.dex */
public class pf extends f9 {
    public final nf d;
    public final a e;

    public pf(nf nfVar) {
        super(f9.c);
        this.d = nfVar;
        a aVar = this.e;
        if (aVar != null) {
            this.e = aVar;
        } else {
            this.e = new a(this);
        }
    }

    public boolean a() {
        return this.d.F();
    }

    @Override // defpackage.f9
    public void b(View view, AccessibilityEvent accessibilityEvent) {
        this.a.onInitializeAccessibilityEvent(view, accessibilityEvent);
        if (!(view instanceof nf) || a()) {
            return;
        }
        nf nfVar = (nf) view;
        if (nfVar.getLayoutManager() != null) {
            nfVar.getLayoutManager().a(accessibilityEvent);
        }
    }

    @Override // defpackage.f9
    public boolean a(View view, int i, Bundle bundle) {
        if (super.a(view, i, bundle)) {
            return true;
        }
        if (a() || this.d.getLayoutManager() == null) {
            return false;
        }
        return this.d.getLayoutManager().a(i, bundle);
    }

    /* compiled from: RecyclerViewAccessibilityDelegate.java */
    /* renamed from: pf$a */
    /* loaded from: classes.dex */
    public static class a extends f9 {
        public final pf d;
        public Map<View, f9> e;

        public a(pf pfVar) {
            super(f9.c);
            this.e = new WeakHashMap();
            this.d = pfVar;
        }

        @Override // defpackage.f9
        public void a(View view, la laVar) {
            if (!this.d.a() && this.d.d.getLayoutManager() != null) {
                this.d.d.getLayoutManager().a(view, laVar);
                f9 f9Var = this.e.get(view);
                if (f9Var != null) {
                    f9Var.a(view, laVar);
                    return;
                } else {
                    this.a.onInitializeAccessibilityNodeInfo(view, laVar.a);
                    return;
                }
            }
            this.a.onInitializeAccessibilityNodeInfo(view, laVar.a);
        }

        @Override // defpackage.f9
        public void b(View view, AccessibilityEvent accessibilityEvent) {
            f9 f9Var = this.e.get(view);
            if (f9Var != null) {
                f9Var.b(view, accessibilityEvent);
            } else {
                this.a.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // defpackage.f9
        public void c(View view, AccessibilityEvent accessibilityEvent) {
            f9 f9Var = this.e.get(view);
            if (f9Var != null) {
                f9Var.c(view, accessibilityEvent);
            } else {
                this.a.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // defpackage.f9
        public void d(View view, AccessibilityEvent accessibilityEvent) {
            f9 f9Var = this.e.get(view);
            if (f9Var != null) {
                f9Var.d(view, accessibilityEvent);
            } else {
                this.a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
            }
        }

        public void b(View view) {
            f9 f9Var;
            View.AccessibilityDelegate b = y9.b(view);
            if (b == null) {
                f9Var = null;
            } else if (b instanceof f9.a) {
                f9Var = ((f9.a) b).a;
            } else {
                f9Var = new f9(b);
            }
            if (f9Var == null || f9Var == this) {
                return;
            }
            this.e.put(view, f9Var);
        }

        @Override // defpackage.f9
        public boolean a(View view, int i, Bundle bundle) {
            if (!this.d.a() && this.d.d.getLayoutManager() != null) {
                f9 f9Var = this.e.get(view);
                if (f9Var != null) {
                    if (f9Var.a(view, i, bundle)) {
                        return true;
                    }
                } else if (super.a(view, i, bundle)) {
                    return true;
                }
                return this.d.d.getLayoutManager().a(view, i, bundle);
            }
            return super.a(view, i, bundle);
        }

        @Override // defpackage.f9
        public void a(View view, int i) {
            f9 f9Var = this.e.get(view);
            if (f9Var != null) {
                f9Var.a(view, i);
            } else {
                this.a.sendAccessibilityEvent(view, i);
            }
        }

        @Override // defpackage.f9
        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            f9 f9Var = this.e.get(view);
            if (f9Var != null) {
                return f9Var.a(view, accessibilityEvent);
            }
            return this.a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // defpackage.f9
        public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            f9 f9Var = this.e.get(viewGroup);
            if (f9Var != null) {
                return f9Var.a(viewGroup, view, accessibilityEvent);
            }
            return this.a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        @Override // defpackage.f9
        public ma a(View view) {
            f9 f9Var = this.e.get(view);
            if (f9Var != null) {
                return f9Var.a(view);
            }
            return super.a(view);
        }
    }

    @Override // defpackage.f9
    public void a(View view, la laVar) {
        this.a.onInitializeAccessibilityNodeInfo(view, laVar.a);
        if (a() || this.d.getLayoutManager() == null) {
            return;
        }
        this.d.getLayoutManager().a(laVar);
    }
}
