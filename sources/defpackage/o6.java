package defpackage;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: WidgetGroup.java */
/* renamed from: o6  reason: default package */
/* loaded from: classes.dex */
public class o6 {
    public static int f;
    public int b;
    public int c;
    public ArrayList<t5> a = new ArrayList<>();
    public ArrayList<a> d = null;
    public int e = -1;

    /* compiled from: WidgetGroup.java */
    /* renamed from: o6$a */
    /* loaded from: classes.dex */
    public class a {
        public a(o6 o6Var, t5 t5Var, k5 k5Var, int i) {
            new WeakReference(t5Var);
            k5Var.b(t5Var.K);
            k5Var.b(t5Var.L);
            k5Var.b(t5Var.M);
            k5Var.b(t5Var.N);
            k5Var.b(t5Var.O);
        }
    }

    public o6(int i) {
        this.b = -1;
        this.c = 0;
        int i2 = f;
        f = i2 + 1;
        this.b = i2;
        this.c = i;
    }

    public boolean a(t5 t5Var) {
        if (this.a.contains(t5Var)) {
            return false;
        }
        this.a.add(t5Var);
        return true;
    }

    public String toString() {
        Iterator<t5> it;
        StringBuilder sb = new StringBuilder();
        int i = this.c;
        sb.append(i == 0 ? "Horizontal" : i == 1 ? "Vertical" : i == 2 ? "Both" : "Unknown");
        sb.append(" [");
        sb.append(this.b);
        sb.append("] <");
        String sb2 = sb.toString();
        while (this.a.iterator().hasNext()) {
            sb2 = sb2 + " " + it.next().k0;
        }
        return jg.a(sb2, " >");
    }

    public void a(int i, o6 o6Var) {
        Iterator<t5> it = this.a.iterator();
        while (it.hasNext()) {
            t5 next = it.next();
            o6Var.a(next);
            if (i == 0) {
                next.r0 = o6Var.b;
            } else {
                next.s0 = o6Var.b;
            }
        }
        this.e = o6Var.b;
    }

    public int a(k5 k5Var, int i) {
        int b;
        int b2;
        if (this.a.size() == 0) {
            return 0;
        }
        ArrayList<t5> arrayList = this.a;
        u5 u5Var = (u5) arrayList.get(0).W;
        k5Var.g();
        u5Var.a(k5Var, false);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList.get(i2).a(k5Var, false);
        }
        if (i == 0 && u5Var.D0 > 0) {
            defpackage.a.a(u5Var, k5Var, arrayList, 0);
        }
        if (i == 1 && u5Var.E0 > 0) {
            defpackage.a.a(u5Var, k5Var, arrayList, 1);
        }
        try {
            k5Var.e();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.d = new ArrayList<>();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            this.d.add(new a(this, arrayList.get(i3), k5Var, i));
        }
        if (i == 0) {
            b = k5Var.b(u5Var.K);
            b2 = k5Var.b(u5Var.M);
            k5Var.g();
        } else {
            b = k5Var.b(u5Var.L);
            b2 = k5Var.b(u5Var.N);
            k5Var.g();
        }
        return b2 - b;
    }

    public void a(ArrayList<o6> arrayList) {
        int size = this.a.size();
        if (this.e != -1 && size > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                o6 o6Var = arrayList.get(i);
                if (this.e == o6Var.b) {
                    a(this.c, o6Var);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }
}
