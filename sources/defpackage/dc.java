package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.fragment.app.Fragment;
import defpackage.ed;
import defpackage.oc;
/* compiled from: FragmentAnim.java */
/* renamed from: dc  reason: default package */
/* loaded from: classes.dex */
public class dc implements Animation.AnimationListener {
    public final /* synthetic */ ViewGroup a;
    public final /* synthetic */ Fragment b;
    public final /* synthetic */ ed.a c;
    public final /* synthetic */ m8 d;

    /* compiled from: FragmentAnim.java */
    /* renamed from: dc$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (dc.this.b.Q() != null) {
                dc.this.b.a((View) null);
                dc dcVar = dc.this;
                ((oc.d) dcVar.c).a(dcVar.b, dcVar.d);
            }
        }
    }

    public dc(ViewGroup viewGroup, Fragment fragment, ed.a aVar, m8 m8Var) {
        this.a = viewGroup;
        this.b = fragment;
        this.c = aVar;
        this.d = m8Var;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        this.a.post(new a());
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
    }
}
