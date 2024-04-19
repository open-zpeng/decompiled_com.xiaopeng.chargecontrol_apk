package defpackage;

import android.app.ActivityThread;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.system.ErrnoException;
import android.system.Os;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Toast;
import com.xiaopeng.lib.framework.ipcmodule.IpcModuleEntry;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.ipcmodule.IIpcService;
import com.xiaopeng.speech.vui.VuiEngine;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import com.xiaopeng.speech.vui.model.VuiFeedback;
import com.xiaopeng.speech.vui.model.VuiFeedbackCode;
import com.xiaopeng.xui.app.XToast$XToastTextView;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import java.io.Closeable;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: CloseUtils.java */
/* renamed from: z90  reason: default package */
/* loaded from: classes.dex */
public class z90 {
    public static Application a;
    public static boolean b;
    public static boolean c;
    public static ve0 d;
    public static volatile sh0<Callable<dh0>, dh0> e;
    public static volatile sh0<dh0, dh0> f;
    public static volatile rh0<? super Throwable> g;
    public static volatile sh0<? super Runnable, ? extends Runnable> h;
    public static volatile sh0<? super Callable<dh0>, ? extends dh0> i;
    public static volatile sh0<? super Callable<dh0>, ? extends dh0> j;
    public static volatile sh0<? super Callable<dh0>, ? extends dh0> k;
    public static volatile sh0<? super Callable<dh0>, ? extends dh0> l;
    public static volatile sh0<? super dh0, ? extends dh0> m;
    public static volatile sh0<? super dh0, ? extends dh0> n;
    public static volatile sh0<? super ah0, ? extends ah0> o;
    public static volatile sh0<? super yg0, ? extends yg0> p;
    public static volatile sh0<? super eh0, ? extends eh0> q;

    public static void a(kh0 kh0Var) {
        if (kh0Var == null) {
            return;
        }
        kh0Var.a();
    }

    public static VuiEngine b() {
        return VuiEngine.getInstance(ActivityThread.currentApplication());
    }

