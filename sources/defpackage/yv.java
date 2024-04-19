package defpackage;
/* compiled from: JavaVersion.java */
/* renamed from: yv  reason: default package */
/* loaded from: classes.dex */
public final class yv {
    public static final int a;

    static {
        int i;
        int i2;
        String property = System.getProperty("java.version");
        try {
            String[] split = property.split("[._]");
            int parseInt = Integer.parseInt(split[0]);
            i = (parseInt != 1 || split.length <= 1) ? parseInt : Integer.parseInt(split[1]);
        } catch (NumberFormatException unused) {
            i = -1;
        }
        if (i == -1) {
            try {
                StringBuilder sb = new StringBuilder();
                for (int i3 = 0; i3 < property.length(); i3++) {
                    char charAt = property.charAt(i3);
                    if (!Character.isDigit(charAt)) {
                        break;
                    }
                    sb.append(charAt);
                }
                i2 = Integer.parseInt(sb.toString());
            } catch (NumberFormatException unused2) {
                i2 = -1;
            }
        } else {
            i2 = i;
        }
        if (i2 == -1) {
            i2 = 6;
        }
        a = i2;
    }
}
