package defpackage;

import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
/* compiled from: ResourcesCompat.java */
/* renamed from: u7  reason: default package */
/* loaded from: classes.dex */
public abstract class u7 {

    /* compiled from: ResourcesCompat.java */
    /* renamed from: u7$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ Typeface c;

        public a(Typeface typeface) {
            this.c = typeface;
        }

        @Override // java.lang.Runnable
        public void run() {
            u7.this.a(this.c);
        }
    }

    /* compiled from: ResourcesCompat.java */
    /* renamed from: u7$b */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public final /* synthetic */ int c;

        public b(int i) {
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            u7.this.a(this.c);
        }
    }

    public abstract void a(int i);

    public abstract void a(Typeface typeface);

    public final void a(Typeface typeface, Handler handler) {
        a(handler).post(new a(typeface));
    }

    public final void a(int i, Handler handler) {
        a(handler).post(new b(i));
    }

    public static Handler a(Handler handler) {
        return handler == null ? new Handler(Looper.getMainLooper()) : handler;
    }
}
