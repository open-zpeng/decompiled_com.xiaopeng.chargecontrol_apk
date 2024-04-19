package com.xiaopeng.lib.apirouter.server.aar;

import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class ClientObserver_Manifest {
    public static final String DESCRIPTOR = "com.xiaopeng.aar.client.ipc.ClientObserver";
    public static final int TRANSACTION_onReceived = 0;
    public static final int TRANSACTION_onReceivedBlob = 1;

    public static Set<String> getKey() {
        HashSet hashSet = new HashSet(2);
        hashSet.add("ClientObserver");
        return hashSet;
    }

    public static String toJsonManifest() {
        return "{\"authority\":\"com.xiaopeng.aar.client.ipc.ClientObserver\",\"DESCRIPTOR\":\"com.xiaopeng.aar.client.ipc.ClientObserver\",\"TRANSACTION\":[{\"path\":\"onReceived\",\"METHOD\":\"onReceived\",\"ID\":0,\"parameter\":[{\"alias\":\"type\",\"name\":\"type\"},{\"alias\":\"appId\",\"name\":\"appId\"},{\"alias\":\"module\",\"name\":\"module\"},{\"alias\":\"msgId\",\"name\":\"msgId\"},{\"alias\":\"data\",\"name\":\"data\"}]},{\"path\":\"onReceivedBlob\",\"METHOD\":\"onReceivedBlob\",\"ID\":1,\"parameter\":[{\"alias\":\"type\",\"name\":\"type\"},{\"alias\":\"appId\",\"name\":\"appId\"},{\"alias\":\"module\",\"name\":\"module\"},{\"alias\":\"msgId\",\"name\":\"msgId\"},{\"alias\":\"data\",\"name\":\"data\"}]}]}";
    }
}
