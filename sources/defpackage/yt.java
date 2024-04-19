package defpackage;

import android.graphics.Matrix;
/* compiled from: TransformerHorizontalBarChart.java */
/* renamed from: yt  reason: default package */
/* loaded from: classes.dex */
public class yt extends xt {
    public yt(au auVar) {
        super(auVar);
    }

    @Override // defpackage.xt
    public void a(boolean z) {
        this.b.reset();
        if (!z) {
            Matrix matrix = this.b;
            au auVar = this.c;
            matrix.postTranslate(auVar.b.left, auVar.d - auVar.d());
            return;
        }
        Matrix matrix2 = this.b;
        au auVar2 = this.c;
        float f = -(auVar2.c - auVar2.e());
        au auVar3 = this.c;
        matrix2.setTranslate(f, auVar3.d - auVar3.d());
        this.b.postScale(-1.0f, 1.0f);
    }
}
