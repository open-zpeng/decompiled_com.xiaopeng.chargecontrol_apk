package defpackage;

import defpackage.jf;
import defpackage.nf;
import java.util.ArrayList;
import java.util.List;
/* compiled from: AdapterHelper.java */
/* renamed from: xe  reason: default package */
/* loaded from: classes.dex */
public final class xe implements jf.a {
    public final a d;
    public Runnable e;
    public c9<b> a = new d9(30);
    public final ArrayList<b> b = new ArrayList<>();
    public final ArrayList<b> c = new ArrayList<>();
    public int h = 0;
    public final boolean f = false;
    public final jf g = new jf(this);

    /* compiled from: AdapterHelper.java */
    /* renamed from: xe$a */
    /* loaded from: classes.dex */
    public interface a {
    }

    /* compiled from: AdapterHelper.java */
    /* renamed from: xe$b */
    /* loaded from: classes.dex */
    public static final class b {
        public int a;
        public int b;
        public Object c;
        public int d;

        public b(int i, int i2, int i3, Object obj) {
            this.a = i;
            this.b = i2;
            this.d = i3;
            this.c = obj;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                b bVar = (b) obj;
                int i = this.a;
                if (i != bVar.a) {
                    return false;
                }
                if (i == 8 && Math.abs(this.d - this.b) == 1 && this.d == bVar.b && this.b == bVar.d) {
                    return true;
                }
                if (this.d == bVar.d && this.b == bVar.b) {
                    Object obj2 = this.c;
                    if (obj2 != null) {
                        if (!obj2.equals(bVar.c)) {
                            return false;
                        }
                    } else if (bVar.c != null) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            return (((this.a * 31) + this.b) * 31) + this.d;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append("[");
            int i = this.a;
            sb.append(i != 1 ? i != 2 ? i != 4 ? i != 8 ? "??" : "mv" : "up" : "rm" : "add");
            sb.append(",s:");
            sb.append(this.b);
            sb.append("c:");
            sb.append(this.d);
            sb.append(",p:");
            sb.append(this.c);
            sb.append("]");
            return sb.toString();
        }
    }

    public xe(a aVar) {
        this.d = aVar;
    }

    public void a() {
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            ((nf.e) this.d).a(this.c.get(i));
        }
        a(this.c);
        this.h = 0;
    }

    public final int b(int i, int i2) {
        for (int size = this.c.size() - 1; size >= 0; size--) {
            b bVar = this.c.get(size);
            int i3 = bVar.a;
            if (i3 == 8) {
                int i4 = bVar.b;
                int i5 = bVar.d;
                if (i4 >= i5) {
                    i5 = i4;
                    i4 = i5;
                }
                if (i >= i4 && i <= i5) {
                    int i6 = bVar.b;
                    if (i4 == i6) {
                        if (i2 == 1) {
                            bVar.d++;
                        } else if (i2 == 2) {
                            bVar.d--;
                        }
                        i++;
                    } else {
                        if (i2 == 1) {
                            bVar.b = i6 + 1;
                        } else if (i2 == 2) {
                            bVar.b = i6 - 1;
                        }
                        i--;
                    }
                } else {
                    int i7 = bVar.b;
                    if (i < i7) {
                        if (i2 == 1) {
                            bVar.b = i7 + 1;
                            bVar.d++;
                        } else if (i2 == 2) {
                            bVar.b = i7 - 1;
                            bVar.d--;
                        }
                    }
                }
            } else {
                int i8 = bVar.b;
                if (i8 <= i) {
                    if (i3 == 1) {
                        i -= bVar.d;
                    } else if (i3 == 2) {
                        i += bVar.d;
                    }
                } else if (i2 == 1) {
                    bVar.b = i8 + 1;
                } else if (i2 == 2) {
                    bVar.b = i8 - 1;
                }
            }
        }
        for (int size2 = this.c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = this.c.get(size2);
            if (bVar2.a == 8) {
                int i9 = bVar2.d;
                if (i9 == bVar2.b || i9 < 0) {
                    this.c.remove(size2);
                    if (!this.f) {
                        bVar2.c = null;
                        this.a.a(bVar2);
                    }
                }
            } else if (bVar2.d <= 0) {
                this.c.remove(size2);
                if (!this.f) {
                    bVar2.c = null;
                    this.a.a(bVar2);
                }
            }
        }
        return i;
    }

