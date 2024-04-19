package defpackage;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import defpackage.oc;
import java.util.ArrayList;
/* compiled from: FragmentManagerState.java */
@SuppressLint({"BanParcelableUsage"})
/* renamed from: qc  reason: default package */
/* loaded from: classes.dex */
public final class qc implements Parcelable {
    public static final Parcelable.Creator<qc> CREATOR = new a();
    public ArrayList<uc> c;
    public ArrayList<String> d;
    public pb[] e;
    public int f;
    public String g;
    public ArrayList<String> h;
    public ArrayList<Bundle> i;
    public ArrayList<oc.m> j;

    /* compiled from: FragmentManagerState.java */
    /* renamed from: qc$a */
    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator<qc> {
        @Override // android.os.Parcelable.Creator
        public qc createFromParcel(Parcel parcel) {
            return new qc(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public qc[] newArray(int i) {
            return new qc[i];
        }
    }

    public qc() {
        this.g = null;
        this.h = new ArrayList<>();
        this.i = new ArrayList<>();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.c);
        parcel.writeStringList(this.d);
        parcel.writeTypedArray(this.e, i);
        parcel.writeInt(this.f);
        parcel.writeString(this.g);
        parcel.writeStringList(this.h);
        parcel.writeTypedList(this.i);
        parcel.writeTypedList(this.j);
    }

    public qc(Parcel parcel) {
        this.g = null;
        this.h = new ArrayList<>();
        this.i = new ArrayList<>();
        this.c = parcel.createTypedArrayList(uc.CREATOR);
        this.d = parcel.createStringArrayList();
        this.e = (pb[]) parcel.createTypedArray(pb.CREATOR);
        this.f = parcel.readInt();
        this.g = parcel.readString();
        this.h = parcel.createStringArrayList();
        this.i = parcel.createTypedArrayList(Bundle.CREATOR);
        this.j = parcel.createTypedArrayList(oc.m.CREATOR);
    }
}
