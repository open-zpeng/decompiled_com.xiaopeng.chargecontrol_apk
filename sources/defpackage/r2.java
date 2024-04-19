package defpackage;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
/* compiled from: AppCompatBackgroundHelper.java */
/* renamed from: r2  reason: default package */
/* loaded from: classes.dex */
public class r2 {
    public final View a;
    public l4 d;
    public l4 e;
    public l4 f;
    public int c = -1;
    public final w2 b = w2.a();

    public r2(View view) {
        this.a = view;
    }

    public void a(AttributeSet attributeSet, int i) {
        n4 a = n4.a(this.a.getContext(), attributeSet, i0.ViewBackgroundHelper, i, 0);
        View view = this.a;
        y9.a(view, view.getContext(), i0.ViewBackgroundHelper, attributeSet, a.b, i, 0);
        try {
            if (a.f(i0.ViewBackgroundHelper_android_background)) {
                this.c = a.e(i0.ViewBackgroundHelper_android_background, -1);
                ColorStateList b = this.b.b(this.a.getContext(), this.c);
                if (b != null) {
                    a(b);
                }
            }
            if (a.f(i0.ViewBackgroundHelper_backgroundTint)) {
                View view2 = this.a;
                ColorStateList a2 = a.a(i0.ViewBackgroundHelper_backgroundTint);
                int i2 = Build.VERSION.SDK_INT;
                view2.setBackgroundTintList(a2);
                int i3 = Build.VERSION.SDK_INT;
            }
            if (a.f(i0.ViewBackgroundHelper_backgroundTintMode)) {
                View view3 = this.a;
                PorterDuff.Mode a3 = t3.a(a.c(i0.ViewBackgroundHelper_backgroundTintMode, -1), null);
                int i4 = Build.VERSION.SDK_INT;
                view3.setBackgroundTintMode(a3);
                int i5 = Build.VERSION.SDK_INT;
            }
            a.b.recycle();
        } catch (Throwable th) {
            a.b.recycle();
            throw th;
        }
    }

    public void b(ColorStateList colorStateList) {
        if (this.e == null) {
            this.e = new l4();
        }
        l4 l4Var = this.e;
        l4Var.a = colorStateList;
        l4Var.d = true;
        a();
    }

    public PorterDuff.Mode c() {
        l4 l4Var = this.e;
        if (l4Var != null) {
            return l4Var.b;
        }
        return null;
    }

    public void d() {
        this.c = -1;
        a((ColorStateList) null);
        a();
    }

    public ColorStateList b() {
        l4 l4Var = this.e;
        if (l4Var != null) {
            return l4Var.a;
        }
        return null;
    }

    public void a(int i) {
        this.c = i;
        w2 w2Var = this.b;
        a(w2Var != null ? w2Var.b(this.a.getContext(), i) : null);
        a();
    }

    public void a(PorterDuff.Mode mode) {
        if (this.e == null) {
            this.e = new l4();
        }
        l4 l4Var = this.e;
        l4Var.b = mode;
        l4Var.c = true;
        a();
    }

    public void a() {
        Drawable background = this.a.getBackground();
        if (background != null) {
            int i = Build.VERSION.SDK_INT;
            boolean z = true;
            if (this.d != null) {
                if (this.f == null) {
                    this.f = new l4();
                }
                l4 l4Var = this.f;
                l4Var.a();
                ColorStateList d = y9.d(this.a);
                if (d != null) {
                    l4Var.d = true;
                    l4Var.a = d;
                }
                View view = this.a;
                int i2 = Build.VERSION.SDK_INT;
                PorterDuff.Mode backgroundTintMode = view.getBackgroundTintMode();
                if (backgroundTintMode != null) {
                    l4Var.c = true;
                    l4Var.b = backgroundTintMode;
                }
                if (l4Var.d || l4Var.c) {
                    w2.a(background, l4Var, this.a.getDrawableState());
                } else {
                    z = false;
                }
                if (z) {
                    return;
                }
            }
            l4 l4Var2 = this.e;
            if (l4Var2 != null) {
                w2.a(background, l4Var2, this.a.getDrawableState());
                return;
            }
            l4 l4Var3 = this.d;
            if (l4Var3 != null) {
                w2.a(background, l4Var3, this.a.getDrawableState());
            }
        }
    }

    public void a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.d == null) {
                this.d = new l4();
            }
            l4 l4Var = this.d;
            l4Var.a = colorStateList;
            l4Var.d = true;
        } else {
            this.d = null;
        }
        a();
    }
}
