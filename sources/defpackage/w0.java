package defpackage;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import com.bumptech.glide.integration.webp.WebpBitmapFactory;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import defpackage.g1;
import defpackage.g2;
import defpackage.l1;
import defpackage.p1;
import defpackage.z1;
import java.lang.Thread;
import java.util.Calendar;
import java.util.List;
/* compiled from: AppCompatDelegateImpl.java */
/* renamed from: w0  reason: default package */
/* loaded from: classes.dex */
public class w0 extends v0 implements z1.a, LayoutInflater.Factory2 {
    public static final f5<String, Integer> c0 = new f5<>();
    public static final boolean d0;
    public static final int[] e0;
    public static final boolean f0;
    public static final boolean g0;
    public static boolean h0;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public j[] H;
    public j I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public int O;
    public int P;
    public boolean Q;
    public boolean R;
    public g S;
    public g T;
    public boolean U;
    public int V;
    public boolean X;
    public Rect Y;
    public Rect Z;
    public d1 a0;
    public e1 b0;
    public final Object e;
    public final Context f;
    public Window g;
    public e h;
    public final u0 i;
    public j0 j;
    public MenuInflater k;
    public CharSequence l;
    public r3 m;
    public c n;
    public k o;
    public l1 p;
    public ActionBarContextView q;
    public PopupWindow r;
    public Runnable s;
    public boolean v;
    public ViewGroup w;
    public TextView x;
    public View y;
    public boolean z;
    public fa t = null;
    public boolean u = true;
    public final Runnable W = new b();

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: w0$a */
    /* loaded from: classes.dex */
    public class a implements Thread.UncaughtExceptionHandler {
        public final /* synthetic */ Thread.UncaughtExceptionHandler a;

        public a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            this.a = uncaughtExceptionHandler;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            String message;
            boolean z = false;
            if ((th instanceof Resources.NotFoundException) && (message = th.getMessage()) != null && (message.contains("drawable") || message.contains("Drawable"))) {
                z = true;
            }
            if (z) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                notFoundException.initCause(th.getCause());
                notFoundException.setStackTrace(th.getStackTrace());
                this.a.uncaughtException(thread, notFoundException);
                return;
            }
            this.a.uncaughtException(thread, th);
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: w0$b */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            w0 w0Var = w0.this;
            if ((w0Var.V & 1) != 0) {
                w0Var.c(0);
            }
            w0 w0Var2 = w0.this;
            if ((w0Var2.V & 4096) != 0) {
                w0Var2.c(108);
            }
            w0 w0Var3 = w0.this;
            w0Var3.U = false;
            w0Var3.V = 0;
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: w0$e */
    /* loaded from: classes.dex */
    public class e extends s1 {
        public e(Window.Callback callback) {
            super(callback);
        }

        public final ActionMode a(ActionMode.Callback callback) {
            p1.a aVar = new p1.a(w0.this.f, callback);
            l1 a = w0.this.a(aVar);
            if (a != null) {
                return aVar.b(a);
            }
            return null;
        }

        @Override // android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return w0.this.a(keyEvent) || this.c.dispatchKeyEvent(keyEvent);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0049, code lost:
            if (r6 != false) goto L7;
         */
        /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
        @Override // android.view.Window.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean dispatchKeyShortcutEvent(android.view.KeyEvent r6) {
            /*
                r5 = this;
                android.view.Window$Callback r0 = r5.c
                boolean r0 = r0.dispatchKeyShortcutEvent(r6)
                r1 = 0
                r2 = 1
                if (r0 != 0) goto L4f
                w0 r0 = defpackage.w0.this
                int r3 = r6.getKeyCode()
                r0.k()
                j0 r4 = r0.j
                if (r4 == 0) goto L1f
                boolean r3 = r4.a(r3, r6)
                if (r3 == 0) goto L1f
            L1d:
                r6 = r2
                goto L4d
            L1f:
                w0$j r3 = r0.I
                if (r3 == 0) goto L34
                int r4 = r6.getKeyCode()
                boolean r3 = r0.a(r3, r4, r6, r2)
                if (r3 == 0) goto L34
                w0$j r6 = r0.I
                if (r6 == 0) goto L1d
                r6.n = r2
                goto L1d
            L34:
                w0$j r3 = r0.I
                if (r3 != 0) goto L4c
                w0$j r3 = r0.d(r1)
                r0.b(r3, r6)
                int r4 = r6.getKeyCode()
                boolean r6 = r0.a(r3, r4, r6, r2)
                r3.m = r1
                if (r6 == 0) goto L4c
                goto L1d
            L4c:
                r6 = r1
            L4d:
                if (r6 == 0) goto L50
            L4f:
                r1 = r2
            L50:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.w0.e.dispatchKeyShortcutEvent(android.view.KeyEvent):boolean");
        }

        @Override // android.view.Window.Callback
        public void onContentChanged() {
        }

        @Override // android.view.Window.Callback
        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof z1)) {
                return this.c.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        @Override // android.view.Window.Callback
        public boolean onMenuOpened(int i, Menu menu) {
            this.c.onMenuOpened(i, menu);
            w0.this.f(i);
            return true;
        }

        @Override // android.view.Window.Callback
        public void onPanelClosed(int i, Menu menu) {
            this.c.onPanelClosed(i, menu);
            w0.this.g(i);
        }

        @Override // android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            z1 z1Var = menu instanceof z1 ? (z1) menu : null;
            if (i == 0 && z1Var == null) {
                return false;
            }
            if (z1Var != null) {
                z1Var.z = true;
            }
            boolean onPreparePanel = this.c.onPreparePanel(i, view, menu);
            if (z1Var != null) {
                z1Var.z = false;
            }
            return onPreparePanel;
        }

        @Override // android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            z1 z1Var;
            j d = w0.this.d(0);
            if (d != null && (z1Var = d.j) != null) {
                this.c.onProvideKeyboardShortcuts(list, z1Var, i);
            } else {
                this.c.onProvideKeyboardShortcuts(list, menu, i);
            }
        }

        @Override // android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            int i = Build.VERSION.SDK_INT;
            return null;
        }

        @Override // android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (w0.this.u && i == 0) {
                return a(callback);
            }
            return this.c.onWindowStartingActionMode(callback, i);
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: w0$f */
    /* loaded from: classes.dex */
    public class f extends g {
        public final PowerManager c;

