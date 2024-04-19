package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xiaopeng.carapi.CarApi;
import com.xiaopeng.chargecontrol.R;
import com.xiaopeng.xui.widget.XNumberPicker;
import com.xiaopeng.xui.widget.XTextView;
import defpackage.fa0;
import java.text.MessageFormat;
import java.util.concurrent.TimeUnit;
/* compiled from: TrunkPowerDialog.java */
/* renamed from: h60  reason: default package */
/* loaded from: classes.dex */
public class h60 extends m10 {
    public static final int[] v0 = {0, 1, 3, 6, 12, 24};
    public boolean r0;
    public XNumberPicker s0;
    public XTextView t0;
    public XTextView u0;

    public h60(boolean z) {
        this.r0 = z;
    }

    public /* synthetic */ void a(ld0 ld0Var, int i) {
        int i2 = v0[this.s0.getValue()];
        x90.i(i2 != -1 ? (int) TimeUnit.HOURS.toMinutes(i2) : 65535);
    }

    public final int j(int i) {
        int i2 = 0;
        while (true) {
            int[] iArr = v0;
            if (i2 >= iArr.length) {
                return 0;
            }
            if (iArr[i2] == i) {
                return i2;
            }
            i2++;
        }
    }

    public /* synthetic */ String k(int i) {
        return MessageFormat.format(p0().getText(R.string.trunk_power_configs).toString(), Integer.valueOf(v0[i]));
    }

    @Override // defpackage.m10
    public e10 l(Bundle bundle) {
        e10 a = new e10(s1(), R.style.TrunkPowerDialogTheme).a(R.layout.dialog_power_supply, false);
        a.d(this.r0 ? R.string.dialog_trunk_power_fridge_title : R.string.dialog_trunk_power_title);
        e10 b = a.b(false);
        b.a(R.string.confirm, new md0() { // from class: z50
            @Override // defpackage.md0
            public final void a(ld0 ld0Var, int i) {
                h60.this.a(ld0Var, i);
            }
        });
        b.a(R.string.cancel);
        return b;
    }

    @Override // androidx.fragment.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup b = w1().b();
        this.u0 = (XTextView) b.findViewById(R.id.title);
        this.s0 = (XNumberPicker) b.findViewById(R.id.delay_picker);
        this.t0 = (XTextView) b.findViewById(R.id.option_tips);
        this.s0.setFormatter(new XNumberPicker.c() { // from class: x50
            @Override // com.xiaopeng.xui.widget.XNumberPicker.c
            public final String a(int i) {
                return h60.this.k(i);
            }
        });
        this.s0.setMinValue(0);
        this.s0.setMaxValue(v0.length - 1);
        this.s0.setWrapSelectorWheel(false);
        int b2 = ((iz) CarApi.e().c()).b(fa0.b.a.g());
        int hours = b2 != 65535 ? (int) TimeUnit.MINUTES.toHours(b2) : -1;
        this.s0.setValue(j(hours));
        this.s0.setOnValueChangedListener(new XNumberPicker.e() { // from class: y50
            @Override // com.xiaopeng.xui.widget.XNumberPicker.e
            public final void a(XNumberPicker xNumberPicker, int i, int i2) {
                h60.this.a(xNumberPicker, i, i2);
            }
        });
        this.u0.setText(this.r0 ? R.string.dialog_trunk_power_fridge_title : R.string.dialog_trunk_power_title);
        this.t0.setText(this.r0 ? R.string.dialog_trunk_power_option_fridge_tips : R.string.dialog_trunk_power_option_tips);
        l(j(hours));
        return super.a(layoutInflater, viewGroup, bundle);
    }

    public final void l(int i) {
        XTextView xTextView = this.t0;
        if (xTextView != null) {
            xTextView.setVisibility(i == 0 ? 4 : 0);
        }
    }

    public /* synthetic */ void a(XNumberPicker xNumberPicker, int i, int i2) {
        XTextView xTextView = this.t0;
        if (xTextView != null) {
            xTextView.setVisibility(i2 == 0 ? 4 : 0);
        }
    }
}
