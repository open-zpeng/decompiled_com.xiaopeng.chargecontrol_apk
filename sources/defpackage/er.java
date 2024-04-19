package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.AttributeSet;
import java.lang.ref.WeakReference;
/* compiled from: LineChart.java */
/* renamed from: er  reason: default package */
/* loaded from: classes.dex */
public class er extends br<wr> implements ps {
    public er(Context context) {
        super(context);
    }

    @Override // defpackage.br, defpackage.cr
    public void g() {
        super.g();
        this.r = new kt(this, this.u, this.t);
    }

    @Override // defpackage.ps
    public wr getLineData() {
        return (wr) this.d;
    }

    @Override // defpackage.cr, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        ht htVar = this.r;
        if (htVar != null && (htVar instanceof kt)) {
            kt ktVar = (kt) htVar;
            Canvas canvas = ktVar.k;
            if (canvas != null) {
                canvas.setBitmap(null);
                ktVar.k = null;
            }
            WeakReference<Bitmap> weakReference = ktVar.j;
            if (weakReference != null) {
                Bitmap bitmap = weakReference.get();
                if (bitmap != null) {
                    bitmap.recycle();
                }
                ktVar.j.clear();
                ktVar.j = null;
            }
        }
        super.onDetachedFromWindow();
    }

    public er(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public er(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
