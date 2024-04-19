package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import defpackage.w2;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: ResourceManagerInternal.java */
/* renamed from: d4  reason: default package */
/* loaded from: classes.dex */
public final class d4 {
    public static d4 i;
    public WeakHashMap<Context, g5<ColorStateList>> a;
    public f5<String, b> b;
    public g5<String> c;
    public final WeakHashMap<Context, c5<WeakReference<Drawable.ConstantState>>> d = new WeakHashMap<>(0);
    public TypedValue e;
    public boolean f;
    public c g;
    public static final PorterDuff.Mode h = PorterDuff.Mode.SRC_IN;
    public static final a j = new a(6);

    /* compiled from: ResourceManagerInternal.java */
    /* renamed from: d4$b */
    /* loaded from: classes.dex */
    public interface b {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    /* compiled from: ResourceManagerInternal.java */
    /* renamed from: d4$c */
    /* loaded from: classes.dex */
    public interface c {
    }

    public static synchronized d4 a() {
        d4 d4Var;
        synchronized (d4.class) {
            if (i == null) {
                i = new d4();
                int i2 = Build.VERSION.SDK_INT;
            }
            d4Var = i;
        }
        return d4Var;
    }

    public synchronized Drawable b(Context context, int i2) {
        return a(context, i2, false);
    }

    public synchronized ColorStateList c(Context context, int i2) {
        ColorStateList a2;
        g5<ColorStateList> g5Var;
        WeakHashMap<Context, g5<ColorStateList>> weakHashMap = this.a;
        a2 = (weakHashMap == null || (g5Var = weakHashMap.get(context)) == null) ? null : g5Var.a(i2);
        if (a2 == null) {
            a2 = this.g != null ? ((w2.a) this.g).b(context, i2) : null;
            if (a2 != null) {
                if (this.a == null) {
                    this.a = new WeakHashMap<>();
                }
                g5<ColorStateList> g5Var2 = this.a.get(context);
                if (g5Var2 == null) {
                    g5Var2 = new g5<>();
                    this.a.put(context, g5Var2);
                }
                g5Var2.a(i2, a2);
            }
        }
        return a2;
    }

