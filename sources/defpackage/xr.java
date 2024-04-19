package defpackage;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.util.Log;
import com.xiaopeng.xui.drawable.XLoadingDrawable;
import java.util.ArrayList;
import java.util.List;
/* compiled from: LineDataSet.java */
/* renamed from: xr  reason: default package */
/* loaded from: classes.dex */
public class xr extends yr<vr> implements us {
    public a H;
    public List<Integer> I;
    public int J;
    public float K;
    public float L;
    public float M;
    public DashPathEffect N;
    public es O;
    public boolean P;
    public boolean Q;

    /* compiled from: LineDataSet.java */
    /* renamed from: xr$a */
    /* loaded from: classes.dex */
    public enum a {
        LINEAR,
        STEPPED,
        CUBIC_BEZIER,
        HORIZONTAL_BEZIER
    }

    public xr(List<vr> list, String str) {
        super(list, str);
        this.H = a.LINEAR;
        this.I = null;
        this.J = -1;
        this.K = 8.0f;
        this.L = 4.0f;
        this.M = 0.2f;
        this.N = null;
        this.O = new cs();
        this.P = true;
        this.Q = true;
        if (this.I == null) {
            this.I = new ArrayList();
        }
        this.I.clear();
        this.I.add(Integer.valueOf(Color.rgb(140, 234, (int) XLoadingDrawable.ALPHA_MAX)));
    }

    public void a(es esVar) {
        if (esVar == null) {
            this.O = new cs();
        } else {
            this.O = esVar;
        }
    }

    public void c(float f) {
        if (f >= 0.5f) {
            this.L = zt.a(f);
        } else {
            Log.e("LineDataSet", "Circle radius cannot be < 0.5");
        }
    }

    public void d(float f) {
        if (f >= 1.0f) {
            this.K = zt.a(f);
        } else {
            Log.e("LineDataSet", "Circle radius cannot be < 1");
        }
    }

    public int s() {
        return this.I.size();
    }

    public int t() {
        return this.J;
    }

    public float u() {
        return this.L;
    }

    public es v() {
        return this.O;
    }

    public boolean w() {
        return this.P;
    }
}
