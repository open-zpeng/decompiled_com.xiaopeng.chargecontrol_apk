package defpackage;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.Iterator;
/* compiled from: AppCompatDelegate.java */
/* renamed from: v0  reason: default package */
/* loaded from: classes.dex */
public abstract class v0 {
    public static final a5<WeakReference<v0>> c = new a5<>(0);
    public static final Object d = new Object();

    public static v0 a(Activity activity, u0 u0Var) {
        return new w0(activity, null, u0Var, activity);
    }

    public static void b(v0 v0Var) {
        synchronized (d) {
            c(v0Var);
        }
    }

    public static void c(v0 v0Var) {
        synchronized (d) {
            Iterator<WeakReference<v0>> it = c.iterator();
            while (it.hasNext()) {
                v0 v0Var2 = it.next().get();
                if (v0Var2 == v0Var || v0Var2 == null) {
                    it.remove();
                }
            }
        }
    }

    public abstract void a();

    public abstract void a(Bundle bundle);

    public abstract void a(View view);

    public abstract void a(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void a(CharSequence charSequence);

    public abstract boolean a(int i);

    public abstract void b();

    public abstract void b(int i);

    public abstract void b(Bundle bundle);

    public abstract void b(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void c();

    public static v0 a(Dialog dialog, u0 u0Var) {
        return new w0(dialog.getContext(), dialog.getWindow(), u0Var, dialog);
    }

    public static void a(v0 v0Var) {
        synchronized (d) {
            c(v0Var);
            c.add(new WeakReference<>(v0Var));
        }
    }
}
