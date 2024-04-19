package defpackage;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract;
import java.io.InputStream;
/* compiled from: StreamLocalUriFetcher.java */
/* renamed from: ui  reason: default package */
/* loaded from: classes.dex */
public class ui extends ri<InputStream> {
    public static final UriMatcher f = new UriMatcher(-1);

    static {
        f.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        f.addURI("com.android.contacts", "contacts/lookup/*", 1);
        f.addURI("com.android.contacts", "contacts/#/photo", 2);
        f.addURI("com.android.contacts", "contacts/#", 3);
        f.addURI("com.android.contacts", "contacts/#/display_photo", 4);
        f.addURI("com.android.contacts", "phone_lookup/*", 5);
    }

    public ui(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    @Override // defpackage.ri
    public void a(InputStream inputStream) {
        inputStream.close();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0025 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0026  */
    @Override // defpackage.ri
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.io.InputStream a(android.net.Uri r3, android.content.ContentResolver r4) {
        /*
            r2 = this;
            android.content.UriMatcher r0 = defpackage.ui.f
            int r0 = r0.match(r3)
            r1 = 1
            if (r0 == r1) goto L19
            r1 = 3
            if (r0 == r1) goto L14
            r1 = 5
            if (r0 == r1) goto L19
            java.io.InputStream r4 = r4.openInputStream(r3)
            goto L23
        L14:
            java.io.InputStream r4 = r2.a(r4, r3)
            goto L23
        L19:
            android.net.Uri r0 = android.provider.ContactsContract.Contacts.lookupContact(r4, r3)
            if (r0 == 0) goto L32
            java.io.InputStream r4 = r2.a(r4, r0)
        L23:
            if (r4 == 0) goto L26
            return r4
        L26:
            java.io.FileNotFoundException r4 = new java.io.FileNotFoundException
            java.lang.String r0 = "InputStream is null for "
            java.lang.String r3 = defpackage.jg.a(r0, r3)
            r4.<init>(r3)
            throw r4
        L32:
            java.io.FileNotFoundException r3 = new java.io.FileNotFoundException
            java.lang.String r4 = "Contact cannot be found"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ui.a(android.net.Uri, android.content.ContentResolver):java.lang.Object");
    }

    public final InputStream a(ContentResolver contentResolver, Uri uri) {
        return ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri, true);
    }

    @Override // defpackage.ji
    public Class<InputStream> a() {
        return InputStream.class;
    }
}
