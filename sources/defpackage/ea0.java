package defpackage;

import defpackage.x10;
/* compiled from: Singleton.java */
/* renamed from: ea0  reason: default package */
/* loaded from: classes.dex */
public abstract class ea0<T> {
    public volatile T a;

    public final T a() {
        if (this.a == null) {
            synchronized (this) {
                if (this.a == null) {
                    x10.a aVar = (x10.a) this;
                    this.a = (T) new w10();
                }
            }
        }
        return this.a;
    }
}
