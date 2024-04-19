package defpackage;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import defpackage.bg;
import defpackage.yn;
import java.nio.ByteBuffer;
import java.util.List;
/* compiled from: GifDrawable.java */
/* renamed from: un  reason: default package */
/* loaded from: classes.dex */
public class un extends Drawable implements yn.b, Animatable, bg {
    public final a c;
    public boolean d;
    public boolean e;
    public boolean f;
    public int h;
    public boolean j;
    public Paint k;
    public Rect l;
    public List<bg.a> m;
    public boolean g = true;
    public int i = -1;

    /* compiled from: GifDrawable.java */
    /* renamed from: un$a */
    /* loaded from: classes.dex */
    public static final class a extends Drawable.ConstantState {
        public final yn a;

        public a(yn ynVar) {
            this.a = ynVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new un(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new un(this);
        }
    }

    public un(a aVar) {
        defpackage.a.a(aVar, "Argument must not be null");
        this.c = aVar;
    }

    public ByteBuffer a() {
        return this.c.a.a.getData().asReadOnlyBuffer();
    }

    public Bitmap b() {
        return this.c.a.m;
    }

    public final Paint c() {
        if (this.k == null) {
            this.k = new Paint(2);
        }
        return this.k;
    }

    public final void d() {
        defpackage.a.a(!this.f, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.c.a.a.d() == 1) {
            invalidateSelf();
        } else if (this.d) {
        } else {
            this.d = true;
            yn ynVar = this.c.a;
            if (!ynVar.k) {
                if (!ynVar.c.contains(this)) {
                    boolean isEmpty = ynVar.c.isEmpty();
                    ynVar.c.add(this);
                    if (isEmpty && !ynVar.f) {
                        ynVar.f = true;
                        ynVar.k = false;
                        ynVar.a();
                    }
                    invalidateSelf();
                    return;
                }
                throw new IllegalStateException("Cannot subscribe twice in a row");
            }
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap;
        if (this.f) {
            return;
        }
        if (this.j) {
            int intrinsicWidth = getIntrinsicWidth();
            int intrinsicHeight = getIntrinsicHeight();
            Rect bounds = getBounds();
            if (this.l == null) {
                this.l = new Rect();
            }
            Gravity.apply(119, intrinsicWidth, intrinsicHeight, bounds, this.l);
            this.j = false;
        }
        yn ynVar = this.c.a;
        yn.a aVar = ynVar.j;
        if (aVar != null) {
            bitmap = aVar.i;
        } else {
            bitmap = ynVar.m;
        }
        if (this.l == null) {
            this.l = new Rect();
        }
        canvas.drawBitmap(bitmap, (Rect) null, this.l, c());
    }

    public final void e() {
        this.d = false;
        yn ynVar = this.c.a;
        ynVar.c.remove(this);
        if (ynVar.c.isEmpty()) {
            ynVar.c();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.c.a.q;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.c.a.p;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.d;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.j = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        c().setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        c().setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        defpackage.a.a(!this.f, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.g = z;
        if (!z) {
            e();
        } else if (this.e) {
            d();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.e = true;
        this.h = 0;
        if (this.g) {
            d();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.e = false;
        e();
    }
}
