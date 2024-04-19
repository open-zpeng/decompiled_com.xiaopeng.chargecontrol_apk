package defpackage;

import android.util.Log;
import java.io.Writer;
/* compiled from: LogWriter.java */
/* renamed from: kd  reason: default package */
/* loaded from: classes.dex */
public final class kd extends Writer {
    public final String c;
    public StringBuilder d = new StringBuilder(128);

    public kd(String str) {
        this.c = str;
    }

    public final void a() {
        if (this.d.length() > 0) {
            Log.d(this.c, this.d.toString());
            StringBuilder sb = this.d;
            sb.delete(0, sb.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        a();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        a();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                a();
            } else {
                this.d.append(c);
            }
        }
    }
}
