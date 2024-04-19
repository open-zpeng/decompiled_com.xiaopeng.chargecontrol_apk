package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.xiaopeng.speech.vui.VuiEngine;
import java.util.Collections;
import java.util.List;
/* compiled from: ExDialog.java */
/* renamed from: e10  reason: default package */
/* loaded from: classes.dex */
public class e10 extends ld0 implements ka0 {
    public Context n;
    public boolean o;
    public String p;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public e10(android.content.Context r3, int r4) {
        /*
            r2 = this;
            ld0$a r0 = defpackage.ld0.a.a()
            r1 = 0
            r0.a = r1
            r2.<init>(r3, r4, r0)
            r3 = 1
            r2.o = r3
            java.lang.String r3 = ""
            r2.p = r3
            android.app.Dialog r3 = r2.e
            android.content.Context r3 = r3.getContext()
            r2.n = r3
            r3 = 2008(0x7d8, float:2.814E-42)
            r2.f(r3)
            java.lang.String r3 = "VuiDialog"
            r2.b(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.e10.<init>(android.content.Context, int):void");
    }

    @Override // defpackage.ld0
    public e10 a(int i, md0 md0Var) {
        b((CharSequence) this.n.getString(i));
        a(md0Var);
        return this;
    }

    @Override // defpackage.ld0
    public e10 b(int i) {
        b((CharSequence) this.n.getString(i));
        a((md0) null);
        return this;
    }

    @Override // defpackage.ld0
    public e10 c(int i) {
        super.c(i);
        return this;
    }

    @Override // defpackage.ld0
    public e10 d(int i) {
        ((eg0) this.d.m).e.setText(i);
        return this;
    }

    public e10 e(int i) {
        super.a(i, this.o);
        return this;
    }

    public Resources f() {
        return b().getResources();
    }

    public e10 g(int i) {
        eg0 eg0Var = (eg0) this.d.m;
        eg0Var.d();
        ag0 ag0Var = eg0Var.k;
        ag0Var.d.setText(i);
        ag0Var.u();
        return this;
    }

    @Override // defpackage.ka0
    public String getSceneId() {
        return this.p;
    }

    @Override // defpackage.ka0
    public List<View> w() {
        return Collections.singletonList(b());
    }

    @Override // defpackage.ld0
    public ld0 c(int i) {
        super.c(i);
        return this;
    }

    @Override // defpackage.ld0
    public void e() {
        a(0, 0);
        z90.a(this);
    }

    public e10 f(int i) {
        this.e.getWindow().setType(i);
        return this;
    }

    public e10 c(CharSequence charSequence) {
        ((eg0) this.d.m).e.setText(charSequence);
        return this;
    }

    @Override // defpackage.ld0
    public ld0 a(int i, md0 md0Var) {
        b((CharSequence) this.n.getString(i));
        a(md0Var);
        return this;
    }

    @Override // defpackage.ld0
    public ld0 b(int i) {
        b((CharSequence) this.n.getString(i));
        a((md0) null);
        return this;
    }

    @Override // defpackage.ld0
    public ld0 d(int i) {
        ((eg0) this.d.m).e.setText(i);
        return this;
    }

    @Override // defpackage.ld0
    public e10 a(int i) {
        a(this.n.getString(i), (md0) null);
        return this;
    }

    @Override // defpackage.ld0
    public e10 b(boolean z) {
        super.b(z);
        return this;
    }

    @Override // defpackage.ld0
    public ld0 a(int i) {
        a(this.n.getString(i), (md0) null);
        return this;
    }

    @Override // defpackage.ld0
    public ld0 b(boolean z) {
        super.b(z);
        return this;
    }

    public e10 a(View view) {
        this.d.m.a(view, this.o);
        return this;
    }

    @Override // defpackage.ld0
    public e10 b(CharSequence charSequence) {
        super.b(charSequence);
        return this;
    }

    @Override // defpackage.ld0
    public ld0 b(CharSequence charSequence) {
        super.b(charSequence);
        return this;
    }

    public e10 b(String str) {
        this.p = str;
        this.d.d = str;
        this.d.c = VuiEngine.getInstance(this.n);
        return this;
    }

    @Override // defpackage.ld0
    public e10 a(int i, boolean z) {
        super.a(i, z);
        return this;
    }

    @Override // defpackage.ld0
    public ld0 a(int i, boolean z) {
        super.a(i, z);
        return this;
    }

    @Override // defpackage.ld0
    public e10 a(boolean z) {
        super.a(z);
        return this;
    }

    @Override // defpackage.ld0
    public ld0 a(boolean z) {
        super.a(z);
        return this;
    }

    @Override // defpackage.ld0
    public ld0 a(CharSequence charSequence) {
        super.a(charSequence);
        return this;
    }

    public e10 a(View view, boolean z) {
        this.d.m.a(view, z);
        return this;
    }

    public e10 a(CharSequence charSequence, md0 md0Var) {
        a(charSequence);
        this.j = md0Var;
        if (md0Var != null && this.h == null) {
            this.h = new hg0() { // from class: gd0
                @Override // defpackage.hg0
                public final void a(bg0 bg0Var, int i) {
                    ld0.this.a(bg0Var, i);
                }
            };
        }
        ((eg0) this.d.m).q = this.h;
        return this;
    }
}
