package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
/* compiled from: DrawableDecoderCompat.java */
/* renamed from: ln  reason: default package */
/* loaded from: classes.dex */
public final class ln {
    public static volatile boolean a = true;

    public static Drawable a(Context context, Context context2, int i, Resources.Theme theme) {
        try {
            if (a) {
                return i1.b(theme != null ? new n1(context2, theme) : context2, i);
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e) {
            if (!context.getPackageName().equals(context2.getPackageName())) {
                return o7.b(context2, i);
            }
            throw e;
        } catch (NoClassDefFoundError unused2) {
            a = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return a.a(context2.getResources(), i, theme);
    }
}
