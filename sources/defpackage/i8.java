package defpackage;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
/* compiled from: WrappedDrawableState.java */
/* renamed from: i8  reason: default package */
/* loaded from: classes.dex */
public final class i8 extends Drawable.ConstantState {
    public int a;
    public Drawable.ConstantState b;
    public ColorStateList c;
    public PorterDuff.Mode d;

    public i8(i8 i8Var) {
        this.c = null;
        this.d = g8.i;
        if (i8Var != null) {
            this.a = i8Var.a;
            this.b = i8Var.b;
            this.c = i8Var.c;
            this.d = i8Var.d;
        }
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        int i = this.a;
        Drawable.ConstantState constantState = this.b;
        return i | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        return newDrawable(null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        int i = Build.VERSION.SDK_INT;
        return new h8(this, resources);
    }
}
