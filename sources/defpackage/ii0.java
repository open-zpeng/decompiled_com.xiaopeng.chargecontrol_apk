package defpackage;

import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: BasicIntQueueDisposable.java */
/* renamed from: ii0  reason: default package */
/* loaded from: classes.dex */
public abstract class ii0<T> extends AtomicInteger implements di0<T> {
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called");
    }
}
