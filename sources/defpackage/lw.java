package defpackage;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
/* compiled from: DateTypeAdapter.java */
/* renamed from: lw  reason: default package */
/* loaded from: classes.dex */
public final class lw extends bv<Date> {
    public static final cv b = new a();
    public final List<DateFormat> a = new ArrayList();

    /* compiled from: DateTypeAdapter.java */
    /* renamed from: lw$a */
    /* loaded from: classes.dex */
    public class a implements cv {
        @Override // defpackage.cv
        public <T> bv<T> a(lu luVar, fx<T> fxVar) {
            if (fxVar.a == Date.class) {
                return new lw();
            }
            return null;
        }
    }

    public lw() {
        this.a.add(DateFormat.getDateTimeInstance(2, 2, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.a.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (yv.a >= 9) {
            this.a.add(iv.a(2, 2));
        }
    }

    public final synchronized Date a(String str) {
        for (DateFormat dateFormat : this.a) {
            try {
                return dateFormat.parse(str);
            } catch (ParseException unused) {
            }
        }
        try {
            return bx.a(str, new ParsePosition(0));
        } catch (ParseException e) {
            throw new zu(str, e);
        }
    }

    @Override // defpackage.bv
    public Date read(gx gxVar) {
        if (gxVar.s() == hx.NULL) {
            gxVar.p();
            return null;
        }
        return a(gxVar.q());
    }

    @Override // defpackage.bv
    /* renamed from: a */
    public synchronized void write(ix ixVar, Date date) {
        if (date == null) {
            ixVar.g();
        } else {
            ixVar.c(this.a.get(0).format(date));
        }
    }
}
