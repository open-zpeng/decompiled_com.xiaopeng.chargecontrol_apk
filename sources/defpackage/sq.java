package defpackage;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Looper;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IInputController;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
/* compiled from: Util.java */
/* renamed from: sq  reason: default package */
/* loaded from: classes.dex */
public final class sq {
    public static final char[] a = "0123456789abcdef".toCharArray();
    public static final char[] b = new char[64];

    /* compiled from: Util.java */
    /* renamed from: sq$a */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = new int[Bitmap.Config.values().length];

        static {
            try {
                a[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Bitmap.Config.RGBA_F16.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Bitmap.Config.ARGB_8888.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static String a(byte[] bArr) {
        String str;
        synchronized (b) {
            char[] cArr = b;
            for (int i = 0; i < bArr.length; i++) {
                int i2 = bArr[i] & 255;
                int i3 = i * 2;
                char[] cArr2 = a;
                cArr[i3] = cArr2[i2 >>> 4];
                cArr[i3 + 1] = cArr2[i2 & 15];
            }
            str = new String(cArr);
        }
        return str;
    }

    public static boolean a(int i, int i2) {
        if (i > 0 || i == Integer.MIN_VALUE) {
            return i2 > 0 || i2 == Integer.MIN_VALUE;
        }
        return false;
    }

    public static boolean b() {
        return !c();
    }

    public static boolean c() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean b(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    @TargetApi(19)
    public static int a(Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            int i = Build.VERSION.SDK_INT;
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException unused) {
                return bitmap.getRowBytes() * bitmap.getHeight();
            }
        }
        throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
    }

    public static int a(int i, int i2, Bitmap.Config config) {
        int i3 = i * i2;
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i4 = a.a[config.ordinal()];
        int i5 = 4;
        if (i4 == 1) {
            i5 = 1;
        } else if (i4 == 2 || i4 == 3) {
            i5 = 2;
        } else if (i4 == 4) {
            i5 = 8;
        }
        return i3 * i5;
    }

    public static void a() {
        if (!c()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static <T> Queue<T> a(int i) {
        return new ArrayDeque(i);
    }

    public static <T> List<T> a(Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T t : collection) {
            if (t != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        } else if (obj instanceof ll) {
            return ((ll) obj).a(obj2);
        } else {
            return obj.equals(obj2);
        }
    }

    public static int a(float f) {
        return Float.floatToIntBits(f) + IInputController.KEYCODE_KNOB_TALKING_BOOK;
    }

    public static int a(Object obj, int i) {
        return (i * 31) + (obj == null ? 0 : obj.hashCode());
    }
}
