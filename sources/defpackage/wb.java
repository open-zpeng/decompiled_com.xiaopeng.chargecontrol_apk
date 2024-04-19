package defpackage;

import android.graphics.Rect;
import android.view.View;
/* compiled from: DefaultSpecialEffectsController.java */
/* renamed from: wb  reason: default package */
/* loaded from: classes.dex */
public class wb implements Runnable {
    public final /* synthetic */ gd c;
    public final /* synthetic */ View d;
    public final /* synthetic */ Rect e;

    public wb(qb qbVar, gd gdVar, View view, Rect rect) {
        this.c = gdVar;
        this.d = view;
        this.e = rect;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.a(this.d, this.e);
    }
}
