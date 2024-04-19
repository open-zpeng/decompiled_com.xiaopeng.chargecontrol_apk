package defpackage;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import defpackage.fq;
/* compiled from: ImageViewTarget.java */
/* renamed from: zp  reason: default package */
/* loaded from: classes.dex */
public abstract class zp<Z> extends dq<ImageView, Z> implements fq.a {
    public Animatable i;

    public zp(ImageView imageView) {
        super(imageView);
    }

    @Override // defpackage.up, defpackage.cq
    public void a(Drawable drawable) {
        super.a(drawable);
        b((zp<Z>) null);
        a((zp<Z>) null);
        ((ImageView) this.c).setImageDrawable(drawable);
    }

    @Override // defpackage.dq, defpackage.up, defpackage.cq
    public void b(Drawable drawable) {
        super.b(drawable);
        b((zp<Z>) null);
        a((zp<Z>) null);
        ((ImageView) this.c).setImageDrawable(drawable);
    }

    public abstract void b(Z z);

    @Override // defpackage.dq, defpackage.up, defpackage.cq
    public void c(Drawable drawable) {
        super.c(drawable);
        Animatable animatable = this.i;
        if (animatable != null) {
            animatable.stop();
        }
        b((zp<Z>) null);
        a((zp<Z>) null);
        ((ImageView) this.c).setImageDrawable(drawable);
    }

    @Override // defpackage.ro
    public void onStart() {
        Animatable animatable = this.i;
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override // defpackage.cq
    public void a(Z z, fq<? super Z> fqVar) {
        if (fqVar != null) {
            eq eqVar = (eq) fqVar;
        }
        b((zp<Z>) z);
        if (z instanceof Animatable) {
            this.i = (Animatable) z;
            this.i.start();
            return;
        }
        this.i = null;
    }

    @Override // defpackage.ro
    public void a() {
        Animatable animatable = this.i;
        if (animatable != null) {
            animatable.stop();
        }
    }

    public final void a(Z z) {
        if (z instanceof Animatable) {
            this.i = (Animatable) z;
            this.i.start();
            return;
        }
        this.i = null;
    }
}
