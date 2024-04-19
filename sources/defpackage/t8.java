package defpackage;

import android.content.Context;
import defpackage.u8;
import java.util.concurrent.Callable;
/* compiled from: FontRequestWorker.java */
/* renamed from: t8  reason: default package */
/* loaded from: classes.dex */
public class t8 implements Callable<u8.d> {
    public final /* synthetic */ String c;
    public final /* synthetic */ Context d;
    public final /* synthetic */ s8 e;
    public final /* synthetic */ int f;

    public t8(String str, Context context, s8 s8Var, int i) {
        this.c = str;
        this.d = context;
        this.e = s8Var;
        this.f = i;
    }

    @Override // java.util.concurrent.Callable
    public u8.d call() {
        return u8.a(this.c, this.d, this.e, this.f);
    }
}
