package defpackage;

import android.graphics.Rect;
import android.view.View;
import androidx.fragment.app.Fragment;
/* compiled from: FragmentTransition.java */
/* renamed from: cd  reason: default package */
/* loaded from: classes.dex */
public class cd implements Runnable {
    public final /* synthetic */ Fragment c;
    public final /* synthetic */ Fragment d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ y4 f;
    public final /* synthetic */ View g;
    public final /* synthetic */ gd h;
    public final /* synthetic */ Rect i;

    public cd(Fragment fragment, Fragment fragment2, boolean z, y4 y4Var, View view, gd gdVar, Rect rect) {
        this.c = fragment;
        this.d = fragment2;
        this.e = z;
        this.f = y4Var;
        this.g = view;
        this.h = gdVar;
        this.i = rect;
    }

    @Override // java.lang.Runnable
    public void run() {
        ed.a(this.c, this.d, this.e, (y4<String, View>) this.f, false);
        View view = this.g;
        if (view != null) {
            this.h.a(view, this.i);
        }
    }
}
