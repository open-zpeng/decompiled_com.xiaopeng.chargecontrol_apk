package defpackage;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.FragmentManager;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.Fragment;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
/* compiled from: RequestManagerRetriever.java */
/* renamed from: uo  reason: default package */
/* loaded from: classes.dex */
public class uo implements Handler.Callback {
    public static final b k = new a();
    public volatile ug c;
    public final Handler f;
    public final b g;
    public final Map<FragmentManager, to> d = new HashMap();
    public final Map<oc, xo> e = new HashMap();
    public final y4<View, Fragment> h = new y4<>();
    public final y4<View, android.app.Fragment> i = new y4<>();
    public final Bundle j = new Bundle();

    /* compiled from: RequestManagerRetriever.java */
    /* renamed from: uo$a */
    /* loaded from: classes.dex */
    public class a implements b {
        public ug a(lg lgVar, qo qoVar, vo voVar, Context context) {
            return new ug(lgVar, qoVar, voVar, context);
        }
    }

    /* compiled from: RequestManagerRetriever.java */
    /* renamed from: uo$b */
    /* loaded from: classes.dex */
    public interface b {
    }

    public uo(b bVar) {
        this.g = bVar == null ? k : bVar;
        this.f = new Handler(Looper.getMainLooper(), this);
    }

