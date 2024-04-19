package defpackage;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import defpackage.l1;
/* compiled from: AppCompatDialog.java */
/* renamed from: c1  reason: default package */
/* loaded from: classes.dex */
public class c1 extends Dialog implements u0 {
    public v0 c;
    public final j9 d;

    /* compiled from: AppCompatDialog.java */
    /* renamed from: c1$a */
    /* loaded from: classes.dex */
    public class a implements j9 {
        public a() {
        }

        @Override // defpackage.j9
        public boolean a(KeyEvent keyEvent) {
            return c1.this.a(keyEvent);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public c1(android.content.Context r5, int r6) {
        /*
            r4 = this;
            r0 = 1
            if (r6 != 0) goto L14
            android.util.TypedValue r1 = new android.util.TypedValue
            r1.<init>()
            android.content.res.Resources$Theme r2 = r5.getTheme()
            int r3 = defpackage.z.dialogTheme
            r2.resolveAttribute(r3, r1, r0)
            int r1 = r1.resourceId
            goto L15
        L14:
            r1 = r6
        L15:
            r4.<init>(r5, r1)
            c1$a r1 = new c1$a
            r1.<init>()
            r4.d = r1
            v0 r1 = r4.a()
            if (r6 != 0) goto L35
            android.util.TypedValue r6 = new android.util.TypedValue
            r6.<init>()
            android.content.res.Resources$Theme r5 = r5.getTheme()
            int r2 = defpackage.z.dialogTheme
            r5.resolveAttribute(r2, r6, r0)
            int r6 = r6.resourceId
        L35:
            r5 = r1
            w0 r5 = (defpackage.w0) r5
            r5.P = r6
            r5 = 0
            r1.a(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.c1.<init>(android.content.Context, int):void");
    }

    @Override // defpackage.u0
    public l1 a(l1.a aVar) {
        return null;
    }

    public v0 a() {
        if (this.c == null) {
            this.c = v0.a(this, this);
        }
        return this.c;
    }

    @Override // defpackage.u0
    public void a(l1 l1Var) {
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().a(view, layoutParams);
    }

    @Override // defpackage.u0
    public void b(l1 l1Var) {
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        a().c();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        getWindow().getDecorView();
        j9 j9Var = this.d;
        if (j9Var == null) {
            return false;
        }
        int i = Build.VERSION.SDK_INT;
        return j9Var.a(keyEvent);
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i) {
        w0 w0Var = (w0) a();
        w0Var.g();
        return (T) w0Var.g.findViewById(i);
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        a().b();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        a().a();
        super.onCreate(bundle);
        a().a(bundle);
    }

    @Override // android.app.Dialog
    public void onStop() {
        super.onStop();
        w0 w0Var = (w0) a();
        w0Var.M = false;
        w0Var.k();
        j0 j0Var = w0Var.j;
        if (j0Var != null) {
            j0Var.c(false);
        }
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        a().b(i);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        a().a(charSequence);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        a().a(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().b(view, layoutParams);
    }

    @Override // android.app.Dialog
    public void setTitle(int i) {
        super.setTitle(i);
        a().a(getContext().getString(i));
    }

    public boolean a(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }
}
