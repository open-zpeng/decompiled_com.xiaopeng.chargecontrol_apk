package defpackage;

import android.content.Context;
import java.util.Comparator;
/* compiled from: DischargeCache.java */
/* renamed from: e90  reason: default package */
/* loaded from: classes.dex */
public class e90 extends i90 {
    public e90(Context context) {
        super(context, "discharge_v2.data", new Comparator() { // from class: v80
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int compare;
                compare = Integer.compare(((j90) obj2).a, ((j90) obj).a);
                return compare;
            }
        });
        f90.b(context, "discharge.data").delete();
        f90.a(context, "discharge.data").delete();
    }
}
