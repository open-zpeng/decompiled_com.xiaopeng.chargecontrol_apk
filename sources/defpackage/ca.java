package defpackage;

import android.view.View;
import defpackage.y9;
/* compiled from: ViewCompat.java */
/* renamed from: ca  reason: default package */
/* loaded from: classes.dex */
public class ca extends y9.c<Boolean> {
    public ca(int i, Class cls, int i2) {
        super(i, cls, i2);
    }

    @Override // defpackage.y9.c
    public Boolean a(View view) {
        return Boolean.valueOf(view.isAccessibilityHeading());
    }
}
