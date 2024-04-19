package com.xiaopeng.lib.apirouter.server;

import com.xiaopeng.chargecontrol.VuiObserver;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class VuiObserver_Manifest {
    public static final String DESCRIPTOR = "com.xiaopeng.chargecontrol.VuiObserver";
    public static final int TRANSACTION_getElementState = 0;
    public static final int TRANSACTION_onEvent = 1;

    public static Set<String> getKey() {
        HashSet hashSet = new HashSet(2);
        hashSet.add(VuiObserver.TAG);
        return hashSet;
    }

    public static String toJsonManifest() {
        return "{\"authority\":\"com.xiaopeng.chargecontrol.VuiObserver\",\"DESCRIPTOR\":\"com.xiaopeng.chargecontrol.VuiObserver\",\"TRANSACTION\":[{\"path\":\"getElementState\",\"METHOD\":\"getElementState\",\"ID\":0,\"parameter\":[{\"alias\":\"sceneId\",\"name\":\"sceneId\"},{\"alias\":\"elementId\",\"name\":\"elementId\"}]},{\"path\":\"onEvent\",\"METHOD\":\"onEvent\",\"ID\":1,\"parameter\":[{\"alias\":\"event\",\"name\":\"event\"},{\"alias\":\"data\",\"name\":\"data\"}]}]}";
    }
}
