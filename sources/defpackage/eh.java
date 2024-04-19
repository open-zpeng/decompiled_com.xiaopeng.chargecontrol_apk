package defpackage;

import com.bumptech.glide.integration.webp.WebpFrame;
/* compiled from: WebpFrameInfo.java */
/* renamed from: eh  reason: default package */
/* loaded from: classes.dex */
public class eh {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final boolean g;
    public final boolean h;

    public eh(int i, WebpFrame webpFrame) {
        this.a = i;
        this.b = webpFrame.getXOffest();
        this.c = webpFrame.getYOffest();
        this.d = webpFrame.getWidth();
        this.e = webpFrame.getHeight();
        this.f = webpFrame.getDurationMs();
        this.g = webpFrame.isBlendWithPreviousFrame();
        this.h = webpFrame.shouldDisposeToBackgroundColor();
    }

    public String toString() {
        StringBuilder a = jg.a("frameNumber=");
        a.append(this.a);
        a.append(", xOffset=");
        a.append(this.b);
        a.append(", yOffset=");
        a.append(this.c);
        a.append(", width=");
        a.append(this.d);
        a.append(", height=");
        a.append(this.e);
        a.append(", duration=");
        a.append(this.f);
        a.append(", blendPreviousFrame=");
        a.append(this.g);
        a.append(", disposeBackgroundColor=");
        a.append(this.h);
        return a.toString();
    }
}
