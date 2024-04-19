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
import defpackage.th;
import java.util.List;
/* compiled from: WebpDrawable.java */
/* renamed from: ph  reason: default package */
/* loaded from: classes.dex */
public class ph extends Drawable implements th.b, Animatable, bg {
    public final a c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public int h;
    public int i;
    public boolean j;
    public Paint k;
    public Rect l;
    public List<bg.a> m;

    /* compiled from: WebpDrawable.java */
    /* renamed from: ph$a */
    /* loaded from: classes.dex */
    public static class a extends Drawable.ConstantState {
        public final th a;

        public a(ek ekVar, th thVar) {
            this.a = thVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new ph(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new ph(this);
        }
    }

    public ph(a aVar) {
        this.g = true;
        this.i = -1;
        this.g = true;
        this.i = -1;
        defpackage.a.a(aVar, "Argument must not be null");
        this.c = aVar;
    }

    public final Paint a() {
        if (this.k == null) {
            this.k = new Paint(2);
        }
        return this.k;
    }

    public final void b() {
        defpackage.a.a(!this.f, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.c.a.a.d() == 1) {
            invalidateSelf();
        } else if (this.d) {
        } else {
            this.d = true;
            th thVar = this.c.a;
            if (!thVar.k) {
                if (!thVar.c.contains(this)) {
                    boolean isEmpty = thVar.c.isEmpty();
                    thVar.c.add(this);
                    if (isEmpty && !thVar.f) {
                        thVar.f = true;
                        thVar.k = false;
                        thVar.a();
                    }
                    invalidateSelf();
                    return;
                }
                throw new IllegalStateException("Cannot subscribe twice in a row");
            }
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
    }

    public final void c() {
        this.d = false;
        th thVar = this.c.a;
        thVar.c.remove(this);
        if (thVar.c.isEmpty()) {
            thVar.c();
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
        th thVar = this.c.a;
        th.a aVar = thVar.j;
        if (aVar != null) {
            bitmap = aVar.i;
        } else {
            bitmap = thVar.m;
        }
        if (this.l == null) {
            this.l = new Rect();
        }
        canvas.drawBitmap(bitmap, (Rect) null, this.l, a());
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
    @Deprecated
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
        a().setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        a().setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        defpackage.a.a(!this.f, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.g = z;
        if (!z) {
            c();
        } else if (this.e) {
            b();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.e = true;
        this.h = 0;
        if (this.g) {
            b();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.e = false;
        c();
    }
}
