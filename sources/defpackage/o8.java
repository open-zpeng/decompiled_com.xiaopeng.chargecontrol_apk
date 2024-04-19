package defpackage;

import android.graphics.Typeface;
/* compiled from: CallbackWithHandler.java */
/* renamed from: o8  reason: default package */
/* loaded from: classes.dex */
public class o8 implements Runnable {
    public final /* synthetic */ x8 c;
    public final /* synthetic */ Typeface d;

    public o8(q8 q8Var, x8 x8Var, Typeface typeface) {
        this.c = x8Var;
        this.d = typeface;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.a(this.d);
    }
}
