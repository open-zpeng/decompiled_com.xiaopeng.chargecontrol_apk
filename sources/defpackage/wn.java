package defpackage;

import defpackage.yn;
/* compiled from: GifDrawableResource.java */
/* renamed from: wn  reason: default package */
/* loaded from: classes.dex */
public class wn extends mn<un> implements rj {
    public wn(un unVar) {
        super(unVar);
    }

    @Override // defpackage.vj
    public int b() {
        yn ynVar = ((un) this.c).c.a;
        return ynVar.a.f() + ynVar.o;
    }

    @Override // defpackage.vj
    public Class<un> c() {
        return un.class;
    }

    @Override // defpackage.vj
    public void d() {
        ((un) this.c).stop();
        un unVar = (un) this.c;
        unVar.f = true;
        yn ynVar = unVar.c.a;
        ynVar.c.clear();
        ynVar.b();
        ynVar.c();
        yn.a aVar = ynVar.j;
        if (aVar != null) {
            ynVar.d.a(aVar);
            ynVar.j = null;
        }
        yn.a aVar2 = ynVar.l;
        if (aVar2 != null) {
            ynVar.d.a(aVar2);
            ynVar.l = null;
        }
        yn.a aVar3 = ynVar.n;
        if (aVar3 != null) {
            ynVar.d.a(aVar3);
            ynVar.n = null;
        }
        ynVar.a.clear();
        ynVar.k = true;
    }

    @Override // defpackage.mn, defpackage.rj
    public void e() {
        ((un) this.c).b().prepareToDraw();
    }
}
