package defpackage;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.xiaopeng.xui.drawable.XToggleDrawable;
/* compiled from: ForwardingListener.java */
/* renamed from: w3  reason: default package */
/* loaded from: classes.dex */
public abstract class w3 implements View.OnTouchListener, View.OnAttachStateChangeListener {
    public final float c;
    public final int d;
    public final int e;
    public final View f;
    public Runnable g;
    public Runnable h;
    public boolean i;
    public int j;
    public final int[] k = new int[2];

    /* compiled from: ForwardingListener.java */
    /* renamed from: w3$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = w3.this.f.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* compiled from: ForwardingListener.java */
    /* renamed from: w3$b */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            w3 w3Var = w3.this;
            w3Var.a();
            View view = w3Var.f;
            if (view.isEnabled() && !view.isLongClickable() && w3Var.c()) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, XToggleDrawable.LIGHT_RADIUS_DEFAULT, XToggleDrawable.LIGHT_RADIUS_DEFAULT, 0);
                view.onTouchEvent(obtain);
                obtain.recycle();
                w3Var.i = true;
            }
        }
    }

    public w3(View view) {
        this.f = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.c = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.d = ViewConfiguration.getTapTimeout();
        this.e = (ViewConfiguration.getLongPressTimeout() + this.d) / 2;
    }

    public final void a() {
        Runnable runnable = this.h;
        if (runnable != null) {
            this.f.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.g;
        if (runnable2 != null) {
            this.f.removeCallbacks(runnable2);
        }
    }

    public abstract j2 b();

    public abstract boolean c();

    public boolean d() {
        j2 b2 = b();
        if (b2 == null || !b2.b()) {
            return true;
        }
        b2.dismiss();
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0087, code lost:
        if (r4 != 3) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0113  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.View r12, android.view.MotionEvent r13) {
        /*
            Method dump skipped, instructions count: 305
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.w3.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.i = false;
        this.j = -1;
        Runnable runnable = this.g;
        if (runnable != null) {
            this.f.removeCallbacks(runnable);
        }
    }
}
