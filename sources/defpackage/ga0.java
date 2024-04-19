package defpackage;

import android.view.View;
import java.util.Iterator;
import java.util.Map;
/* compiled from: ViewHandler.java */
/* renamed from: ga0  reason: default package */
/* loaded from: classes.dex */
public class ga0 {
    public View a;
    public final y4<b, Runnable> b = new y4<>();

    /* compiled from: ViewHandler.java */
    /* renamed from: ga0$a */
    /* loaded from: classes.dex */
    public class a implements View.OnAttachStateChangeListener {
        public a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ga0.this.a.removeOnAttachStateChangeListener(this);
            synchronized (ga0.this.b) {
                for (b bVar : ga0.this.b.keySet()) {
                    ga0.this.a.removeCallbacks(bVar);
                }
                ga0.this.b.clear();
            }
        }
    }

    /* compiled from: ViewHandler.java */
    /* renamed from: ga0$b */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public Runnable c;

        public b(Runnable runnable) {
            this.c = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            ga0.this.c(this.c);
            this.c.run();
        }
    }

    public ga0(View view) {
        this.a = view;
        this.a.addOnAttachStateChangeListener(new a());
    }

    public static ga0 a(View view) {
        return new ga0(view);
    }

    public void b(Runnable runnable) {
        this.a.post(a(runnable));
    }

    public final b c(Runnable runnable) {
        synchronized (this.b) {
            Iterator<Map.Entry<b, Runnable>> it = this.b.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<b, Runnable> next = it.next();
                if (next.getValue() == runnable) {
                    b key = next.getKey();
                    it.remove();
                    return key;
                }
            }
            return null;
        }
    }

    public final b a(Runnable runnable) {
        b bVar;
        synchronized (this.b) {
            bVar = new b(runnable);
            this.b.put(bVar, runnable);
        }
        return bVar;
    }
}
