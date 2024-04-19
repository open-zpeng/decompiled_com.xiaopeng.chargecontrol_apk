package defpackage;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AppOpsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StrictMode;
import android.os.Trace;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.util.Log;
import android.util.Xml;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.load.ImageHeaderParser;
import com.xiaopeng.lib.apirouter.ClientConstants;
import defpackage.a9;
import defpackage.ed;
import defpackage.nf;
import defpackage.oc;
import defpackage.t5;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: MediaDescriptionCompatApi21.java */
/* renamed from: a  reason: default package */
/* loaded from: classes.dex */
public class a {
    public static long a;
    public static Method b;

    public static int a(int i, int i2, int i3, int i4) {
        int min = Math.min(i2 / i4, i / i3);
        int max = Math.max(1, min == 0 ? 0 : Integer.highestOneBit(min));
        if (Log.isLoggable("Utils", 2) && max > 1) {
            StringBuilder a2 = jg.a("Downsampling WEBP, sampleSize: ", max, ", target dimens: [", i3, "x");
            jg.a(a2, i4, "], actual dimens: [", i, "x");
            a2.append(i2);
            a2.append("]");
            Log.v("Utils", a2.toString());
        }
        return max;
    }

    public static boolean b(int i, int i2) {
        return i != Integer.MIN_VALUE && i2 != Integer.MIN_VALUE && i <= 512 && i2 <= 384;
    }

    public static boolean b(Uri uri) {
        return uri.getPathSegments().contains("video");
    }

