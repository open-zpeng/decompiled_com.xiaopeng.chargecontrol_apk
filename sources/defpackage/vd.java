package defpackage;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: Lifecycle.java */
/* renamed from: vd  reason: default package */
/* loaded from: classes.dex */
public abstract class vd {

    /* compiled from: Lifecycle.java */
    /* renamed from: vd$b */
    /* loaded from: classes.dex */
    public enum b {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public boolean a(b bVar) {
            return compareTo(bVar) >= 0;
        }
    }

    public vd() {
        new AtomicReference();
    }

    public abstract void a(yd ydVar);

    public abstract void b(yd ydVar);

    /* compiled from: Lifecycle.java */
    /* renamed from: vd$a */
    /* loaded from: classes.dex */
    public enum a {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;

        public static a a(b bVar) {
            int ordinal = bVar.ordinal();
            if (ordinal != 2) {
                if (ordinal != 3) {
                    if (ordinal != 4) {
                        return null;
                    }
                    return ON_PAUSE;
                }
                return ON_STOP;
            }
            return ON_DESTROY;
        }

        public static a b(b bVar) {
            int ordinal = bVar.ordinal();
            if (ordinal != 1) {
                if (ordinal != 2) {
                    if (ordinal != 3) {
                        return null;
                    }
                    return ON_RESUME;
                }
                return ON_START;
            }
            return ON_CREATE;
        }

        public b a() {
            int ordinal = ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (ordinal == 2) {
                        return b.RESUMED;
                    }
                    if (ordinal != 3) {
                        if (ordinal != 4) {
                            if (ordinal == 5) {
                                return b.DESTROYED;
                            }
                            throw new IllegalArgumentException(this + " has no target state");
                        }
                    }
                }
                return b.STARTED;
            }
            return b.CREATED;
        }
    }
}
