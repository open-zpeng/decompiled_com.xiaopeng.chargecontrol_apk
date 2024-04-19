package defpackage;

import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.xiaopeng.speech.vui.constants.VuiConstants;
/* compiled from: XuiUtils.java */
/* renamed from: ee0  reason: default package */
/* loaded from: classes.dex */
public class ee0 {
    public static volatile DisplayMetrics a;

    public static DisplayMetrics a() {
        if (a == null) {
            synchronized (ee0.class) {
                if (a == null) {
                    a = new DisplayMetrics();
                    WindowManager windowManager = (WindowManager) z90.c().getSystemService("window");
                    if (windowManager != null) {
                        windowManager.getDefaultDisplay().getRealMetrics(a);
                    }
                }
            }
        }
        return a;
    }

    public static String a(int i) {
        if (i != 0) {
            if (i != 4) {
                if (i != 8) {
                    return null;
                }
                return "gone";
            }
            return "invisible";
        }
        return VuiConstants.ELEMENT_VISIBLE;
    }

    public static int a(float f) {
        return (int) ((f * z90.c().getResources().getDisplayMetrics().density) + 0.5f);
    }
}