    public boolean c() {
        return this.b.size() > 0;
    }

    public void d() {
        boolean z;
        boolean z2;
        this.g.a(this.b);
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.b.get(i);
            int i2 = bVar.a;
            if (i2 == 1) {
                b(bVar);
            } else if (i2 == 2) {
                int i3 = bVar.b;
                int i4 = bVar.d + i3;
                int i5 = 0;
                boolean z3 = true;
                int i6 = i3;
                while (i6 < i4) {
                    if (((nf.e) this.d).a(i6) != null || a(i6)) {
                        if (z3) {
                            z = false;
                        } else {
                            a(a(2, i3, i5, null));
                            z = true;
                        }
                        z2 = true;
                    } else {
                        if (z3) {
                            b(a(2, i3, i5, null));
                            z = true;
                        } else {
                            z = false;
                        }
                        z2 = false;
                    }
                    if (z) {
                        i6 -= i5;
                        i4 -= i5;
                        i5 = 1;
                    } else {
                        i5++;
                    }
                    i6++;
                    z3 = z2;
                }
                if (i5 != bVar.d) {
                    if (!this.f) {
                        bVar.c = null;
                        this.a.a(bVar);
                    }
                    bVar = a(2, i3, i5, null);
                }
                if (!z3) {
                    a(bVar);
                } else {
                    b(bVar);
                }
            } else if (i2 == 4) {
                int i7 = bVar.b;
                int i8 = bVar.d + i7;
                int i9 = i7;
                boolean z4 = true;
                int i10 = 0;
                while (i7 < i8) {
                    if (((nf.e) this.d).a(i7) != null || a(i7)) {
                        if (!z4) {
                            a(a(4, i9, i10, bVar.c));
                            i10 = 0;
                            i9 = i7;
                        }
                        z4 = true;
                    } else {
                        if (z4) {
                            b(a(4, i9, i10, bVar.c));
                            i10 = 0;
                            i9 = i7;
                        }
                        z4 = false;
                    }
                    i10++;
                    i7++;
                }
                if (i10 != bVar.d) {
                    Object obj = bVar.c;
                    if (!this.f) {
                        bVar.c = null;
                        this.a.a(bVar);
                    }
                    bVar = a(4, i9, i10, obj);
                }
                if (!z4) {
                    a(bVar);
                } else {
                    b(bVar);
                }
            } else if (i2 == 8) {
                b(bVar);
            }
            Runnable runnable = this.e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.b.clear();
    }

    public void e() {
        a(this.b);
        a(this.c);
        this.h = 0;
    }

    public void c(b bVar) {
        if (this.f) {
            return;
        }
        bVar.c = null;
        this.a.a(bVar);
    }

