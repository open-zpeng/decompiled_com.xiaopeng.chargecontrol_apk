package defpackage;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/* compiled from: DiskCacheWriteLocker.java */
/* renamed from: qk  reason: default package */
/* loaded from: classes.dex */
public final class qk {
    public final Map<String, a> a = new HashMap();
    public final b b = new b();

    /* compiled from: DiskCacheWriteLocker.java */
    /* renamed from: qk$a */
    /* loaded from: classes.dex */
    public static class a {
        public final Lock a = new ReentrantLock();
        public int b;
    }

    public void a(String str) {
        a aVar;
        synchronized (this) {
            aVar = this.a.get(str);
            if (aVar == null) {
                aVar = this.b.a();
                this.a.put(str, aVar);
            }
            aVar.b++;
        }
        aVar.a.lock();
    }

    public void b(String str) {
        a aVar;
        synchronized (this) {
            a aVar2 = this.a.get(str);
            defpackage.a.a(aVar2, "Argument must not be null");
            aVar = aVar2;
            if (aVar.b >= 1) {
                aVar.b--;
                if (aVar.b == 0) {
                    a remove = this.a.remove(str);
                    if (remove.equals(aVar)) {
                        this.b.a(remove);
                    } else {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + remove + ", safeKey: " + str);
                    }
                }
            } else {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.b);
            }
        }
        aVar.a.unlock();
    }

    /* compiled from: DiskCacheWriteLocker.java */
    /* renamed from: qk$b */
    /* loaded from: classes.dex */
    public static class b {
        public final Queue<a> a = new ArrayDeque();

        public a a() {
            a poll;
            synchronized (this.a) {
                poll = this.a.poll();
            }
            return poll == null ? new a() : poll;
        }

        public void a(a aVar) {
            synchronized (this.a) {
                if (this.a.size() < 10) {
                    this.a.offer(aVar);
                }
            }
        }
    }
}
