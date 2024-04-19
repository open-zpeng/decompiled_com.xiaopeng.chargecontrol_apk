package defpackage;

import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IRadioController;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import defpackage.wt;
/* compiled from: FSize.java */
/* renamed from: st  reason: default package */
/* loaded from: classes.dex */
public final class st extends wt.a {
    public static wt<st> d = wt.a(IRadioController.TEF663x_PCHANNEL, new st(XToggleDrawable.LIGHT_RADIUS_DEFAULT, XToggleDrawable.LIGHT_RADIUS_DEFAULT));
    public float b;
    public float c;

    static {
        d.a(0.5f);
    }

    public st() {
    }

    @Override // defpackage.wt.a
    public wt.a a() {
        return new st(XToggleDrawable.LIGHT_RADIUS_DEFAULT, XToggleDrawable.LIGHT_RADIUS_DEFAULT);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof st) {
            st stVar = (st) obj;
            return this.b == stVar.b && this.c == stVar.c;
        }
        return false;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.b) ^ Float.floatToIntBits(this.c);
    }

    public String toString() {
        return this.b + "x" + this.c;
    }

    public st(float f, float f2) {
        this.b = f;
        this.c = f2;
    }

    public static st a(float f, float f2) {
        st a = d.a();
        a.b = f;
        a.c = f2;
        return a;
    }
}
