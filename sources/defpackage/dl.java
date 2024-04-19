package defpackage;

import android.util.Log;
import defpackage.ji;
import defpackage.nl;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
/* compiled from: ByteBufferFileLoader.java */
/* renamed from: dl  reason: default package */
/* loaded from: classes.dex */
public class dl implements nl<File, ByteBuffer> {

    /* compiled from: ByteBufferFileLoader.java */
    /* renamed from: dl$b */
    /* loaded from: classes.dex */
    public static class b implements ol<File, ByteBuffer> {
        @Override // defpackage.ol
        public nl<File, ByteBuffer> a(rl rlVar) {
            return new dl();
        }
    }

    @Override // defpackage.nl
    public nl.a<ByteBuffer> a(File file, int i, int i2, bi biVar) {
        File file2 = file;
        return new nl.a<>(new iq(file2), new a(file2));
    }

    @Override // defpackage.nl
    public boolean a(File file) {
        return true;
    }

    /* compiled from: ByteBufferFileLoader.java */
    /* renamed from: dl$a */
    /* loaded from: classes.dex */
    public static final class a implements ji<ByteBuffer> {
        public final File c;

        public a(File file) {
            this.c = file;
        }

        @Override // defpackage.ji
        public void a(qg qgVar, ji.a<? super ByteBuffer> aVar) {
            try {
                aVar.a((ji.a<? super ByteBuffer>) jq.a(this.c));
            } catch (IOException e) {
                if (Log.isLoggable("ByteBufferFileLoader", 3)) {
                    Log.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", e);
                }
                aVar.a((Exception) e);
            }
        }

        @Override // defpackage.ji
        public void b() {
        }

        @Override // defpackage.ji
        public uh c() {
            return uh.LOCAL;
        }

        @Override // defpackage.ji
        public void cancel() {
        }

        @Override // defpackage.ji
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }
    }
}
