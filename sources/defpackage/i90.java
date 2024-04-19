package defpackage;

import android.content.Context;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
/* compiled from: PowerCache.java */
/* renamed from: i90  reason: default package */
/* loaded from: classes.dex */
public class i90 extends f90<j90> {
    public static final Pattern m = Pattern.compile("^[-]?[0-9]+ [-]?[0-9]+\\.?[0-9]+$");
    public final Comparator<j90> l;

    public i90(Context context, String str, Comparator<j90> comparator) {
        super(context, str, Integer.MAX_VALUE);
        this.l = comparator;
    }

    @Override // defpackage.f90
    public void a(List<j90> list) {
        List<j90> c = c();
        HashMap hashMap = new HashMap();
        for (j90 j90Var : list) {
            hashMap.put(Integer.valueOf(j90Var.a), Float.valueOf(j90Var.b));
        }
        ArrayList arrayList = new ArrayList();
        for (j90 j90Var2 : c) {
            Float f = (Float) hashMap.remove(Integer.valueOf(j90Var2.a));
            float f2 = j90Var2.b;
            if (f != null) {
                f2 = (f.floatValue() + f2) / 2.0f;
            }
            arrayList.add(new j90(j90Var2.a, f2));
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            arrayList.add(new j90(((Integer) entry.getKey()).intValue(), ((Float) entry.getValue()).floatValue()));
        }
        Collections.sort(arrayList, this.l);
        b();
        super.a((List) arrayList);
    }

    @Override // defpackage.f90
    public String b(j90 j90Var) {
        j90 j90Var2 = j90Var;
        return j90Var2.a + " " + j90Var2.b;
    }

    @Override // defpackage.f90
    public boolean b(String str) {
        return !str.isEmpty() && m.matcher(str).matches();
    }

    @Override // defpackage.f90
    public j90 a(String str) {
        String[] split = str.split(" ");
        return new j90(Integer.parseInt(split[0]), Float.parseFloat(split[1]));
    }
}
