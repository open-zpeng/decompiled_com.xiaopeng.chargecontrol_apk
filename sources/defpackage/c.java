package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
/* compiled from: IMediaSession.java */
/* renamed from: c  reason: default package */
/* loaded from: classes.dex */
public interface c extends IInterface {

    /* compiled from: IMediaSession.java */
    /* renamed from: c$a */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements c {

        /* compiled from: IMediaSession.java */
        /* renamed from: c$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0003a implements c {
            public IBinder c;

            public C0003a(IBinder iBinder) {
                this.c = iBinder;
            }

            public void a(b bVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    obtain.writeStrongBinder(bVar != null ? bVar.asBinder() : null);
                    this.c.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.c;
            }
        }

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.media.session.IMediaSession");
            if (queryLocalInterface != null && (queryLocalInterface instanceof c)) {
                return (c) queryLocalInterface;
            }
            return new C0003a(iBinder);
        }
    }
}
