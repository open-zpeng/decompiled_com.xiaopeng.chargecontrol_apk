package defpackage;

import android.annotation.SuppressLint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
/* compiled from: DrawableUtils.java */
@SuppressLint({"RestrictedAPI"})
/* renamed from: t3  reason: default package */
/* loaded from: classes.dex */
public class t3 {
    public static final int[] a = {16842912};
    public static final int[] b = new int[0];

    static {
        new Rect();
        int i = Build.VERSION.SDK_INT;
        try {
            Class.forName("android.graphics.Insets");
        } catch (ClassNotFoundException unused) {
        }
    }

    public static boolean a(Drawable drawable) {
        int i = Build.VERSION.SDK_INT;
        if (drawable instanceof DrawableContainer) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState instanceof DrawableContainer.DrawableContainerState) {
                for (Drawable drawable2 : ((DrawableContainer.DrawableContainerState) constantState).getChildren()) {
                    if (!a(drawable2)) {
                        return false;
                    }
                }
                return true;
            }
            return true;
        } else if (drawable instanceof f8) {
            return a(((g8) drawable).h);
        } else {
            if (drawable instanceof j1) {
                return a(((j1) drawable).c);
            }
            if (drawable instanceof ScaleDrawable) {
                return a(((ScaleDrawable) drawable).getDrawable());
            }
            return true;
        }
    }

    public static void b(Drawable drawable) {
        int i = Build.VERSION.SDK_INT;
    }

    public static PorterDuff.Mode a(int i, PorterDuff.Mode mode) {
        if (i != 3) {
            if (i != 5) {
                if (i != 9) {
                    switch (i) {
                        case 14:
                            return PorterDuff.Mode.MULTIPLY;
                        case 15:
                            return PorterDuff.Mode.SCREEN;
                        case 16:
                            return PorterDuff.Mode.ADD;
                        default:
                            return mode;
                    }
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }
}
