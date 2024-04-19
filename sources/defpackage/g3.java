package defpackage;

import android.content.ClipData;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputContentInfo;
import defpackage.h9;
/* compiled from: AppCompatReceiveContentHelper.java */
/* renamed from: g3  reason: default package */
/* loaded from: classes.dex */
public class g3 implements xa {
    public final /* synthetic */ View a;

    public g3(View view) {
        this.a = view;
    }

    public boolean a(ya yaVar, int i, Bundle bundle) {
        int i2 = Build.VERSION.SDK_INT;
        if ((i & 1) != 0) {
            try {
                yaVar.a.d();
                InputContentInfo inputContentInfo = (InputContentInfo) yaVar.a.b();
                bundle = bundle == null ? new Bundle() : new Bundle(bundle);
                bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", inputContentInfo);
            } catch (Exception e) {
                Log.w("ReceiveContent", "Can't insert content from IME; requestPermission() failed", e);
                return false;
            }
        }
        h9.a aVar = new h9.a(new ClipData(yaVar.a.a(), new ClipData.Item(yaVar.a.c())), 2);
        aVar.d = yaVar.a.e();
        aVar.e = bundle;
        return y9.a(this.a, new h9(aVar)) == null;
    }
}
