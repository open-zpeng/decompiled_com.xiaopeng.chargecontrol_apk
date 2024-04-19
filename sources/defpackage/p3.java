package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
/* compiled from: AppCompatTextViewAutoSizeHelper.java */
/* renamed from: p3  reason: default package */
/* loaded from: classes.dex */
public class p3 {
    public static final RectF l = new RectF();
    @SuppressLint({"BanConcurrentHashMap"})
    public static ConcurrentHashMap<String, Method> m = new ConcurrentHashMap<>();
    @SuppressLint({"BanConcurrentHashMap"})
    public static ConcurrentHashMap<String, Field> n = new ConcurrentHashMap<>();
    public int a = 0;
    public boolean b = false;
    public float c = -1.0f;
    public float d = -1.0f;
    public float e = -1.0f;
    public int[] f = new int[0];
    public boolean g = false;
    public TextPaint h;
    public final TextView i;
    public final Context j;
    public final c k;

    /* compiled from: AppCompatTextViewAutoSizeHelper.java */
    /* renamed from: p3$a */
    /* loaded from: classes.dex */
    public static class a extends c {
        @Override // defpackage.p3.c
        public void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection((TextDirectionHeuristic) p3.a(textView, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    /* compiled from: AppCompatTextViewAutoSizeHelper.java */
    /* renamed from: p3$b */
    /* loaded from: classes.dex */
    public static class b extends a {
        @Override // defpackage.p3.c
        public boolean a(TextView textView) {
            return textView.isHorizontallyScrollable();
        }

        @Override // defpackage.p3.a, defpackage.p3.c
        public void a(StaticLayout.Builder builder, TextView textView) {
            builder.setTextDirection(textView.getTextDirectionHeuristic());
        }
    }

    /* compiled from: AppCompatTextViewAutoSizeHelper.java */
    /* renamed from: p3$c */
    /* loaded from: classes.dex */
    public static class c {
        public void a(StaticLayout.Builder builder, TextView textView) {
            throw null;
        }

        public boolean a(TextView textView) {
            return ((Boolean) p3.a(textView, "getHorizontallyScrolling", false)).booleanValue();
        }
    }

    public p3(TextView textView) {
        this.i = textView;
        this.j = this.i.getContext();
        if (Build.VERSION.SDK_INT >= 29) {
            this.k = new b();
        } else {
            this.k = new a();
        }
    }

    public final int[] a(int[] iArr) {
        int length = iArr.length;
        if (length == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            if (i > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i)) < 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        if (length == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr2[i2] = ((Integer) arrayList.get(i2)).intValue();
        }
        return iArr2;
    }

    public final boolean b() {
        if (d() && this.a == 1) {
            if (!this.g || this.f.length == 0) {
                int floor = ((int) Math.floor((this.e - this.d) / this.c)) + 1;
                int[] iArr = new int[floor];
                for (int i = 0; i < floor; i++) {
                    iArr[i] = Math.round((i * this.c) + this.d);
                }
                this.f = a(iArr);
            }
            this.b = true;
        } else {
            this.b = false;
        }
        return this.b;
    }

    public final boolean c() {
        int length = this.f.length;
        this.g = length > 0;
        if (this.g) {
            this.a = 1;
            int[] iArr = this.f;
            this.d = iArr[0];
            this.e = iArr[length - 1];
            this.c = -1.0f;
        }
        return this.g;
    }

    public final boolean d() {
        return !(this.i instanceof x2);
    }

    public final void a(float f, float f2, float f3) {
        if (f <= XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f + "px) is less or equal to (0px)");
        } else if (f2 <= f) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f2 + "px) is less or equal to minimum auto-size text size (" + f + "px)");
        } else if (f3 > XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
            this.a = 1;
            this.d = f;
            this.e = f2;
            this.c = f3;
            this.g = false;
        } else {
            throw new IllegalArgumentException("The auto-size step granularity (" + f3 + "px) is less or equal to (0px)");
        }
    }

