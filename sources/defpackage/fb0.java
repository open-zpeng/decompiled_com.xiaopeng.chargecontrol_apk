package defpackage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
/* compiled from: DateUtils.java */
/* renamed from: fb0  reason: default package */
/* loaded from: classes.dex */
public class fb0 {
    public static SimpleDateFormat a;
    public static SimpleDateFormat b;
    public static SimpleDateFormat c;

    static {
        new SimpleDateFormat("MM.dd");
        new SimpleDateFormat("yyyy.MM");
        new SimpleDateFormat("MM.dd");
        new SimpleDateFormat("MM月dd日");
        new SimpleDateFormat("yyyy年MM月dd日");
        new SimpleDateFormat("yyyy.MM.dd");
        new SimpleDateFormat("HH:mm:ss");
        a = new SimpleDateFormat("HH:mm");
        new SimpleDateFormat("yyyy-MM-dd");
        new SimpleDateFormat("yyMMddHHmmss");
        b = new SimpleDateFormat("yyyy/MM/dd");
        new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        c = new SimpleDateFormat("yyyyMMdd_HHmmss");
        new SimpleDateFormat("dd MMM yyyy");
        new SimpleDateFormat("dd.MMM yyyy");
        new SimpleDateFormat("dd MMM");
        new SimpleDateFormat("dd.MMM");
        new SimpleDateFormat("E,dd MMM");
        new SimpleDateFormat("E,dd.MMM");
    }

    public static synchronized String a(long j) {
        String format;
        synchronized (fb0.class) {
            format = c.format(Long.valueOf(j));
        }
        return format;
    }

    public static synchronized String b(long j) {
        String format;
        synchronized (fb0.class) {
            format = b.format(Long.valueOf(j));
        }
        return format;
    }

    public static synchronized String c(long j) {
        String format;
        synchronized (fb0.class) {
            format = a.format(Long.valueOf(j));
        }
        return format;
    }

    public static synchronized long a(String str) {
        long j;
        synchronized (fb0.class) {
            j = 0;
            try {
                j = c.parse(str).getTime();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return j;
    }
}
