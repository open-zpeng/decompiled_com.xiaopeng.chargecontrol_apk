package defpackage;

import android.graphics.Rect;
import android.view.View;
import androidx.fragment.app.Fragment;
import defpackage.ed;
import java.util.ArrayList;
/* compiled from: FragmentTransition.java */
/* renamed from: dd  reason: default package */
/* loaded from: classes.dex */
public class dd implements Runnable {
    public final /* synthetic */ gd c;
    public final /* synthetic */ y4 d;
    public final /* synthetic */ Object e;
    public final /* synthetic */ ed.b f;
    public final /* synthetic */ ArrayList g;
    public final /* synthetic */ View h;
    public final /* synthetic */ Fragment i;
    public final /* synthetic */ Fragment j;
    public final /* synthetic */ boolean k;
    public final /* synthetic */ ArrayList l;
    public final /* synthetic */ Object m;
    public final /* synthetic */ Rect n;

    public dd(gd gdVar, y4 y4Var, Object obj, ed.b bVar, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean z, ArrayList arrayList2, Object obj2, Rect rect) {
        this.c = gdVar;
        this.d = y4Var;
        this.e = obj;
        this.f = bVar;
        this.g = arrayList;
        this.h = view;
        this.i = fragment;
        this.j = fragment2;
        this.k = z;
        this.l = arrayList2;
        this.m = obj2;
        this.n = rect;
    }

    @Override // java.lang.Runnable
    public void run() {
        y4<String, View> a = ed.a(this.c, this.d, this.e, this.f);
        if (a != null) {
            this.g.addAll(a.values());
            this.g.add(this.h);
        }
        ed.a(this.i, this.j, this.k, a, false);
        Object obj = this.e;
        if (obj != null) {
            this.c.b(obj, this.l, this.g);
            View a2 = ed.a(a, this.f, this.m, this.k);
            if (a2 != null) {
                this.c.a(a2, this.n);
            }
        }
    }
}
