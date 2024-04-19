package com.xiaopeng.lib.apirouter.server;

import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.xiaopeng.chargecontrol.OpenApiService;
/* loaded from: classes.dex */
public class OpenApiService_Stub extends Binder implements IInterface {
    public OpenApiService provider = new OpenApiService();
    public OpenApiService_Manifest manifest = new OpenApiService_Manifest();

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1598968902) {
            switch (i) {
                case 0:
                    parcel.enforceInterface(OpenApiService_Manifest.DESCRIPTOR);
                    Uri uri = (Uri) Uri.CREATOR.createFromParcel(parcel);
                    try {
                        Integer valueOf = Integer.valueOf(this.provider.getFridgeSwitchStatus());
                        parcel2.writeNoException();
                        TransactTranslator.reply(parcel2, valueOf);
                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        parcel2.writeException(new IllegalStateException(e.getMessage()));
                        return true;
                    }
                case 1:
                    parcel.enforceInterface(OpenApiService_Manifest.DESCRIPTOR);
                    try {
                        Boolean valueOf2 = Boolean.valueOf(this.provider.setFridgeSwitchStatus(((Boolean) TransactTranslator.read(((Uri) Uri.CREATOR.createFromParcel(parcel)).getQueryParameter("on"), "boolean")).booleanValue()));
                        parcel2.writeNoException();
                        TransactTranslator.reply(parcel2, valueOf2);
                        return true;
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        parcel2.writeException(new IllegalStateException(e2.getMessage()));
                        return true;
                    }
                case 2:
                    parcel.enforceInterface(OpenApiService_Manifest.DESCRIPTOR);
                    Uri uri2 = (Uri) Uri.CREATOR.createFromParcel(parcel);
                    try {
                        Integer valueOf3 = Integer.valueOf(this.provider.getTrunkPowerSwitchStatus());
                        parcel2.writeNoException();
                        TransactTranslator.reply(parcel2, valueOf3);
                        return true;
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        parcel2.writeException(new IllegalStateException(e3.getMessage()));
                        return true;
                    }
                case 3:
                    parcel.enforceInterface(OpenApiService_Manifest.DESCRIPTOR);
                    Uri uri3 = (Uri) Uri.CREATOR.createFromParcel(parcel);
                    try {
                        this.provider.onReceiverData(((Integer) TransactTranslator.read(uri3.getQueryParameter("id"), "int")).intValue(), (String) TransactTranslator.read(uri3.getQueryParameter("bundle"), "java.lang.String"));
                        parcel2.writeNoException();
                        TransactTranslator.reply(parcel2, null);
                        return true;
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        parcel2.writeException(new IllegalStateException(e4.getMessage()));
                        return true;
                    }
                case 4:
                    parcel.enforceInterface(OpenApiService_Manifest.DESCRIPTOR);
                    Uri uri4 = (Uri) Uri.CREATOR.createFromParcel(parcel);
                    try {
                        Integer valueOf4 = Integer.valueOf(this.provider.getSolarWorkSt());
                        parcel2.writeNoException();
                        TransactTranslator.reply(parcel2, valueOf4);
                        return true;
                    } catch (Exception e5) {
                        e5.printStackTrace();
                        parcel2.writeException(new IllegalStateException(e5.getMessage()));
                        return true;
                    }
                case 5:
                    parcel.enforceInterface(OpenApiService_Manifest.DESCRIPTOR);
                    Uri uri5 = (Uri) Uri.CREATOR.createFromParcel(parcel);
                    try {
                        String trunkPowerDelayOffTime = this.provider.getTrunkPowerDelayOffTime();
                        parcel2.writeNoException();
                        TransactTranslator.reply(parcel2, trunkPowerDelayOffTime);
                        return true;
                    } catch (Exception e6) {
                        e6.printStackTrace();
                        parcel2.writeException(new IllegalStateException(e6.getMessage()));
                        return true;
                    }
                case 6:
                    parcel.enforceInterface(OpenApiService_Manifest.DESCRIPTOR);
                    Uri uri6 = (Uri) Uri.CREATOR.createFromParcel(parcel);
                    try {
                        Boolean valueOf5 = Boolean.valueOf(this.provider.hasFridge());
                        parcel2.writeNoException();
                        TransactTranslator.reply(parcel2, valueOf5);
                        return true;
                    } catch (Exception e7) {
                        e7.printStackTrace();
                        parcel2.writeException(new IllegalStateException(e7.getMessage()));
                        return true;
                    }
                case 7:
                    parcel.enforceInterface(OpenApiService_Manifest.DESCRIPTOR);
                    Uri uri7 = (Uri) Uri.CREATOR.createFromParcel(parcel);
                    try {
                        Boolean valueOf6 = Boolean.valueOf(this.provider.hasSolarRoof());
                        parcel2.writeNoException();
                        TransactTranslator.reply(parcel2, valueOf6);
                        return true;
                    } catch (Exception e8) {
                        e8.printStackTrace();
                        parcel2.writeException(new IllegalStateException(e8.getMessage()));
                        return true;
                    }
                case 8:
                    parcel.enforceInterface(OpenApiService_Manifest.DESCRIPTOR);
                    Uri uri8 = (Uri) Uri.CREATOR.createFromParcel(parcel);
                    try {
                        Boolean valueOf7 = Boolean.valueOf(this.provider.tryClosePanel());
                        parcel2.writeNoException();
                        TransactTranslator.reply(parcel2, valueOf7);
                        return true;
                    } catch (Exception e9) {
                        e9.printStackTrace();
                        parcel2.writeException(new IllegalStateException(e9.getMessage()));
                        return true;
                    }
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
        parcel2.writeString(OpenApiService_Manifest.DESCRIPTOR);
        return true;
    }
}
