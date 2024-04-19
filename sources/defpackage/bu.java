package defpackage;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
/* compiled from: DefaultDateTypeAdapter.java */
/* renamed from: bu  reason: default package */
/* loaded from: classes.dex */
public final class bu extends bv<Date> {
    public final Class<? extends Date> a;
    public final List<DateFormat> b = new ArrayList();

    public bu(Class<? extends Date> cls, String str) {
        a(cls);
        this.a = cls;
        this.b.add(new SimpleDateFormat(str, Locale.US));
        if (Locale.getDefault().equals(Locale.US)) {
            return;
        }
        this.b.add(new SimpleDateFormat(str));
    }

    public static Class<? extends Date> a(Class<? extends Date> cls) {
        if (cls == Date.class || cls == java.sql.Date.class || cls == Timestamp.class) {
            return cls;
        }
        throw new IllegalArgumentException("Date type must be one of " + Date.class + ", " + Timestamp.class + ", or " + java.sql.Date.class + " but was " + cls);
    }

    @Override // defpackage.bv
    public Date read(gx gxVar) {
        Date date;
        if (gxVar.s() == hx.NULL) {
            gxVar.p();
            return null;
        }
        Date a = a(gxVar.q());
        Class<? extends Date> cls = this.a;
        if (cls == Date.class) {
            return a;
        }
        if (cls == Timestamp.class) {
            date = new Timestamp(a.getTime());
        } else if (cls == java.sql.Date.class) {
            date = new java.sql.Date(a.getTime());
        } else {
            throw new AssertionError();
        }
        return date;
    }

    public String toString() {
        DateFormat dateFormat = this.b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            StringBuilder a = jg.a("DefaultDateTypeAdapter(");
            a.append(((SimpleDateFormat) dateFormat).toPattern());
            a.append(')');
            return a.toString();
        }
        StringBuilder a2 = jg.a("DefaultDateTypeAdapter(");
        a2.append(dateFormat.getClass().getSimpleName());
        a2.append(')');
        return a2.toString();
    }

    @Override // defpackage.bv
    /* renamed from: a */
    public void write(ix ixVar, Date date) {
        if (date == null) {
            ixVar.g();
            return;
        }
        synchronized (this.b) {
            ixVar.c(this.b.get(0).format(date));
        }
    }

    public bu(Class<? extends Date> cls, int i, int i2) {
        a(cls);
        this.a = cls;
        this.b.add(DateFormat.getDateTimeInstance(i, i2, Locale.US));
        if (!Locale.getDefault().equals(Locale.US)) {
            this.b.add(DateFormat.getDateTimeInstance(i, i2));
        }
        if (yv.a >= 9) {
            this.b.add(iv.a(i, i2));
        }
    }

    public final Date a(String str) {
        synchronized (this.b) {
            for (DateFormat dateFormat : this.b) {
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
    }
}
