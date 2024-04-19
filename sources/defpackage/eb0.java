package defpackage;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import java.util.List;
/* compiled from: IDataUploadInterface.java */
/* renamed from: eb0  reason: default package */
/* loaded from: classes.dex */
public interface eb0 extends IInterface {

    /* compiled from: IDataUploadInterface.java */
    /* renamed from: eb0$a */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements eb0 {
        public static eb0 a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.xiaopeng.lib.bughunter.IDataUploadInterface");
            if (queryLocalInterface != null && (queryLocalInterface instanceof eb0)) {
                return (eb0) queryLocalInterface;
            }
            return new C0005a(iBinder);
        }

        /* compiled from: IDataUploadInterface.java */
        /* renamed from: eb0$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0005a implements eb0 {
            public IBinder c;

            public C0005a(IBinder iBinder) {
                this.c = iBinder;
            }

            public void a(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                    obtain.writeString(str);
                    this.c.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.c;
            }

            public void b(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                    obtain.writeString(str);
                    this.c.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void c(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                    obtain.writeString(str);
                    this.c.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.c.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void b(String str, String str2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.c.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void a(List<String> list) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.xiaopeng.lib.bughunter.IDataUploadInterface");
                    obtain.writeStringList(list);
                    this.c.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }
    }
}
