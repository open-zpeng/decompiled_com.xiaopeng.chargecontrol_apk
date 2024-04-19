package defpackage;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/* compiled from: TimeTypeAdapter.java */
/* renamed from: uw  reason: default package */
/* loaded from: classes.dex */
public final class uw extends bv<Time> {
    public static final cv b = new a();
    public final DateFormat a = new SimpleDateFormat("hh:mm:ss a");

    /* compiled from: TimeTypeAdapter.java */
    /* renamed from: uw$a */
    /* loaded from: classes.dex */
    public class a implements cv {
        @Override // defpackage.cv
        public <T> bv<T> a(lu luVar, fx<T> fxVar) {
            if (fxVar.a == Time.class) {
                return new uw();
            }
            return null;
        }
    }

    @Override // defpackage.bv
    /* renamed from: a */
    public synchronized void write(ix ixVar, Time time) {
        ixVar.c(time == null ? null : this.a.format((Date) time));
    }

    @Override // defpackage.bv
    public synchronized Time read(gx gxVar) {
        if (gxVar.s() == hx.NULL) {
            gxVar.p();
            return null;
        }
        try {
            return new Time(this.a.parse(gxVar.q()).getTime());
        } catch (ParseException e) {
            throw new zu(e);
        }
    }
}
