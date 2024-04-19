package com.xiaopeng.lib.apirouter.server;

import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class OpenApiService_Manifest {
    public static final String DESCRIPTOR = "com.xiaopeng.chargecontrol.OpenApiService";
    public static final int TRANSACTION_getFridgeSwitchStatus = 0;
    public static final int TRANSACTION_getSolarWorkSt = 4;
    public static final int TRANSACTION_getTrunkPowerDelayOffTime = 5;
    public static final int TRANSACTION_getTrunkPowerSwitchStatus = 2;
    public static final int TRANSACTION_hasFridge = 6;
    public static final int TRANSACTION_hasSolarRoof = 7;
    public static final int TRANSACTION_onReceiverData = 3;
    public static final int TRANSACTION_setFridgeSwitchStatus = 1;
    public static final int TRANSACTION_tryClosePanel = 8;

    public static Set<String> getKey() {
        HashSet hashSet = new HashSet(2);
        hashSet.add("OpenApiService");
        return hashSet;
    }

    public static String toJsonManifest() {
        return "{\"authority\":\"com.xiaopeng.chargecontrol.OpenApiService\",\"DESCRIPTOR\":\"com.xiaopeng.chargecontrol.OpenApiService\",\"TRANSACTION\":[{\"path\":\"getFridgeSwitchStatus\",\"METHOD\":\"getFridgeSwitchStatus\",\"ID\":0,\"parameter\":[]},{\"path\":\"setFridgeSwitchStatus\",\"METHOD\":\"setFridgeSwitchStatus\",\"ID\":1,\"parameter\":[{\"alias\":\"on\",\"name\":\"on\"}]},{\"path\":\"getTrunkPowerSwitchStatus\",\"METHOD\":\"getTrunkPowerSwitchStatus\",\"ID\":2,\"parameter\":[]},{\"path\":\"onReceiverData\",\"METHOD\":\"onReceiverData\",\"ID\":3,\"parameter\":[{\"alias\":\"id\",\"name\":\"id\"},{\"alias\":\"bundle\",\"name\":\"bundle\"}]},{\"path\":\"getSolarWorkSt\",\"METHOD\":\"getSolarWorkSt\",\"ID\":4,\"parameter\":[]},{\"path\":\"getTrunkPowerDelayOffTime\",\"METHOD\":\"getTrunkPowerDelayOffTime\",\"ID\":5,\"parameter\":[]},{\"path\":\"hasFridge\",\"METHOD\":\"hasFridge\",\"ID\":6,\"parameter\":[]},{\"path\":\"hasSolarRoof\",\"METHOD\":\"hasSolarRoof\",\"ID\":7,\"parameter\":[]},{\"path\":\"tryClosePanel\",\"METHOD\":\"tryClosePanel\",\"ID\":8,\"parameter\":[]}]}";
    }
}
