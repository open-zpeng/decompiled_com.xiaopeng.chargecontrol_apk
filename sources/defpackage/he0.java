package defpackage;

import android.content.res.Configuration;
import android.widget.TextView;
/* compiled from: XViewDelegateFontScale.java */
/* renamed from: he0  reason: default package */
/* loaded from: classes.dex */
public class he0 extends ie0 {
    public TextView a;
    public float b;
    public float c;

    @Override // defpackage.ie0
    public void a() {
    }

    public final void a(Configuration configuration) {
        float f = this.c;
        float f2 = configuration.fontScale;
        if (f != f2) {
            this.c = f2;
            this.a.setTextSize(this.b);
        }
    }
}
