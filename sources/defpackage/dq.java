package defpackage;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* compiled from: ViewTarget.java */
@Deprecated
/* renamed from: dq  reason: default package */
/* loaded from: classes.dex */
public abstract class dq<T extends View, Z> extends up<Z> {
    public static int h = rg.glide_custom_view_target_tag;
    public final T c;
    public final a d;
    public View.OnAttachStateChangeListener e;
    public boolean f;
    public boolean g;

    public dq(T t) {
        defpackage.a.a(t, "Argument must not be null");
        this.c = t;
        this.d = new a(t);
    }

    @Override // defpackage.cq
    public void a(bq bqVar) {
        this.d.b.remove(bqVar);
    }

    @Override // defpackage.up, defpackage.cq
    public void b(Drawable drawable) {
        super.b(drawable);
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.e;
        if (onAttachStateChangeListener == null || this.g) {
            return;
        }
        this.c.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.g = true;
    }

    @Override // defpackage.up, defpackage.cq
    public void c(Drawable drawable) {
        View.OnAttachStateChangeListener onAttachStateChangeListener;
        super.c(drawable);
        this.d.a();
        if (this.f || (onAttachStateChangeListener = this.e) == null || !this.g) {
            return;
        }
        this.c.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.g = false;
    }

    public String toString() {
        StringBuilder a2 = jg.a("Target for: ");
        a2.append(this.c);
        return a2.toString();
    }

    @Override // defpackage.cq
    public void a(np npVar) {
        this.c.setTag(h, npVar);
    }

    /* compiled from: ViewTarget.java */
    /* renamed from: dq$a */
    /* loaded from: classes.dex */
    public static final class a {
        public static Integer e;
        public final View a;
        public final List<bq> b = new ArrayList();
        public boolean c;
        public ViewTreeObserver$OnPreDrawListenerC0004a d;

        /* compiled from: ViewTarget.java */
        /* renamed from: dq$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class ViewTreeObserver$OnPreDrawListenerC0004a implements ViewTreeObserver.OnPreDrawListener {
            public final WeakReference<a> c;

            public ViewTreeObserver$OnPreDrawListenerC0004a(a aVar) {
                this.c = new WeakReference<>(aVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    Log.v("ViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                a aVar = this.c.get();
                if (aVar == null || aVar.b.isEmpty()) {
                    return true;
                }
                int c = aVar.c();
                int b = aVar.b();
                if (aVar.a(c, b)) {
                    Iterator it = new ArrayList(aVar.b).iterator();
                    while (it.hasNext()) {
                        ((sp) it.next()).a(c, b);
                    }
                    aVar.a();
                    return true;
                }
                return true;
            }
        }

        public a(View view) {
            this.a = view;
        }

        public void a() {
            ViewTreeObserver viewTreeObserver = this.a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.d);
            }
            this.d = null;
            this.b.clear();
        }

        public final boolean a(int i, int i2) {
            if (i > 0 || i == Integer.MIN_VALUE) {
                return i2 > 0 || i2 == Integer.MIN_VALUE;
            }
            return false;
        }

        public final int b() {
            int paddingBottom = this.a.getPaddingBottom() + this.a.getPaddingTop();
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            return a(this.a.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingBottom);
        }

        public final int c() {
            int paddingRight = this.a.getPaddingRight() + this.a.getPaddingLeft();
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            return a(this.a.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingRight);
        }

        public final int a(int i, int i2, int i3) {
            int i4 = i2 - i3;
            if (i4 > 0) {
                return i4;
            }
            if (this.c && this.a.isLayoutRequested()) {
                return 0;
            }
            int i5 = i - i3;
            if (i5 > 0) {
                return i5;
            }
            if (this.a.isLayoutRequested() || i2 != -2) {
                return 0;
            }
            if (Log.isLoggable("ViewTarget", 4)) {
                Log.i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            Context context = this.a.getContext();
            if (e == null) {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                defpackage.a.a(windowManager, "Argument must not be null");
                Display defaultDisplay = windowManager.getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                e = Integer.valueOf(Math.max(point.x, point.y));
            }
            return e.intValue();
        }
    }

    @Override // defpackage.cq
    public void b(bq bqVar) {
        a aVar = this.d;
        int c = aVar.c();
        int b = aVar.b();
        if (aVar.a(c, b)) {
            ((sp) bqVar).a(c, b);
            return;
        }
        if (!aVar.b.contains(bqVar)) {
            aVar.b.add(bqVar);
        }
        if (aVar.d == null) {
            ViewTreeObserver viewTreeObserver = aVar.a.getViewTreeObserver();
            aVar.d = new a.ViewTreeObserver$OnPreDrawListenerC0004a(aVar);
            viewTreeObserver.addOnPreDrawListener(aVar.d);
        }
    }

    @Override // defpackage.cq
    public np c() {
        Object tag = this.c.getTag(h);
        if (tag != null) {
            if (tag instanceof np) {
                return (np) tag;
            }
            throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
        }
        return null;
    }
}
