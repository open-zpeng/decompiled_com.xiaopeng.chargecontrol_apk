package defpackage;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import com.xiaopeng.xui.drawable.XToggleDrawable;
/* compiled from: LimitLine.java */
/* renamed from: lr  reason: default package */
/* loaded from: classes.dex */
public class lr extends gr {
    public float g;
    public float h = 2.0f;
    public int i = Color.rgb(237, 91, 91);
    public Paint.Style j = Paint.Style.FILL_AND_STROKE;
    public String k = "";
    public DashPathEffect l = null;
    public a m = a.RIGHT_TOP;

    /* compiled from: LimitLine.java */
    /* renamed from: lr$a */
    /* loaded from: classes.dex */
    public enum a {
        LEFT_TOP,
        LEFT_BOTTOM,
        RIGHT_TOP,
        RIGHT_BOTTOM
    }

    public lr(float f) {
        this.g = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        this.g = f;
    }
}
