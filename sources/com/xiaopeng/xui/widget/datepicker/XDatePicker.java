package com.xiaopeng.xui.widget.datepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.icu.util.Calendar;
import android.util.AttributeSet;
import android.view.autofill.AutofillManager;
import com.xiaopeng.xui.widget.XFrameLayout;
import java.util.Locale;
/* loaded from: classes.dex */
public class XDatePicker extends XFrameLayout {
    public final d d;

    /* loaded from: classes.dex */
    public class a implements c {
        public a() {
        }

        public void a(XDatePicker xDatePicker, int i, int i2, int i3) {
            AutofillManager autofillManager = (AutofillManager) XDatePicker.this.getContext().getSystemService(AutofillManager.class);
            if (autofillManager != null) {
                autofillManager.notifyValueChanged(XDatePicker.this);
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b implements d {
        public XDatePicker a;
        public Context b;
        public Calendar c;
        public Locale d;
        public c e;
        public c f;

        public b(XDatePicker xDatePicker, Context context) {
            this.a = xDatePicker;
            this.b = context;
            a(Locale.getDefault());
        }

        public void a(Locale locale) {
            if (locale.equals(this.d)) {
                return;
            }
            this.d = locale;
        }
    }

    /* loaded from: classes.dex */
    public interface c {
    }

    /* loaded from: classes.dex */
    public interface d {
    }

    public XDatePicker(Context context) {
        this(context, null);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return XDatePicker.class.getName();
    }

    public int getDayOfMonth() {
        return ((yf0) this.d).a();
    }

    public long getMaxDate() {
        Calendar calendar;
        yf0 yf0Var = (yf0) this.d;
        if (yf0Var.p != null) {
            calendar = yf0Var.o;
        } else {
            calendar = Calendar.getInstance();
            calendar.set(2100, 11, 30);
        }
        return calendar.getTimeInMillis();
    }

    public long getMinDate() {
        Calendar calendar = ((yf0) this.d).o;
        if (calendar == null) {
            calendar = Calendar.getInstance();
            calendar.set(1900, 1, 1);
        }
        return calendar.getTimeInMillis();
    }

    public int getMonth() {
        return ((yf0) this.d).b();
    }

    public int getYear() {
        return ((yf0) this.d).c();
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return ((yf0) this.d).q;
    }

    @Override // com.xiaopeng.xui.widget.XFrameLayout, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ((yf0) this.d).a(configuration);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        if (((yf0) this.d).q == z) {
            return;
        }
        super.setEnabled(z);
        yf0 yf0Var = (yf0) this.d;
        yf0Var.h.setEnabled(z);
        yf0Var.i.setEnabled(z);
        yf0Var.j.setEnabled(z);
        yf0Var.q = z;
    }

    public void setMaxDate(long j) {
        ((yf0) this.d).a(j);
    }

    public void setMinDate(long j) {
        ((yf0) this.d).b(j);
    }

    public void setOnDateChangedListener(c cVar) {
        ((b) this.d).e = cVar;
    }

    public XDatePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XDatePicker(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, cd0.XDatePicker);
    }

    public XDatePicker(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        if (getImportantForAutofill() == 0) {
            setImportantForAutofill(1);
        }
        this.d = new yf0(this, context, attributeSet, i, i2);
        ((b) this.d).f = new a();
    }
}
