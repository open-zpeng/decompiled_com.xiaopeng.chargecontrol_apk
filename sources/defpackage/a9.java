package defpackage;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
/* compiled from: PrecomputedTextCompat.java */
/* renamed from: a9  reason: default package */
/* loaded from: classes.dex */
public class a9 implements Spannable {
    public final Spannable c;
    public final a d;
    public final PrecomputedText e;

    /* compiled from: PrecomputedTextCompat.java */
    /* renamed from: a9$a */
    /* loaded from: classes.dex */
    public static final class a {
        public final TextPaint a;
        public final TextDirectionHeuristic b;
        public final int c;
        public final int d;

        public a(PrecomputedText.Params params) {
            this.a = params.getTextPaint();
            this.b = params.getTextDirection();
            this.c = params.getBreakStrategy();
            this.d = params.getHyphenationFrequency();
            int i = Build.VERSION.SDK_INT;
        }

        public int a() {
            return this.c;
        }

        public int b() {
            return this.d;
        }

        public TextDirectionHeuristic c() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (a(aVar)) {
                    int i = Build.VERSION.SDK_INT;
                    return this.b == aVar.b;
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            int i = Build.VERSION.SDK_INT;
            return defpackage.a.a(Float.valueOf(this.a.getTextSize()), Float.valueOf(this.a.getTextScaleX()), Float.valueOf(this.a.getTextSkewX()), Float.valueOf(this.a.getLetterSpacing()), Integer.valueOf(this.a.getFlags()), this.a.getTextLocales(), this.a.getTypeface(), Boolean.valueOf(this.a.isElegantTextHeight()), this.b, Integer.valueOf(this.c), Integer.valueOf(this.d));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("{");
            StringBuilder a = jg.a("textSize=");
            a.append(this.a.getTextSize());
            sb.append(a.toString());
            sb.append(", textScaleX=" + this.a.getTextScaleX());
            sb.append(", textSkewX=" + this.a.getTextSkewX());
            int i = Build.VERSION.SDK_INT;
            StringBuilder a2 = jg.a(", letterSpacing=");
            a2.append(this.a.getLetterSpacing());
            sb.append(a2.toString());
            sb.append(", elegantTextHeight=" + this.a.isElegantTextHeight());
            int i2 = Build.VERSION.SDK_INT;
            StringBuilder a3 = jg.a(", textLocale=");
            a3.append(this.a.getTextLocales());
            sb.append(a3.toString());
            sb.append(", typeface=" + this.a.getTypeface());
            int i3 = Build.VERSION.SDK_INT;
            StringBuilder a4 = jg.a(", variationSettings=");
            a4.append(this.a.getFontVariationSettings());
            sb.append(a4.toString());
            sb.append(", textDir=" + this.b);
            sb.append(", breakStrategy=" + this.c);
            sb.append(", hyphenationFrequency=" + this.d);
            sb.append("}");
            return sb.toString();
        }

        public boolean a(a aVar) {
            int i = Build.VERSION.SDK_INT;
            if (this.c == aVar.c && this.d == aVar.d && this.a.getTextSize() == aVar.a.getTextSize() && this.a.getTextScaleX() == aVar.a.getTextScaleX() && this.a.getTextSkewX() == aVar.a.getTextSkewX()) {
                int i2 = Build.VERSION.SDK_INT;
                if (this.a.getLetterSpacing() == aVar.a.getLetterSpacing() && TextUtils.equals(this.a.getFontFeatureSettings(), aVar.a.getFontFeatureSettings()) && this.a.getFlags() == aVar.a.getFlags()) {
                    int i3 = Build.VERSION.SDK_INT;
                    if (this.a.getTextLocales().equals(aVar.a.getTextLocales())) {
                        return this.a.getTypeface() == null ? aVar.a.getTypeface() == null : this.a.getTypeface().equals(aVar.a.getTypeface());
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        return this.c.charAt(i);
    }

    @Override // android.text.Spanned
    public int getSpanEnd(Object obj) {
        return this.c.getSpanEnd(obj);
    }

    @Override // android.text.Spanned
    public int getSpanFlags(Object obj) {
        return this.c.getSpanFlags(obj);
    }

    @Override // android.text.Spanned
    public int getSpanStart(Object obj) {
        return this.c.getSpanStart(obj);
    }

    @Override // android.text.Spanned
    @SuppressLint({"NewApi"})
    public <T> T[] getSpans(int i, int i2, Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 29) {
            return (T[]) this.e.getSpans(i, i2, cls);
        }
        return (T[]) this.c.getSpans(i, i2, cls);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.c.length();
    }

    @Override // android.text.Spanned
    public int nextSpanTransition(int i, int i2, Class cls) {
        return this.c.nextSpanTransition(i, i2, cls);
    }

    @Override // android.text.Spannable
    @SuppressLint({"NewApi"})
    public void removeSpan(Object obj) {
        if (!(obj instanceof MetricAffectingSpan)) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.e.removeSpan(obj);
                return;
            } else {
                this.c.removeSpan(obj);
                return;
            }
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
    }

    @Override // android.text.Spannable
    @SuppressLint({"NewApi"})
    public void setSpan(Object obj, int i, int i2, int i3) {
        if (!(obj instanceof MetricAffectingSpan)) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.e.setSpan(obj, i, i2, i3);
                return;
            } else {
                this.c.setSpan(obj, i, i2, i3);
                return;
            }
        }
        throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return this.c.subSequence(i, i2);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.c.toString();
    }
}
