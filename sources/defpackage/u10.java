package defpackage;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.xiaopeng.chargecontrol.widget.ThemeTextView;
import com.xiaopeng.speech.vui.model.VuiFeedbackCode;
import com.xiaopeng.xui.widget.XSeekBar;
import defpackage.fa0;
import defpackage.ly;
import defpackage.my;
import defpackage.r70;
import defpackage.y60;
import org.greenrobot.eventbus.ThreadMode;
/* compiled from: BaseChargeLimitDialog.java */
/* renamed from: u10  reason: default package */
/* loaded from: classes.dex */
public abstract class u10 extends m10 implements DialogInterface.OnShowListener, DialogInterface.OnDismissListener, SeekBar.OnSeekBarChangeListener, hc0 {
    public ThemeTextView r0;
    public ThemeTextView s0;
    public ThemeTextView t0;
    public SeekBar u0;
    public XSeekBar v0;
    public lf0 w0;
    public ga0 x0;

    /* compiled from: BaseChargeLimitDialog.java */
    /* renamed from: u10$a */
    /* loaded from: classes.dex */
    public class a implements hc0 {
        public a() {
        }

        @Override // defpackage.hc0
        public boolean a(View view, tc0 tc0Var) {
            if (view.getId() == o90.limit_best) {
                u10.a(u10.this);
                return false;
            } else if (view == u10.this.v0 && ((Number) tc0Var.getEventValue(tc0Var)).intValue() < y60.a.a) {
                z90.a(view, VuiFeedbackCode.SUCCESS, r90.vui_fb_charge_limit_less_than_min);
                return true;
            } else if (view instanceof hc0) {
                return ((hc0) view).a(view, tc0Var);
            } else {
                z90.a(view, 0);
                return false;
            }
        }
    }

    @Override // defpackage.m10, androidx.fragment.app.Fragment
    public void Q0() {
        super.Q0();
        iv.e(this);
    }

    @Override // defpackage.hc0
    public sc0 a(String str, fc0 fc0Var) {
        return null;
    }

    public /* synthetic */ void a(ld0 ld0Var, int i) {
        if (r70.b.a.b() == 2 && this.v0.getProgress() <= this.u0.getProgress()) {
            final Bundle bundle = new Bundle();
            m(bundle);
            m10 m10Var = new m10();
            m10Var.b(f(r90.dialog_title_confirm_stop_charge));
            m10Var.a(f(r90.dialog_message_confirm_decrease_stop_charge));
            m10Var.b(f(r90.finish_charge), new md0() { // from class: n10
                @Override // defpackage.md0
                public final void a(ld0 ld0Var2, int i2) {
                    u10.this.a(bundle, ld0Var2, i2);
                }
            });
            m10Var.a(f(r90.cancel), (md0) null);
            ((d10) r1()).b(m10Var);
            return;
        }
        Bundle bundle2 = new Bundle();
        m(bundle2);
        n(bundle2);
    }

    @Override // defpackage.hc0
    public boolean a(View view, tc0 tc0Var) {
        return false;
    }

