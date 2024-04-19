package defpackage;

import java.io.PrintStream;
import java.util.logging.Level;
/* compiled from: Logger.java */
/* renamed from: nl0  reason: default package */
/* loaded from: classes.dex */
public interface nl0 {

    /* compiled from: Logger.java */
    /* renamed from: nl0$a */
    /* loaded from: classes.dex */
    public static class a implements nl0 {
        @Override // defpackage.nl0
        public void a(Level level, String str) {
            PrintStream printStream = System.out;
            printStream.println("[" + level + "] " + str);
        }

        @Override // defpackage.nl0
        public void a(Level level, String str, Throwable th) {
            PrintStream printStream = System.out;
            printStream.println("[" + level + "] " + str);
            th.printStackTrace(System.out);
        }
    }

    void a(Level level, String str);

    void a(Level level, String str, Throwable th);
}
