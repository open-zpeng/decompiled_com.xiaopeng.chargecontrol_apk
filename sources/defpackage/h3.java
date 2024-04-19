package defpackage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
/* compiled from: AppCompatSeekBar.java */
/* renamed from: h3  reason: default package */
/* loaded from: classes.dex */
public class h3 extends SeekBar {
    public final i3 c;

    public h3(Context context) {
        this(context, null);
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        i3 i3Var = this.c;
        Drawable drawable = i3Var.e;
        if (drawable != null && drawable.isStateful() && drawable.setState(i3Var.d.getDrawableState())) {
            i3Var.d.invalidateDrawable(drawable);
        }
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.c.e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.c.a(canvas);
    }

    public h3(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, z.seekBarStyle);
    }

    public h3(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        i4.a(this, getContext());
        this.c = new i3(this);
        this.c.a(attributeSet, i);
    }
}
