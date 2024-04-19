package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* compiled from: TlsVersion.java */
/* renamed from: wk0  reason: default package */
/* loaded from: classes.dex */
public enum wk0 {
    TLS_1_3("TLSv1.3"),
    TLS_1_2("TLSv1.2"),
    TLS_1_1("TLSv1.1"),
    TLS_1_0("TLSv1"),
    SSL_3_0("SSLv3");
    
    public final String c;

    wk0(String str) {
        this.c = str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static List<wk0> a(String... strArr) {
        char c;
        wk0 wk0Var;
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            int hashCode = str.hashCode();
            if (hashCode == 79201641) {
                if (str.equals("SSLv3")) {
                    c = 4;
                }
                c = 65535;
            } else if (hashCode != 79923350) {
                switch (hashCode) {
                    case -503070503:
                        if (str.equals("TLSv1.1")) {
                            c = 2;
                            break;
                        }
                        c = 65535;
                        break;
                    case -503070502:
                        if (str.equals("TLSv1.2")) {
                            c = 1;
                            break;
                        }
                        c = 65535;
                        break;
                    case -503070501:
                        if (str.equals("TLSv1.3")) {
                            c = 0;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        c = 65535;
                        break;
                }
            } else {
                if (str.equals("TLSv1")) {
                    c = 3;
                }
                c = 65535;
            }
            if (c == 0) {
                wk0Var = TLS_1_3;
            } else if (c == 1) {
                wk0Var = TLS_1_2;
            } else if (c == 2) {
                wk0Var = TLS_1_1;
            } else if (c == 3) {
                wk0Var = TLS_1_0;
            } else if (c == 4) {
                wk0Var = SSL_3_0;
            } else {
                throw new IllegalArgumentException(jg.a("Unexpected TLS version: ", str));
            }
            arrayList.add(wk0Var);
        }
        return Collections.unmodifiableList(arrayList);
    }
}
