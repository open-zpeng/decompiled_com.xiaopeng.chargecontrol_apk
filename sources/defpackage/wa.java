package defpackage;

import android.os.Build;
import android.os.Bundle;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import defpackage.ya;
/* compiled from: InputConnectionCompat.java */
/* renamed from: wa  reason: default package */
/* loaded from: classes.dex */
public class wa extends InputConnectionWrapper {
    public final /* synthetic */ xa a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wa(InputConnection inputConnection, boolean z, xa xaVar) {
        super(inputConnection, z);
        this.a = xaVar;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean commitContent(InputContentInfo inputContentInfo, int i, Bundle bundle) {
        ya yaVar;
        xa xaVar = this.a;
        if (inputContentInfo == null) {
            yaVar = null;
        } else {
            int i2 = Build.VERSION.SDK_INT;
            yaVar = new ya(new ya.a(inputContentInfo));
        }
        if (((g3) xaVar).a(yaVar, i, bundle)) {
            return true;
        }
        return super.commitContent(inputContentInfo, i, bundle);
    }
}
