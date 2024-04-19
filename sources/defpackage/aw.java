package defpackage;

import java.math.BigDecimal;
/* compiled from: LazilyParsedNumber.java */
/* renamed from: aw  reason: default package */
/* loaded from: classes.dex */
public final class aw extends Number {
    public final String c;

    public aw(String str) {
        this.c = str;
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof aw) {
            String str = this.c;
            String str2 = ((aw) obj).c;
            return str == str2 || str.equals(str2);
        }
        return false;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.c);
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            try {
                return Integer.parseInt(this.c);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(this.c);
            }
        } catch (NumberFormatException unused2) {
            return new BigDecimal(this.c).intValue();
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.c);
        } catch (NumberFormatException unused) {
            return new BigDecimal(this.c).longValue();
        }
    }

    public String toString() {
        return this.c;
    }
}
