package defpackage;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
/* compiled from: WindowInsetsCompat.java */
/* renamed from: ja  reason: default package */
/* loaded from: classes.dex */
public class ja {
    public static final ja b;
    public final k a;

    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: ja$a */
    /* loaded from: classes.dex */
    public static final class a {
        public final e a;

        public a() {
            int i = Build.VERSION.SDK_INT;
            if (i >= 30) {
                this.a = new d();
            } else if (i >= 29) {
                this.a = new c();
            } else {
                this.a = new b();
            }
        }

        public ja a() {
            return this.a.b();
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: ja$b */
    /* loaded from: classes.dex */
    public static class b extends e {
        public static Field e = null;
        public static boolean f = false;
        public static Constructor<WindowInsets> g = null;
        public static boolean h = false;
        public WindowInsets c;
        public x7 d;

        public b() {
            WindowInsets windowInsets;
            WindowInsets windowInsets2;
            if (!f) {
                try {
                    e = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e2) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e2);
                }
                f = true;
            }
            Field field = e;
            if (field != null) {
                try {
                    windowInsets = (WindowInsets) field.get(null);
                } catch (ReflectiveOperationException e3) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e3);
                }
                if (windowInsets != null) {
                    windowInsets2 = new WindowInsets(windowInsets);
                    this.c = windowInsets2;
                }
            }
            if (!h) {
                try {
                    g = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e4) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e4);
                }
                h = true;
            }
            Constructor<WindowInsets> constructor = g;
            if (constructor != null) {
                try {
                    windowInsets2 = constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException e5) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e5);
                }
                this.c = windowInsets2;
            }
            windowInsets2 = null;
            this.c = windowInsets2;
        }

        @Override // defpackage.ja.e
        public void b(x7 x7Var) {
            this.d = x7Var;
        }

        @Override // defpackage.ja.e
        public void d(x7 x7Var) {
            WindowInsets windowInsets = this.c;
            if (windowInsets != null) {
                this.c = windowInsets.replaceSystemWindowInsets(x7Var.a, x7Var.b, x7Var.c, x7Var.d);
            }
        }

        @Override // defpackage.ja.e
        public ja b() {
            a();
            ja a = ja.a(this.c);
            a.a.a(this.b);
            a.a.b(this.d);
            return a;
        }

        public b(ja jaVar) {
            this.c = jaVar.e();
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: ja$c */
    /* loaded from: classes.dex */
    public static class c extends e {
        public final WindowInsets.Builder c;

        public c() {
            this.c = new WindowInsets.Builder();
        }

        @Override // defpackage.ja.e
        public void a(x7 x7Var) {
            this.c.setMandatorySystemGestureInsets(x7Var.a());
        }

        @Override // defpackage.ja.e
        public void b(x7 x7Var) {
            this.c.setStableInsets(x7Var.a());
        }

        @Override // defpackage.ja.e
        public void c(x7 x7Var) {
            this.c.setSystemGestureInsets(x7Var.a());
        }

        @Override // defpackage.ja.e
        public void d(x7 x7Var) {
            this.c.setSystemWindowInsets(x7Var.a());
        }

        @Override // defpackage.ja.e
        public void e(x7 x7Var) {
            this.c.setTappableElementInsets(x7Var.a());
        }

        @Override // defpackage.ja.e
        public ja b() {
            a();
            ja a = ja.a(this.c.build());
            a.a.a(this.b);
            return a;
        }

        public c(ja jaVar) {
            WindowInsets.Builder builder;
            WindowInsets e = jaVar.e();
            if (e != null) {
                builder = new WindowInsets.Builder(e);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.c = builder;
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: ja$d */
    /* loaded from: classes.dex */
    public static class d extends c {
        public d() {
        }

        public d(ja jaVar) {
            super(jaVar);
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: ja$e */
    /* loaded from: classes.dex */
    public static class e {
        public final ja a = new ja((ja) null);
        public x7[] b;

        public final void a() {
            x7[] x7VarArr = this.b;
            if (x7VarArr != null) {
                x7 x7Var = x7VarArr[defpackage.a.b(1)];
                x7 x7Var2 = this.b[defpackage.a.b(2)];
                if (x7Var != null && x7Var2 != null) {
                    d(x7.a(Math.max(x7Var.a, x7Var2.a), Math.max(x7Var.b, x7Var2.b), Math.max(x7Var.c, x7Var2.c), Math.max(x7Var.d, x7Var2.d)));
                } else if (x7Var != null) {
                    d(x7Var);
                } else if (x7Var2 != null) {
                    d(x7Var2);
                }
                x7 x7Var3 = this.b[defpackage.a.b(16)];
                if (x7Var3 != null) {
                    c(x7Var3);
                }
                x7 x7Var4 = this.b[defpackage.a.b(32)];
                if (x7Var4 != null) {
                    a(x7Var4);
                }
                x7 x7Var5 = this.b[defpackage.a.b(64)];
                if (x7Var5 != null) {
                    e(x7Var5);
                }
            }
        }

        public void a(x7 x7Var) {
        }

        public ja b() {
            throw null;
        }

        public void b(x7 x7Var) {
            throw null;
        }

        public void c(x7 x7Var) {
        }

        public void d(x7 x7Var) {
            throw null;
        }

        public void e(x7 x7Var) {
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: ja$g */
    /* loaded from: classes.dex */
    public static class g extends f {
        public x7 m;

        public g(ja jaVar, WindowInsets windowInsets) {
            super(jaVar, windowInsets);
            this.m = null;
        }

        @Override // defpackage.ja.k
        public ja b() {
            return ja.a(this.c.consumeStableInsets());
        }

        @Override // defpackage.ja.k
        public ja c() {
            return ja.a(this.c.consumeSystemWindowInsets());
        }

        @Override // defpackage.ja.k
        public final x7 e() {
            if (this.m == null) {
                this.m = x7.a(this.c.getStableInsetLeft(), this.c.getStableInsetTop(), this.c.getStableInsetRight(), this.c.getStableInsetBottom());
            }
            return this.m;
        }

        @Override // defpackage.ja.k
        public boolean g() {
            return this.c.isConsumed();
        }

        @Override // defpackage.ja.k
        public void b(x7 x7Var) {
            this.m = x7Var;
        }

        public g(ja jaVar, g gVar) {
            super(jaVar, gVar);
            this.m = null;
            this.m = gVar.m;
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: ja$h */
    /* loaded from: classes.dex */
    public static class h extends g {
        public h(ja jaVar, WindowInsets windowInsets) {
            super(jaVar, windowInsets);
        }

        @Override // defpackage.ja.k
        public ja a() {
            return ja.a(this.c.consumeDisplayCutout());
        }

        @Override // defpackage.ja.k
        public i9 d() {
            DisplayCutout displayCutout = this.c.getDisplayCutout();
            if (displayCutout == null) {
                return null;
            }
            return new i9(displayCutout);
        }

        @Override // defpackage.ja.f, defpackage.ja.k
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof h) {
                h hVar = (h) obj;
                return Objects.equals(this.c, hVar.c) && Objects.equals(this.f, hVar.f);
            }
            return false;
        }

        @Override // defpackage.ja.k
        public int hashCode() {
            return this.c.hashCode();
        }

        public h(ja jaVar, h hVar) {
            super(jaVar, hVar);
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: ja$i */
    /* loaded from: classes.dex */
    public static class i extends h {
        public i(ja jaVar, WindowInsets windowInsets) {
            super(jaVar, windowInsets);
        }

        @Override // defpackage.ja.f, defpackage.ja.k
        public ja a(int i, int i2, int i3, int i4) {
            return ja.a(this.c.inset(i, i2, i3, i4));
        }

        @Override // defpackage.ja.g, defpackage.ja.k
        public void b(x7 x7Var) {
        }

        public i(ja jaVar, i iVar) {
            super(jaVar, iVar);
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: ja$j */
    /* loaded from: classes.dex */
    public static class j extends i {
        public static final ja n = ja.a(WindowInsets.CONSUMED);

        public j(ja jaVar, WindowInsets windowInsets) {
            super(jaVar, windowInsets);
        }

        @Override // defpackage.ja.f, defpackage.ja.k
        public final void a(View view) {
        }

        public j(ja jaVar, j jVar) {
            super(jaVar, jVar);
        }
    }

    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: ja$k */
    /* loaded from: classes.dex */
    public static class k {
        public static final ja b = new a().a().a.a().a.b().a.c();
        public final ja a;

        public k(ja jaVar) {
            this.a = jaVar;
        }

        public ja a() {
            return this.a;
        }

        public void a(View view) {
        }

        public void a(ja jaVar) {
        }

        public void a(x7 x7Var) {
        }

        public void a(x7[] x7VarArr) {
        }

        public ja b() {
            return this.a;
        }

        public void b(ja jaVar) {
        }

        public void b(x7 x7Var) {
        }

        public ja c() {
            return this.a;
        }

        public i9 d() {
            return null;
        }

        public x7 e() {
            return x7.e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof k) {
                k kVar = (k) obj;
                return h() == kVar.h() && g() == kVar.g() && defpackage.a.b(f(), kVar.f()) && defpackage.a.b(e(), kVar.e()) && defpackage.a.b(d(), kVar.d());
            }
            return false;
        }

        public x7 f() {
            return x7.e;
        }

        public boolean g() {
            return false;
        }

        public boolean h() {
            return false;
        }

        public int hashCode() {
            return defpackage.a.a(Boolean.valueOf(h()), Boolean.valueOf(g()), f(), e(), d());
        }

        public ja a(int i, int i2, int i3, int i4) {
            return b;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            b = j.n;
        } else {
            b = k.b;
        }
    }

    public ja(WindowInsets windowInsets) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            this.a = new j(this, windowInsets);
        } else if (i2 >= 29) {
            this.a = new i(this, windowInsets);
        } else {
            this.a = new h(this, windowInsets);
        }
    }

    public static ja a(WindowInsets windowInsets) {
        return a(windowInsets, null);
    }

    @Deprecated
    public int b() {
        return this.a.f().a;
    }

    @Deprecated
    public int c() {
        return this.a.f().c;
    }

    @Deprecated
    public int d() {
        return this.a.f().b;
    }

    public WindowInsets e() {
        k kVar = this.a;
        if (kVar instanceof f) {
            return ((f) kVar).c;
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ja) {
            return defpackage.a.b(this.a, ((ja) obj).a);
        }
        return false;
    }

    public int hashCode() {
        k kVar = this.a;
        if (kVar == null) {
            return 0;
        }
        return kVar.hashCode();
    }

    public static ja a(WindowInsets windowInsets, View view) {
        if (windowInsets != null) {
            ja jaVar = new ja(windowInsets);
            if (view != null && view.isAttachedToWindow()) {
                jaVar.a.b(y9.l(view));
                jaVar.a.a(view.getRootView());
            }
            return jaVar;
        }
        throw new NullPointerException();
    }

    /* compiled from: WindowInsetsCompat.java */
    /* renamed from: ja$f */
    /* loaded from: classes.dex */
    public static class f extends k {
        public static boolean g = false;
        public static Method h;
        public static Class<?> i;
        public static Class<?> j;
        public static Field k;
        public static Field l;
        public final WindowInsets c;
        public x7 d;
        public ja e;
        public x7 f;

        public f(ja jaVar, WindowInsets windowInsets) {
            super(jaVar);
            this.d = null;
            this.c = windowInsets;
        }

        @Override // defpackage.ja.k
        public ja a(int i2, int i3, int i4, int i5) {
            e bVar;
            ja a = ja.a(this.c);
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 30) {
                bVar = new d(a);
            } else if (i6 >= 29) {
                bVar = new c(a);
            } else {
                bVar = new b(a);
            }
            bVar.d(ja.a(f(), i2, i3, i4, i5));
            bVar.b(ja.a(e(), i2, i3, i4, i5));
            return bVar.b();
        }

        @Override // defpackage.ja.k
        public void a(x7[] x7VarArr) {
        }

        @Override // defpackage.ja.k
        public void b(ja jaVar) {
            this.e = jaVar;
        }

        @Override // defpackage.ja.k
        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return Objects.equals(this.f, ((f) obj).f);
            }
            return false;
        }

        @Override // defpackage.ja.k
        public final x7 f() {
            if (this.d == null) {
                this.d = x7.a(this.c.getSystemWindowInsetLeft(), this.c.getSystemWindowInsetTop(), this.c.getSystemWindowInsetRight(), this.c.getSystemWindowInsetBottom());
            }
            return this.d;
        }

        @Override // defpackage.ja.k
        public boolean h() {
            return this.c.isRound();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(ja jaVar, f fVar) {
            super(jaVar);
            WindowInsets windowInsets = new WindowInsets(fVar.c);
            this.d = null;
            this.c = windowInsets;
        }

        @Override // defpackage.ja.k
        public void a(ja jaVar) {
            jaVar.a.b(this.e);
            jaVar.a.a(this.f);
        }

        @Override // defpackage.ja.k
        public void a(x7 x7Var) {
            this.f = x7Var;
        }

        @Override // defpackage.ja.k
        public void a(View view) {
            if (Build.VERSION.SDK_INT < 30) {
                if (!g) {
                    try {
                        h = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                        i = Class.forName("android.view.ViewRootImpl");
                        j = Class.forName("android.view.View$AttachInfo");
                        k = j.getDeclaredField("mVisibleInsets");
                        l = i.getDeclaredField("mAttachInfo");
                        k.setAccessible(true);
                        l.setAccessible(true);
                    } catch (ReflectiveOperationException e) {
                        StringBuilder a = jg.a("Failed to get visible insets. (Reflection error). ");
                        a.append(e.getMessage());
                        Log.e("WindowInsetsCompat", a.toString(), e);
                    }
                    g = true;
                }
                Method method = h;
                x7 x7Var = null;
                if (method != null && j != null && k != null) {
                    try {
                        Object invoke = method.invoke(view, new Object[0]);
                        if (invoke == null) {
                            Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                        } else {
                            Rect rect = (Rect) k.get(l.get(invoke));
                            if (rect != null) {
                                x7Var = x7.a(rect);
                            }
                        }
                    } catch (ReflectiveOperationException e2) {
                        StringBuilder a2 = jg.a("Failed to get visible insets. (Reflection error). ");
                        a2.append(e2.getMessage());
                        Log.e("WindowInsetsCompat", a2.toString(), e2);
                    }
                }
                if (x7Var == null) {
                    x7Var = x7.e;
                }
                a(x7Var);
                return;
            }
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }
    }

    public ja(ja jaVar) {
        if (jaVar != null) {
            k kVar = jaVar.a;
            if (Build.VERSION.SDK_INT >= 30 && (kVar instanceof j)) {
                this.a = new j(this, (j) kVar);
            } else if (Build.VERSION.SDK_INT >= 29 && (kVar instanceof i)) {
                this.a = new i(this, (i) kVar);
            } else {
                int i2 = Build.VERSION.SDK_INT;
                if (kVar instanceof h) {
                    this.a = new h(this, (h) kVar);
                } else if (kVar instanceof g) {
                    this.a = new g(this, (g) kVar);
                } else if (kVar instanceof f) {
                    this.a = new f(this, (f) kVar);
                } else {
                    this.a = new k(this);
                }
            }
            kVar.a(this);
            return;
        }
        this.a = new k(this);
    }

    @Deprecated
    public int a() {
        return this.a.f().d;
    }

    public static x7 a(x7 x7Var, int i2, int i3, int i4, int i5) {
        int max = Math.max(0, x7Var.a - i2);
        int max2 = Math.max(0, x7Var.b - i3);
        int max3 = Math.max(0, x7Var.c - i4);
        int max4 = Math.max(0, x7Var.d - i5);
        return (max == i2 && max2 == i3 && max3 == i4 && max4 == i5) ? x7Var : x7.a(max, max2, max3, max4);
    }
}
