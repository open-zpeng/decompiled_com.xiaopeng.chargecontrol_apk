package defpackage;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Build;
import android.os.Bundle;
import defpackage.he;
import defpackage.vd;
/* compiled from: ReportFragment.java */
/* renamed from: ie  reason: default package */
/* loaded from: classes.dex */
public class ie extends Fragment {
    public a c;

    /* compiled from: ReportFragment.java */
    /* renamed from: ie$a */
    /* loaded from: classes.dex */
    public interface a {
    }

    /* compiled from: ReportFragment.java */
    /* renamed from: ie$b */
    /* loaded from: classes.dex */
    public static class b implements Application.ActivityLifecycleCallbacks {
        public static void registerIn(Activity activity) {
            activity.registerActivityLifecycleCallbacks(new b());
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostCreated(Activity activity, Bundle bundle) {
            ie.a(activity, vd.a.ON_CREATE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostResumed(Activity activity) {
            ie.a(activity, vd.a.ON_RESUME);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPostStarted(Activity activity) {
            ie.a(activity, vd.a.ON_START);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreDestroyed(Activity activity) {
            ie.a(activity, vd.a.ON_DESTROY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPrePaused(Activity activity) {
            ie.a(activity, vd.a.ON_PAUSE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreStopped(Activity activity) {
            ie.a(activity, vd.a.ON_STOP);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    public static void a(Activity activity, vd.a aVar) {
        if (activity instanceof be) {
            ae r = ((be) activity).r();
            r.a("handleLifecycleEvent");
            r.a(aVar.a());
        } else if (activity instanceof zd) {
            vd r2 = ((zd) activity).r();
            if (r2 instanceof ae) {
                ae aeVar = (ae) r2;
                aeVar.a("handleLifecycleEvent");
                aeVar.a(aVar.a());
            }
        }
    }

    public static void b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 29) {
            b.registerIn(activity);
        }
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new ie(), "androidx.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a aVar = this.c;
        if (aVar != null) {
            he.b bVar = (he.b) aVar;
        }
        a(vd.a.ON_CREATE);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        a(vd.a.ON_DESTROY);
        this.c = null;
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        a(vd.a.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        a aVar = this.c;
        if (aVar != null) {
            he.this.a();
        }
        a(vd.a.ON_RESUME);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        a aVar = this.c;
        if (aVar != null) {
            he.this.b();
        }
        a(vd.a.ON_START);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        a(vd.a.ON_STOP);
    }

    public static ie a(Activity activity) {
        return (ie) activity.getFragmentManager().findFragmentByTag("androidx.lifecycle.LifecycleDispatcher.report_fragment_tag");
    }

    public final void a(vd.a aVar) {
        if (Build.VERSION.SDK_INT < 29) {
            a(getActivity(), aVar);
        }
    }
}
