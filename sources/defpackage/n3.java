package defpackage;

import android.graphics.Typeface;
import android.widget.TextView;
/* compiled from: AppCompatTextHelper.java */
/* renamed from: n3  reason: default package */
/* loaded from: classes.dex */
public class n3 implements Runnable {
    public final /* synthetic */ TextView c;
    public final /* synthetic */ Typeface d;
    public final /* synthetic */ int e;

    public n3(m3 m3Var, TextView textView, Typeface typeface, int i) {
        this.c = textView;
        this.d = typeface;
        this.e = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.setTypeface(this.d, this.e);
    }
}
