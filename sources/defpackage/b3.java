package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
/* compiled from: AppCompatMultiAutoCompleteTextView.java */
/* renamed from: b3  reason: default package */
/* loaded from: classes.dex */
public class b3 extends MultiAutoCompleteTextView implements x9 {
    public static final int[] e = {16843126};
    public final r2 c;
    public final m3 d;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public b3(android.content.Context r4, android.util.AttributeSet r5) {
        /*
            r3 = this;
            int r0 = defpackage.z.autoCompleteTextViewStyle
            defpackage.k4.a(r4)
            r3.<init>(r4, r5, r0)
            android.content.Context r4 = r3.getContext()
            defpackage.i4.a(r3, r4)
            android.content.Context r4 = r3.getContext()
            int[] r1 = defpackage.b3.e
            r2 = 0
            n4 r4 = defpackage.n4.a(r4, r5, r1, r0, r2)
            boolean r1 = r4.f(r2)
            if (r1 == 0) goto L27
            android.graphics.drawable.Drawable r1 = r4.b(r2)
            r3.setDropDownBackgroundDrawable(r1)
        L27:
            android.content.res.TypedArray r4 = r4.b
            r4.recycle()
            r2 r4 = new r2
            r4.<init>(r3)
            r3.c = r4
            r2 r4 = r3.c
            r4.a(r5, r0)
            m3 r4 = new m3
            r4.<init>(r3)
            r3.d = r4
            m3 r4 = r3.d
            r4.a(r5, r0)
            m3 r4 = r3.d
            r4.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.b3.<init>(android.content.Context, android.util.AttributeSet):void");
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

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        a.a(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
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

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(i1.b(getContext(), i));
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

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        m3 m3Var = this.d;
        if (m3Var != null) {
            m3Var.a(context, i);
        }
    }
}
