package defpackage;

import android.view.View;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
/* compiled from: FragmentTransition.java */
/* renamed from: bd  reason: default package */
/* loaded from: classes.dex */
public class bd implements Runnable {
    public final /* synthetic */ Object c;
    public final /* synthetic */ gd d;
    public final /* synthetic */ View e;
    public final /* synthetic */ Fragment f;
    public final /* synthetic */ ArrayList g;
    public final /* synthetic */ ArrayList h;
    public final /* synthetic */ ArrayList i;
    public final /* synthetic */ Object j;

    public bd(Object obj, gd gdVar, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
        this.c = obj;
        this.d = gdVar;
        this.e = view;
        this.f = fragment;
        this.g = arrayList;
        this.h = arrayList2;
        this.i = arrayList3;
        this.j = obj2;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj = this.c;
        if (obj != null) {
            this.d.b(obj, this.e);
            this.h.addAll(ed.a(this.d, this.c, this.f, this.g, this.e));
        }
        if (this.i != null) {
            if (this.j != null) {
                ArrayList<View> arrayList = new ArrayList<>();
                arrayList.add(this.e);
                this.d.a(this.j, this.i, arrayList);
            }
            this.i.clear();
            this.i.add(this.e);
        }
    }
}
