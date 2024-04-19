package com.xiaopeng.lib.apirouter.server;

import android.os.IBinder;
import android.util.Log;
import android.util.Pair;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class AutoCodeMatcher {
    public static HashMap<String, Pair<IBinder, String>> mapping;
    public static List<IManifestHandler> sManifestHandlerList = new LinkedList();
    public static Object sLock = new Object();

    public static void addManifestHandler(IManifestHandler iManifestHandler) {
        synchronized (sLock) {
            if (!sManifestHandlerList.contains(iManifestHandler)) {
                sManifestHandlerList.add(iManifestHandler);
            }
        }
    }

    private void initManifestHandler() {
        synchronized (sLock) {
            if (!sManifestHandlerList.isEmpty()) {
                for (IManifestHandler iManifestHandler : sManifestHandlerList) {
                    initManifestHandler(iManifestHandler);
                }
            }
        }
    }

    public Pair<IBinder, String> match(String str) {
        if (mapping == null) {
            mapping = ManifestHelperMapping.reflectMapping();
            initManifestHandler();
        }
        HashMap<String, Pair<IBinder, String>> hashMap = mapping;
        Pair<IBinder, String> pair = hashMap == null ? null : hashMap.get(str);
        return pair == null ? new Pair<>(null, null) : pair;
    }

    private void initManifestHandler(IManifestHandler iManifestHandler) {
        IManifestHelper[] manifestHelpers;
        if (iManifestHandler == null || (manifestHelpers = iManifestHandler.getManifestHelpers()) == null || manifestHelpers.length == 0) {
            return;
        }
        if (mapping == null) {
            mapping = new HashMap<>();
        }
        HashMap<String, Pair<IBinder, String>> hashMap = mapping;
        for (IManifestHelper iManifestHelper : manifestHelpers) {
            try {
                HashMap<String, Pair<IBinder, String>> mapping2 = iManifestHelper.getMapping();
                if (mapping2 != null && !mapping2.isEmpty()) {
                    hashMap.putAll(mapping2);
                }
            } catch (Exception e) {
                StringBuilder a = jg.a("initManifestHandler:");
                a.append(iManifestHelper.getClass());
                Log.e("AutoCodeMatcher", a.toString(), e);
            }
        }
    }
}
