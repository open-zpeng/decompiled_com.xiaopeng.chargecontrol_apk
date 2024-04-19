package defpackage;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
/* compiled from: DrawableResource.java */
/* renamed from: mn  reason: default package */
/* loaded from: classes.dex */
public abstract class mn<T extends Drawable> implements vj<T>, rj {
    public final T c;

    public mn(T t) {
        a.a(t, "Argument must not be null");
        this.c = t;
    }

    @Override // defpackage.vj
    public Object a() {
        Drawable.ConstantState constantState = this.c.getConstantState();
        if (constantState == null) {
            return this.c;
        }
        return constantState.newDrawable();
    }

    @Override // defpackage.rj
    public void e() {
        T t = this.c;
        if (t instanceof BitmapDrawable) {
            ((BitmapDrawable) t).getBitmap().prepareToDraw();
        } else if (t instanceof un) {
            ((un) t).b().prepareToDraw();
        }
    }
}
