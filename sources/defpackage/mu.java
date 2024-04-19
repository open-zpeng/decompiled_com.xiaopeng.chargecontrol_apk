package defpackage;

import defpackage.vw;
import defpackage.xw;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: GsonBuilder.java */
/* renamed from: mu  reason: default package */
/* loaded from: classes.dex */
public final class mu {
    public String h;
    public xv a = xv.i;
    public av b = av.c;
    public fu c = eu.c;
    public final Map<Type, nu<?>> d = new HashMap();
    public final List<cv> e = new ArrayList();
    public final List<cv> f = new ArrayList();
    public boolean g = false;
    public int i = 2;
    public int j = 2;
    public boolean k = false;
    public boolean l = false;
    public boolean m = true;
    public boolean n = false;
    public boolean o = false;
    public boolean p = false;

    public mu a(cu... cuVarArr) {
        for (cu cuVar : cuVarArr) {
            xv xvVar = this.a;
            xv m5clone = xvVar.m5clone();
            m5clone.g = new ArrayList(xvVar.g);
            m5clone.g.add(cuVar);
            m5clone.h = new ArrayList(xvVar.h);
            m5clone.h.add(cuVar);
            this.a = m5clone;
        }
        return this;
    }

    public mu a(Type type, Object obj) {
        boolean z = obj instanceof yu;
        iv.a(z || (obj instanceof qu) || (obj instanceof nu) || (obj instanceof bv));
        if (obj instanceof nu) {
            this.d.put(type, (nu) obj);
        }
        if (z || (obj instanceof qu)) {
            fx fxVar = new fx(type);
            this.e.add(new vw.c(obj, fxVar, fxVar.b == fxVar.a, null));
        }
        if (obj instanceof bv) {
            this.e.add(xw.a(new fx(type), (bv) obj));
        }
        return this;
    }

    public lu a() {
        bu buVar;
        bu buVar2;
        bu buVar3;
        ArrayList arrayList = new ArrayList(this.f.size() + this.e.size() + 3);
        arrayList.addAll(this.e);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.f);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        String str = this.h;
        int i = this.i;
        int i2 = this.j;
        if (str != null && !"".equals(str.trim())) {
            bu buVar4 = new bu(Date.class, str);
            buVar2 = new bu(Timestamp.class, str);
            buVar3 = new bu(java.sql.Date.class, str);
            buVar = buVar4;
        } else {
            if (i != 2 && i2 != 2) {
                buVar = new bu(Date.class, i, i2);
                bu buVar5 = new bu(Timestamp.class, i, i2);
                bu buVar6 = new bu(java.sql.Date.class, i, i2);
                buVar2 = buVar5;
                buVar3 = buVar6;
            }
            return new lu(this.a, this.c, this.d, this.g, this.k, this.o, this.m, this.n, this.p, this.l, this.b, this.h, this.i, this.j, this.e, this.f, arrayList);
        }
        arrayList.add(xw.a(Date.class, buVar));
        arrayList.add(new xw.y(Timestamp.class, buVar2));
        arrayList.add(new xw.y(java.sql.Date.class, buVar3));
        return new lu(this.a, this.c, this.d, this.g, this.k, this.o, this.m, this.n, this.p, this.l, this.b, this.h, this.i, this.j, this.e, this.f, arrayList);
    }
}
