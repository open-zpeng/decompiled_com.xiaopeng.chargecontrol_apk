package defpackage;

import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;
/* compiled from: ImageHeaderParserRegistry.java */
/* renamed from: gp  reason: default package */
/* loaded from: classes.dex */
public final class gp {
    public final List<ImageHeaderParser> a = new ArrayList();

    public synchronized List<ImageHeaderParser> a() {
        return this.a;
    }

    public synchronized void a(ImageHeaderParser imageHeaderParser) {
        this.a.add(imageHeaderParser);
    }
}
