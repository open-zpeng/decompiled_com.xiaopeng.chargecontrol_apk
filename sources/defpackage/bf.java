package defpackage;

import defpackage.nf;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: DefaultItemAnimator.java */
/* renamed from: bf  reason: default package */
/* loaded from: classes.dex */
public class bf implements Runnable {
    public final /* synthetic */ ArrayList c;
    public final /* synthetic */ df d;

    public bf(df dfVar, ArrayList arrayList) {
        this.d = dfVar;
        this.c = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            this.d.g((nf.c0) it.next());
        }
        this.c.clear();
        this.d.l.remove(this.c);
    }
}
