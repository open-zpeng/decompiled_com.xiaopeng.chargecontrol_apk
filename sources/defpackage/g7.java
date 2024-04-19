package defpackage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import defpackage.vd;
/* compiled from: ComponentActivity.java */
/* renamed from: g7  reason: default package */
/* loaded from: classes.dex */
public class g7 extends Activity implements zd, j9 {
    public ae c;

    public g7() {
        int[] iArr = b5.a;
        Object[] objArr = b5.c;
        this.c = new ae(this);
    }

    @Override // defpackage.j9
    public boolean a(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView != null) {
            y9.a(decorView, keyEvent);
        }
        int i = Build.VERSION.SDK_INT;
        return a(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView != null) {
            y9.a(decorView, keyEvent);
        }
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    @Override // android.app.Activity
    @SuppressLint({"RestrictedApi"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ie.b(this);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        ae aeVar = this.c;
        vd.b bVar = vd.b.CREATED;
        aeVar.a("markState");
        aeVar.a("setCurrentState");
        aeVar.a(bVar);
        super.onSaveInstanceState(bundle);
    }
}
