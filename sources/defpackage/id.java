package defpackage;

import android.os.Build;
import android.view.View;
import java.util.ArrayList;
import java.util.Map;
/* compiled from: FragmentTransitionImpl.java */
/* renamed from: id  reason: default package */
/* loaded from: classes.dex */
public class id implements Runnable {
    public final /* synthetic */ ArrayList c;
    public final /* synthetic */ Map d;

    public id(gd gdVar, ArrayList arrayList, Map map) {
        this.c = arrayList;
        this.d = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            View view = (View) this.c.get(i);
            String m = y9.m(view);
            int i2 = Build.VERSION.SDK_INT;
            view.setTransitionName((String) this.d.get(m));
        }
    }
}
