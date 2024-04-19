package defpackage;

import java.util.concurrent.Executor;
/* compiled from: ArchTaskExecutor.java */
/* renamed from: t4  reason: default package */
/* loaded from: classes.dex */
public class t4 extends v4 {
    public static volatile t4 c;
    public v4 b = new u4();
    public v4 a = this.b;

    /* compiled from: ArchTaskExecutor.java */
    /* renamed from: t4$a */
    /* loaded from: classes.dex */
    public static class a implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            t4.b().b(runnable);
        }
    }

    /* compiled from: ArchTaskExecutor.java */
    /* renamed from: t4$b */
    /* loaded from: classes.dex */
    public static class b implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            t4.b().a(runnable);
        }
    }

    public static t4 b() {
        if (c != null) {
            return c;
        }
        synchronized (t4.class) {
            if (c == null) {
                c = new t4();
            }
        }
        return c;
    }

    @Override // defpackage.v4
    public void a(Runnable runnable) {
        this.a.a(runnable);
    }

    @Override // defpackage.v4
    public boolean a() {
        return this.a.a();
    }

    @Override // defpackage.v4
    public void b(Runnable runnable) {
        this.a.b(runnable);
    }
}
