package defpackage;

import android.content.Context;
import java.util.Comparator;
/* compiled from: ChargeCache.java */
/* renamed from: b90  reason: default package */
/* loaded from: classes.dex */
public class b90 extends i90 {
    public b90(Context context) {
        super(context, "charge_v2.data", new Comparator() { // from class: r80
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int compare;
                compare = Integer.compare(((j90) obj).a, ((j90) obj2).a);
                return compare;
            }
        });
        f90.b(context, "charge.data").delete();
        f90.a(context, "charge.data").delete();
    }
}
