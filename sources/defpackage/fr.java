package defpackage;

import android.graphics.DashPathEffect;
import android.util.Log;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import java.util.ArrayList;
import java.util.List;
/* compiled from: AxisBase.java */
/* renamed from: fr  reason: default package */
/* loaded from: classes.dex */
public abstract class fr extends gr {
    public fs g;
    public int n;
    public int o;
    public List<lr> z;
    public int h = -7829368;
    public float i = 1.0f;
    public int j = -7829368;
    public float k = 1.0f;
    public float[] l = new float[0];
    public float[] m = new float[0];
    public int p = 6;
    public float q = 1.0f;
    public boolean r = false;
    public boolean s = false;
    public boolean t = true;
    public boolean u = true;
    public boolean v = true;
    public boolean w = false;
    public DashPathEffect x = null;
    public DashPathEffect y = null;
    public boolean A = false;
    public boolean B = true;
    public float C = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
    public float D = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
    public boolean E = false;
    public boolean F = false;
    public float G = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
    public float H = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
    public float I = XToggleDrawable.LIGHT_RADIUS_DEFAULT;

    public fr() {
        this.e = zt.a(10.0f);
        this.b = zt.a(5.0f);
        this.c = zt.a(5.0f);
        this.z = new ArrayList();
    }

    public int a() {
        return this.p;
    }

    public void b(int i) {
        if (i > 25) {
            i = 25;
        }
        if (i < 2) {
            i = 2;
        }
        this.p = i;
        this.s = false;
    }

    public fs c() {
        fs fsVar = this.g;
        if (fsVar == null || ((fsVar instanceof bs) && ((bs) fsVar).b != this.o)) {
            this.g = new bs(this.o);
        }
        return this.g;
    }

    public boolean d() {
        return this.w && this.n > 0;
    }

    public void e(float f) {
        this.F = true;
        this.G = f;
        this.I = Math.abs(f - this.H);
    }

    public void f(float f) {
        this.E = true;
        this.H = f;
        this.I = Math.abs(this.G - f);
    }

    public void a(lr lrVar) {
        this.z.add(lrVar);
        if (this.z.size() > 6) {
            Log.e("MPAndroiChart", "Warning! You have more than 6 LimitLines on your axis, do you really want that?");
        }
    }

    public void d(float f) {
        this.k = zt.a(f);
    }

    public String b() {
        String str = "";
        for (int i = 0; i < this.l.length; i++) {
            String a = a(i);
            if (a != null && str.length() < a.length()) {
                str = a;
            }
        }
        return str;
    }

    public String a(int i) {
        return (i < 0 || i >= this.l.length) ? "" : c().a(this.l[i], this);
    }

    public void a(fs fsVar) {
        if (fsVar == null) {
            this.g = new bs(this.o);
        } else {
            this.g = fsVar;
        }
    }

    public void a(float f, float f2) {
        float f3 = this.E ? this.H : f - this.C;
        float f4 = this.F ? this.G : f2 + this.D;
        if (Math.abs(f4 - f3) == XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
            f4 += 1.0f;
            f3 -= 1.0f;
        }
        this.H = f3;
        this.G = f4;
        this.I = Math.abs(f4 - f3);
    }
}
