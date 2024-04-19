package defpackage;

import android.app.PendingIntent;
import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;
/* compiled from: NotificationCompat.java */
/* renamed from: h7  reason: default package */
/* loaded from: classes.dex */
public class h7 {
    public final Bundle a;
    public IconCompat b;
    public final l7[] c;
    public boolean d;
    public boolean e;
    public final int f;
    public final boolean g;
    @Deprecated
    public int h;
    public CharSequence i;
    public PendingIntent j;

    public IconCompat a() {
        int i;
        if (this.b == null && (i = this.h) != 0) {
            this.b = IconCompat.a(null, "", i);
        }
        return this.b;
    }

    public boolean b() {
        return this.e;
    }
}