    public static ImageHeaderParser.ImageType b(List<ImageHeaderParser> list, InputStream inputStream, ck ckVar) {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new cn(inputStream, ckVar);
        }
        inputStream.mark(5242880);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                ImageHeaderParser.ImageType a2 = list.get(i).a(inputStream);
                inputStream.reset();
                if (a2 != ImageHeaderParser.ImageType.UNKNOWN) {
                    return a2;
                }
            } catch (Throwable th) {
                inputStream.reset();
                throw th;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    public static void a(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static boolean a(Uri uri) {
        return uri != null && ClientConstants.BINDER.SCHEME.equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    public static InputConnection a(InputConnection inputConnection, EditorInfo editorInfo, View view) {
        if (inputConnection != null && editorInfo.hintText == null) {
            ViewParent parent = view.getParent();
            while (true) {
                if (!(parent instanceof View)) {
                    break;
                } else if (parent instanceof s4) {
                    editorInfo.hintText = ((s4) parent).a();
                    break;
                } else {
                    parent = parent.getParent();
                }
            }
        }
        return inputConnection;
    }

    public static boolean b(Object obj, Object obj2) {
        int i = Build.VERSION.SDK_INT;
        return Objects.equals(obj, obj2);
    }

    public static <T> T a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static int b(nf.z zVar, mf mfVar, View view, View view2, nf.n nVar, boolean z) {
        if (nVar.e() == 0 || zVar.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return zVar.a();
        }
        return (int) (((mfVar.a(view2) - mfVar.d(view)) / (Math.abs(nVar.l(view) - nVar.l(view2)) + 1)) * zVar.a());
    }

    public static int a(nf.z zVar, mf mfVar, View view, View view2, nf.n nVar, boolean z, boolean z2) {
        int max;
        if (nVar.e() == 0 || zVar.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        int min = Math.min(nVar.l(view), nVar.l(view2));
        int max2 = Math.max(nVar.l(view), nVar.l(view2));
        if (z2) {
            max = Math.max(0, (zVar.a() - max2) - 1);
        } else {
            max = Math.max(0, min);
        }
        if (z) {
            return Math.round((max * (Math.abs(mfVar.a(view2) - mfVar.d(view)) / (Math.abs(nVar.l(view) - nVar.l(view2)) + 1))) + (mfVar.f() - mfVar.d(view)));
        }
        return max;
    }

    public static boolean b(Drawable drawable) {
        int i = Build.VERSION.SDK_INT;
        return drawable.isAutoMirrored();
    }

    public static String b(Context context, ComponentName componentName) {
        String string;
        ActivityInfo activityInfo = context.getPackageManager().getActivityInfo(componentName, Build.VERSION.SDK_INT >= 29 ? 269222528 : 787072);
        int i = Build.VERSION.SDK_INT;
        String str = activityInfo.parentActivityName;
        if (str != null) {
            return str;
        }
        if (activityInfo.metaData == null || (string = activityInfo.metaData.getString("android.support.PARENT_ACTIVITY")) == null) {
            return null;
        }
        if (string.charAt(0) == '.') {
            return context.getPackageName() + string;
        }
        return string;
    }

    public static void a(Object obj, StringBuilder sb) {
        int lastIndexOf;
        if (obj == null) {
            sb.append("null");
            return;
        }
        String simpleName = obj.getClass().getSimpleName();
        if (simpleName.length() <= 0 && (lastIndexOf = (simpleName = obj.getClass().getName()).lastIndexOf(46)) > 0) {
            simpleName = simpleName.substring(lastIndexOf + 1);
        }
        sb.append(simpleName);
        sb.append('{');
        sb.append(Integer.toHexString(System.identityHashCode(obj)));
    }

    public static void b(TextView textView, int i) {
        a(i);
        int fontMetricsInt = textView.getPaint().getFontMetricsInt(null);
        if (i != fontMetricsInt) {
            textView.setLineSpacing(i - fontMetricsInt, 1.0f);
        }
    }

    public static int b(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 4) {
                    if (i != 8) {
                        if (i != 16) {
                            if (i != 32) {
                                if (i != 64) {
                                    if (i != 128) {
                                        if (i == 256) {
                                            return 8;
                                        }
                                        throw new IllegalArgumentException(jg.a("type needs to be >= FIRST and <= LAST, type=", i));
                                    }
                                    return 7;
                                }
                                return 6;
                            }
                            return 5;
                        }
                        return 4;
                    }
                    return 3;
                }
                return 2;
            }
            return 1;
        }
        return 0;
    }

    public static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e) {
            if (Log.isLoggable("Utils", 5)) {
                Log.w("Utils", "Error reading data from stream", e);
                return null;
            }
            return null;
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must not be null or empty");
        }
        return str;
    }

    public static fc a(Context context, Fragment fragment, boolean z, boolean z2) {
        int Y;
        int i;
        int h0 = fragment.h0();
        if (z2) {
            if (z) {
                Y = fragment.l0();
            } else {
                Y = fragment.m0();
            }
        } else if (z) {
            Y = fragment.V();
        } else {
            Y = fragment.Y();
        }
        boolean z3 = false;
        fragment.a(0, 0, 0, 0);
        ViewGroup viewGroup = fragment.I;
        if (viewGroup != null && viewGroup.getTag(mb.visible_removing_fragment_view_tag) != null) {
            fragment.I.setTag(mb.visible_removing_fragment_view_tag, null);
        }
        ViewGroup viewGroup2 = fragment.I;
        if (viewGroup2 == null || viewGroup2.getLayoutTransition() == null) {
            Animation L0 = fragment.L0();
            if (L0 != null) {
                return new fc(L0);
            }
            Animator M0 = fragment.M0();
            if (M0 != null) {
                return new fc(M0);
            }
            if (Y == 0 && h0 != 0) {
                if (h0 == 4097) {
                    i = z ? lb.fragment_open_enter : lb.fragment_open_exit;
                } else if (h0 == 4099) {
                    i = z ? lb.fragment_fade_enter : lb.fragment_fade_exit;
                } else if (h0 != 8194) {
                    i = -1;
                } else {
                    i = z ? lb.fragment_close_enter : lb.fragment_close_exit;
                }
                Y = i;
            }
            if (Y != 0) {
                boolean equals = "anim".equals(context.getResources().getResourceTypeName(Y));
                if (equals) {
                    try {
                        Animation loadAnimation = AnimationUtils.loadAnimation(context, Y);
                        if (loadAnimation != null) {
                            return new fc(loadAnimation);
                        }
                        z3 = true;
                    } catch (Resources.NotFoundException e) {
                        throw e;
                    } catch (RuntimeException unused) {
                    }
                }
                if (!z3) {
                    try {
                        Animator loadAnimator = AnimatorInflater.loadAnimator(context, Y);
                        if (loadAnimator != null) {
                            return new fc(loadAnimator);
                        }
                    } catch (RuntimeException e2) {
                        if (!equals) {
                            Animation loadAnimation2 = AnimationUtils.loadAnimation(context, Y);
                            if (loadAnimation2 != null) {
                                return new fc(loadAnimation2);
                            }
                        } else {
                            throw e2;
                        }
                    }
                }
            }
            return null;
        }
        return null;
    }

    public static boolean a(t5.a aVar, t5.a aVar2, t5.a aVar3, t5.a aVar4) {
        return (aVar3 == t5.a.FIXED || aVar3 == t5.a.WRAP_CONTENT || (aVar3 == t5.a.MATCH_PARENT && aVar != t5.a.WRAP_CONTENT)) || (aVar4 == t5.a.FIXED || aVar4 == t5.a.WRAP_CONTENT || (aVar4 == t5.a.MATCH_PARENT && aVar2 != t5.a.WRAP_CONTENT));
    }

    /* JADX WARN: Code restructure failed: missing block: B:143:0x022d, code lost:
        if (r2.n0 == 2) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x030b, code lost:
        if (r5[r16].f.d == r6) goto L173;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0164, code lost:
        if (r4[r2].f.d == r6) goto L82;
     */
    /* JADX WARN: Removed duplicated region for block: B:226:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x04dc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0543 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:334:0x05d7  */
    /* JADX WARN: Removed duplicated region for block: B:357:0x064a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:366:0x065d  */
    /* JADX WARN: Removed duplicated region for block: B:413:0x072d  */
    /* JADX WARN: Removed duplicated region for block: B:421:0x0771 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:426:0x077d  */
    /* JADX WARN: Removed duplicated region for block: B:429:0x0788  */
    /* JADX WARN: Removed duplicated region for block: B:430:0x078b  */
    /* JADX WARN: Removed duplicated region for block: B:433:0x0791  */
    /* JADX WARN: Removed duplicated region for block: B:434:0x0794  */
    /* JADX WARN: Removed duplicated region for block: B:436:0x0798  */
    /* JADX WARN: Removed duplicated region for block: B:442:0x07a9  */
    /* JADX WARN: Removed duplicated region for block: B:444:0x07b1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:454:0x07ce A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x011d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void a(defpackage.u5 r37, defpackage.k5 r38, java.util.ArrayList<defpackage.t5> r39, int r40) {
        /*
            Method dump skipped, instructions count: 2013
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.a.a(u5, k5, java.util.ArrayList, int):void");
    }

    @SuppressLint({"NewApi"})
    public static boolean a() {
        try {
            if (b == null) {
                return Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        int i = Build.VERSION.SDK_INT;
        try {
            if (b == null) {
                a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) b.invoke(null, Long.valueOf(a))).booleanValue();
        } catch (Exception e) {
            if (e instanceof InvocationTargetException) {
                Throwable cause = e.getCause();
                if (cause instanceof RuntimeException) {
                    throw ((RuntimeException) cause);
                }
                throw new RuntimeException(cause);
            }
            Log.v("Trace", "Unable to call isTagEnabled via reflection", e);
            return false;
        }
    }

    public static int a(nf.z zVar, mf mfVar, View view, View view2, nf.n nVar, boolean z) {
        if (nVar.e() == 0 || zVar.a() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(nVar.l(view) - nVar.l(view2)) + 1;
        }
        return Math.min(mfVar.g(), mfVar.a(view2) - mfVar.d(view));
    }

    public static File a(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        StringBuilder a2 = jg.a(".font");
        a2.append(Process.myPid());
        a2.append("-");
        a2.append(Process.myTid());
        a2.append("-");
        String sb = a2.toString();
        for (int i = 0; i < 100; i++) {
            File file = new File(cacheDir, jg.a(sb, i));
            if (file.createNewFile()) {
                return file;
            }
        }
        return null;
    }

    public static String a(View view) {
        try {
            return view.getContext().getResources().getResourceEntryName(view.getId());
        } catch (Exception unused) {
            return "UNKNOWN";
        }
    }

    public static void a(PopupWindow popupWindow, boolean z) {
        int i = Build.VERSION.SDK_INT;
        popupWindow.setOverlapAnchor(z);
    }

    public static int a(Object... objArr) {
        int i = Build.VERSION.SDK_INT;
        return Objects.hash(objArr);
    }

    public static Drawable a(Resources resources, int i, Resources.Theme theme) {
        int i2 = Build.VERSION.SDK_INT;
        return resources.getDrawable(i, theme);
    }

    public static ByteBuffer a(Context context, CancellationSignal cancellationSignal, Uri uri) {
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r", cancellationSignal);
            if (openFileDescriptor == null) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
            try {
                FileChannel channel = fileInputStream.getChannel();
                MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                fileInputStream.close();
                openFileDescriptor.close();
                return map;
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException unused) {
            return null;
        }
    }

    public static <T> T a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    public static Intent a(Activity activity) {
        int i = Build.VERSION.SDK_INT;
        Intent parentActivityIntent = activity.getParentActivityIntent();
        if (parentActivityIntent != null) {
            return parentActivityIntent;
        }
        try {
            String b2 = b((Context) activity, activity.getComponentName());
            if (b2 == null) {
                return null;
            }
            ComponentName componentName = new ComponentName(activity, b2);
            try {
                if (b((Context) activity, componentName) == null) {
                    return Intent.makeMainActivity(componentName);
                }
                return new Intent().setComponent(componentName);
            } catch (PackageManager.NameNotFoundException unused) {
                Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + b2 + "' in manifest");
                return null;
            }
        } catch (PackageManager.NameNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static int a(Context context, String str) {
        int myPid = Process.myPid();
        int myUid = Process.myUid();
        String packageName = context.getPackageName();
        if (context.checkPermission(str, myPid, myUid) == -1) {
            return -1;
        }
        int i = Build.VERSION.SDK_INT;
        String permissionToOp = AppOpsManager.permissionToOp(str);
        if (permissionToOp != null) {
            if (packageName == null) {
                String[] packagesForUid = context.getPackageManager().getPackagesForUid(myUid);
                if (packagesForUid == null || packagesForUid.length <= 0) {
                    return -1;
                }
                packageName = packagesForUid[0];
            }
            int i2 = Build.VERSION.SDK_INT;
            if (((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOpNoThrow(permissionToOp, packageName) != 0) {
                return -2;
            }
        }
        return 0;
    }

    public static <T> T a(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static int a(List<ImageHeaderParser> list, InputStream inputStream, ck ckVar) {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new cn(inputStream, ckVar);
        }
        inputStream.mark(5242880);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            try {
                int a2 = list.get(i).a(inputStream, ckVar);
                if (a2 != -1) {
                    return a2;
                }
            } finally {
                inputStream.reset();
            }
        }
        return -1;
    }

    public static int a(int i, int i2) {
        int i3 = Build.VERSION.SDK_INT;
        return Gravity.getAbsoluteGravity(i, i2);
    }

    public static void a(Fragment fragment, fc fcVar, ed.a aVar) {
        View view = fragment.J;
        ViewGroup viewGroup = fragment.I;
        viewGroup.startViewTransition(view);
        m8 m8Var = new m8();
        m8Var.a(new cc(fragment));
        oc.d dVar = (oc.d) aVar;
        dVar.b(fragment, m8Var);
        Animation animation = fcVar.a;
        if (animation != null) {
            gc gcVar = new gc(animation, viewGroup, view);
            fragment.a(fragment.J);
            gcVar.setAnimationListener(new dc(viewGroup, fragment, dVar, m8Var));
            fragment.J.startAnimation(gcVar);
            return;
        }
        Animator animator = fcVar.b;
        fragment.a(animator);
        animator.addListener(new ec(viewGroup, view, fragment, dVar, m8Var));
        animator.setTarget(fragment.J);
        animator.start();
    }

    public static boolean a(File file, InputStream inputStream) {
        FileOutputStream fileOutputStream;
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file, false);
            } catch (IOException e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            try {
                fileOutputStream.close();
            } catch (IOException unused) {
            }
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            return true;
        } catch (IOException e2) {
            e = e2;
            fileOutputStream2 = fileOutputStream;
            Log.e("TypefaceCompatUtil", "Error copying resource contents to temp file: " + e.getMessage());
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused2) {
                }
            }
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused3) {
                }
            }
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            throw th;
        }
    }

    public static boolean a(File file, Resources resources, int i) {
        InputStream inputStream;
        try {
            inputStream = resources.openRawResource(i);
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            boolean a2 = a(file, inputStream);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            }
            return a2;
        } catch (Throwable th2) {
            th = th2;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    public static q7 a(XmlPullParser xmlPullParser, Resources resources) {
        int next;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            xmlPullParser.require(2, null, "font-family");
            if (xmlPullParser.getName().equals("font-family")) {
                TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), e7.FontFamily);
                String string = obtainAttributes.getString(e7.FontFamily_fontProviderAuthority);
                String string2 = obtainAttributes.getString(e7.FontFamily_fontProviderPackage);
                String string3 = obtainAttributes.getString(e7.FontFamily_fontProviderQuery);
                int resourceId = obtainAttributes.getResourceId(e7.FontFamily_fontProviderCerts, 0);
                int integer = obtainAttributes.getInteger(e7.FontFamily_fontProviderFetchStrategy, 1);
                int integer2 = obtainAttributes.getInteger(e7.FontFamily_fontProviderFetchTimeout, 500);
                String string4 = obtainAttributes.getString(e7.FontFamily_fontProviderSystemFontFamily);
                obtainAttributes.recycle();
                if (string != null && string2 != null && string3 != null) {
                    while (xmlPullParser.next() != 3) {
                        a(xmlPullParser);
                    }
                    return new t7(new s8(string, string2, string3, a(resources, resourceId)), integer, integer2, string4);
                }
                ArrayList arrayList = new ArrayList();
                while (xmlPullParser.next() != 3) {
                    if (xmlPullParser.getEventType() == 2) {
                        if (xmlPullParser.getName().equals("font")) {
                            TypedArray obtainAttributes2 = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), e7.FontFamilyFont);
                            if (obtainAttributes2.hasValue(e7.FontFamilyFont_fontWeight)) {
                                i = e7.FontFamilyFont_fontWeight;
                            } else {
                                i = e7.FontFamilyFont_android_fontWeight;
                            }
                            int i6 = obtainAttributes2.getInt(i, 400);
                            if (obtainAttributes2.hasValue(e7.FontFamilyFont_fontStyle)) {
                                i2 = e7.FontFamilyFont_fontStyle;
                            } else {
                                i2 = e7.FontFamilyFont_android_fontStyle;
                            }
                            boolean z = 1 == obtainAttributes2.getInt(i2, 0);
                            if (obtainAttributes2.hasValue(e7.FontFamilyFont_ttcIndex)) {
                                i3 = e7.FontFamilyFont_ttcIndex;
                            } else {
                                i3 = e7.FontFamilyFont_android_ttcIndex;
                            }
                            if (obtainAttributes2.hasValue(e7.FontFamilyFont_fontVariationSettings)) {
                                i4 = e7.FontFamilyFont_fontVariationSettings;
                            } else {
                                i4 = e7.FontFamilyFont_android_fontVariationSettings;
                            }
                            String string5 = obtainAttributes2.getString(i4);
                            int i7 = obtainAttributes2.getInt(i3, 0);
                            if (obtainAttributes2.hasValue(e7.FontFamilyFont_font)) {
                                i5 = e7.FontFamilyFont_font;
                            } else {
                                i5 = e7.FontFamilyFont_android_font;
                            }
                            int resourceId2 = obtainAttributes2.getResourceId(i5, 0);
                            String string6 = obtainAttributes2.getString(i5);
                            obtainAttributes2.recycle();
                            while (xmlPullParser.next() != 3) {
                                a(xmlPullParser);
                            }
                            arrayList.add(new s7(string6, i6, z, string5, i7, resourceId2));
                        } else {
                            a(xmlPullParser);
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    return null;
                }
                return new r7((s7[]) arrayList.toArray(new s7[arrayList.size()]));
            }
            a(xmlPullParser);
            return null;
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static Intent a(Context context, ComponentName componentName) {
        String b2 = b(context, componentName);
        if (b2 == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), b2);
        if (b(context, componentName2) == null) {
            return Intent.makeMainActivity(componentName2);
        }
        return new Intent().setComponent(componentName2);
    }

    public static int a(int i) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException();
    }

    public static List<List<byte[]>> a(Resources resources, int i) {
        if (i == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            int i2 = Build.VERSION.SDK_INT;
            if (obtainTypedArray.getType(0) == 1) {
                for (int i3 = 0; i3 < obtainTypedArray.length(); i3++) {
                    int resourceId = obtainTypedArray.getResourceId(i3, 0);
                    if (resourceId != 0) {
                        arrayList.add(a(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(a(resources.getStringArray(i)));
            }
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    public static List<byte[]> a(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(Base64.decode(str, 0));
        }
        return arrayList;
    }

    public static void a(XmlPullParser xmlPullParser) {
        int i = 1;
        while (i > 0) {
            int next = xmlPullParser.next();
            if (next == 2) {
                i++;
            } else if (next == 3) {
                i--;
            }
        }
    }

    public static boolean a(Drawable drawable, int i) {
        int i2 = Build.VERSION.SDK_INT;
        return drawable.setLayoutDirection(i);
    }

    public static o6 a(ArrayList<o6> arrayList, int i) {
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            o6 o6Var = arrayList.get(i2);
            if (i == o6Var.b) {
                return o6Var;
            }
        }
        return null;
    }

    public static o6 a(t5 t5Var, int i, ArrayList<o6> arrayList, o6 o6Var) {
        int i2;
        int i3;
        int i4;
        if (i == 0) {
            i2 = t5Var.r0;
        } else {
            i2 = t5Var.s0;
        }
        if (i2 != -1 && (o6Var == null || i2 != o6Var.b)) {
            int i5 = 0;
            while (true) {
                if (i5 >= arrayList.size()) {
                    break;
                }
                o6 o6Var2 = arrayList.get(i5);
                if (o6Var2.b == i2) {
                    if (o6Var != null) {
                        o6Var.a(i, o6Var2);
                        arrayList.remove(o6Var);
                    }
                    o6Var = o6Var2;
                } else {
                    i5++;
                }
            }
        } else if (i2 != -1) {
            return o6Var;
        }
        if (o6Var == null) {
            if (t5Var instanceof x5) {
                x5 x5Var = (x5) t5Var;
                int i6 = 0;
                while (true) {
                    if (i6 >= x5Var.v0) {
                        i3 = -1;
                        break;
                    }
                    t5 t5Var2 = x5Var.u0[i6];
                    if (i == 0 && (i4 = t5Var2.r0) != -1) {
                        i3 = i4;
                        break;
                    } else if (i == 1 && (i3 = t5Var2.s0) != -1) {
                        break;
                    } else {
                        i6++;
                    }
                }
                if (i3 != -1) {
                    int i7 = 0;
                    while (true) {
                        if (i7 >= arrayList.size()) {
                            break;
                        }
                        o6 o6Var3 = arrayList.get(i7);
                        if (o6Var3.b == i3) {
                            o6Var = o6Var3;
                            break;
                        }
                        i7++;
                    }
                }
            }
            if (o6Var == null) {
                o6Var = new o6(i);
            }
            arrayList.add(o6Var);
        }
        if (o6Var.a(t5Var)) {
            if (t5Var instanceof v5) {
                v5 v5Var = (v5) t5Var;
                v5Var.x0.a(v5Var.y0 != 0 ? 0 : 1, arrayList, o6Var);
            }
            if (i == 0) {
                t5Var.r0 = o6Var.b;
                t5Var.K.a(i, arrayList, o6Var);
                t5Var.M.a(i, arrayList, o6Var);
            } else {
                t5Var.s0 = o6Var.b;
                t5Var.L.a(i, arrayList, o6Var);
                t5Var.O.a(i, arrayList, o6Var);
                t5Var.N.a(i, arrayList, o6Var);
            }
            t5Var.R.a(i, arrayList, o6Var);
        }
        return o6Var;
    }

    public static int a(Drawable drawable) {
        int i = Build.VERSION.SDK_INT;
        return drawable.getLayoutDirection();
    }

    public static void a(EditorInfo editorInfo, CharSequence charSequence, int i) {
        editorInfo.setInitialSurroundingSubText(charSequence, i);
    }

    public static void a(TextView textView, int i) {
        int i2;
        a(i);
        Paint.FontMetricsInt fontMetricsInt = textView.getPaint().getFontMetricsInt();
        int i3 = Build.VERSION.SDK_INT;
        if (textView.getIncludeFontPadding()) {
            i2 = fontMetricsInt.bottom;
        } else {
            i2 = fontMetricsInt.descent;
        }
        if (i > Math.abs(i2)) {
            textView.setPadding(textView.getPaddingLeft(), textView.getPaddingTop(), textView.getPaddingRight(), i - i2);
        }
    }

    public static void a(TextView textView, a9 a9Var) {
        if (Build.VERSION.SDK_INT >= 29) {
            Spannable spannable = a9Var.c;
            textView.setText(spannable instanceof PrecomputedText ? (PrecomputedText) spannable : null);
        } else if (new a9.a(textView.getTextMetricsParams()).a(a9Var.d)) {
            textView.setText(a9Var);
        } else {
            throw new IllegalArgumentException("Given text can not be applied to TextView.");
        }
    }

    public static void a(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }

    public static void a(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i, int i2) {
        view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i, i2);
    }
}
