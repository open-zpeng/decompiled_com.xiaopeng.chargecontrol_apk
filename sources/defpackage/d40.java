package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.xiaopeng.chargecontrol.widget.ThemeTextView;
import com.xiaopeng.speech.vui.model.VuiFeedbackCode;
import com.xiaopeng.xui.widget.XSeekBar;
import defpackage.my;
import org.greenrobot.eventbus.ThreadMode;
/* compiled from: DischargeLimitDialog.java */
/* renamed from: d40  reason: default package */
/* loaded from: classes.dex */
public class d40 extends m10 implements SeekBar.OnSeekBarChangeListener, hc0 {
    public static final int y0 = ee0.a(10.0f);
    public ThemeTextView r0;
    public TextView s0;
    public TextView t0;
    public TextView u0;
    public SeekBar v0;
    public XSeekBar w0;
    public ga0 x0;

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
        if (j(this.w0.getProgress())) {
            x90.f(this.w0.getProgress());
        }
    }

    public final boolean j(int i) {
        return i < this.v0.getProgress();
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00e4 A[Catch: JSONException -> 0x00ea, TRY_LEAVE, TryCatch #0 {JSONException -> 0x00ea, blocks: (B:16:0x00bb, B:20:0x00c6, B:22:0x00cc, B:30:0x00e4, B:24:0x00d2, B:25:0x00d8, B:27:0x00de), top: B:34:0x00bb }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(int r6) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.d40.k(int):void");
    }

    @Override // defpackage.m10
    public e10 l(Bundle bundle) {
        e10 e10Var = new e10(s1(), s90.DischargeLimitDialogStyle);
        e10Var.b("DischargeLimitDialog");
        e10Var.a(this);
        e10 a = e10Var.a(q90.dialog_discharge_limit_setting, false);
        a.d(r90.set_limit_discharge_title);
        a.a(r90.confirm, new md0() { // from class: x30
            @Override // defpackage.md0
            public final void a(ld0 ld0Var, int i) {
                d40.this.a(ld0Var, i);
            }
        });
        a.a(r90.cancel);
        return a;
    }

    @tl0(threadMode = ThreadMode.MAIN)
    public void onDischargeLimitChanged(my.b0 b0Var) {
        k(((Integer) b0Var.a).intValue());
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        k(i);
    }

    @tl0(threadMode = ThreadMode.MAIN)
    public void onSocChanged(my.m0 m0Var) {
        this.v0.setProgress(((Integer) m0Var.a).intValue());
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    public /* synthetic */ void x1() {
        this.t0.setVisibility(0);
        this.u0.setVisibility(0);
        k(x90.b(100));
    }

    public final void y1() {
        if (this.s0.getRight() + y0 >= this.t0.getX()) {
            this.s0.setVisibility(4);
        } else {
            this.s0.setVisibility(0);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup b = w1().b();
        this.r0 = (ThemeTextView) b.findViewById(o90.tips);
        this.s0 = (TextView) b.findViewById(o90.limit_min);
        this.t0 = (TextView) b.findViewById(o90.limit_current);
        this.u0 = (TextView) b.findViewById(o90.limit_current_percent_symbol);
        this.v0 = (SeekBar) b.findViewById(o90.limit_current_soc);
        this.w0 = (XSeekBar) b.findViewById(o90.limit_thumb);
        this.x0 = ga0.a(this.w0);
        this.w0.setOnSeekBarChangeListener(this);
        ((ImageView) b.findViewById(o90.limit_bg)).setImageResource(n90.charge_limit_bg_lnc);
        int p = x90.p();
        if (p == -1) {
            p = 0;
        }
        l(p);
        k(x90.b(100));
        this.x0.b(new Runnable() { // from class: w30
            @Override // java.lang.Runnable
            public final void run() {
                d40.this.x1();
            }
        });
        this.w0.a(p0().getString(r90.discharge_limit));
        z90.a(this.w0);
        iv.d(this);
        return super.a(layoutInflater, viewGroup, bundle);
    }

    public final void l(int i) {
        this.v0.setProgress(i);
    }

    @Override // defpackage.hc0
    public boolean a(View view, tc0 tc0Var) {
        if (view == this.w0 && ((Number) tc0Var.getEventValue(tc0Var)).intValue() < 20) {
            z90.a(view, VuiFeedbackCode.SUCCESS, r90.vui_fb_discharge_limit_less_than_min);
            return true;
        } else if (view instanceof hc0) {
            return ((hc0) view).a(view, tc0Var);
        } else {
            z90.a(view, 0);
            return false;
        }
    }
}
