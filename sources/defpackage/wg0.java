package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.icu.util.Calendar;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.xiaopeng.xui.widget.XNumberPicker;
import com.xiaopeng.xui.widget.timepicker.XTimePicker;
/* compiled from: XTimePickerSpinnerDelegate.java */
/* renamed from: wg0  reason: default package */
/* loaded from: classes.dex */
public class wg0 extends XTimePicker.b {
    public final XNumberPicker g;
    public final XNumberPicker h;
    public final Calendar i;
    public boolean j;

    /* compiled from: XTimePickerSpinnerDelegate.java */
    /* renamed from: wg0$a */
    /* loaded from: classes.dex */
    public class a implements XNumberPicker.e {
        public a() {
        }

        @Override // com.xiaopeng.xui.widget.XNumberPicker.e
        public void a(XNumberPicker xNumberPicker, int i, int i2) {
            wg0.this.c();
        }
    }

    /* compiled from: XTimePickerSpinnerDelegate.java */
    /* renamed from: wg0$b */
    /* loaded from: classes.dex */
    public class b implements XNumberPicker.e {
        public b() {
        }

        @Override // com.xiaopeng.xui.widget.XNumberPicker.e
        public void a(XNumberPicker xNumberPicker, int i, int i2) {
            int minValue = wg0.this.h.getMinValue();
            int maxValue = wg0.this.h.getMaxValue();
            if (i == maxValue && i2 == minValue) {
                wg0.this.g.setValue(wg0.this.g.getValue() + 1);
            } else if (i == minValue && i2 == maxValue) {
                wg0.this.g.setValue(wg0.this.g.getValue() - 1);
            }
            wg0.this.c();
        }
    }

    public wg0(XTimePicker xTimePicker, Context context, AttributeSet attributeSet, int i, int i2) {
        super(xTimePicker, context);
        this.j = true;
        TypedArray obtainStyledAttributes = this.b.obtainStyledAttributes(attributeSet, dd0.XTimePicker, i, i2);
        int resourceId = obtainStyledAttributes.getResourceId(dd0.XTimePicker_tp_xTimePickerLayout, ad0.x_time_picker_layout);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(this.b).inflate(resourceId, (ViewGroup) this.a, true).setSaveFromParentEnabled(false);
        this.g = (XNumberPicker) xTimePicker.findViewById(yc0.hour);
        this.g.setMinValue(0);
        this.g.setMaxValue(23);
        this.g.setOnLongPressUpdateInterval(100L);
        String[] strArr = new String[24];
        for (int i3 = 0; i3 < strArr.length; i3++) {
            strArr[i3] = context.getResources().getString(bd0.x_time_picker_hour, Integer.valueOf(i3));
        }
        this.g.setDisplayedValues(strArr);
        this.g.setOnValueChangedListener(new a());
        this.h = (XNumberPicker) this.a.findViewById(yc0.minute);
        this.h.setMinValue(0);
        this.h.setMaxValue(59);
        this.h.setOnLongPressUpdateInterval(100L);
        this.h.setFormatter(XNumberPicker.getTwoDigitFormatter());
        String[] strArr2 = new String[60];
        for (int i4 = 0; i4 < strArr2.length; i4++) {
            strArr2[i4] = context.getResources().getString(bd0.x_time_picker_minute, Integer.valueOf(i4));
        }
        this.h.setDisplayedValues(strArr2);
        this.h.setOnValueChangedListener(new b());
        this.i = Calendar.getInstance(this.c);
        a(this.i.get(11), true);
        b(this.i.get(12), true);
        if (!this.j) {
            this.h.setEnabled(false);
            this.g.setEnabled(false);
            this.j = false;
        }
        if (this.a.getImportantForAccessibility() == 0) {
            this.a.setImportantForAccessibility(1);
        }
    }

    public final void a(int i, boolean z) {
        if (i == a()) {
            return;
        }
        this.f = 0L;
        this.g.setValue(i);
        if (z) {
            c();
        }
    }

    public final void b(int i, boolean z) {
        if (i == b()) {
            return;
        }
        this.f = 0L;
        this.h.setValue(i);
        if (z) {
            c();
        }
    }

    public final void c() {
        this.a.sendAccessibilityEvent(4);
        XTimePicker.c cVar = this.d;
        if (cVar != null) {
            ((XTimePicker.a) cVar).a(this.a, a(), b());
        }
        XTimePicker.c cVar2 = this.e;
        if (cVar2 != null) {
            ((XTimePicker.a) cVar2).a(this.a, a(), b());
        }
    }

    public int a() {
        return this.g.getValue();
    }

    public int b() {
        return this.h.getValue();
    }

    public void a(Parcelable parcelable) {
        if (parcelable instanceof XTimePicker.b.a) {
            XTimePicker.b.a aVar = (XTimePicker.b.a) parcelable;
            a(aVar.c, true);
            b(aVar.d, true);
        }
    }

    public Parcelable b(Parcelable parcelable) {
        return new XTimePicker.b.a(parcelable, a(), b());
    }
}
