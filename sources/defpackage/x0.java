package defpackage;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import defpackage.ja;
/* compiled from: AppCompatDelegateImpl.java */
/* renamed from: x0  reason: default package */
/* loaded from: classes.dex */
public class x0 implements s9 {
    public final /* synthetic */ w0 a;

    public x0(w0 w0Var) {
        this.a = w0Var;
    }

    public ja a(View view, ja jaVar) {
        ja.e bVar;
        int d = jaVar.d();
        int a = this.a.a(jaVar, (Rect) null);
        if (d != a) {
            int b = jaVar.b();
            int c = jaVar.c();
            int a2 = jaVar.a();
            int i = Build.VERSION.SDK_INT;
            if (i >= 30) {
                bVar = new ja.d(jaVar);
            } else if (i >= 29) {
                bVar = new ja.c(jaVar);
            } else {
                bVar = new ja.b(jaVar);
            }
            bVar.d(x7.a(b, a, c, a2));
            jaVar = bVar.b();
        }
        return y9.b(view, jaVar);
    }
}
