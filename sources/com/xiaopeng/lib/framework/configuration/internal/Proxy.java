package com.xiaopeng.lib.framework.configuration.internal;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class Proxy {
    public static final String TAG = "Proxy";
    public String mAppID;
    public WeakReference<Application> mApplication;
    public Connector mConnector;
    public ContextProvider mContextProvider;

    /* loaded from: classes.dex */
    public interface ContextProvider {
        String getAppID();

        String getAppPackageName();

        int getAppVersionCode();

        String getAppVersionName();

        Context getContext();
    }

    /* loaded from: classes.dex */
    public static final class Holder {
        public static final Proxy INSTANCE = new Proxy();
    }

    public static Proxy getInstance() {
        return Holder.INSTANCE;
    }

    public synchronized String getConfiguration(String str, String str2) {
        String configuration;
        Log.v(TAG, "getConfiguration key:" + str + "; default:" + str2);
        configuration = this.mConnector.getConfiguration(str);
        if (configuration == null) {
            configuration = str2;
        }
        return configuration;
    }

    public synchronized void init(Application application, String str) {
        if (this.mApplication == null) {
            Log.d(TAG, "init appID:" + str);
            this.mApplication = new WeakReference<>(application);
            this.mAppID = str;
            this.mConnector = new Connector(this.mContextProvider);
            this.mConnector.connect();
        } else {
            Log.w(TAG, "Warning! init many times;");
            throw new RuntimeException("init many times");
        }
    }

    public Proxy() {
        this.mContextProvider = new ContextProvider() { // from class: com.xiaopeng.lib.framework.configuration.internal.Proxy.1
            @Override // com.xiaopeng.lib.framework.configuration.internal.Proxy.ContextProvider
            public String getAppID() {
                return Proxy.this.mAppID;
            }

            @Override // com.xiaopeng.lib.framework.configuration.internal.Proxy.ContextProvider
            public String getAppPackageName() {
                Application application = (Application) Proxy.this.mApplication.get();
                if (application != null) {
                    return application.getPackageName();
                }
                return null;
            }

            @Override // com.xiaopeng.lib.framework.configuration.internal.Proxy.ContextProvider
            public int getAppVersionCode() {
                Application application = (Application) Proxy.this.mApplication.get();
                if (application != null) {
                    try {
                        return application.getPackageManager().getPackageInfo(application.getPackageName(), 0).versionCode;
                    } catch (PackageManager.NameNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                return 0;
            }

            @Override // com.xiaopeng.lib.framework.configuration.internal.Proxy.ContextProvider
            public String getAppVersionName() {
                Application application = (Application) Proxy.this.mApplication.get();
                if (application != null) {
                    try {
                        return application.getPackageManager().getPackageInfo(application.getPackageName(), 0).versionName;
                    } catch (PackageManager.NameNotFoundException e) {
                        e.printStackTrace();
                        return null;
                    }
                }
                return null;
            }

            @Override // com.xiaopeng.lib.framework.configuration.internal.Proxy.ContextProvider
            public Context getContext() {
                return (Context) Proxy.this.mApplication.get();
            }
        };
    }
}
