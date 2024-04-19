package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
/* compiled from: AppCompatImageView.java */
/* renamed from: a3  reason: default package */
/* loaded from: classes.dex */
public class a3 extends ImageView implements x9, fb {
    public final r2 c;
    public final z2 d;

    public a3(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        r2 r2Var = this.c;
        if (r2Var != null) {
            r2Var.a();
        }
        z2 z2Var = this.d;
        if (z2Var != null) {
            z2Var.a();
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

    public ColorStateList getSupportImageTintList() {
        l4 l4Var;
        z2 z2Var = this.d;
        if (z2Var == null || (l4Var = z2Var.c) == null) {
            return null;
        }
        return l4Var.a;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        l4 l4Var;
        z2 z2Var = this.d;
        if (z2Var == null || (l4Var = z2Var.c) == null) {
            return null;
        }
        return l4Var.b;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        Drawable background = this.d.a.getBackground();
        int i = Build.VERSION.SDK_INT;
        return ((background instanceof RippleDrawable) ^ true) && super.hasOverlappingRendering();
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

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        z2 z2Var = this.d;
        if (z2Var != null) {
            z2Var.a();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        z2 z2Var = this.d;
        if (z2Var != null) {
            z2Var.a();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        z2 z2Var = this.d;
        if (z2Var != null) {
            z2Var.a(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        z2 z2Var = this.d;
        if (z2Var != null) {
            z2Var.a();
        }
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

    public void setSupportImageTintList(ColorStateList colorStateList) {
        z2 z2Var = this.d;
        if (z2Var != null) {
            z2Var.a(colorStateList);
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        z2 z2Var = this.d;
        if (z2Var != null) {
            z2Var.a(mode);
        }
    }

    public a3(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a3(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        k4.a(context);
        i4.a(this, getContext());
        this.c = new r2(this);
        this.c.a(attributeSet, i);
        this.d = new z2(this);
        this.d.a(attributeSet, i);
    }
}
