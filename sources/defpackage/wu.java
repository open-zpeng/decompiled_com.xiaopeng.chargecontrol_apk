package defpackage;

import java.math.BigInteger;
/* compiled from: JsonPrimitive.java */
/* renamed from: wu  reason: default package */
/* loaded from: classes.dex */
public final class wu extends ru {
    public final Object a;

    public wu(Boolean bool) {
        if (bool != null) {
            this.a = bool;
            return;
        }
        throw new NullPointerException();
    }

    @Override // defpackage.ru
    public boolean a() {
        Object obj = this.a;
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return Boolean.parseBoolean(d());
    }

    @Override // defpackage.ru
    public int b() {
        return this.a instanceof Number ? h().intValue() : Integer.parseInt(d());
    }

    @Override // defpackage.ru
    public String d() {
        Object obj = this.a;
        if (obj instanceof Number) {
            return h().toString();
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).toString();
        }
        return (String) obj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || wu.class != obj.getClass()) {
            return false;
        }
        wu wuVar = (wu) obj;
        if (this.a == null) {
            return wuVar.a == null;
        } else if (a(this) && a(wuVar)) {
            return h().longValue() == wuVar.h().longValue();
        } else if ((this.a instanceof Number) && (wuVar.a instanceof Number)) {
            double doubleValue = h().doubleValue();
            double doubleValue2 = wuVar.h().doubleValue();
            if (doubleValue != doubleValue2) {
                return Double.isNaN(doubleValue) && Double.isNaN(doubleValue2);
            }
            return true;
        } else {
            return this.a.equals(wuVar.a);
        }
    }

    public Number h() {
        Object obj = this.a;
        return obj instanceof String ? new aw((String) obj) : (Number) obj;
    }

    public int hashCode() {
        long doubleToLongBits;
        if (this.a == null) {
            return 31;
        }
        if (a(this)) {
            doubleToLongBits = h().longValue();
        } else {
            Object obj = this.a;
            if (obj instanceof Number) {
                doubleToLongBits = Double.doubleToLongBits(h().doubleValue());
            } else {
                return obj.hashCode();
            }
        }
        return (int) ((doubleToLongBits >>> 32) ^ doubleToLongBits);
    }

    public boolean i() {
        return this.a instanceof String;
    }

    public wu(Number number) {
        if (number != null) {
            this.a = number;
            return;
        }
        throw new NullPointerException();
    }

    public static boolean a(wu wuVar) {
        Object obj = wuVar.a;
        if (obj instanceof Number) {
            Number number = (Number) obj;
            return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
        }
        return false;
    }

    public wu(String str) {
        if (str != null) {
            this.a = str;
            return;
        }
        throw new NullPointerException();
    }
}
