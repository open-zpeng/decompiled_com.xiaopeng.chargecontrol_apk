package defpackage;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.xiaopeng.xui.drawable.XToggleDrawable;
/* compiled from: AppCompatSeekBarHelper.java */
/* renamed from: i3  reason: default package */
/* loaded from: classes.dex */
public class i3 extends d3 {
    public final SeekBar d;
    public Drawable e;
    public ColorStateList f;
    public PorterDuff.Mode g;
    public boolean h;
    public boolean i;

    public i3(SeekBar seekBar) {
        super(seekBar);
        this.f = null;
        this.g = null;
        this.h = false;
        this.i = false;
        this.d = seekBar;
    }

    @Override // defpackage.d3
    public void a(AttributeSet attributeSet, int i) {
        super.a(attributeSet, i);
        n4 a = n4.a(this.d.getContext(), attributeSet, i0.AppCompatSeekBar, i, 0);
        SeekBar seekBar = this.d;
        y9.a(seekBar, seekBar.getContext(), i0.AppCompatSeekBar, attributeSet, a.b, i, 0);
        Drawable c = a.c(i0.AppCompatSeekBar_android_thumb);
        if (c != null) {
            this.d.setThumb(c);
        }
        Drawable b = a.b(i0.AppCompatSeekBar_tickMark);
        Drawable drawable = this.e;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.e = b;
        if (b != null) {
            b.setCallback(this.d);
            a.a(b, y9.h(this.d));
            if (b.isStateful()) {
                b.setState(this.d.getDrawableState());
            }
            a();
        }
        this.d.invalidate();
        if (a.f(i0.AppCompatSeekBar_tickMarkTintMode)) {
            this.g = t3.a(a.c(i0.AppCompatSeekBar_tickMarkTintMode, -1), this.g);
            this.i = true;
        }
        if (a.f(i0.AppCompatSeekBar_tickMarkTint)) {
            this.f = a.a(i0.AppCompatSeekBar_tickMarkTint);
            this.h = true;
        }
        a.b.recycle();
        a();
    }

    public final void a() {
        if (this.e != null) {
            if (this.h || this.i) {
                Drawable mutate = this.e.mutate();
                int i = Build.VERSION.SDK_INT;
                this.e = mutate;
                if (this.h) {
                    this.e.setTintList(this.f);
                }
                if (this.i) {
                    Drawable drawable = this.e;
                    PorterDuff.Mode mode = this.g;
                    int i2 = Build.VERSION.SDK_INT;
                    drawable.setTintMode(mode);
                }
                if (this.e.isStateful()) {
                    this.e.setState(this.d.getDrawableState());
                }
            }
        }
    }

    public void a(Canvas canvas) {
        if (this.e != null) {
            int max = this.d.getMax();
            if (max > 1) {
                int intrinsicWidth = this.e.getIntrinsicWidth();
                int intrinsicHeight = this.e.getIntrinsicHeight();
                int i = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i2 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.e.setBounds(-i, -i2, i, i2);
                float width = ((this.d.getWidth() - this.d.getPaddingLeft()) - this.d.getPaddingRight()) / max;
                int save = canvas.save();
                canvas.translate(this.d.getPaddingLeft(), this.d.getHeight() / 2);
                for (int i3 = 0; i3 <= max; i3++) {
                    this.e.draw(canvas);
                    canvas.translate(width, XToggleDrawable.LIGHT_RADIUS_DEFAULT);
                }
                canvas.restoreToCount(save);
            }
        }
    }
}
