package defpackage;

import defpackage.df;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: DefaultItemAnimator.java */
/* renamed from: ze  reason: default package */
/* loaded from: classes.dex */
public class ze implements Runnable {
    public final /* synthetic */ ArrayList c;
    public final /* synthetic */ df d;

    public ze(df dfVar, ArrayList arrayList) {
        this.d = dfVar;
        this.c = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            df.f fVar = (df.f) it.next();
            this.d.b(fVar.a, fVar.b, fVar.c, fVar.d, fVar.e);
        }
        this.c.clear();
        this.d.m.remove(this.c);
    }
}
