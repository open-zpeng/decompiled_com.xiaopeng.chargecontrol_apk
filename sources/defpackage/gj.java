package defpackage;

import defpackage.hj;
import defpackage.kj;
import defpackage.nl;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* compiled from: DecodeHelper.java */
/* renamed from: gj  reason: default package */
/* loaded from: classes.dex */
public final class gj<Transcode> {
    public final List<nl.a<?>> a = new ArrayList();
    public final List<zh> b = new ArrayList();
    public ng c;
    public Object d;
    public int e;
    public int f;
    public Class<?> g;
    public hj.d h;
    public bi i;
    public Map<Class<?>, fi<?>> j;
    public Class<Transcode> k;
    public boolean l;
    public boolean m;
    public zh n;
    public qg o;
    public jj p;
    public boolean q;
    public boolean r;

    public <Data> tj<Data, ?, Transcode> a(Class<Data> cls) {
        sg sgVar = this.c.b;
        Class<?> cls2 = this.g;
        Class<Transcode> cls3 = this.k;
        tj<?, ?, ?> a = sgVar.i.a(cls, cls2, cls3);
        if (sgVar.i.a(a)) {
            return null;
        }
        if (a == null) {
            ArrayList arrayList = new ArrayList();
            for (Class cls4 : sgVar.c.b(cls, cls2)) {
                for (Class cls5 : sgVar.f.b(cls4, cls3)) {
                    arrayList.add(new ij(cls, cls4, cls5, sgVar.c.a(cls, cls4), sgVar.f.a(cls4, cls5), sgVar.j));
                }
            }
            a = arrayList.isEmpty() ? null : new tj<>(cls, cls2, cls3, arrayList, sgVar.j);
            sgVar.i.a(cls, cls2, cls3, a);
        }
        return a;
    }

    public ok b() {
        return ((kj.c) this.h).a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean c(Class<?> cls) {
        return a(cls) != null;
    }

    public <Z> fi<Z> b(Class<Z> cls) {
        fi<Z> fiVar = (fi<Z>) this.j.get(cls);
        if (fiVar == null) {
            Iterator<Map.Entry<Class<?>, fi<?>>> it = this.j.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Class<?>, fi<?>> next = it.next();
                if (next.getKey().isAssignableFrom(cls)) {
                    fiVar = (fi<Z>) next.getValue();
                    break;
                }
            }
        }
        if (fiVar == null) {
            if (this.j.isEmpty() && this.q) {
                throw new IllegalArgumentException("Missing transformation for " + cls + ". If you wish to ignore unknown resource types, use the optional transformation methods.");
            }
            return (fm) fm.b;
        }
        return fiVar;
    }

    public List<nl.a<?>> c() {
        if (!this.l) {
            this.l = true;
            this.a.clear();
            sg sgVar = this.c.b;
            List a = sgVar.a.a((pl) this.d);
            int size = a.size();
            for (int i = 0; i < size; i++) {
                nl.a<?> a2 = ((nl) a.get(i)).a(this.d, this.e, this.f, this.i);
                if (a2 != null) {
                    this.a.add(a2);
                }
            }
        }
        return this.a;
    }

    public List<nl<File, ?>> a(File file) {
        return this.c.b.a.a((pl) file);
    }

    public List<zh> a() {
        if (!this.m) {
            this.m = true;
            this.b.clear();
            List<nl.a<?>> c = c();
            int size = c.size();
            for (int i = 0; i < size; i++) {
                nl.a<?> aVar = c.get(i);
                if (!this.b.contains(aVar.a)) {
                    this.b.add(aVar.a);
                }
                for (int i2 = 0; i2 < aVar.b.size(); i2++) {
                    if (!this.b.contains(aVar.b.get(i2))) {
                        this.b.add(aVar.b.get(i2));
                    }
                }
            }
        }
        return this.b;
    }
}
