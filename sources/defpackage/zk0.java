package defpackage;
/* compiled from: Buffer.java */
/* renamed from: zk0  reason: default package */
/* loaded from: classes.dex */
public final class zk0 implements bl0, al0, Cloneable {
    public dl0 c;
    public long d;

    public Object clone() {
        zk0 zk0Var = new zk0();
        if (this.d != 0) {
            zk0Var.c = new dl0(this.c);
            dl0 dl0Var = zk0Var.c;
            dl0Var.g = dl0Var;
            dl0Var.f = dl0Var;
            dl0 dl0Var2 = this.c;
            while (true) {
                dl0Var2 = dl0Var2.f;
                if (dl0Var2 == this.c) {
                    break;
                }
                zk0Var.c.g.a(new dl0(dl0Var2));
            }
            zk0Var.d = this.d;
        }
        return zk0Var;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zk0) {
            zk0 zk0Var = (zk0) obj;
            long j = this.d;
            if (j != zk0Var.d) {
                return false;
            }
            long j2 = 0;
            if (j == 0) {
                return true;
            }
            dl0 dl0Var = this.c;
            dl0 dl0Var2 = zk0Var.c;
            int i = dl0Var.b;
            int i2 = dl0Var2.b;
            while (j2 < this.d) {
                long min = Math.min(dl0Var.c - i, dl0Var2.c - i2);
                int i3 = i2;
                int i4 = i;
                int i5 = 0;
                while (i5 < min) {
                    int i6 = i4 + 1;
                    int i7 = i3 + 1;
                    if (dl0Var.a[i4] != dl0Var2.a[i3]) {
                        return false;
                    }
                    i5++;
                    i4 = i6;
                    i3 = i7;
                }
                if (i4 == dl0Var.c) {
                    dl0Var = dl0Var.f;
                    i = dl0Var.b;
                } else {
                    i = i4;
                }
                if (i3 == dl0Var2.c) {
                    dl0Var2 = dl0Var2.f;
                    i2 = dl0Var2.b;
                } else {
                    i2 = i3;
                }
                j2 += min;
            }
            return true;
        }
        return false;
    }

    @Override // java.io.Flushable
    public void flush() {
    }

    public int hashCode() {
        dl0 dl0Var = this.c;
        if (dl0Var == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = dl0Var.c;
            for (int i3 = dl0Var.b; i3 < i2; i3++) {
                i = (i * 31) + dl0Var.a[i3];
            }
            dl0Var = dl0Var.f;
        } while (dl0Var != this.c);
        return i;
    }

    public String toString() {
        cl0 fl0Var;
        long j = this.d;
        if (j <= 2147483647L) {
            int i = (int) j;
            if (i == 0) {
                fl0Var = cl0.g;
            } else {
                fl0Var = new fl0(this, i);
            }
            return fl0Var.toString();
        }
        StringBuilder a = jg.a("size > Integer.MAX_VALUE: ");
        a.append(this.d);
        throw new IllegalArgumentException(a.toString());
    }
}
