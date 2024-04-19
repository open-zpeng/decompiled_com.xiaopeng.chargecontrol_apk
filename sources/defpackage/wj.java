package defpackage;

import defpackage.fj;
import defpackage.ji;
import defpackage.nl;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* compiled from: ResourceCacheGenerator.java */
/* renamed from: wj  reason: default package */
/* loaded from: classes.dex */
public class wj implements fj, ji.a<Object> {
    public final fj.a c;
    public final gj<?> d;
    public int e;
    public int f = -1;
    public zh g;
    public List<nl<File, ?>> h;
    public int i;
    public volatile nl.a<?> j;
    public File k;
    public xj l;

    public wj(gj<?> gjVar, fj.a aVar) {
        this.d = gjVar;
        this.c = aVar;
    }

    @Override // defpackage.fj
    public boolean a() {
        List<zh> a = this.d.a();
        if (a.isEmpty()) {
            return false;
        }
        gj<?> gjVar = this.d;
        sg sgVar = gjVar.c.b;
        Class<?> cls = gjVar.d.getClass();
        Class<?> cls2 = gjVar.g;
        Class<?> cls3 = gjVar.k;
        List<Class<?>> a2 = sgVar.h.a(cls, cls2, cls3);
        if (a2 == null) {
            a2 = new ArrayList<>();
            for (Class<?> cls4 : sgVar.a.a(cls)) {
                for (Class<?> cls5 : sgVar.c.b(cls4, cls2)) {
                    if (!sgVar.f.b(cls5, cls3).isEmpty() && !a2.contains(cls5)) {
                        a2.add(cls5);
                    }
                }
            }
            sgVar.h.a(cls, cls2, cls3, Collections.unmodifiableList(a2));
        }
        if (a2.isEmpty()) {
            if (File.class.equals(this.d.k)) {
                return false;
            }
            StringBuilder a3 = jg.a("Failed to find any load path from ");
            a3.append(this.d.d.getClass());
            a3.append(" to ");
            a3.append(this.d.k);
            throw new IllegalStateException(a3.toString());
        }
        while (true) {
            List<nl<File, ?>> list = this.h;
            if (list != null) {
                if (this.i < list.size()) {
                    this.j = null;
                    boolean z = false;
                    while (!z) {
                        if (!(this.i < this.h.size())) {
                            break;
                        }
                        List<nl<File, ?>> list2 = this.h;
                        int i = this.i;
                        this.i = i + 1;
                        File file = this.k;
                        gj<?> gjVar2 = this.d;
                        this.j = list2.get(i).a(file, gjVar2.e, gjVar2.f, gjVar2.i);
                        if (this.j != null && this.d.c(this.j.c.a())) {
                            this.j.c.a(this.d.o, this);
                            z = true;
                        }
                    }
                    return z;
                }
            }
            this.f++;
            if (this.f >= a2.size()) {
                this.e++;
                if (this.e >= a.size()) {
                    return false;
                }
                this.f = 0;
            }
            zh zhVar = a.get(this.e);
            Class<?> cls6 = a2.get(this.f);
            fi<Z> b = this.d.b(cls6);
            gj<?> gjVar3 = this.d;
            this.l = new xj(gjVar3.c.a, zhVar, gjVar3.n, gjVar3.e, gjVar3.f, b, cls6, gjVar3.i);
            this.k = this.d.b().a(this.l);
            File file2 = this.k;
            if (file2 != null) {
                this.g = zhVar;
                this.h = this.d.a(file2);
                this.i = 0;
            }
        }
    }

    @Override // defpackage.fj
    public void cancel() {
        nl.a<?> aVar = this.j;
        if (aVar != null) {
            aVar.c.cancel();
        }
    }

    @Override // defpackage.ji.a
    public void a(Object obj) {
        this.c.a(this.g, obj, this.j.c, uh.RESOURCE_DISK_CACHE, this.l);
    }

    @Override // defpackage.ji.a
    public void a(Exception exc) {
        this.c.a(this.l, exc, this.j.c, uh.RESOURCE_DISK_CACHE);
    }
}
