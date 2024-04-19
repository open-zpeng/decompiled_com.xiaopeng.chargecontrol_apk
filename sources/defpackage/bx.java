package defpackage;

import java.util.TimeZone;
/* compiled from: ISO8601Utils.java */
/* renamed from: bx  reason: default package */
/* loaded from: classes.dex */
public class bx {
    public static final TimeZone a = TimeZone.getTimeZone("UTC");

    /* JADX WARN: Removed duplicated region for block: B:57:0x00dd A[Catch: IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01cc, NumberFormatException -> 0x01ce, IndexOutOfBoundsException -> 0x01d0, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01cc, blocks: (B:2:0x0000, B:4:0x0012, B:5:0x0014, B:7:0x0020, B:8:0x0022, B:10:0x0031, B:12:0x0037, B:16:0x004c, B:18:0x005c, B:19:0x005e, B:21:0x006a, B:22:0x006c, B:24:0x0072, B:28:0x007c, B:33:0x008c, B:35:0x0094, B:36:0x0098, B:38:0x009e, B:43:0x00ab, B:45:0x00b2, B:55:0x00d7, B:57:0x00dd, B:59:0x00e4, B:84:0x0193, B:64:0x00f0, B:65:0x010b, B:66:0x010c, B:70:0x0128, B:72:0x0135, B:75:0x013e, B:77:0x015d, B:80:0x016c, B:81:0x018e, B:83:0x0191, B:69:0x0117, B:86:0x01c4, B:87:0x01cb, B:49:0x00c2, B:50:0x00c5, B:44:0x00ae), top: B:103:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01c4 A[Catch: IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01cc, NumberFormatException -> 0x01ce, IndexOutOfBoundsException -> 0x01d0, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01cc, blocks: (B:2:0x0000, B:4:0x0012, B:5:0x0014, B:7:0x0020, B:8:0x0022, B:10:0x0031, B:12:0x0037, B:16:0x004c, B:18:0x005c, B:19:0x005e, B:21:0x006a, B:22:0x006c, B:24:0x0072, B:28:0x007c, B:33:0x008c, B:35:0x0094, B:36:0x0098, B:38:0x009e, B:43:0x00ab, B:45:0x00b2, B:55:0x00d7, B:57:0x00dd, B:59:0x00e4, B:84:0x0193, B:64:0x00f0, B:65:0x010b, B:66:0x010c, B:70:0x0128, B:72:0x0135, B:75:0x013e, B:77:0x015d, B:80:0x016c, B:81:0x018e, B:83:0x0191, B:69:0x0117, B:86:0x01c4, B:87:0x01cb, B:49:0x00c2, B:50:0x00c5, B:44:0x00ae), top: B:103:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Date a(java.lang.String r14, java.text.ParsePosition r15) {
        /*
            Method dump skipped, instructions count: 565
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bx.a(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    public static boolean a(String str, int i, char c) {
        return i < str.length() && str.charAt(i) == c;
    }

    public static int a(String str, int i, int i2) {
        int i3;
        int i4;
        if (i < 0 || i2 > str.length() || i > i2) {
            throw new NumberFormatException(str);
        }
        if (i < i2) {
            i4 = i + 1;
            int digit = Character.digit(str.charAt(i), 10);
            if (digit < 0) {
                StringBuilder a2 = jg.a("Invalid number: ");
                a2.append(str.substring(i, i2));
                throw new NumberFormatException(a2.toString());
            }
            i3 = -digit;
        } else {
            i3 = 0;
            i4 = i;
        }
        while (i4 < i2) {
            int i5 = i4 + 1;
            int digit2 = Character.digit(str.charAt(i4), 10);
            if (digit2 < 0) {
                StringBuilder a3 = jg.a("Invalid number: ");
                a3.append(str.substring(i, i2));
                throw new NumberFormatException(a3.toString());
            }
            i3 = (i3 * 10) - digit2;
            i4 = i5;
        }
        return -i3;
    }
}
