package defpackage;

import java.io.Closeable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TimeZone;
import java.util.regex.Pattern;
/* compiled from: Util.java */
/* renamed from: yk0  reason: default package */
/* loaded from: classes.dex */
public final class yk0 {
    public static final byte[] a = new byte[0];

    /* compiled from: Util.java */
    /* renamed from: yk0$a */
    /* loaded from: classes.dex */
    public class a implements Comparator<String> {
        @Override // java.util.Comparator
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    }

    static {
        vk0.a(a);
        byte[] bArr = a;
        a(bArr.length, 0, bArr.length);
        cl0.a("efbbbf");
        cl0.a("feff");
        cl0.a("fffe");
        cl0.a("0000ffff");
        cl0.a("ffff0000");
        Charset.forName("UTF-8");
        Charset.forName("UTF-16BE");
        Charset.forName("UTF-16LE");
        Charset.forName("UTF-32BE");
        Charset.forName("UTF-32LE");
        TimeZone.getTimeZone("GMT");
        Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    public static void a(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception unused) {
            }
        }
    }

    public static <T> List<T> a(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }
}
