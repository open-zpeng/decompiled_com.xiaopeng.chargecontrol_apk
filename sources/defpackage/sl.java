package defpackage;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import defpackage.nl;
import java.io.InputStream;
/* compiled from: ResourceLoader.java */
/* renamed from: sl  reason: default package */
/* loaded from: classes.dex */
public class sl<Data> implements nl<Integer, Data> {
    public final nl<Uri, Data> a;
    public final Resources b;

    /* compiled from: ResourceLoader.java */
    /* renamed from: sl$a */
    /* loaded from: classes.dex */
    public static final class a implements ol<Integer, AssetFileDescriptor> {
        public final Resources a;

        public a(Resources resources) {
            this.a = resources;
        }

        @Override // defpackage.ol
        public nl<Integer, AssetFileDescriptor> a(rl rlVar) {
            return new sl(this.a, rlVar.a(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* compiled from: ResourceLoader.java */
    /* renamed from: sl$b */
    /* loaded from: classes.dex */
    public static class b implements ol<Integer, ParcelFileDescriptor> {
        public final Resources a;

        public b(Resources resources) {
            this.a = resources;
        }

        @Override // defpackage.ol
        public nl<Integer, ParcelFileDescriptor> a(rl rlVar) {
            return new sl(this.a, rlVar.a(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* compiled from: ResourceLoader.java */
    /* renamed from: sl$c */
    /* loaded from: classes.dex */
    public static class c implements ol<Integer, InputStream> {
        public final Resources a;

        public c(Resources resources) {
            this.a = resources;
        }

        @Override // defpackage.ol
        public nl<Integer, InputStream> a(rl rlVar) {
            return new sl(this.a, rlVar.a(Uri.class, InputStream.class));
        }
    }

    /* compiled from: ResourceLoader.java */
    /* renamed from: sl$d */
    /* loaded from: classes.dex */
    public static class d implements ol<Integer, Uri> {
        public final Resources a;

        public d(Resources resources) {
            this.a = resources;
        }

        @Override // defpackage.ol
        public nl<Integer, Uri> a(rl rlVar) {
            return new sl(this.a, vl.a);
        }
    }

    public sl(Resources resources, nl<Uri, Data> nlVar) {
        this.b = resources;
        this.a = nlVar;
    }

    @Override // defpackage.nl
    public nl.a a(Integer num, int i, int i2, bi biVar) {
        Uri uri;
        Integer num2 = num;
        try {
            uri = Uri.parse("android.resource://" + this.b.getResourcePackageName(num2.intValue()) + '/' + this.b.getResourceTypeName(num2.intValue()) + '/' + this.b.getResourceEntryName(num2.intValue()));
        } catch (Resources.NotFoundException e) {
            if (Log.isLoggable("ResourceLoader", 5)) {
                Log.w("ResourceLoader", "Received invalid resource id: " + num2, e);
            }
            uri = null;
        }
        if (uri == null) {
            return null;
        }
        return this.a.a(uri, i, i2, biVar);
    }

    @Override // defpackage.nl
    public boolean a(Integer num) {
        return true;
    }
}
