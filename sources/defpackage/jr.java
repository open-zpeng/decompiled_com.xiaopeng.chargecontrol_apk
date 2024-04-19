package defpackage;

import android.graphics.DashPathEffect;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import java.util.ArrayList;
import java.util.List;
/* compiled from: Legend.java */
/* renamed from: jr  reason: default package */
/* loaded from: classes.dex */
public class jr extends gr {
    public kr[] h;
    public kr[] g = new kr[0];
    public boolean i = false;
    public c j = c.LEFT;
    public e k = e.BOTTOM;
    public d l = d.HORIZONTAL;
    public boolean m = false;
    public a n = a.LEFT_TO_RIGHT;
    public b o = b.SQUARE;
    public float p = 8.0f;
    public float q = 3.0f;
    public DashPathEffect r = null;
    public float s = 6.0f;
    public float t = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
    public float u = 5.0f;
    public float v = 3.0f;
    public float w = 0.95f;
    public float x = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
    public float y = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
    public boolean z = false;
    public List<st> A = new ArrayList(16);
    public List<Boolean> B = new ArrayList(16);
    public List<st> C = new ArrayList(16);

    /* compiled from: Legend.java */
    /* renamed from: jr$a */
    /* loaded from: classes.dex */
    public enum a {
        LEFT_TO_RIGHT,
        RIGHT_TO_LEFT
    }

    /* compiled from: Legend.java */
    /* renamed from: jr$b */
    /* loaded from: classes.dex */
    public enum b {
        NONE,
        EMPTY,
        DEFAULT,
        SQUARE,
        CIRCLE,
        LINE
    }

    /* compiled from: Legend.java */
    /* renamed from: jr$c */
    /* loaded from: classes.dex */
    public enum c {
        LEFT,
        CENTER,
        RIGHT
    }

    /* compiled from: Legend.java */
    /* renamed from: jr$d */
    /* loaded from: classes.dex */
    public enum d {
        HORIZONTAL,
        VERTICAL
    }

    /* compiled from: Legend.java */
    /* renamed from: jr$e */
    /* loaded from: classes.dex */
    public enum e {
        TOP,
        CENTER,
        BOTTOM
    }

    public jr() {
        this.e = zt.a(10.0f);
        this.b = zt.a(5.0f);
        this.c = zt.a(3.0f);
    }

    public void a(List<kr> list) {
        this.g = (kr[]) list.toArray(new kr[list.size()]);
    }

    public float b() {
        return this.p;
    }

    public c c() {
        return this.j;
    }

    public d d() {
        return this.l;
    }

    public kr[] a() {
        return this.h;
    }
}
