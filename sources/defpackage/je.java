package defpackage;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
/* compiled from: ViewModel.java */
/* renamed from: je  reason: default package */
/* loaded from: classes.dex */
public abstract class je {
    public final Map<String, Object> a = new HashMap();

    public final void a() {
        Map<String, Object> map = this.a;
        if (map != null) {
            synchronized (map) {
                for (Object obj : this.a.values()) {
                    if (obj instanceof Closeable) {
                        try {
                            ((Closeable) obj).close();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
        b();
    }

    public void b() {
    }

    public <T> T a(String str) {
        T t;
        Map<String, Object> map = this.a;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            t = (T) this.a.get(str);
        }
        return t;
    }
}
