package defpackage;

import android.content.Intent;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* compiled from: ActivityResultContracts.java */
/* renamed from: x  reason: default package */
/* loaded from: classes.dex */
public final class x extends w<String[], Map<String, Boolean>> {
    @Override // defpackage.w
    public Map<String, Boolean> a(int i, Intent intent) {
        if (i != -1) {
            return Collections.emptyMap();
        }
        if (intent == null) {
            return Collections.emptyMap();
        }
        String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
        int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
        if (intArrayExtra != null && stringArrayExtra != null) {
            HashMap hashMap = new HashMap();
            int length = stringArrayExtra.length;
            for (int i2 = 0; i2 < length; i2++) {
                hashMap.put(stringArrayExtra[i2], Boolean.valueOf(intArrayExtra[i2] == 0));
            }
            return hashMap;
        }
        return Collections.emptyMap();
    }
}
