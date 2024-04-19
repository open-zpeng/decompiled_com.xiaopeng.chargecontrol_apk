package defpackage;

import defpackage.df;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: DefaultItemAnimator.java */
/* renamed from: af  reason: default package */
/* loaded from: classes.dex */
public class af implements Runnable {
    public final /* synthetic */ ArrayList c;
    public final /* synthetic */ df d;

    public af(df dfVar, ArrayList arrayList) {
        this.d = dfVar;
        this.c = arrayList;
    }

    @Override // java.lang.Runnable
    public void run() {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            this.d.a((df.e) it.next());
        }
        this.c.clear();
        this.d.n.remove(this.c);
    }
}
