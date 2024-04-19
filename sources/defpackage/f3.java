package defpackage;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.RatingBar;
/* compiled from: AppCompatRatingBar.java */
/* renamed from: f3  reason: default package */
/* loaded from: classes.dex */
public class f3 extends RatingBar {
    public final d3 c;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public f3(android.content.Context r2, android.util.AttributeSet r3) {
        /*
            r1 = this;
            int r0 = defpackage.z.ratingBarStyle
            r1.<init>(r2, r3, r0)
            android.content.Context r2 = r1.getContext()
            defpackage.i4.a(r1, r2)
            d3 r2 = new d3
            r2.<init>(r1)
            r1.c = r2
            d3 r2 = r1.c
            r2.a(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.f3.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Bitmap bitmap = this.c.b;
        if (bitmap != null) {
            setMeasuredDimension(View.resolveSizeAndState(bitmap.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
        }
    }
}
