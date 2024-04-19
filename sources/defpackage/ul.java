package defpackage;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import defpackage.nl;
import java.io.File;
import java.io.InputStream;
/* compiled from: StringLoader.java */
/* renamed from: ul  reason: default package */
/* loaded from: classes.dex */
public class ul<Data> implements nl<String, Data> {
    public final nl<Uri, Data> a;

    /* compiled from: StringLoader.java */
    /* renamed from: ul$a */
    /* loaded from: classes.dex */
    public static final class a implements ol<String, AssetFileDescriptor> {
        @Override // defpackage.ol
        public nl<String, AssetFileDescriptor> a(rl rlVar) {
            return new ul(rlVar.a(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* compiled from: StringLoader.java */
    /* renamed from: ul$b */
    /* loaded from: classes.dex */
    public static class b implements ol<String, ParcelFileDescriptor> {
        @Override // defpackage.ol
        public nl<String, ParcelFileDescriptor> a(rl rlVar) {
            return new ul(rlVar.a(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* compiled from: StringLoader.java */
    /* renamed from: ul$c */
    /* loaded from: classes.dex */
    public static class c implements ol<String, InputStream> {
        @Override // defpackage.ol
        public nl<String, InputStream> a(rl rlVar) {
            return new ul(rlVar.a(Uri.class, InputStream.class));
        }
    }

    public ul(nl<Uri, Data> nlVar) {
        this.a = nlVar;
    }

    @Override // defpackage.nl
    public nl.a a(String str, int i, int i2, bi biVar) {
        Uri a2;
        String str2 = str;
        if (TextUtils.isEmpty(str2)) {
            a2 = null;
        } else if (str2.charAt(0) == '/') {
            a2 = a2(str2);
        } else {
            Uri parse = Uri.parse(str2);
            a2 = parse.getScheme() == null ? a2(str2) : parse;
        }
        if (a2 == null || !this.a.a(a2)) {
            return null;
        }
        return this.a.a(a2, i, i2, biVar);
    }

    @Override // defpackage.nl
    public boolean a(String str) {
        return true;
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public static Uri a2(String str) {
        return Uri.fromFile(new File(str));
    }
}