    public static int c(int i2) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i2 - 1));
    }

    public static void d(int i2) {
        a(c().getText(i2));
    }

    public static void a(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public static Context c() {
        Application application = a;
        if (application != null) {
            return application;
        }
        throw new RuntimeException("Xui must be call Xui#init()!");
    }

    public static void a(int i2, Bundle bundle, String str) {
        IIpcService iIpcService = (IIpcService) Module.get(IpcModuleEntry.class).get(IIpcService.class);
        if (iIpcService != null) {
            iIpcService.sendData(i2, bundle, str);
        } else {
            Log.w("Ipc", "IpcService must register first before send message.");
        }
    }

    public static pc0 b(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return pc0.LEVEL3;
                    }
                    return pc0.LEVEL4;
                }
                return pc0.LEVEL3;
            }
            return pc0.LEVEL2;
        }
        return pc0.LEVEL1;
    }

    public static void c(Throwable th) {
        if (!(th instanceof VirtualMachineError)) {
            if (!(th instanceof ThreadDeath)) {
                if (th instanceof LinkageError) {
                    throw ((LinkageError) th);
                }
                return;
            }
            throw ((ThreadDeath) th);
        }
        throw ((VirtualMachineError) th);
    }

    public static Rect a(View view, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, dd0.XBackgroundPadding);
        if (obtainStyledAttributes.getBoolean(dd0.XBackgroundPadding_x_bg_padding_enable, false)) {
            int dimensionPixelSize = obtainStyledAttributes.hasValue(dd0.XBackgroundPadding_x_bg_padding) ? obtainStyledAttributes.getDimensionPixelSize(dd0.XBackgroundPadding_x_bg_padding, -1) : -1;
            int i2 = dimensionPixelSize;
            int i3 = i2;
            int i4 = i3;
            if (obtainStyledAttributes.hasValue(dd0.XBackgroundPadding_x_bg_padding_left)) {
                i2 = obtainStyledAttributes.getDimensionPixelSize(dd0.XBackgroundPadding_x_bg_padding_left, -1);
            }
            if (obtainStyledAttributes.hasValue(dd0.XBackgroundPadding_x_bg_padding_right)) {
                i3 = obtainStyledAttributes.getDimensionPixelSize(dd0.XBackgroundPadding_x_bg_padding_right, -1);
            }
            if (obtainStyledAttributes.hasValue(dd0.XBackgroundPadding_x_bg_padding_top)) {
                i4 = obtainStyledAttributes.getDimensionPixelSize(dd0.XBackgroundPadding_x_bg_padding_top, -1);
            }
            if (obtainStyledAttributes.hasValue(dd0.XBackgroundPadding_x_bg_padding_bottom)) {
                dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(dd0.XBackgroundPadding_x_bg_padding_bottom, -1);
            }
            obtainStyledAttributes.recycle();
            return a(view, i2, i4, i3, dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
        return null;
    }

    public static RuntimeException b(Throwable th) {
        throw gk0.a(th);
    }

    public static void b(String str) {
        be0.a("xui-ViewLocation", str);
    }

    public static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static <T, R> R b(sh0<T, R> sh0Var, T t) {
        try {
            return sh0Var.apply(t);
        } catch (Throwable th) {
            throw gk0.a(th);
        }
    }

    public static void a(View view, int i2) {
        a(view, i2, 0, 0);
    }

    public static int a(String str, int i2, int i3, int i4) {
        try {
            Os.chmod(str, i2);
            if (i3 >= 0 || i4 >= 0) {
                try {
                    Os.chown(str, i3, i4);
                    return 0;
                } catch (ErrnoException e2) {
                    Log.w("FileUtils", "Failed to chown(" + str + "): " + e2);
                    return e2.errno;
                }
            }
            return 0;
        } catch (ErrnoException e3) {
            Log.w("FileUtils", "Failed to chmod(" + str + "): " + e3);
            return e3.errno;
        }
    }

    public static /* synthetic */ void a(View view, ViewGroup viewGroup, de0 de0Var) {
        String str;
        Rect rect = new Rect();
        boolean localVisibleRect = view.getLocalVisibleRect(rect);
        int height = view.getHeight();
        int i2 = rect.top;
        if (i2 < 0) {
            viewGroup.scrollBy(0, i2 - 60);
            str = "top all ";
        } else if (i2 > 0) {
            if (rect.height() < height) {
                viewGroup.scrollBy(0, (-rect.top) - 60);
                str = "top a part ";
            } else {
                viewGroup.scrollBy(0, (rect.bottom - viewGroup.getHeight()) + 60);
                str = "bottom all ";
            }
        } else if (rect.height() < height) {
            viewGroup.scrollBy(0, (height - rect.bottom) + 60);
            str = "bottom a part ";
        } else {
            str = "";
        }
        be0.a("xui-ViewLocation", "scrollByLocation end localVisible : " + localVisibleRect + ", top " + rect.top + ", bottom " + rect.bottom + ", rect h:" + rect.height() + ",h:" + height + ", type: " + str);
        de0Var.a(view);
    }

    public static void a(final View view, final int i2, final int i3, final int i4) {
        final ViewGroup viewGroup;
        if (i2 == 0 && (view instanceof re0) && ((re0) view).a()) {
            be0.a("VuiFloatingManager", "DisableHitEffect type " + i2 + " view " + view);
            return;
        }
        if (d == null) {
            d = new xe0(c());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("show==   isCheckScroll : ");
        sb.append(true);
        sb.append(" view : ");
        sb.append(view);
        sb.append(" x : ");
        jg.a(sb, i3, " y : ", i4, " type : ");
        sb.append(i2);
        be0.a("VuiFloatingManager", sb.toString());
        final de0 de0Var = new de0() { // from class: u90
            @Override // defpackage.de0
            public final void a(View view2) {
                ((xe0) z90.d).a(view, i2, i3, i4);
            }
        };
        ViewParent parent = view.getParent();
        while (true) {
            if (!(parent instanceof ViewGroup)) {
                viewGroup = null;
                break;
            }
            viewGroup = (ViewGroup) parent;
            if (viewGroup.shouldDelayChildPressedState()) {
                break;
            }
            parent = parent.getParent();
        }
        if (viewGroup != null) {
            b("scrollByLocation start ");
            view.post(new Runnable() { // from class: t90
                @Override // java.lang.Runnable
                public final void run() {
                    z90.a(view, viewGroup, de0Var);
                }
            });
            return;
        }
        de0Var.a(view);
    }

    public static void a(Context context) {
        try {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            intent.addFlags(270532608);
            context.startActivity(intent);
        } catch (Exception e2) {
            be0.a("ActivityUtils", "startHome e=" + e2);
        }
    }

    public static <T, R> boolean a(bh0<T> bh0Var, ch0<? super R> ch0Var, sh0<? super T, ? extends bh0<? extends R>> sh0Var) {
        if (bh0Var instanceof Callable) {
            try {
                Object obj = (Object) ((Callable) bh0Var).call();
                if (obj == 0) {
                    ch0Var.onSubscribe(wh0.INSTANCE);
                    ch0Var.onComplete();
                    return true;
                }
                try {
                    bh0<? extends R> apply = sh0Var.apply(obj);
                    ai0.a(apply, "The mapper returned a null ObservableSource");
                    bh0<? extends R> bh0Var2 = apply;
                    if (bh0Var2 instanceof Callable) {
                        try {
                            Object call = ((Callable) bh0Var2).call();
                            if (call == null) {
                                ch0Var.onSubscribe(wh0.INSTANCE);
                                ch0Var.onComplete();
                                return true;
                            }
                            dj0 dj0Var = new dj0(ch0Var, call);
                            ch0Var.onSubscribe(dj0Var);
                            dj0Var.run();
                        } catch (Throwable th) {
                            c(th);
                            ch0Var.onSubscribe(wh0.INSTANCE);
                            ch0Var.onError(th);
                            return true;
                        }
                    } else {
                        ((ah0) bh0Var2).a(ch0Var);
                    }
                    return true;
                } catch (Throwable th2) {
                    c(th2);
                    ch0Var.onSubscribe(wh0.INSTANCE);
                    ch0Var.onError(th2);
                    return true;
                }
            } catch (Throwable th3) {
                c(th3);
                ch0Var.onSubscribe(wh0.INSTANCE);
                ch0Var.onError(th3);
                return true;
            }
        }
        return false;
    }

    public static Rect a(View view, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        Drawable drawable;
        int i10;
        int i11;
        int i12;
        int i13;
        be0.a("xpui-bgPadding", String.format("insetLeft %s, insetTop %s, insetRight %s, insetBottom %s, ", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)));
        Drawable background = view.getBackground();
        int paddingLeft = view.getPaddingLeft();
        int paddingRight = view.getPaddingRight();
        int paddingTop = view.getPaddingTop();
        int paddingBottom = view.getPaddingBottom();
        be0.a("xpui-bgPadding", String.format("paddingLeft %s, paddingRight %s, paddingTop %s, paddingBottom %s, ", Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight), Integer.valueOf(paddingTop), Integer.valueOf(paddingBottom)));
        if (background != null) {
            if (background instanceof InsetDrawable) {
                InsetDrawable insetDrawable = (InsetDrawable) background;
                drawable = insetDrawable.getDrawable();
                Rect rect = new Rect();
                insetDrawable.getPadding(rect);
                int i14 = i2;
                if (i14 == -1) {
                    i14 = rect.left;
                }
                int i15 = i14;
                int i16 = i3;
                if (i16 == -1) {
                    i16 = rect.top;
                }
                int i17 = i16;
                int i18 = i4;
                if (i18 == -1) {
                    i18 = rect.right;
                }
                int i19 = i18;
                int i20 = i5;
                if (i20 == -1) {
                    i20 = rect.bottom;
                }
                i10 = i15 - rect.left;
                i12 = i17 - rect.top;
                i11 = i19 - rect.right;
                i13 = i20 - rect.bottom;
                i9 = i20;
                i6 = i15;
                i7 = i17;
                i8 = i19;
            } else {
                i6 = i2;
                i7 = i3;
                i8 = i4;
                i9 = i5;
                drawable = background;
                i10 = 0;
                i11 = 0;
                i12 = 0;
                i13 = 0;
            }
            be0.a("xpui-bgPadding", String.format("paddingLeftOffset %s, paddingTopOffset %s, paddingRightOffset %s, paddingBottomOffset %s, ", Integer.valueOf(i10), Integer.valueOf(i12), Integer.valueOf(i11), Integer.valueOf(i13)));
            InsetDrawable insetDrawable2 = new InsetDrawable(drawable, i6, i7, i8, i9);
            view.setBackground(insetDrawable2);
            insetDrawable2.setDrawable(drawable);
            view.setPadding(paddingLeft + i10, paddingTop + i12, paddingRight + i11, paddingBottom + i13);
            be0.a("xpui-bgPadding", String.format("paddingLeft %s, paddingRight %s, paddingTop %s, paddingBottom %s, ", Integer.valueOf(view.getPaddingLeft()), Integer.valueOf(view.getPaddingRight()), Integer.valueOf(view.getPaddingTop()), Integer.valueOf(view.getPaddingBottom())));
            return new Rect(i6, i7, i8, i9);
        }
        return null;
    }

    public static Uri a(String str) {
        return Uri.parse(String.format("file:///android_asset/%s", str));
    }

    public static void a(String str, View... viewArr) {
        b().updateScene(str, Arrays.asList(viewArr));
    }

    public static kh0 a(View view, rh0<? super Object> rh0Var) {
        if (view != null) {
            lx lxVar = new lx(view);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            dh0 a2 = mk0.a();
            ai0.a(timeUnit, "unit is null");
            ai0.a(a2, "scheduler is null");
            return a(new hj0(lxVar, 800L, timeUnit, a2)).b(rh0Var);
        }
        throw new NullPointerException("view == null");
    }

    public static void a(re0... re0VarArr) {
        for (re0 re0Var : re0VarArr) {
            try {
                JSONObject p2 = re0Var.p();
                if (p2 == null) {
                    p2 = new JSONObject();
                    re0Var.a(p2);
                }
                p2.put(VuiConstants.PROPS_FEEDBACK, (Object) true);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void a(View view, VuiFeedbackCode vuiFeedbackCode, int i2) {
        b().vuiFeedback(view, new VuiFeedback.Builder().code(vuiFeedbackCode).content(view.getContext().getString(i2)).build());
    }

    public static kh0 a() {
        Runnable runnable = zh0.a;
        ai0.a(runnable, "run is null");
        return new lh0(runnable);
    }

    public static <T, R> R a(sh0<T, R> sh0Var, T t) {
        try {
            return sh0Var.apply(t);
        } catch (Throwable th) {
            throw gk0.a(th);
        }
    }

    public static <T, U> ah0<U> a(T t, sh0<? super T, ? extends bh0<? extends U>> sh0Var) {
        return a(new ej0(t, sh0Var));
    }

    public static void a(ka0 ka0Var) {
        for (View view : ka0Var.w()) {
            a(ka0Var.getSceneId(), view);
        }
    }

    public static void a(CharSequence charSequence, int i2) {
        int i3 = ad0.x_toast;
        Context c2 = c();
        View inflate = LayoutInflater.from(c2).inflate(i3, (ViewGroup) null);
        Toast toast = new Toast(c2);
        toast.setGravity(8388661, 0, 0);
        toast.setView(inflate);
        XToast$XToastTextView xToast$XToastTextView = (XToast$XToastTextView) toast.getView().findViewById(yc0.textView);
        xToast$XToastTextView.setIcon(0);
        toast.setDuration(i2);
        if (c) {
            xToast$XToastTextView.setElevation(XToggleDrawable.LIGHT_RADIUS_DEFAULT);
        } else {
            xToast$XToastTextView.setElevation(12.0f);
        }
        xToast$XToastTextView.setText(charSequence);
        toast.show();
    }

    public static void a(String str, View view) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                a(str, viewGroup.getChildAt(i2));
            }
        }
        if (view instanceof la0) {
            ((la0) view).e(str);
        }
    }

    public static ma0 a(View view) {
        if (view instanceof ma0) {
            return (ma0) view;
        }
        if (view.getParent() instanceof View) {
            a((View) view.getParent());
            return null;
        }
        return null;
    }

    public static mc0 a(int i2) {
        switch (i2) {
            case 1:
                return mc0.BUTTON;
            case 2:
                return mc0.LISTVIEW;
            case 3:
                return mc0.CHECKBOX;
            case 4:
                return mc0.RADIOBUTTON;
            case 5:
                return mc0.RADIOGROUP;
            case 6:
                return mc0.GROUP;
            case 7:
                return mc0.EDITTEXT;
            case 8:
                return mc0.PROGRESSBAR;
            case 9:
                return mc0.SEEKBAR;
            case 10:
                return mc0.TABHOST;
            case 11:
                return mc0.SEARCHVIEW;
            case 12:
                return mc0.RATINGBAR;
            case 13:
                return mc0.IMAGEBUTTON;
            case 14:
                return mc0.IMAGEVIEW;
            case 15:
                return mc0.SCROLLVIEW;
            case 16:
                return mc0.TEXTVIEW;
            case 17:
                return mc0.RECYCLEVIEW;
            case 18:
                return mc0.SWITCH;
            case 19:
                return mc0.CUSTOM;
            case 20:
                return mc0.XSLIDER;
            case 21:
                return mc0.XTABLAYOUT;
            case 22:
                return mc0.XGROUPHEADER;
            default:
                return mc0.UNKNOWN;
        }
    }

    public static void a(CharSequence charSequence) {
        String[] split;
        int i2;
        if (charSequence == null) {
            i2 = 0;
        } else {
            i2 = 0;
            for (String str : charSequence.toString().trim().split(" ")) {
                if (str.trim().length() != 0) {
                    int i3 = i2;
                    boolean z = true;
                    boolean z2 = false;
                    for (int i4 = 0; i4 < str.length(); i4++) {
                        if (str.charAt(i4) > 255) {
                            if (!z) {
                                i3++;
                            }
                            i3++;
                            z2 = true;
                            z = true;
                        } else {
                            z = false;
                        }
                    }
                    if (!z2 || !z) {
                        i3++;
                    }
                    i2 = i3;
                }
            }
        }
        if (i2 > 8) {
            a(charSequence, 1);
        } else {
            a(charSequence, 0);
        }
    }

    public static Cipher a(String str, int i2) {
        Cipher cipher = null;
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "AES");
            cipher = Cipher.getInstance("AES");
            cipher.init(i2, secretKeySpec);
            return cipher;
        } catch (InvalidKeyException e2) {
            e2.printStackTrace();
            return cipher;
        } catch (NoSuchAlgorithmException e3) {
            e3.printStackTrace();
            return cipher;
        } catch (NoSuchPaddingException e4) {
            e4.printStackTrace();
            return cipher;
        }
    }

    public static void a(Throwable th) {
        rh0<? super Throwable> rh0Var = g;
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else {
            boolean z = true;
            if (!(th instanceof nh0) && !(th instanceof IllegalStateException) && !(th instanceof NullPointerException) && !(th instanceof IllegalArgumentException) && !(th instanceof mh0)) {
                z = false;
            }
            if (!z) {
                th = new ph0(th);
            }
        }
        if (rh0Var != null) {
            try {
                rh0Var.accept(th);
                return;
            } catch (Throwable th2) {
                th2.printStackTrace();
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th2);
            }
        }
        th.printStackTrace();
        Thread currentThread2 = Thread.currentThread();
        currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, th);
    }

    public static Runnable a(Runnable runnable) {
        ai0.a(runnable, "run is null");
        sh0<? super Runnable, ? extends Runnable> sh0Var = h;
        return sh0Var == null ? runnable : (Runnable) b(sh0Var, runnable);
    }

    public static <T> yg0<T> a(yg0<T> yg0Var) {
        sh0<? super yg0, ? extends yg0> sh0Var = p;
        return sh0Var != null ? (yg0) b(sh0Var, yg0Var) : yg0Var;
    }

    public static <T> ah0<T> a(ah0<T> ah0Var) {
        sh0<? super ah0, ? extends ah0> sh0Var = o;
        return sh0Var != null ? (ah0) b(sh0Var, ah0Var) : ah0Var;
    }

    public static <T> eh0<T> a(eh0<T> eh0Var) {
        sh0<? super eh0, ? extends eh0> sh0Var = q;
        return sh0Var != null ? (eh0) b(sh0Var, eh0Var) : eh0Var;
    }

    public static dh0 a(Callable<dh0> callable) {
        try {
            dh0 call = callable.call();
            ai0.a(call, "Scheduler Callable result can't be null");
            return call;
        } catch (Throwable th) {
            throw gk0.a(th);
        }
    }

    public static dh0 a(sh0<? super Callable<dh0>, ? extends dh0> sh0Var, Callable<dh0> callable) {
        Object b2 = b(sh0Var, callable);
        ai0.a(b2, "Scheduler Callable result can't be null");
        return (dh0) b2;
    }
}
