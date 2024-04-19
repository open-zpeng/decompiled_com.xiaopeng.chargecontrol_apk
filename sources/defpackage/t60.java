package defpackage;

import android.content.res.Configuration;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.xiaopeng.chargecontrol.R;
import com.xiaopeng.chargecontrol.widget.ThemeTextView;
import defpackage.ky;
import java.text.DecimalFormat;
import org.greenrobot.eventbus.ThreadMode;
/* compiled from: SolarRoofDialog.java */
/* renamed from: t60  reason: default package */
/* loaded from: classes.dex */
public class t60 extends m10 {
    public ThemeTextView r0;
    public ThemeTextView s0;
    public ThemeTextView t0;
    public ImageView u0;
    public View v0;
    public final DecimalFormat w0 = new DecimalFormat("#.###");
    public final DecimalFormat x0 = new DecimalFormat("#.#");

    @Override // defpackage.m10, androidx.fragment.app.Fragment
    public void Q0() {
        super.Q0();
        iv.e(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup b = w1().b();
        this.r0 = (ThemeTextView) b.findViewById(R.id.power);
        this.s0 = (ThemeTextView) b.findViewById(R.id.total_power);
        this.t0 = (ThemeTextView) b.findViewById(R.id.total_energy);
        this.u0 = (ImageView) b.findViewById(R.id.solar_roof_state_img);
        this.v0 = b.findViewById(R.id.solar_roof_state);
        this.r0.setText("--");
        this.r0.setTextColorResource(R.color.sub_title);
        this.s0.setText("--");
        this.s0.setTextColorResource(R.color.sub_title);
        this.t0.setText("--");
        this.t0.setTextColorResource(R.color.sub_title);
        j(R.drawable.bg_solar_roof_dialog);
        iv.d(this);
        return super.a(layoutInflater, viewGroup, bundle);
    }

    public final void j(int i) {
        w1().b().setBackgroundResource(i);
    }

    @Override // defpackage.m10
    public e10 l(Bundle bundle) {
        e10 a = new e10(s1(), R.style.SolarRoofDialogContent).a(R.layout.dialog_solar_roof, false);
        a.d(R.string.solar_roof);
        return a.a(true);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.H = true;
        j(0);
        j(R.drawable.bg_solar_roof_dialog);
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onSolarPowerChanged(ky.a aVar) {
        this.r0.setTextColorResource(R.color.title);
        this.r0.setText(a(R.string.solar_roof_format_power, ((Float) aVar.a).floatValue(), this.w0));
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onSolarTotalPowerGenerationChanged(ky.b bVar) {
        this.s0.setTextColorResource(R.color.title);
        this.s0.setText(a(R.string.solar_roof_format_total_power, ((Float) bVar.a).floatValue(), this.w0));
        this.t0.setTextColorResource(R.color.title);
        this.t0.setText(a(R.string.solar_roof_format_total_energy, ((Float) bVar.a).floatValue() * 800.0f, this.x0));
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onSolarWorkingStateChanged(ky.c cVar) {
        int i = ((Integer) cVar.a).intValue() == 1 ? 0 : 8;
        this.u0.setVisibility(i);
        this.v0.setVisibility(i);
    }

    public final CharSequence a(int i, float f, DecimalFormat decimalFormat) {
        String format = decimalFormat.format(f);
        String a = a(i, format);
        for (int i2 = 0; i2 < a.length(); i2++) {
            if (!Character.isDigit(a.charAt(i2))) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(a);
                spannableStringBuilder.setSpan(new AbsoluteSizeSpan(p0().getDimensionPixelSize(R.dimen.solar_roof_decimal_size)), i2, a.length(), 33);
                return spannableStringBuilder;
            }
        }
        return a;
    }
}
