package defpackage;

import java.io.IOException;
/* compiled from: HttpException.java */
/* renamed from: yh  reason: default package */
/* loaded from: classes.dex */
public final class yh extends IOException {
    public yh(int i) {
        super(jg.a("Http request failed with status code: ", i), null);
    }

    public yh(String str) {
        super(str, null);
    }

    public yh(String str, int i) {
        super(str, null);
    }
}
