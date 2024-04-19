package defpackage;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import com.xiaopeng.chargecontrol.R;
import com.xiaopeng.chargecontrol.widget.ThemeTextView;
import com.xiaopeng.xui.widget.XConstraintLayout;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XSwitch;
import com.xiaopeng.xui.widget.XTextView;
import defpackage.fa0;
import defpackage.jy;
import java.text.MessageFormat;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.ThreadMode;
/* compiled from: BaseTrunkPowerBar.java */
/* renamed from: a60  reason: default package */
/* loaded from: classes.dex */
public abstract class a60 extends XConstraintLayout {
    public XLinearLayout A;
    public XTextView B;
    public kh0 C;
    public d10 D;
    public m10 E;
    public boolean F;
    public CompoundButton.OnCheckedChangeListener G;
    public boolean x;
    public XSwitch y;
    public ThemeTextView z;

    public a60(Context context) {
        this(context, null);
    }

    private void setToggleChecked(boolean z) {
        this.F = false;
        this.y.setChecked(z);
    }

    public /* synthetic */ void a(CompoundButton compoundButton, boolean z) {
        Log.e("BaseTrunkPowerBar", "setOnCheckedChangeListener isChecked = " + z);
        x();
        if (z) {
            x90.i(fa0.b.a.g());
        }
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = this.G;
        if (onCheckedChangeListener != null) {
            onCheckedChangeListener.onCheckedChanged(compoundButton, z);
        }
    }

    public /* synthetic */ boolean b(View view, boolean z) {
        StringBuilder a = jg.a("setOnInterceptListener mSetCheckByUser = ");
        a.append(this.F);
        a.append(", checked = ");
        a.append(z);
        Log.i("BaseTrunkPowerBar", a.toString());
        if (!this.F) {
            StringBuilder a2 = jg.a("mSetCheckByUser is ");
            a2.append(this.F);
            Log.i("BaseTrunkPowerBar", a2.toString());
            this.F = true;
            return false;
        }
        this.F = true;
        if (z && x90.n() < 40) {
            d10 d10Var = this.D;
            if (d10Var != null) {
                i60 i60Var = new i60();
                this.E = i60Var;
                d10Var.b(i60Var);
            }
            return true;
        }
        int r = x90.r();
        Log.e("BaseTrunkPowerBar", "getTrunkPowerSwitchStatus = " + r + ", checked = " + z);
        if (r == 1 && !z) {
            x90.b(z);
            return true;
        } else if (r != 2) {
            x90.b(z);
            return true;
        } else {
            return false;
        }
    }

    public final void d(int i) {
        this.B.setText(MessageFormat.format(getResources().getText(R.string.trunk_power_configs).toString(), Integer.valueOf(i == 65535 ? -1 : (int) TimeUnit.MINUTES.toHours(i))));
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
        z90.a(this.C);
        d10 d10Var = this.D;
        if (d10Var == null || (m10Var = this.E) == null) {
            return;
        }
        d10Var.a(m10Var);
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onTrunkPowerOffDelayChanged(jy.d dVar) {
        d(((Integer) dVar.a).intValue());
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onTrunkPowerStateChanged(jy.e eVar) {
        d10 d10Var;
        m10 m10Var;
        int intValue = ((Integer) eVar.a).intValue();
        this.y.setEnabled(intValue != 2);
        x();
        if (intValue != 3) {
            setToggleChecked(intValue == 1);
            if (intValue != 0 || (d10Var = this.D) == null || (m10Var = this.E) == null) {
                return;
            }
            d10Var.a(m10Var);
        }
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.G = onCheckedChangeListener;
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener2 = this.G;
        XSwitch xSwitch = this.y;
        onCheckedChangeListener2.onCheckedChanged(xSwitch, xSwitch.isChecked());
    }

    public void u() {
        this.y = (XSwitch) findViewById(R.id.trunk_power_toggle);
        this.z = (ThemeTextView) findViewById(R.id.trunk_power_state);
        this.A = (XLinearLayout) findViewById(R.id.trunk_power_config_container);
        this.B = (XTextView) findViewById(R.id.trunk_power_config);
    }

    public void v() {
        if (getContext() instanceof d10) {
            this.D = (d10) getContext();
        }
        LayoutInflater.from(getContext()).inflate(w(), this);
        u();
        this.y.setCheckSoundEnable(true);
        d(fa0.b.a.g());
        x();
        this.y.setOnInterceptListener(new XSwitch.b() { // from class: f50
            @Override // com.xiaopeng.xui.widget.XSwitch.b
            public final boolean a(View view, boolean z) {
                return a60.this.b(view, z);
            }
        });
        this.y.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: g50
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                a60.this.a(compoundButton, z);
            }
        });
        this.C = z90.a(this.A, new rh0() { // from class: h50
            @Override // defpackage.rh0
            public final void accept(Object obj) {
                a60.this.b(obj);
            }
        });
    }

    public abstract int w();

    public void x() {
        this.A.setEnabled(this.y.isEnabled() && this.y.isChecked());
    }

    public a60(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a60(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.F = true;
        v();
    }

    public /* synthetic */ void b(Object obj) {
        d10 d10Var = this.D;
        if (d10Var != null) {
            h60 h60Var = new h60(this.x);
            this.E = h60Var;
            d10Var.b(h60Var);
        }
    }
}
