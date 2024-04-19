package defpackage;

import defpackage.th;
/* compiled from: WebpDrawableResource.java */
/* renamed from: rh  reason: default package */
/* loaded from: classes.dex */
public class rh extends mn<ph> implements rj {
    public rh(ph phVar) {
        super(phVar);
    }

    @Override // defpackage.vj
    public int b() {
        th thVar = ((ph) this.c).c.a;
        return thVar.a.f() + thVar.o;
    }

    @Override // defpackage.vj
    public Class<ph> c() {
        return ph.class;
    }

    @Override // defpackage.vj
    public void d() {
        ((ph) this.c).stop();
        ph phVar = (ph) this.c;
        phVar.f = true;
        th thVar = phVar.c.a;
        thVar.c.clear();
        thVar.b();
        thVar.c();
        th.a aVar = thVar.j;
        if (aVar != null) {
            thVar.d.a(aVar);
            thVar.j = null;
        }
        th.a aVar2 = thVar.l;
        if (aVar2 != null) {
            thVar.d.a(aVar2);
            thVar.l = null;
        }
        th.a aVar3 = thVar.n;
        if (aVar3 != null) {
            thVar.d.a(aVar3);
            thVar.n = null;
        }
        thVar.a.clear();
        thVar.k = true;
    }

    @Override // defpackage.mn, defpackage.rj
    public void e() {
        ((ph) this.c).c.a.m.prepareToDraw();
    }
}
