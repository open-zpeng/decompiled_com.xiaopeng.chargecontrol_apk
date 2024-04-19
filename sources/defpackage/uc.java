package defpackage;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
/* compiled from: FragmentState.java */
@SuppressLint({"BanParcelableUsage"})
/* renamed from: uc  reason: default package */
/* loaded from: classes.dex */
public final class uc implements Parcelable {
    public static final Parcelable.Creator<uc> CREATOR = new a();
    public final String c;
    public final String d;
    public final boolean e;
    public final int f;
    public final int g;
    public final String h;
    public final boolean i;
    public final boolean j;
    public final boolean k;
    public final Bundle l;
    public final boolean m;
    public final int n;
    public Bundle o;

    /* compiled from: FragmentState.java */
    /* renamed from: uc$a */
    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator<uc> {
        @Override // android.os.Parcelable.Creator
        public uc createFromParcel(Parcel parcel) {
            return new uc(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public uc[] newArray(int i) {
            return new uc[i];
        }
    }

    public uc(Fragment fragment) {
        this.c = fragment.getClass().getName();
        this.d = fragment.h;
        this.e = fragment.p;
        this.f = fragment.y;
        this.g = fragment.z;
        this.h = fragment.A;
        this.i = fragment.D;
        this.j = fragment.o;
        this.k = fragment.C;
        this.l = fragment.i;
        this.m = fragment.B;
        this.n = fragment.S.ordinal();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.c);
        sb.append(" (");
        sb.append(this.d);
        sb.append(")}:");
        if (this.e) {
            sb.append(" fromLayout");
        }
        if (this.g != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.g));
        }
        String str = this.h;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.h);
        }
        if (this.i) {
            sb.append(" retainInstance");
        }
        if (this.j) {
            sb.append(" removing");
        }
        if (this.k) {
            sb.append(" detached");
        }
        if (this.m) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        parcel.writeInt(this.e ? 1 : 0);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
        parcel.writeString(this.h);
        parcel.writeInt(this.i ? 1 : 0);
        parcel.writeInt(this.j ? 1 : 0);
        parcel.writeInt(this.k ? 1 : 0);
        parcel.writeBundle(this.l);
        parcel.writeInt(this.m ? 1 : 0);
        parcel.writeBundle(this.o);
        parcel.writeInt(this.n);
    }

    public uc(Parcel parcel) {
        this.c = parcel.readString();
        this.d = parcel.readString();
        this.e = parcel.readInt() != 0;
        this.f = parcel.readInt();
        this.g = parcel.readInt();
        this.h = parcel.readString();
        this.i = parcel.readInt() != 0;
        this.j = parcel.readInt() != 0;
        this.k = parcel.readInt() != 0;
        this.l = parcel.readBundle();
        this.m = parcel.readInt() != 0;
        this.o = parcel.readBundle();
        this.n = parcel.readInt();
    }
}
