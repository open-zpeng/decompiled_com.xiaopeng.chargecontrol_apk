package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import defpackage.a9;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
/* compiled from: AppCompatTextView.java */
/* renamed from: o3  reason: default package */
/* loaded from: classes.dex */
public class o3 extends TextView implements x9, eb, ab {
    public final r2 c;
    public final m3 d;
    public final l3 e;
    public boolean f;
    public Future<a9> g;

    public o3(Context context) {
        this(context, null);
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        r2 r2Var = this.c;
        if (r2Var != null) {
            r2Var.a();
        }
        m3 m3Var = this.d;
        if (m3Var != null) {
            m3Var.a();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (ab.a) {
            return super.getAutoSizeMaxTextSize();
        }
        m3 m3Var = this.d;
        if (m3Var != null) {
            return m3Var.b();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (ab.a) {
            return super.getAutoSizeMinTextSize();
        }
        m3 m3Var = this.d;
        if (m3Var != null) {
            return m3Var.c();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (ab.a) {
            return super.getAutoSizeStepGranularity();
        }
        m3 m3Var = this.d;
        if (m3Var != null) {
            return m3Var.d();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (ab.a) {
            return super.getAutoSizeTextAvailableSizes();
        }
        m3 m3Var = this.d;
        return m3Var != null ? m3Var.e() : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (ab.a) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        m3 m3Var = this.d;
        if (m3Var != null) {
            return m3Var.f();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return getPaddingTop() - getPaint().getFontMetricsInt().top;
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return getPaddingBottom() + getPaint().getFontMetricsInt().bottom;
    }

    public ColorStateList getSupportBackgroundTintList() {
        r2 r2Var = this.c;
        if (r2Var != null) {
            return r2Var.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        r2 r2Var = this.c;
        if (r2Var != null) {
            return r2Var.c();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        l4 l4Var = this.d.h;
        if (l4Var != null) {
            return l4Var.a;
        }
        return null;
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        l4 l4Var = this.d.h;
        if (l4Var != null) {
            return l4Var.b;
        }
        return null;
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        Future<a9> future = this.g;
        if (future != null) {
            try {
                this.g = null;
                a.a((TextView) this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        int i = Build.VERSION.SDK_INT;
        return super.getTextClassifier();
    }

    public a9.a getTextMetricsParamsCompat() {
        int i = Build.VERSION.SDK_INT;
        return new a9.a(getTextMetricsParams());
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.d.a(this, onCreateInputConnection, editorInfo);
        a.a(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m3 m3Var = this.d;
        if (m3Var == null || ab.a) {
            return;
        }
        m3Var.i.a();
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        Future<a9> future = this.g;
        if (future != null) {
            try {
                this.g = null;
                a.a((TextView) this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        m3 m3Var = this.d;
        if (m3Var == null || ab.a || !m3Var.g()) {
            return;
        }
        this.d.i.a();
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (ab.a) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
            return;
        }
        m3 m3Var = this.d;
        if (m3Var != null) {
            m3Var.a(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (ab.a) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
            return;
        }
        m3 m3Var = this.d;
        if (m3Var != null) {
            m3Var.a(iArr, i);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (ab.a) {
            super.setAutoSizeTextTypeWithDefaults(i);
            return;
        }
        m3 m3Var = this.d;
        if (m3Var != null) {
            m3Var.a(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        r2 r2Var = this.c;
        if (r2Var != null) {
            r2Var.d();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        r2 r2Var = this.c;
        if (r2Var != null) {
            r2Var.a(i);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        m3 m3Var = this.d;
        if (m3Var != null) {
            m3Var.a();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        m3 m3Var = this.d;
        if (m3Var != null) {
            m3Var.a();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        m3 m3Var = this.d;
        if (m3Var != null) {
            m3Var.a();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        m3 m3Var = this.d;
        if (m3Var != null) {
            m3Var.a();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        int i = Build.VERSION.SDK_INT;
        super.setCustomSelectionActionModeCallback(callback);
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i) {
        int i2 = Build.VERSION.SDK_INT;
        super.setFirstBaselineToTopHeight(i);
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i) {
        int i2 = Build.VERSION.SDK_INT;
        super.setLastBaselineToBottomHeight(i);
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i) {
        a.b(this, i);
    }

    public void setPrecomputedText(a9 a9Var) {
        a.a((TextView) this, a9Var);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        r2 r2Var = this.c;
        if (r2Var != null) {
            r2Var.b(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        r2 r2Var = this.c;
        if (r2Var != null) {
            r2Var.a(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.d.a(colorStateList);
        this.d.a();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        this.d.a(mode);
        this.d.a();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        m3 m3Var = this.d;
        if (m3Var != null) {
            m3Var.a(context, i);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        int i = Build.VERSION.SDK_INT;
        super.setTextClassifier(textClassifier);
    }

    public void setTextFuture(Future<a9> future) {
        this.g = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(a9.a aVar) {
        int i = Build.VERSION.SDK_INT;
        TextDirectionHeuristic c = aVar.c();
        int i2 = 1;
        if (c != TextDirectionHeuristics.FIRSTSTRONG_RTL && c != TextDirectionHeuristics.FIRSTSTRONG_LTR) {
            if (c == TextDirectionHeuristics.ANYRTL_LTR) {
                i2 = 2;
            } else if (c == TextDirectionHeuristics.LTR) {
                i2 = 3;
            } else if (c == TextDirectionHeuristics.RTL) {
                i2 = 4;
            } else if (c == TextDirectionHeuristics.LOCALE) {
                i2 = 5;
            } else if (c == TextDirectionHeuristics.FIRSTSTRONG_LTR) {
                i2 = 6;
            } else if (c == TextDirectionHeuristics.FIRSTSTRONG_RTL) {
                i2 = 7;
            }
        }
        setTextDirection(i2);
        int i3 = Build.VERSION.SDK_INT;
        getPaint().set(aVar.a);
        setBreakStrategy(aVar.a());
        setHyphenationFrequency(aVar.b());
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        boolean z = ab.a;
        if (z) {
            super.setTextSize(i, f);
            return;
        }
        m3 m3Var = this.d;
        if (m3Var == null || z || m3Var.g()) {
            return;
        }
        m3Var.i.a(i, f);
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface, int i) {
        if (this.f) {
            return;
        }
        Typeface typeface2 = null;
        if (typeface != null && i > 0) {
            typeface2 = y7.a(getContext(), typeface, i);
        }
        this.f = true;
        if (typeface2 != null) {
            typeface = typeface2;
        }
        try {
            super.setTypeface(typeface, i);
        } finally {
            this.f = false;
        }
    }

    public o3(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o3(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        k4.a(context);
        this.f = false;
        i4.a(this, getContext());
        this.c = new r2(this);
        this.c.a(attributeSet, i);
        this.d = new m3(this);
        this.d.a(attributeSet, i);
        this.d.a();
        this.e = new l3(this);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i != 0 ? i1.b(context, i) : null, i2 != 0 ? i1.b(context, i2) : null, i3 != 0 ? i1.b(context, i3) : null, i4 != 0 ? i1.b(context, i4) : null);
        m3 m3Var = this.d;
        if (m3Var != null) {
            m3Var.a();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i != 0 ? i1.b(context, i) : null, i2 != 0 ? i1.b(context, i2) : null, i3 != 0 ? i1.b(context, i3) : null, i4 != 0 ? i1.b(context, i4) : null);
        m3 m3Var = this.d;
        if (m3Var != null) {
            m3Var.a();
        }
    }
}
