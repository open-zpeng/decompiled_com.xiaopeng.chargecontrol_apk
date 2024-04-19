package defpackage;

import defpackage.fj;
import defpackage.ji;
import defpackage.nl;
/* compiled from: SourceGenerator.java */
/* renamed from: zj  reason: default package */
/* loaded from: classes.dex */
public class zj implements ji.a<Object> {
    public final /* synthetic */ nl.a c;
    public final /* synthetic */ ak d;

    public zj(ak akVar, nl.a aVar) {
        this.d = akVar;
        this.c = aVar;
    }

    @Override // defpackage.ji.a
    public void a(Object obj) {
        ak akVar = this.d;
        nl.a<?> aVar = this.c;
        nl.a<?> aVar2 = akVar.h;
        if (aVar2 != null && aVar2 == aVar) {
            ak akVar2 = this.d;
            nl.a aVar3 = this.c;
            jj jjVar = akVar2.c.p;
            if (obj != null && jjVar.a(aVar3.c.c())) {
                akVar2.g = obj;
                akVar2.d.b();
                return;
            }
            fj.a aVar4 = akVar2.d;
            zh zhVar = aVar3.a;
            ji<Data> jiVar = aVar3.c;
            aVar4.a(zhVar, obj, jiVar, jiVar.c(), akVar2.i);
        }
    }

    @Override // defpackage.ji.a
    public void a(Exception exc) {
        ak akVar = this.d;
        nl.a<?> aVar = this.c;
        nl.a<?> aVar2 = akVar.h;
        if (aVar2 != null && aVar2 == aVar) {
            ak akVar2 = this.d;
            nl.a aVar3 = this.c;
            fj.a aVar4 = akVar2.d;
            zh zhVar = akVar2.i;
            ji<Data> jiVar = aVar3.c;
            aVar4.a(zhVar, exc, jiVar, jiVar.c());
        }
    }
}
