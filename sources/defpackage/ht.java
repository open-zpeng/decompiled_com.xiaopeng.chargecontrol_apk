package defpackage;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import com.xiaopeng.xui.drawable.XLoadingDrawable;
/* compiled from: DataRenderer.java */
/* renamed from: ht  reason: default package */
/* loaded from: classes.dex */
public abstract class ht extends nt {
    public xq b;
    public Paint c;
    public Paint d;
    public Paint e;

    public ht(xq xqVar, au auVar) {
        super(auVar);
        this.b = xqVar;
        this.c = new Paint(1);
        this.c.setStyle(Paint.Style.FILL);
        new Paint(4);
        this.e = new Paint(1);
        this.e.setColor(Color.rgb(63, 63, 63));
        this.e.setTextAlign(Paint.Align.CENTER);
        this.e.setTextSize(zt.a(9.0f));
        this.d = new Paint(1);
        this.d.setStyle(Paint.Style.STROKE);
        this.d.setStrokeWidth(2.0f);
        this.d.setColor(Color.rgb((int) XLoadingDrawable.ALPHA_MAX, 187, 115));
    }

    public abstract void a();

    public abstract void a(Canvas canvas);

    public abstract void a(Canvas canvas, is[] isVarArr);

    public boolean a(os osVar) {
        return ((float) osVar.getData().b()) < this.a.i * ((float) osVar.getMaxVisibleCount());
    }

    public abstract void b(Canvas canvas);

    public abstract void c(Canvas canvas);

    public void a(ts tsVar) {
        this.e.setTypeface(((rr) tsVar).i);
        this.e.setTextSize(((rr) tsVar).q);
    }
}
