package defpackage;

import android.content.res.Configuration;
import android.icu.util.Calendar;
import android.widget.LinearLayout;
import com.xiaopeng.libconfig.remotecontrol.RemoteControlFeedbackConstant;
import com.xiaopeng.xui.widget.XNumberPicker;
import com.xiaopeng.xui.widget.datepicker.XDatePicker;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.Locale;
/* compiled from: XDatePickerSpinnerDelegate.java */
/* renamed from: yf0  reason: default package */
/* loaded from: classes.dex */
public class yf0 extends XDatePicker.b {
    public final LinearLayout g;
    public XNumberPicker h;
    public XNumberPicker i;
    public XNumberPicker j;
    public String[] k;
    public final DateFormat l;
    public int m;
    public Calendar n;
    public Calendar o;
    public Calendar p;
    public boolean q;

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00e7, code lost:
        if (r9 == 'M') goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public yf0(com.xiaopeng.xui.widget.datepicker.XDatePicker r19, android.content.Context r20, android.util.AttributeSet r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 552
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.yf0.<init>(com.xiaopeng.xui.widget.datepicker.XDatePicker, android.content.Context, android.util.AttributeSet, int, int):void");
    }

    public /* synthetic */ void a(XNumberPicker xNumberPicker, int i, int i2) {
        this.n.setTimeInMillis(this.c.getTimeInMillis());
        if (xNumberPicker == this.h) {
            int actualMaximum = this.n.getActualMaximum(5);
            if (i == actualMaximum && i2 == 1) {
                this.n.add(5, 1);
            } else if (i == 1 && i2 == actualMaximum) {
                this.n.add(5, -1);
            } else {
                this.n.add(5, i2 - i);
            }
        } else if (xNumberPicker == this.i) {
            if (i == 11 && i2 == 0) {
                this.n.add(2, 1);
            } else if (i == 0 && i2 == 11) {
                this.n.add(2, -1);
            } else {
                this.n.add(2, i2 - i);
            }
        } else if (xNumberPicker == this.j) {
            this.n.set(1, i2);
        } else {
            throw new IllegalArgumentException();
        }
        a(this.n.get(1), this.n.get(2), this.n.get(5));
        d();
        this.a.sendAccessibilityEvent(4);
        XDatePicker.c cVar = this.e;
        if (cVar != null) {
            ((XDatePicker.a) cVar).a(this.a, c(), b(), a());
        }
        XDatePicker.c cVar2 = this.f;
        if (cVar2 != null) {
            ((XDatePicker.a) cVar2).a(this.a, c(), b(), a());
        }
    }

    public int b() {
        return this.c.get(2);
    }

    public int c() {
        return this.c.get(1);
    }

    public final void d() {
        if (this.c.equals(this.o)) {
            this.h.setMinValue(this.c.get(5));
            this.h.setMaxValue(this.c.getActualMaximum(5));
            this.h.setWrapSelectorWheel(false);
            this.i.setDisplayedValues(null);
            this.i.setMinValue(this.c.get(2));
            this.i.setMaxValue(this.c.getActualMaximum(2));
            this.i.setWrapSelectorWheel(false);
        } else if (this.c.equals(this.p)) {
            this.h.setMinValue(this.c.getActualMinimum(5));
            this.h.setMaxValue(this.c.get(5));
            this.h.setWrapSelectorWheel(false);
            this.i.setDisplayedValues(null);
            this.i.setMinValue(this.c.getActualMinimum(2));
            this.i.setMaxValue(this.c.get(2));
            this.i.setWrapSelectorWheel(false);
        } else {
            this.h.setMinValue(1);
            this.h.setMaxValue(this.c.getActualMaximum(5));
            this.h.setWrapSelectorWheel(true);
            this.i.setDisplayedValues(null);
            this.i.setMinValue(0);
            this.i.setMaxValue(11);
            this.i.setWrapSelectorWheel(true);
        }
        String[] strArr = new String[this.c.getActualMaximum(5)];
        int i = 0;
        while (i < this.c.getActualMaximum(5)) {
            int i2 = i + 1;
            strArr[i] = this.b.getResources().getString(bd0.x_date_picker_day, Integer.valueOf(i2));
            i = i2;
        }
        this.h.setDisplayedValues(strArr);
        this.i.setDisplayedValues((String[]) Arrays.copyOfRange(this.k, this.i.getMinValue(), this.i.getMaxValue() + 1));
        this.j.setMinValue(this.o.get(1));
        this.j.setMaxValue(this.p.get(1));
        String[] strArr2 = new String[RemoteControlFeedbackConstant.SUCCESS_WAKE_UP];
        for (int i3 = 0; i3 < strArr2.length; i3++) {
            strArr2[i3] = this.b.getResources().getString(bd0.x_date_picker_year, Integer.valueOf(this.j.getMinValue() + i3));
        }
        this.j.setDisplayedValues(strArr2);
        this.j.setWrapSelectorWheel(false);
        this.j.setValue(this.c.get(1));
        this.i.setValue(this.c.get(2));
        this.h.setValue(this.c.get(5));
    }

    public void b(long j) {
        this.n.setTimeInMillis(j);
        if (this.n.get(1) == this.o.get(1) && this.n.get(6) == this.o.get(6)) {
            return;
        }
        this.o.setTimeInMillis(j);
        if (this.c.before(this.o)) {
            this.c.setTimeInMillis(this.o.getTimeInMillis());
        }
        d();
    }

    public final void a(int i, int i2, int i3) {
        this.c.set(i, i2, i3);
        if (this.c.before(this.o)) {
            this.c.setTimeInMillis(this.o.getTimeInMillis());
        } else if (this.c.after(this.p)) {
            this.c.setTimeInMillis(this.p.getTimeInMillis());
        }
    }

    public int a() {
        return this.c.get(5);
    }

    public void a(long j) {
        this.n.setTimeInMillis(j);
        if (this.n.get(1) == this.p.get(1) && this.n.get(6) == this.p.get(6)) {
            return;
        }
        this.p.setTimeInMillis(j);
        if (this.c.after(this.p)) {
            this.c.setTimeInMillis(this.p.getTimeInMillis());
        }
        d();
    }

    @Override // com.xiaopeng.xui.widget.datepicker.XDatePicker.b
    public void a(Locale locale) {
        super.a(locale);
        this.n = a(this.n, locale);
        this.o = a(this.o, locale);
        this.p = a(this.p, locale);
        this.c = a(this.c, locale);
        this.m = this.n.getActualMaximum(2) + 1;
        this.k = new DateFormatSymbols().getShortMonths();
    }

    public final Calendar a(Calendar calendar, Locale locale) {
        if (calendar == null) {
            return Calendar.getInstance(locale);
        }
        long timeInMillis = calendar.getTimeInMillis();
        Calendar calendar2 = Calendar.getInstance(locale);
        calendar2.setTimeInMillis(timeInMillis);
        return calendar2;
    }

    public void a(Configuration configuration) {
        a(configuration.getLocales().get(0));
    }
}
