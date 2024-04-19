package defpackage;

import android.content.Context;
import android.content.ContextWrapper;
import defpackage.lg;
import defpackage.mg;
import java.util.List;
import java.util.Map;
/* compiled from: GlideContext.java */
/* renamed from: ng  reason: default package */
/* loaded from: classes.dex */
public class ng extends ContextWrapper {
    public static final vg<?, ?> k = new kg();
    public final ck a;
    public final sg b;
    public final aq c;
    public final lg.a d;
    public final List<pp<Object>> e;
    public final Map<Class<?>, vg<?, ?>> f;
    public final kj g;
    public final boolean h;
    public final int i;
    public qp j;

    public ng(Context context, ck ckVar, sg sgVar, aq aqVar, lg.a aVar, Map<Class<?>, vg<?, ?>> map, List<pp<Object>> list, kj kjVar, boolean z, int i) {
        super(context.getApplicationContext());
        this.a = ckVar;
        this.b = sgVar;
        this.c = aqVar;
        this.d = aVar;
        this.e = list;
        this.f = map;
        this.g = kjVar;
        this.h = z;
        this.i = i;
    }

    public synchronized qp a() {
        if (this.j == null) {
            qp a = ((mg.a) this.d).a();
            a.v = true;
            this.j = a;
        }
        return this.j;
    }
}
