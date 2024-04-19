package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import defpackage.f9;
import java.lang.reflect.Field;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: ViewCompat.java */
@SuppressLint({"PrivateConstructorForUtilityClass"})
/* renamed from: y9  reason: default package */
/* loaded from: classes.dex */
public class y9 {
    public static WeakHashMap<View, fa> a;
    public static Field b;
    public static boolean c;
    public static final u9 d;

    /* compiled from: ViewCompat.java */
    /* renamed from: y9$a */
    /* loaded from: classes.dex */
    public class a implements u9 {
        @Override // defpackage.u9
        public h9 a(h9 h9Var) {
            return h9Var;
        }
    }

    /* compiled from: ViewCompat.java */
    /* renamed from: y9$b */
    /* loaded from: classes.dex */
    public static class b implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {
        public WeakHashMap<View, Boolean> c = new WeakHashMap<>();

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i = Build.VERSION.SDK_INT;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    static {
        new AtomicInteger(1);
        a = null;
        c = false;
        int[] iArr = {d7.accessibility_custom_action_0, d7.accessibility_custom_action_1, d7.accessibility_custom_action_2, d7.accessibility_custom_action_3, d7.accessibility_custom_action_4, d7.accessibility_custom_action_5, d7.accessibility_custom_action_6, d7.accessibility_custom_action_7, d7.accessibility_custom_action_8, d7.accessibility_custom_action_9, d7.accessibility_custom_action_10, d7.accessibility_custom_action_11, d7.accessibility_custom_action_12, d7.accessibility_custom_action_13, d7.accessibility_custom_action_14, d7.accessibility_custom_action_15, d7.accessibility_custom_action_16, d7.accessibility_custom_action_17, d7.accessibility_custom_action_18, d7.accessibility_custom_action_19, d7.accessibility_custom_action_20, d7.accessibility_custom_action_21, d7.accessibility_custom_action_22, d7.accessibility_custom_action_23, d7.accessibility_custom_action_24, d7.accessibility_custom_action_25, d7.accessibility_custom_action_26, d7.accessibility_custom_action_27, d7.accessibility_custom_action_28, d7.accessibility_custom_action_29, d7.accessibility_custom_action_30, d7.accessibility_custom_action_31};
        d = new a();
        new b();
    }

    public static void a(View view, @SuppressLint({"ContextFirst"}) Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 29) {
            defpackage.a.a(view, context, iArr, attributeSet, typedArray, i, i2);
        }
    }

