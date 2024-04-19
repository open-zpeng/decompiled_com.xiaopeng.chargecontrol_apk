package defpackage;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import defpackage.d;
import java.util.List;
/* compiled from: IMediaControllerCallback.java */
/* renamed from: b  reason: default package */
/* loaded from: classes.dex */
public interface b extends IInterface {

    /* compiled from: IMediaControllerCallback.java */
    /* renamed from: b$a */
    /* loaded from: classes.dex */
    public static abstract class a extends Binder implements b {
        public a() {
            attachInterface(this, "android.support.v4.media.session.IMediaControllerCallback");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        String readString = parcel.readString();
                        Bundle bundle = parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null;
                        d dVar = ((d.b) this).c.get();
                        if (dVar != null) {
                            dVar.a(1, readString, bundle);
                        }
                        return true;
                    case 2:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        a();
                        return true;
                    case 3:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        PlaybackStateCompat createFromParcel = parcel.readInt() != 0 ? PlaybackStateCompat.CREATOR.createFromParcel(parcel) : null;
                        d dVar2 = ((d.b) this).c.get();
                        if (dVar2 != null) {
                            dVar2.a(2, createFromParcel, null);
                        }
                        return true;
                    case 4:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        a(parcel.readInt() != 0 ? MediaMetadataCompat.CREATOR.createFromParcel(parcel) : null);
                        return true;
                    case 5:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        a(parcel.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR));
                        return true;
                    case 6:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        a(parcel.readInt() != 0 ? (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel) : null);
                        return true;
                    case 7:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        a(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                        return true;
                    case 8:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        a(parcel.readInt() != 0 ? ParcelableVolumeInfo.CREATOR.createFromParcel(parcel) : null);
                        return true;
                    case 9:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        int readInt = parcel.readInt();
                        d dVar3 = ((d.b) this).c.get();
                        if (dVar3 != null) {
                            dVar3.a(9, Integer.valueOf(readInt), null);
                        }
                        return true;
                    case 10:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        parcel.readInt();
                        d.b bVar = (d.b) this;
                        return true;
                    case 11:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        boolean z = parcel.readInt() != 0;
                        d dVar4 = ((d.b) this).c.get();
                        if (dVar4 != null) {
                            dVar4.a(11, Boolean.valueOf(z), null);
                        }
                        return true;
                    case 12:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        int readInt2 = parcel.readInt();
                        d dVar5 = ((d.b) this).c.get();
                        if (dVar5 != null) {
                            dVar5.a(12, Integer.valueOf(readInt2), null);
                        }
                        return true;
                    case 13:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        d dVar6 = ((d.b) this).c.get();
                        if (dVar6 != null) {
                            dVar6.a(13, null, null);
                        }
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("android.support.v4.media.session.IMediaControllerCallback");
            return true;
        }
    }

    void a();

    void a(Bundle bundle);

    void a(MediaMetadataCompat mediaMetadataCompat);

    void a(ParcelableVolumeInfo parcelableVolumeInfo);

    void a(CharSequence charSequence);

    void a(List<MediaSessionCompat.QueueItem> list);
}
