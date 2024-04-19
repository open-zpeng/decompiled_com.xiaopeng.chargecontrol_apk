package defpackage;

import android.os.Build;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* compiled from: FragmentTransitionImpl.java */
/* renamed from: hd  reason: default package */
/* loaded from: classes.dex */
public class hd implements Runnable {
    public final /* synthetic */ ArrayList c;
    public final /* synthetic */ Map d;

    public hd(gd gdVar, ArrayList arrayList, Map map) {
        this.c = arrayList;
        this.d = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            View view = (View) this.c.get(i);
            String m = y9.m(view);
            if (m != null) {
                Iterator it = this.d.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        str = null;
                        break;
                    }
                    Map.Entry entry = (Map.Entry) it.next();
                    if (m.equals(entry.getValue())) {
                        str = (String) entry.getKey();
                        break;
                    }
                }
                int i2 = Build.VERSION.SDK_INT;
                view.setTransitionName(str);
            }
        }
    }
}
