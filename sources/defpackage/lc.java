package defpackage;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
/* compiled from: FragmentHostCallback.java */
/* renamed from: lc  reason: default package */
/* loaded from: classes.dex */
public abstract class lc<E> extends hc {
    public final Activity c;
    public final Context d;
    public final Handler e;
    public final oc f;

    public lc(bc bcVar) {
        Handler handler = new Handler();
        this.f = new pc();
        this.c = bcVar;
        a.a(bcVar, (Object) "context == null");
        this.d = bcVar;
        a.a(handler, (Object) "handler == null");
        this.e = handler;
    }
}