    public final Drawable d(Context context, int i2) {
        int next;
        f5<String, b> f5Var = this.b;
        if (f5Var == null || f5Var.isEmpty()) {
            return null;
        }
        g5<String> g5Var = this.c;
        if (g5Var != null) {
            String b2 = g5Var.b(i2, null);
            if ("appcompat_skip_skip".equals(b2) || (b2 != null && this.b.getOrDefault(b2, null) == null)) {
                return null;
            }
        } else {
            this.c = new g5<>();
        }
        if (this.e == null) {
            this.e = new TypedValue();
        }
        TypedValue typedValue = this.e;
        Resources resources = context.getResources();
        resources.getValue(i2, typedValue, true);
        long j2 = (typedValue.assetCookie << 32) | typedValue.data;
        Drawable a2 = a(context, j2);
        if (a2 != null) {
            return a2;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i2);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                while (true) {
                    next = xml.next();
                    if (next == 2 || next == 1) {
                        break;
                    }
                }
                if (next == 2) {
                    String name = xml.getName();
                    this.c.a(i2, name);
                    b bVar = this.b.get(name);
                    if (bVar != null) {
                        a2 = bVar.a(context, xml, asAttributeSet, context.getTheme());
                    }
                    if (a2 != null) {
                        a2.setChangingConfigurations(typedValue.changingConfigurations);
                        a(context, j2, a2);
                    }
                } else {
                    throw new XmlPullParserException("No start tag found");
                }
            } catch (Exception e) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e);
            }
        }
        if (a2 == null) {
            this.c.a(i2, "appcompat_skip_skip");
        }
        return a2;
    }

    /* compiled from: ResourceManagerInternal.java */
    /* renamed from: d4$a */
    /* loaded from: classes.dex */
    public static class a extends d5<Integer, PorterDuffColorFilter> {
        public a(int i) {
            super(i);
        }

        public PorterDuffColorFilter a(int i, PorterDuff.Mode mode) {
            return a((a) Integer.valueOf(mode.hashCode() + ((i + 31) * 31)));
        }

        public PorterDuffColorFilter a(int i, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return a((a) Integer.valueOf(mode.hashCode() + ((i + 31) * 31)), (Integer) porterDuffColorFilter);
        }
    }

    public synchronized void a(c cVar) {
        this.g = cVar;
    }

    public synchronized void a(Context context) {
        c5<WeakReference<Drawable.ConstantState>> c5Var = this.d.get(context);
        if (c5Var != null) {
            c5Var.a();
        }
    }

    public final Drawable a(Context context, int i2) {
        if (this.e == null) {
            this.e = new TypedValue();
        }
        TypedValue typedValue = this.e;
        context.getResources().getValue(i2, typedValue, true);
        long j2 = (typedValue.assetCookie << 32) | typedValue.data;
        Drawable a2 = a(context, j2);
        if (a2 != null) {
            return a2;
        }
        c cVar = this.g;
        Drawable a3 = cVar == null ? null : ((w2.a) cVar).a(this, context, i2);
        if (a3 != null) {
            a3.setChangingConfigurations(typedValue.changingConfigurations);
            a(context, j2, a3);
        }
        return a3;
    }

    public final Drawable a(Context context, int i2, boolean z, Drawable drawable) {
        ColorStateList c2 = c(context, i2);
        if (c2 != null) {
            if (t3.a(drawable)) {
                drawable = drawable.mutate();
            }
            int i3 = Build.VERSION.SDK_INT;
            drawable.setTintList(c2);
            c cVar = this.g;
            PorterDuff.Mode a2 = cVar != null ? ((w2.a) cVar).a(i2) : null;
            if (a2 != null) {
                int i4 = Build.VERSION.SDK_INT;
                drawable.setTintMode(a2);
                return drawable;
            }
            return drawable;
        }
        c cVar2 = this.g;
        if (cVar2 == null || !((w2.a) cVar2).a(context, i2, drawable)) {
            c cVar3 = this.g;
            if ((cVar3 != null && ((w2.a) cVar3).b(context, i2, drawable)) || !z) {
                return drawable;
            }
            return null;
        }
        return drawable;
    }

    public final synchronized Drawable a(Context context, long j2) {
        c5<WeakReference<Drawable.ConstantState>> c5Var = this.d.get(context);
        if (c5Var == null) {
            return null;
        }
        WeakReference<Drawable.ConstantState> a2 = c5Var.a(j2, null);
        if (a2 != null) {
            Drawable.ConstantState constantState = a2.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            int a3 = b5.a(c5Var.d, c5Var.f, j2);
            if (a3 >= 0) {
                Object[] objArr = c5Var.e;
                Object obj = objArr[a3];
                Object obj2 = c5.g;
                if (obj != obj2) {
                    objArr[a3] = obj2;
                    c5Var.c = true;
                }
            }
        }
        return null;
    }

    public final synchronized boolean a(Context context, long j2, Drawable drawable) {
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState != null) {
            c5<WeakReference<Drawable.ConstantState>> c5Var = this.d.get(context);
            if (c5Var == null) {
                c5Var = new c5<>();
                this.d.put(context, c5Var);
            }
            c5Var.b(j2, new WeakReference<>(constantState));
            return true;
        }
        return false;
    }

    public static void a(Drawable drawable, l4 l4Var, int[] iArr) {
        if (t3.a(drawable) && drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if (!l4Var.d && !l4Var.c) {
            drawable.clearColorFilter();
        } else {
            PorterDuffColorFilter porterDuffColorFilter = null;
            ColorStateList colorStateList = l4Var.d ? l4Var.a : null;
            PorterDuff.Mode mode = l4Var.c ? l4Var.b : h;
            if (colorStateList != null && mode != null) {
                porterDuffColorFilter = a(colorStateList.getColorForState(iArr, 0), mode);
            }
            drawable.setColorFilter(porterDuffColorFilter);
        }
        int i2 = Build.VERSION.SDK_INT;
    }

    public static synchronized PorterDuffColorFilter a(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter a2;
        synchronized (d4.class) {
            a2 = j.a(i2, mode);
            if (a2 == null) {
                a2 = new PorterDuffColorFilter(i2, mode);
                j.a(i2, mode, a2);
            }
        }
        return a2;
    }

    public synchronized Drawable a(Context context, int i2, boolean z) {
        Drawable d;
        if (!this.f) {
            boolean z2 = true;
            this.f = true;
            Drawable b2 = b(context, k1.abc_vector_test);
            if (b2 != null) {
                if (!(b2 instanceof dg) && !"android.graphics.drawable.VectorDrawable".equals(b2.getClass().getName())) {
                    z2 = false;
                }
            }
            this.f = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
        d = d(context, i2);
        if (d == null) {
            d = a(context, i2);
        }
        if (d == null) {
            d = o7.b(context, i2);
        }
        if (d != null) {
            d = a(context, i2, z, d);
        }
        if (d != null) {
            t3.b(d);
        }
        return d;
    }
}
