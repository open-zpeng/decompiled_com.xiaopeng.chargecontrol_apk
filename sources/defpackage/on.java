package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import java.util.List;
/* compiled from: ResourceDrawableDecoder.java */
/* renamed from: on  reason: default package */
/* loaded from: classes.dex */
public class on implements di<Uri, Drawable> {
    public final Context a;

    public on(Context context) {
        this.a = context.getApplicationContext();
    }

    @Override // defpackage.di
    public /* bridge */ /* synthetic */ vj<Drawable> a(Uri uri, int i, int i2, bi biVar) {
        return a(uri);
    }

    @Override // defpackage.di
    public boolean a(Uri uri, bi biVar) {
        return uri.getScheme().equals("android.resource");
    }

    public vj a(Uri uri) {
        Context context;
        int parseInt;
        String authority = uri.getAuthority();
        if (authority.equals(this.a.getPackageName())) {
            context = this.a;
        } else {
            try {
                context = this.a.createPackageContext(authority, 0);
            } catch (PackageManager.NameNotFoundException e) {
                if (authority.contains(this.a.getPackageName())) {
                    context = this.a;
                } else {
                    throw new IllegalArgumentException(jg.a("Failed to obtain context or unrecognized Uri format for: ", uri), e);
                }
            }
        }
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            List<String> pathSegments2 = uri.getPathSegments();
            String authority2 = uri.getAuthority();
            String str = pathSegments2.get(0);
            String str2 = pathSegments2.get(1);
            parseInt = context.getResources().getIdentifier(str2, str, authority2);
            if (parseInt == 0) {
                parseInt = Resources.getSystem().getIdentifier(str2, str, "android");
            }
            if (parseInt == 0) {
                throw new IllegalArgumentException(jg.a("Failed to find resource id for: ", uri));
            }
        } else if (pathSegments.size() == 1) {
            try {
                parseInt = Integer.parseInt(uri.getPathSegments().get(0));
            } catch (NumberFormatException e2) {
                throw new IllegalArgumentException(jg.a("Unrecognized Uri format: ", uri), e2);
            }
        } else {
            throw new IllegalArgumentException(jg.a("Unrecognized Uri format: ", uri));
        }
        Drawable a = ln.a(this.a, context, parseInt, null);
        if (a != null) {
            return new nn(a);
        }
        return null;
    }
}
