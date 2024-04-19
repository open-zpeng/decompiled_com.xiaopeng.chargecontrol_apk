package defpackage;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import defpackage.i;
/* compiled from: ResultReceiver.java */
@SuppressLint({"BanParcelableUsage"})
/* renamed from: j  reason: default package */
/* loaded from: classes.dex */
public class j implements Parcelable {
    public static final Parcelable.Creator<j> CREATOR = new a();
    public final Handler c = null;
    public i d;

    /* compiled from: ResultReceiver.java */
    /* renamed from: j$a */
    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator<j> {
        @Override // android.os.Parcelable.Creator
        public j createFromParcel(Parcel parcel) {
            return new j(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public j[] newArray(int i) {
            return new j[i];
        }
    }

    /* compiled from: ResultReceiver.java */
    /* renamed from: j$b */
    /* loaded from: classes.dex */
    public class b extends i.a {
        public b() {
        }
    }

    /* compiled from: ResultReceiver.java */
    /* renamed from: j$c */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        public final int c;
        public final Bundle d;

        public c(int i, Bundle bundle) {
            this.c = i;
            this.d = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.this.a(this.c, this.d);
        }
    }

    public j(Parcel parcel) {
        this.d = i.a.a(parcel.readStrongBinder());
    }

    public void a(int i, Bundle bundle) {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            if (this.d == null) {
                this.d = new b();
            }
            parcel.writeStrongBinder(this.d.asBinder());
        }
    }
}
