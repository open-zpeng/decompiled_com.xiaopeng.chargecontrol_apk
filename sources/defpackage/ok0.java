package defpackage;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
/* compiled from: CipherSuite.java */
/* renamed from: ok0  reason: default package */
/* loaded from: classes.dex */
public final class ok0 {
    public static final Comparator<String> b = new a();
    public static final Map<String, ok0> c = new TreeMap(b);
    public static final ok0 d;
    public static final ok0 e;
    public static final ok0 f;
    public static final ok0 g;
    public static final ok0 h;
    public static final ok0 i;
    public static final ok0 j;
    public static final ok0 k;
    public static final ok0 l;
    public static final ok0 m;
    public static final ok0 n;
    public static final ok0 o;
    public static final ok0 p;
    public static final ok0 q;
    public static final ok0 r;
    public final String a;

    /* compiled from: CipherSuite.java */
    /* renamed from: ok0$a */
    /* loaded from: classes.dex */
    public class a implements Comparator<String> {
        /* JADX WARN: Code restructure failed: missing block: B:19:?, code lost:
            return 1;
         */
        @Override // java.util.Comparator
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int compare(java.lang.String r7, java.lang.String r8) {
            /*
                r6 = this;
                java.lang.String r7 = (java.lang.String) r7
                java.lang.String r8 = (java.lang.String) r8
                int r0 = r7.length()
                int r1 = r8.length()
                int r0 = java.lang.Math.min(r0, r1)
                r1 = 4
            L11:
                r2 = -1
                r3 = 1
                if (r1 >= r0) goto L27
                char r4 = r7.charAt(r1)
                char r5 = r8.charAt(r1)
                if (r4 == r5) goto L24
                if (r4 >= r5) goto L22
                goto L35
            L22:
                r2 = r3
                goto L35
            L24:
                int r1 = r1 + 1
                goto L11
            L27:
                int r7 = r7.length()
                int r8 = r8.length()
                if (r7 == r8) goto L34
                if (r7 >= r8) goto L22
                goto L35
            L34:
                r2 = 0
            L35:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.ok0.a.compare(java.lang.Object, java.lang.Object):int");
        }
    }

    static {
        a("SSL_RSA_WITH_NULL_MD5");
        a("SSL_RSA_WITH_NULL_SHA");
        a("SSL_RSA_EXPORT_WITH_RC4_40_MD5");
        a("SSL_RSA_WITH_RC4_128_MD5");
        a("SSL_RSA_WITH_RC4_128_SHA");
        a("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA");
        a("SSL_RSA_WITH_DES_CBC_SHA");
        d = a("SSL_RSA_WITH_3DES_EDE_CBC_SHA");
        a("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA");
        a("SSL_DHE_DSS_WITH_DES_CBC_SHA");
        a("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA");
        a("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA");
        a("SSL_DHE_RSA_WITH_DES_CBC_SHA");
        a("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA");
        a("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5");
        a("SSL_DH_anon_WITH_RC4_128_MD5");
        a("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA");
        a("SSL_DH_anon_WITH_DES_CBC_SHA");
        a("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA");
        a("TLS_KRB5_WITH_DES_CBC_SHA");
        a("TLS_KRB5_WITH_3DES_EDE_CBC_SHA");
        a("TLS_KRB5_WITH_RC4_128_SHA");
        a("TLS_KRB5_WITH_DES_CBC_MD5");
        a("TLS_KRB5_WITH_3DES_EDE_CBC_MD5");
        a("TLS_KRB5_WITH_RC4_128_MD5");
        a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA");
        a("TLS_KRB5_EXPORT_WITH_RC4_40_SHA");
        a("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5");
        a("TLS_KRB5_EXPORT_WITH_RC4_40_MD5");
        e = a("TLS_RSA_WITH_AES_128_CBC_SHA");
        a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA");
        a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA");
        a("TLS_DH_anon_WITH_AES_128_CBC_SHA");
        f = a("TLS_RSA_WITH_AES_256_CBC_SHA");
        a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA");
        a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA");
        a("TLS_DH_anon_WITH_AES_256_CBC_SHA");
        a("TLS_RSA_WITH_NULL_SHA256");
        a("TLS_RSA_WITH_AES_128_CBC_SHA256");
        a("TLS_RSA_WITH_AES_256_CBC_SHA256");
        a("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256");
        a("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA");
        a("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA");
        a("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA");
        a("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256");
        a("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256");
        a("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256");
        a("TLS_DH_anon_WITH_AES_128_CBC_SHA256");
        a("TLS_DH_anon_WITH_AES_256_CBC_SHA256");
        a("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA");
        a("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA");
        a("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA");
        a("TLS_PSK_WITH_RC4_128_SHA");
        a("TLS_PSK_WITH_3DES_EDE_CBC_SHA");
        a("TLS_PSK_WITH_AES_128_CBC_SHA");
        a("TLS_PSK_WITH_AES_256_CBC_SHA");
        a("TLS_RSA_WITH_SEED_CBC_SHA");
        g = a("TLS_RSA_WITH_AES_128_GCM_SHA256");
        h = a("TLS_RSA_WITH_AES_256_GCM_SHA384");
        a("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256");
        a("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384");
        a("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256");
        a("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384");
        a("TLS_DH_anon_WITH_AES_128_GCM_SHA256");
        a("TLS_DH_anon_WITH_AES_256_GCM_SHA384");
        a("TLS_EMPTY_RENEGOTIATION_INFO_SCSV");
        a("TLS_FALLBACK_SCSV");
        a("TLS_ECDH_ECDSA_WITH_NULL_SHA");
        a("TLS_ECDH_ECDSA_WITH_RC4_128_SHA");
        a("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA");
        a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA");
        a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA");
        a("TLS_ECDHE_ECDSA_WITH_NULL_SHA");
        a("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA");
        a("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA");
        i = a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA");
        j = a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA");
        a("TLS_ECDH_RSA_WITH_NULL_SHA");
        a("TLS_ECDH_RSA_WITH_RC4_128_SHA");
        a("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA");
        a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA");
        a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA");
        a("TLS_ECDHE_RSA_WITH_NULL_SHA");
        a("TLS_ECDHE_RSA_WITH_RC4_128_SHA");
        a("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA");
        k = a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA");
        l = a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA");
        a("TLS_ECDH_anon_WITH_NULL_SHA");
        a("TLS_ECDH_anon_WITH_RC4_128_SHA");
        a("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA");
        a("TLS_ECDH_anon_WITH_AES_128_CBC_SHA");
        a("TLS_ECDH_anon_WITH_AES_256_CBC_SHA");
        a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256");
        a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384");
        a("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256");
        a("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384");
        a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256");
        a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384");
        a("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256");
        a("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384");
        m = a("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256");
        n = a("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384");
        a("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256");
        a("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384");
        o = a("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256");
        p = a("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384");
        a("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256");
        a("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384");
        a("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA");
        a("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA");
        q = a("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256");
        r = a("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256");
    }

    public ok0(String str) {
        if (str != null) {
            this.a = str;
            return;
        }
        throw new NullPointerException();
    }

    public static synchronized ok0 a(String str) {
        ok0 ok0Var;
        synchronized (ok0.class) {
            ok0Var = c.get(str);
            if (ok0Var == null) {
                ok0Var = new ok0(str);
                c.put(str, ok0Var);
            }
        }
        return ok0Var;
    }

    public String toString() {
        return this.a;
    }
}
