package defpackage;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.xiaopeng.lib.apirouter.ClientConstants;
import defpackage.nl;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* compiled from: UriLoader.java */
/* renamed from: wl  reason: default package */
/* loaded from: classes.dex */
public class wl<Data> implements nl<Uri, Data> {
    public static final Set<String> b = Collections.unmodifiableSet(new HashSet(Arrays.asList("file", "android.resource", ClientConstants.BINDER.SCHEME)));
    public final c<Data> a;

    /* compiled from: UriLoader.java */
    /* renamed from: wl$a */
    /* loaded from: classes.dex */
    public static final class a implements ol<Uri, AssetFileDescriptor>, c<AssetFileDescriptor> {
        public final ContentResolver a;

        public a(ContentResolver contentResolver) {
            this.a = contentResolver;
        }

        @Override // defpackage.ol
        public nl<Uri, AssetFileDescriptor> a(rl rlVar) {
            return new wl(this);
        }

        @Override // defpackage.wl.c
        public ji<AssetFileDescriptor> a(Uri uri) {
            return new gi(this.a, uri);
        }
    }

    /* compiled from: UriLoader.java */
    /* renamed from: wl$b */
    /* loaded from: classes.dex */
    public static class b implements ol<Uri, ParcelFileDescriptor>, c<ParcelFileDescriptor> {
        public final ContentResolver a;

        public b(ContentResolver contentResolver) {
            this.a = contentResolver;
        }

        @Override // defpackage.wl.c
        public ji<ParcelFileDescriptor> a(Uri uri) {
            return new oi(this.a, uri);
        }

        @Override // defpackage.ol
        public nl<Uri, ParcelFileDescriptor> a(rl rlVar) {
            return new wl(this);
        }
    }

    /* compiled from: UriLoader.java */
    /* renamed from: wl$c */
    /* loaded from: classes.dex */
    public interface c<Data> {
        ji<Data> a(Uri uri);
    }

    /* compiled from: UriLoader.java */
    /* renamed from: wl$d */
    /* loaded from: classes.dex */
    public static class d implements ol<Uri, InputStream>, c<InputStream> {
        public final ContentResolver a;

        public d(ContentResolver contentResolver) {
            this.a = contentResolver;
        }

        @Override // defpackage.wl.c
        public ji<InputStream> a(Uri uri) {
            return new ui(this.a, uri);
        }

        @Override // defpackage.ol
        public nl<Uri, InputStream> a(rl rlVar) {
            return new wl(this);
        }
    }

    public wl(c<Data> cVar) {
        this.a = cVar;
    }

    @Override // defpackage.nl
    public nl.a a(Uri uri, int i, int i2, bi biVar) {
        Uri uri2 = uri;
        return new nl.a(new iq(uri2), this.a.a(uri2));
    }

    @Override // defpackage.nl
    public boolean a(Uri uri) {
        return b.contains(uri.getScheme());
    }
}
