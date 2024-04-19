package defpackage;

import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import defpackage.j;
/* compiled from: IResultReceiver.java */
/* renamed from: i  reason: default package */
/* loaded from: classes.dex */
public interface i extends IInterface {

    /* compiled from: IResultReceiver.java */
    /* renamed from: i$a */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements i {

        /* compiled from: IResultReceiver.java */
        /* renamed from: i$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0007a implements i {
            public IBinder c;

            public C0007a(IBinder iBinder) {
                this.c = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.c;
            }
        }

        public a() {
            attachInterface(this, "android.support.v4.os.IResultReceiver");
        }

        public static i a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.os.IResultReceiver");
            if (queryLocalInterface != null && (queryLocalInterface instanceof i)) {
                return (i) queryLocalInterface;
            }
            return new C0007a(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("android.support.v4.os.IResultReceiver");
                return true;
            }
            parcel.enforceInterface("android.support.v4.os.IResultReceiver");
            int readInt = parcel.readInt();
            Bundle bundle = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
            j jVar = j.this;
            Handler handler = jVar.c;
            if (handler != null) {
                handler.post(new j.c(readInt, bundle));
            } else {
                jVar.a(readInt, bundle);
            }
            return true;
        }
    }
}
