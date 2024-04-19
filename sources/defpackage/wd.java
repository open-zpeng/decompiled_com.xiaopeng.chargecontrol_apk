package defpackage;

import android.app.Activity;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;
/* compiled from: LifecycleDispatcher.java */
/* renamed from: wd  reason: default package */
/* loaded from: classes.dex */
public class wd {
    public static AtomicBoolean a = new AtomicBoolean(false);

    /* compiled from: LifecycleDispatcher.java */
    /* renamed from: wd$a */
    /* loaded from: classes.dex */
    public static class a extends qd {
        @Override // defpackage.qd, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            ie.b(activity);
        }

        @Override // defpackage.qd, android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // defpackage.qd, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }
}
