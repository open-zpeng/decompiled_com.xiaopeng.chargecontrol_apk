package defpackage;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Trace;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import com.bumptech.glide.integration.webp.WebpBitmapFactory;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IInputController;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IRadioController;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import com.xiaopeng.xui.widget.XTextView;
import defpackage.b50;
import defpackage.df;
import defpackage.ff;
import defpackage.la;
import defpackage.pf;
import defpackage.rf;
import defpackage.sf;
import defpackage.xe;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* compiled from: RecyclerView.java */
/* renamed from: nf  reason: default package */
/* loaded from: classes.dex */
public class nf extends ViewGroup implements w9, k9, l9 {
    public static final int[] B0 = {16843830};
    public static final boolean C0;
    public static final boolean D0;
    public static final boolean E0;
    public static final boolean F0;
    public static final boolean G0;
    public static final Class<?>[] H0;
    public static final Interpolator I0;
    public boolean A;
    public final sf.b A0;
    public int B;
    public boolean C;
    public final AccessibilityManager D;
    public List<p> E;
    public boolean F;
    public boolean G;
    public int H;
    public int I;
    public j J;
    public EdgeEffect K;
    public EdgeEffect L;
    public EdgeEffect M;
    public EdgeEffect N;
    public k O;
    public int P;
    public int Q;
    public VelocityTracker R;
    public int S;
    public int T;
    public int U;
    public int V;
    public int W;
    public final int a0;
    public final int b0;
    public final w c;
    public float c0;
    public final u d;
    public float d0;
    public x e;
    public boolean e0;
    public xe f;
    public final b0 f0;
    public ye g;
    public ff g0;
    public final sf h;
    public ff.b h0;
    public boolean i;
    public final z i0;
    public final Rect j;
    public s j0;
    public final Rect k;
    public List<s> k0;
    public final RectF l;
    public boolean l0;
    public f m;
    public boolean m0;
    public n n;
    public k.b n0;
    public v o;
    public boolean o0;
    public final List<v> p;
    public pf p0;
    public final ArrayList<m> q;
    public final int[] q0;
    public final ArrayList<r> r;
    public n9 r0;
    public r s;
    public final int[] s0;
    public boolean t;
    public final int[] t0;
    public boolean u;
    public final int[] u0;
    public boolean v;
    public final List<c0> v0;
    public boolean w;
    public Runnable w0;
    public int x;
    public boolean x0;
    public boolean y;
    public int y0;
    public boolean z;
    public int z0;

    /* compiled from: RecyclerView.java */
    /* renamed from: nf$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            nf nfVar = nf.this;
            if (!nfVar.w || nfVar.isLayoutRequested()) {
                return;
            }
            nf nfVar2 = nf.this;
            if (!nfVar2.t) {
                nfVar2.requestLayout();
            } else if (nfVar2.z) {
                nfVar2.y = true;
            } else {
                nfVar2.v();
            }
        }
    }

    /* compiled from: RecyclerView.java */
    /* renamed from: nf$a0 */
    /* loaded from: classes.dex */
    public static abstract class a0 {
    }

