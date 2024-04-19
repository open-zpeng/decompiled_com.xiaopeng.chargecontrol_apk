package defpackage;

import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.GeneratedAppGlideModule;
import com.bumptech.glide.load.ImageHeaderParser;
import defpackage.al;
import defpackage.am;
import defpackage.bl;
import defpackage.bm;
import defpackage.cm;
import defpackage.dl;
import defpackage.dm;
import defpackage.el;
import defpackage.fl;
import defpackage.hn;
import defpackage.jn;
import defpackage.ki;
import defpackage.kl;
import defpackage.qi;
import defpackage.si;
import defpackage.sl;
import defpackage.ul;
import defpackage.vl;
import defpackage.wl;
import defpackage.xk;
import defpackage.xl;
import defpackage.yl;
import defpackage.zk;
import defpackage.zl;
import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* compiled from: Glide.java */
/* renamed from: lg  reason: default package */
/* loaded from: classes.dex */
public class lg implements ComponentCallbacks2 {
    public static volatile lg k;
    public static volatile boolean l;
    public final ek c;
    public final wk d;
    public final ng e;
    public final sg f;
    public final ck g;
    public final uo h;
    public final mo i;
    public final List<ug> j = new ArrayList();

    /* compiled from: Glide.java */
    /* renamed from: lg$a */
    /* loaded from: classes.dex */
    public interface a {
    }

