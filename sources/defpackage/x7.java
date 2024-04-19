package defpackage;

import android.graphics.Insets;
import android.graphics.Rect;
/* compiled from: Insets.java */
/* renamed from: x7  reason: default package */
/* loaded from: classes.dex */
public final class x7 {
    public static final x7 e = new x7(0, 0, 0, 0);
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    public x7(int i, int i2, int i3, int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public static x7 a(int i, int i2, int i3, int i4) {
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            return e;
        }
        return new x7(i, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || x7.class != obj.getClass()) {
            return false;
        }
        x7 x7Var = (x7) obj;
        return this.d == x7Var.d && this.a == x7Var.a && this.c == x7Var.c && this.b == x7Var.b;
    }

    public int hashCode() {
        return (((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d;
    }

    public String toString() {
        StringBuilder a = jg.a("Insets{left=");
        a.append(this.a);
        a.append(", top=");
        a.append(this.b);
        a.append(", right=");
        a.append(this.c);
        a.append(", bottom=");
        a.append(this.d);
        a.append('}');
        return a.toString();
    }

    public static x7 a(Rect rect) {
        return a(rect.left, rect.top, rect.right, rect.bottom);
    }

    public Insets a() {
        return Insets.of(this.a, this.b, this.c, this.d);
    }
}
