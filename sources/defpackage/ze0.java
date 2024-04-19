package defpackage;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
/* compiled from: VuiImageDecoderUtils.java */
/* renamed from: ze0  reason: default package */
/* loaded from: classes.dex */
public class ze0 {
    public static List<String> a;

    public static int a(int i) {
        return i != 1 ? 1500 : 5500;
    }

    @TargetApi(28)
    public static Drawable a(Context context, int i, boolean z) {
        boolean a2;
        boolean z2;
        be0.a("ze0", "decoderImage type : " + i + ", isNight : " + z);
        if (i != 1) {
            String str = "anim/floating_touch_night.webp";
            if (z) {
                z2 = a(context, "anim/floating_touch_night.webp");
                a2 = false;
            } else {
                a2 = a(context, "anim/floating_touch.webp");
                z2 = false;
            }
            if (!z || !z2) {
                str = a2 ? "anim/floating_touch.webp" : null;
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    return ImageDecoder.decodeDrawable(ImageDecoder.createSource(context.getAssets(), str));
                } catch (IOException e) {
                    if (be0.a(5)) {
                        be0.a(5, "ze0", "decodeException:", e, false);
                        return null;
                    }
                    return null;
                }
            }
            be0.b("ze0", "decode error, file not found");
            return null;
        }
        return new we0(BitmapFactory.decodeResource(context.getResources(), xc0.floating_element));
    }

    public static boolean a() {
        return false;
    }

    public static boolean b(int i) {
        return i == 1;
    }

    public static boolean a(Context context, String str) {
        if (str.startsWith("anim/")) {
            str = str.replace("anim/", "");
        }
        try {
            if (a == null) {
                a = Arrays.asList(context.getResources().getAssets().list("anim"));
            }
            be0.a("ze0", "assetsContains, assets:" + a);
            return a.contains(str);
        } catch (Exception e) {
            StringBuilder a2 = jg.a("assetsContains call ex:");
            a2.append(e.getMessage());
            be0.d("ze0", a2.toString());
            e.printStackTrace();
            return false;
        }
    }
}
