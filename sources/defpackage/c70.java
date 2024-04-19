package defpackage;

import android.util.SparseArray;
import androidx.fragment.app.Fragment;
import java.util.HashSet;
import java.util.Set;
/* compiled from: GlobalConfig.java */
/* renamed from: c70  reason: default package */
/* loaded from: classes.dex */
public class c70 {
    public static Set<i80> a = new HashSet();
    public static SparseArray<b70> b = new SparseArray<>();

    public static void a(int i, Class<? extends Fragment> cls) {
        b.put(i, new b70(i, cls, null));
    }
}
