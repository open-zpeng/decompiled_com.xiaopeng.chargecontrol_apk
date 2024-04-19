package com.xiaopeng.lib.apirouter;

import android.text.TextUtils;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public class ApiMatcher {
    public static final String PROCESS_TAG_DIVIDER = "@";
    public ConcurrentHashMap<String, RemoteOperator> mRemoteOperators = new ConcurrentHashMap<>();

    private RemoteOperator getRemoteOperator(UriStruct uriStruct) {
        String a;
        Set<Map.Entry<String, RemoteOperator>> entrySet = this.mRemoteOperators.entrySet();
        String str = uriStruct.processTag;
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(PROCESS_TAG_DIVIDER);
            a = jg.a(sb, uriStruct.applicationId, ".");
        } else {
            a = jg.a(new StringBuilder(), uriStruct.applicationId, ".");
        }
        StringBuilder a2 = jg.a(".");
        a2.append(uriStruct.serviceName);
        String sb2 = a2.toString();
        for (Map.Entry<String, RemoteOperator> entry : entrySet) {
            String key = entry.getKey();
            if (key.startsWith(a) && key.endsWith(sb2)) {
                return entry.getValue();
            }
        }
        return null;
    }

    private RemoteOperator put(String str, String str2, RemoteOperator remoteOperator) {
        if (!TextUtils.isEmpty(str)) {
            str2 = jg.b(str, PROCESS_TAG_DIVIDER, str2);
        }
        return this.mRemoteOperators.put(str2, remoteOperator);
    }

    private void remove(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            str2 = jg.b(str, PROCESS_TAG_DIVIDER, str2);
        }
        this.mRemoteOperators.remove(str2);
    }

    public synchronized RemoteOperator matchRemoteOperator(UriStruct uriStruct) {
        return getRemoteOperator(uriStruct);
    }

    public synchronized void publishUri(UriStruct uriStruct, RemoteOperator remoteOperator) {
        RemoteOperator put;
        String str = uriStruct.processTag;
        RemoteOperator put2 = put(str, remoteOperator.getAuthority(), remoteOperator);
        if (put2 != null) {
            put2.unLinkToDeath("getAuthority");
        }
        if (!remoteOperator.getAuthority().equals(remoteOperator.getDescription()) && (put = put(str, remoteOperator.getDescription(), remoteOperator)) != null) {
            put.unLinkToDeath("getDescription");
        }
        remoteOperator.linkToDeath();
    }

    public synchronized void unpublishUri(UriStruct uriStruct) {
        RemoteOperator remoteOperator = getRemoteOperator(uriStruct);
        if (remoteOperator != null) {
            String str = uriStruct.processTag;
            remove(str, remoteOperator.getAuthority());
            if (!remoteOperator.getAuthority().equals(remoteOperator.getDescription())) {
                remove(str, remoteOperator.getDescription());
            }
            remoteOperator.unLinkToDeath("unpublishUri");
        }
    }
}