    public lg(Context context, kj kjVar, wk wkVar, ek ekVar, ck ckVar, uo uoVar, mo moVar, int i, a aVar, Map<Class<?>, vg<?, ?>> map, List<pp<Object>> list, boolean z, boolean z2) {
        di mmVar;
        di enVar;
        og ogVar = og.NORMAL;
        this.c = ekVar;
        this.g = ckVar;
        this.d = wkVar;
        this.h = uoVar;
        this.i = moVar;
        Resources resources = context.getResources();
        this.f = new sg();
        sg sgVar = this.f;
        sgVar.g.a(new qm());
        int i2 = Build.VERSION.SDK_INT;
        sg sgVar2 = this.f;
        sgVar2.g.a(new vm());
        List<ImageHeaderParser> a2 = this.f.a();
        sn snVar = new sn(context, a2, ekVar, ckVar);
        hn hnVar = new hn(ekVar, new hn.g());
        sm smVar = new sm(this.f.a(), resources.getDisplayMetrics(), ekVar, ckVar);
        if (z2) {
            int i3 = Build.VERSION.SDK_INT;
            enVar = new zm();
            mmVar = new nm();
        } else {
            mmVar = new mm(smVar);
            enVar = new en(smVar, ckVar);
        }
        on onVar = new on(context);
        sl.c cVar = new sl.c(resources);
        sl.d dVar = new sl.d(resources);
        sl.b bVar = new sl.b(resources);
        sl.a aVar2 = new sl.a(resources);
        im imVar = new im(ckVar);
        co coVar = new co();
        fo foVar = new fo();
        ContentResolver contentResolver = context.getContentResolver();
        sg sgVar3 = this.f;
        sgVar3.b.a(ByteBuffer.class, new cl());
        sgVar3.b.a(InputStream.class, new tl(ckVar));
        sgVar3.c.a("Bitmap", mmVar, ByteBuffer.class, Bitmap.class);
        sgVar3.c.a("Bitmap", enVar, InputStream.class, Bitmap.class);
        int i4 = Build.VERSION.SDK_INT;
        sg sgVar4 = this.f;
        sgVar4.c.a("Bitmap", new bn(smVar), ParcelFileDescriptor.class, Bitmap.class);
        sg sgVar5 = this.f;
        sgVar5.c.a("Bitmap", hnVar, ParcelFileDescriptor.class, Bitmap.class);
        sgVar5.c.a("Bitmap", new hn(ekVar, new hn.c(null)), AssetFileDescriptor.class, Bitmap.class);
        sgVar5.a.a(Bitmap.class, Bitmap.class, vl.a.a);
        sgVar5.c.a("Bitmap", new gn(), Bitmap.class, Bitmap.class);
        sgVar5.d.a(Bitmap.class, imVar);
        sgVar5.c.a("BitmapDrawable", new gm(resources, mmVar), ByteBuffer.class, BitmapDrawable.class);
        sgVar5.c.a("BitmapDrawable", new gm(resources, enVar), InputStream.class, BitmapDrawable.class);
        sgVar5.c.a("BitmapDrawable", new gm(resources, hnVar), ParcelFileDescriptor.class, BitmapDrawable.class);
        sgVar5.d.a(BitmapDrawable.class, new hm(ekVar, imVar));
        sgVar5.c.a("Gif", new bo(a2, snVar, ckVar), InputStream.class, un.class);
        sgVar5.c.a("Gif", snVar, ByteBuffer.class, un.class);
        sgVar5.d.a(un.class, new vn());
        sgVar5.a.a(zg.class, zg.class, vl.a.a);
        sgVar5.c.a("Bitmap", new zn(ekVar), zg.class, Bitmap.class);
        sgVar5.c.a("legacy_append", onVar, Uri.class, Drawable.class);
        sgVar5.c.a("legacy_append", new dn(onVar, ekVar), Uri.class, Bitmap.class);
        sgVar5.e.a((ki.a<?>) new jn.a());
        sgVar5.a.a(File.class, ByteBuffer.class, new dl.b());
        sgVar5.a.a(File.class, InputStream.class, new fl.e());
        sgVar5.c.a("legacy_append", new qn(), File.class, File.class);
        sgVar5.a.a(File.class, ParcelFileDescriptor.class, new fl.b());
        sgVar5.a.a(File.class, File.class, vl.a.a);
        sgVar5.e.a((ki.a<?>) new qi.a(ckVar));
        int i5 = Build.VERSION.SDK_INT;
        sg sgVar6 = this.f;
        sgVar6.e.a((ki.a<?>) new si.a());
        sg sgVar7 = this.f;
        sgVar7.a.a(Integer.TYPE, InputStream.class, cVar);
        sgVar7.a.a(Integer.TYPE, ParcelFileDescriptor.class, bVar);
        sgVar7.a.a(Integer.class, InputStream.class, cVar);
        sgVar7.a.a(Integer.class, ParcelFileDescriptor.class, bVar);
        sgVar7.a.a(Integer.class, Uri.class, dVar);
        sgVar7.a.a(Integer.TYPE, AssetFileDescriptor.class, aVar2);
        sgVar7.a.a(Integer.class, AssetFileDescriptor.class, aVar2);
        sgVar7.a.a(Integer.TYPE, Uri.class, dVar);
        sgVar7.a.a(String.class, InputStream.class, new el.c());
        sgVar7.a.a(Uri.class, InputStream.class, new el.c());
        sgVar7.a.a(String.class, InputStream.class, new ul.c());
        sgVar7.a.a(String.class, ParcelFileDescriptor.class, new ul.b());
        sgVar7.a.a(String.class, AssetFileDescriptor.class, new ul.a());
        sgVar7.a.a(Uri.class, InputStream.class, new zl.a());
        sgVar7.a.a(Uri.class, InputStream.class, new al.c(context.getAssets()));
        sgVar7.a.a(Uri.class, ParcelFileDescriptor.class, new al.b(context.getAssets()));
        sgVar7.a.a(Uri.class, InputStream.class, new am.a(context));
        sgVar7.a.a(Uri.class, InputStream.class, new bm.a(context));
        if (Build.VERSION.SDK_INT >= 29) {
            sg sgVar8 = this.f;
            sgVar8.a.a(Uri.class, InputStream.class, new cm.c(context));
            sg sgVar9 = this.f;
            sgVar9.a.a(Uri.class, ParcelFileDescriptor.class, new cm.b(context));
        }
        sg sgVar10 = this.f;
        sgVar10.a.a(Uri.class, InputStream.class, new wl.d(contentResolver));
        sgVar10.a.a(Uri.class, ParcelFileDescriptor.class, new wl.b(contentResolver));
        sgVar10.a.a(Uri.class, AssetFileDescriptor.class, new wl.a(contentResolver));
        sgVar10.a.a(Uri.class, InputStream.class, new xl.a());
        sgVar10.a.a(URL.class, InputStream.class, new dm.a());
        sgVar10.a.a(Uri.class, File.class, new kl.a(context));
        sgVar10.a.a(gl.class, InputStream.class, new yl.a());
        sgVar10.a.a(byte[].class, ByteBuffer.class, new bl.a());
        sgVar10.a.a(byte[].class, InputStream.class, new bl.d());
        sgVar10.a.a(Uri.class, Uri.class, vl.a.a);
        sgVar10.a.a(Drawable.class, Drawable.class, vl.a.a);
        sgVar10.c.a("legacy_append", new pn(), Drawable.class, Drawable.class);
        sgVar10.f.a(Bitmap.class, BitmapDrawable.class, new Cdo(resources));
        sgVar10.f.a(Bitmap.class, byte[].class, coVar);
        sgVar10.f.a(Drawable.class, byte[].class, new eo(ekVar, coVar, foVar));
        sgVar10.f.a(un.class, byte[].class, foVar);
        int i6 = Build.VERSION.SDK_INT;
        hn hnVar2 = new hn(ekVar, new hn.d());
        this.f.c.a("legacy_append", hnVar2, ByteBuffer.class, Bitmap.class);
        sg sgVar11 = this.f;
        sgVar11.c.a("legacy_append", new gm(resources, hnVar2), ByteBuffer.class, BitmapDrawable.class);
        this.e = new ng(context, ckVar, this.f, new aq(), aVar, map, list, kjVar, z, i);
    }

