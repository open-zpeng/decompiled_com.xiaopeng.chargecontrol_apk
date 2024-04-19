package defpackage;

import android.content.Context;
import java.util.regex.Pattern;
/* compiled from: ConsumptionCache.java */
/* renamed from: d90  reason: default package */
/* loaded from: classes.dex */
public class d90 extends f90<Float> {
    public static final Pattern l = Pattern.compile("^[-]?[0-9]+\\.?[0-9]+$");

    public d90(Context context) {
        super(context, "consumption_per_100m.data", 1001);
    }

    @Override // defpackage.f90
    public Float a(String str) {
        return Float.valueOf(Float.parseFloat(str));
    }

    @Override // defpackage.f90
    public String b(Float f) {
        return Float.toString(f.floatValue());
    }

    @Override // defpackage.f90
    public boolean b(String str) {
        return !str.isEmpty() && l.matcher(str).matches();
    }
}
