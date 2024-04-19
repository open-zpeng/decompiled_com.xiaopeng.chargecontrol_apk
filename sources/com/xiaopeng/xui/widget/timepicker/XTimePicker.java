package com.xiaopeng.xui.widget.timepicker;

import android.content.Context;
import android.icu.util.Calendar;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;
import com.xiaopeng.xui.widget.XFrameLayout;
import java.util.Locale;
/* loaded from: classes.dex */
public class XTimePicker extends XFrameLayout {
    public static final String e = XTimePicker.class.getSimpleName();
    public final d d;

    /* loaded from: classes.dex */
    public class a implements c {
        public a() {
        }

        public void a(XTimePicker xTimePicker, int i, int i2) {
            AutofillManager autofillManager = (AutofillManager) XTimePicker.this.getContext().getSystemService(AutofillManager.class);
            if (autofillManager != null) {
                autofillManager.notifyValueChanged(XTimePicker.this);
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b implements d {
        public final XTimePicker a;
        public final Context b;
        public final Locale c;
        public c d;
        public c e;
        public long f;

        /* loaded from: classes.dex */
        public static class a extends View.BaseSavedState {
            public final int c;
            public final int d;
            public final int e;

            public a(Parcelable parcelable, int i, int i2) {
                super(parcelable);
                this.c = i;
                this.d = i2;
                this.e = 0;
            }

            @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.c);
                parcel.writeInt(this.d);
                parcel.writeInt(this.e);
            }
        }

        public b(XTimePicker xTimePicker, Context context) {
            this.a = xTimePicker;
            this.b = context;
            this.c = context.getResources().getConfiguration().getLocales().get(0);
        }

        public final void a(AutofillValue autofillValue) {
            if (autofillValue != null && autofillValue.isDate()) {
                long dateValue = autofillValue.getDateValue();
                Calendar calendar = Calendar.getInstance(this.c);
                calendar.setTimeInMillis(dateValue);
                int i = calendar.get(11);
                int i2 = calendar.get(12);
                wg0 wg0Var = (wg0) this;
                wg0Var.a(i, false);
                wg0Var.b(i2, false);
                wg0Var.c();
                this.f = dateValue;
                return;
            }
            String str = XTimePicker.e;
            be0.d(str, autofillValue + " could not be autofilled into " + this);
        }
    }

    /* loaded from: classes.dex */
    public interface c {
    }

    /* loaded from: classes.dex */
    public interface d {
    }

    public XTimePicker(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void autofill(AutofillValue autofillValue) {
        if (isEnabled()) {
            ((b) this.d).a(autofillValue);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i) {
        viewStructure.setAutofillId(getAutofillId());
        onProvideAutofillStructure(viewStructure, i);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return XTimePicker.class.getName();
    }

    @Override // android.view.View
    public AutofillValue getAutofillValue() {
        if (isEnabled()) {
            b bVar = (b) this.d;
            long j = bVar.f;
            if (j != 0) {
                return AutofillValue.forDate(j);
            }
            Calendar calendar = Calendar.getInstance(bVar.c);
            wg0 wg0Var = (wg0) bVar;
            calendar.set(11, wg0Var.a());
            calendar.set(12, wg0Var.b());
            return AutofillValue.forDate(calendar.getTimeInMillis());
        }
        return null;
    }

    @Override // android.view.View
    public int getBaseline() {
        return ((wg0) this.d).g.getBaseline();
    }

    public Integer getCurrentHour() {
        return Integer.valueOf(getHour());
    }

    public Integer getCurrentMinute() {
        return Integer.valueOf(getMinute());
    }

    public int getHour() {
        return ((wg0) this.d).a();
    }

    public int getMinute() {
        return ((wg0) this.d).b();
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return ((wg0) this.d).j;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        View.BaseSavedState baseSavedState = (View.BaseSavedState) parcelable;
        super.onRestoreInstanceState(baseSavedState.getSuperState());
        ((wg0) this.d).a(baseSavedState);
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        return ((wg0) this.d).b(super.onSaveInstanceState());
    }

    public void setCurrentHour(Integer num) {
        setHour(num.intValue());
    }

    public void setCurrentMinute(Integer num) {
        setMinute(num.intValue());
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        wg0 wg0Var = (wg0) this.d;
        wg0Var.h.setEnabled(z);
        wg0Var.g.setEnabled(z);
        wg0Var.j = z;
    }

    public void setHour(int i) {
        d dVar = this.d;
        if (i < 0) {
            i = 0;
        } else if (i > 23) {
            i = 23;
        }
        ((wg0) dVar).a(i, true);
    }

    public void setMinute(int i) {
        d dVar = this.d;
        if (i < 0) {
            i = 0;
        } else if (i > 59) {
            i = 59;
        }
        ((wg0) dVar).b(i, true);
    }

    public void setOnTimeChangedListener(c cVar) {
        ((b) this.d).d = cVar;
    }

    public XTimePicker(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XTimePicker(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, cd0.XTimePicker);
    }

    public XTimePicker(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        if (getImportantForAutofill() == 0) {
            setImportantForAutofill(1);
        }
        this.d = new wg0(this, context, attributeSet, i, i2);
        ((b) this.d).e = new a();
    }
}
