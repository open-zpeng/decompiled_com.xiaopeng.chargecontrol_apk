package defpackage;

import android.os.RemoteException;
import defpackage.eb0;
import java.util.ArrayList;
import java.util.List;
/* compiled from: DataCollectorHelper.java */
/* renamed from: ab0  reason: default package */
/* loaded from: classes.dex */
public class ab0 implements Runnable {
    public final /* synthetic */ String[] c;
    public final /* synthetic */ List d;
    public final /* synthetic */ ra0 e;
    public final /* synthetic */ ya0 f;

    public ab0(ya0 ya0Var, String[] strArr, List list, ra0 ra0Var) {
        this.f = ya0Var;
        this.c = strArr;
        this.d = list;
        this.e = ra0Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f.a(this.c[1], this.d);
        this.e.put("address", this.c[0]);
        String json = this.e.toJson();
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.c[1].replace(".zip", "_en.zip"));
        this.f.a(json);
        eb0 eb0Var = this.f.a;
        if (eb0Var != null) {
            try {
                ((eb0.a.C0005a) eb0Var).a(arrayList);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
