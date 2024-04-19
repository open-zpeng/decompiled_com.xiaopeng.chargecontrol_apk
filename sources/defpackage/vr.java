package defpackage;

import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable;
import com.xiaopeng.xui.drawable.XToggleDrawable;
/* compiled from: Entry.java */
/* renamed from: vr  reason: default package */
/* loaded from: classes.dex */
public class vr extends sr implements Parcelable {
    public static final Parcelable.Creator<vr> CREATOR = new a();
    public float f;

    /* compiled from: Entry.java */
    /* renamed from: vr$a */
    /* loaded from: classes.dex */
    public static class a implements Parcelable.Creator<vr> {
        @Override // android.os.Parcelable.Creator
        public vr createFromParcel(Parcel parcel) {
            return new vr(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public vr[] newArray(int i) {
            return new vr[i];
        }
    }

    public vr() {
        this.f = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
    }

    public float b() {
        return this.f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder a2 = jg.a("Entry, x: ");
        a2.append(this.f);
        a2.append(" y: ");
        a2.append(a());
        return a2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.f);
        parcel.writeFloat(a());
        Object obj = this.d;
        if (obj != null) {
            if (obj instanceof Parcelable) {
                parcel.writeInt(1);
                parcel.writeParcelable((Parcelable) this.d, i);
                return;
            }
            throw new ParcelFormatException("Cannot parcel an Entry with non-parcelable data");
        }
        parcel.writeInt(0);
    }

    public vr(float f, float f2) {
        super(f2);
        this.f = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        this.f = f;
    }

    public vr(Parcel parcel) {
        this.f = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        this.f = parcel.readFloat();
        this.c = parcel.readFloat();
        if (parcel.readInt() == 1) {
            this.d = parcel.readParcelable(Object.class.getClassLoader());
        }
    }
}
