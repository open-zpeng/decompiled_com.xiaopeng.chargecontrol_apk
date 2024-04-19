package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
/* compiled from: Barrier.java */
/* renamed from: q6  reason: default package */
/* loaded from: classes.dex */
public class q6 extends s6 {
    public int l;
    public int m;
    public q5 n;

    public q6(Context context) {
        super(context);
        super.setVisibility(8);
    }

    @Override // defpackage.s6
    public void a(t5 widget, boolean isRtl) {
        int i = this.l;
        this.m = i;
        int i2 = Build.VERSION.SDK_INT;
        if (isRtl) {
            if (i == 5) {
                this.m = 1;
            } else if (i == 6) {
                this.m = 0;
            }
        } else if (i == 5) {
            this.m = 0;
        } else if (i == 6) {
            this.m = 1;
        }
        if (widget instanceof q5) {
            ((q5) widget).w0 = this.m;
        }
    }

    public boolean getAllowsGoneWidget() {
        return this.n.x0;
    }

    public int getMargin() {
        return this.n.y0;
    }

    public int getType() {
        return this.l;
    }

    public void setAllowsGoneWidget(boolean supportGone) {
        this.n.x0 = supportGone;
    }

    public void setDpMargin(int margin) {
        this.n.y0 = (int) ((margin * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setMargin(int margin) {
        this.n.y0 = margin;
    }

    public void setType(int type) {
        this.l = type;
    }

    @Override // defpackage.s6
    public void a(AttributeSet attrs) {
        super.a(attrs);
        this.n = new q5();
        if (attrs != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, a7.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == a7.ConstraintLayout_Layout_barrierDirection) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == a7.ConstraintLayout_Layout_barrierAllowsGoneWidgets) {
                    this.n.x0 = obtainStyledAttributes.getBoolean(index, true);
                } else if (index == a7.ConstraintLayout_Layout_barrierMargin) {
                    this.n.y0 = obtainStyledAttributes.getDimensionPixelSize(index, 0);
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f = this.n;
        e();
    }
}