    public void a(int i, float f) {
        Resources resources;
        Context context = this.j;
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        float applyDimension = TypedValue.applyDimension(i, f, resources.getDisplayMetrics());
        if (applyDimension != this.i.getPaint().getTextSize()) {
            this.i.getPaint().setTextSize(applyDimension);
            int i2 = Build.VERSION.SDK_INT;
            boolean isInLayout = this.i.isInLayout();
            if (this.i.getLayout() != null) {
                this.b = false;
                try {
                    Method a2 = a("nullLayouts");
                    if (a2 != null) {
                        a2.invoke(this.i, new Object[0]);
                    }
                } catch (Exception e) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e);
                }
                if (!isInLayout) {
                    this.i.requestLayout();
                } else {
                    this.i.forceLayout();
                }
                this.i.invalidate();
            }
        }
    }

    public final int a(RectF rectF) {
        CharSequence transformation;
        int length = this.f.length;
        if (length != 0) {
            int i = length - 1;
            int i2 = 1;
            int i3 = 0;
            while (i2 <= i) {
                int i4 = (i2 + i) / 2;
                int i5 = this.f[i4];
                CharSequence text = this.i.getText();
                TransformationMethod transformationMethod = this.i.getTransformationMethod();
                if (transformationMethod != null && (transformation = transformationMethod.getTransformation(text, this.i)) != null) {
                    text = transformation;
                }
                int i6 = Build.VERSION.SDK_INT;
                int maxLines = this.i.getMaxLines();
                TextPaint textPaint = this.h;
                if (textPaint == null) {
                    this.h = new TextPaint();
                } else {
                    textPaint.reset();
                }
                this.h.set(this.i.getPaint());
                this.h.setTextSize(i5);
                int round = Math.round(rectF.right);
                int i7 = Build.VERSION.SDK_INT;
                StaticLayout.Builder obtain = StaticLayout.Builder.obtain(text, 0, text.length(), this.h, round);
                obtain.setAlignment((Layout.Alignment) a(this.i, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL)).setLineSpacing(this.i.getLineSpacingExtra(), this.i.getLineSpacingMultiplier()).setIncludePad(this.i.getIncludeFontPadding()).setBreakStrategy(this.i.getBreakStrategy()).setHyphenationFrequency(this.i.getHyphenationFrequency()).setMaxLines(maxLines == -1 ? Integer.MAX_VALUE : maxLines);
                try {
                    this.k.a(obtain, this.i);
                } catch (ClassCastException unused) {
                    Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
                }
                StaticLayout build = obtain.build();
                if ((maxLines == -1 || (build.getLineCount() <= maxLines && build.getLineEnd(build.getLineCount() - 1) == text.length())) && ((float) build.getHeight()) <= rectF.bottom) {
                    int i8 = i4 + 1;
                    i3 = i2;
                    i2 = i8;
                } else {
                    i3 = i4 - 1;
                    i = i3;
                }
            }
            return this.f[i3];
        }
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    public static <T> T a(Object obj, String str, T t) {
        try {
            return (T) a(str).invoke(obj, new Object[0]);
        } catch (Exception e) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e);
            return t;
        }
    }

    public static Method a(String str) {
        try {
            Method method = m.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                method.setAccessible(true);
                m.put(str, method);
            }
            return method;
        } catch (Exception e) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e);
            return null;
        }
    }

    public void a() {
        if (d() && this.a != 0) {
            if (this.b) {
                if (this.i.getMeasuredHeight() <= 0 || this.i.getMeasuredWidth() <= 0) {
                    return;
                }
                int measuredWidth = this.k.a(this.i) ? 1048576 : (this.i.getMeasuredWidth() - this.i.getTotalPaddingLeft()) - this.i.getTotalPaddingRight();
                int height = (this.i.getHeight() - this.i.getCompoundPaddingBottom()) - this.i.getCompoundPaddingTop();
                if (measuredWidth <= 0 || height <= 0) {
                    return;
                }
                synchronized (l) {
                    l.setEmpty();
                    l.right = measuredWidth;
                    l.bottom = height;
                    float a2 = a(l);
                    if (a2 != this.i.getTextSize()) {
                        a(0, a2);
                    }
                }
            }
            this.b = true;
        }
    }
}
