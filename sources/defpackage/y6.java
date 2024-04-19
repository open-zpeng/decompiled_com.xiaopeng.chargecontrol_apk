package defpackage;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.xiaopeng.xui.drawable.XLoadingDrawable;
import defpackage.t5;
/* compiled from: Placeholder.java */
/* renamed from: y6  reason: default package */
/* loaded from: classes.dex */
public class y6 extends View {
    public int c;
    public View d;
    public int e;

    public void a(ConstraintLayout container) {
        if (this.c == -1 && !isInEditMode()) {
            setVisibility(this.e);
        }
        this.d = container.findViewById(this.c);
        View view = this.d;
        if (view != null) {
            ((ConstraintLayout.a) view.getLayoutParams()).g0 = true;
            this.d.setVisibility(0);
            setVisibility(0);
        }
    }

    public View getContent() {
        return this.d;
    }

    public int getEmptyVisibility() {
        return this.e;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(XLoadingDrawable.ALPHA_MAX, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize(rect.height());
            int height = rect.height();
            int width = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((width / 2.0f) - (rect.width() / 2.0f)) - rect.left, ((rect.height() / 2.0f) + (height / 2.0f)) - rect.bottom, paint);
        }
    }

    public void setContentId(int id) {
        View findViewById;
        if (this.c == id) {
            return;
        }
        View view = this.d;
        if (view != null) {
            view.setVisibility(0);
            ((ConstraintLayout.a) this.d.getLayoutParams()).g0 = false;
            this.d = null;
        }
        this.c = id;
        if (id == -1 || (findViewById = ((View) getParent()).findViewById(id)) == null) {
            return;
        }
        findViewById.setVisibility(8);
    }

    public void setEmptyVisibility(int visibility) {
        this.e = visibility;
    }

    public void a() {
        if (this.d == null) {
            return;
        }
        ConstraintLayout.a aVar = (ConstraintLayout.a) getLayoutParams();
        ConstraintLayout.a aVar2 = (ConstraintLayout.a) this.d.getLayoutParams();
        aVar2.s0.j0 = 0;
        if (aVar.s0.f() != t5.a.FIXED) {
            aVar.s0.l(aVar2.s0.i());
        }
        if (aVar.s0.h() != t5.a.FIXED) {
            aVar.s0.i(aVar2.s0.e());
        }
        aVar2.s0.j0 = 8;
    }
}