    /* compiled from: RecyclerView.java */
    /* renamed from: nf$b */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k kVar = nf.this.O;
            if (kVar != null) {
                df dfVar = (df) kVar;
                boolean z = !dfVar.h.isEmpty();
                boolean z2 = !dfVar.j.isEmpty();
                boolean z3 = !dfVar.k.isEmpty();
                boolean z4 = !dfVar.i.isEmpty();
                if (z || z2 || z4 || z3) {
                    Iterator<c0> it = dfVar.h.iterator();
                    while (it.hasNext()) {
                        c0 next = it.next();
                        View view = next.a;
                        ViewPropertyAnimator animate = view.animate();
                        dfVar.q.add(next);
                        animate.setDuration(dfVar.d).alpha(XToggleDrawable.LIGHT_RADIUS_DEFAULT).setListener(new cf(dfVar, next, animate, view)).start();
                    }
                    dfVar.h.clear();
                    if (z2) {
                        ArrayList<df.f> arrayList = new ArrayList<>();
                        arrayList.addAll(dfVar.j);
                        dfVar.m.add(arrayList);
                        dfVar.j.clear();
                        ze zeVar = new ze(dfVar, arrayList);
                        if (z) {
                            y9.a(arrayList.get(0).a.a, zeVar, dfVar.d);
                        } else {
                            zeVar.run();
                        }
                    }
                    if (z3) {
                        ArrayList<df.e> arrayList2 = new ArrayList<>();
                        arrayList2.addAll(dfVar.k);
                        dfVar.n.add(arrayList2);
                        dfVar.k.clear();
                        af afVar = new af(dfVar, arrayList2);
                        if (z) {
                            y9.a(arrayList2.get(0).a.a, afVar, dfVar.d);
                        } else {
                            afVar.run();
                        }
                    }
                    if (z4) {
                        ArrayList<c0> arrayList3 = new ArrayList<>();
                        arrayList3.addAll(dfVar.i);
                        dfVar.l.add(arrayList3);
                        dfVar.i.clear();
                        bf bfVar = new bf(dfVar, arrayList3);
                        if (!z && !z2 && !z3) {
                            bfVar.run();
                        } else {
                            y9.a(arrayList3.get(0).a, bfVar, Math.max(z2 ? dfVar.c() : 0L, z3 ? dfVar.f : 0L) + (z ? dfVar.d : 0L));
                        }
                    }
                }
            }
            nf.this.o0 = false;
        }
    }

    /* compiled from: RecyclerView.java */
    /* renamed from: nf$c */
    /* loaded from: classes.dex */
    public class c implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    /* compiled from: RecyclerView.java */
    /* renamed from: nf$c0 */
    /* loaded from: classes.dex */
    public static abstract class c0 {
        public static final List<Object> t = Collections.emptyList();
        public final View a;
        public WeakReference<nf> b;
        public int j;
        public nf r;
        public f<? extends c0> s;
        public int c = -1;
        public int d = -1;
        public long e = -1;
        public int f = -1;
        public int g = -1;
        public c0 h = null;
        public c0 i = null;
        public List<Object> k = null;
        public List<Object> l = null;
        public int m = 0;
        public u n = null;
        public boolean o = false;
        public int p = 0;
        public int q = -1;

        public c0(View view) {
            if (view != null) {
                this.a = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        public void a(int i, boolean z) {
            if (this.d == -1) {
                this.d = this.c;
            }
            if (this.g == -1) {
                this.g = this.c;
            }
            if (z) {
                this.g += i;
            }
            this.c += i;
            if (this.a.getLayoutParams() != null) {
                ((o) this.a.getLayoutParams()).c = true;
            }
        }

        public void b() {
            this.j &= -33;
        }

        public final int c() {
            nf nfVar = this.r;
            if (nfVar == null) {
                return -1;
            }
            return nfVar.c(this);
        }

        public final int d() {
            int i = this.g;
            return i == -1 ? this.c : i;
        }

        public List<Object> e() {
            if ((this.j & 1024) == 0) {
                List<Object> list = this.k;
                if (list != null && list.size() != 0) {
                    return this.l;
                }
                return t;
            }
            return t;
        }

        public boolean f() {
            return (this.a.getParent() == null || this.a.getParent() == this.r) ? false : true;
        }

        public boolean g() {
            return (this.j & 1) != 0;
        }

        public boolean h() {
            return (this.j & 4) != 0;
        }

        public final boolean i() {
            return (this.j & 16) == 0 && !y9.p(this.a);
        }

        public boolean j() {
            return (this.j & 8) != 0;
        }

        public boolean k() {
            return this.n != null;
        }

        public boolean l() {
            return (this.j & IRadioController.TEF663x_PCHANNEL) != 0;
        }

        public boolean m() {
            return (this.j & 2) != 0;
        }

        public void n() {
            this.j = 0;
            this.c = -1;
            this.d = -1;
            this.e = -1L;
            this.g = -1;
            this.m = 0;
            this.h = null;
            this.i = null;
            List<Object> list = this.k;
            if (list != null) {
                list.clear();
            }
            this.j &= -1025;
            this.p = 0;
            this.q = -1;
            nf.e(this);
        }

        public boolean o() {
            return (this.j & 128) != 0;
        }

        public boolean p() {
            return (this.j & 32) != 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder((getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName()) + "{" + Integer.toHexString(hashCode()) + " position=" + this.c + " id=" + this.e + ", oldPos=" + this.d + ", pLpos:" + this.g);
            if (k()) {
                sb.append(" scrap ");
                sb.append(this.o ? "[changeScrap]" : "[attachedScrap]");
            }
            if (h()) {
                sb.append(" invalid");
            }
            if (!g()) {
                sb.append(" unbound");
            }
            boolean z = true;
            if ((this.j & 2) != 0) {
                sb.append(" update");
            }
            if (j()) {
                sb.append(" removed");
            }
            if (o()) {
                sb.append(" ignored");
            }
            if (l()) {
                sb.append(" tmpDetached");
            }
            if (!i()) {
                StringBuilder a = jg.a(" not recyclable(");
                a.append(this.m);
                a.append(")");
                sb.append(a.toString());
            }
            if ((this.j & IInputController.KEYCODE_BACK_BUTTON) == 0 && !h()) {
                z = false;
            }
            if (z) {
                sb.append(" undefined adapter position");
            }
            if (this.a.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        public boolean b(int i) {
            return (i & this.j) != 0;
        }

        public void a() {
            this.d = -1;
            this.g = -1;
        }

        public void a(int i, int i2) {
            this.j = (i & i2) | (this.j & (~i2));
        }

        public void a(int i) {
            this.j = i | this.j;
        }

        public void a(Object obj) {
            if (obj == null) {
                a(1024);
            } else if ((1024 & this.j) == 0) {
                if (this.k == null) {
                    this.k = new ArrayList();
                    this.l = Collections.unmodifiableList(this.k);
                }
                this.k.add(obj);
            }
        }

        public final void a(boolean z) {
            int i = this.m;
            this.m = z ? i - 1 : i + 1;
            int i2 = this.m;
            if (i2 < 0) {
                this.m = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
            } else if (!z && i2 == 1) {
                this.j |= 16;
            } else if (z && this.m == 0) {
                this.j &= -17;
            }
        }
    }

    /* compiled from: RecyclerView.java */
    /* renamed from: nf$d */
    /* loaded from: classes.dex */
    public class d implements sf.b {
        public d() {
        }

        public void a(c0 c0Var, k.c cVar, k.c cVar2) {
            nf.this.a(c0Var, cVar, cVar2);
        }

        public void b(c0 c0Var, k.c cVar, k.c cVar2) {
            nf.this.d.b(c0Var);
            nf.this.b(c0Var, cVar, cVar2);
        }

        public void c(c0 c0Var, k.c cVar, k.c cVar2) {
            c0Var.a(false);
            nf nfVar = nf.this;
            if (nfVar.F) {
                if (nfVar.O.a(c0Var, c0Var, cVar, cVar2)) {
                    nf.this.S();
                }
            } else if (nfVar.O.c(c0Var, cVar, cVar2)) {
                nf.this.S();
            }
        }

        public void a(c0 c0Var) {
            nf nfVar = nf.this;
            nfVar.n.a(c0Var.a, nfVar.d);
        }
    }

    /* compiled from: RecyclerView.java */
    /* renamed from: nf$g */
    /* loaded from: classes.dex */
    public static class g extends Observable<h> {
        public void a() {
            for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
                ((h) ((Observable) this).mObservers.get(size)).a();
            }
        }
    }

    /* compiled from: RecyclerView.java */
    /* renamed from: nf$h */
    /* loaded from: classes.dex */
    public static abstract class h {
        public void a() {
        }
    }

    /* compiled from: RecyclerView.java */
    /* renamed from: nf$i */
    /* loaded from: classes.dex */
    public interface i {
    }

    /* compiled from: RecyclerView.java */
    /* renamed from: nf$j */
    /* loaded from: classes.dex */
    public static class j {
        public EdgeEffect a(nf nfVar) {
            return new EdgeEffect(nfVar.getContext());
        }
    }

    /* compiled from: RecyclerView.java */
    /* renamed from: nf$k */
    /* loaded from: classes.dex */
    public static abstract class k {
        public b a = null;
        public ArrayList<a> b = new ArrayList<>();
        public long c = 120;
        public long d = 120;
        public long e = 250;
        public long f = 250;

        /* compiled from: RecyclerView.java */
        /* renamed from: nf$k$a */
        /* loaded from: classes.dex */
        public interface a {
            void a();
        }

        /* compiled from: RecyclerView.java */
        /* renamed from: nf$k$b */
        /* loaded from: classes.dex */
        public interface b {
        }

        /* compiled from: RecyclerView.java */
        /* renamed from: nf$k$c */
        /* loaded from: classes.dex */
        public static class c {
            public int a;
            public int b;

            public c a(c0 c0Var) {
                View view = c0Var.a;
                this.a = view.getLeft();
                this.b = view.getTop();
                view.getRight();
                view.getBottom();
                return this;
            }
        }

        public final void a(c0 c0Var) {
            b bVar = this.a;
            if (bVar != null) {
                ((l) bVar).a(c0Var);
            }
        }

        public abstract boolean a(c0 c0Var, c0 c0Var2, c cVar, c cVar2);

        public abstract boolean a(c0 c0Var, c cVar, c cVar2);

        public abstract void b();

        public abstract void b(c0 c0Var);

        public abstract boolean b(c0 c0Var, c cVar, c cVar2);

        public long c() {
            return this.e;
        }

        public abstract boolean c(c0 c0Var, c cVar, c cVar2);

        public abstract boolean d();

        public c e() {
            return new c();
        }

        public static int c(c0 c0Var) {
            int i = c0Var.j & 14;
            if (c0Var.h()) {
                return 4;
            }
            if ((i & 4) == 0) {
                int i2 = c0Var.d;
                int c2 = c0Var.c();
                return (i2 == -1 || c2 == -1 || i2 == c2) ? i : i | 2048;
            }
            return i;
        }

        public boolean a(c0 c0Var, List<Object> list) {
            return !((qf) this).g || c0Var.h();
        }

        public final void a() {
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                this.b.get(i).a();
            }
            this.b.clear();
        }
    }

    /* compiled from: RecyclerView.java */
    /* renamed from: nf$l */
    /* loaded from: classes.dex */
    public class l implements k.b {
        public l() {
        }

        public void a(c0 c0Var) {
            c0Var.a(true);
            if (c0Var.h != null && c0Var.i == null) {
                c0Var.h = null;
            }
            c0Var.i = null;
            if (((c0Var.j & 16) != 0) || nf.this.j(c0Var.a) || !c0Var.l()) {
                return;
            }
            nf.this.removeDetachedView(c0Var.a, false);
        }
    }

    /* compiled from: RecyclerView.java */
    /* renamed from: nf$m */
    /* loaded from: classes.dex */
    public static abstract class m {
        public void a(Canvas canvas, nf nfVar) {
        }

        public void a(Rect rect, View view, nf nfVar) {
            ((o) view.getLayoutParams()).a();
            rect.set(0, 0, 0, 0);
        }
    }

    /* compiled from: RecyclerView.java */
    /* renamed from: nf$n */
    /* loaded from: classes.dex */
    public static abstract class n {
        public ye a;
        public nf b;
        public y g;
        public int m;
        public boolean n;
        public int o;
        public int p;
        public int q;
        public int r;
        public final rf.b c = new a();
        public final rf.b d = new b();
        public rf e = new rf(this.c);
        public rf f = new rf(this.d);
        public boolean h = false;
        public boolean i = false;
        public boolean j = false;
        public boolean k = true;
        public boolean l = true;

        /* compiled from: RecyclerView.java */
        /* renamed from: nf$n$a */
        /* loaded from: classes.dex */
        public class a implements rf.b {
            public a() {
            }

            @Override // defpackage.rf.b
            public View a(int i) {
                return n.this.e(i);
            }

            @Override // defpackage.rf.b
            public int b() {
                return n.this.o();
            }

            @Override // defpackage.rf.b
            public int a() {
                return n.this.s() - n.this.p();
            }

            @Override // defpackage.rf.b
            public int b(View view) {
                return n.this.i(view) + ((ViewGroup.MarginLayoutParams) ((o) view.getLayoutParams())).rightMargin;
            }

            @Override // defpackage.rf.b
            public int a(View view) {
                return n.this.f(view) - ((ViewGroup.MarginLayoutParams) ((o) view.getLayoutParams())).leftMargin;
            }
        }

        /* compiled from: RecyclerView.java */
        /* renamed from: nf$n$b */
        /* loaded from: classes.dex */
        public class b implements rf.b {
            public b() {
            }

            @Override // defpackage.rf.b
            public View a(int i) {
                return n.this.e(i);
            }

            @Override // defpackage.rf.b
            public int b() {
                return n.this.q();
            }

            @Override // defpackage.rf.b
            public int a() {
                return n.this.h() - n.this.n();
            }

            @Override // defpackage.rf.b
            public int b(View view) {
                return n.this.e(view) + ((ViewGroup.MarginLayoutParams) ((o) view.getLayoutParams())).bottomMargin;
            }

            @Override // defpackage.rf.b
            public int a(View view) {
                return n.this.j(view) - ((ViewGroup.MarginLayoutParams) ((o) view.getLayoutParams())).topMargin;
            }
        }

        /* compiled from: RecyclerView.java */
        /* renamed from: nf$n$c */
        /* loaded from: classes.dex */
        public interface c {
        }

        /* compiled from: RecyclerView.java */
        /* renamed from: nf$n$d */
        /* loaded from: classes.dex */
        public static class d {
            public int a;
            public int b;
            public boolean c;
            public boolean d;
        }

        public boolean A() {
            return false;
        }

        public void B() {
        }

        @Deprecated
        public void C() {
        }

        public View D() {
            return null;
        }

        public void E() {
        }

        public Parcelable F() {
            return null;
        }

        public boolean G() {
            return false;
        }

        public void H() {
            nf nfVar = this.b;
            if (nfVar != null) {
                nfVar.requestLayout();
            }
        }

        public void I() {
            this.h = true;
        }

        public boolean J() {
            return false;
        }

        public void K() {
            y yVar = this.g;
            if (yVar != null) {
                yVar.stop();
            }
        }

        public boolean L() {
            return false;
        }

        public int a(int i, u uVar, z zVar) {
            return 0;
        }

        public int a(u uVar, z zVar) {
            return -1;
        }

        public int a(z zVar) {
            return 0;
        }

        public View a(View view, int i, u uVar, z zVar) {
            return null;
        }

        public void a(int i, int i2, z zVar, c cVar) {
        }

        public void a(int i, c cVar) {
        }

        public void a(Rect rect, int i, int i2) {
            d(a(i, p() + o() + rect.width(), m()), a(i2, n() + q() + rect.height(), l()));
        }

        public void a(Parcelable parcelable) {
        }

        public void a(f fVar, f fVar2) {
        }

        public void a(u uVar, z zVar, View view, la laVar) {
        }

        public void a(nf nfVar, int i, int i2) {
        }

        public void a(nf nfVar, int i, int i2, int i3) {
        }

        public boolean a() {
            return false;
        }

        public boolean a(o oVar) {
            return oVar != null;
        }

        public int b(int i, u uVar, z zVar) {
            return 0;
        }

        public int b(u uVar, z zVar) {
            return -1;
        }

        public int b(z zVar) {
            return 0;
        }

        public void b(nf nfVar) {
        }

        public void b(nf nfVar, int i, int i2) {
        }

        public void b(nf nfVar, u uVar) {
            C();
        }

        public boolean b() {
            return false;
        }

        public int c(z zVar) {
            return 0;
        }

        public abstract o c();

        public void c(u uVar) {
            int size = uVar.a.size();
            for (int i = size - 1; i >= 0; i--) {
                View view = uVar.a.get(i).a;
                c0 l = nf.l(view);
                if (!l.o()) {
                    l.a(false);
                    if (l.l()) {
                        this.b.removeDetachedView(view, false);
                    }
                    k kVar = this.b.O;
                    if (kVar != null) {
                        kVar.b(l);
                    }
                    l.a(true);
                    c0 l2 = nf.l(view);
                    l2.n = null;
                    l2.o = false;
                    l2.b();
                    uVar.a(l2);
                }
            }
            uVar.a.clear();
            ArrayList<c0> arrayList = uVar.b;
            if (arrayList != null) {
                arrayList.clear();
            }
            if (size > 0) {
                this.b.invalidate();
            }
        }

        public int d() {
            return -1;
        }

        public int d(z zVar) {
            return 0;
        }

        public View d(int i) {
            int e = e();
            for (int i2 = 0; i2 < e; i2++) {
                View e2 = e(i2);
                c0 l = nf.l(e2);
                if (l != null && l.d() == i && !l.o() && (this.b.i0.h || !l.j())) {
                    return e2;
                }
            }
            return null;
        }

        public int e(z zVar) {
            return 0;
        }

        public void e(nf nfVar) {
            if (nfVar == null) {
                this.b = null;
                this.a = null;
                this.q = 0;
                this.r = 0;
            } else {
                this.b = nfVar;
                this.a = nfVar.g;
                this.q = nfVar.getWidth();
                this.r = nfVar.getHeight();
            }
            this.o = 1073741824;
            this.p = 1073741824;
        }

        public int f(z zVar) {
            return 0;
        }

        public boolean f() {
            nf nfVar = this.b;
            return nfVar != null && nfVar.i;
        }

        public View g() {
            View focusedChild;
            nf nfVar = this.b;
            if (nfVar == null || (focusedChild = nfVar.getFocusedChild()) == null || this.a.c.contains(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public void g(z zVar) {
        }

        public int h() {
            return this.r;
        }

        public void h(int i) {
        }

        public int i() {
            return this.p;
        }

        public void j(int i) {
            ye yeVar;
            int c2;
            View a2;
            if (e(i) == null || (a2 = ((of) yeVar.a).a((c2 = (yeVar = this.a).c(i)))) == null) {
                return;
            }
            if (yeVar.b.d(c2)) {
                yeVar.c(a2);
            }
            ((of) yeVar.a).b(c2);
        }

        public int k() {
            return y9.h(this.b);
        }

        public void k(int i) {
        }

        public int l(View view) {
            return ((o) view.getLayoutParams()).a();
        }

        public int m(View view) {
            return ((o) view.getLayoutParams()).b.right;
        }

        public int n() {
            nf nfVar = this.b;
            if (nfVar != null) {
                return nfVar.getPaddingBottom();
            }
            return 0;
        }

        public void o(View view) {
            ye yeVar = this.a;
            int indexOfChild = ((of) yeVar.a).a.indexOfChild(view);
            if (indexOfChild < 0) {
                return;
            }
            if (yeVar.b.d(indexOfChild)) {
                yeVar.c(view);
            }
            ((of) yeVar.a).b(indexOfChild);
        }

        public int p() {
            nf nfVar = this.b;
            if (nfVar != null) {
                return nfVar.getPaddingRight();
            }
            return 0;
        }

        public int q() {
            nf nfVar = this.b;
            if (nfVar != null) {
                return nfVar.getPaddingTop();
            }
            return 0;
        }

        public int r() {
            return 0;
        }

        public int s() {
            return this.q;
        }

        public int t() {
            return this.o;
        }

        public boolean u() {
            int e = e();
            for (int i = 0; i < e; i++) {
                ViewGroup.LayoutParams layoutParams = e(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public boolean v() {
            return this.i;
        }

        public boolean w() {
            return this.j;
        }

        public final boolean x() {
            return this.l;
        }

        public boolean y() {
            return false;
        }

        public boolean z() {
            y yVar = this.g;
            return yVar != null && yVar.isRunning();
        }

        public void b(y yVar) {
            y yVar2 = this.g;
            if (yVar2 != null && yVar != yVar2 && yVar2.isRunning()) {
                this.g.stop();
            }
            this.g = yVar;
            this.g.start(this.b, this);
        }

        public void f(int i) {
            nf nfVar = this.b;
            if (nfVar != null) {
                nfVar.e(i);
            }
        }

        public int h(View view) {
            Rect rect = ((o) view.getLayoutParams()).b;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public int i(View view) {
            return m(view) + view.getRight();
        }

        public int k(View view) {
            return ((o) view.getLayoutParams()).b.left;
        }

        public int l() {
            return y9.i(this.b);
        }

        public int m() {
            return y9.j(this.b);
        }

        public int n(View view) {
            return ((o) view.getLayoutParams()).b.top;
        }

        public boolean i(int i) {
            int i2;
            int s;
            nf nfVar = this.b;
            if (nfVar == null) {
                return false;
            }
            if (i == 4096) {
                int h = nfVar.canScrollVertically(1) ? (h() - q()) - n() : 0;
                if (this.b.canScrollHorizontally(1)) {
                    i2 = h;
                    s = (s() - o()) - p();
                } else {
                    i2 = h;
                    s = 0;
                }
            } else if (i != 8192) {
                s = 0;
                i2 = 0;
            } else {
                int i3 = nfVar.canScrollVertically(-1) ? -((h() - q()) - n()) : 0;
                if (this.b.canScrollHorizontally(-1)) {
                    s = -((s() - o()) - p());
                    i2 = i3;
                } else {
                    i2 = i3;
                    s = 0;
                }
            }
            if (i2 == 0 && s == 0) {
                return false;
            }
            this.b.a(s, i2, (Interpolator) null, Integer.MIN_VALUE, true);
            return true;
        }

        public int f(View view) {
            return view.getLeft() - k(view);
        }

        public void g(int i) {
            nf nfVar = this.b;
            if (nfVar != null) {
                nfVar.f(i);
            }
        }

        public static int a(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            if (mode != Integer.MIN_VALUE) {
                return mode != 1073741824 ? Math.max(i2, i3) : size;
            }
            return Math.min(size, Math.max(i2, i3));
        }

        public void b(View view) {
            b(view, -1);
        }

        public int d(View view) {
            return ((o) view.getLayoutParams()).b.bottom;
        }

        public int g(View view) {
            Rect rect = ((o) view.getLayoutParams()).b;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public int o() {
            nf nfVar = this.b;
            if (nfVar != null) {
                return nfVar.getPaddingLeft();
            }
            return 0;
        }

        public void b(View view, int i) {
            a(view, i, false);
        }

        public void d(int i, int i2) {
            this.b.setMeasuredDimension(i, i2);
        }

        public int j() {
            nf nfVar = this.b;
            f adapter = nfVar != null ? nfVar.getAdapter() : null;
            if (adapter != null) {
                return adapter.a();
            }
            return 0;
        }

        public void b(int i) {
            e(i);
            c(i);
        }

        public void d(nf nfVar) {
            c(View.MeasureSpec.makeMeasureSpec(nfVar.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(nfVar.getHeight(), 1073741824));
        }

        public void a(String str) {
            nf nfVar = this.b;
            if (nfVar != null) {
                nfVar.e(str);
            }
        }

        public boolean b(View view, int i, int i2, o oVar) {
            return (this.k && b(view.getMeasuredWidth(), i, ((ViewGroup.MarginLayoutParams) oVar).width) && b(view.getMeasuredHeight(), i2, ((ViewGroup.MarginLayoutParams) oVar).height)) ? false : true;
        }

        public int j(View view) {
            return view.getTop() - n(view);
        }

        public void e(int i, int i2) {
            int e = e();
            if (e == 0) {
                this.b.c(i, i2);
                return;
            }
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MIN_VALUE;
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MAX_VALUE;
            for (int i7 = 0; i7 < e; i7++) {
                View e2 = e(i7);
                Rect rect = this.b.j;
                b(e2, rect);
                int i8 = rect.left;
                if (i8 < i3) {
                    i3 = i8;
                }
                int i9 = rect.right;
                if (i9 > i4) {
                    i4 = i9;
                }
                int i10 = rect.top;
                if (i10 < i6) {
                    i6 = i10;
                }
                int i11 = rect.bottom;
                if (i11 > i5) {
                    i5 = i11;
                }
            }
            this.b.j.set(i3, i6, i4, i5);
            a(this.b.j, i, i2);
        }

        public void a(nf nfVar) {
            this.i = true;
            B();
        }

        public static boolean b(int i, int i2, int i3) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            if (i3 <= 0 || i == i3) {
                if (mode == Integer.MIN_VALUE) {
                    return size >= i;
                } else if (mode != 0) {
                    return mode == 1073741824 && size == i;
                } else {
                    return true;
                }
            }
            return false;
        }

        public void a(nf nfVar, u uVar) {
            this.i = false;
            b(nfVar, uVar);
        }

        public void b(View view, Rect rect) {
            nf.a(view, rect);
        }

        public boolean a(Runnable runnable) {
            nf nfVar = this.b;
            if (nfVar != null) {
                return nfVar.removeCallbacks(runnable);
            }
            return false;
        }

        public void b(int i, int i2) {
            this.b.c(i, i2);
        }

        public void b(u uVar) {
            for (int e = e() - 1; e >= 0; e--) {
                if (!nf.l(e(e)).o()) {
                    a(e, uVar);
                }
            }
        }

        public o a(ViewGroup.LayoutParams layoutParams) {
            if (layoutParams instanceof o) {
                return new o((o) layoutParams);
            }
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                return new o((ViewGroup.MarginLayoutParams) layoutParams);
            }
            return new o(layoutParams);
        }

        public void c(int i, int i2) {
            this.q = View.MeasureSpec.getSize(i);
            this.o = View.MeasureSpec.getMode(i);
            if (this.o == 0 && !nf.D0) {
                this.q = 0;
            }
            this.r = View.MeasureSpec.getSize(i2);
            this.p = View.MeasureSpec.getMode(i2);
            if (this.p != 0 || nf.D0) {
                return;
            }
            this.r = 0;
        }

        public void b(AccessibilityEvent accessibilityEvent) {
            nf nfVar = this.b;
            if (nfVar == null || accessibilityEvent == null) {
                return;
            }
            boolean z = true;
            if (!nfVar.canScrollVertically(1) && !this.b.canScrollVertically(-1) && !this.b.canScrollHorizontally(-1) && !this.b.canScrollHorizontally(1)) {
                z = false;
            }
            accessibilityEvent.setScrollable(z);
            f fVar = this.b.m;
            if (fVar != null) {
                accessibilityEvent.setItemCount(fVar.a());
            }
        }

        public int e() {
            ye yeVar = this.a;
            if (yeVar != null) {
                return yeVar.a();
            }
            return 0;
        }

        public o a(Context context, AttributeSet attributeSet) {
            return new o(context, attributeSet);
        }

        public View e(int i) {
            ye yeVar = this.a;
            if (yeVar != null) {
                return ((of) yeVar.a).a(yeVar.c(i));
            }
            return null;
        }

        public void a(nf nfVar, z zVar, int i) {
            Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void a(View view) {
            a(view, -1);
        }

        public void a(View view, int i) {
            a(view, i, true);
        }

        public int e(View view) {
            return d(view) + view.getBottom();
        }

        public final void a(View view, int i, boolean z) {
            c0 l = nf.l(view);
            if (!z && !l.j()) {
                this.b.h.c(l);
            } else {
                this.b.h.a(l);
            }
            o oVar = (o) view.getLayoutParams();
            if (!l.p() && !l.k()) {
                if (view.getParent() == this.b) {
                    int a2 = this.a.a(view);
                    if (i == -1) {
                        i = this.a.a();
                    }
                    if (a2 == -1) {
                        StringBuilder a3 = jg.a("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
                        a3.append(this.b.indexOfChild(view));
                        throw new IllegalStateException(jg.a(this.b, a3));
                    } else if (a2 != i) {
                        this.b.n.a(a2, i);
                    }
                } else {
                    this.a.a(view, i, false);
                    oVar.c = true;
                    y yVar = this.g;
                    if (yVar != null && yVar.isRunning()) {
                        this.g.onChildAttachedToWindow(view);
                    }
                }
            } else {
                if (l.k()) {
                    l.n.b(l);
                } else {
                    l.b();
                }
                this.a.a(view, i, view.getLayoutParams(), false);
            }
            if (oVar.d) {
                l.a.invalidate();
                oVar.d = false;
            }
        }

        public void c(u uVar, z zVar) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        public View c(View view) {
            View d2;
            nf nfVar = this.b;
            if (nfVar == null || (d2 = nfVar.d(view)) == null || this.a.c.contains(d2)) {
                return null;
            }
            return d2;
        }

        public final void c(int i) {
            this.a.a(i);
        }

        public void c(View view, int i) {
            a(view, i, (o) view.getLayoutParams());
        }

        @Deprecated
        public boolean c(nf nfVar) {
            return z() || nfVar.J();
        }

        public void a(View view, int i, o oVar) {
            c0 l = nf.l(view);
            if (l.j()) {
                this.b.h.a(l);
            } else {
                this.b.h.c(l);
            }
            this.a.a(view, i, oVar, l.j());
        }

        public void a(int i, int i2) {
            View e = e(i);
            if (e != null) {
                b(i);
                c(e, i2);
                return;
            }
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.b.toString());
        }

        public void a(View view, u uVar) {
            o(view);
            uVar.a(view);
        }

        public void a(int i, u uVar) {
            View e = e(i);
            j(i);
            uVar.a(e);
        }

        public void a(u uVar) {
            for (int e = e() - 1; e >= 0; e--) {
                View e2 = e(e);
                c0 l = nf.l(e2);
                if (!l.o()) {
                    if (l.h() && !l.j() && !this.b.m.b) {
                        j(e);
                        uVar.a(l);
                    } else {
                        b(e);
                        uVar.b(e2);
                        this.b.h.c(l);
                    }
                }
            }
        }

        public boolean a(View view, int i, int i2, o oVar) {
            return (!view.isLayoutRequested() && this.k && b(view.getWidth(), i, ((ViewGroup.MarginLayoutParams) oVar).width) && b(view.getHeight(), i2, ((ViewGroup.MarginLayoutParams) oVar).height)) ? false : true;
        }

        public void a(View view, int i, int i2) {
            o oVar = (o) view.getLayoutParams();
            Rect i3 = this.b.i(view);
            int i4 = i3.left + i3.right + i;
            int i5 = i3.top + i3.bottom + i2;
            int a2 = a(s(), t(), p() + o() + ((ViewGroup.MarginLayoutParams) oVar).leftMargin + ((ViewGroup.MarginLayoutParams) oVar).rightMargin + i4, ((ViewGroup.MarginLayoutParams) oVar).width, a());
            int a3 = a(h(), i(), n() + q() + ((ViewGroup.MarginLayoutParams) oVar).topMargin + ((ViewGroup.MarginLayoutParams) oVar).bottomMargin + i5, ((ViewGroup.MarginLayoutParams) oVar).height, b());
            if (a(view, a2, a3, oVar)) {
                view.measure(a2, a3);
            }
        }

        public static int a(int i, int i2, int i3, int i4, boolean z) {
            int i5;
            int i6 = i - i3;
            int i7 = 0;
            int max = Math.max(0, i6);
            if (z) {
                if (i4 < 0) {
                    if (i4 == -1) {
                        if (i2 == Integer.MIN_VALUE || (i2 != 0 && i2 == 1073741824)) {
                            i5 = max;
                        } else {
                            i2 = 0;
                            i5 = 0;
                        }
                        i7 = i2;
                        max = i5;
                    }
                    max = 0;
                }
                max = i4;
                i7 = 1073741824;
            } else {
                if (i4 < 0) {
                    if (i4 == -1) {
                        i7 = i2;
                    } else {
                        if (i4 == -2) {
                            if (i2 == Integer.MIN_VALUE || i2 == 1073741824) {
                                i7 = Integer.MIN_VALUE;
                            }
                        }
                        max = 0;
                    }
                }
                max = i4;
                i7 = 1073741824;
            }
            return View.MeasureSpec.makeMeasureSpec(max, i7);
        }

        public void a(View view, int i, int i2, int i3, int i4) {
            o oVar = (o) view.getLayoutParams();
            Rect rect = oVar.b;
            view.layout(i + rect.left + ((ViewGroup.MarginLayoutParams) oVar).leftMargin, i2 + rect.top + ((ViewGroup.MarginLayoutParams) oVar).topMargin, (i3 - rect.right) - ((ViewGroup.MarginLayoutParams) oVar).rightMargin, (i4 - rect.bottom) - ((ViewGroup.MarginLayoutParams) oVar).bottomMargin);
        }

        public void a(View view, boolean z, Rect rect) {
            Matrix matrix;
            if (z) {
                Rect rect2 = ((o) view.getLayoutParams()).b;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (this.b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
                RectF rectF = this.b.l;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void a(View view, Rect rect) {
            nf nfVar = this.b;
            if (nfVar == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(nfVar.i(view));
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x00bb, code lost:
            if (r14 == false) goto L13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean a(defpackage.nf r10, android.view.View r11, android.graphics.Rect r12, boolean r13, boolean r14) {
            /*
                r9 = this;
                r0 = 2
                int[] r0 = new int[r0]
                int r1 = r9.o()
                int r2 = r9.q()
                int r3 = r9.s()
                int r4 = r9.p()
                int r3 = r3 - r4
                int r4 = r9.h()
                int r5 = r9.n()
                int r4 = r4 - r5
                int r5 = r11.getLeft()
                int r6 = r12.left
                int r5 = r5 + r6
                int r6 = r11.getScrollX()
                int r5 = r5 - r6
                int r6 = r11.getTop()
                int r7 = r12.top
                int r6 = r6 + r7
                int r11 = r11.getScrollY()
                int r6 = r6 - r11
                int r11 = r12.width()
                int r11 = r11 + r5
                int r12 = r12.height()
                int r12 = r12 + r6
                int r5 = r5 - r1
                r1 = 0
                int r7 = java.lang.Math.min(r1, r5)
                int r6 = r6 - r2
                int r2 = java.lang.Math.min(r1, r6)
                int r11 = r11 - r3
                int r3 = java.lang.Math.max(r1, r11)
                int r12 = r12 - r4
                int r12 = java.lang.Math.max(r1, r12)
                int r4 = r9.k()
                r8 = 1
                if (r4 != r8) goto L63
                if (r3 == 0) goto L5e
                goto L6b
            L5e:
                int r3 = java.lang.Math.max(r7, r11)
                goto L6b
            L63:
                if (r7 == 0) goto L66
                goto L6a
            L66:
                int r7 = java.lang.Math.min(r5, r3)
            L6a:
                r3 = r7
            L6b:
                if (r2 == 0) goto L6e
                goto L72
            L6e:
                int r2 = java.lang.Math.min(r6, r12)
            L72:
                r0[r1] = r3
                r0[r8] = r2
                r11 = r0[r1]
                r12 = r0[r8]
                if (r14 == 0) goto Lbd
                android.view.View r14 = r10.getFocusedChild()
                if (r14 != 0) goto L84
            L82:
                r14 = r1
                goto Lbb
            L84:
                int r0 = r9.o()
                int r2 = r9.q()
                int r3 = r9.s()
                int r4 = r9.p()
                int r3 = r3 - r4
                int r4 = r9.h()
                int r5 = r9.n()
                int r4 = r4 - r5
                nf r5 = r9.b
                android.graphics.Rect r5 = r5.j
                r9.b(r14, r5)
                int r14 = r5.left
                int r14 = r14 - r11
                if (r14 >= r3) goto L82
                int r14 = r5.right
                int r14 = r14 - r11
                if (r14 <= r0) goto L82
                int r14 = r5.top
                int r14 = r14 - r12
                if (r14 >= r4) goto L82
                int r14 = r5.bottom
                int r14 = r14 - r12
                if (r14 > r2) goto Lba
                goto L82
            Lba:
                r14 = r8
            Lbb:
                if (r14 == 0) goto Lc2
            Lbd:
                if (r11 != 0) goto Lc3
                if (r12 == 0) goto Lc2
                goto Lc3
            Lc2:
                return r1
            Lc3:
                if (r13 == 0) goto Lc9
                r10.scrollBy(r11, r12)
                goto Lcc
            Lc9:
                r10.h(r11, r12)
            Lcc:
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.nf.n.a(nf, android.view.View, android.graphics.Rect, boolean, boolean):boolean");
        }

        public boolean a(nf nfVar, View view, Rect rect, boolean z) {
            return a(nfVar, view, rect, z, false);
        }

        public boolean a(View view, boolean z) {
            boolean z2 = this.e.a(view, 24579) && this.f.a(view, 24579);
            return z ? z2 : !z2;
        }

        public boolean a(nf nfVar, View view, View view2) {
            return c(nfVar);
        }

        public void a(nf nfVar, int i, int i2, Object obj) {
            E();
        }

        public void a(y yVar) {
            if (this.g == yVar) {
                this.g = null;
            }
        }

        public void a(la laVar) {
            nf nfVar = this.b;
            a(nfVar.d, nfVar.i0, laVar);
        }

        public void a(u uVar, z zVar, la laVar) {
            if (this.b.canScrollVertically(-1) || this.b.canScrollHorizontally(-1)) {
                laVar.a.addAction(WebpBitmapFactory.IN_TEMP_BUFFER_SIZE);
                laVar.a.setScrollable(true);
            }
            if (this.b.canScrollVertically(1) || this.b.canScrollHorizontally(1)) {
                laVar.a.addAction(4096);
                laVar.a.setScrollable(true);
            }
            int b2 = b(uVar, zVar);
            int a2 = a(uVar, zVar);
            boolean y = y();
            int r = r();
            int i = Build.VERSION.SDK_INT;
            laVar.a(new la.b(AccessibilityNodeInfo.CollectionInfo.obtain(b2, a2, y, r)));
        }

        public void a(AccessibilityEvent accessibilityEvent) {
            nf nfVar = this.b;
            u uVar = nfVar.d;
            z zVar = nfVar.i0;
            b(accessibilityEvent);
        }

        public void a(View view, la laVar) {
            c0 l = nf.l(view);
            if (l == null || l.j() || this.a.b(l.a)) {
                return;
            }
            nf nfVar = this.b;
            a(nfVar.d, nfVar.i0, view, laVar);
        }

        public boolean a(int i, Bundle bundle) {
            nf nfVar = this.b;
            u uVar = nfVar.d;
            z zVar = nfVar.i0;
            return i(i);
        }

        public boolean a(View view, int i, Bundle bundle) {
            nf nfVar = this.b;
            u uVar = nfVar.d;
            z zVar = nfVar.i0;
            return G();
        }

        public static d a(Context context, AttributeSet attributeSet, int i, int i2) {
            d dVar = new d();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, we.RecyclerView, i, i2);
            dVar.a = obtainStyledAttributes.getInt(we.RecyclerView_android_orientation, 1);
            dVar.b = obtainStyledAttributes.getInt(we.RecyclerView_spanCount, 1);
            dVar.c = obtainStyledAttributes.getBoolean(we.RecyclerView_reverseLayout, false);
            dVar.d = obtainStyledAttributes.getBoolean(we.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return dVar;
        }
    }

    /* compiled from: RecyclerView.java */
    /* renamed from: nf$p */
    /* loaded from: classes.dex */
    public interface p {
        void a(View view);

        void b(View view);
    }

    /* compiled from: RecyclerView.java */
    /* renamed from: nf$q */
    /* loaded from: classes.dex */
    public static abstract class q {
    }

    /* compiled from: RecyclerView.java */
    /* renamed from: nf$r */
    /* loaded from: classes.dex */
    public interface r {
    }

    /* compiled from: RecyclerView.java */
    /* renamed from: nf$s */
    /* loaded from: classes.dex */
    public static abstract class s {
        public void onScrollStateChanged(nf nfVar, int i) {
        }

        public void onScrolled(nf nfVar, int i, int i2) {
        }
    }

    /* compiled from: RecyclerView.java */
    /* renamed from: nf$t */
    /* loaded from: classes.dex */
    public static class t {
        public SparseArray<a> a = new SparseArray<>();
        public int b = 0;

        /* compiled from: RecyclerView.java */
        /* renamed from: nf$t$a */
        /* loaded from: classes.dex */
        public static class a {
            public final ArrayList<c0> a = new ArrayList<>();
            public int b = 5;
            public long c = 0;
            public long d = 0;
        }

        public long a(long j, long j2) {
            if (j == 0) {
                return j2;
            }
            return (j2 / 4) + ((j / 4) * 3);
        }

        public void b() {
            this.b--;
        }

        public void a() {
            this.b++;
        }

        public void a(f fVar, f fVar2, boolean z) {
            if (fVar != null) {
                this.b--;
            }
            if (!z && this.b == 0) {
                for (int i = 0; i < this.a.size(); i++) {
                    this.a.valueAt(i).a.clear();
                }
            }
            if (fVar2 != null) {
                this.b++;
            }
        }

        public final a a(int i) {
            a aVar = this.a.get(i);
            if (aVar == null) {
                a aVar2 = new a();
                this.a.put(i, aVar2);
                return aVar2;
            }
            return aVar;
        }

        public void a(c0 c0Var) {
            int i = c0Var.f;
            ArrayList<c0> arrayList = a(i).a;
            if (this.a.get(i).b <= arrayList.size()) {
                return;
            }
            c0Var.n();
            arrayList.add(c0Var);
        }
    }

    /* compiled from: RecyclerView.java */
    /* renamed from: nf$v */
    /* loaded from: classes.dex */
    public interface v {
        void a(c0 c0Var);
    }

    /* compiled from: RecyclerView.java */
    /* renamed from: nf$w */
    /* loaded from: classes.dex */
    public class w extends h {
        public w() {
        }

        @Override // defpackage.nf.h
        public void a() {
            nf.this.e((String) null);
            nf nfVar = nf.this;
            nfVar.i0.g = true;
            nfVar.d(true);
            if (nf.this.f.c()) {
                return;
            }
            nf.this.requestLayout();
        }
    }

    /* compiled from: RecyclerView.java */
    /* renamed from: nf$y */
    /* loaded from: classes.dex */
    public static abstract class y {
        public n mLayoutManager;
        public boolean mPendingInitialRun;
        public nf mRecyclerView;
        public boolean mRunning;
        public boolean mStarted;
        public View mTargetView;
        public int mTargetPosition = -1;
        public final a mRecyclingAction = new a(0, 0);

        /* compiled from: RecyclerView.java */
        /* renamed from: nf$y$a */
        /* loaded from: classes.dex */
        public static class a {
            public int a;
            public int b;
            public int d = -1;
            public boolean f = false;
            public int g = 0;
            public int c = Integer.MIN_VALUE;
            public Interpolator e = null;

            public a(int i, int i2) {
                this.a = i;
                this.b = i2;
            }

            public void a(nf nfVar) {
                int i = this.d;
                if (i >= 0) {
                    this.d = -1;
                    nfVar.d(i);
                    this.f = false;
                } else if (this.f) {
                    if (this.e != null && this.c < 1) {
                        throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                    }
                    int i2 = this.c;
                    if (i2 >= 1) {
                        nfVar.f0.a(this.a, this.b, i2, this.e);
                        this.g++;
                        if (this.g > 10) {
                            Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                        }
                        this.f = false;
                        return;
                    }
                    throw new IllegalStateException("Scroll duration must be a positive number");
                } else {
                    this.g = 0;
                }
            }
        }

        /* compiled from: RecyclerView.java */
        /* renamed from: nf$y$b */
        /* loaded from: classes.dex */
        public interface b {
            PointF a(int i);
        }

        public PointF computeScrollVectorForPosition(int i) {
            n layoutManager = getLayoutManager();
            if (layoutManager instanceof b) {
                return ((b) layoutManager).a(i);
            }
            StringBuilder a2 = jg.a("You should override computeScrollVectorForPosition when the LayoutManager does not implement ");
            a2.append(b.class.getCanonicalName());
            Log.w("RecyclerView", a2.toString());
            return null;
        }

        public View findViewByPosition(int i) {
            return this.mRecyclerView.n.d(i);
        }

        public int getChildCount() {
            return this.mRecyclerView.n.e();
        }

        public int getChildPosition(View view) {
            return this.mRecyclerView.g(view);
        }

        public n getLayoutManager() {
            return this.mLayoutManager;
        }

        public int getTargetPosition() {
            return this.mTargetPosition;
        }

        @Deprecated
        public void instantScrollToPosition(int i) {
            this.mRecyclerView.g(i);
        }

        public boolean isPendingInitialRun() {
            return this.mPendingInitialRun;
        }

        public boolean isRunning() {
            return this.mRunning;
        }

        public void normalize(PointF pointF) {
            float f = pointF.x;
            float f2 = pointF.y;
            float sqrt = (float) Math.sqrt((f2 * f2) + (f * f));
            pointF.x /= sqrt;
            pointF.y /= sqrt;
        }

        public void onAnimation(int i, int i2) {
            PointF computeScrollVectorForPosition;
            nf nfVar = this.mRecyclerView;
            if (this.mTargetPosition == -1 || nfVar == null) {
                stop();
            }
            if (this.mPendingInitialRun && this.mTargetView == null && this.mLayoutManager != null && (computeScrollVectorForPosition = computeScrollVectorForPosition(this.mTargetPosition)) != null && (computeScrollVectorForPosition.x != XToggleDrawable.LIGHT_RADIUS_DEFAULT || computeScrollVectorForPosition.y != XToggleDrawable.LIGHT_RADIUS_DEFAULT)) {
                nfVar.a((int) Math.signum(computeScrollVectorForPosition.x), (int) Math.signum(computeScrollVectorForPosition.y), (int[]) null);
            }
            this.mPendingInitialRun = false;
            View view = this.mTargetView;
            if (view != null) {
                if (getChildPosition(view) == this.mTargetPosition) {
                    onTargetFound(this.mTargetView, nfVar.i0, this.mRecyclingAction);
                    this.mRecyclingAction.a(nfVar);
                    stop();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.mTargetView = null;
                }
            }
            if (this.mRunning) {
                onSeekTargetStep(i, i2, nfVar.i0, this.mRecyclingAction);
                boolean z = this.mRecyclingAction.d >= 0;
                this.mRecyclingAction.a(nfVar);
                if (z && this.mRunning) {
                    this.mPendingInitialRun = true;
                    nfVar.f0.a();
                }
            }
        }

        public void onChildAttachedToWindow(View view) {
            if (getChildPosition(view) == getTargetPosition()) {
                this.mTargetView = view;
            }
        }

        public abstract void onSeekTargetStep(int i, int i2, z zVar, a aVar);

        public abstract void onStart();

        public abstract void onStop();

        public abstract void onTargetFound(View view, z zVar, a aVar);

        public void setTargetPosition(int i) {
            this.mTargetPosition = i;
        }

        public void start(nf nfVar, n nVar) {
            nfVar.f0.b();
            if (this.mStarted) {
                StringBuilder a2 = jg.a("An instance of ");
                a2.append(getClass().getSimpleName());
                a2.append(" was started more than once. Each instance of");
                a2.append(getClass().getSimpleName());
                a2.append(" is intended to only be used once. You should create a new instance for each use.");
                Log.w("RecyclerView", a2.toString());
            }
            this.mRecyclerView = nfVar;
            this.mLayoutManager = nVar;
            int i = this.mTargetPosition;
            if (i != -1) {
                this.mRecyclerView.i0.a = i;
                this.mRunning = true;
                this.mPendingInitialRun = true;
                this.mTargetView = findViewByPosition(getTargetPosition());
                onStart();
                this.mRecyclerView.f0.a();
                this.mStarted = true;
                return;
            }
            throw new IllegalArgumentException("Invalid target position");
        }

        public final void stop() {
            if (this.mRunning) {
                this.mRunning = false;
                onStop();
                this.mRecyclerView.i0.a = -1;
                this.mTargetView = null;
                this.mTargetPosition = -1;
                this.mPendingInitialRun = false;
                this.mLayoutManager.a(this);
                this.mLayoutManager = null;
                this.mRecyclerView = null;
            }
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        C0 = false;
        D0 = true;
        E0 = true;
        F0 = false;
        G0 = false;
        Class<?> cls = Integer.TYPE;
        H0 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        I0 = new c();
    }

    public nf(Context context) {
        this(context, null);
    }

    private n9 getScrollingChildHelper() {
        if (this.r0 == null) {
            this.r0 = new n9(this);
        }
        return this.r0;
    }

    public static nf k(View view) {
        if (view instanceof ViewGroup) {
            if (view instanceof nf) {
                return (nf) view;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                nf k2 = k(viewGroup.getChildAt(i2));
                if (k2 != null) {
                    return k2;
                }
            }
            return null;
        }
        return null;
    }

    public static c0 l(View view) {
        if (view == null) {
            return null;
        }
        return ((o) view.getLayoutParams()).a;
    }

    public void A() {
        if (this.N != null) {
            return;
        }
        this.N = this.J.a(this);
        if (this.i) {
            this.N.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            this.N.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void B() {
        if (this.K != null) {
            return;
        }
        this.K = this.J.a(this);
        if (this.i) {
            this.K.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            this.K.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public void C() {
        if (this.M != null) {
            return;
        }
        this.M = this.J.a(this);
        if (this.i) {
            this.M.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            this.M.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public void D() {
        if (this.L != null) {
            return;
        }
        this.L = this.J.a(this);
        if (this.i) {
            this.L.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            this.L.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public String E() {
        StringBuilder a2 = jg.a(" ");
        a2.append(super.toString());
        a2.append(", adapter:");
        a2.append(this.m);
        a2.append(", layout:");
        a2.append(this.n);
        a2.append(", context:");
        a2.append(getContext());
        return a2.toString();
    }

    public boolean F() {
        return !this.w || this.F || this.f.c();
    }

    public void G() {
        this.f = new xe(new e());
    }

    public void H() {
        this.N = null;
        this.L = null;
        this.M = null;
        this.K = null;
    }

    public boolean I() {
        AccessibilityManager accessibilityManager = this.D;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public boolean J() {
        return this.H > 0;
    }

    public void K() {
        int b2 = this.g.b();
        for (int i2 = 0; i2 < b2; i2++) {
            ((o) this.g.d(i2).getLayoutParams()).c = true;
        }
        u uVar = this.d;
        int size = uVar.c.size();
        for (int i3 = 0; i3 < size; i3++) {
            o oVar = (o) uVar.c.get(i3).a.getLayoutParams();
            if (oVar != null) {
                oVar.c = true;
            }
        }
    }

    public void L() {
        int b2 = this.g.b();
        for (int i2 = 0; i2 < b2; i2++) {
            c0 l2 = l(this.g.d(i2));
            if (l2 != null && !l2.o()) {
                l2.a(6);
            }
        }
        K();
        u uVar = this.d;
        int size = uVar.c.size();
        for (int i3 = 0; i3 < size; i3++) {
            c0 c0Var = uVar.c.get(i3);
            if (c0Var != null) {
                c0Var.a(6);
                c0Var.a((Object) null);
            }
        }
        f fVar = nf.this.m;
        if (fVar == null || !fVar.b) {
            uVar.c();
        }
    }

    public void M() {
    }

    public void N() {
    }

    public void O() {
        this.H++;
    }

    public void P() {
        c(true);
    }

    public void Q() {
    }

    public void R() {
    }

    public void S() {
        if (this.o0 || !this.t) {
            return;
        }
        y9.a(this, this.w0);
        this.o0 = true;
    }

    public final void T() {
        boolean z2 = false;
        if (this.F) {
            xe xeVar = this.f;
            xeVar.a(xeVar.b);
            xeVar.a(xeVar.c);
            xeVar.h = 0;
            if (this.G) {
                this.n.b(this);
            }
        }
        if (this.O != null && this.n.L()) {
            this.f.d();
        } else {
            this.f.b();
        }
        boolean z3 = this.l0 || this.m0;
        this.i0.k = this.w && this.O != null && (this.F || z3 || this.n.h) && (!this.F || this.m.b);
        z zVar = this.i0;
        if (zVar.k && z3 && !this.F) {
            if (this.O != null && this.n.L()) {
                z2 = true;
            }
        }
        zVar.l = z2;
    }

    public void U() {
        k kVar = this.O;
        if (kVar != null) {
            kVar.b();
        }
        n nVar = this.n;
        if (nVar != null) {
            nVar.b(this.d);
            this.n.c(this.d);
        }
        this.d.a();
    }

    public void V() {
        c0 c0Var;
        int a2 = this.g.a();
        for (int i2 = 0; i2 < a2; i2++) {
            View b2 = this.g.b(i2);
            c0 h2 = h(b2);
            if (h2 != null && (c0Var = h2.i) != null) {
                View view = c0Var.a;
                int left = b2.getLeft();
                int top = b2.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    public final void W() {
        z zVar = this.i0;
        zVar.n = -1L;
        zVar.m = -1;
        zVar.o = -1;
    }

    public final void X() {
        VelocityTracker velocityTracker = this.R;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        boolean z2 = false;
        i(0);
        EdgeEffect edgeEffect = this.K;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z2 = this.K.isFinished();
        }
        EdgeEffect edgeEffect2 = this.L;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z2 |= this.L.isFinished();
        }
        EdgeEffect edgeEffect3 = this.M;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z2 |= this.M.isFinished();
        }
        EdgeEffect edgeEffect4 = this.N;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z2 |= this.N.isFinished();
        }
        if (z2) {
            y9.t(this);
        }
    }

    public void Y() {
        int b2 = this.g.b();
        for (int i2 = 0; i2 < b2; i2++) {
            c0 l2 = l(this.g.d(i2));
            if (!l2.o() && l2.d == -1) {
                l2.d = l2.c;
            }
        }
    }

    public void Z() {
        this.x++;
        if (this.x != 1 || this.z) {
            return;
        }
        this.y = false;
    }

    public void a0() {
        setScrollState(0);
        this.f0.b();
        n nVar = this.n;
        if (nVar != null) {
            nVar.K();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        n nVar = this.n;
        if (nVar == null || !nVar.A()) {
            super.addFocusables(arrayList, i2, i3);
        }
    }

    public void b(m mVar) {
        n nVar = this.n;
        if (nVar != null) {
            nVar.a("Cannot remove item decoration during a scroll  or layout");
        }
        this.q.remove(mVar);
        if (this.q.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        K();
        requestLayout();
    }

    public void c(int i2, int i3) {
        setMeasuredDimension(n.a(i2, getPaddingRight() + getPaddingLeft(), y9.j(this)), n.a(i3, getPaddingBottom() + getPaddingTop(), y9.i(this)));
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof o) && this.n.a((o) layoutParams);
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        n nVar = this.n;
        if (nVar != null && nVar.a()) {
            return this.n.a(this.i0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        n nVar = this.n;
        if (nVar != null && nVar.a()) {
            return this.n.b(this.i0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        n nVar = this.n;
        if (nVar != null && nVar.a()) {
            return this.n.c(this.i0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        n nVar = this.n;
        if (nVar != null && nVar.b()) {
            return this.n.d(this.i0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        n nVar = this.n;
        if (nVar != null && nVar.b()) {
            return this.n.e(this.i0);
        }
        return 0;
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        n nVar = this.n;
        if (nVar != null && nVar.b()) {
            return this.n.f(this.i0);
        }
        return 0;
    }

    public void d(int i2) {
        if (this.n == null) {
            return;
        }
        setScrollState(2);
        this.n.k(i2);
        awakenScrollBars();
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return getScrollingChildHelper().a(f2, f3, z2);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().a(f2, f3);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().a(i2, i3, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().a(i2, i3, i4, i5, iArr);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        boolean z2;
        boolean z3;
        int i2;
        int i3;
        super.draw(canvas);
        int size = this.q.size();
        boolean z4 = false;
        for (int i4 = 0; i4 < size; i4++) {
            ef efVar = (ef) this.q.get(i4);
            if (efVar.q == efVar.s.getWidth() && efVar.r == efVar.s.getHeight()) {
                if (efVar.A != 0) {
                    if (efVar.t) {
                        int i5 = efVar.q;
                        int i6 = efVar.e;
                        int i7 = i5 - i6;
                        int i8 = efVar.l;
                        int i9 = efVar.k;
                        int i10 = i8 - (i9 / 2);
                        efVar.c.setBounds(0, 0, i6, i9);
                        efVar.d.setBounds(0, 0, efVar.f, efVar.r);
                        if (efVar.b()) {
                            efVar.d.draw(canvas);
                            canvas.translate(efVar.e, i10);
                            canvas.scale(-1.0f, 1.0f);
                            efVar.c.draw(canvas);
                            canvas.scale(-1.0f, 1.0f);
                            canvas.translate(-efVar.e, -i10);
                        } else {
                            canvas.translate(i7, XToggleDrawable.LIGHT_RADIUS_DEFAULT);
                            efVar.d.draw(canvas);
                            canvas.translate(XToggleDrawable.LIGHT_RADIUS_DEFAULT, i10);
                            efVar.c.draw(canvas);
                            canvas.translate(-i7, -i10);
                        }
                    }
                    if (efVar.u) {
                        int i11 = efVar.r;
                        int i12 = efVar.i;
                        int i13 = efVar.o;
                        int i14 = efVar.n;
                        efVar.g.setBounds(0, 0, i14, i12);
                        efVar.h.setBounds(0, 0, efVar.q, efVar.j);
                        canvas.translate(XToggleDrawable.LIGHT_RADIUS_DEFAULT, i11 - i12);
                        efVar.h.draw(canvas);
                        canvas.translate(i13 - (i14 / 2), XToggleDrawable.LIGHT_RADIUS_DEFAULT);
                        efVar.g.draw(canvas);
                        canvas.translate(-i3, -i2);
                    }
                }
            } else {
                efVar.q = efVar.s.getWidth();
                efVar.r = efVar.s.getHeight();
                efVar.a(0);
            }
        }
        EdgeEffect edgeEffect = this.K;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z2 = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.i ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, XToggleDrawable.LIGHT_RADIUS_DEFAULT);
            EdgeEffect edgeEffect2 = this.K;
            z2 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.L;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.i) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.L;
            z2 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.M;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.i ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(paddingTop, -width);
            EdgeEffect edgeEffect6 = this.M;
            z2 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.N;
        if (edgeEffect7 == null || edgeEffect7.isFinished()) {
            z3 = z2;
        } else {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.i) {
                canvas.translate(getPaddingRight() + (-getWidth()), getPaddingBottom() + (-getHeight()));
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.N;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z4 = true;
            }
            z3 = z4 | z2;
            canvas.restoreToCount(save4);
        }
        if (!z3 && this.O != null && this.q.size() > 0 && this.O.d()) {
            z3 = true;
        }
        if (z3) {
            y9.t(this);
        }
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    public void e(boolean z2) {
        if (this.x < 1) {
            this.x = 1;
        }
        if (!z2 && !this.z) {
            this.y = false;
        }
        if (this.x == 1) {
            if (z2 && this.y && !this.z && this.n != null && this.m != null) {
                w();
            }
            if (!this.z) {
                this.y = false;
            }
        }
        this.x--;
    }

    public void f(int i2, int i3) {
        int b2 = this.g.b();
        for (int i4 = 0; i4 < b2; i4++) {
            c0 l2 = l(this.g.d(i4));
            if (l2 != null && !l2.o() && l2.c >= i2) {
                l2.a(i3, false);
                this.i0.g = true;
            }
        }
        u uVar = this.d;
        int size = uVar.c.size();
        for (int i5 = 0; i5 < size; i5++) {
            c0 c0Var = uVar.c.get(i5);
            if (c0Var != null && c0Var.c >= i2) {
                c0Var.a(i3, false);
            }
        }
        requestLayout();
    }

    /* JADX WARN: Code restructure failed: missing block: B:127:0x019a, code lost:
        if (r8 > 0) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x01b4, code lost:
        if (r2 > 0) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x01b7, code lost:
        if (r8 < 0) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x01ba, code lost:
        if (r2 < 0) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x01c2, code lost:
        if ((r2 * r3) <= 0) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x01ca, code lost:
        if ((r2 * r3) >= 0) goto L129;
     */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:152:? A[RETURN, SYNTHETIC] */
    @Override // android.view.ViewGroup, android.view.ViewParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View focusSearch(android.view.View r14, int r15) {
        /*
            Method dump skipped, instructions count: 470
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.nf.focusSearch(android.view.View, int):android.view.View");
    }

    public void g(int i2) {
        if (this.z) {
            return;
        }
        a0();
        n nVar = this.n;
        if (nVar == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        nVar.k(i2);
        awakenScrollBars();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        n nVar = this.n;
        if (nVar != null) {
            return nVar.c();
        }
        throw new IllegalStateException(jg.a(this, jg.a("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        n nVar = this.n;
        if (nVar != null) {
            return nVar.a(getContext(), attributeSet);
        }
        throw new IllegalStateException(jg.a(this, jg.a("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public f getAdapter() {
        return this.m;
    }

    @Override // android.view.View
    public int getBaseline() {
        n nVar = this.n;
        if (nVar != null) {
            return nVar.d();
        }
        return super.getBaseline();
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i2, int i3) {
        return super.getChildDrawingOrder(i2, i3);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.i;
    }

    public pf getCompatAccessibilityDelegate() {
        return this.p0;
    }

    public j getEdgeEffectFactory() {
        return this.J;
    }

    public k getItemAnimator() {
        return this.O;
    }

    public int getItemDecorationCount() {
        return this.q.size();
    }

    public n getLayoutManager() {
        return this.n;
    }

    public int getMaxFlingVelocity() {
        return this.b0;
    }

    public int getMinFlingVelocity() {
        return this.a0;
    }

    public long getNanoTime() {
        if (E0) {
            return System.nanoTime();
        }
        return 0L;
    }

    public q getOnFlingListener() {
        return null;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.e0;
    }

    public t getRecycledViewPool() {
        return this.d.b();
    }

    public int getScrollState() {
        return this.P;
    }

    public void h(int i2) {
        if (this.z) {
            return;
        }
        n nVar = this.n;
        if (nVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            nVar.a(this, this.i0, i2);
        }
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().b(0);
    }

    public Rect i(View view) {
        o oVar = (o) view.getLayoutParams();
        if (!oVar.c) {
            return oVar.b;
        }
        if (this.i0.h && (oVar.b() || oVar.a.h())) {
            return oVar.b;
        }
        Rect rect = oVar.b;
        rect.set(0, 0, 0, 0);
        int size = this.q.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.j.set(0, 0, 0, 0);
            this.q.get(i2).a(this.j, view, this);
            int i3 = rect.left;
            Rect rect2 = this.j;
            rect.left = i3 + rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        oVar.c = false;
        return rect;
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return this.t;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.z;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().d;
    }

    public boolean j(View view) {
        Z();
        ye yeVar = this.g;
        int indexOfChild = ((of) yeVar.a).a.indexOfChild(view);
        boolean z2 = true;
        if (indexOfChild == -1) {
            yeVar.c(view);
        } else if (yeVar.b.c(indexOfChild)) {
            yeVar.b.d(indexOfChild);
            yeVar.c(view);
            ((of) yeVar.a).b(indexOfChild);
        } else {
            z2 = false;
        }
        if (z2) {
            c0 l2 = l(view);
            this.d.b(l2);
            this.d.a(l2);
        }
        e(!z2);
        return z2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004f, code lost:
        if (r0 >= 30.0f) goto L17;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onAttachedToWindow() {
        /*
            r4 = this;
            super.onAttachedToWindow()
            r0 = 0
            r4.H = r0
            r1 = 1
            r4.t = r1
            boolean r2 = r4.w
            if (r2 == 0) goto L14
            boolean r2 = r4.isLayoutRequested()
            if (r2 != 0) goto L14
            goto L15
        L14:
            r1 = r0
        L15:
            r4.w = r1
            nf$n r1 = r4.n
            if (r1 == 0) goto L1e
            r1.a(r4)
        L1e:
            r4.o0 = r0
            boolean r0 = defpackage.nf.E0
            if (r0 == 0) goto L68
            java.lang.ThreadLocal<ff> r0 = defpackage.ff.g
            java.lang.Object r0 = r0.get()
            ff r0 = (defpackage.ff) r0
            r4.g0 = r0
            ff r0 = r4.g0
            if (r0 != 0) goto L61
            ff r0 = new ff
            r0.<init>()
            r4.g0 = r0
            android.view.Display r0 = defpackage.y9.e(r4)
            r1 = 1114636288(0x42700000, float:60.0)
            boolean r2 = r4.isInEditMode()
            if (r2 != 0) goto L52
            if (r0 == 0) goto L52
            float r0 = r0.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 < 0) goto L52
            goto L53
        L52:
            r0 = r1
        L53:
            ff r1 = r4.g0
            r2 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r2 = r2 / r0
            long r2 = (long) r2
            r1.e = r2
            java.lang.ThreadLocal<ff> r0 = defpackage.ff.g
            r0.set(r1)
        L61:
            ff r0 = r4.g0
            java.util.ArrayList<nf> r0 = r0.c
            r0.add(r4)
        L68:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.nf.onAttachedToWindow():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        ff ffVar;
        super.onDetachedFromWindow();
        k kVar = this.O;
        if (kVar != null) {
            kVar.b();
        }
        a0();
        this.t = false;
        n nVar = this.n;
        if (nVar != null) {
            nVar.a(this, this.d);
        }
        this.v0.clear();
        removeCallbacks(this.w0);
        this.h.b();
        if (!E0 || (ffVar = this.g0) == null) {
            return;
        }
        ffVar.c.remove(this);
        this.g0 = null;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.q.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.q.get(i2).a(canvas, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0081  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onGenericMotionEvent(android.view.MotionEvent r14) {
        /*
            Method dump skipped, instructions count: 220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.nf.onGenericMotionEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        if (this.z) {
            return false;
        }
        this.s = null;
        if (a(motionEvent)) {
            t();
            return true;
        }
        n nVar = this.n;
        if (nVar == null) {
            return false;
        }
        boolean a2 = nVar.a();
        boolean b2 = this.n.b();
        if (this.R == null) {
            this.R = VelocityTracker.obtain();
        }
        this.R.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.A) {
                this.A = false;
            }
            this.Q = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.U = x2;
            this.S = x2;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.V = y2;
            this.T = y2;
            if (this.P == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                i(1);
            }
            int[] iArr = this.t0;
            iArr[1] = 0;
            iArr[0] = 0;
            int i2 = a2 ? 1 : 0;
            if (b2) {
                i2 |= 2;
            }
            i(i2, 0);
        } else if (actionMasked == 1) {
            this.R.clear();
            i(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.Q);
            if (findPointerIndex < 0) {
                StringBuilder a3 = jg.a("Error processing scroll; pointer index for id ");
                a3.append(this.Q);
                a3.append(" not found. Did any MotionEvents get skipped?");
                Log.e("RecyclerView", a3.toString());
                return false;
            }
            int x3 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y3 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.P != 1) {
                int i3 = x3 - this.S;
                int i4 = y3 - this.T;
                if (!a2 || Math.abs(i3) <= this.W) {
                    z2 = false;
                } else {
                    this.U = x3;
                    z2 = true;
                }
                if (b2 && Math.abs(i4) > this.W) {
                    this.V = y3;
                    z2 = true;
                }
                if (z2) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            t();
        } else if (actionMasked == 5) {
            this.Q = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.U = x4;
            this.S = x4;
            int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.V = y4;
            this.T = y4;
        } else if (actionMasked == 6) {
            b(motionEvent);
        }
        return this.P == 1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        n8.a("RV OnLayout");
        w();
        int i6 = Build.VERSION.SDK_INT;
        Trace.endSection();
        this.w = true;
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        n nVar = this.n;
        if (nVar == null) {
            c(i2, i3);
            return;
        }
        boolean z2 = false;
        if (nVar.w()) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.n.b(i2, i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z2 = true;
            }
            this.x0 = z2;
            if (this.x0 || this.m == null) {
                return;
            }
            if (this.i0.e == 1) {
                x();
            }
            this.n.c(i2, i3);
            this.i0.j = true;
            y();
            this.n.e(i2, i3);
            if (this.n.J()) {
                this.n.c(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                this.i0.j = true;
                y();
                this.n.e(i2, i3);
            }
            this.y0 = getMeasuredWidth();
            this.z0 = getMeasuredHeight();
        } else if (this.u) {
            this.n.b(i2, i3);
        } else {
            if (this.C) {
                Z();
                O();
                T();
                P();
                z zVar = this.i0;
                if (zVar.l) {
                    zVar.h = true;
                } else {
                    this.f.b();
                    this.i0.h = false;
                }
                this.C = false;
                e(false);
            } else if (this.i0.l) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            f fVar = this.m;
            if (fVar != null) {
                this.i0.f = fVar.a();
            } else {
                this.i0.f = 0;
            }
            Z();
            this.n.b(i2, i3);
            e(false);
            this.i0.h = false;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (J()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof x)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        this.e = (x) parcelable;
        super.onRestoreInstanceState(this.e.c);
        requestLayout();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        x xVar = new x(super.onSaveInstanceState());
        x xVar2 = this.e;
        if (xVar2 != null) {
            xVar.e = xVar2.e;
        } else {
            n nVar = this.n;
            if (nVar != null) {
                xVar.e = nVar.F();
            } else {
                xVar.e = null;
            }
        }
        return xVar;
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 == i4 && i3 == i5) {
            return;
        }
        H();
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0204  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            Method dump skipped, instructions count: 779
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.nf.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public void removeDetachedView(View view, boolean z2) {
        c0 l2 = l(view);
        if (l2 != null) {
            if (l2.l()) {
                l2.j &= -257;
            } else if (!l2.o()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Called removeDetachedView with a view which is not flagged as tmp detached.");
                sb.append(l2);
                throw new IllegalArgumentException(jg.a(this, sb));
            }
        }
        view.clearAnimation();
        c(view);
        super.removeDetachedView(view, z2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (!this.n.a(this, view, view2) && view2 != null) {
            a(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        return this.n.a(this, view, rect, z2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z2) {
        int size = this.r.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((ef) this.r.get(i2)).a(z2);
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.x == 0 && !this.z) {
            super.requestLayout();
        } else {
            this.y = true;
        }
    }

    @Override // android.view.View
    public void scrollBy(int i2, int i3) {
        n nVar = this.n;
        if (nVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (this.z) {
        } else {
            boolean a2 = nVar.a();
            boolean b2 = this.n.b();
            if (a2 || b2) {
                if (!a2) {
                    i2 = 0;
                }
                if (!b2) {
                    i3 = 0;
                }
                a(i2, i3, (MotionEvent) null, 0);
            }
        }
    }

    @Override // android.view.View
    public void scrollTo(int i2, int i3) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (a(accessibilityEvent)) {
            return;
        }
        super.sendAccessibilityEventUnchecked(accessibilityEvent);
    }

    public void setAccessibilityDelegateCompat(pf pfVar) {
        this.p0 = pfVar;
        y9.a(this, this.p0);
    }

    public void setAdapter(f fVar) {
        setLayoutFrozen(false);
        f fVar2 = this.m;
        if (fVar2 != null) {
            fVar2.b(this.c);
            this.m.b(this);
        }
        U();
        this.f.e();
        f fVar3 = this.m;
        this.m = fVar;
        if (fVar != null) {
            fVar.a(this.c);
            fVar.a(this);
        }
        n nVar = this.n;
        if (nVar != null) {
            nVar.a(fVar3, this.m);
        }
        u uVar = this.d;
        f fVar4 = this.m;
        uVar.a();
        uVar.b().a(fVar3, fVar4, false);
        this.i0.g = true;
        d(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(i iVar) {
        if (iVar == null) {
            return;
        }
        setChildrenDrawingOrderEnabled(false);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z2) {
        if (z2 != this.i) {
            H();
        }
        this.i = z2;
        super.setClipToPadding(z2);
        if (this.w) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(j jVar) {
        if (jVar != null) {
            this.J = jVar;
            H();
            return;
        }
        throw new NullPointerException();
    }

    public void setHasFixedSize(boolean z2) {
        this.u = z2;
    }

    public void setItemAnimator(k kVar) {
        k kVar2 = this.O;
        if (kVar2 != null) {
            kVar2.b();
            this.O.a = null;
        }
        this.O = kVar;
        k kVar3 = this.O;
        if (kVar3 != null) {
            kVar3.a = this.n0;
        }
    }

    public void setItemViewCacheSize(int i2) {
        u uVar = this.d;
        uVar.e = i2;
        uVar.d();
    }

    @Deprecated
    public void setLayoutFrozen(boolean z2) {
        suppressLayout(z2);
    }

    public void setLayoutManager(n nVar) {
        if (nVar == this.n) {
            return;
        }
        a0();
        if (this.n != null) {
            k kVar = this.O;
            if (kVar != null) {
                kVar.b();
            }
            this.n.b(this.d);
            this.n.c(this.d);
            this.d.a();
            if (this.t) {
                this.n.a(this, this.d);
            }
            this.n.e((nf) null);
            this.n = null;
        } else {
            this.d.a();
        }
        ye yeVar = this.g;
        yeVar.b.b();
        int size = yeVar.c.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            ((of) yeVar.a).c(yeVar.c.get(size));
            yeVar.c.remove(size);
        }
        of ofVar = (of) yeVar.a;
        int a2 = ofVar.a();
        for (int i2 = 0; i2 < a2; i2++) {
            View a3 = ofVar.a(i2);
            ofVar.a.c(a3);
            a3.clearAnimation();
        }
        ofVar.a.removeAllViews();
        this.n = nVar;
        if (nVar != null) {
            if (nVar.b == null) {
                this.n.e(this);
                if (this.t) {
                    this.n.a(this);
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("LayoutManager ");
                sb.append(nVar);
                sb.append(" is already attached to a RecyclerView:");
                throw new IllegalArgumentException(jg.a(nVar.b, sb));
            }
        }
        this.d.d();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        int i2 = Build.VERSION.SDK_INT;
        if (layoutTransition == null) {
            super.setLayoutTransition(null);
            return;
        }
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z2) {
        n9 scrollingChildHelper = getScrollingChildHelper();
        if (scrollingChildHelper.d) {
            y9.v(scrollingChildHelper.c);
        }
        scrollingChildHelper.d = z2;
    }

    public void setOnFlingListener(q qVar) {
    }

    @Deprecated
    public void setOnScrollListener(s sVar) {
        this.j0 = sVar;
    }

    public void setPreserveFocusAfterLayout(boolean z2) {
        this.e0 = z2;
    }

    public void setRecycledViewPool(t tVar) {
        u uVar = this.d;
        t tVar2 = uVar.g;
        if (tVar2 != null) {
            tVar2.b();
        }
        uVar.g = tVar;
        if (uVar.g == null || nf.this.getAdapter() == null) {
            return;
        }
        uVar.g.a();
    }

    @Deprecated
    public void setRecyclerListener(v vVar) {
        this.o = vVar;
    }

    public void setScrollState(int i2) {
        if (i2 == this.P) {
            return;
        }
        this.P = i2;
        if (i2 != 2) {
            this.f0.b();
            n nVar = this.n;
            if (nVar != null) {
                nVar.K();
            }
        }
        b(i2);
    }

    public void setScrollingTouchSlop(int i2) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i2 != 0) {
            if (i2 != 1) {
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i2 + "; using default value");
            } else {
                this.W = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
        }
        this.W = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(a0 a0Var) {
        this.d.a(a0Var);
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().a(i2, 0);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        getScrollingChildHelper().c(0);
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z2) {
        if (z2 != this.z) {
            e("Do not suppressLayout in layout or scroll");
            if (!z2) {
                this.z = false;
                if (this.y && this.n != null && this.m != null) {
                    requestLayout();
                }
                this.y = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, XToggleDrawable.LIGHT_RADIUS_DEFAULT, XToggleDrawable.LIGHT_RADIUS_DEFAULT, 0));
            this.z = true;
            this.A = true;
            a0();
        }
    }

    public final void t() {
        X();
        setScrollState(0);
    }

    public void u() {
        int b2 = this.g.b();
        for (int i2 = 0; i2 < b2; i2++) {
            c0 l2 = l(this.g.d(i2));
            if (!l2.o()) {
                l2.a();
            }
        }
        u uVar = this.d;
        int size = uVar.c.size();
        for (int i3 = 0; i3 < size; i3++) {
            uVar.c.get(i3).a();
        }
        int size2 = uVar.a.size();
        for (int i4 = 0; i4 < size2; i4++) {
            uVar.a.get(i4).a();
        }
        ArrayList<c0> arrayList = uVar.b;
        if (arrayList != null) {
            int size3 = arrayList.size();
            for (int i5 = 0; i5 < size3; i5++) {
                uVar.b.get(i5).a();
            }
        }
    }

    public void v() {
        if (this.w && !this.F) {
            if (this.f.c()) {
                boolean z2 = false;
                if ((this.f.h & 4) != 0) {
                    if (!((this.f.h & 11) != 0)) {
                        n8.a("RV PartialInvalidate");
                        Z();
                        O();
                        this.f.d();
                        if (!this.y) {
                            int a2 = this.g.a();
                            int i2 = 0;
                            while (true) {
                                if (i2 < a2) {
                                    c0 l2 = l(this.g.b(i2));
                                    if (l2 != null && !l2.o() && l2.m()) {
                                        z2 = true;
                                        break;
                                    }
                                    i2++;
                                } else {
                                    break;
                                }
                            }
                            if (z2) {
                                w();
                            } else {
                                this.f.a();
                            }
                        }
                        e(true);
                        P();
                        int i3 = Build.VERSION.SDK_INT;
                        Trace.endSection();
                        return;
                    }
                }
                if (this.f.c()) {
                    n8.a("RV FullInvalidate");
                    w();
                    int i4 = Build.VERSION.SDK_INT;
                    Trace.endSection();
                    return;
                }
                return;
            }
            return;
        }
        n8.a("RV FullInvalidate");
        w();
        int i5 = Build.VERSION.SDK_INT;
        Trace.endSection();
    }

    /* JADX WARN: Code restructure failed: missing block: B:145:0x02f8, code lost:
        if (r15.g.b(r0) == false) goto L195;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void w() {
        /*
            Method dump skipped, instructions count: 917
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.nf.w():void");
    }

    public final void x() {
        int c2;
        this.i0.a(1);
        a(this.i0);
        this.i0.j = false;
        Z();
        sf sfVar = this.h;
        sfVar.a.clear();
        sfVar.b.a();
        O();
        T();
        View focusedChild = (this.e0 && hasFocus() && this.m != null) ? getFocusedChild() : null;
        c0 e2 = focusedChild == null ? null : e(focusedChild);
        if (e2 == null) {
            z zVar = this.i0;
            zVar.n = -1L;
            zVar.m = -1;
            zVar.o = -1;
        } else {
            this.i0.n = this.m.b ? e2.e : -1L;
            z zVar2 = this.i0;
            if (this.F) {
                c2 = -1;
            } else {
                c2 = e2.j() ? e2.d : e2.c();
            }
            zVar2.m = c2;
            z zVar3 = this.i0;
            View view = e2.a;
            int id = view.getId();
            while (!view.isFocused() && (view instanceof ViewGroup) && view.hasFocus()) {
                view = ((ViewGroup) view).getFocusedChild();
                if (view.getId() != -1) {
                    id = view.getId();
                }
            }
            zVar3.o = id;
        }
        z zVar4 = this.i0;
        zVar4.i = zVar4.k && this.m0;
        this.m0 = false;
        this.l0 = false;
        z zVar5 = this.i0;
        zVar5.h = zVar5.l;
        zVar5.f = this.m.a();
        a(this.q0);
        if (this.i0.k) {
            int a2 = this.g.a();
            for (int i2 = 0; i2 < a2; i2++) {
                c0 l2 = l(this.g.b(i2));
                if (!l2.o() && (!l2.h() || this.m.b)) {
                    k kVar = this.O;
                    k.c(l2);
                    l2.e();
                    k.c e3 = kVar.e();
                    View view2 = l2.a;
                    e3.a = view2.getLeft();
                    e3.b = view2.getTop();
                    view2.getRight();
                    view2.getBottom();
                    this.h.b(l2, e3);
                    if (this.i0.i && l2.m() && !l2.j() && !l2.o() && !l2.h()) {
                        this.h.b.b(d(l2), l2);
                    }
                }
            }
        }
        if (this.i0.l) {
            Y();
            z zVar6 = this.i0;
            boolean z2 = zVar6.g;
            zVar6.g = false;
            this.n.c(this.d, zVar6);
            this.i0.g = z2;
            for (int i3 = 0; i3 < this.g.a(); i3++) {
                c0 l3 = l(this.g.b(i3));
                if (!l3.o()) {
                    sf.a orDefault = this.h.a.getOrDefault(l3, null);
                    if (!((orDefault == null || (orDefault.a & 4) == 0) ? false : true)) {
                        k.c(l3);
                        boolean b2 = l3.b(WebpBitmapFactory.IN_TEMP_BUFFER_SIZE);
                        k kVar2 = this.O;
                        l3.e();
                        k.c e4 = kVar2.e();
                        View view3 = l3.a;
                        e4.a = view3.getLeft();
                        e4.b = view3.getTop();
                        view3.getRight();
                        view3.getBottom();
                        if (b2) {
                            a(l3, e4);
                        } else {
                            sf sfVar2 = this.h;
                            sf.a orDefault2 = sfVar2.a.getOrDefault(l3, null);
                            if (orDefault2 == null) {
                                orDefault2 = sf.a.a();
                                sfVar2.a.put(l3, orDefault2);
                            }
                            orDefault2.a |= 2;
                            orDefault2.b = e4;
                        }
                    }
                }
            }
            u();
        } else {
            u();
        }
        P();
        e(false);
        this.i0.e = 2;
    }

    public final void y() {
        Z();
        O();
        this.i0.a(6);
        this.f.b();
        this.i0.f = this.m.a();
        this.i0.d = 0;
        boolean z2 = true;
        if (this.e != null) {
            f fVar = this.m;
            int ordinal = fVar.c.ordinal();
            if (ordinal == 1 ? fVar.a() > 0 : ordinal != 2) {
                Parcelable parcelable = this.e.e;
                if (parcelable != null) {
                    this.n.a(parcelable);
                }
                this.e = null;
            }
        }
        z zVar = this.i0;
        zVar.h = false;
        this.n.c(this.d, zVar);
        z zVar2 = this.i0;
        zVar2.g = false;
        if (!zVar2.k || this.O == null) {
            z2 = false;
        }
        zVar2.k = z2;
        this.i0.e = 4;
        P();
        e(false);
    }

    public void z() {
        int i2;
        for (int size = this.v0.size() - 1; size >= 0; size--) {
            c0 c0Var = this.v0.get(size);
            if (c0Var.a.getParent() == this && !c0Var.o() && (i2 = c0Var.q) != -1) {
                y9.a(c0Var.a, i2);
                c0Var.q = -1;
            }
        }
        this.v0.clear();
    }

    /* compiled from: RecyclerView.java */
    /* renamed from: nf$e */
    /* loaded from: classes.dex */
    public class e implements xe.a {
        public e() {
        }

        public c0 a(int i) {
            c0 a = nf.this.a(i, true);
            if (a == null || nf.this.g.b(a.a)) {
                return null;
            }
            return a;
        }

        public void a(int i, int i2, Object obj) {
            nf.this.a(i, i2, obj);
            nf.this.m0 = true;
        }

        public void a(xe.b bVar) {
            int i = bVar.a;
            if (i == 1) {
                nf nfVar = nf.this;
                nfVar.n.a(nfVar, bVar.b, bVar.d);
            } else if (i == 2) {
                nf nfVar2 = nf.this;
                nfVar2.n.b(nfVar2, bVar.b, bVar.d);
            } else if (i == 4) {
                nf nfVar3 = nf.this;
                nfVar3.n.a(nfVar3, bVar.b, bVar.d, bVar.c);
            } else if (i != 8) {
            } else {
                nf nfVar4 = nf.this;
                nfVar4.n.a(nfVar4, bVar.b, bVar.d, 1);
            }
        }
    }

    /* compiled from: RecyclerView.java */
    /* renamed from: nf$u */
    /* loaded from: classes.dex */
    public final class u {
        public final ArrayList<c0> a = new ArrayList<>();
        public ArrayList<c0> b = null;
        public final ArrayList<c0> c = new ArrayList<>();
        public final List<c0> d = Collections.unmodifiableList(this.a);
        public int e = 2;
        public int f = 2;
        public t g;

        public u() {
        }

        public void a() {
            this.a.clear();
            c();
        }

        public void a(a0 a0Var) {
        }

        public void b(int i) {
            a(this.c.get(i), true);
            this.c.remove(i);
        }

        public void c() {
            for (int size = this.c.size() - 1; size >= 0; size--) {
                b(size);
            }
            this.c.clear();
            if (nf.E0) {
                ff.b bVar = nf.this.h0;
                int[] iArr = bVar.c;
                if (iArr != null) {
                    Arrays.fill(iArr, -1);
                }
                bVar.d = 0;
            }
        }

        public void d() {
            n nVar = nf.this.n;
            this.f = this.e + (nVar != null ? nVar.m : 0);
            for (int size = this.c.size() - 1; size >= 0 && this.c.size() > this.f; size--) {
                b(size);
            }
        }

        public int a(int i) {
            if (i >= 0 && i < nf.this.i0.a()) {
                nf nfVar = nf.this;
                return !nfVar.i0.h ? i : nfVar.f.a(i, 0);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("invalid position ");
            sb.append(i);
            sb.append(". State item count is ");
            sb.append(nf.this.i0.a());
            throw new IndexOutOfBoundsException(jg.a(nf.this, sb));
        }

        public void b(View view) {
            c0 l = nf.l(view);
            if (!l.b(12) && l.m() && !nf.this.b(l)) {
                if (this.b == null) {
                    this.b = new ArrayList<>();
                }
                l.n = this;
                l.o = true;
                this.b.add(l);
            } else if (l.h() && !l.j() && !nf.this.m.b) {
                throw new IllegalArgumentException(jg.a(nf.this, jg.a("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.")));
            } else {
                l.n = this;
                l.o = false;
                this.a.add(l);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:105:0x01e7, code lost:
            if (r11.f != 0) goto L60;
         */
        /* JADX WARN: Code restructure failed: missing block: B:110:0x01f8, code lost:
            if (r9 == (-1)) goto L65;
         */
        /* JADX WARN: Code restructure failed: missing block: B:112:0x01fb, code lost:
            r9 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:229:0x0430, code lost:
            if (r11.h() == false) goto L175;
         */
        /* JADX WARN: Code restructure failed: missing block: B:239:0x0466, code lost:
            if ((r4 == 0 || r4 + r7 < r19) == false) goto L175;
         */
        /* JADX WARN: Removed duplicated region for block: B:262:0x04ca  */
        /* JADX WARN: Removed duplicated region for block: B:263:0x04d8  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0089  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x008b  */
        /* JADX WARN: Removed duplicated region for block: B:95:0x01bb  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public defpackage.nf.c0 a(int r17, boolean r18, long r19) {
            /*
                Method dump skipped, instructions count: 1308
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.nf.u.a(int, boolean, long):nf$c0");
        }

        public void b(c0 c0Var) {
            if (c0Var.o) {
                this.b.remove(c0Var);
            } else {
                this.a.remove(c0Var);
            }
            c0Var.n = null;
            c0Var.o = false;
            c0Var.b();
        }

        public t b() {
            if (this.g == null) {
                this.g = new t();
            }
            return this.g;
        }

        public final void a(ViewGroup viewGroup, boolean z) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    a((ViewGroup) childAt, true);
                }
            }
            if (z) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                    return;
                }
                int visibility = viewGroup.getVisibility();
                viewGroup.setVisibility(4);
                viewGroup.setVisibility(visibility);
            }
        }

        public void a(View view) {
            c0 l = nf.l(view);
            if (l.l()) {
                nf.this.removeDetachedView(view, false);
            }
            if (l.k()) {
                l.n.b(l);
            } else if (l.p()) {
                l.b();
            }
            a(l);
            if (nf.this.O == null || l.i()) {
                return;
            }
            nf.this.O.b(l);
        }

        public void a(c0 c0Var) {
            boolean z;
            if (!c0Var.k() && c0Var.a.getParent() == null) {
                if (!c0Var.l()) {
                    if (!c0Var.o()) {
                        boolean z2 = (c0Var.j & 16) == 0 && y9.p(c0Var.a);
                        f fVar = nf.this.m;
                        if (fVar != null && z2) {
                            fVar.d();
                        }
                        if (c0Var.i()) {
                            if (this.f <= 0 || c0Var.b(IInputController.KEYCODE_KNOB_USB_MUSIC)) {
                                z = false;
                            } else {
                                int size = this.c.size();
                                if (size >= this.f && size > 0) {
                                    b(0);
                                    size--;
                                }
                                if (nf.E0 && size > 0 && !nf.this.h0.a(c0Var.c)) {
                                    do {
                                        size--;
                                        if (size < 0) {
                                            break;
                                        }
                                    } while (nf.this.h0.a(this.c.get(size).c));
                                    size++;
                                }
                                this.c.add(size, c0Var);
                                z = true;
                            }
                            if (!z) {
                                a(c0Var, true);
                                r1 = true;
                            }
                        } else {
                            z = false;
                        }
                        nf.this.h.d(c0Var);
                        if (z || r1 || !z2) {
                            return;
                        }
                        c0Var.s = null;
                        c0Var.r = null;
                        return;
                    }
                    throw new IllegalArgumentException(jg.a(nf.this, jg.a("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.")));
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Tmp detached view should be removed from RecyclerView before it can be recycled: ");
                sb.append(c0Var);
                throw new IllegalArgumentException(jg.a(nf.this, sb));
            }
            StringBuilder a = jg.a("Scrapped or attached views may not be recycled. isScrap:");
            a.append(c0Var.k());
            a.append(" isAttached:");
            a.append(c0Var.a.getParent() != null);
            throw new IllegalArgumentException(jg.a(nf.this, a));
        }

        public void a(c0 c0Var, boolean z) {
            nf.e(c0Var);
            View view = c0Var.a;
            pf pfVar = nf.this.p0;
            if (pfVar != null) {
                pf.a aVar = pfVar.e;
                y9.a(view, aVar instanceof pf.a ? aVar.e.remove(view) : null);
            }
            if (z) {
                v vVar = nf.this.o;
                if (vVar != null) {
                    vVar.a(c0Var);
                }
                int size = nf.this.p.size();
                for (int i = 0; i < size; i++) {
                    nf.this.p.get(i).a(c0Var);
                }
                f fVar = nf.this.m;
                if (fVar != null) {
                    fVar.g();
                }
                nf nfVar = nf.this;
                if (nfVar.i0 != null) {
                    nfVar.h.d(c0Var);
                }
            }
            c0Var.s = null;
            c0Var.r = null;
            b().a(c0Var);
        }
    }

    public nf(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, ue.recyclerViewStyle);
    }

    /* compiled from: RecyclerView.java */
    /* renamed from: nf$x */
    /* loaded from: classes.dex */
    public static class x extends jb {
        public static final Parcelable.Creator<x> CREATOR = new a();
        public Parcelable e;

        /* compiled from: RecyclerView.java */
        /* renamed from: nf$x$a */
        /* loaded from: classes.dex */
        public class a implements Parcelable.ClassLoaderCreator<x> {
            @Override // android.os.Parcelable.ClassLoaderCreator
            public x createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new x(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i) {
                return new x[i];
            }

            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new x(parcel, null);
            }
        }

        public x(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.e = parcel.readParcelable(classLoader == null ? n.class.getClassLoader() : classLoader);
        }

        @Override // defpackage.jb, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.c, i);
            parcel.writeParcelable(this.e, 0);
        }

        public x(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public nf(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        ClassLoader classLoader;
        Constructor constructor;
        Object[] objArr;
        this.c = new w();
        this.d = new u();
        this.h = new sf();
        new a();
        this.j = new Rect();
        this.k = new Rect();
        this.l = new RectF();
        this.p = new ArrayList();
        this.q = new ArrayList<>();
        this.r = new ArrayList<>();
        this.x = 0;
        this.F = false;
        this.G = false;
        this.H = 0;
        this.I = 0;
        this.J = new j();
        this.O = new df();
        this.P = 0;
        this.Q = -1;
        this.c0 = Float.MIN_VALUE;
        this.d0 = Float.MIN_VALUE;
        this.e0 = true;
        this.f0 = new b0();
        this.h0 = E0 ? new ff.b() : null;
        this.i0 = new z();
        this.l0 = false;
        this.m0 = false;
        this.n0 = new l();
        this.o0 = false;
        this.q0 = new int[2];
        this.s0 = new int[2];
        this.t0 = new int[2];
        this.u0 = new int[2];
        this.v0 = new ArrayList();
        this.w0 = new b();
        this.y0 = 0;
        this.z0 = 0;
        this.A0 = new d();
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.W = viewConfiguration.getScaledTouchSlop();
        this.c0 = ea.a(viewConfiguration, context);
        int i3 = Build.VERSION.SDK_INT;
        this.d0 = viewConfiguration.getScaledVerticalScrollFactor();
        this.a0 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.b0 = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.O.a = this.n0;
        G();
        this.g = new ye(new of(this));
        if (y9.g(this) == 0) {
            int i4 = Build.VERSION.SDK_INT;
            setImportantForAutofill(8);
        }
        if (y9.f(this) == 0) {
            int i5 = Build.VERSION.SDK_INT;
            setImportantForAccessibility(1);
        }
        this.D = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new pf(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, we.RecyclerView, i2, 0);
        y9.a(this, context, we.RecyclerView, attributeSet, obtainStyledAttributes, i2, 0);
        String string = obtainStyledAttributes.getString(we.RecyclerView_layoutManager);
        if (obtainStyledAttributes.getInt(we.RecyclerView_android_descendantFocusability, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.i = obtainStyledAttributes.getBoolean(we.RecyclerView_android_clipToPadding, true);
        this.v = obtainStyledAttributes.getBoolean(we.RecyclerView_fastScrollEnabled, false);
        if (this.v) {
            a((StateListDrawable) obtainStyledAttributes.getDrawable(we.RecyclerView_fastScrollVerticalThumbDrawable), obtainStyledAttributes.getDrawable(we.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) obtainStyledAttributes.getDrawable(we.RecyclerView_fastScrollHorizontalThumbDrawable), obtainStyledAttributes.getDrawable(we.RecyclerView_fastScrollHorizontalTrackDrawable));
        }
        obtainStyledAttributes.recycle();
        if (string != null) {
            String trim = string.trim();
            if (!trim.isEmpty()) {
                if (trim.charAt(0) == '.') {
                    trim = context.getPackageName() + trim;
                } else if (!trim.contains(".")) {
                    trim = nf.class.getPackage().getName() + '.' + trim;
                }
                String str = trim;
                try {
                    if (isInEditMode()) {
                        classLoader = getClass().getClassLoader();
                    } else {
                        classLoader = context.getClassLoader();
                    }
                    Class<? extends U> asSubclass = Class.forName(str, false, classLoader).asSubclass(n.class);
                    try {
                        constructor = asSubclass.getConstructor(H0);
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i2), 0};
                    } catch (NoSuchMethodException e2) {
                        try {
                            constructor = asSubclass.getConstructor(new Class[0]);
                            objArr = null;
                        } catch (NoSuchMethodException e3) {
                            e3.initCause(e2);
                            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + str, e3);
                        }
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((n) constructor.newInstance(objArr));
                } catch (ClassCastException e4) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + str, e4);
                } catch (ClassNotFoundException e5) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + str, e5);
                } catch (IllegalAccessException e6) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + str, e6);
                } catch (InstantiationException e7) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, e7);
                } catch (InvocationTargetException e8) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, e8);
                }
            }
        }
        int i6 = Build.VERSION.SDK_INT;
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, B0, i2, 0);
        y9.a(this, context, B0, attributeSet, obtainStyledAttributes2, i2, 0);
        boolean z2 = obtainStyledAttributes2.getBoolean(0, true);
        obtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z2);
    }

    /* compiled from: RecyclerView.java */
    /* renamed from: nf$b0 */
    /* loaded from: classes.dex */
    public class b0 implements Runnable {
        public int c;
        public int d;
        public OverScroller e;
        public Interpolator f = nf.I0;
        public boolean g = false;
        public boolean h = false;

        public b0() {
            this.e = new OverScroller(nf.this.getContext(), nf.I0);
        }

        public void a() {
            if (this.g) {
                this.h = true;
                return;
            }
            nf.this.removeCallbacks(this);
            y9.a(nf.this, this);
        }

        public void b() {
            nf.this.removeCallbacks(this);
            this.e.abortAnimation();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            int i2;
            nf nfVar = nf.this;
            if (nfVar.n == null) {
                b();
                return;
            }
            this.h = false;
            this.g = true;
            nfVar.v();
            OverScroller overScroller = this.e;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i3 = currX - this.c;
                int i4 = currY - this.d;
                this.c = currX;
                this.d = currY;
                nf nfVar2 = nf.this;
                int[] iArr = nfVar2.u0;
                iArr[0] = 0;
                iArr[1] = 0;
                if (nfVar2.a(i3, i4, iArr, (int[]) null, 1)) {
                    int[] iArr2 = nf.this.u0;
                    i3 -= iArr2[0];
                    i4 -= iArr2[1];
                }
                if (nf.this.getOverScrollMode() != 2) {
                    nf.this.b(i3, i4);
                }
                nf nfVar3 = nf.this;
                if (nfVar3.m != null) {
                    int[] iArr3 = nfVar3.u0;
                    iArr3[0] = 0;
                    iArr3[1] = 0;
                    nfVar3.a(i3, i4, iArr3);
                    nf nfVar4 = nf.this;
                    int[] iArr4 = nfVar4.u0;
                    i2 = iArr4[0];
                    i = iArr4[1];
                    i3 -= i2;
                    i4 -= i;
                    y yVar = nfVar4.n.g;
                    if (yVar != null && !yVar.isPendingInitialRun() && yVar.isRunning()) {
                        int a = nf.this.i0.a();
                        if (a == 0) {
                            yVar.stop();
                        } else if (yVar.getTargetPosition() >= a) {
                            yVar.setTargetPosition(a - 1);
                            yVar.onAnimation(i2, i);
                        } else {
                            yVar.onAnimation(i2, i);
                        }
                    }
                } else {
                    i = 0;
                    i2 = 0;
                }
                if (!nf.this.q.isEmpty()) {
                    nf.this.invalidate();
                }
                nf nfVar5 = nf.this;
                int[] iArr5 = nfVar5.u0;
                iArr5[0] = 0;
                iArr5[1] = 0;
                nfVar5.a(i2, i, i3, i4, null, 1, iArr5);
                int[] iArr6 = nf.this.u0;
                int i5 = i3 - iArr6[0];
                int i6 = i4 - iArr6[1];
                if (i2 != 0 || i != 0) {
                    nf.this.d(i2, i);
                }
                if (!nf.this.awakenScrollBars()) {
                    nf.this.invalidate();
                }
                boolean z = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i5 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i6 != 0));
                y yVar2 = nf.this.n.g;
                if (!(yVar2 != null && yVar2.isPendingInitialRun()) && z) {
                    if (nf.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i7 = i5 < 0 ? -currVelocity : i5 > 0 ? currVelocity : 0;
                        if (i6 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i6 <= 0) {
                            currVelocity = 0;
                        }
                        nf.this.a(i7, currVelocity);
                    }
                    if (nf.E0) {
                        ff.b bVar = nf.this.h0;
                        int[] iArr7 = bVar.c;
                        if (iArr7 != null) {
                            Arrays.fill(iArr7, -1);
                        }
                        bVar.d = 0;
                    }
                } else {
                    a();
                    nf nfVar6 = nf.this;
                    ff ffVar = nfVar6.g0;
                    if (ffVar != null) {
                        ffVar.a(nfVar6, i2, i);
                    }
                }
            }
            y yVar3 = nf.this.n.g;
            if (yVar3 != null && yVar3.isPendingInitialRun()) {
                yVar3.onAnimation(0, 0);
            }
            this.g = false;
            if (this.h) {
                nf.this.removeCallbacks(this);
                y9.a(nf.this, this);
                return;
            }
            nf.this.setScrollState(0);
            nf.this.i(1);
        }

        public void a(int i, int i2, int i3, Interpolator interpolator) {
            if (i3 == Integer.MIN_VALUE) {
                int abs = Math.abs(i);
                int abs2 = Math.abs(i2);
                boolean z = abs > abs2;
                nf nfVar = nf.this;
                int width = z ? nfVar.getWidth() : nfVar.getHeight();
                if (!z) {
                    abs = abs2;
                }
                i3 = Math.min((int) (((abs / width) + 1.0f) * 300.0f), 2000);
            }
            int i4 = i3;
            if (interpolator == null) {
                interpolator = nf.I0;
            }
            if (this.f != interpolator) {
                this.f = interpolator;
                this.e = new OverScroller(nf.this.getContext(), interpolator);
            }
            this.d = 0;
            this.c = 0;
            nf.this.setScrollState(2);
            this.e.startScroll(0, 0, i, i2, i4);
            int i5 = Build.VERSION.SDK_INT;
            a();
        }
    }

    /* compiled from: RecyclerView.java */
    /* renamed from: nf$o */
    /* loaded from: classes.dex */
    public static class o extends ViewGroup.MarginLayoutParams {
        public c0 a;
        public final Rect b;
        public boolean c;
        public boolean d;

        public o(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.b = new Rect();
            this.c = true;
            this.d = false;
        }

        public int a() {
            return this.a.d();
        }

        public boolean b() {
            return this.a.m();
        }

        public boolean c() {
            return this.a.j();
        }

        public o(int i, int i2) {
            super(i, i2);
            this.b = new Rect();
            this.c = true;
            this.d = false;
        }

        public o(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.b = new Rect();
            this.c = true;
            this.d = false;
        }

        public o(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.b = new Rect();
            this.c = true;
            this.d = false;
        }

        public o(o oVar) {
            super((ViewGroup.LayoutParams) oVar);
            this.b = new Rect();
            this.c = true;
            this.d = false;
        }
    }

    /* compiled from: RecyclerView.java */
    /* renamed from: nf$z */
    /* loaded from: classes.dex */
    public static class z {
        public SparseArray<Object> b;
        public int m;
        public long n;
        public int o;
        public int p;
        public int q;
        public int a = -1;
        public int c = 0;
        public int d = 0;
        public int e = 1;
        public int f = 0;
        public boolean g = false;
        public boolean h = false;
        public boolean i = false;
        public boolean j = false;
        public boolean k = false;
        public boolean l = false;

        public void a(int i) {
            if ((this.e & i) != 0) {
                return;
            }
            StringBuilder a = jg.a("Layout state should be one of ");
            a.append(Integer.toBinaryString(i));
            a.append(" but it is ");
            a.append(Integer.toBinaryString(this.e));
            throw new IllegalStateException(a.toString());
        }

        public String toString() {
            StringBuilder a = jg.a("State{mTargetPosition=");
            a.append(this.a);
            a.append(", mData=");
            a.append(this.b);
            a.append(", mItemCount=");
            a.append(this.f);
            a.append(", mIsMeasuring=");
            a.append(this.j);
            a.append(", mPreviousLayoutItemCount=");
            a.append(this.c);
            a.append(", mDeletedInvisibleItemCountSincePreviousLayout=");
            a.append(this.d);
            a.append(", mStructureChanged=");
            a.append(this.g);
            a.append(", mInPreLayout=");
            a.append(this.h);
            a.append(", mRunSimpleAnimations=");
            a.append(this.k);
            a.append(", mRunPredictiveAnimations=");
            a.append(this.l);
            a.append('}');
            return a.toString();
        }

        public int a() {
            if (this.h) {
                return this.c - this.d;
            }
            return this.f;
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        n nVar = this.n;
        if (nVar != null) {
            return nVar.a(layoutParams);
        }
        throw new IllegalStateException(jg.a(this, jg.a("RecyclerView has no LayoutManager")));
    }

    public final void a(c0 c0Var) {
        View view = c0Var.a;
        boolean z2 = view.getParent() == this;
        this.d.b(h(view));
        if (c0Var.l()) {
            this.g.a(view, -1, view.getLayoutParams(), true);
        } else if (!z2) {
            this.g.a(view, -1, true);
        } else {
            ye yeVar = this.g;
            int indexOfChild = ((of) yeVar.a).a.indexOfChild(view);
            if (indexOfChild >= 0) {
                yeVar.b.e(indexOfChild);
                yeVar.c.add(view);
                ((of) yeVar.a).b(view);
                return;
            }
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    public long d(c0 c0Var) {
        if (this.m.b) {
            return c0Var.e;
        }
        return c0Var.c;
    }

    public void h(int i2, int i3) {
        a(i2, i3, (Interpolator) null);
    }

    public c0 h(View view) {
        ViewParent parent = view.getParent();
        if (parent != null && parent != this) {
            throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
        }
        return l(view);
    }

    public void g(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int b2 = this.g.b();
        if (i2 < i3) {
            i5 = i2;
            i4 = i3;
            i6 = -1;
        } else {
            i4 = i2;
            i5 = i3;
            i6 = 1;
        }
        for (int i12 = 0; i12 < b2; i12++) {
            c0 l2 = l(this.g.d(i12));
            if (l2 != null && (i11 = l2.c) >= i5 && i11 <= i4) {
                if (i11 == i2) {
                    l2.a(i3 - i2, false);
                } else {
                    l2.a(i6, false);
                }
                this.i0.g = true;
            }
        }
        u uVar = this.d;
        if (i2 < i3) {
            i9 = i3;
            i8 = -1;
            i7 = i2;
        } else {
            i7 = i3;
            i8 = 1;
            i9 = i2;
        }
        int size = uVar.c.size();
        for (int i13 = 0; i13 < size; i13++) {
            c0 c0Var = uVar.c.get(i13);
            if (c0Var != null && (i10 = c0Var.c) >= i7 && i10 <= i9) {
                if (i10 == i2) {
                    c0Var.a(i3 - i2, false);
                } else {
                    c0Var.a(i8, false);
                }
            }
        }
        requestLayout();
    }

    public void b(s sVar) {
        List<s> list = this.k0;
        if (list != null) {
            list.remove(sVar);
        }
    }

    public void c(boolean z2) {
        this.H--;
        if (this.H < 1) {
            this.H = 0;
            if (z2) {
                int i2 = this.B;
                this.B = 0;
                if (i2 != 0 && I()) {
                    AccessibilityEvent obtain = AccessibilityEvent.obtain();
                    obtain.setEventType(2048);
                    int i3 = Build.VERSION.SDK_INT;
                    obtain.setContentChangeTypes(i2);
                    sendAccessibilityEventUnchecked(obtain);
                }
                z();
            }
        }
    }

    public void d(boolean z2) {
        this.G = z2 | this.G;
        this.F = true;
        L();
    }

    public void b(int i2, int i3) {
        boolean z2;
        EdgeEffect edgeEffect = this.K;
        if (edgeEffect == null || edgeEffect.isFinished() || i2 <= 0) {
            z2 = false;
        } else {
            this.K.onRelease();
            z2 = this.K.isFinished();
        }
        EdgeEffect edgeEffect2 = this.M;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i2 < 0) {
            this.M.onRelease();
            z2 |= this.M.isFinished();
        }
        EdgeEffect edgeEffect3 = this.L;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i3 > 0) {
            this.L.onRelease();
            z2 |= this.L.isFinished();
        }
        EdgeEffect edgeEffect4 = this.N;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i3 < 0) {
            this.N.onRelease();
            z2 |= this.N.isFinished();
        }
        if (z2) {
            y9.t(this);
        }
    }

    /* compiled from: RecyclerView.java */
    /* renamed from: nf$f */
    /* loaded from: classes.dex */
    public static abstract class f<VH extends c0> {
        public final g a = new g();
        public boolean b = false;
        public a c = a.ALLOW;

        /* compiled from: RecyclerView.java */
        /* renamed from: nf$f$a */
        /* loaded from: classes.dex */
        public enum a {
            ALLOW,
            PREVENT_WHEN_EMPTY,
            PREVENT
        }

        public abstract int a();

        public final VH a(ViewGroup viewGroup, int i) {
            try {
                n8.a("RV CreateView");
                b50.c cVar = new b50.c(LayoutInflater.from(viewGroup.getContext()).inflate(q90.layout_item_help_tab, viewGroup, false));
                cVar.a.setOnClickListener(((b50.d) this).h);
                if (cVar.a.getParent() == null) {
                    cVar.f = i;
                    int i2 = Build.VERSION.SDK_INT;
                    Trace.endSection();
                    return cVar;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } catch (Throwable th) {
                n8.a();
                throw th;
            }
        }

        public void a(nf nfVar) {
        }

        public long b() {
            return -1L;
        }

        public void b(h hVar) {
            this.a.unregisterObserver(hVar);
        }

        public void b(nf nfVar) {
        }

        public int c() {
            return 0;
        }

        public boolean d() {
            return false;
        }

        public void e() {
        }

        public void f() {
        }

        public void g() {
        }

        public final void a(VH vh, int i) {
            boolean z = vh.s == null;
            if (z) {
                vh.c = i;
                if (this.b) {
                    vh.e = -1L;
                }
                vh.a(1, 519);
                n8.a("RV OnBindView");
            }
            vh.s = this;
            vh.e();
            b50.d dVar = (b50.d) this;
            b50.c cVar = (b50.c) vh;
            cVar.u.setText(dVar.d.get(i).c());
            cVar.u.setSelected(i == dVar.g);
            XTextView xTextView = cVar.u;
            xTextView.a(xTextView.getText().toString());
            cVar.u.a(i);
            cVar.u.b(cVar.u.getId() + "_" + i);
            cVar.u.a(mc0.BUTTON);
            if (z) {
                List<Object> list = vh.k;
                if (list != null) {
                    list.clear();
                }
                vh.j &= -1025;
                ViewGroup.LayoutParams layoutParams = vh.a.getLayoutParams();
                if (layoutParams instanceof o) {
                    ((o) layoutParams).c = true;
                }
                n8.a();
            }
        }

        public void a(h hVar) {
            this.a.registerObserver(hVar);
        }
    }

    public boolean e(int i2, int i3) {
        n nVar = this.n;
        if (nVar == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.z) {
            return false;
        } else {
            boolean a2 = nVar.a();
            boolean b2 = this.n.b();
            int i4 = (!a2 || Math.abs(i2) < this.a0) ? 0 : i2;
            int i5 = (!b2 || Math.abs(i3) < this.a0) ? 0 : i3;
            if (i4 == 0 && i5 == 0) {
                return false;
            }
            float f2 = i4;
            float f3 = i5;
            if (!dispatchNestedPreFling(f2, f3)) {
                boolean z2 = a2 || b2;
                dispatchNestedFling(f2, f3, z2);
                if (z2) {
                    int i6 = a2 ? 1 : 0;
                    if (b2) {
                        i6 |= 2;
                    }
                    i(i6, 1);
                    int i7 = this.b0;
                    int max = Math.max(-i7, Math.min(i4, i7));
                    int i8 = this.b0;
                    int max2 = Math.max(-i8, Math.min(i5, i8));
                    b0 b0Var = this.f0;
                    nf.this.setScrollState(2);
                    b0Var.d = 0;
                    b0Var.c = 0;
                    Interpolator interpolator = b0Var.f;
                    Interpolator interpolator2 = I0;
                    if (interpolator != interpolator2) {
                        b0Var.f = interpolator2;
                        b0Var.e = new OverScroller(nf.this.getContext(), I0);
                    }
                    b0Var.e.fling(0, 0, max, max2, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
                    b0Var.a();
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:?, code lost:
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View d(android.view.View r3) {
        /*
            r2 = this;
            android.view.ViewParent r0 = r3.getParent()
        L4:
            if (r0 == 0) goto L14
            if (r0 == r2) goto L14
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto L14
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            android.view.ViewParent r0 = r3.getParent()
            goto L4
        L14:
            if (r0 != r2) goto L17
            goto L18
        L17:
            r3 = 0
        L18:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.nf.d(android.view.View):android.view.View");
    }

    public int f(View view) {
        c0 l2 = l(view);
        if (l2 != null) {
            return l2.c();
        }
        return -1;
    }

    public void f(int i2) {
        int a2 = this.g.a();
        for (int i3 = 0; i3 < a2; i3++) {
            this.g.b(i3).offsetTopAndBottom(i2);
        }
    }

    public void d(int i2, int i3) {
        this.I++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i2, scrollY - i3);
        R();
        s sVar = this.j0;
        if (sVar != null) {
            sVar.onScrolled(this, i2, i3);
        }
        List<s> list = this.k0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.k0.get(size).onScrolled(this, i2, i3);
            }
        }
        this.I--;
    }

    public void a(m mVar, int i2) {
        n nVar = this.n;
        if (nVar != null) {
            nVar.a("Cannot add item decoration during a scroll  or layout");
        }
        if (this.q.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i2 < 0) {
            this.q.add(mVar);
        } else {
            this.q.add(i2, mVar);
        }
        K();
        requestLayout();
    }

    public boolean i(int i2, int i3) {
        return getScrollingChildHelper().a(i2, i3);
    }

    public c0 c(int i2) {
        c0 c0Var = null;
        if (this.F) {
            return null;
        }
        int b2 = this.g.b();
        for (int i3 = 0; i3 < b2; i3++) {
            c0 l2 = l(this.g.d(i3));
            if (l2 != null && !l2.j() && c(l2) == i2) {
                if (!this.g.b(l2.a)) {
                    return l2;
                }
                c0Var = l2;
            }
        }
        return c0Var;
    }

    public int g(View view) {
        c0 l2 = l(view);
        if (l2 != null) {
            return l2.d();
        }
        return -1;
    }

    public void i(int i2) {
        getScrollingChildHelper().c(i2);
    }

    public void b(r rVar) {
        this.r.remove(rVar);
        if (this.s == rVar) {
            this.s = null;
        }
    }

    public final void b(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.Q) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.Q = motionEvent.getPointerId(i2);
            int x2 = (int) (motionEvent.getX(i2) + 0.5f);
            this.U = x2;
            this.S = x2;
            int y2 = (int) (motionEvent.getY(i2) + 0.5f);
            this.V = y2;
            this.T = y2;
        }
    }

    public void c(View view) {
        c0 l2 = l(view);
        N();
        f fVar = this.m;
        if (fVar != null && l2 != null) {
            fVar.f();
        }
        List<p> list = this.E;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.E.get(size).b(view);
            }
        }
    }

    public void a(m mVar) {
        a(mVar, -1);
    }

    public void a(s sVar) {
        if (this.k0 == null) {
            this.k0 = new ArrayList();
        }
        this.k0.add(sVar);
    }

    public void a(int i2, int i3, int[] iArr) {
        Z();
        O();
        n8.a("RV Scroll");
        a(this.i0);
        int a2 = i2 != 0 ? this.n.a(i2, this.d, this.i0) : 0;
        int b2 = i3 != 0 ? this.n.b(i3, this.d, this.i0) : 0;
        int i4 = Build.VERSION.SDK_INT;
        Trace.endSection();
        V();
        P();
        e(false);
        if (iArr != null) {
            iArr[0] = a2;
            iArr[1] = b2;
        }
    }

    public void b(c0 c0Var, k.c cVar, k.c cVar2) {
        a(c0Var);
        c0Var.a(false);
        if (this.O.b(c0Var, cVar, cVar2)) {
            S();
        }
    }

    public void e(String str) {
        if (J()) {
            if (str == null) {
                throw new IllegalStateException(jg.a(this, jg.a("Cannot call this method while RecyclerView is computing a layout or scrolling")));
            }
            throw new IllegalStateException(str);
        } else if (this.I > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(jg.a(this, jg.a(""))));
        }
    }

    public int c(c0 c0Var) {
        if (c0Var.b(IInputController.KEYCODE_WIND_EXIT_MODE) || !c0Var.g()) {
            return -1;
        }
        xe xeVar = this.f;
        int i2 = c0Var.c;
        int size = xeVar.b.size();
        for (int i3 = 0; i3 < size; i3++) {
            xe.b bVar = xeVar.b.get(i3);
            int i4 = bVar.a;
            if (i4 != 1) {
                if (i4 == 2) {
                    int i5 = bVar.b;
                    if (i5 <= i2) {
                        int i6 = bVar.d;
                        if (i5 + i6 > i2) {
                            return -1;
                        }
                        i2 -= i6;
                    } else {
                        continue;
                    }
                } else if (i4 == 8) {
                    int i7 = bVar.b;
                    if (i7 == i2) {
                        i2 = bVar.d;
                    } else {
                        if (i7 < i2) {
                            i2--;
                        }
                        if (bVar.d <= i2) {
                            i2++;
                        }
                    }
                }
            } else if (bVar.b <= i2) {
                i2 += bVar.d;
            }
        }
        return i2;
    }

    public boolean b(c0 c0Var) {
        k kVar = this.O;
        return kVar == null || kVar.a(c0Var, c0Var.e());
    }

    public void b(int i2) {
        n nVar = this.n;
        if (nVar != null) {
            nVar.h(i2);
        }
        Q();
        s sVar = this.j0;
        if (sVar != null) {
            sVar.onScrollStateChanged(this, i2);
        }
        List<s> list = this.k0;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.k0.get(size).onScrollStateChanged(this, i2);
            }
        }
    }

    public c0 e(View view) {
        View d2 = d(view);
        if (d2 == null) {
            return null;
        }
        return h(d2);
    }

    public void e(int i2) {
        int a2 = this.g.a();
        for (int i3 = 0; i3 < a2; i3++) {
            this.g.b(i3).offsetLeftAndRight(i2);
        }
    }

    public static void e(c0 c0Var) {
        WeakReference<nf> weakReference = c0Var.b;
        if (weakReference != null) {
            nf nfVar = weakReference.get();
            while (nfVar != null) {
                if (nfVar == c0Var.a) {
                    return;
                }
                ViewParent parent = nfVar.getParent();
                nfVar = parent instanceof View ? (View) parent : null;
            }
            c0Var.b = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x011c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(int r18, int r19, android.view.MotionEvent r20, int r21) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.nf.a(int, int, android.view.MotionEvent, int):boolean");
    }

    public void b(View view) {
        c0 l2 = l(view);
        M();
        f fVar = this.m;
        if (fVar != null && l2 != null) {
            fVar.e();
        }
        List<p> list = this.E;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.E.get(size).a(view);
            }
        }
    }

    public void a(int i2, int i3, Interpolator interpolator) {
        a(i2, i3, interpolator, Integer.MIN_VALUE);
    }

    public void a(int i2, int i3, Interpolator interpolator, int i4) {
        a(i2, i3, interpolator, i4, false);
    }

    public void a(int i2, int i3, Interpolator interpolator, int i4, boolean z2) {
        n nVar = this.n;
        if (nVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (this.z) {
        } else {
            if (!nVar.a()) {
                i2 = 0;
            }
            if (!this.n.b()) {
                i3 = 0;
            }
            if (i2 == 0 && i3 == 0) {
                return;
            }
            if (i4 == Integer.MIN_VALUE || i4 > 0) {
                if (z2) {
                    int i5 = i2 != 0 ? 1 : 0;
                    if (i3 != 0) {
                        i5 |= 2;
                    }
                    i(i5, 1);
                }
                this.f0.a(i2, i3, i4, interpolator);
                return;
            }
            scrollBy(i2, i3);
        }
    }

    public void a(int i2, int i3) {
        if (i2 < 0) {
            B();
            if (this.K.isFinished()) {
                this.K.onAbsorb(-i2);
            }
        } else if (i2 > 0) {
            C();
            if (this.M.isFinished()) {
                this.M.onAbsorb(i2);
            }
        }
        if (i3 < 0) {
            D();
            if (this.L.isFinished()) {
                this.L.onAbsorb(-i3);
            }
        } else if (i3 > 0) {
            A();
            if (this.N.isFinished()) {
                this.N.onAbsorb(i3);
            }
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        y9.t(this);
    }

    public final void a(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.j.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof o) {
            o oVar = (o) layoutParams;
            if (!oVar.c) {
                Rect rect = oVar.b;
                Rect rect2 = this.j;
                rect2.left -= rect.left;
                rect2.right += rect.right;
                rect2.top -= rect.top;
                rect2.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.j);
            offsetRectIntoDescendantCoords(view, this.j);
        }
        this.n.a(this, view, this.j, !this.w, view2 == null);
    }

    public void a(r rVar) {
        this.r.add(rVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x005e, code lost:
        if (r6 == 2) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(android.view.MotionEvent r12) {
        /*
            r11 = this;
            int r0 = r12.getAction()
            java.util.ArrayList<nf$r> r1 = r11.r
            int r1 = r1.size()
            r2 = 0
            r3 = r2
        Lc:
            if (r3 >= r1) goto L6e
            java.util.ArrayList<nf$r> r4 = r11.r
            java.lang.Object r4 = r4.get(r3)
            nf$r r4 = (defpackage.nf.r) r4
            r5 = r4
            ef r5 = (defpackage.ef) r5
            int r6 = r5.v
            r7 = 2
            r8 = 1
            if (r6 != r8) goto L5e
            float r6 = r12.getX()
            float r9 = r12.getY()
            boolean r6 = r5.b(r6, r9)
            float r9 = r12.getX()
            float r10 = r12.getY()
            boolean r9 = r5.a(r9, r10)
            int r10 = r12.getAction()
            if (r10 != 0) goto L62
            if (r6 != 0) goto L41
            if (r9 == 0) goto L62
        L41:
            if (r9 == 0) goto L4e
            r5.w = r8
            float r6 = r12.getX()
            int r6 = (int) r6
            float r6 = (float) r6
            r5.p = r6
            goto L5a
        L4e:
            if (r6 == 0) goto L5a
            r5.w = r7
            float r6 = r12.getY()
            int r6 = (int) r6
            float r6 = (float) r6
            r5.m = r6
        L5a:
            r5.a(r7)
            goto L60
        L5e:
            if (r6 != r7) goto L62
        L60:
            r5 = r8
            goto L63
        L62:
            r5 = r2
        L63:
            if (r5 == 0) goto L6b
            r5 = 3
            if (r0 == r5) goto L6b
            r11.s = r4
            return r8
        L6b:
            int r3 = r3 + 1
            goto Lc
        L6e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.nf.a(android.view.MotionEvent):boolean");
    }

    public boolean a(AccessibilityEvent accessibilityEvent) {
        int i2;
        if (J()) {
            if (accessibilityEvent != null) {
                int i3 = Build.VERSION.SDK_INT;
                i2 = accessibilityEvent.getContentChangeTypes();
            } else {
                i2 = 0;
            }
            if (i2 == 0) {
                i2 = 0;
            }
            this.B = i2 | this.B;
            return true;
        }
        return false;
    }

    public final void a(z zVar) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.f0.e;
            zVar.p = overScroller.getFinalX() - overScroller.getCurrX();
            zVar.q = overScroller.getFinalY() - overScroller.getCurrY();
            return;
        }
        zVar.p = 0;
        zVar.q = 0;
    }

    public void a(c0 c0Var, k.c cVar) {
        c0Var.a(0, WebpBitmapFactory.IN_TEMP_BUFFER_SIZE);
        if (this.i0.i && c0Var.m() && !c0Var.j() && !c0Var.o()) {
            this.h.b.b(d(c0Var), c0Var);
        }
        this.h.b(c0Var, cVar);
    }

    public final void a(int[] iArr) {
        int a2 = this.g.a();
        if (a2 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i2 = Integer.MIN_VALUE;
        int i3 = Integer.MAX_VALUE;
        for (int i4 = 0; i4 < a2; i4++) {
            c0 l2 = l(this.g.b(i4));
            if (!l2.o()) {
                int d2 = l2.d();
                if (d2 < i3) {
                    i3 = d2;
                }
                if (d2 > i2) {
                    i2 = d2;
                }
            }
        }
        iArr[0] = i3;
        iArr[1] = i2;
    }

    public void a(c0 c0Var, k.c cVar, k.c cVar2) {
        c0Var.a(false);
        if (this.O.a(c0Var, cVar, cVar2)) {
            S();
        }
    }

    public void a(int i2, int i3, boolean z2) {
        int i4 = i2 + i3;
        int b2 = this.g.b();
        for (int i5 = 0; i5 < b2; i5++) {
            c0 l2 = l(this.g.d(i5));
            if (l2 != null && !l2.o()) {
                int i6 = l2.c;
                if (i6 >= i4) {
                    l2.a(-i3, z2);
                    this.i0.g = true;
                } else if (i6 >= i2) {
                    l2.a(8);
                    l2.a(-i3, z2);
                    l2.c = i2 - 1;
                    this.i0.g = true;
                }
            }
        }
        u uVar = this.d;
        int size = uVar.c.size();
        while (true) {
            size--;
            if (size >= 0) {
                c0 c0Var = uVar.c.get(size);
                if (c0Var != null) {
                    int i7 = c0Var.c;
                    if (i7 >= i4) {
                        c0Var.a(-i3, z2);
                    } else if (i7 >= i2) {
                        c0Var.a(8);
                        uVar.b(size);
                    }
                }
            } else {
                requestLayout();
                return;
            }
        }
    }

    public void a(int i2, int i3, Object obj) {
        int i4;
        int i5;
        int b2 = this.g.b();
        int i6 = i3 + i2;
        for (int i7 = 0; i7 < b2; i7++) {
            View d2 = this.g.d(i7);
            c0 l2 = l(d2);
            if (l2 != null && !l2.o() && (i5 = l2.c) >= i2 && i5 < i6) {
                l2.a(2);
                l2.a(obj);
                ((o) d2.getLayoutParams()).c = true;
            }
        }
        u uVar = this.d;
        int size = uVar.c.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            }
            c0 c0Var = uVar.c.get(size);
            if (c0Var != null && (i4 = c0Var.c) >= i2 && i4 < i6) {
                c0Var.a(2);
                uVar.b(size);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0036 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public defpackage.nf.c0 a(int r6, boolean r7) {
        /*
            r5 = this;
            ye r0 = r5.g
            int r0 = r0.b()
            r1 = 0
            r2 = 0
        L8:
            if (r2 >= r0) goto L3a
            ye r3 = r5.g
            android.view.View r3 = r3.d(r2)
            nf$c0 r3 = l(r3)
            if (r3 == 0) goto L37
            boolean r4 = r3.j()
            if (r4 != 0) goto L37
            if (r7 == 0) goto L23
            int r4 = r3.c
            if (r4 == r6) goto L2a
            goto L37
        L23:
            int r4 = r3.d()
            if (r4 == r6) goto L2a
            goto L37
        L2a:
            ye r1 = r5.g
            android.view.View r4 = r3.a
            boolean r1 = r1.b(r4)
            if (r1 == 0) goto L36
            r1 = r3
            goto L37
        L36:
            return r3
        L37:
            int r2 = r2 + 1
            goto L8
        L3a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.nf.a(int, boolean):nf$c0");
    }

    public c0 a(long j2) {
        f fVar = this.m;
        c0 c0Var = null;
        if (fVar != null && fVar.b) {
            int b2 = this.g.b();
            for (int i2 = 0; i2 < b2; i2++) {
                c0 l2 = l(this.g.d(i2));
                if (l2 != null && !l2.j() && l2.e == j2) {
                    if (!this.g.b(l2.a)) {
                        return l2;
                    }
                    c0Var = l2;
                }
            }
        }
        return c0Var;
    }

    public static void a(View view, Rect rect) {
        o oVar = (o) view.getLayoutParams();
        Rect rect2 = oVar.b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) oVar).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) oVar).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) oVar).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) oVar).bottomMargin);
    }

    public boolean a(c0 c0Var, int i2) {
        if (J()) {
            c0Var.q = i2;
            this.v0.add(c0Var);
            return false;
        }
        y9.a(c0Var.a, i2);
        return true;
    }

    public void a(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable != null && drawable != null && stateListDrawable2 != null && drawable2 != null) {
            Resources resources = getContext().getResources();
            new ef(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(ve.fastscroll_default_thickness), resources.getDimensionPixelSize(ve.fastscroll_minimum_range), resources.getDimensionPixelOffset(ve.fastscroll_margin));
            return;
        }
        throw new IllegalArgumentException(jg.a(this, jg.a("Trying to set fast scroller without both required drawables.")));
    }

    public final void a(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        getScrollingChildHelper().b(i2, i3, i4, i5, iArr, i6, iArr2);
    }

    public boolean a(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return getScrollingChildHelper().a(i2, i3, iArr, iArr2, i4);
    }
}
