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
import defpackage.ug;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* compiled from: CustomViewTarget.java */
/* renamed from: xp  reason: default package */
/* loaded from: classes.dex */
public abstract class xp<T extends View, Z> implements cq<Z> {
    public static final int h = rg.glide_custom_view_target_tag;
    public final a c;
    public final T d;
    public View.OnAttachStateChangeListener e;
    public boolean f;
    public boolean g;

    public xp(T t) {
        defpackage.a.a(t, "Argument must not be null");
        this.d = t;
        this.c = new a(t);
    }

    @Override // defpackage.ro
    public void a() {
    }

    @Override // defpackage.cq
    public final void a(bq bqVar) {
        this.c.b.remove(bqVar);
    }

    @Override // defpackage.ro
    public void b() {
    }

    @Override // defpackage.cq
    public final void b(bq bqVar) {
        a aVar = this.c;
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
            aVar.d = new a.ViewTreeObserver$OnPreDrawListenerC0014a(aVar);
            viewTreeObserver.addOnPreDrawListener(aVar.d);
        }
    }

    @Override // defpackage.cq
    public final void c(Drawable drawable) {
        View.OnAttachStateChangeListener onAttachStateChangeListener;
        this.c.a();
        ug.b bVar = (ug.b) this;
        if (this.f || (onAttachStateChangeListener = this.e) == null || !this.g) {
            return;
        }
        this.d.removeOnAttachStateChangeListener(onAttachStateChangeListener);
        this.g = false;
    }

    @Override // defpackage.ro
    public void onStart() {
    }

    public String toString() {
        StringBuilder a2 = jg.a("Target for: ");
        a2.append(this.d);
        return a2.toString();
    }

    @Override // defpackage.cq
    public final void a(np npVar) {
        this.d.setTag(h, npVar);
    }

    /* compiled from: CustomViewTarget.java */
    /* renamed from: xp$a */
    /* loaded from: classes.dex */
    public static final class a {
        public static Integer e;
        public final View a;
        public final List<bq> b = new ArrayList();
        public boolean c;
        public ViewTreeObserver$OnPreDrawListenerC0014a d;

        /* compiled from: CustomViewTarget.java */
        /* renamed from: xp$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class ViewTreeObserver$OnPreDrawListenerC0014a implements ViewTreeObserver.OnPreDrawListener {
            public final WeakReference<a> c;

            public ViewTreeObserver$OnPreDrawListenerC0014a(a aVar) {
                this.c = new WeakReference<>(aVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("CustomViewTarget", 2)) {
                    Log.v("CustomViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
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
            if (Log.isLoggable("CustomViewTarget", 4)) {
                Log.i("CustomViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
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
    public final np c() {
        Object tag = this.d.getTag(h);
        if (tag != null) {
            if (tag instanceof np) {
                return (np) tag;
            }
            throw new IllegalArgumentException("You must not pass non-R.id ids to setTag(id)");
        }
        return null;
    }

    @Override // defpackage.cq
    public final void b(Drawable drawable) {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.e;
        if (onAttachStateChangeListener == null || this.g) {
            return;
        }
        this.d.addOnAttachStateChangeListener(onAttachStateChangeListener);
        this.g = true;
    }
}
