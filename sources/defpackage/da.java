package defpackage;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
/* compiled from: ViewCompat.java */
/* renamed from: da  reason: default package */
/* loaded from: classes.dex */
public class da implements View.OnApplyWindowInsetsListener {
    public ja a = null;
    public final /* synthetic */ View b;
    public final /* synthetic */ s9 c;

    public da(View view, s9 s9Var) {
        this.b = view;
        this.c = s9Var;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        ja a = ja.a(windowInsets, view);
        if (Build.VERSION.SDK_INT < 30) {
            View view2 = this.b;
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view2.getTag(d7.tag_window_insets_animation_callback);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view2, windowInsets);
            }
            if (a.equals(this.a)) {
                return ((x0) this.c).a(view, a).e();
            }
        }
        this.a = a;
        ja a2 = ((x0) this.c).a(view, a);
        if (Build.VERSION.SDK_INT >= 30) {
            return a2.e();
        }
        view.requestApplyInsets();
        return a2.e();
    }
}
