package defpackage;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import java.util.Locale;
/* compiled from: ContentInfoCompat.java */
/* renamed from: h9  reason: default package */
/* loaded from: classes.dex */
public final class h9 {
    public final ClipData a;
    public final int b;
    public final int c;
    public final Uri d;
    public final Bundle e;

    /* compiled from: ContentInfoCompat.java */
    /* renamed from: h9$a */
    /* loaded from: classes.dex */
    public static final class a {
        public ClipData a;
        public int b;
        public int c;
        public Uri d;
        public Bundle e;

        public a(ClipData clipData, int i) {
            this.a = clipData;
            this.b = i;
        }
    }

    public h9(a aVar) {
        ClipData clipData = aVar.a;
        defpackage.a.a(clipData);
        this.a = clipData;
        int i = aVar.b;
        if (i < 0) {
            throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too low)", "source", 0, 3));
        }
        if (i <= 3) {
            this.b = i;
            int i2 = aVar.c;
            if ((i2 & 1) == i2) {
                this.c = i2;
                this.d = aVar.d;
                this.e = aVar.e;
                return;
            }
            StringBuilder a2 = jg.a("Requested flags 0x");
            a2.append(Integer.toHexString(i2));
            a2.append(", but only 0x");
            a2.append(Integer.toHexString(1));
            a2.append(" are allowed");
            throw new IllegalArgumentException(a2.toString());
        }
        throw new IllegalArgumentException(String.format(Locale.US, "%s is out of range of [%d, %d] (too high)", "source", 0, 3));
    }

    public String toString() {
        String str;
        StringBuilder a2 = jg.a("ContentInfoCompat{clip=");
        a2.append(this.a);
        a2.append(", source=");
        int i = this.b;
        if (i == 0) {
            str = "SOURCE_APP";
        } else if (i == 1) {
            str = "SOURCE_CLIPBOARD";
        } else if (i != 2) {
            str = i != 3 ? String.valueOf(i) : "SOURCE_DRAG_AND_DROP";
        } else {
            str = "SOURCE_INPUT_METHOD";
        }
        a2.append(str);
        a2.append(", flags=");
        int i2 = this.c;
        a2.append((i2 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i2));
        a2.append(", linkUri=");
        a2.append(this.d);
        a2.append(", extras=");
        a2.append(this.e);
        a2.append("}");
        return a2.toString();
    }
}
