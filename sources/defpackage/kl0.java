package defpackage;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* compiled from: EventBusBuilder.java */
/* renamed from: kl0  reason: default package */
/* loaded from: classes.dex */
public class kl0 {
    public static final ExecutorService m = Executors.newCachedThreadPool();
    public boolean e;
    public boolean g;
    public boolean h;
    public List<am0> j;
    public nl0 k;
    public ol0 l;
    public boolean a = true;
    public boolean b = true;
    public boolean c = true;
    public boolean d = true;
    public boolean f = true;
    public ExecutorService i = m;

    public jl0 a() {
        jl0 jl0Var;
        synchronized (jl0.class) {
            if (jl0.s == null) {
                jl0.s = new jl0(this);
                jl0Var = jl0.s;
            } else {
                throw new ll0("Default instance already exists. It may be only set once before it's used the first time to ensure consistent behavior.");
            }
        }
        return jl0Var;
    }
}