    public void c(View view) {
        this.r0 = (ThemeTextView) view.findViewById(o90.tips);
        this.s0 = (ThemeTextView) view.findViewById(o90.limit_current);
        this.t0 = (ThemeTextView) view.findViewById(o90.limit_current_percent_symbol);
        this.u0 = (SeekBar) view.findViewById(o90.limit_current_soc);
        this.v0 = (XSeekBar) view.findViewById(o90.limit_thumb);
        this.x0 = new ga0(this.v0);
        this.v0.setOnSeekBarChangeListener(this);
        this.w0 = (lf0) view.findViewById(o90.battery_protect_checkbox);
        this.w0.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: q10
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                u10.this.a(compoundButton, z);
            }
        });
    }

    public int j(int i) {
        if (i > y60.a.c) {
            return l90.charge_limit_warning;
        }
        return l90.charge_limit_daily_best_color;
    }

    public int k(int i) {
        if (i >= y60.a.a && i < y60.a.c) {
            return r90.set_limit_charge_content_daily;
        }
        if (i == y60.a.c) {
            return r90.set_limit_charge_content_best;
        }
        return r90.set_limit_charge_content_long_dis;
    }

    @Override // defpackage.m10
    public e10 l(Bundle bundle) {
        e10 e10Var = new e10(r1(), s90.ChargeLimitDialogStyle);
        e10Var.b("ChargeLimitDialog");
        e10Var.a(this);
        e10 a2 = e10Var.a(y1(), false);
        a2.d(r90.set_limit_charge_title);
        a2.a(r90.confirm, new md0() { // from class: o10
            @Override // defpackage.md0
            public final void a(ld0 ld0Var, int i) {
                u10.this.a(ld0Var, i);
            }
        });
        a2.a(r90.cancel);
        a2.a(new a());
        return a2;
    }

    public void m(int i) {
        int max = Math.max(Math.min(i, y60.a.b), y60.a.a);
        this.v0.setProgress(max);
        this.r0.setText(k(max));
        this.s0.setText(Integer.toString(max));
        this.s0.setTextColorResource(j(max));
        this.t0.setTextColorResource(j(max));
        float x = (this.u0.getX() + ((max / this.v0.getMax()) * this.u0.getWidth())) - (((this.s0.getPaint().measureText(Integer.toString(max)) + this.s0.getPaddingLeft()) + this.s0.getPaddingRight()) / 2.0f);
        ConstraintLayout.a aVar = (ConstraintLayout.a) this.s0.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) aVar).leftMargin = Math.round(x);
        this.s0.setLayoutParams(aVar);
        this.r0.setTextColorResource(l(max));
        this.v0.setThumb(defpackage.a.a(p0(), a(max, this.u0.getProgress()), (Resources.Theme) null));
    }

    public void n(Bundle bundle) {
        x90.e(bundle.getInt("limit"));
        fa0.b.a.a(bundle.getBoolean("battery_protect"));
    }

    @tl0(threadMode = ThreadMode.MAIN)
    public void onChargeLimitChanged(ly.c cVar) {
        m(((Integer) cVar.a).intValue());
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        m(i);
    }

    @tl0(threadMode = ThreadMode.MAIN)
    public void onSocChanged(my.m0 m0Var) {
        this.u0.setProgress(((Integer) m0Var.a).intValue());
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    public /* synthetic */ void x1() {
        this.s0.setVisibility(0);
        this.t0.setVisibility(0);
        m(x90.a(y60.a.c));
    }

    public int y1() {
        return q90.dialog_charge_limit_settings_lnc;
    }

    public void z1() {
        int p = x90.p();
        if (p == -1) {
            p = 0;
        }
        this.u0.setProgress(p);
        m(x90.a(y60.a.c));
        ga0 ga0Var = this.x0;
        ga0Var.a.post(ga0Var.a(new Runnable() { // from class: p10
            @Override // java.lang.Runnable
            public final void run() {
                u10.this.x1();
            }
        }));
        this.w0.setChecked(fa0.b.a.h());
    }

    public int l(int i) {
        int i2 = y60.a.c;
        if (i > i2) {
            return l90.charge_limit_warning;
        }
        if (i == i2) {
            return l90.charge_limit_daily_best_color;
        }
        return l90.charge_limit_text_color;
    }

    public static /* synthetic */ void a(u10 u10Var) {
        u10Var.m(90);
        z90.a(u10Var.v0, 0, (int) (((90.0f / u10Var.v0.getMax()) - 0.5d) * u10Var.v0.getWidth()), 0);
    }

    public void m(Bundle bundle) {
        bundle.putInt("limit", this.v0.getProgress());
        bundle.putBoolean("battery_protect", this.w0.isChecked());
    }

    @Override // androidx.fragment.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        c(w1().b());
        z1();
        this.v0.a(p0().getString(r90.charge_limit));
        z90.a(this.v0);
        iv.d(this);
        return super.a(layoutInflater, viewGroup, bundle);
    }

    public /* synthetic */ void a(CompoundButton compoundButton, boolean z) {
        z90.a(w1().p, compoundButton);
    }

    public /* synthetic */ void a(Bundle bundle, ld0 ld0Var, int i) {
        n(bundle);
        x90.z();
    }

    public int a(int i, int i2) {
        if (i > y60.a.c) {
            return n90.charge_limit_thumb_warning;
        }
        if (i > i2) {
            return n90.charge_limit_thumb_enable;
        }
        return n90.charge_limit_thumb_disable;
    }
}
