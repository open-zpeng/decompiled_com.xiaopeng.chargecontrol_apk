package defpackage;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import com.xiaopeng.xui.drawable.XLoadingDrawable;
import defpackage.vr;
import java.util.List;
/* JADX WARN: Incorrect class signature, class is equals to this class: <T:Lvr;>Lzr<TT;>;Lws<TT;>; */
/* compiled from: LineScatterCandleRadarDataSet.java */
/* renamed from: zr  reason: default package */
/* loaded from: classes.dex */
public abstract class zr<T extends vr> extends ur implements ws<T>, rs {
    public float A;
    public DashPathEffect B;
    public int x;
    public boolean y;
    public boolean z;

    public zr(List<T> list, String str) {
        super(list, str);
        this.x = Color.rgb((int) XLoadingDrawable.ALPHA_MAX, 187, 115);
        this.y = true;
        this.z = true;
        this.A = 0.5f;
        this.B = null;
        this.A = zt.a(0.5f);
    }

    public int o() {
        return this.x;
    }
}
