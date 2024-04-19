package defpackage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* compiled from: ListCompositeDisposable.java */
/* renamed from: xh0  reason: default package */
/* loaded from: classes.dex */
public final class xh0 implements kh0, uh0 {
    public List<kh0> c;
    public volatile boolean d;

    @Override // defpackage.kh0
    public void a() {
        if (this.d) {
            return;
        }
        synchronized (this) {
            if (this.d) {
                return;
            }
            this.d = true;
            List<kh0> list = this.c;
            ArrayList arrayList = null;
            this.c = null;
            if (list == null) {
                return;
            }
            for (kh0 kh0Var : list) {
                try {
                    kh0Var.a();
                } catch (Throwable th) {
                    z90.c(th);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th);
                }
            }
            if (arrayList != null) {
                if (arrayList.size() == 1) {
                    throw gk0.a((Throwable) arrayList.get(0));
                }
                throw new mh0(arrayList);
            }
        }
    }

    @Override // defpackage.kh0
    public boolean b() {
        return this.d;
    }

    @Override // defpackage.uh0
    public boolean c(kh0 kh0Var) {
        ai0.a(kh0Var, "d is null");
        if (!this.d) {
            synchronized (this) {
                if (!this.d) {
                    List list = this.c;
                    if (list == null) {
                        list = new LinkedList();
                        this.c = list;
                    }
                    list.add(kh0Var);
                    return true;
                }
            }
        }
        kh0Var.a();
        return false;
    }

    @Override // defpackage.uh0
    public boolean b(kh0 kh0Var) {
        if (a(kh0Var)) {
            kh0Var.a();
            return true;
        }
        return false;
    }

    @Override // defpackage.uh0
    public boolean a(kh0 kh0Var) {
        ai0.a(kh0Var, "Disposable item is null");
        if (this.d) {
            return false;
        }
        synchronized (this) {
            if (this.d) {
                return false;
            }
            List<kh0> list = this.c;
            if (list != null && list.remove(kh0Var)) {
                return true;
            }
            return false;
        }
    }
}
