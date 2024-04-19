package defpackage;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import defpackage.jr;
import java.util.ArrayList;
import java.util.List;
/* compiled from: LegendRenderer.java */
/* renamed from: jt  reason: default package */
/* loaded from: classes.dex */
public class jt extends nt {
    public Paint b;
    public Paint c;
    public jr d;
    public List<kr> e;
    public Paint.FontMetrics f;
    public Path g;

    public jt(au auVar, jr jrVar) {
        super(auVar);
        this.e = new ArrayList(16);
        this.f = new Paint.FontMetrics();
        this.g = new Path();
        this.d = jrVar;
        this.b = new Paint(1);
        this.b.setTextSize(zt.a(9.0f));
        this.b.setTextAlign(Paint.Align.LEFT);
        this.c = new Paint(1);
        this.c.setStyle(Paint.Style.FILL);
    }

    public void a(Canvas canvas, float f, float f2, kr krVar, jr jrVar) {
        float f3;
        float f4;
        int i = krVar.f;
        if (i == 1122868 || i == 1122867 || i == 0) {
            return;
        }
        int save = canvas.save();
        jr.b bVar = krVar.b;
        if (bVar == jr.b.DEFAULT) {
            bVar = jrVar.o;
        }
        this.c.setColor(krVar.f);
        if (Float.isNaN(krVar.c)) {
            f3 = jrVar.p;
        } else {
            f3 = krVar.c;
        }
        float a = zt.a(f3);
        float f5 = a / 2.0f;
        int ordinal = bVar.ordinal();
        if (ordinal != 0 && ordinal != 1) {
            if (ordinal != 2) {
                if (ordinal == 3) {
                    this.c.setStyle(Paint.Style.FILL);
                    canvas.drawRect(f, f2 - f5, f + a, f2 + f5, this.c);
                } else if (ordinal != 4) {
                    if (ordinal == 5) {
                        if (Float.isNaN(krVar.d)) {
                            f4 = jrVar.q;
                        } else {
                            f4 = krVar.d;
                        }
                        float a2 = zt.a(f4);
                        DashPathEffect dashPathEffect = krVar.e;
                        if (dashPathEffect == null) {
                            dashPathEffect = jrVar.r;
                        }
                        this.c.setStyle(Paint.Style.STROKE);
                        this.c.setStrokeWidth(a2);
                        this.c.setPathEffect(dashPathEffect);
                        this.g.reset();
                        this.g.moveTo(f, f2);
                        this.g.lineTo(f + a, f2);
                        canvas.drawPath(this.g, this.c);
                    }
                }
            }
            this.c.setStyle(Paint.Style.FILL);
            canvas.drawCircle(f + f5, f2, f5, this.c);
        }
        canvas.restoreToCount(save);
    }
}
