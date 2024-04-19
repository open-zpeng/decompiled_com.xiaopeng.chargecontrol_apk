package defpackage;

import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: ViewPropertyAnimatorCompatSet.java */
/* renamed from: r1  reason: default package */
/* loaded from: classes.dex */
public class r1 {
    public Interpolator c;
    public ga d;
    public boolean e;
    public long b = -1;
    public final ha f = new a();
    public final ArrayList<fa> a = new ArrayList<>();

    /* compiled from: ViewPropertyAnimatorCompatSet.java */
    /* renamed from: r1$a */
    /* loaded from: classes.dex */
    public class a extends ha {
        public boolean a = false;
        public int b = 0;

        public a() {
        }

        @Override // defpackage.ga
        public void b(View view) {
            int i = this.b + 1;
            this.b = i;
            if (i == r1.this.a.size()) {
                ga gaVar = r1.this.d;
                if (gaVar != null) {
                    gaVar.b(null);
                }
                this.b = 0;
                this.a = false;
                r1.this.e = false;
            }
        }

        @Override // defpackage.ha, defpackage.ga
        public void c(View view) {
            if (this.a) {
                return;
            }
            this.a = true;
            ga gaVar = r1.this.d;
            if (gaVar != null) {
                gaVar.c(null);
            }
        }
    }

    public void a() {
        if (this.e) {
            Iterator<fa> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            this.e = false;
        }
    }

    public void b() {
        View view;
        if (this.e) {
            return;
        }
        Iterator<fa> it = this.a.iterator();
        while (it.hasNext()) {
            fa next = it.next();
            long j = this.b;
            if (j >= 0) {
                next.a(j);
            }
            Interpolator interpolator = this.c;
            if (interpolator != null && (view = next.a.get()) != null) {
                view.animate().setInterpolator(interpolator);
            }
            if (this.d != null) {
                next.a(this.f);
            }
            View view2 = next.a.get();
            if (view2 != null) {
                view2.animate().start();
            }
        }
        this.e = true;
    }
}
