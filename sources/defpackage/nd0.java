package defpackage;

import android.app.Activity;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import com.xiaopeng.xui.drawable.XToggleDrawable;
/* compiled from: XPanelActivity.java */
/* renamed from: nd0  reason: default package */
/* loaded from: classes.dex */
public class nd0 extends t0 {
    public static final Uri C = Settings.System.getUriFor("key_panel_car_speed");
    public d A;
    public float r = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
    public final Runnable s = new a();
    public final Handler t = new Handler();
    public boolean u = false;
    public boolean v = true;
    public float w = 0.6f;
    public long x = 0;
    public boolean y = false;
    public int z = 0;
    public ContentObserver B = new c(this.t);

    /* compiled from: XPanelActivity.java */
    /* renamed from: nd0$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            nd0.a(nd0.this);
        }
    }

    /* compiled from: XPanelActivity.java */
    /* renamed from: nd0$b */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public final /* synthetic */ int c;

        public b(int i) {
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            nd0 nd0Var;
            int i = this.c;
            if (i != 0) {
                if (i == 1 && (nd0Var = nd0.this) != null) {
                    try {
                        boolean isChild = nd0Var.isChild();
                        if (nd0Var.moveTaskToBack(true) || isChild) {
                            return;
                        }
                        z90.a(nd0Var);
                        return;
                    } catch (Exception e) {
                        be0.a("ActivityUtils", "moveTaskToBack e=" + e);
                        return;
                    }
                }
                return;
            }
            nd0 nd0Var2 = nd0.this;
            if (nd0Var2 != null) {
                try {
                    boolean isChild2 = nd0Var2.isChild();
                    nd0Var2.finish();
                    if (nd0Var2.isFinishing() || isChild2) {
                        return;
                    }
                    z90.a(nd0Var2);
                } catch (Exception e2) {
                    be0.a("ActivityUtils", "finish e=" + e2);
                }
            }
        }
    }

    /* compiled from: XPanelActivity.java */
    /* renamed from: nd0$c */
    /* loaded from: classes.dex */
    public class c extends ContentObserver {
        public c(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z, Uri uri) {
            super.onChange(z, uri);
            nd0.this.f(true);
        }
    }

    /* compiled from: XPanelActivity.java */
    /* renamed from: nd0$d */
    /* loaded from: classes.dex */
    public static final class d {
        public int a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public final Activity h;

        public d(Activity activity) {
            WindowManager.LayoutParams attributes;
            this.h = activity;
            Activity activity2 = this.h;
            if (activity2 == null || activity2.getWindow() == null || (attributes = this.h.getWindow().getAttributes()) == null) {
                return;
            }
            this.a = attributes.x;
            this.b = attributes.y;
            this.c = attributes.flags;
            this.d = attributes.width;
            this.e = attributes.height;
            this.f = attributes.gravity;
            this.g = attributes.systemUiVisibility;
        }

        public void a() {
            WindowManager.LayoutParams attributes;
            Activity activity = this.h;
            if (activity == null || activity.getWindow() == null || (attributes = this.h.getWindow().getAttributes()) == null) {
                return;
            }
            attributes.x = this.a;
            attributes.y = this.b;
            attributes.flags |= this.c;
            attributes.width = this.d;
            attributes.height = this.e;
            attributes.gravity = this.f;
            attributes.systemUiVisibility |= this.g;
            this.h.getWindow().setAttributes(attributes);
        }
    }

    public static /* synthetic */ void a(nd0 nd0Var) {
        if (nd0Var.y() > XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
            nd0Var.z();
        }
    }

    public void d(int i) {
        this.z = i;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        f(false);
        return super.dispatchTouchEvent(motionEvent);
    }

    public void e(boolean z) {
        Window window;
        if (!this.y || (window = getWindow()) == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (attributes != null) {
            float f = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
            attributes.alpha = z ? 1.0f : 0.0f;
            if (z) {
                f = this.w;
            }
            attributes.dimAmount = f;
        }
        window.setAttributes(attributes);
    }

    public final void f(boolean z) {
        float f;
        try {
            f = Settings.System.getFloat(getContentResolver(), "key_panel_car_speed", XToggleDrawable.LIGHT_RADIUS_DEFAULT);
        } catch (Exception unused) {
            f = 0.0f;
        }
        boolean z2 = true;
        if (z && this.r * f > XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
            z2 = false;
        }
        if (f <= XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
            this.t.removeCallbacks(this.s);
        } else if (z2) {
            this.t.removeCallbacks(this.s);
            this.t.postDelayed(this.s, 30000L);
        }
        this.r = f;
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
    }

    public void g(boolean z) {
        this.y = z;
    }

    public void h(boolean z) {
        this.u = z;
    }

    @Override // android.app.Activity
    public boolean moveTaskToBack(boolean z) {
        return super.moveTaskToBack(z);
    }

    @Override // defpackage.bc, androidx.activity.ComponentActivity, defpackage.g7, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(14);
        super.onCreate(bundle);
        this.A = new d(this);
    }

    @Override // defpackage.bc, android.app.Activity
    public void onPause() {
        super.onPause();
        e(false);
        try {
            getApplicationContext().getContentResolver().unregisterContentObserver(this.B);
        } catch (Exception unused) {
        }
        if (this.v) {
            z();
        }
        this.v = true;
    }

    @Override // defpackage.t0, android.app.Activity
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        int i = getResources().getConfiguration().orientation;
        int a2 = a(this, wc0.x_compat_app_panel_x);
        int a3 = a(this, wc0.x_compat_app_panel_y);
        int a4 = a(this, wc0.x_compat_app_panel_width);
        int a5 = a(this, wc0.x_compat_app_panel_height);
        if (i == 1) {
            d x = x();
            x.a = a2;
            x.b = a3;
            x.d = a4;
            x.e = a5;
            x.f = 80;
            x.a();
        } else if (i != 2) {
        } else {
            d x2 = x();
            x2.a = a2;
            x2.b = a3;
            x2.d = a4;
            x2.e = a5;
            x2.f = 49;
            x2.a();
        }
    }

    @Override // defpackage.bc, android.app.Activity
    public void onResume() {
        super.onResume();
        f(false);
        e(true);
        try {
            getApplicationContext().getContentResolver().registerContentObserver(C, true, this.B);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0039, code lost:
        if ((r0 < r6 || r3 < r6 || r0 > r5.getWidth() + r4 || r3 > r5.getHeight() + r4) == false) goto L25;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            int r0 = r8.getAction()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L3b
            float r0 = r8.getX()
            int r0 = (int) r0
            float r3 = r8.getY()
            int r3 = (int) r3
            android.view.ViewConfiguration r4 = android.view.ViewConfiguration.get(r7)
            int r4 = r4.getScaledWindowTouchSlop()
            android.view.Window r5 = r7.getWindow()
            android.view.View r5 = r5.getDecorView()
            int r6 = -r4
            if (r0 < r6) goto L38
            if (r3 < r6) goto L38
            int r6 = r5.getWidth()
            int r6 = r6 + r4
            if (r0 > r6) goto L38
            int r0 = r5.getHeight()
            int r0 = r0 + r4
            if (r3 <= r0) goto L36
            goto L38
        L36:
            r0 = r1
            goto L39
        L38:
            r0 = r2
        L39:
            if (r0 != 0) goto L42
        L3b:
            int r0 = r8.getAction()
            r3 = 4
            if (r0 != r3) goto L44
        L42:
            r0 = r2
            goto L45
        L44:
            r0 = r1
        L45:
            android.view.Window r3 = r7.getWindow()
            android.view.View r3 = r3.getDecorView()
            boolean r4 = r7.u
            if (r4 == 0) goto L56
            if (r3 == 0) goto L56
            if (r0 == 0) goto L56
            r1 = r2
        L56:
            if (r1 == 0) goto L5c
            r7.z()
            return r2
        L5c:
            boolean r8 = super.onTouchEvent(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.nd0.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void q() {
        f(false);
    }

    @Override // android.app.Activity
    public void recreate() {
        super.recreate();
        this.v = false;
    }

    public d x() {
        return this.A;
    }

    public final float y() {
        try {
            return Settings.System.getFloat(getContentResolver(), "key_panel_car_speed", XToggleDrawable.LIGHT_RADIUS_DEFAULT);
        } catch (Exception unused) {
            return XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        }
    }

    public void z() {
        b bVar = new b(this.z);
        e(false);
        this.t.postDelayed(bVar, this.x);
    }

    public static int a(Context context, int i) {
        return (int) ((context.getResources().getDimension(i) * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
