package defpackage;

import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
/* compiled from: XViewDelegate.java */
/* renamed from: fe0  reason: default package */
/* loaded from: classes.dex */
public abstract class fe0 {
    public static fe0 a(View view, AttributeSet attributeSet) {
        return a(view, attributeSet, 0, 0);
    }

    public abstract void a();

    public abstract void a(Configuration configuration);

    public abstract void b();

    public static fe0 a(View view, AttributeSet attributeSet, int i) {
        return a(view, attributeSet, i, 0);
    }

    public static fe0 a(View view, AttributeSet attributeSet, int i, int i2) {
        return new ge0(view, attributeSet, i, i2, null);
    }

    public static fe0 a(View view, AttributeSet attributeSet, int i, int i2, Object obj) {
        return new ge0(view, attributeSet, i, i2, obj);
    }
}
