package defpackage;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.Fragment;
import defpackage.vd;
import defpackage.xc;
import java.util.ArrayList;
/* compiled from: BackStackState.java */
@SuppressLint({"BanParcelableUsage"})
/* renamed from: pb  reason: default package */
/* loaded from: classes.dex */
public final class pb implements Parcelable {
    public static final Parcelable.Creator<pb> CREATOR = new a();
    public final int[] c;
    public final ArrayList<String> d;
    public final int[] e;
    public final int[] f;
    public final int g;
    public final String h;
    public final int i;
    public final int j;
    public final CharSequence k;
    public final int l;
    public final CharSequence m;
    public final ArrayList<String> n;
    public final ArrayList<String> o;
    public final boolean p;

    /* compiled from: BackStackState.java */
    /* renamed from: pb$a */
    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator<pb> {
        @Override // android.os.Parcelable.Creator
        public pb createFromParcel(Parcel parcel) {
            return new pb(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public pb[] newArray(int i) {
            return new pb[i];
        }
    }

    public pb(ob obVar) {
        int size = obVar.a.size();
        this.c = new int[size * 5];
        if (obVar.g) {
            this.d = new ArrayList<>(size);
            this.e = new int[size];
            this.f = new int[size];
            int i = 0;
            int i2 = 0;
            while (i < size) {
                xc.a aVar = obVar.a.get(i);
                int i3 = i2 + 1;
                this.c[i2] = aVar.a;
                ArrayList<String> arrayList = this.d;
                Fragment fragment = aVar.b;
                arrayList.add(fragment != null ? fragment.h : null);
                int[] iArr = this.c;
                int i4 = i3 + 1;
                iArr[i3] = aVar.c;
                int i5 = i4 + 1;
                iArr[i4] = aVar.d;
                int i6 = i5 + 1;
                iArr[i5] = aVar.e;
                iArr[i6] = aVar.f;
                this.e[i] = aVar.g.ordinal();
                this.f[i] = aVar.h.ordinal();
                i++;
                i2 = i6 + 1;
            }
            this.g = obVar.f;
            this.h = obVar.h;
            this.i = obVar.s;
            this.j = obVar.i;
            this.k = obVar.j;
            this.l = obVar.k;
            this.m = obVar.l;
            this.n = obVar.m;
            this.o = obVar.n;
            this.p = obVar.o;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public ob a(oc ocVar) {
        ob obVar = new ob(ocVar);
        int i = 0;
        int i2 = 0;
        while (i < this.c.length) {
            xc.a aVar = new xc.a();
            int i3 = i + 1;
            aVar.a = this.c[i];
            if (oc.c(2)) {
                Log.v("FragmentManager", "Instantiate " + obVar + " op #" + i2 + " base fragment #" + this.c[i3]);
            }
            String str = this.d.get(i2);
            if (str != null) {
                aVar.b = ocVar.c.b(str);
            } else {
                aVar.b = null;
            }
            aVar.g = vd.b.values()[this.e[i2]];
            aVar.h = vd.b.values()[this.f[i2]];
            int[] iArr = this.c;
            int i4 = i3 + 1;
            aVar.c = iArr[i3];
            int i5 = i4 + 1;
            aVar.d = iArr[i4];
            int i6 = i5 + 1;
            aVar.e = iArr[i5];
            aVar.f = iArr[i6];
            obVar.b = aVar.c;
            obVar.c = aVar.d;
            obVar.d = aVar.e;
            obVar.e = aVar.f;
            obVar.a(aVar);
            i2++;
            i = i6 + 1;
        }
        obVar.f = this.g;
        obVar.h = this.h;
        obVar.s = this.i;
        obVar.g = true;
        obVar.i = this.j;
        obVar.j = this.k;
        obVar.k = this.l;
        obVar.l = this.m;
        obVar.m = this.n;
        obVar.n = this.o;
        obVar.o = this.p;
        obVar.a(1);
        return obVar;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.c);
        parcel.writeStringList(this.d);
        parcel.writeIntArray(this.e);
        parcel.writeIntArray(this.f);
        parcel.writeInt(this.g);
        parcel.writeString(this.h);
        parcel.writeInt(this.i);
        parcel.writeInt(this.j);
        TextUtils.writeToParcel(this.k, parcel, 0);
        parcel.writeInt(this.l);
        TextUtils.writeToParcel(this.m, parcel, 0);
        parcel.writeStringList(this.n);
        parcel.writeStringList(this.o);
        parcel.writeInt(this.p ? 1 : 0);
    }

    public pb(Parcel parcel) {
        this.c = parcel.createIntArray();
        this.d = parcel.createStringArrayList();
        this.e = parcel.createIntArray();
        this.f = parcel.createIntArray();
        this.g = parcel.readInt();
        this.h = parcel.readString();
        this.i = parcel.readInt();
        this.j = parcel.readInt();
        this.k = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.l = parcel.readInt();
        this.m = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.n = parcel.createStringArrayList();
        this.o = parcel.createStringArrayList();
        this.p = parcel.readInt() != 0;
    }
}
