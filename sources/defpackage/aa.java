package defpackage;

import android.view.View;
import defpackage.y9;
/* compiled from: ViewCompat.java */
/* renamed from: aa  reason: default package */
/* loaded from: classes.dex */
public class aa extends y9.c<CharSequence> {
    public aa(int i, Class cls, int i2, int i3) {
        super(i, cls, i2, i3);
    }

    @Override // defpackage.y9.c
    public CharSequence a(View view) {
        return view.getAccessibilityPaneTitle();
    }
}
