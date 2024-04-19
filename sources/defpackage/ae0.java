package defpackage;

import android.media.AudioManager;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* compiled from: XSoundEffectManager.java */
/* renamed from: ae0  reason: default package */
/* loaded from: classes.dex */
public class ae0 {
    public boolean c;
    public ConcurrentHashMap<Integer, zd0> a = new ConcurrentHashMap<>();
    public ExecutorService b = Executors.newSingleThreadExecutor();
    public ConcurrentHashMap<Integer, Boolean> d = new ConcurrentHashMap<>();

    /* compiled from: XSoundEffectManager.java */
    /* renamed from: ae0$b */
    /* loaded from: classes.dex */
    public static class b {
        public static final ae0 a = new ae0(null);
    }

    /* compiled from: XSoundEffectManager.java */
    /* renamed from: ae0$c */
    /* loaded from: classes.dex */
    public static class c {
        public AudioManager a;

        /* compiled from: XSoundEffectManager.java */
        /* renamed from: ae0$c$a */
        /* loaded from: classes.dex */
        public static class a {
            public static final c a = new c(null);
        }

        public /* synthetic */ c(a aVar) {
        }
    }

    public /* synthetic */ ae0(a aVar) {
    }

    public /* synthetic */ void a(int i) {
        if (this.c) {
            be0.a("xpui-XSoundManager", String.format("play-not for destroy resource:%s", Integer.valueOf(i)));
            return;
        }
        Boolean bool = this.d.get(Integer.valueOf(i));
        if (bool != null && bool.booleanValue()) {
            be0.a("xpui-XSoundManager", String.format("play-not for release resource:%s", Integer.valueOf(i)));
            return;
        }
        System.currentTimeMillis();
        zd0 zd0Var = this.a.get(Integer.valueOf(i));
        if (zd0Var == null) {
            zd0Var = new xd0(wd0.a.get(i));
            this.a.put(Integer.valueOf(i), zd0Var);
        }
        ((xd0) zd0Var).c();
    }

    public synchronized void b(final int i) {
        int i2 = i != 2 ? i != 3 ? i != 4 ? i != 5 ? -1 : 14 : 15 : 16 : 17;
        try {
            if (i2 > 0) {
                c cVar = c.a.a;
                if (cVar.a == null) {
                    cVar.a = (AudioManager) z90.c().getSystemService("audio");
                }
                cVar.a.playSoundEffect(i2);
            } else {
                this.c = false;
                this.d.put(Integer.valueOf(i), false);
                this.b.execute(new Runnable() { // from class: ud0
                    @Override // java.lang.Runnable
                    public final void run() {
                        ae0.this.a(i);
                    }
                });
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
