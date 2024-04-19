package defpackage;

import java.util.ArrayList;
import java.util.List;
/* compiled from: DependencyNode.java */
/* renamed from: g6  reason: default package */
/* loaded from: classes.dex */
public class g6 implements e6 {
    public p6 d;
    public int f;
    public int g;
    public e6 a = null;
    public boolean b = false;
    public boolean c = false;
    public a e = a.UNKNOWN;
    public int h = 1;
    public h6 i = null;
    public boolean j = false;
    public List<e6> k = new ArrayList();
    public List<g6> l = new ArrayList();

    /* compiled from: DependencyNode.java */
    /* renamed from: g6$a */
    /* loaded from: classes.dex */
    public enum a {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public g6(p6 p6Var) {
        this.d = p6Var;
    }

    public void a(int i) {
        if (this.j) {
            return;
        }
        this.j = true;
        this.g = i;
        for (e6 e6Var : this.k) {
            e6Var.a(e6Var);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.d.b.k0);
        sb.append(":");
        sb.append(this.e);
        sb.append("(");
        sb.append(this.j ? Integer.valueOf(this.g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.l.size());
        sb.append(":d=");
        sb.append(this.k.size());
        sb.append(">");
        return sb.toString();
    }

    @Override // defpackage.e6
    public void a(e6 e6Var) {
        for (g6 g6Var : this.l) {
            if (!g6Var.j) {
                return;
            }
        }
        this.c = true;
        e6 e6Var2 = this.a;
        if (e6Var2 != null) {
            e6Var2.a(this);
        }
        if (this.b) {
            this.d.a(this);
            return;
        }
        g6 g6Var2 = null;
        int i = 0;
        for (g6 g6Var3 : this.l) {
            if (!(g6Var3 instanceof h6)) {
                i++;
                g6Var2 = g6Var3;
            }
        }
        if (g6Var2 != null && i == 1 && g6Var2.j) {
            h6 h6Var = this.i;
            if (h6Var != null) {
                if (!h6Var.j) {
                    return;
                }
                this.f = this.h * h6Var.g;
            }
            a(g6Var2.g + this.f);
        }
        e6 e6Var3 = this.a;
        if (e6Var3 != null) {
            e6Var3.a(this);
        }
    }

    public void a() {
        this.l.clear();
        this.k.clear();
        this.j = false;
        this.g = 0;
        this.c = false;
        this.b = false;
    }
}
