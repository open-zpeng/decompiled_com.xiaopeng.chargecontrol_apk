package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
/* compiled from: LineRadarRenderer.java */
/* renamed from: lt  reason: default package */
/* loaded from: classes.dex */
public abstract class lt extends mt {
    public lt(xq xqVar, au auVar) {
        super(xqVar, auVar);
    }

    public void a(Canvas canvas, Path path, int i, int i2) {
        int i3 = (i & 16777215) | (i2 << 24);
        if (zt.a() >= 18) {
            int save = canvas.save();
            canvas.clipPath(path);
            canvas.drawColor(i3);
            canvas.restoreToCount(save);
            return;
        }
        Paint.Style style = this.c.getStyle();
        int color = this.c.getColor();
        this.c.setStyle(Paint.Style.FILL);
        this.c.setColor(i3);
        canvas.drawPath(path, this.c);
        this.c.setColor(color);
        this.c.setStyle(style);
    }

    public void a(Canvas canvas, Path path, Drawable drawable) {
        if (zt.a() >= 18) {
            int save = canvas.save();
            canvas.clipPath(path);
            RectF rectF = this.a.b;
            drawable.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
            drawable.draw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        StringBuilder a = jg.a("Fill-drawables not (yet) supported below API level 18, this code was run on API level ");
        a.append(Build.VERSION.SDK_INT);
        a.append(".");
        throw new RuntimeException(a.toString());
    }
}
