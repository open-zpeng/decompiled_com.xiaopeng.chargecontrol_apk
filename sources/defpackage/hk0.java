package defpackage;

import java.io.Serializable;
/* compiled from: NotificationLite.java */
/* renamed from: hk0  reason: default package */
/* loaded from: classes.dex */
public enum hk0 {
    COMPLETE;

    /* compiled from: NotificationLite.java */
    /* renamed from: hk0$a */
    /* loaded from: classes.dex */
    public static final class a implements Serializable {
        public final kh0 c;

        public String toString() {
            StringBuilder a = jg.a("NotificationLite.Disposable[");
            a.append(this.c);
            a.append("]");
            return a.toString();
        }
    }

    /* compiled from: NotificationLite.java */
    /* renamed from: hk0$b */
    /* loaded from: classes.dex */
    public static final class b implements Serializable {
        public final Throwable c;

        public b(Throwable th) {
            this.c = th;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                Throwable th = this.c;
                Throwable th2 = ((b) obj).c;
                return th == th2 || (th != null && th.equals(th2));
            }
            return false;
        }

        public int hashCode() {
            return this.c.hashCode();
        }

        public String toString() {
            StringBuilder a = jg.a("NotificationLite.Error[");
            a.append(this.c);
            a.append("]");
            return a.toString();
        }
    }

    public static <T> Object a(T t) {
        return t;
    }

    public static Object a(Throwable th) {
        return new b(th);
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NotificationLite.Complete";
    }
}
