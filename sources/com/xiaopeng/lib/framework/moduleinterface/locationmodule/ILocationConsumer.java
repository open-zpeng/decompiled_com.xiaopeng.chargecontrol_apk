package com.xiaopeng.lib.framework.moduleinterface.locationmodule;

import android.content.Context;
import com.xiaopeng.lib.framework.moduleinterface.locationmodule.ILocation;
/* loaded from: classes.dex */
public interface ILocationConsumer {
    boolean connected();

    ILocation getLocation();

    void init(Context context);

    void init(Context context, String remoteAppPackage);

    void subscribe(ILocation.Category category);

    void unsubscribe();
}
