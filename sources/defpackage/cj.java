package defpackage;

import defpackage.fj;
import defpackage.ji;
import defpackage.nl;
import java.io.File;
import java.util.List;
/* compiled from: DataCacheGenerator.java */
/* renamed from: cj  reason: default package */
/* loaded from: classes.dex */
public class cj implements fj, ji.a<Object> {
    public final List<zh> c;
    public final gj<?> d;
    public final fj.a e;
    public int f = -1;
    public zh g;
    public List<nl<File, ?>> h;
    public int i;
    public volatile nl.a<?> j;
    public File k;

    public cj(List<zh> list, gj<?> gjVar, fj.a aVar) {
        this.c = list;
        this.d = gjVar;
        this.e = aVar;
    }

    @Override // defpackage.fj
    public boolean a() {
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
                        gj<?> gjVar = this.d;
                        this.j = list2.get(i).a(file, gjVar.e, gjVar.f, gjVar.i);
                        if (this.j != null && this.d.c(this.j.c.a())) {
                            this.j.c.a(this.d.o, this);
                            z = true;
                        }
                    }
                    return z;
                }
            }
            this.f++;
            if (this.f >= this.c.size()) {
                return false;
            }
            zh zhVar = this.c.get(this.f);
            this.k = this.d.b().a(new dj(zhVar, this.d.n));
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
        this.e.a(this.g, obj, this.j.c, uh.DATA_DISK_CACHE, this.g);
    }

    @Override // defpackage.ji.a
    public void a(Exception exc) {
        this.e.a(this.g, exc, this.j.c, uh.DATA_DISK_CACHE);
    }
}
