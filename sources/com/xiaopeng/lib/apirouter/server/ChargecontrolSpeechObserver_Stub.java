package com.xiaopeng.lib.apirouter.server;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.xiaopeng.chargecontrol.ChargecontrolSpeechObserver;
/* loaded from: classes.dex */
public class ChargecontrolSpeechObserver_Stub extends Binder implements IInterface {
    public ChargecontrolSpeechObserver provider = new ChargecontrolSpeechObserver();
    public ChargecontrolSpeechObserver_Manifest manifest = new ChargecontrolSpeechObserver_Manifest();

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 0) {
            parcel.enforceInterface(ChargecontrolSpeechObserver_Manifest.DESCRIPTOR);
            Uri uri = (Uri) Uri.CREATOR.createFromParcel(parcel);
            try {
                this.provider.onEvent((String) TransactTranslator.read(uri.getQueryParameter("event"), "java.lang.String"), (String) TransactTranslator.read(uri.getQueryParameter("data"), "java.lang.String"));
                parcel2.writeNoException();
                TransactTranslator.reply(parcel2, null);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                parcel2.writeException(new IllegalStateException(e.getMessage()));
                return true;
            }
        } else if (i != 1) {
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString(ChargecontrolSpeechObserver_Manifest.DESCRIPTOR);
            return true;
        } else {
            parcel.enforceInterface(ChargecontrolSpeechObserver_Manifest.DESCRIPTOR);
            Uri uri2 = (Uri) Uri.CREATOR.createFromParcel(parcel);
            try {
                this.provider.onQuery((String) TransactTranslator.read(uri2.getQueryParameter("event"), "java.lang.String"), (String) TransactTranslator.read(uri2.getQueryParameter("data"), "java.lang.String"), (String) TransactTranslator.read(uri2.getQueryParameter("callback"), "java.lang.String"));
                parcel2.writeNoException();
                TransactTranslator.reply(parcel2, null);
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                parcel2.writeException(new IllegalStateException(e2.getMessage()));
                return true;
            }
        }
    }
}