        public f(Context context) {
            super();
            this.c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        @Override // defpackage.w0.g
        public IntentFilter b() {
            int i = Build.VERSION.SDK_INT;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        @Override // defpackage.w0.g
        public int c() {
            int i = Build.VERSION.SDK_INT;
            return this.c.isPowerSaveMode() ? 2 : 1;
        }

        @Override // defpackage.w0.g
        public void d() {
            w0.this.d();
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: w0$g */
    /* loaded from: classes.dex */
    public abstract class g {
        public BroadcastReceiver a;

        /* compiled from: AppCompatDelegateImpl.java */
        /* renamed from: w0$g$a */
        /* loaded from: classes.dex */
        public class a extends BroadcastReceiver {
            public a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                g.this.d();
            }
        }

        public g() {
        }

        public void a() {
            BroadcastReceiver broadcastReceiver = this.a;
            if (broadcastReceiver != null) {
                try {
                    w0.this.f.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.a = null;
            }
        }

        public abstract IntentFilter b();

        public abstract int c();

        public abstract void d();

        public void e() {
            a();
            IntentFilter b = b();
            if (b == null || b.countActions() == 0) {
                return;
            }
            if (this.a == null) {
                this.a = new a();
            }
            w0.this.f.registerReceiver(this.a, b);
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: w0$h */
    /* loaded from: classes.dex */
    public class h extends g {
        public final g1 c;

        public h(g1 g1Var) {
            super();
            this.c = g1Var;
        }

        @Override // defpackage.w0.g
        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        @Override // defpackage.w0.g
        public int c() {
            boolean z;
            long j;
            g1 g1Var = this.c;
            g1.a aVar = g1Var.c;
            if (aVar.f > System.currentTimeMillis()) {
                z = aVar.a;
            } else {
                Location a = defpackage.a.a(g1Var.a, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? g1Var.a("network") : null;
                Location a2 = defpackage.a.a(g1Var.a, "android.permission.ACCESS_FINE_LOCATION") == 0 ? g1Var.a("gps") : null;
                if (a2 == null || a == null ? a2 != null : a2.getTime() > a.getTime()) {
                    a = a2;
                }
                if (a != null) {
                    g1.a aVar2 = g1Var.c;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (f1.d == null) {
                        f1.d = new f1();
                    }
                    f1 f1Var = f1.d;
                    f1Var.a(currentTimeMillis - 86400000, a.getLatitude(), a.getLongitude());
                    long j2 = f1Var.a;
                    f1Var.a(currentTimeMillis, a.getLatitude(), a.getLongitude());
                    boolean z2 = f1Var.c == 1;
                    long j3 = f1Var.b;
                    long j4 = f1Var.a;
                    f1Var.a(currentTimeMillis + 86400000, a.getLatitude(), a.getLongitude());
                    long j5 = f1Var.b;
                    if (j3 == -1 || j4 == -1) {
                        j = 43200000 + currentTimeMillis;
                    } else {
                        j = (currentTimeMillis > j4 ? 0 + j5 : currentTimeMillis > j3 ? 0 + j4 : 0 + j3) + 60000;
                    }
                    aVar2.a = z2;
                    aVar2.b = j2;
                    aVar2.c = j3;
                    aVar2.d = j4;
                    aVar2.e = j5;
                    aVar2.f = j;
                    z = aVar.a;
                } else {
                    Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
                    int i = Calendar.getInstance().get(11);
                    z = i < 6 || i >= 22;
                }
            }
            return z ? 2 : 1;
        }

        @Override // defpackage.w0.g
        public void d() {
            w0.this.d();
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: w0$i */
    /* loaded from: classes.dex */
    public class i extends ContentFrameLayout {
        public i(Context context) {
            super(context);
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return w0.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (x < -5 || y < -5 || x > getWidth() + 5 || y > getHeight() + 5) {
                    w0 w0Var = w0.this;
                    w0Var.a(w0Var.d(0), true);
                    return true;
                }
            }
            return super.onInterceptTouchEvent(motionEvent);
        }

        @Override // android.view.View
        public void setBackgroundResource(int i) {
            setBackgroundDrawable(i1.b(getContext(), i));
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        d0 = false;
        e0 = new int[]{16842836};
        f0 = !"robolectric".equals(Build.FINGERPRINT);
        int i3 = Build.VERSION.SDK_INT;
        g0 = true;
        if (!d0 || h0) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(new a(Thread.getDefaultUncaughtExceptionHandler()));
        h0 = true;
    }

    public w0(Context context, Window window, u0 u0Var, Object obj) {
        Integer orDefault;
        t0 t0Var;
        this.O = -100;
        this.f = context;
        this.i = u0Var;
        this.e = obj;
        if (this.O == -100 && (this.e instanceof Dialog)) {
            for (Context context2 = this.f; context2 != null; context2 = ((ContextWrapper) context2).getBaseContext()) {
                if (context2 instanceof t0) {
                    t0Var = (t0) context2;
                    break;
                } else if (!(context2 instanceof ContextWrapper)) {
                    break;
                }
            }
            t0Var = null;
            if (t0Var != null) {
                this.O = ((w0) t0Var.k()).O;
            }
        }
        if (this.O == -100 && (orDefault = c0.getOrDefault(this.e.getClass().getName(), null)) != null) {
            this.O = orDefault.intValue();
            c0.remove(this.e.getClass().getName());
        }
        if (window != null) {
            a(window);
        }
        w2.b();
    }

    @Override // defpackage.v0
    public void a(Bundle bundle) {
        this.K = true;
        a(false);
        h();
        Object obj = this.e;
        if (obj instanceof Activity) {
            String str = null;
            try {
                Activity activity = (Activity) obj;
                try {
                    str = defpackage.a.b((Context) activity, activity.getComponentName());
                } catch (PackageManager.NameNotFoundException e2) {
                    throw new IllegalArgumentException(e2);
                }
            } catch (IllegalArgumentException unused) {
            }
            if (str != null) {
                j0 j0Var = this.j;
                if (j0Var == null) {
                    this.X = true;
                } else {
                    j0Var.b(true);
                }
            }
            v0.a(this);
        }
        this.L = true;
    }

    @Override // defpackage.v0
    public void b() {
        k();
        j0 j0Var = this.j;
        e(0);
    }

    @Override // defpackage.v0
    public void b(Bundle bundle) {
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    @Override // defpackage.v0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.e
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L9
            defpackage.v0.b(r3)
        L9:
            boolean r0 = r3.U
            if (r0 == 0) goto L18
            android.view.Window r0 = r3.g
            android.view.View r0 = r0.getDecorView()
            java.lang.Runnable r1 = r3.W
            r0.removeCallbacks(r1)
        L18:
            r0 = 0
            r3.M = r0
            r0 = 1
            r3.N = r0
            int r0 = r3.O
            r1 = -100
            if (r0 == r1) goto L48
            java.lang.Object r0 = r3.e
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L48
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L48
            f5<java.lang.String, java.lang.Integer> r0 = defpackage.w0.c0
            java.lang.Object r1 = r3.e
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.O
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L57
        L48:
            f5<java.lang.String, java.lang.Integer> r0 = defpackage.w0.c0
            java.lang.Object r1 = r3.e
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L57:
            j0 r0 = r3.j
            if (r0 == 0) goto L5e
            r0.d()
        L5e:
            w0$g r0 = r3.S
            if (r0 == 0) goto L65
            r0.a()
        L65:
            w0$g r0 = r3.T
            if (r0 == 0) goto L6c
            r0.a()
        L6c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.w0.c():void");
    }

    public j d(int i2) {
        j[] jVarArr = this.H;
        if (jVarArr == null || jVarArr.length <= i2) {
            j[] jVarArr2 = new j[i2 + 1];
            if (jVarArr != null) {
                System.arraycopy(jVarArr, 0, jVarArr2, 0, jVarArr.length);
            }
            this.H = jVarArr2;
            jVarArr = jVarArr2;
        }
        j jVar = jVarArr[i2];
        if (jVar == null) {
            j jVar2 = new j(i2);
            jVarArr[i2] = jVar2;
            return jVar2;
        }
        return jVar;
    }

    public final void e(int i2) {
        this.V = (1 << i2) | this.V;
        if (this.U) {
            return;
        }
        y9.a(this.g.getDecorView(), this.W);
        this.U = true;
    }

    public void f(int i2) {
        if (i2 == 108) {
            k();
            j0 j0Var = this.j;
            if (j0Var != null) {
                j0Var.a(true);
            }
        }
    }

    public void g(int i2) {
        if (i2 == 108) {
            k();
            j0 j0Var = this.j;
            if (j0Var != null) {
                j0Var.a(false);
            }
        } else if (i2 == 0) {
            j d2 = d(i2);
            if (d2.o) {
                a(d2, false);
            }
        }
    }

    public final void h() {
        if (this.g == null) {
            Object obj = this.e;
            if (obj instanceof Activity) {
                a(((Activity) obj).getWindow());
            }
        }
        if (this.g == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    public final Context i() {
        k();
        j0 j0Var = this.j;
        Context c2 = j0Var != null ? j0Var.c() : null;
        return c2 == null ? this.f : c2;
    }

    public final Window.Callback j() {
        return this.g.getCallback();
    }

    public final void k() {
        g();
        if (this.B && this.j == null) {
            Object obj = this.e;
            if (obj instanceof Activity) {
                this.j = new h1((Activity) obj, this.C);
            } else if (obj instanceof Dialog) {
                this.j = new h1((Dialog) obj);
            }
            j0 j0Var = this.j;
            if (j0Var != null) {
                j0Var.b(this.X);
            }
        }
    }

    public final boolean l() {
        ViewGroup viewGroup;
        return this.v && (viewGroup = this.w) != null && y9.r(viewGroup);
    }

    public final void m() {
        if (this.v) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x007a, code lost:
        if (((org.xmlpull.v1.XmlPullParser) r14).getDepth() > 1) goto L26;
     */
    @Override // android.view.LayoutInflater.Factory2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View onCreateView(android.view.View r11, java.lang.String r12, android.content.Context r13, android.util.AttributeSet r14) {
        /*
            r10 = this;
            d1 r0 = r10.a0
            r1 = 0
            if (r0 != 0) goto L55
            android.content.Context r0 = r10.f
            int[] r2 = defpackage.i0.AppCompatTheme
            android.content.res.TypedArray r0 = r0.obtainStyledAttributes(r2)
            int r2 = defpackage.i0.AppCompatTheme_viewInflaterClass
            java.lang.String r2 = r0.getString(r2)
            if (r2 != 0) goto L1d
            d1 r0 = new d1
            r0.<init>()
            r10.a0 = r0
            goto L55
        L1d:
            java.lang.Class r0 = java.lang.Class.forName(r2)     // Catch: java.lang.Throwable -> L32
            java.lang.Class[] r3 = new java.lang.Class[r1]     // Catch: java.lang.Throwable -> L32
            java.lang.reflect.Constructor r0 = r0.getDeclaredConstructor(r3)     // Catch: java.lang.Throwable -> L32
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L32
            java.lang.Object r0 = r0.newInstance(r3)     // Catch: java.lang.Throwable -> L32
            d1 r0 = (defpackage.d1) r0     // Catch: java.lang.Throwable -> L32
            r10.a0 = r0     // Catch: java.lang.Throwable -> L32
            goto L55
        L32:
            r0 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Failed to instantiate custom view inflater "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r2 = ". Falling back to default."
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            java.lang.String r3 = "AppCompatDelegate"
            android.util.Log.i(r3, r2, r0)
            d1 r0 = new d1
            r0.<init>()
            r10.a0 = r0
        L55:
            boolean r0 = defpackage.w0.d0
            r2 = 1
            if (r0 == 0) goto La2
            e1 r0 = r10.b0
            if (r0 != 0) goto L65
            e1 r0 = new e1
            r0.<init>()
            r10.b0 = r0
        L65:
            e1 r0 = r10.b0
            boolean r0 = r0.a(r14)
            if (r0 == 0) goto L6f
            r6 = r2
            goto La3
        L6f:
            boolean r0 = r14 instanceof org.xmlpull.v1.XmlPullParser
            if (r0 == 0) goto L7d
            r0 = r14
            org.xmlpull.v1.XmlPullParser r0 = (org.xmlpull.v1.XmlPullParser) r0
            int r0 = r0.getDepth()
            if (r0 <= r2) goto La2
            goto L8b
        L7d:
            r0 = r11
            android.view.ViewParent r0 = (android.view.ViewParent) r0
            if (r0 != 0) goto L83
            goto La2
        L83:
            android.view.Window r3 = r10.g
            android.view.View r3 = r3.getDecorView()
        L89:
            if (r0 != 0) goto L8d
        L8b:
            r1 = r2
            goto La2
        L8d:
            if (r0 == r3) goto La2
            boolean r4 = r0 instanceof android.view.View
            if (r4 == 0) goto La2
            r4 = r0
            android.view.View r4 = (android.view.View) r4
            boolean r4 = defpackage.y9.q(r4)
            if (r4 == 0) goto L9d
            goto La2
        L9d:
            android.view.ViewParent r0 = r0.getParent()
            goto L89
        La2:
            r6 = r1
        La3:
            d1 r1 = r10.a0
            boolean r7 = defpackage.w0.d0
            r8 = 1
            defpackage.q4.a()
            r9 = 0
            r2 = r11
            r3 = r12
            r4 = r13
            r5 = r14
            android.view.View r0 = r1.a(r2, r3, r4, r5, r6, r7, r8, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.w0.onCreateView(android.view.View, java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: w0$c */
    /* loaded from: classes.dex */
    public final class c implements g2.a {
        public c() {
        }

        @Override // defpackage.g2.a
        public boolean a(z1 z1Var) {
            Window.Callback j = w0.this.j();
            if (j != null) {
                j.onMenuOpened(108, z1Var);
                return true;
            }
            return true;
        }

        @Override // defpackage.g2.a
        public void a(z1 z1Var, boolean z) {
            w0.this.b(z1Var);
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: w0$d */
    /* loaded from: classes.dex */
    public class d implements l1.a {
        public l1.a a;

        /* compiled from: AppCompatDelegateImpl.java */
        /* renamed from: w0$d$a */
        /* loaded from: classes.dex */
        public class a extends ha {
            public a() {
            }

            @Override // defpackage.ga
            public void b(View view) {
                w0.this.q.setVisibility(8);
                w0 w0Var = w0.this;
                PopupWindow popupWindow = w0Var.r;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (w0Var.q.getParent() instanceof View) {
                    y9.u((View) w0.this.q.getParent());
                }
                w0.this.q.d();
                w0.this.t.a((ga) null);
                w0 w0Var2 = w0.this;
                w0Var2.t = null;
                y9.u(w0Var2.w);
            }
        }

        public d(l1.a aVar) {
            this.a = aVar;
        }

        @Override // defpackage.l1.a
        public boolean a(l1 l1Var, Menu menu) {
            y9.u(w0.this.w);
            return this.a.a(l1Var, menu);
        }

        @Override // defpackage.l1.a
        public boolean b(l1 l1Var, Menu menu) {
            return this.a.b(l1Var, menu);
        }

        @Override // defpackage.l1.a
        public boolean a(l1 l1Var, MenuItem menuItem) {
            return this.a.a(l1Var, menuItem);
        }

        @Override // defpackage.l1.a
        public void a(l1 l1Var) {
            this.a.a(l1Var);
            w0 w0Var = w0.this;
            if (w0Var.r != null) {
                w0Var.g.getDecorView().removeCallbacks(w0.this.s);
            }
            w0 w0Var2 = w0.this;
            if (w0Var2.q != null) {
                w0Var2.f();
                w0 w0Var3 = w0.this;
                fa a2 = y9.a(w0Var3.q);
                a2.a(XToggleDrawable.LIGHT_RADIUS_DEFAULT);
                w0Var3.t = a2;
                w0.this.t.a(new a());
            }
            w0 w0Var4 = w0.this;
            u0 u0Var = w0Var4.i;
            if (u0Var != null) {
                u0Var.b(w0Var4.p);
            }
            w0 w0Var5 = w0.this;
            w0Var5.p = null;
            y9.u(w0Var5.w);
        }
    }

    @Override // defpackage.v0
    public void b(int i2) {
        g();
        ViewGroup viewGroup = (ViewGroup) this.w.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f).inflate(i2, viewGroup);
        this.h.c.onContentChanged();
    }

    public void f() {
        fa faVar = this.t;
        if (faVar != null) {
            faVar.a();
        }
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: w0$k */
    /* loaded from: classes.dex */
    public final class k implements g2.a {
        public k() {
        }

        @Override // defpackage.g2.a
        public void a(z1 z1Var, boolean z) {
            z1 c = z1Var.c();
            boolean z2 = c != z1Var;
            w0 w0Var = w0.this;
            if (z2) {
                z1Var = c;
            }
            j a = w0Var.a((Menu) z1Var);
            if (a != null) {
                if (z2) {
                    w0.this.a(a.a, a, c);
                    w0.this.a(a, true);
                    return;
                }
                w0.this.a(a, z);
            }
        }

        @Override // defpackage.g2.a
        public boolean a(z1 z1Var) {
            Window.Callback j;
            if (z1Var == z1Var.c()) {
                w0 w0Var = w0.this;
                if (!w0Var.B || (j = w0Var.j()) == null || w0.this.N) {
                    return true;
                }
                j.onMenuOpened(108, z1Var);
                return true;
            }
            return true;
        }
    }

    public final int e() {
        int i2 = this.O;
        if (i2 != -100) {
            return i2;
        }
        return -100;
    }

    public boolean d() {
        return a(true);
    }

    public final void g() {
        ViewGroup viewGroup;
        CharSequence charSequence;
        Context context;
        if (this.v) {
            return;
        }
        TypedArray obtainStyledAttributes = this.f.obtainStyledAttributes(i0.AppCompatTheme);
        if (obtainStyledAttributes.hasValue(i0.AppCompatTheme_windowActionBar)) {
            if (obtainStyledAttributes.getBoolean(i0.AppCompatTheme_windowNoTitle, false)) {
                a(1);
            } else if (obtainStyledAttributes.getBoolean(i0.AppCompatTheme_windowActionBar, false)) {
                a(108);
            }
            if (obtainStyledAttributes.getBoolean(i0.AppCompatTheme_windowActionBarOverlay, false)) {
                a(109);
            }
            if (obtainStyledAttributes.getBoolean(i0.AppCompatTheme_windowActionModeOverlay, false)) {
                a(10);
            }
            this.E = obtainStyledAttributes.getBoolean(i0.AppCompatTheme_android_windowIsFloating, false);
            obtainStyledAttributes.recycle();
            h();
            this.g.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.f);
            if (!this.F) {
                if (this.E) {
                    viewGroup = (ViewGroup) from.inflate(f0.abc_dialog_title_material, (ViewGroup) null);
                    this.C = false;
                    this.B = false;
                } else if (this.B) {
                    TypedValue typedValue = new TypedValue();
                    this.f.getTheme().resolveAttribute(z.actionBarTheme, typedValue, true);
                    int i2 = typedValue.resourceId;
                    if (i2 != 0) {
                        context = new n1(this.f, i2);
                    } else {
                        context = this.f;
                    }
                    viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(f0.abc_screen_toolbar, (ViewGroup) null);
                    this.m = (r3) viewGroup.findViewById(e0.decor_content_parent);
                    this.m.setWindowCallback(j());
                    if (this.C) {
                        this.m.a(109);
                    }
                    if (this.z) {
                        this.m.a(2);
                    }
                    if (this.A) {
                        this.m.a(5);
                    }
                } else {
                    viewGroup = null;
                }
            } else {
                viewGroup = this.D ? (ViewGroup) from.inflate(f0.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) from.inflate(f0.abc_screen_simple, (ViewGroup) null);
            }
            if (viewGroup != null) {
                int i3 = Build.VERSION.SDK_INT;
                y9.a(viewGroup, new x0(this));
                if (this.m == null) {
                    this.x = (TextView) viewGroup.findViewById(e0.title);
                }
                r4.b(viewGroup);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(e0.action_bar_activity_content);
                ViewGroup viewGroup2 = (ViewGroup) this.g.findViewById(16908290);
                if (viewGroup2 != null) {
                    while (viewGroup2.getChildCount() > 0) {
                        View childAt = viewGroup2.getChildAt(0);
                        viewGroup2.removeViewAt(0);
                        contentFrameLayout.addView(childAt);
                    }
                    viewGroup2.setId(-1);
                    contentFrameLayout.setId(16908290);
                    if (viewGroup2 instanceof FrameLayout) {
                        ((FrameLayout) viewGroup2).setForeground(null);
                    }
                }
                this.g.setContentView(viewGroup);
                contentFrameLayout.setAttachListener(new z0(this));
                this.w = viewGroup;
                Object obj = this.e;
                if (obj instanceof Activity) {
                    charSequence = ((Activity) obj).getTitle();
                } else {
                    charSequence = this.l;
                }
                if (!TextUtils.isEmpty(charSequence)) {
                    r3 r3Var = this.m;
                    if (r3Var != null) {
                        r3Var.setWindowTitle(charSequence);
                    } else {
                        j0 j0Var = this.j;
                        if (j0Var != null) {
                            j0Var.a(charSequence);
                        } else {
                            TextView textView = this.x;
                            if (textView != null) {
                                textView.setText(charSequence);
                            }
                        }
                    }
                }
                ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.w.findViewById(16908290);
                View decorView = this.g.getDecorView();
                contentFrameLayout2.a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
                TypedArray obtainStyledAttributes2 = this.f.obtainStyledAttributes(i0.AppCompatTheme);
                obtainStyledAttributes2.getValue(i0.AppCompatTheme_windowMinWidthMajor, contentFrameLayout2.getMinWidthMajor());
                obtainStyledAttributes2.getValue(i0.AppCompatTheme_windowMinWidthMinor, contentFrameLayout2.getMinWidthMinor());
                if (obtainStyledAttributes2.hasValue(i0.AppCompatTheme_windowFixedWidthMajor)) {
                    obtainStyledAttributes2.getValue(i0.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout2.getFixedWidthMajor());
                }
                if (obtainStyledAttributes2.hasValue(i0.AppCompatTheme_windowFixedWidthMinor)) {
                    obtainStyledAttributes2.getValue(i0.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout2.getFixedWidthMinor());
                }
                if (obtainStyledAttributes2.hasValue(i0.AppCompatTheme_windowFixedHeightMajor)) {
                    obtainStyledAttributes2.getValue(i0.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout2.getFixedHeightMajor());
                }
                if (obtainStyledAttributes2.hasValue(i0.AppCompatTheme_windowFixedHeightMinor)) {
                    obtainStyledAttributes2.getValue(i0.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout2.getFixedHeightMinor());
                }
                obtainStyledAttributes2.recycle();
                contentFrameLayout2.requestLayout();
                this.v = true;
                j d2 = d(0);
                if (this.N) {
                    return;
                }
                if (d2 == null || d2.j == null) {
                    e(108);
                    return;
                }
                return;
            }
            StringBuilder a2 = jg.a("AppCompat does not support the current theme features: { windowActionBar: ");
            a2.append(this.B);
            a2.append(", windowActionBarOverlay: ");
            a2.append(this.C);
            a2.append(", android:windowIsFloating: ");
            a2.append(this.E);
            a2.append(", windowActionModeOverlay: ");
            a2.append(this.D);
            a2.append(", windowNoTitle: ");
            a2.append(this.F);
            a2.append(" }");
            throw new IllegalArgumentException(a2.toString());
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    @Override // defpackage.v0
    public void b(View view, ViewGroup.LayoutParams layoutParams) {
        g();
        ViewGroup viewGroup = (ViewGroup) this.w.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.h.c.onContentChanged();
    }

    @Override // defpackage.v0
    public void a(View view) {
        g();
        ViewGroup viewGroup = (ViewGroup) this.w.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.h.c.onContentChanged();
    }

    /* compiled from: AppCompatDelegateImpl.java */
    /* renamed from: w0$j */
    /* loaded from: classes.dex */
    public static final class j {
        public int a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public ViewGroup g;
        public View h;
        public View i;
        public z1 j;
        public x1 k;
        public Context l;
        public boolean m;
        public boolean n;
        public boolean o;
        public boolean p;
        public boolean q = false;
        public boolean r;
        public Bundle s;

        public j(int i) {
            this.a = i;
        }

        public void a(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(z.actionBarPopupTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                newTheme.applyStyle(i, true);
            }
            newTheme.resolveAttribute(z.panelMenuListTheme, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                newTheme.applyStyle(i2, true);
            } else {
                newTheme.applyStyle(h0.Theme_AppCompat_CompactMenu, true);
            }
            n1 n1Var = new n1(context, 0);
            n1Var.getTheme().setTo(newTheme);
            this.l = n1Var;
            TypedArray obtainStyledAttributes = n1Var.obtainStyledAttributes(i0.AppCompatTheme);
            this.b = obtainStyledAttributes.getResourceId(i0.AppCompatTheme_panelBackground, 0);
            this.f = obtainStyledAttributes.getResourceId(i0.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }

        public void a(z1 z1Var) {
            x1 x1Var;
            z1 z1Var2 = this.j;
            if (z1Var == z1Var2) {
                return;
            }
            if (z1Var2 != null) {
                z1Var2.a(this.k);
            }
            this.j = z1Var;
            if (z1Var == null || (x1Var = this.k) == null) {
                return;
            }
            z1Var.a(x1Var, z1Var.a);
        }
    }

    public void c(int i2) {
        j d2;
        j d3 = d(i2);
        if (d3.j != null) {
            Bundle bundle = new Bundle();
            d3.j.b(bundle);
            if (bundle.size() > 0) {
                d3.s = bundle;
            }
            d3.j.k();
            d3.j.clear();
        }
        d3.r = true;
        d3.q = true;
        if ((i2 != 108 && i2 != 0) || this.m == null || (d2 = d(0)) == null) {
            return;
        }
        d2.m = false;
        b(d2, (KeyEvent) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00b8 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(defpackage.w0.j r11, android.view.KeyEvent r12) {
        /*
            Method dump skipped, instructions count: 328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.w0.b(w0$j, android.view.KeyEvent):boolean");
    }

    @Override // defpackage.v0
    public void a(View view, ViewGroup.LayoutParams layoutParams) {
        g();
        ((ViewGroup) this.w.findViewById(16908290)).addView(view, layoutParams);
        this.h.c.onContentChanged();
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    public final void a(Window window) {
        if (this.g == null) {
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof e)) {
                this.h = new e(callback);
                window.setCallback(this.h);
                n4 a2 = n4.a(this.f, (AttributeSet) null, e0);
                Drawable c2 = a2.c(0);
                if (c2 != null) {
                    window.setBackgroundDrawable(c2);
                }
                a2.b.recycle();
                this.g = window;
                return;
            }
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    @Override // defpackage.v0
    public final void a(CharSequence charSequence) {
        this.l = charSequence;
        r3 r3Var = this.m;
        if (r3Var != null) {
            r3Var.setWindowTitle(charSequence);
            return;
        }
        j0 j0Var = this.j;
        if (j0Var != null) {
            j0Var.a(charSequence);
            return;
        }
        TextView textView = this.x;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    @Override // defpackage.z1.a
    public boolean a(z1 z1Var, MenuItem menuItem) {
        j a2;
        Window.Callback j2 = j();
        if (j2 == null || this.N || (a2 = a((Menu) z1Var.c())) == null) {
            return false;
        }
        return j2.onMenuItemSelected(a2.a, menuItem);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public defpackage.l1 a(defpackage.l1.a r9) {
        /*
            Method dump skipped, instructions count: 430
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.w0.a(l1$a):l1");
    }

    public void b(z1 z1Var) {
        if (this.G) {
            return;
        }
        this.G = true;
        this.m.b();
        Window.Callback j2 = j();
        if (j2 != null && !this.N) {
            j2.onPanelClosed(108, z1Var);
        }
        this.G = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(android.view.KeyEvent r7) {
        /*
            Method dump skipped, instructions count: 282
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.w0.a(android.view.KeyEvent):boolean");
    }

    @Override // defpackage.v0
    public void a() {
        LayoutInflater from = LayoutInflater.from(this.f);
        if (from.getFactory() == null) {
            from.setFactory2(this);
            int i2 = Build.VERSION.SDK_INT;
        } else if (from.getFactory2() instanceof w0) {
        } else {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x0101, code lost:
        if (r14.h != null) goto L48;
     */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0108  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(defpackage.w0.j r14, android.view.KeyEvent r15) {
        /*
            Method dump skipped, instructions count: 387
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.w0.a(w0$j, android.view.KeyEvent):void");
    }

    @Override // defpackage.z1.a
    public void a(z1 z1Var) {
        r3 r3Var = this.m;
        if (r3Var != null && r3Var.g() && (!ViewConfiguration.get(this.f).hasPermanentMenuKey() || this.m.d())) {
            Window.Callback j2 = j();
            if (this.m.a()) {
                this.m.e();
                if (this.N) {
                    return;
                }
                j2.onPanelClosed(108, d(0).j);
                return;
            } else if (j2 == null || this.N) {
                return;
            } else {
                if (this.U && (1 & this.V) != 0) {
                    this.g.getDecorView().removeCallbacks(this.W);
                    this.W.run();
                }
                j d2 = d(0);
                z1 z1Var2 = d2.j;
                if (z1Var2 == null || d2.r || !j2.onPreparePanel(0, d2.i, z1Var2)) {
                    return;
                }
                j2.onMenuOpened(108, d2.j);
                this.m.f();
                return;
            }
        }
        j d3 = d(0);
        d3.q = true;
        a(d3, false);
        a(d3, (KeyEvent) null);
    }

    public void a(j jVar, boolean z) {
        ViewGroup viewGroup;
        r3 r3Var;
        if (z && jVar.a == 0 && (r3Var = this.m) != null && r3Var.a()) {
            b(jVar.j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.f.getSystemService("window");
        if (windowManager != null && jVar.o && (viewGroup = jVar.g) != null) {
            windowManager.removeView(viewGroup);
            if (z) {
                a(jVar.a, jVar, (Menu) null);
            }
        }
        jVar.m = false;
        jVar.n = false;
        jVar.o = false;
        jVar.h = null;
        jVar.q = true;
        if (this.I == jVar) {
            this.I = null;
        }
    }

    public void a(int i2, j jVar, Menu menu) {
        if (menu == null) {
            if (jVar == null && i2 >= 0) {
                j[] jVarArr = this.H;
                if (i2 < jVarArr.length) {
                    jVar = jVarArr[i2];
                }
            }
            if (jVar != null) {
                menu = jVar.j;
            }
        }
        if ((jVar == null || jVar.o) && !this.N) {
            this.h.c.onPanelClosed(i2, menu);
        }
    }

    public j a(Menu menu) {
        j[] jVarArr = this.H;
        int length = jVarArr != null ? jVarArr.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            j jVar = jVarArr[i2];
            if (jVar != null && jVar.j == menu) {
                return jVar;
            }
        }
        return null;
    }

    public final boolean a(j jVar, int i2, KeyEvent keyEvent, int i3) {
        z1 z1Var;
        boolean z = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((jVar.m || b(jVar, keyEvent)) && (z1Var = jVar.j) != null) {
            z = z1Var.performShortcut(i2, keyEvent, i3);
        }
        if (z && (i3 & 1) == 0 && this.m == null) {
            a(jVar, true);
        }
        return z;
    }

    public final int a(ja jaVar, Rect rect) {
        int i2;
        boolean z;
        boolean z2;
        int a2;
        if (jaVar != null) {
            i2 = jaVar.d();
        } else {
            i2 = rect != null ? rect.top : 0;
        }
        ActionBarContextView actionBarContextView = this.q;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.q.getLayoutParams();
            if (this.q.isShown()) {
                if (this.Y == null) {
                    this.Y = new Rect();
                    this.Z = new Rect();
                }
                Rect rect2 = this.Y;
                Rect rect3 = this.Z;
                if (jaVar == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(jaVar.b(), jaVar.d(), jaVar.c(), jaVar.a());
                }
                r4.a(this.w, rect2, rect3);
                int i3 = rect2.top;
                int i4 = rect2.left;
                int i5 = rect2.right;
                ja l = y9.l(this.w);
                int b2 = l == null ? 0 : l.b();
                int c2 = l == null ? 0 : l.c();
                if (marginLayoutParams.topMargin == i3 && marginLayoutParams.leftMargin == i4 && marginLayoutParams.rightMargin == i5) {
                    z2 = false;
                } else {
                    marginLayoutParams.topMargin = i3;
                    marginLayoutParams.leftMargin = i4;
                    marginLayoutParams.rightMargin = i5;
                    z2 = true;
                }
                if (i3 > 0 && this.y == null) {
                    this.y = new View(this.f);
                    this.y.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = b2;
                    layoutParams.rightMargin = c2;
                    this.w.addView(this.y, -1, layoutParams);
                } else {
                    View view = this.y;
                    if (view != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                        if (marginLayoutParams2.height != marginLayoutParams.topMargin || marginLayoutParams2.leftMargin != b2 || marginLayoutParams2.rightMargin != c2) {
                            marginLayoutParams2.height = marginLayoutParams.topMargin;
                            marginLayoutParams2.leftMargin = b2;
                            marginLayoutParams2.rightMargin = c2;
                            this.y.setLayoutParams(marginLayoutParams2);
                        }
                    }
                }
                z = this.y != null;
                if (z && this.y.getVisibility() != 0) {
                    View view2 = this.y;
                    if ((y9.n(view2) & WebpBitmapFactory.IN_TEMP_BUFFER_SIZE) != 0) {
                        a2 = o7.a(this.f, b0.abc_decor_view_status_guard_light);
                    } else {
                        a2 = o7.a(this.f, b0.abc_decor_view_status_guard);
                    }
                    view2.setBackgroundColor(a2);
                }
                if (!this.D && z) {
                    i2 = 0;
                }
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z = false;
                z2 = true;
            } else {
                z = false;
                z2 = false;
            }
            if (z2) {
                this.q.setLayoutParams(marginLayoutParams);
            }
        }
        View view3 = this.y;
        if (view3 != null) {
            view3.setVisibility(z ? 0 : 8);
        }
        return i2;
    }

    @Override // defpackage.v0
    public boolean a(int i2) {
        if (i2 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            i2 = 108;
        } else if (i2 == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            i2 = 109;
        }
        if (this.F && i2 == 108) {
            return false;
        }
        if (this.B && i2 == 1) {
            this.B = false;
        }
        if (i2 == 1) {
            m();
            this.F = true;
            return true;
        } else if (i2 == 2) {
            m();
            this.z = true;
            return true;
        } else if (i2 == 5) {
            m();
            this.A = true;
            return true;
        } else if (i2 == 10) {
            m();
            this.D = true;
            return true;
        } else if (i2 == 108) {
            m();
            this.B = true;
            return true;
        } else if (i2 != 109) {
            return this.g.requestFeature(i2);
        } else {
            m();
            this.C = true;
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0140  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(boolean r11) {
        /*
            Method dump skipped, instructions count: 328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.w0.a(boolean):boolean");
    }

    public final Configuration a(Context context, int i2, Configuration configuration) {
        int i3;
        if (i2 != 1) {
            i3 = i2 != 2 ? context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32;
        } else {
            i3 = 16;
        }
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i3 | (configuration2.uiMode & (-49));
        return configuration2;
    }

    public final g a(Context context) {
        if (this.S == null) {
            if (g1.d == null) {
                Context applicationContext = context.getApplicationContext();
                g1.d = new g1(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
            }
            this.S = new h(g1.d);
        }
        return this.S;
    }

    public int a(Context context, int i2) {
        if (i2 != -100) {
            if (i2 != -1) {
                if (i2 == 0) {
                    int i3 = Build.VERSION.SDK_INT;
                    if (((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() == 0) {
                        return -1;
                    }
                    return a(context).c();
                } else if (i2 != 1 && i2 != 2) {
                    if (i2 == 3) {
                        if (this.T == null) {
                            this.T = new f(context);
                        }
                        return this.T.c();
                    }
                    throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                }
            }
            return i2;
        }
        return -1;
    }
}
