package com.xiaopeng.lib.framework.moduleinterface.appresourcemodule;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
/* loaded from: classes.dex */
public interface IAppResourceManager {

    /* loaded from: classes.dex */
    public interface IResourceObserver {
        void onChange(String uriPath, AppResourceResponse response);
    }

    /* loaded from: classes.dex */
    public enum Status {
        NOT_REGISTER(0),
        NOT_AUTH(1),
        NOT_AVAILABLE(2),
        OK(3),
        ERROR(4);
        
        public final int mId;

        Status(int id) {
            this.mId = id;
        }

        public int id() {
            return this.mId;
        }
    }

    /* loaded from: classes.dex */
    public enum UpdatePolicy {
        LOCAL(0),
        SYNC(1),
        ASYNC(2);
        
        public final int mId;

        UpdatePolicy(int id) {
            this.mId = id;
        }

        public int id() {
            return this.mId;
        }
    }

    boolean addResource(AppResourceRequest request);

    ah0<AppResourceResponse> addResourceObSource(AppResourceRequest request);

    void checkUpdate(String uriPath);

    ah0<AppResourceResponse> checkUpdateObSource(String uriPath);

    ah0<AppResourceResponse> clearResourceObSource();

    void clearResources();

    boolean deleteResource(String uriPath);

    ah0<AppResourceResponse> deleteResourceObSource(String uriPath);

    AssetFileDescriptor getFileDescriptor(String uriPath);

    ah0<AssetFileDescriptor> getFileDescriptorObSource(String uriPath);

    Uri getFullUri(String uriPath);

    ah0<Uri> getFullUrlObSource(String uriPath);

    Status getStatus(String uriPath);

    ah0<Status> getStatusObSource(String uriPath);

    void subscribeChanges(IResourceObserver observer);

    void unSubscribeChanges(IResourceObserver observer);
}
