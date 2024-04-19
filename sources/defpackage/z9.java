package defpackage;

import android.view.View;
import defpackage.y9;
/* compiled from: ViewCompat.java */
/* renamed from: z9  reason: default package */
/* loaded from: classes.dex */
public class z9 extends y9.c<Boolean> {
    public z9(int i, Class cls, int i2) {
        super(i, cls, i2);
    }

    @Override // defpackage.y9.c
    public Boolean a(View view) {
        return Boolean.valueOf(view.isScreenReaderFocusable());
    }
}
