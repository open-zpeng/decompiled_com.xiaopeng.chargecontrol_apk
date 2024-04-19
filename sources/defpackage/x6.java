package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
/* compiled from: Guideline.java */
/* renamed from: x6  reason: default package */
/* loaded from: classes.dex */
public class x6 extends View {
    public x6(Context context) {
        super(context);
        super.setVisibility(8);
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(0, 0);
    }

    public void setGuidelineBegin(int margin) {
        ConstraintLayout.a aVar = (ConstraintLayout.a) getLayoutParams();
        aVar.a = margin;
        setLayoutParams(aVar);
    }

    public void setGuidelineEnd(int margin) {
        ConstraintLayout.a aVar = (ConstraintLayout.a) getLayoutParams();
        aVar.b = margin;
        setLayoutParams(aVar);
    }

    public void setGuidelinePercent(float ratio) {
        ConstraintLayout.a aVar = (ConstraintLayout.a) getLayoutParams();
        aVar.c = ratio;
        setLayoutParams(aVar);
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
    }
}
