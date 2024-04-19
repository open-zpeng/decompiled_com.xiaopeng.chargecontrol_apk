package defpackage;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: ActivityResult.java */
@SuppressLint({"BanParcelableUsage"})
/* renamed from: q  reason: default package */
/* loaded from: classes.dex */
public final class q implements Parcelable {
    public static final Parcelable.Creator<q> CREATOR = new a();
    public final int c;
    public final Intent d;

    /* compiled from: ActivityResult.java */
    /* renamed from: q$a */
    /* loaded from: classes.dex */
    public class a implements Parcelable.Creator<q> {
        @Override // android.os.Parcelable.Creator
        public q createFromParcel(Parcel parcel) {
            return new q(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public q[] newArray(int i) {
            return new q[i];
        }
    }

    public q(int i, Intent intent) {
        this.c = i;
        this.d = intent;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        String str;
        StringBuilder a2 = jg.a("ActivityResult{resultCode=");
        int i = this.c;
        if (i != -1) {
            str = i != 0 ? String.valueOf(i) : "RESULT_CANCELED";
        } else {
            str = "RESULT_OK";
        }
        a2.append(str);
        a2.append(", data=");
        a2.append(this.d);
        a2.append('}');
        return a2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.c);
        parcel.writeInt(this.d == null ? 0 : 1);
        Intent intent = this.d;
        if (intent != null) {
            intent.writeToParcel(parcel, i);
        }
    }

    public q(Parcel parcel) {
        this.c = parcel.readInt();
        this.d = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }
}
