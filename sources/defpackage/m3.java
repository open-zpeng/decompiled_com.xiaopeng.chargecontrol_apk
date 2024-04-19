package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import java.lang.ref.WeakReference;
import java.util.Arrays;
/* compiled from: AppCompatTextHelper.java */
/* renamed from: m3  reason: default package */
/* loaded from: classes.dex */
public class m3 {
    public final TextView a;
    public l4 b;
    public l4 c;
    public l4 d;
    public l4 e;
    public l4 f;
    public l4 g;
    public l4 h;
    public final p3 i;
    public int j = 0;
    public int k = -1;
    public Typeface l;
    public boolean m;

    /* compiled from: AppCompatTextHelper.java */
    /* renamed from: m3$a */
    /* loaded from: classes.dex */
    public class a extends u7 {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ WeakReference c;

        public a(int i, int i2, WeakReference weakReference) {
            this.a = i;
            this.b = i2;
            this.c = weakReference;
        }

        @Override // defpackage.u7
        public void a(int i) {
        }

        @Override // defpackage.u7
        public void a(Typeface typeface) {
            int i = Build.VERSION.SDK_INT;
            int i2 = this.a;
            if (i2 != -1) {
                typeface = Typeface.create(typeface, i2, (this.b & 2) != 0);
            }
            m3 m3Var = m3.this;
            WeakReference weakReference = this.c;
            if (m3Var.m) {
                m3Var.l = typeface;
                TextView textView = (TextView) weakReference.get();
                if (textView != null) {
                    if (y9.q(textView)) {
                        textView.post(new n3(m3Var, textView, typeface, m3Var.j));
                    } else {
                        textView.setTypeface(typeface, m3Var.j);
                    }
                }
            }
        }
    }

    public m3(TextView textView) {
        this.a = textView;
        this.i = new p3(this.a);
    }

