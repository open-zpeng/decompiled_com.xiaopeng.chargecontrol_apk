package defpackage;

import java.util.ArrayList;
import java.util.List;
/* compiled from: PendingPost.java */
/* renamed from: ql0  reason: default package */
/* loaded from: classes.dex */
public final class ql0 {
    public static final List<ql0> d = new ArrayList();
    public Object a;
    public xl0 b;
    public ql0 c;

    public ql0(Object obj, xl0 xl0Var) {
        this.a = obj;
        this.b = xl0Var;
    }

    public static ql0 a(xl0 xl0Var, Object obj) {
        synchronized (d) {
            int size = d.size();
            if (size > 0) {
                ql0 remove = d.remove(size - 1);
                remove.a = obj;
                remove.b = xl0Var;
                remove.c = null;
                return remove;
            }
            return new ql0(obj, xl0Var);
        }
    }

    public static void a(ql0 ql0Var) {
        ql0Var.a = null;
        ql0Var.b = null;
        ql0Var.c = null;
        synchronized (d) {
            if (d.size() < 10000) {
                d.add(ql0Var);
            }
        }
    }
}
