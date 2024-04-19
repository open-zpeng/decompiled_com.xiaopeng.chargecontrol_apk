package defpackage;

import java.lang.reflect.Field;
import java.util.Locale;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: FieldNamingPolicy.java */
/* renamed from: eu  reason: default package */
/* loaded from: classes.dex */
public abstract class eu implements fu {
    public static final eu c = new a("IDENTITY", 0);
    public static final eu d = new eu("UPPER_CAMEL_CASE", 1) { // from class: eu.b
        @Override // defpackage.fu
        public String a(Field field) {
            return eu.a(field.getName());
        }
    };
    public static final eu e = new eu("UPPER_CAMEL_CASE_WITH_SPACES", 2) { // from class: eu.c
        @Override // defpackage.fu
        public String a(Field field) {
            return eu.a(eu.a(field.getName(), " "));
        }
    };
    public static final eu f = new eu("LOWER_CASE_WITH_UNDERSCORES", 3) { // from class: eu.d
        @Override // defpackage.fu
        public String a(Field field) {
            return eu.a(field.getName(), "_").toLowerCase(Locale.ENGLISH);
        }
    };
    public static final eu g = new eu("LOWER_CASE_WITH_DASHES", 4) { // from class: eu.e
        @Override // defpackage.fu
        public String a(Field field) {
            return eu.a(field.getName(), "-").toLowerCase(Locale.ENGLISH);
        }
    };
    public static final eu h = new eu("LOWER_CASE_WITH_DOTS", 5) { // from class: eu.f
        @Override // defpackage.fu
        public String a(Field field) {
            return eu.a(field.getName(), ".").toLowerCase(Locale.ENGLISH);
        }
    };
    public static final /* synthetic */ eu[] i = {c, d, e, f, g, h};

    /* compiled from: FieldNamingPolicy.java */
    /* renamed from: eu$a */
    /* loaded from: classes.dex */
    public enum a extends eu {
        public a(String str, int i) {
            super(str, i, null);
        }

        @Override // defpackage.fu
        public String a(Field field) {
            return field.getName();
        }
    }

    public /* synthetic */ eu(String str, int i2, a aVar) {
    }

    public static String a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (Character.isUpperCase(charAt) && sb.length() != 0) {
                sb.append(str2);
            }
            sb.append(charAt);
        }
        return sb.toString();
    }

    public static eu valueOf(String str) {
        return (eu) Enum.valueOf(eu.class, str);
    }

    public static eu[] values() {
        return (eu[]) i.clone();
    }

    public static String a(String str) {
        int length = str.length() - 1;
        int i2 = 0;
        while (!Character.isLetter(str.charAt(i2)) && i2 < length) {
            i2++;
        }
        char charAt = str.charAt(i2);
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        char upperCase = Character.toUpperCase(charAt);
        if (i2 == 0) {
            return upperCase + str.substring(1);
        }
        return str.substring(0, i2) + upperCase + str.substring(i2 + 1);
    }
}
