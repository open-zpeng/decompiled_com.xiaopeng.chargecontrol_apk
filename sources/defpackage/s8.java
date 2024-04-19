package defpackage;

import android.util.Base64;
import java.util.List;
/* compiled from: FontRequest.java */
/* renamed from: s8  reason: default package */
/* loaded from: classes.dex */
public final class s8 {
    public final String a;
    public final String b;
    public final String c;
    public final List<List<byte[]>> d;
    public final int e;
    public final String f;

    public s8(String str, String str2, String str3, List<List<byte[]>> list) {
        if (str != null) {
            this.a = str;
            if (str2 != null) {
                this.b = str2;
                if (str3 != null) {
                    this.c = str3;
                    if (list != null) {
                        this.d = list;
                        this.e = 0;
                        this.f = str + "-" + str2 + "-" + str3;
                        return;
                    }
                    throw new NullPointerException();
                }
                throw new NullPointerException();
            }
            throw new NullPointerException();
        }
        throw new NullPointerException();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder a = jg.a("FontRequest {mProviderAuthority: ");
        a.append(this.a);
        a.append(", mProviderPackage: ");
        a.append(this.b);
        a.append(", mQuery: ");
        a.append(this.c);
        a.append(", mCertificates:");
        sb.append(a.toString());
        for (int i = 0; i < this.d.size(); i++) {
            sb.append(" [");
            List<byte[]> list = this.d.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i2), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.e);
        return sb.toString();
    }
}
