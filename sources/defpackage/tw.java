package defpackage;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/* compiled from: SqlDateTypeAdapter.java */
/* renamed from: tw  reason: default package */
/* loaded from: classes.dex */
public final class tw extends bv<Date> {
    public static final cv b = new a();
    public final DateFormat a = new SimpleDateFormat("MMM d, yyyy");

    /* compiled from: SqlDateTypeAdapter.java */
    /* renamed from: tw$a */
    /* loaded from: classes.dex */
    public class a implements cv {
        @Override // defpackage.cv
        public <T> bv<T> a(lu luVar, fx<T> fxVar) {
            if (fxVar.a == Date.class) {
                return new tw();
            }
            return null;
        }
    }

    @Override // defpackage.bv
    /* renamed from: a */
    public synchronized void write(ix ixVar, Date date) {
        ixVar.c(date == null ? null : this.a.format((java.util.Date) date));
    }

    @Override // defpackage.bv
    public synchronized Date read(gx gxVar) {
        if (gxVar.s() == hx.NULL) {
            gxVar.p();
            return null;
        }
        try {
            return new Date(this.a.parse(gxVar.q()).getTime());
        } catch (ParseException e) {
            throw new zu(e);
        }
    }
}
