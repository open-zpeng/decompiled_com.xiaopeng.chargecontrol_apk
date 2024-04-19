package defpackage;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;
/* compiled from: AccessibilityClickableSpanCompat.java */
/* renamed from: ka  reason: default package */
/* loaded from: classes.dex */
public final class ka extends ClickableSpan {
    public final int c;
    public final la d;
    public final int e;

    public ka(int i, la laVar, int i2) {
        this.c = i;
        this.d = laVar;
        this.e = i2;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.c);
        this.d.a(this.e, bundle);
    }
}
