package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewConfiguration;
import com.xiaopeng.xui.drawable.XLoadingDrawable;
import com.xiaopeng.xui.drawable.XToggleDrawable;
/* compiled from: Utils.java */
/* renamed from: zt  reason: default package */
/* loaded from: classes.dex */
public abstract class zt {
    public static DisplayMetrics a = null;
    public static int b = 50;
    public static int c = 8000;
    public static Rect d;
    public static Paint.FontMetrics e;
    public static Rect f;
    public static fs g;
    public static Rect h;
    public static Rect i;
    public static Paint.FontMetrics j;

    static {
        Double.longBitsToDouble(1L);
        Float.intBitsToFloat(1);
        d = new Rect();
        e = new Paint.FontMetrics();
        f = new Rect();
        g = new ds(1);
        h = new Rect();
        i = new Rect();
        j = new Paint.FontMetrics();
    }

    public static void a(Canvas canvas, Drawable drawable, int i2, int i3, int i4, int i5) {
        vt a2 = vt.d.a();
        a2.b = i2 - (i4 / 2);
        a2.c = i3 - (i5 / 2);
        drawable.copyBounds(h);
        Rect rect = h;
        int i6 = rect.left;
        int i7 = rect.top;
        drawable.setBounds(i6, i7, i6 + i4, i4 + i7);
        int save = canvas.save();
        canvas.translate(a2.b, a2.c);
        drawable.draw(canvas);
        canvas.restoreToCount(save);
    }

    public static float b(Paint paint, Paint.FontMetrics fontMetrics) {
        paint.getFontMetrics(fontMetrics);
        return (fontMetrics.ascent - fontMetrics.top) + fontMetrics.bottom;
    }

    public static int c(Paint paint, String str) {
        return (int) paint.measureText(str);
    }

    public static st b(Paint paint, String str) {
        st a2 = st.a(XToggleDrawable.LIGHT_RADIUS_DEFAULT, XToggleDrawable.LIGHT_RADIUS_DEFAULT);
        Rect rect = f;
        rect.set(0, 0, 0, 0);
        paint.getTextBounds(str, 0, str.length(), rect);
        a2.b = rect.width();
        a2.c = rect.height();
        return a2;
    }

    public static void a(Context context) {
        if (context == null) {
            b = ViewConfiguration.getMinimumFlingVelocity();
            c = ViewConfiguration.getMaximumFlingVelocity();
            Log.e("MPChartLib-Utils", "Utils.init(...) PROVIDED CONTEXT OBJECT IS NULL");
            return;
        }
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        b = viewConfiguration.getScaledMinimumFlingVelocity();
        c = viewConfiguration.getScaledMaximumFlingVelocity();
        a = context.getResources().getDisplayMetrics();
    }

    public static float a(float f2) {
        DisplayMetrics displayMetrics = a;
        if (displayMetrics == null) {
            Log.e("MPChartLib-Utils", "Utils NOT INITIALIZED. You need to call Utils.init(...) at least once before calling Utils.convertDpToPixel(...). Otherwise conversion does not take place.");
            return f2;
        }
        return f2 * displayMetrics.density;
    }

    public static int a(Paint paint, String str) {
        Rect rect = d;
        rect.set(0, 0, 0, 0);
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.height();
    }

    public static float a(Paint paint) {
        return a(paint, e);
    }

    public static float a(Paint paint, Paint.FontMetrics fontMetrics) {
        paint.getFontMetrics(fontMetrics);
        return fontMetrics.descent - fontMetrics.ascent;
    }

    public static float a(double d2) {
        if (Double.isInfinite(d2) || Double.isNaN(d2) || d2 == XLoadingDrawable.DEFAULT_RADIANS) {
            return XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        }
        float pow = (float) Math.pow(10.0d, 1 - ((int) Math.ceil((float) Math.log10(d2 < XLoadingDrawable.DEFAULT_RADIANS ? -d2 : d2))));
        return ((float) Math.round(d2 * pow)) / pow;
    }

    @SuppressLint({"NewApi"})
    public static void a(View view) {
        int i2 = Build.VERSION.SDK_INT;
        view.postInvalidateOnAnimation();
    }

    public static st a(float f2, float f3, float f4) {
        double d2 = f4 * 0.017453292f;
        return st.a(Math.abs(((float) Math.sin(d2)) * f3) + Math.abs(((float) Math.cos(d2)) * f2), Math.abs(f3 * ((float) Math.cos(d2))) + Math.abs(f2 * ((float) Math.sin(d2))));
    }

    public static int a() {
        return Build.VERSION.SDK_INT;
    }
}
