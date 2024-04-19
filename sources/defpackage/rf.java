package defpackage;

import android.view.View;
/* compiled from: ViewBoundsCheck.java */
/* renamed from: rf  reason: default package */
/* loaded from: classes.dex */
public class rf {
    public final b a;
    public a b = new a();

    /* compiled from: ViewBoundsCheck.java */
    /* renamed from: rf$a */
    /* loaded from: classes.dex */
    public static class a {
        public int a = 0;
        public int b;
        public int c;
        public int d;
        public int e;

        public int a(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }

        public boolean a() {
            int i = this.a;
            if ((i & 7) == 0 || (i & (a(this.d, this.b) << 0)) != 0) {
                int i2 = this.a;
                if ((i2 & 112) == 0 || (i2 & (a(this.d, this.c) << 4)) != 0) {
                    int i3 = this.a;
                    if ((i3 & 1792) == 0 || (i3 & (a(this.e, this.b) << 8)) != 0) {
                        int i4 = this.a;
                        return (i4 & 28672) == 0 || (i4 & (a(this.e, this.c) << 12)) != 0;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
    }

    /* compiled from: ViewBoundsCheck.java */
    /* renamed from: rf$b */
    /* loaded from: classes.dex */
    public interface b {
        int a();

        int a(View view);

        View a(int i);

        int b();

        int b(View view);
    }

    public rf(b bVar) {
        this.a = bVar;
    }

    public View a(int i, int i2, int i3, int i4) {
        int b2 = this.a.b();
        int a2 = this.a.a();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View a3 = this.a.a(i);
            int a4 = this.a.a(a3);
            int b3 = this.a.b(a3);
            a aVar = this.b;
            aVar.b = b2;
            aVar.c = a2;
            aVar.d = a4;
            aVar.e = b3;
            if (i3 != 0) {
                aVar.a = 0;
                aVar.a |= i3;
                if (aVar.a()) {
                    return a3;
                }
            }
            if (i4 != 0) {
                a aVar2 = this.b;
                aVar2.a = 0;
                aVar2.a |= i4;
                if (aVar2.a()) {
                    view = a3;
                }
            }
            i += i5;
        }
        return view;
    }

    public boolean a(View view, int i) {
        a aVar = this.b;
        int b2 = this.a.b();
        int a2 = this.a.a();
        int a3 = this.a.a(view);
        int b3 = this.a.b(view);
        aVar.b = b2;
        aVar.c = a2;
        aVar.d = a3;
        aVar.e = b3;
        if (i != 0) {
            a aVar2 = this.b;
            aVar2.a = 0;
            aVar2.a |= i;
            return aVar2.a();
        }
        return false;
    }
}
