package defpackage;

import android.util.Log;
/* compiled from: RxPlugins.java */
/* renamed from: da0  reason: default package */
/* loaded from: classes.dex */
public class da0 {
    public static final rh0<Throwable> a = new rh0() { // from class: v90
        @Override // defpackage.rh0
        public final void accept(Object obj) {
            Log.w("RxPlugins", "Uncaught exception occurred in RxJava: ", (Throwable) obj);
        }
    };
}
