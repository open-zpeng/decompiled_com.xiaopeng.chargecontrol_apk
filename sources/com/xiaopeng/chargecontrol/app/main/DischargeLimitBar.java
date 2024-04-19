package com.xiaopeng.chargecontrol.app.main;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.xiaopeng.chargecontrol.R;
import com.xiaopeng.chargecontrol.app.main.DischargeLimitBar;
import com.xiaopeng.xui.widget.XConstraintLayout;
import defpackage.my;
import org.greenrobot.eventbus.ThreadMode;
/* loaded from: classes.dex */
public class DischargeLimitBar extends XConstraintLayout {
    public d10 A;
    public m10 B;
    public TextView x;
    public View y;
    public kh0 z;

    public DischargeLimitBar(Context context) {
        super(context);
        u();
    }

    public /* synthetic */ void b(Object obj) {
        d10 d10Var = this.A;
        if (d10Var != null) {
            d40 d40Var = new d40();
            this.B = d40Var;
            d10Var.b(d40Var);
        }
    }

    @Override // com.xiaopeng.xui.widget.XConstraintLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        iv.d(this);
    }

    @Override // com.xiaopeng.xui.widget.XConstraintLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        m10 m10Var;
        super.onDetachedFromWindow();
        iv.e(this);
        z90.a(this.z);
        d10 d10Var = this.A;
        if (d10Var == null || (m10Var = this.B) == null) {
            return;
        }
        d10Var.a(m10Var);
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onDischargeLimitChanged(my.b0 b0Var) {
        this.x.setText(getResources().getString(R.string.limit_format, Integer.valueOf(((Integer) b0Var.a).intValue())));
        z90.a("MainBottom", this.y);
    }

    public final void u() {
        if (getContext() instanceof d10) {
            this.A = (d10) getContext();
        }
        LayoutInflater.from(getContext()).inflate(R.layout.layout_discharge_limit_bar, this);
        this.x = (TextView) findViewById(R.id.limit_current);
        this.y = findViewById(R.id.limit_container);
        this.z = z90.a(this.y, new rh0() { // from class: n50
            @Override // defpackage.rh0
            public final void accept(Object obj) {
                DischargeLimitBar.this.b(obj);
            }
        });
    }

    public DischargeLimitBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        u();
    }

    public DischargeLimitBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        u();
    }
}
