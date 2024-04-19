package com.xiaopeng.chargecontrol.app.main;

import android.content.Context;
import android.util.AttributeSet;
import com.xiaopeng.chargecontrol.app.main.ChartButton;
import com.xiaopeng.xui.widget.XImageButton;
import defpackage.r70;
import org.greenrobot.eventbus.ThreadMode;
/* loaded from: classes.dex */
public class ChartButton extends XImageButton {
    public d10 g;
    public kh0 h;

    public ChartButton(Context context) {
        this(context, null);
    }

    public /* synthetic */ void b(Object obj) {
        d10 d10Var = this.g;
        if (d10Var != null) {
            d10Var.b(new v10());
        }
    }

    public /* synthetic */ void c(Object obj) {
        d10 d10Var = this.g;
        if (d10Var != null) {
            d10Var.b(new p60());
        }
    }

    public /* synthetic */ void d(Object obj) {
        d10 d10Var = this.g;
        if (d10Var != null) {
            d10Var.b(new c40());
        }
    }

    @Override // com.xiaopeng.xui.widget.XImageButton, android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        iv.d(this);
    }

    @Override // com.xiaopeng.xui.widget.XImageButton, android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        iv.e(this);
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onLocalChargeStatusChanged(q70 q70Var) {
        if (r70.b.a.d()) {
            z90.a(this.h);
            this.h = z90.a(this, new rh0() { // from class: m50
                @Override // defpackage.rh0
                public final void accept(Object obj) {
                    ChartButton.this.c(obj);
                }
            });
        } else if (r70.b.a.c()) {
            z90.a(this.h);
            this.h = z90.a(this, new rh0() { // from class: k50
                @Override // defpackage.rh0
                public final void accept(Object obj) {
                    ChartButton.this.b(obj);
                }
            });
        } else if (r70.b.a.e()) {
            z90.a(this.h);
            this.h = z90.a(this, new rh0() { // from class: l50
                @Override // defpackage.rh0
                public final void accept(Object obj) {
                    ChartButton.this.d(obj);
                }
            });
        }
        z90.b().updateScene("Main", this);
    }

    public ChartButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChartButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        if (getContext() instanceof d10) {
            this.g = (d10) getContext();
        }
    }
}
