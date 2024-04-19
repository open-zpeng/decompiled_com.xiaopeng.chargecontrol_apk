package defpackage;

import android.view.View;
import android.view.ViewGroup;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IRadioController;
import defpackage.nf;
import java.util.ArrayList;
import java.util.List;
/* compiled from: ChildHelper.java */
/* renamed from: ye  reason: default package */
/* loaded from: classes.dex */
public class ye {
    public final b a;
    public final a b = new a();
    public final List<View> c = new ArrayList();

    /* compiled from: ChildHelper.java */
    /* renamed from: ye$b */
    /* loaded from: classes.dex */
    public interface b {
    }

    public ye(b bVar) {
        this.a = bVar;
    }

    public void a(View view, int i, boolean z) {
        int c;
        if (i < 0) {
            c = ((of) this.a).a();
        } else {
            c = c(i);
        }
        this.b.a(c, z);
        if (z) {
            this.c.add(view);
            ((of) this.a).b(view);
        }
        of ofVar = (of) this.a;
        ofVar.a.addView(view, c);
        ofVar.a.b(view);
    }

    public View b(int i) {
        return ((of) this.a).a(c(i));
    }

    public final boolean c(View view) {
        if (this.c.remove(view)) {
            ((of) this.a).c(view);
            return true;
        }
        return false;
    }

    public View d(int i) {
        return ((of) this.a).a.getChildAt(i);
    }

    public String toString() {
        return this.b.toString() + ", hidden list:" + this.c.size();
    }

    /* compiled from: ChildHelper.java */
    /* renamed from: ye$a */
    /* loaded from: classes.dex */
    public static class a {
        public long a = 0;
        public a b;

        public final void a() {
            if (this.b == null) {
                this.b = new a();
            }
        }

        public void b() {
            this.a = 0L;
            a aVar = this.b;
            if (aVar != null) {
                aVar.b();
            }
        }

        public boolean c(int i) {
            if (i < 64) {
                return (this.a & (1 << i)) != 0;
            }
            a();
            return this.b.c(i - 64);
        }

        public boolean d(int i) {
            if (i >= 64) {
                a();
                return this.b.d(i - 64);
            }
            long j = 1 << i;
            boolean z = (this.a & j) != 0;
            this.a &= ~j;
            long j2 = j - 1;
            long j3 = this.a;
            this.a = Long.rotateRight(j3 & (~j2), 1) | (j3 & j2);
            a aVar = this.b;
            if (aVar != null) {
                if (aVar.c(0)) {
                    e(63);
                }
                this.b.d(0);
            }
            return z;
        }

        public void e(int i) {
            if (i >= 64) {
                a();
                this.b.e(i - 64);
                return;
            }
            this.a |= 1 << i;
        }

        public String toString() {
            if (this.b == null) {
                return Long.toBinaryString(this.a);
            }
            return this.b.toString() + "xx" + Long.toBinaryString(this.a);
        }

        public void a(int i) {
            if (i >= 64) {
                a aVar = this.b;
                if (aVar != null) {
                    aVar.a(i - 64);
                    return;
                }
                return;
            }
            this.a &= ~(1 << i);
        }

        public int b(int i) {
            a aVar = this.b;
            if (aVar == null) {
                if (i >= 64) {
                    return Long.bitCount(this.a);
                }
                return Long.bitCount(this.a & ((1 << i) - 1));
            } else if (i < 64) {
                return Long.bitCount(this.a & ((1 << i) - 1));
            } else {
                return Long.bitCount(this.a) + aVar.b(i - 64);
            }
        }

        public void a(int i, boolean z) {
            if (i >= 64) {
                a();
                this.b.a(i - 64, z);
                return;
            }
            boolean z2 = (this.a & Long.MIN_VALUE) != 0;
            long j = (1 << i) - 1;
            long j2 = this.a;
            this.a = ((j2 & (~j)) << 1) | (j2 & j);
            if (z) {
                e(i);
            } else {
                a(i);
            }
            if (z2 || this.b != null) {
                a();
                this.b.a(0, z2);
            }
        }
    }

    public int b() {
        return ((of) this.a).a();
    }

    public final int c(int i) {
        if (i < 0) {
            return -1;
        }
        int a2 = ((of) this.a).a();
        int i2 = i;
        while (i2 < a2) {
            int b2 = i - (i2 - this.b.b(i2));
            if (b2 == 0) {
                while (this.b.c(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += b2;
        }
        return -1;
    }

    public boolean b(View view) {
        return this.c.contains(view);
    }

    public void a(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int c;
        if (i < 0) {
            c = ((of) this.a).a();
        } else {
            c = c(i);
        }
        this.b.a(c, z);
        if (z) {
            this.c.add(view);
            ((of) this.a).b(view);
        }
        ((of) this.a).a(view, c, layoutParams);
    }

    public int a() {
        return ((of) this.a).a() - this.c.size();
    }

    public void a(int i) {
        nf.c0 l;
        int c = c(i);
        this.b.d(c);
        of ofVar = (of) this.a;
        View childAt = ofVar.a.getChildAt(c);
        if (childAt != null && (l = nf.l(childAt)) != null) {
            if (l.l() && !l.o()) {
                StringBuilder sb = new StringBuilder();
                sb.append("called detach on an already detached child ");
                sb.append(l);
                throw new IllegalArgumentException(jg.a(ofVar.a, sb));
            }
            l.a(IRadioController.TEF663x_PCHANNEL);
        }
        ofVar.a.detachViewFromParent(c);
    }

    public int a(View view) {
        int indexOfChild = ((of) this.a).a.indexOfChild(view);
        if (indexOfChild == -1 || this.b.c(indexOfChild)) {
            return -1;
        }
        return indexOfChild - this.b.b(indexOfChild);
    }
}
