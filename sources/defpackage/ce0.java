package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
/* compiled from: XTouchAreaUtils.java */
/* renamed from: ce0  reason: default package */
/* loaded from: classes.dex */
public class ce0 {
    static {
        Class[] clsArr = {TextView.class, ImageView.class};
    }

    public static void a(View view, ViewGroup viewGroup, int[] iArr) {
        if (view == null) {
            return;
        }
        if (iArr == null) {
            iArr = new int[]{20, 20, 20, 20};
        }
        me0.a(view, viewGroup, iArr[0], iArr[1], iArr[2], iArr[3]);
    }

    public static void a(View view, ViewGroup viewGroup) {
        if (view == null || viewGroup == null) {
            return;
        }
        me0.a(view, viewGroup);
    }
}
