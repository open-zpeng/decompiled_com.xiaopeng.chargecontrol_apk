package defpackage;
/* compiled from: RequestCoordinator.java */
/* renamed from: op  reason: default package */
/* loaded from: classes.dex */
public interface op {

    /* compiled from: RequestCoordinator.java */
    /* renamed from: op$a */
    /* loaded from: classes.dex */
    public enum a {
        RUNNING(false),
        PAUSED(false),
        CLEARED(false),
        SUCCESS(true),
        FAILED(true);
        
        public final boolean c;

        a(boolean z) {
            this.c = z;
        }
    }

    boolean a();

    void b(np npVar);

    boolean c(np npVar);

    boolean d(np npVar);

    void e(np npVar);

    op f();

    boolean f(np npVar);
}
