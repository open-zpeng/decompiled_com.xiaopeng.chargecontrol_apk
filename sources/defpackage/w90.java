package defpackage;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ActivityThread;
/* compiled from: ActivityHelper.java */
/* renamed from: w90  reason: default package */
/* loaded from: classes.dex */
public class w90 {
    public Activity a;

    /* compiled from: ActivityHelper.java */
    /* renamed from: w90$a */
    /* loaded from: classes.dex */
    public class a extends ba0 {
        public a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            w90.this.a = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            w90.this.a = activity;
        }
    }

    /* compiled from: ActivityHelper.java */
    /* renamed from: w90$b */
    /* loaded from: classes.dex */
    public static class b {
        @SuppressLint({"StaticFieldLeak"})
        public static final w90 a = new w90(null);
    }

    public /* synthetic */ w90(a aVar) {
    }

    public void a() {
        ActivityThread.currentApplication().registerActivityLifecycleCallbacks(new a());
    }

    public boolean b() {
        return this.a != null;
    }
}