    @SuppressLint({"NewApi"})
    public void a(AttributeSet attributeSet, int i) {
        boolean z;
        boolean z2;
        String str;
        String str2;
        int resourceId;
        Context context = this.a.getContext();
        w2 a2 = w2.a();
        n4 a3 = n4.a(context, attributeSet, i0.AppCompatTextHelper, i, 0);
        TextView textView = this.a;
        y9.a(textView, textView.getContext(), i0.AppCompatTextHelper, attributeSet, a3.b, i, 0);
        int e = a3.e(i0.AppCompatTextHelper_android_textAppearance, -1);
        if (a3.f(i0.AppCompatTextHelper_android_drawableLeft)) {
            this.b = a(context, a2, a3.e(i0.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (a3.f(i0.AppCompatTextHelper_android_drawableTop)) {
            this.c = a(context, a2, a3.e(i0.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (a3.f(i0.AppCompatTextHelper_android_drawableRight)) {
            this.d = a(context, a2, a3.e(i0.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (a3.f(i0.AppCompatTextHelper_android_drawableBottom)) {
            this.e = a(context, a2, a3.e(i0.AppCompatTextHelper_android_drawableBottom, 0));
        }
        int i2 = Build.VERSION.SDK_INT;
        if (a3.f(i0.AppCompatTextHelper_android_drawableStart)) {
            this.f = a(context, a2, a3.e(i0.AppCompatTextHelper_android_drawableStart, 0));
        }
        if (a3.f(i0.AppCompatTextHelper_android_drawableEnd)) {
            this.g = a(context, a2, a3.e(i0.AppCompatTextHelper_android_drawableEnd, 0));
        }
        a3.b.recycle();
        boolean z3 = this.a.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (e != -1) {
            n4 n4Var = new n4(context, context.obtainStyledAttributes(e, i0.TextAppearance));
            if (z3 || !n4Var.f(i0.TextAppearance_textAllCaps)) {
                z = false;
                z2 = false;
            } else {
                z2 = n4Var.a(i0.TextAppearance_textAllCaps, false);
                z = true;
            }
            a(context, n4Var);
            int i3 = Build.VERSION.SDK_INT;
            str = n4Var.f(i0.TextAppearance_textLocale) ? n4Var.d(i0.TextAppearance_textLocale) : null;
            int i4 = Build.VERSION.SDK_INT;
            str2 = n4Var.f(i0.TextAppearance_fontVariationSettings) ? n4Var.d(i0.TextAppearance_fontVariationSettings) : null;
            n4Var.b.recycle();
        } else {
            z = false;
            z2 = false;
            str = null;
            str2 = null;
        }
        n4 n4Var2 = new n4(context, context.obtainStyledAttributes(attributeSet, i0.TextAppearance, i, 0));
        if (!z3 && n4Var2.f(i0.TextAppearance_textAllCaps)) {
            z2 = n4Var2.a(i0.TextAppearance_textAllCaps, false);
            z = true;
        }
        int i5 = Build.VERSION.SDK_INT;
        if (n4Var2.f(i0.TextAppearance_textLocale)) {
            str = n4Var2.d(i0.TextAppearance_textLocale);
        }
        int i6 = Build.VERSION.SDK_INT;
        if (n4Var2.f(i0.TextAppearance_fontVariationSettings)) {
            str2 = n4Var2.d(i0.TextAppearance_fontVariationSettings);
        }
        int i7 = Build.VERSION.SDK_INT;
        if (n4Var2.f(i0.TextAppearance_android_textSize) && n4Var2.b(i0.TextAppearance_android_textSize, -1) == 0) {
            this.a.setTextSize(0, XToggleDrawable.LIGHT_RADIUS_DEFAULT);
        }
        a(context, n4Var2);
        n4Var2.b.recycle();
        if (!z3 && z) {
            this.a.setAllCaps(z2);
        }
        Typeface typeface = this.l;
        if (typeface != null) {
            if (this.k == -1) {
                this.a.setTypeface(typeface, this.j);
            } else {
                this.a.setTypeface(typeface);
            }
        }
        if (str2 != null) {
            this.a.setFontVariationSettings(str2);
        }
        if (str != null) {
            int i8 = Build.VERSION.SDK_INT;
            this.a.setTextLocales(LocaleList.forLanguageTags(str));
        }
        p3 p3Var = this.i;
        TypedArray obtainStyledAttributes = p3Var.j.obtainStyledAttributes(attributeSet, i0.AppCompatTextView, i, 0);
        TextView textView2 = p3Var.i;
        y9.a(textView2, textView2.getContext(), i0.AppCompatTextView, attributeSet, obtainStyledAttributes, i, 0);
        if (obtainStyledAttributes.hasValue(i0.AppCompatTextView_autoSizeTextType)) {
            p3Var.a = obtainStyledAttributes.getInt(i0.AppCompatTextView_autoSizeTextType, 0);
        }
        float dimension = obtainStyledAttributes.hasValue(i0.AppCompatTextView_autoSizeStepGranularity) ? obtainStyledAttributes.getDimension(i0.AppCompatTextView_autoSizeStepGranularity, -1.0f) : -1.0f;
        float dimension2 = obtainStyledAttributes.hasValue(i0.AppCompatTextView_autoSizeMinTextSize) ? obtainStyledAttributes.getDimension(i0.AppCompatTextView_autoSizeMinTextSize, -1.0f) : -1.0f;
        float dimension3 = obtainStyledAttributes.hasValue(i0.AppCompatTextView_autoSizeMaxTextSize) ? obtainStyledAttributes.getDimension(i0.AppCompatTextView_autoSizeMaxTextSize, -1.0f) : -1.0f;
        if (obtainStyledAttributes.hasValue(i0.AppCompatTextView_autoSizePresetSizes) && (resourceId = obtainStyledAttributes.getResourceId(i0.AppCompatTextView_autoSizePresetSizes, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            int length = obtainTypedArray.length();
            int[] iArr = new int[length];
            if (length > 0) {
                for (int i9 = 0; i9 < length; i9++) {
                    iArr[i9] = obtainTypedArray.getDimensionPixelSize(i9, -1);
                }
                p3Var.f = p3Var.a(iArr);
                p3Var.c();
            }
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes.recycle();
        if (p3Var.d()) {
            if (p3Var.a == 1) {
                if (!p3Var.g) {
                    DisplayMetrics displayMetrics = p3Var.j.getResources().getDisplayMetrics();
                    if (dimension2 == -1.0f) {
                        dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                    }
                    if (dimension3 == -1.0f) {
                        dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                    }
                    if (dimension == -1.0f) {
                        dimension = 1.0f;
                    }
                    p3Var.a(dimension2, dimension3, dimension);
                }
                p3Var.b();
            }
        } else {
            p3Var.a = 0;
        }
        if (ab.a) {
            p3 p3Var2 = this.i;
            if (p3Var2.a != 0) {
                int[] iArr2 = p3Var2.f;
                if (iArr2.length > 0) {
                    if (this.a.getAutoSizeStepGranularity() != -1.0f) {
                        this.a.setAutoSizeTextTypeUniformWithConfiguration(Math.round(this.i.d), Math.round(this.i.e), Math.round(this.i.c), 0);
                    } else {
                        this.a.setAutoSizeTextTypeUniformWithPresetSizes(iArr2, 0);
                    }
                }
            }
        }
        n4 n4Var3 = new n4(context, context.obtainStyledAttributes(attributeSet, i0.AppCompatTextView));
        int e2 = n4Var3.e(i0.AppCompatTextView_drawableLeftCompat, -1);
        Drawable a4 = e2 != -1 ? a2.a(context, e2) : null;
        int e3 = n4Var3.e(i0.AppCompatTextView_drawableTopCompat, -1);
        Drawable a5 = e3 != -1 ? a2.a(context, e3) : null;
        int e4 = n4Var3.e(i0.AppCompatTextView_drawableRightCompat, -1);
        Drawable a6 = e4 != -1 ? a2.a(context, e4) : null;
        int e5 = n4Var3.e(i0.AppCompatTextView_drawableBottomCompat, -1);
        Drawable a7 = e5 != -1 ? a2.a(context, e5) : null;
        int e6 = n4Var3.e(i0.AppCompatTextView_drawableStartCompat, -1);
        Drawable a8 = e6 != -1 ? a2.a(context, e6) : null;
        int e7 = n4Var3.e(i0.AppCompatTextView_drawableEndCompat, -1);
        Drawable a9 = e7 != -1 ? a2.a(context, e7) : null;
        int i10 = Build.VERSION.SDK_INT;
        if (a8 != null || a9 != null) {
            Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
            TextView textView3 = this.a;
            if (a8 == null) {
                a8 = compoundDrawablesRelative[0];
            }
            if (a5 == null) {
                a5 = compoundDrawablesRelative[1];
            }
            if (a9 == null) {
                a9 = compoundDrawablesRelative[2];
            }
            if (a7 == null) {
                a7 = compoundDrawablesRelative[3];
            }
            textView3.setCompoundDrawablesRelativeWithIntrinsicBounds(a8, a5, a9, a7);
        } else if (a4 != null || a5 != null || a6 != null || a7 != null) {
            int i11 = Build.VERSION.SDK_INT;
            Drawable[] compoundDrawablesRelative2 = this.a.getCompoundDrawablesRelative();
            if (compoundDrawablesRelative2[0] == null && compoundDrawablesRelative2[2] == null) {
                Drawable[] compoundDrawables = this.a.getCompoundDrawables();
                TextView textView4 = this.a;
                if (a4 == null) {
                    a4 = compoundDrawables[0];
                }
                if (a5 == null) {
                    a5 = compoundDrawables[1];
                }
                if (a6 == null) {
                    a6 = compoundDrawables[2];
                }
                if (a7 == null) {
                    a7 = compoundDrawables[3];
                }
                textView4.setCompoundDrawablesWithIntrinsicBounds(a4, a5, a6, a7);
            } else {
                TextView textView5 = this.a;
                Drawable drawable = compoundDrawablesRelative2[0];
                if (a5 == null) {
                    a5 = compoundDrawablesRelative2[1];
                }
                Drawable drawable2 = compoundDrawablesRelative2[2];
                if (a7 == null) {
                    a7 = compoundDrawablesRelative2[3];
                }
                textView5.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, a5, drawable2, a7);
            }
        }
        if (n4Var3.f(i0.AppCompatTextView_drawableTint)) {
            ColorStateList a10 = n4Var3.a(i0.AppCompatTextView_drawableTint);
            TextView textView6 = this.a;
            if (textView6 != null) {
                int i12 = Build.VERSION.SDK_INT;
                textView6.setCompoundDrawableTintList(a10);
            } else {
                throw new NullPointerException();
            }
        }
        if (n4Var3.f(i0.AppCompatTextView_drawableTintMode)) {
            PorterDuff.Mode a11 = t3.a(n4Var3.c(i0.AppCompatTextView_drawableTintMode, -1), null);
            TextView textView7 = this.a;
            if (textView7 != null) {
                int i13 = Build.VERSION.SDK_INT;
                textView7.setCompoundDrawableTintMode(a11);
            } else {
                throw new NullPointerException();
            }
        }
        int b = n4Var3.b(i0.AppCompatTextView_firstBaselineToTopHeight, -1);
        int b2 = n4Var3.b(i0.AppCompatTextView_lastBaselineToBottomHeight, -1);
        int b3 = n4Var3.b(i0.AppCompatTextView_lineHeight, -1);
        n4Var3.b.recycle();
        if (b != -1) {
            TextView textView8 = this.a;
            defpackage.a.a(b);
            int i14 = Build.VERSION.SDK_INT;
            textView8.setFirstBaselineToTopHeight(b);
        }
        if (b2 != -1) {
            defpackage.a.a(this.a, b2);
        }
        if (b3 != -1) {
            defpackage.a.b(this.a, b3);
        }
    }

    public int b() {
        return Math.round(this.i.e);
    }

    public int c() {
        return Math.round(this.i.d);
    }

    public int d() {
        return Math.round(this.i.c);
    }

    public int[] e() {
        return this.i.f;
    }

    public int f() {
        return this.i.a;
    }

    public boolean g() {
        p3 p3Var = this.i;
        return p3Var.d() && p3Var.a != 0;
    }

    public final void a(Context context, n4 n4Var) {
        int i;
        String d;
        this.j = n4Var.c(i0.TextAppearance_android_textStyle, this.j);
        int i2 = Build.VERSION.SDK_INT;
        this.k = n4Var.c(i0.TextAppearance_android_textFontWeight, -1);
        if (this.k != -1) {
            this.j = (this.j & 2) | 0;
        }
        if (!n4Var.f(i0.TextAppearance_android_fontFamily) && !n4Var.f(i0.TextAppearance_fontFamily)) {
            if (n4Var.f(i0.TextAppearance_android_typeface)) {
                this.m = false;
                int c = n4Var.c(i0.TextAppearance_android_typeface, 1);
                if (c == 1) {
                    this.l = Typeface.SANS_SERIF;
                    return;
                } else if (c == 2) {
                    this.l = Typeface.SERIF;
                    return;
                } else if (c != 3) {
                    return;
                } else {
                    this.l = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.l = null;
        if (n4Var.f(i0.TextAppearance_fontFamily)) {
            i = i0.TextAppearance_fontFamily;
        } else {
            i = i0.TextAppearance_android_fontFamily;
        }
        int i3 = this.k;
        int i4 = this.j;
        if (!context.isRestricted()) {
            try {
                Typeface a2 = n4Var.a(i, this.j, new a(i3, i4, new WeakReference(this.a)));
                if (a2 != null) {
                    int i5 = Build.VERSION.SDK_INT;
                    if (this.k != -1) {
                        this.l = Typeface.create(Typeface.create(a2, 0), this.k, (this.j & 2) != 0);
                    } else {
                        this.l = a2;
                    }
                }
                this.m = this.l == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.l != null || (d = n4Var.d(i)) == null) {
            return;
        }
        int i6 = Build.VERSION.SDK_INT;
        if (this.k != -1) {
            this.l = Typeface.create(Typeface.create(d, 0), this.k, (this.j & 2) != 0);
        } else {
            this.l = Typeface.create(d, this.j);
        }
    }

    public void a(Context context, int i) {
        String d;
        n4 n4Var = new n4(context, context.obtainStyledAttributes(i, i0.TextAppearance));
        if (n4Var.f(i0.TextAppearance_textAllCaps)) {
            this.a.setAllCaps(n4Var.a(i0.TextAppearance_textAllCaps, false));
        }
        int i2 = Build.VERSION.SDK_INT;
        if (n4Var.f(i0.TextAppearance_android_textSize) && n4Var.b(i0.TextAppearance_android_textSize, -1) == 0) {
            this.a.setTextSize(0, XToggleDrawable.LIGHT_RADIUS_DEFAULT);
        }
        a(context, n4Var);
        int i3 = Build.VERSION.SDK_INT;
        if (n4Var.f(i0.TextAppearance_fontVariationSettings) && (d = n4Var.d(i0.TextAppearance_fontVariationSettings)) != null) {
            this.a.setFontVariationSettings(d);
        }
        n4Var.b.recycle();
        Typeface typeface = this.l;
        if (typeface != null) {
            this.a.setTypeface(typeface, this.j);
        }
    }

    public void a() {
        if (this.b != null || this.c != null || this.d != null || this.e != null) {
            Drawable[] compoundDrawables = this.a.getCompoundDrawables();
            a(compoundDrawables[0], this.b);
            a(compoundDrawables[1], this.c);
            a(compoundDrawables[2], this.d);
            a(compoundDrawables[3], this.e);
        }
        int i = Build.VERSION.SDK_INT;
        if (this.f == null && this.g == null) {
            return;
        }
        Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
        a(compoundDrawablesRelative[0], this.f);
        a(compoundDrawablesRelative[2], this.g);
    }

    public final void a(Drawable drawable, l4 l4Var) {
        if (drawable == null || l4Var == null) {
            return;
        }
        w2.a(drawable, l4Var, this.a.getDrawableState());
    }

    public static l4 a(Context context, w2 w2Var, int i) {
        ColorStateList b = w2Var.b(context, i);
        if (b != null) {
            l4 l4Var = new l4();
            l4Var.d = true;
            l4Var.a = b;
            return l4Var;
        }
        return null;
    }

    public void a(int i) {
        p3 p3Var = this.i;
        if (p3Var.d()) {
            if (i == 0) {
                p3Var.a = 0;
                p3Var.d = -1.0f;
                p3Var.e = -1.0f;
                p3Var.c = -1.0f;
                p3Var.f = new int[0];
                p3Var.b = false;
            } else if (i == 1) {
                DisplayMetrics displayMetrics = p3Var.j.getResources().getDisplayMetrics();
                p3Var.a(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
                if (p3Var.b()) {
                    p3Var.a();
                }
            } else {
                throw new IllegalArgumentException(jg.a("Unknown auto-size text type: ", i));
            }
        }
    }

    public void a(int i, int i2, int i3, int i4) {
        p3 p3Var = this.i;
        if (p3Var.d()) {
            DisplayMetrics displayMetrics = p3Var.j.getResources().getDisplayMetrics();
            p3Var.a(TypedValue.applyDimension(i4, i, displayMetrics), TypedValue.applyDimension(i4, i2, displayMetrics), TypedValue.applyDimension(i4, i3, displayMetrics));
            if (p3Var.b()) {
                p3Var.a();
            }
        }
    }

    public void a(int[] iArr, int i) {
        p3 p3Var = this.i;
        if (p3Var.d()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = p3Var.j.getResources().getDisplayMetrics();
                    for (int i2 = 0; i2 < length; i2++) {
                        iArr2[i2] = Math.round(TypedValue.applyDimension(i, iArr[i2], displayMetrics));
                    }
                }
                p3Var.f = p3Var.a(iArr2);
                if (!p3Var.c()) {
                    StringBuilder a2 = jg.a("None of the preset sizes is valid: ");
                    a2.append(Arrays.toString(iArr));
                    throw new IllegalArgumentException(a2.toString());
                }
            } else {
                p3Var.g = false;
            }
            if (p3Var.b()) {
                p3Var.a();
            }
        }
    }

    public void a(ColorStateList colorStateList) {
        if (this.h == null) {
            this.h = new l4();
        }
        l4 l4Var = this.h;
        l4Var.a = colorStateList;
        l4Var.d = colorStateList != null;
        l4 l4Var2 = this.h;
        this.b = l4Var2;
        this.c = l4Var2;
        this.d = l4Var2;
        this.e = l4Var2;
        this.f = l4Var2;
        this.g = l4Var2;
    }

    public void a(PorterDuff.Mode mode) {
        if (this.h == null) {
            this.h = new l4();
        }
        l4 l4Var = this.h;
        l4Var.b = mode;
        l4Var.c = mode != null;
        l4 l4Var2 = this.h;
        this.b = l4Var2;
        this.c = l4Var2;
        this.d = l4Var2;
        this.e = l4Var2;
        this.f = l4Var2;
        this.g = l4Var2;
    }

    public void a(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        if (Build.VERSION.SDK_INT >= 30 || inputConnection == null) {
            return;
        }
        va.a(editorInfo, textView.getText());
    }
}
