package defpackage;
/* compiled from: Protocol.java */
/* renamed from: sk0  reason: default package */
/* loaded from: classes.dex */
public enum sk0 {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");
    
    public final String c;

    sk0(String str) {
        this.c = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.c;
    }
}