    public static lg a(Context context) {
        GeneratedAppGlideModule generatedAppGlideModule;
        if (k == null) {
            try {
                generatedAppGlideModule = (GeneratedAppGlideModule) Class.forName("com.bumptech.glide.GeneratedAppGlideModuleImpl").getDeclaredConstructor(Context.class).newInstance(context.getApplicationContext().getApplicationContext());
            } catch (ClassNotFoundException unused) {
                if (Log.isLoggable("Glide", 5)) {
                    Log.w("Glide", "Failed to find GeneratedAppGlideModule. You should include an annotationProcessor compile dependency on com.github.bumptech.glide:compiler in your application and a @GlideModule annotated AppGlideModule implementation or LibraryGlideModules will be silently ignored");
                }
                generatedAppGlideModule = null;
            } catch (IllegalAccessException e) {
                a(e);
                throw null;
            } catch (InstantiationException e2) {
                a(e2);
                throw null;
            } catch (NoSuchMethodException e3) {
                a(e3);
                throw null;
            } catch (InvocationTargetException e4) {
                a(e4);
                throw null;
            }
            synchronized (lg.class) {
                if (k == null) {
                    a(context, generatedAppGlideModule);
                }
            }
        }
        return k;
    }

    public static uo b(Context context) {
        defpackage.a.a(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return a(context).h;
    }

    public static ug c(Context context) {
        return b(context).a(context);
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        sq.a();
        ((pq) this.d).a();
        this.c.a();
        ((jk) this.g).a();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        sq.a();
        for (ug ugVar : this.j) {
            ugVar.onTrimMemory(i);
        }
        ((vk) this.d).a(i);
        this.c.a(i);
        ((jk) this.g).b(i);
    }

    public void b(ug ugVar) {
        synchronized (this.j) {
            if (this.j.contains(ugVar)) {
                this.j.remove(ugVar);
            } else {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
        }
    }

    public static void a(Context context, GeneratedAppGlideModule generatedAppGlideModule) {
        List<bp> list;
        if (!l) {
            l = true;
            mg mgVar = new mg();
            Context applicationContext = context.getApplicationContext();
            List emptyList = Collections.emptyList();
            if (generatedAppGlideModule == null || generatedAppGlideModule.a()) {
                if (Log.isLoggable("ManifestParser", 3)) {
                    Log.d("ManifestParser", "Loading Glide modules");
                }
                ArrayList arrayList = new ArrayList();
                try {
                    ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
                    if (applicationInfo.metaData == null) {
                        if (Log.isLoggable("ManifestParser", 3)) {
                            Log.d("ManifestParser", "Got null app info metadata");
                        }
                    } else {
                        if (Log.isLoggable("ManifestParser", 2)) {
                            Log.v("ManifestParser", "Got app info metadata: " + applicationInfo.metaData);
                        }
                        for (String str : applicationInfo.metaData.keySet()) {
                            if ("GlideModule".equals(applicationInfo.metaData.get(str))) {
                                arrayList.add(dp.a(str));
                                if (Log.isLoggable("ManifestParser", 3)) {
                                    Log.d("ManifestParser", "Loaded Glide module: " + str);
                                }
                            }
                        }
                        if (Log.isLoggable("ManifestParser", 3)) {
                            Log.d("ManifestParser", "Finished loading Glide modules");
                        }
                    }
                    list = arrayList;
                } catch (PackageManager.NameNotFoundException e) {
                    throw new RuntimeException("Unable to find metadata to parse GlideModules", e);
                }
            } else {
                list = emptyList;
            }
            if (generatedAppGlideModule != null && !generatedAppGlideModule.b().isEmpty()) {
                Set<Class<?>> b = generatedAppGlideModule.b();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    bp bpVar = (bp) it.next();
                    if (b.contains(bpVar.getClass())) {
                        if (Log.isLoggable("Glide", 3)) {
                            Log.d("Glide", "AppGlideModule excludes manifest GlideModule: " + bpVar);
                        }
                        it.remove();
                    }
                }
            }
            if (Log.isLoggable("Glide", 3)) {
                for (bp bpVar2 : list) {
                    StringBuilder a2 = jg.a("Discovered GlideModule from manifest: ");
                    a2.append(bpVar2.getClass());
                    Log.d("Glide", a2.toString());
                }
            }
            mgVar.m = generatedAppGlideModule != null ? generatedAppGlideModule.c() : null;
            for (bp bpVar3 : list) {
                bpVar3.a(applicationContext, mgVar);
            }
            if (generatedAppGlideModule != null) {
                generatedAppGlideModule.a(applicationContext, mgVar);
            }
            if (mgVar.f == null) {
                mgVar.f = zk.c();
            }
            if (mgVar.g == null) {
                mgVar.g = zk.b();
            }
            if (mgVar.n == null) {
                int i = zk.a() >= 4 ? 2 : 1;
                zk.b bVar = zk.b.b;
                if (!TextUtils.isEmpty("animation")) {
                    mgVar.n = new zk(new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new zk.a("animation", bVar, true)));
                } else {
                    throw new IllegalArgumentException(jg.a("Name must be non-null and non-empty, but given: ", "animation"));
                }
            }
            if (mgVar.i == null) {
                mgVar.i = new xk(new xk.a(applicationContext));
            }
            if (mgVar.j == null) {
                mgVar.j = new oo();
            }
            if (mgVar.c == null) {
                int i2 = mgVar.i.a;
                if (i2 > 0) {
                    mgVar.c = new kk(i2);
                } else {
                    mgVar.c = new fk();
                }
            }
            if (mgVar.d == null) {
                mgVar.d = new jk(mgVar.i.d);
            }
            if (mgVar.e == null) {
                mgVar.e = new vk(mgVar.i.b);
            }
            if (mgVar.h == null) {
                mgVar.h = new uk(applicationContext);
            }
            if (mgVar.b == null) {
                mgVar.b = new kj(mgVar.e, mgVar.h, mgVar.g, mgVar.f, new zk(new ThreadPoolExecutor(0, Integer.MAX_VALUE, zk.b, TimeUnit.MILLISECONDS, new SynchronousQueue(), new zk.a("source-unlimited", zk.b.b, false))), mgVar.n, mgVar.o);
            }
            List<pp<Object>> list2 = mgVar.p;
            if (list2 == null) {
                mgVar.p = Collections.emptyList();
            } else {
                mgVar.p = Collections.unmodifiableList(list2);
            }
            lg lgVar = new lg(applicationContext, mgVar.b, mgVar.e, mgVar.c, mgVar.d, new uo(mgVar.m), mgVar.j, mgVar.k, mgVar.l, mgVar.a, mgVar.p, mgVar.q, mgVar.r);
            for (bp bpVar4 : list) {
                try {
                    bpVar4.a(applicationContext, lgVar, lgVar.f);
                } catch (AbstractMethodError e2) {
                    StringBuilder a3 = jg.a("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: ");
                    a3.append(bpVar4.getClass().getName());
                    throw new IllegalStateException(a3.toString(), e2);
                }
            }
            if (generatedAppGlideModule != null) {
                generatedAppGlideModule.a(applicationContext, lgVar, lgVar.f);
            }
            applicationContext.registerComponentCallbacks(lgVar);
            k = lgVar;
            l = false;
            return;
        }
        throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
    }

    public static void a(Exception exc) {
        throw new IllegalStateException("GeneratedAppGlideModuleImpl is implemented incorrectly. If you've manually implemented this class, remove your implementation. The Annotation processor will generate a correct implementation.", exc);
    }

    public Context a() {
        return this.e.getBaseContext();
    }

    public static ug a(Fragment fragment) {
        return b(fragment.U()).a(fragment);
    }

    public static ug a(View view) {
        return b(view.getContext()).a(view);
    }

    public boolean a(cq<?> cqVar) {
        synchronized (this.j) {
            for (ug ugVar : this.j) {
                if (ugVar.b(cqVar)) {
                    return true;
                }
            }
            return false;
        }
    }

    public void a(ug ugVar) {
        synchronized (this.j) {
            if (!this.j.contains(ugVar)) {
                this.j.add(ugVar);
            } else {
                throw new IllegalStateException("Cannot register already registered manager");
            }
        }
    }
}
