package defpackage;

import android.animation.Animator;
import android.view.View;
import androidx.fragment.app.Fragment;
import defpackage.m8;
/* compiled from: FragmentAnim.java */
/* renamed from: cc  reason: default package */
/* loaded from: classes.dex */
public class cc implements m8.a {
    public final /* synthetic */ Fragment a;

    public cc(Fragment fragment) {
        this.a = fragment;
    }

    @Override // defpackage.m8.a
    public void a() {
        if (this.a.Q() != null) {
            View Q = this.a.Q();
            this.a.a((View) null);
            Q.clearAnimation();
        }
        this.a.a((Animator) null);
    }
}
