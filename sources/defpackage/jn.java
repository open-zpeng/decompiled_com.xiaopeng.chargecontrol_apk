package defpackage;

import defpackage.ki;
import java.nio.ByteBuffer;
/* compiled from: ByteBufferRewinder.java */
/* renamed from: jn  reason: default package */
/* loaded from: classes.dex */
public class jn implements ki<ByteBuffer> {
    public final ByteBuffer a;

    public jn(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
    }

    @Override // defpackage.ki
    public ByteBuffer a() {
        this.a.position(0);
        return this.a;
    }

    @Override // defpackage.ki
    public void b() {
    }

    /* compiled from: ByteBufferRewinder.java */
    /* renamed from: jn$a */
    /* loaded from: classes.dex */
    public static class a implements ki.a<ByteBuffer> {
        @Override // defpackage.ki.a
        public ki<ByteBuffer> a(ByteBuffer byteBuffer) {
            return new jn(byteBuffer);
        }

        @Override // defpackage.ki.a
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }
    }
}
