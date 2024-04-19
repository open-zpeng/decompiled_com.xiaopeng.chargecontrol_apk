package defpackage;

import defpackage.mk;
import java.util.Queue;
/* compiled from: BaseKeyPool.java */
/* renamed from: dk  reason: default package */
/* loaded from: classes.dex */
public abstract class dk<T extends mk> {
    public final Queue<T> a = sq.a(20);

    public abstract T a();

    public void a(T t) {
        if (this.a.size() < 20) {
            this.a.offer(t);
        }
    }

    public T b() {
        T poll = this.a.poll();
        return poll == null ? a() : poll;
    }
}
