package defpackage;

import android.content.Context;
import com.xiaopeng.chargecontrol.widget.ThreeColumnsPicker;
import com.xiaopeng.xui.widget.XNumberPicker;
/* compiled from: AppointmentDialog.java */
/* renamed from: t30  reason: default package */
/* loaded from: classes.dex */
public class t30 extends e10 {
    public ThreeColumnsPicker q;

    /* compiled from: AppointmentDialog.java */
    /* renamed from: t30$a */
    /* loaded from: classes.dex */
    public static final class a implements XNumberPicker.c {
        public Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // com.xiaopeng.xui.widget.XNumberPicker.c
        public String a(int i) {
            return this.a.getString(r90.hour_unit_format, XNumberPicker.getTwoDigitFormatter().a(i));
        }
    }

    /* compiled from: AppointmentDialog.java */
    /* renamed from: t30$b */
    /* loaded from: classes.dex */
    public static final class b implements XNumberPicker.c {
        public Context a;

        public b(Context context) {
            this.a = context;
        }

        @Override // com.xiaopeng.xui.widget.XNumberPicker.c
        public String a(int i) {
            return this.a.getString(r90.minute_unit_format, XNumberPicker.getTwoDigitFormatter().a(i));
        }
    }

    public t30(Context context) {
        super(context, s90.XDialogView_Large);
        a(q90.dialog_appointment_time, false);
        this.q = (ThreeColumnsPicker) b().findViewById(o90.picker);
        ThreeColumnsPicker threeColumnsPicker = this.q;
        if (threeColumnsPicker == null) {
            return;
        }
        threeColumnsPicker.setSecondMinValue(0);
        this.q.setSecondMaxValue(23);
        this.q.setSecondFormatter(new a(this.n));
        this.q.setThirdMinValue(0);
        this.q.setThirdMaxValue(59);
        this.q.setThirdFormatter(new b(this.n));
    }
}
