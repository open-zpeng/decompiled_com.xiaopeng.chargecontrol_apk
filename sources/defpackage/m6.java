package defpackage;

import java.util.ArrayList;
/* compiled from: RunGroup.java */
/* renamed from: m6  reason: default package */
/* loaded from: classes.dex */
public class m6 {
    public static int d;
    public boolean a;
    public p6 b;
    public ArrayList<p6> c = new ArrayList<>();

    public m6(p6 p6Var, int i) {
        this.b = null;
        d++;
        this.b = p6Var;
    }

    public final long a(g6 g6Var, long j) {
        p6 p6Var = g6Var.d;
        if (p6Var instanceof k6) {
            return j;
        }
        int size = g6Var.k.size();
        long j2 = j;
        for (int i = 0; i < size; i++) {
            e6 e6Var = g6Var.k.get(i);
            if (e6Var instanceof g6) {
                g6 g6Var2 = (g6) e6Var;
                if (g6Var2.d != p6Var) {
                    j2 = Math.min(j2, a(g6Var2, g6Var2.f + j));
                }
            }
        }
        if (g6Var == p6Var.i) {
            long d2 = j - p6Var.d();
            return Math.min(Math.min(j2, a(p6Var.h, d2)), d2 - p6Var.h.f);
        }
        return j2;
    }

    public final long b(g6 g6Var, long j) {
        p6 p6Var = g6Var.d;
        if (p6Var instanceof k6) {
            return j;
        }
        int size = g6Var.k.size();
        long j2 = j;
        for (int i = 0; i < size; i++) {
            e6 e6Var = g6Var.k.get(i);
            if (e6Var instanceof g6) {
                g6 g6Var2 = (g6) e6Var;
                if (g6Var2.d != p6Var) {
                    j2 = Math.max(j2, b(g6Var2, g6Var2.f + j));
                }
            }
        }
        if (g6Var == p6Var.h) {
            long d2 = j + p6Var.d();
            return Math.max(Math.max(j2, b(p6Var.i, d2)), d2 - p6Var.i.f);
        }
        return j2;
    }
}