    public static View.AccessibilityDelegate b(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return view.getAccessibilityDelegate();
        }
        if (c) {
            return null;
        }
        if (b == null) {
            try {
                b = View.class.getDeclaredField("mAccessibilityDelegate");
                b.setAccessible(true);
            } catch (Throwable unused) {
                c = true;
                return null;
            }
        }
        try {
            Object obj = b.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            c = true;
            return null;
        }
    }

    public static CharSequence c(View view) {
        return new aa(d7.tag_accessibility_pane_title, CharSequence.class, 8, 28).b(view);
    }

    public static ColorStateList d(View view) {
        int i = Build.VERSION.SDK_INT;
        return view.getBackgroundTintList();
    }

    public static Display e(View view) {
        int i = Build.VERSION.SDK_INT;
        return view.getDisplay();
    }

    public static int f(View view) {
        int i = Build.VERSION.SDK_INT;
        return view.getImportantForAccessibility();
    }

    @SuppressLint({"InlinedApi"})
    public static int g(View view) {
        int i = Build.VERSION.SDK_INT;
        return view.getImportantForAutofill();
    }

    public static int h(View view) {
        int i = Build.VERSION.SDK_INT;
        return view.getLayoutDirection();
    }

    public static int i(View view) {
        int i = Build.VERSION.SDK_INT;
        return view.getMinimumHeight();
    }

    public static int j(View view) {
        int i = Build.VERSION.SDK_INT;
        return view.getMinimumWidth();
    }

    public static String[] k(View view) {
        return (String[]) view.getTag(d7.tag_on_receive_content_mime_types);
    }

    public static ja l(View view) {
        int i = Build.VERSION.SDK_INT;
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return null;
        }
        ja a2 = ja.a(rootWindowInsets);
        a2.a.b(a2);
        a2.a.a(view.getRootView());
        return a2;
    }

    public static String m(View view) {
        int i = Build.VERSION.SDK_INT;
        return view.getTransitionName();
    }

    public static int n(View view) {
        int i = Build.VERSION.SDK_INT;
        return view.getWindowSystemUiVisibility();
    }

    public static boolean o(View view) {
        int i = Build.VERSION.SDK_INT;
        return view.hasOnClickListeners();
    }

    public static boolean p(View view) {
        int i = Build.VERSION.SDK_INT;
        return view.hasTransientState();
    }

    public static boolean q(View view) {
        int i = Build.VERSION.SDK_INT;
        return view.isAttachedToWindow();
    }

    public static boolean r(View view) {
        int i = Build.VERSION.SDK_INT;
        return view.isLaidOut();
    }

    public static boolean s(View view) {
        Boolean b2 = new z9(d7.tag_screen_reader_focusable, Boolean.class, 28).b(view);
        if (b2 == null) {
            return false;
        }
        return b2.booleanValue();
    }

    public static void t(View view) {
        int i = Build.VERSION.SDK_INT;
        view.postInvalidateOnAnimation();
    }

    public static void u(View view) {
        int i = Build.VERSION.SDK_INT;
        view.requestApplyInsets();
    }

    public static void v(View view) {
        int i = Build.VERSION.SDK_INT;
        view.stopNestedScroll();
    }

    public static void a(View view, f9 f9Var) {
        if (f9Var == null && (b(view) instanceof f9.a)) {
            f9Var = new f9(f9.c);
        }
        view.setAccessibilityDelegate(f9Var == null ? null : f9Var.b);
    }

    /* compiled from: ViewCompat.java */
    /* renamed from: y9$c */
    /* loaded from: classes.dex */
    public static abstract class c<T> {
        public final int a;
        public final Class<T> b;
        public final int c;

        public c(int i, Class<T> cls, int i2) {
            this.a = i;
            this.b = cls;
            this.c = i2;
        }

        public abstract T a(View view);

        public T b(View view) {
            if (Build.VERSION.SDK_INT >= this.c) {
                return a(view);
            }
            int i = Build.VERSION.SDK_INT;
            T t = (T) view.getTag(this.a);
            if (this.b.isInstance(t)) {
                return t;
            }
            return null;
        }

        public c(int i, Class<T> cls, int i2, int i3) {
            this.a = i;
            this.b = cls;
            this.c = i3;
        }
    }

    public static void a(View view, Runnable runnable) {
        int i = Build.VERSION.SDK_INT;
        view.postOnAnimation(runnable);
    }

    public static void a(View view, Runnable runnable, long j) {
        int i = Build.VERSION.SDK_INT;
        view.postOnAnimationDelayed(runnable, j);
    }

    public static void a(View view, int i) {
        int i2 = Build.VERSION.SDK_INT;
        view.setImportantForAccessibility(i);
    }

    public static ja b(View view, ja jaVar) {
        int i = Build.VERSION.SDK_INT;
        WindowInsets e = jaVar.e();
        if (e != null) {
            WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(e);
            if (!onApplyWindowInsets.equals(e)) {
                return ja.a(onApplyWindowInsets, view);
            }
        }
        return jaVar;
    }

    public static fa a(View view) {
        if (a == null) {
            a = new WeakHashMap<>();
        }
        fa faVar = a.get(view);
        if (faVar == null) {
            fa faVar2 = new fa(view);
            a.put(view, faVar2);
            return faVar2;
        }
        return faVar;
    }

    public static void a(View view, float f) {
        int i = Build.VERSION.SDK_INT;
        view.setElevation(f);
    }

    public static void a(View view, String str) {
        int i = Build.VERSION.SDK_INT;
        view.setTransitionName(str);
    }

    public static void a(View view, s9 s9Var) {
        if (Build.VERSION.SDK_INT < 30) {
            view.setTag(d7.tag_on_apply_window_listener, s9Var);
        }
        if (s9Var == null) {
            view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(d7.tag_window_insets_animation_callback));
        } else {
            view.setOnApplyWindowInsetsListener(new da(view, s9Var));
        }
    }

    public static ja a(View view, ja jaVar) {
        int i = Build.VERSION.SDK_INT;
        WindowInsets e = jaVar.e();
        if (e != null) {
            WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(e);
            if (!dispatchApplyWindowInsets.equals(e)) {
                return ja.a(dispatchApplyWindowInsets, view);
            }
        }
        return jaVar;
    }

    public static ja a(View view, ja jaVar, Rect rect) {
        int i = Build.VERSION.SDK_INT;
        WindowInsets e = jaVar.e();
        if (e != null) {
            return ja.a(view.computeSystemWindowInsets(e, rect), view);
        }
        rect.setEmpty();
        return jaVar;
    }

    public static h9 a(View view, h9 h9Var) {
        u9 u9Var;
        u9 u9Var2;
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + h9Var + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        t9 t9Var = (t9) view.getTag(d7.tag_on_receive_content_listener);
        if (t9Var != null) {
            h9 a2 = ((cb) t9Var).a(view, h9Var);
            if (a2 == null) {
                return null;
            }
            if (view instanceof u9) {
                u9Var2 = (u9) view;
            } else {
                u9Var2 = d;
            }
            return u9Var2.a(a2);
        }
        if (view instanceof u9) {
            u9Var = (u9) view;
        } else {
            u9Var = d;
        }
        return u9Var.a(h9Var);
    }

    public static void a(View view, Drawable drawable) {
        int i = Build.VERSION.SDK_INT;
        view.setBackground(drawable);
    }

    public static void a(View view, int i, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        view.setScrollIndicators(i, i2);
    }

    public static boolean a(View view, KeyEvent keyEvent) {
        int i = Build.VERSION.SDK_INT;
        return false;
    }
}
