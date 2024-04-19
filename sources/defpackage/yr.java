package defpackage;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import com.xiaopeng.xui.drawable.XLoadingDrawable;
import defpackage.vr;
import java.util.List;
/* compiled from: LineRadarDataSet.java */
/* renamed from: yr  reason: default package */
/* loaded from: classes.dex */
public abstract class yr<T extends vr> extends zr<T> implements vs<T> {
    public int C;
    public Drawable D;
    public int E;
    public float F;
    public boolean G;

    public yr(List<T> list, String str) {
        super(list, str);
        this.C = Color.rgb(140, 234, (int) XLoadingDrawable.ALPHA_MAX);
        this.E = 85;
        this.F = 2.5f;
        this.G = false;
    }

    @TargetApi(18)
    public void a(Drawable drawable) {
        this.D = drawable;
    }

    public int p() {
        return this.E;
    }

    public int q() {
        return this.C;
    }

    public Drawable r() {
        return this.D;
    }
}
