package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.xiaopeng.chargecontrol.R;
import com.xiaopeng.speech.vui.VuiEngine;
import com.xiaopeng.xui.widget.XButton;
import com.xiaopeng.xui.widget.XConstraintLayout;
import defpackage.fa0;
import defpackage.ly;
import defpackage.y60;
import org.greenrobot.eventbus.ThreadMode;
/* compiled from: BaseChargeLimitBar.java */
/* renamed from: c30  reason: default package */
/* loaded from: classes.dex */
public abstract class c30 extends XConstraintLayout implements ma0 {
    public View A;
    public kh0 B;
    public d10 C;
    public m10 D;
    public w10 E;
    public final String F;
    public SharedPreferences.OnSharedPreferenceChangeListener G;
    public TextView x;
    public TextView y;
    public XButton z;

    public c30(Context context) {
        super(context);
        this.E = x10.a();
        this.F = a70.k() ? "Main" : "MainBottom";
        this.G = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: z20
            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                c30.this.a(sharedPreferences, str);
            }
        };
        u();
    }

    public /* synthetic */ void a(SharedPreferences sharedPreferences, String str) {
        if ("battery_protect_mode".equals(str)) {
            e(x90.a(y60.a.b));
        }
    }

    public /* synthetic */ void b(Object obj) {
        d10 d10Var = this.C;
        if (d10Var != null) {
            m10 a = iv.a();
            this.D = a;
            d10Var.b(a);
        }
    }

    public int d(int i) {
        return i == y60.a.c ? R.string.best_limit_format : R.string.limit_format;
    }

    public final void e(int i) {
        if (i == y60.a.c) {
            this.y.setText(R.string.charge_limit_tips_best);
            this.y.setVisibility(0);
        } else if (this.E.a()) {
            this.y.setText(R.string.charge_limit_tips_reset);
            this.y.setVisibility(0);
        } else {
            this.y.setVisibility(8);
        }
    }

    @Override // com.xiaopeng.xui.widget.XConstraintLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        iv.d(this);
        fa0.b.a.a.registerOnSharedPreferenceChangeListener(this.G);
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onChargeLimitChanged(ly.c cVar) {
        int intValue = ((Integer) cVar.a).intValue();
        this.x.setText(getResources().getString(d(intValue), Integer.valueOf(intValue)));
        this.z.setEnabled(intValue != y60.a.c);
        z90.a(this.F, this.A);
        e(intValue);
    }

    @Override // com.xiaopeng.xui.widget.XConstraintLayout, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        m10 m10Var;
        super.onDetachedFromWindow();
        fa0.b.a.a.unregisterOnSharedPreferenceChangeListener(this.G);
        iv.e(this);
        z90.a(this.B);
        d10 d10Var = this.C;
        if (d10Var == null || (m10Var = this.D) == null) {
            return;
        }
        d10Var.a(m10Var);
    }

    public final void u() {
        if (getContext() instanceof d10) {
            this.C = (d10) getContext();
        }
        LayoutInflater.from(getContext()).inflate(R.layout.layout_charge_limit_bar, this);
        this.x = (TextView) findViewById(R.id.limit_current);
        this.y = (TextView) findViewById(R.id.limit_tips);
        this.z = (XButton) findViewById(R.id.limit_best);
        this.A = findViewById(R.id.limit_container);
        z90.a(this.z);
        XButton xButton = this.z;
        VuiEngine.getInstance(xButton.getContext()).setHasFeedBackTxtByViewDisable(xButton, xButton.getContext().getString(R.string.vui_fb_charge_limit_beat));
        this.B = z90.a(this.A, new rh0() { // from class: b30
            @Override // defpackage.rh0
            public final void accept(Object obj) {
                c30.this.b(obj);
            }
        });
        this.z.setOnClickListener(new View.OnClickListener() { // from class: a30
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                x90.e(y60.a.c);
            }
        });
    }

    public c30(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.E = x10.a();
        this.F = a70.k() ? "Main" : "MainBottom";
        this.G = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: z20
            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                c30.this.a(sharedPreferences, str);
            }
        };
        u();
    }

    public c30(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.E = x10.a();
        this.F = a70.k() ? "Main" : "MainBottom";
        this.G = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: z20
            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                c30.this.a(sharedPreferences, str);
            }
        };
        u();
    }
}
