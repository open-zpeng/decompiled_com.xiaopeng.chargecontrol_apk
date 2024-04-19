package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: AbsSavedState.java */
/* renamed from: jb  reason: default package */
/* loaded from: classes.dex */
public abstract class jb implements Parcelable {
    public final Parcelable c;
    public static final jb d = new a();
    public static final Parcelable.Creator<jb> CREATOR = new b();

    /* compiled from: AbsSavedState.java */
    /* renamed from: jb$a */
    /* loaded from: classes.dex */
    public static class a extends jb {
        public a() {
            super((a) null);
        }
    }

    public /* synthetic */ jb(a aVar) {
        this.c = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.c, i);
    }

    /* compiled from: AbsSavedState.java */
    /* renamed from: jb$b */
    /* loaded from: classes.dex */
    public static class b implements Parcelable.ClassLoaderCreator<jb> {
        @Override // android.os.Parcelable.ClassLoaderCreator
        /* renamed from: createFromParcel  reason: avoid collision after fix types in other method */
        public jb createFromParcel2(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return jb.d;
            }
            throw new IllegalStateException("superState must be null");
        }

        @Override // android.os.Parcelable.Creator
        public Object[] newArray(int i) {
            return new jb[i];
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        public jb createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return jb.d;
            }
            throw new IllegalStateException("superState must be null");
        }

        @Override // android.os.Parcelable.Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel2(parcel, (ClassLoader) null);
        }
    }

    public jb(Parcelable parcelable) {
        if (parcelable != null) {
            this.c = parcelable == d ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    public jb(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        this.c = readParcelable == null ? d : readParcelable;
    }
}
