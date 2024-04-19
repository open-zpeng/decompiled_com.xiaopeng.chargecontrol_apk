package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import defpackage.wt;
/* compiled from: MPPointF.java */
/* renamed from: vt  reason: default package */
/* loaded from: classes.dex */
public class vt extends wt.a {
    public static wt<vt> d = wt.a(32, new vt(XToggleDrawable.LIGHT_RADIUS_DEFAULT, XToggleDrawable.LIGHT_RADIUS_DEFAULT));
    public float b;
    public float c;

    /* compiled from: MPPointF.java */
    /* renamed from: vt$a */
    /* loaded from: classes.dex */
    public static class a implements Parcelable.Creator<vt> {
        @Override // android.os.Parcelable.Creator
        public vt createFromParcel(Parcel parcel) {
            vt vtVar = new vt(XToggleDrawable.LIGHT_RADIUS_DEFAULT, XToggleDrawable.LIGHT_RADIUS_DEFAULT);
            vtVar.b = parcel.readFloat();
            vtVar.c = parcel.readFloat();
            return vtVar;
        }

        @Override // android.os.Parcelable.Creator
        public vt[] newArray(int i) {
            return new vt[i];
        }
    }

    static {
        d.a(0.5f);
    }

    public vt() {
    }

    public static vt a(float f, float f2) {
        vt a2 = d.a();
        a2.b = f;
        a2.c = f2;
        return a2;
    }

    public vt(float f, float f2) {
        this.b = f;
        this.c = f2;
    }

    public static vt a(vt vtVar) {
        vt a2 = d.a();
        a2.b = vtVar.b;
        a2.c = vtVar.c;
        return a2;
    }

    @Override // defpackage.wt.a
    public wt.a a() {
        return new vt(XToggleDrawable.LIGHT_RADIUS_DEFAULT, XToggleDrawable.LIGHT_RADIUS_DEFAULT);
    }
}
