package defpackage;

import android.content.ClipDescription;
import android.net.Uri;
import android.view.inputmethod.InputContentInfo;
/* compiled from: InputContentInfoCompat.java */
/* renamed from: ya  reason: default package */
/* loaded from: classes.dex */
public final class ya {
    public final b a;

    /* compiled from: InputContentInfoCompat.java */
    /* renamed from: ya$a */
    /* loaded from: classes.dex */
    public static final class a implements b {
        public final InputContentInfo a;

        public a(Object obj) {
            this.a = (InputContentInfo) obj;
        }

        @Override // defpackage.ya.b
        public ClipDescription a() {
            return this.a.getDescription();
        }

        @Override // defpackage.ya.b
        public Object b() {
            return this.a;
        }

        @Override // defpackage.ya.b
        public Uri c() {
            return this.a.getContentUri();
        }

        @Override // defpackage.ya.b
        public void d() {
            this.a.requestPermission();
        }

        @Override // defpackage.ya.b
        public Uri e() {
            return this.a.getLinkUri();
        }
    }

    /* compiled from: InputContentInfoCompat.java */
    /* renamed from: ya$b */
    /* loaded from: classes.dex */
    public interface b {
        ClipDescription a();

        Object b();

        Uri c();

        void d();

        Uri e();
    }

    public ya(b bVar) {
        this.a = bVar;
    }
}
