package com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.remotestorage;

import android.app.Application;
import java.util.Map;
/* loaded from: classes.dex */
public interface IRemoteStorage {

    /* loaded from: classes.dex */
    public enum CATEGORY {
        CDU,
        CAN
    }

    void appendWithPathAndCallback(String bucketName, String remoteFolder, byte[] uploadContent, Callback callback);

    void downloadWithPathAndCallback(String bucketName, String remoteFolder, String localFile, Callback callback);

    @Deprecated
    void initWithCategoryAndContext(Application application);

    void initWithContext(Application application);

    void needCertified(boolean openCertification);

    void uploadWithCallback(CATEGORY category, String moduleName, String file, Callback callback);

    void uploadWithCallback(CATEGORY category, String moduleName, String file, Callback callback, Map<String, String> remoteCallbackParams);

    void uploadWithPathAndCallback(String bucketName, String remoteFolder, String file, Callback callback);

    void uploadWithPathAndCallback(String bucketName, String remoteFolder, String file, Callback callback, Map<String, String> remoteCallbackParams);
}
