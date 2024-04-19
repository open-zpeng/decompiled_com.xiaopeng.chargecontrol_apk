package defpackage;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import defpackage.nl;
import java.io.InputStream;
/* compiled from: AssetUriLoader.java */
/* renamed from: al  reason: default package */
/* loaded from: classes.dex */
public class al<Data> implements nl<Uri, Data> {
    public final AssetManager a;
    public final a<Data> b;

    /* compiled from: AssetUriLoader.java */
    /* renamed from: al$a */
    /* loaded from: classes.dex */
    public interface a<Data> {
        ji<Data> a(AssetManager assetManager, String str);
    }

    /* compiled from: AssetUriLoader.java */
    /* renamed from: al$b */
    /* loaded from: classes.dex */
    public static class b implements ol<Uri, ParcelFileDescriptor>, a<ParcelFileDescriptor> {
        public final AssetManager a;

        public b(AssetManager assetManager) {
            this.a = assetManager;
        }

        @Override // defpackage.ol
        public nl<Uri, ParcelFileDescriptor> a(rl rlVar) {
            return new al(this.a, this);
        }

        @Override // defpackage.al.a
        public ji<ParcelFileDescriptor> a(AssetManager assetManager, String str) {
            return new ni(assetManager, str);
        }
    }

    /* compiled from: AssetUriLoader.java */
    /* renamed from: al$c */
    /* loaded from: classes.dex */
    public static class c implements ol<Uri, InputStream>, a<InputStream> {
        public final AssetManager a;

        public c(AssetManager assetManager) {
            this.a = assetManager;
        }

        @Override // defpackage.ol
        public nl<Uri, InputStream> a(rl rlVar) {
            return new al(this.a, this);
        }

        @Override // defpackage.al.a
        public ji<InputStream> a(AssetManager assetManager, String str) {
            return new ti(assetManager, str);
        }
    }

    public al(AssetManager assetManager, a<Data> aVar) {
        this.a = assetManager;
        this.b = aVar;
    }

    @Override // defpackage.nl
    public nl.a a(Uri uri, int i, int i2, bi biVar) {
        Uri uri2 = uri;
        return new nl.a(new iq(uri2), this.b.a(this.a, uri2.toString().substring(22)));
    }

    @Override // defpackage.nl
    public boolean a(Uri uri) {
        Uri uri2 = uri;
        return "file".equals(uri2.getScheme()) && !uri2.getPathSegments().isEmpty() && "android_asset".equals(uri2.getPathSegments().get(0));
    }
}
