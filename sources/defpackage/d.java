package defpackage;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.ParcelableVolumeInfo;
import defpackage.b;
import java.lang.ref.WeakReference;
import java.util.List;
/* compiled from: MediaControllerCompat.java */
/* renamed from: d  reason: default package */
/* loaded from: classes.dex */
public abstract class d implements IBinder.DeathRecipient {
    public defpackage.b c;

    /* compiled from: MediaControllerCompat.java */
    /* renamed from: d$a */
    /* loaded from: classes.dex */
    public static class a implements g {
        public final WeakReference<d> a;

        public a(d dVar) {
            this.a = new WeakReference<>(dVar);
        }
    }

    public d() {
        int i = Build.VERSION.SDK_INT;
        new h(new a(this));
    }

    public void a() {
    }

    public void a(int i, Object obj, Bundle bundle) {
    }

    public void b() {
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        a(8, null, null);
    }

    public void c() {
    }

    public void d() {
    }

    public void e() {
    }

    public void f() {
    }

    public void g() {
    }

    public void h() {
    }

    /* compiled from: MediaControllerCompat.java */
    /* renamed from: d$b */
    /* loaded from: classes.dex */
    public static class b extends b.a {
        public final WeakReference<d> c;

        public b(d dVar) {
            this.c = new WeakReference<>(dVar);
        }

        public void a() {
            d dVar = this.c.get();
            if (dVar != null) {
                dVar.a(8, null, null);
            }
        }

        public void a(MediaMetadataCompat mediaMetadataCompat) {
            d dVar = this.c.get();
            if (dVar != null) {
                dVar.a(3, mediaMetadataCompat, null);
            }
        }

        public void a(List<MediaSessionCompat.QueueItem> list) {
            d dVar = this.c.get();
            if (dVar != null) {
                dVar.a(5, list, null);
            }
        }

        public void a(CharSequence charSequence) {
            d dVar = this.c.get();
            if (dVar != null) {
                dVar.a(6, charSequence, null);
            }
        }

        public void a(Bundle bundle) {
            d dVar = this.c.get();
            if (dVar != null) {
                dVar.a(7, bundle, null);
            }
        }

        public void a(ParcelableVolumeInfo parcelableVolumeInfo) {
            d dVar = this.c.get();
            if (dVar != null) {
                dVar.a(4, parcelableVolumeInfo != null ? new f(parcelableVolumeInfo.c, parcelableVolumeInfo.d, parcelableVolumeInfo.e, parcelableVolumeInfo.f, parcelableVolumeInfo.g) : null, null);
            }
        }
    }
}
