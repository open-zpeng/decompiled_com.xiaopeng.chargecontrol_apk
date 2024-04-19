package defpackage;

import android.view.View;
import defpackage.y9;
/* compiled from: ViewCompat.java */
/* renamed from: ba  reason: default package */
/* loaded from: classes.dex */
public class ba extends y9.c<CharSequence> {
    public ba(int i, Class cls, int i2, int i3) {
        super(i, cls, i2, i3);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // defpackage.y9.c
    public CharSequence a(View view) {
        return view.getStateDescription();
    }
}
