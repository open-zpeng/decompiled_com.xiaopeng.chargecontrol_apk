package defpackage;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
/* compiled from: AppCompatImageHelper.java */
/* renamed from: z2  reason: default package */
/* loaded from: classes.dex */
public class z2 {
    public final ImageView a;
    public l4 b;
    public l4 c;
    public l4 d;

    public z2(ImageView imageView) {
        this.a = imageView;
    }

    public void a(AttributeSet attributeSet, int i) {
        int e;
        n4 a = n4.a(this.a.getContext(), attributeSet, i0.AppCompatImageView, i, 0);
        ImageView imageView = this.a;
        y9.a(imageView, imageView.getContext(), i0.AppCompatImageView, attributeSet, a.b, i, 0);
        try {
            Drawable drawable = this.a.getDrawable();
            if (drawable == null && (e = a.e(i0.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = i1.b(this.a.getContext(), e)) != null) {
                this.a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                t3.b(drawable);
            }
            if (a.f(i0.AppCompatImageView_tint)) {
                ImageView imageView2 = this.a;
                ColorStateList a2 = a.a(i0.AppCompatImageView_tint);
                int i2 = Build.VERSION.SDK_INT;
                imageView2.setImageTintList(a2);
                int i3 = Build.VERSION.SDK_INT;
            }
            if (a.f(i0.AppCompatImageView_tintMode)) {
                ImageView imageView3 = this.a;
                PorterDuff.Mode a3 = t3.a(a.c(i0.AppCompatImageView_tintMode, -1), null);
                int i4 = Build.VERSION.SDK_INT;
                imageView3.setImageTintMode(a3);
                int i5 = Build.VERSION.SDK_INT;
            }
            a.b.recycle();
        } catch (Throwable th) {
            a.b.recycle();
            throw th;
        }
    }

    public void a(int i) {
        if (i != 0) {
            Drawable b = i1.b(this.a.getContext(), i);
            if (b != null) {
                t3.b(b);
            }
            this.a.setImageDrawable(b);
        } else {
            this.a.setImageDrawable(null);
        }
        a();
    }

    public void a(ColorStateList colorStateList) {
        if (this.c == null) {
            this.c = new l4();
        }
        l4 l4Var = this.c;
        l4Var.a = colorStateList;
        l4Var.d = true;
        a();
    }

    public void a(PorterDuff.Mode mode) {
        if (this.c == null) {
            this.c = new l4();
        }
        l4 l4Var = this.c;
        l4Var.b = mode;
        l4Var.c = true;
        a();
    }

    public void a() {
        Drawable drawable = this.a.getDrawable();
        if (drawable != null) {
            t3.b(drawable);
        }
        if (drawable != null) {
            int i = Build.VERSION.SDK_INT;
            boolean z = true;
            if (this.b != null) {
                if (this.d == null) {
                    this.d = new l4();
                }
                l4 l4Var = this.d;
                l4Var.a();
                ImageView imageView = this.a;
                int i2 = Build.VERSION.SDK_INT;
                ColorStateList imageTintList = imageView.getImageTintList();
                if (imageTintList != null) {
                    l4Var.d = true;
                    l4Var.a = imageTintList;
                }
                ImageView imageView2 = this.a;
                int i3 = Build.VERSION.SDK_INT;
                PorterDuff.Mode imageTintMode = imageView2.getImageTintMode();
                if (imageTintMode != null) {
                    l4Var.c = true;
                    l4Var.b = imageTintMode;
                }
                if (l4Var.d || l4Var.c) {
                    w2.a(drawable, l4Var, this.a.getDrawableState());
                } else {
                    z = false;
                }
                if (z) {
                    return;
                }
            }
            l4 l4Var2 = this.c;
            if (l4Var2 != null) {
                w2.a(drawable, l4Var2, this.a.getDrawableState());
                return;
            }
            l4 l4Var3 = this.b;
            if (l4Var3 != null) {
                w2.a(drawable, l4Var3, this.a.getDrawableState());
            }
        }
    }
}
