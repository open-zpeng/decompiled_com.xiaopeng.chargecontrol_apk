package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
/* compiled from: ThemeUtils.java */
/* renamed from: i4  reason: default package */
/* loaded from: classes.dex */
public class i4 {
    public static final ThreadLocal<TypedValue> a = new ThreadLocal<>();
    public static final int[] b = {-16842910};
    public static final int[] c = {16842908};
    public static final int[] d;
    public static final int[] e;
    public static final int[] f;
    public static final int[] g;

    static {
        new int[1][0] = 16843518;
        d = new int[]{16842919};
        e = new int[]{16842912};
        new int[1][0] = 16842913;
        f = new int[0];
        g = new int[1];
    }

    public static int a(Context context, int i) {
        ColorStateList c2 = c(context, i);
        if (c2 != null && c2.isStateful()) {
            return c2.getColorForState(b, c2.getDefaultColor());
        }
        TypedValue typedValue = a.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            a.set(typedValue);
        }
        context.getTheme().resolveAttribute(16842803, typedValue, true);
        float f2 = typedValue.getFloat();
        int b2 = b(context, i);
        return w7.b(b2, Math.round(Color.alpha(b2) * f2));
    }

    public static int b(Context context, int i) {
        int[] iArr = g;
        iArr[0] = i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, iArr);
        try {
            return obtainStyledAttributes.getColor(0, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static ColorStateList c(Context context, int i) {
        ColorStateList colorStateList;
        int resourceId;
        int[] iArr = g;
        iArr[0] = i;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, iArr);
        try {
            if (!obtainStyledAttributes.hasValue(0) || (resourceId = obtainStyledAttributes.getResourceId(0, 0)) == 0 || (colorStateList = i1.a(context, resourceId)) == null) {
                colorStateList = obtainStyledAttributes.getColorStateList(0);
            }
            return colorStateList;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public static void a(View view, Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i0.AppCompatTheme);
        try {
            if (!obtainStyledAttributes.hasValue(i0.AppCompatTheme_windowActionBar)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }
}