    public static Activity c(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return c(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static boolean d(Context context) {
        Activity c = c(context);
        return c == null || !c.isFinishing();
    }

    public ug a(Context context) {
        if (context != null) {
            if (sq.c() && !(context instanceof Application)) {
                if (context instanceof bc) {
                    return a((bc) context);
                }
                if (context instanceof Activity) {
                    return a((Activity) context);
                }
                if (context instanceof ContextWrapper) {
                    ContextWrapper contextWrapper = (ContextWrapper) context;
                    if (contextWrapper.getBaseContext().getApplicationContext() != null) {
                        return a(contextWrapper.getBaseContext());
                    }
                }
            }
            return b(context);
        }
        throw new IllegalArgumentException("You cannot start a load on a null Context");
    }

    public final ug b(Context context) {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.c = ((a) this.g).a(lg.a(context.getApplicationContext()), new ko(), new po(), context.getApplicationContext());
                }
            }
        }
        return this.c;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        ComponentCallbacks remove;
        int i = message.what;
        Object obj = null;
        boolean z = true;
        if (i == 1) {
            obj = (FragmentManager) message.obj;
            remove = this.d.remove(obj);
        } else if (i != 2) {
            z = false;
            remove = null;
        } else {
            obj = (oc) message.obj;
            remove = this.e.remove(obj);
        }
        if (z && remove == null && Log.isLoggable("RMRetriever", 5)) {
            Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj);
        }
        return z;
    }

    @Deprecated
    public to b(Activity activity) {
        return a(activity.getFragmentManager(), (android.app.Fragment) null, d(activity));
    }

    public ug a(bc bcVar) {
        if (sq.b()) {
            return a(bcVar.getApplicationContext());
        }
        int i = Build.VERSION.SDK_INT;
        if (!bcVar.isDestroyed()) {
            return a(bcVar, bcVar.f(), (Fragment) null, d(bcVar));
        }
        throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
    }

    public ug a(Fragment fragment) {
        defpackage.a.a(fragment.U(), "You cannot start a load on a fragment before it is attached or after it is destroyed");
        if (sq.b()) {
            return a(fragment.U().getApplicationContext());
        }
        return a(fragment.U(), fragment.T(), fragment, fragment.G0());
    }

    public ug a(Activity activity) {
        if (sq.b()) {
            return a(activity.getApplicationContext());
        }
        int i = Build.VERSION.SDK_INT;
        if (!activity.isDestroyed()) {
            return a(activity, activity.getFragmentManager(), (android.app.Fragment) null, d(activity));
        }
        throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
    }

    public ug a(View view) {
        if (sq.b()) {
            return a(view.getContext().getApplicationContext());
        }
        defpackage.a.a(view, "Argument must not be null");
        defpackage.a.a(view.getContext(), "Unable to obtain a request manager for a view without a Context");
        Activity c = c(view.getContext());
        if (c == null) {
            return a(view.getContext().getApplicationContext());
        }
        if (c instanceof bc) {
            bc bcVar = (bc) c;
            this.h.clear();
            a(bcVar.f().n(), this.h);
            View findViewById = bcVar.findViewById(16908290);
            Fragment fragment = null;
            while (!view.equals(findViewById) && (fragment = this.h.getOrDefault(view, null)) == null && (view.getParent() instanceof View)) {
                view = (View) view.getParent();
            }
            this.h.clear();
            return fragment != null ? a(fragment) : a(bcVar);
        }
        this.i.clear();
        a(c.getFragmentManager(), this.i);
        View findViewById2 = c.findViewById(16908290);
        android.app.Fragment fragment2 = null;
        while (!view.equals(findViewById2) && (fragment2 = this.i.getOrDefault(view, null)) == null && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        this.i.clear();
        if (fragment2 == null) {
            return a(c);
        }
        if (fragment2.getActivity() != null) {
            if (!sq.b()) {
                int i = Build.VERSION.SDK_INT;
                return a(fragment2.getActivity(), fragment2.getChildFragmentManager(), fragment2, fragment2.isVisible());
            }
            return a(fragment2.getActivity().getApplicationContext());
        }
        throw new IllegalArgumentException("You cannot start a load on a fragment before it is attached");
    }

    public static void a(Collection<Fragment> collection, Map<View, Fragment> map) {
        if (collection == null) {
            return;
        }
        for (Fragment fragment : collection) {
            if (fragment != null && fragment.w0() != null) {
                map.put(fragment.w0(), fragment);
                a(fragment.T().n(), map);
            }
        }
    }

    @TargetApi(26)
    @Deprecated
    public final void a(FragmentManager fragmentManager, y4<View, android.app.Fragment> y4Var) {
        int i = Build.VERSION.SDK_INT;
        for (android.app.Fragment fragment : fragmentManager.getFragments()) {
            if (fragment.getView() != null) {
                y4Var.put(fragment.getView(), fragment);
                a(fragment.getChildFragmentManager(), y4Var);
            }
        }
    }

    public final to a(FragmentManager fragmentManager, android.app.Fragment fragment, boolean z) {
        to toVar = (to) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (toVar == null && (toVar = this.d.get(fragmentManager)) == null) {
            toVar = new to();
            toVar.h = fragment;
            if (fragment != null && fragment.getActivity() != null) {
                toVar.a(fragment.getActivity());
            }
            if (z) {
                toVar.c.b();
            }
            this.d.put(fragmentManager, toVar);
            fragmentManager.beginTransaction().add(toVar, "com.bumptech.glide.manager").commitAllowingStateLoss();
            this.f.obtainMessage(1, fragmentManager).sendToTarget();
        }
        return toVar;
    }

    @Deprecated
    public final ug a(Context context, FragmentManager fragmentManager, android.app.Fragment fragment, boolean z) {
        to a2 = a(fragmentManager, fragment, z);
        ug ugVar = a2.f;
        if (ugVar == null) {
            lg a3 = lg.a(context);
            ug a4 = ((a) this.g).a(a3, a2.c, a2.d, context);
            a2.f = a4;
            return a4;
        }
        return ugVar;
    }

    public xo a(Context context, oc ocVar) {
        return a(ocVar, (Fragment) null, d(context));
    }

    public final ug a(Context context, oc ocVar, Fragment fragment, boolean z) {
        xo a2 = a(ocVar, fragment, z);
        ug y1 = a2.y1();
        if (y1 == null) {
            lg a3 = lg.a(context);
            ug a4 = ((a) this.g).a(a3, a2.w1(), a2.z1(), context);
            a2.a(a4);
            return a4;
        }
        return y1;
    }

    public final xo a(oc ocVar, Fragment fragment, boolean z) {
        xo xoVar = (xo) ocVar.c.c("com.bumptech.glide.manager");
        if (xoVar == null && (xoVar = this.e.get(ocVar)) == null) {
            xoVar = new xo();
            xoVar.a(fragment);
            if (z) {
                xoVar.w1().b();
            }
            this.e.put(ocVar, xoVar);
            ob obVar = new ob(ocVar);
            obVar.a(0, xoVar, "com.bumptech.glide.manager", 1);
            obVar.a();
            this.f.obtainMessage(2, ocVar).sendToTarget();
        }
        return xoVar;
    }
}
