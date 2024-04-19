package com.xiaopeng.lib.framework.moduleinterface.accountmodule;

import android.app.Application;
/* loaded from: classes.dex */
public interface IAccount {
    IUserInfo getUserInfo();

    void init(Application application, String appId);

    void init(Application application, String appId, String packageName);

    void login();

    void logout();

    void requestOAuth(ICallback<IAuthInfo, IError> callback);

    void requestOAuth(String appID, ICallback<IAuthInfo, IError> callback);

    void requestOTP(String deviceID, ICallback<IOTPInfo, IError> callback);
}