    public final void a(b bVar) {
        int i;
        int i2 = bVar.a;
        if (i2 != 1 && i2 != 8) {
            int b2 = b(bVar.b, i2);
            int i3 = bVar.b;
            int i4 = bVar.a;
            if (i4 == 2) {
                i = 0;
            } else if (i4 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + bVar);
            } else {
                i = 1;
            }
            int i5 = b2;
            int i6 = i3;
            int i7 = 1;
            for (int i8 = 1; i8 < bVar.d; i8++) {
                int b3 = b((i * i8) + bVar.b, bVar.a);
                int i9 = bVar.a;
                if (i9 == 2 ? b3 == i5 : i9 == 4 && b3 == i5 + 1) {
                    i7++;
                } else {
                    b a2 = a(bVar.a, i5, i7, bVar.c);
                    a(a2, i6);
                    if (!this.f) {
                        a2.c = null;
                        this.a.a(a2);
                    }
                    if (bVar.a == 4) {
                        i6 += i7;
                    }
                    i7 = 1;
                    i5 = b3;
                }
            }
            Object obj = bVar.c;
            if (!this.f) {
                bVar.c = null;
                this.a.a(bVar);
            }
            if (i7 > 0) {
                b a3 = a(bVar.a, i5, i7, obj);
                a(a3, i6);
                if (this.f) {
                    return;
                }
                a3.c = null;
                this.a.a(a3);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }

    public void a(b bVar, int i) {
        ((nf.e) this.d).a(bVar);
        int i2 = bVar.a;
        if (i2 != 2) {
            if (i2 == 4) {
                nf.e eVar = (nf.e) this.d;
                nf.this.a(i, bVar.d, bVar.c);
                nf.this.m0 = true;
                return;
            }
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
        a aVar = this.d;
        int i3 = bVar.d;
        nf.e eVar2 = (nf.e) aVar;
        nf.this.a(i, i3, true);
        nf nfVar = nf.this;
        nfVar.l0 = true;
        nfVar.i0.d += i3;
    }

    public final void b(b bVar) {
        this.c.add(bVar);
        int i = bVar.a;
        if (i == 1) {
            a aVar = this.d;
            nf.e eVar = (nf.e) aVar;
            nf.this.f(bVar.b, bVar.d);
            nf.this.l0 = true;
        } else if (i == 2) {
            a aVar2 = this.d;
            nf.e eVar2 = (nf.e) aVar2;
            nf.this.a(bVar.b, bVar.d, false);
            nf.this.l0 = true;
        } else if (i == 4) {
            ((nf.e) this.d).a(bVar.b, bVar.d, bVar.c);
        } else if (i == 8) {
            a aVar3 = this.d;
            nf.e eVar3 = (nf.e) aVar3;
            nf.this.g(bVar.b, bVar.d);
            nf.this.l0 = true;
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    public final boolean a(int i) {
        int size = this.c.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.c.get(i2);
            int i3 = bVar.a;
            if (i3 == 8) {
                if (a(bVar.d, i2 + 1) == i) {
                    return true;
                }
            } else if (i3 == 1) {
                int i4 = bVar.b;
                int i5 = bVar.d + i4;
                while (i4 < i5) {
                    if (a(i4, i2 + 1) == i) {
                        return true;
                    }
                    i4++;
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    public void b() {
        a();
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.b.get(i);
            int i2 = bVar.a;
            if (i2 == 1) {
                ((nf.e) this.d).a(bVar);
                nf.e eVar = (nf.e) this.d;
                nf.this.f(bVar.b, bVar.d);
                nf.this.l0 = true;
            } else if (i2 == 2) {
                ((nf.e) this.d).a(bVar);
                a aVar = this.d;
                int i3 = bVar.b;
                int i4 = bVar.d;
                nf.e eVar2 = (nf.e) aVar;
                nf.this.a(i3, i4, true);
                nf nfVar = nf.this;
                nfVar.l0 = true;
                nfVar.i0.d += i4;
            } else if (i2 == 4) {
                ((nf.e) this.d).a(bVar);
                ((nf.e) this.d).a(bVar.b, bVar.d, bVar.c);
            } else if (i2 == 8) {
                ((nf.e) this.d).a(bVar);
                nf.e eVar3 = (nf.e) this.d;
                nf.this.g(bVar.b, bVar.d);
                nf.this.l0 = true;
            }
            Runnable runnable = this.e;
            if (runnable != null) {
                runnable.run();
            }
        }
        a(this.b);
        this.h = 0;
    }

    public int a(int i, int i2) {
        int size = this.c.size();
        while (i2 < size) {
            b bVar = this.c.get(i2);
            int i3 = bVar.a;
            if (i3 == 8) {
                int i4 = bVar.b;
                if (i4 == i) {
                    i = bVar.d;
                } else {
                    if (i4 < i) {
                        i--;
                    }
                    if (bVar.d <= i) {
                        i++;
                    }
                }
            } else {
                int i5 = bVar.b;
                if (i5 > i) {
                    continue;
                } else if (i3 == 2) {
                    int i6 = bVar.d;
                    if (i < i5 + i6) {
                        return -1;
                    }
                    i -= i6;
                } else if (i3 == 1) {
                    i += bVar.d;
                }
            }
            i2++;
        }
        return i;
    }

    public b a(int i, int i2, int i3, Object obj) {
        b a2 = this.a.a();
        if (a2 == null) {
            return new b(i, i2, i3, obj);
        }
        a2.a = i;
        a2.b = i2;
        a2.d = i3;
        a2.c = obj;
        return a2;
    }

    public void a(List<b> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            c(list.get(i));
        }
        list.clear();
    }
}
