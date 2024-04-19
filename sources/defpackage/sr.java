package defpackage;

import android.graphics.drawable.Drawable;
import com.xiaopeng.xui.drawable.XToggleDrawable;
/* compiled from: BaseEntry.java */
/* renamed from: sr  reason: default package */
/* loaded from: classes.dex */
public abstract class sr {
    public float c;
    public Object d;
    public Drawable e;

    public sr() {
        this.c = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        this.d = null;
        this.e = null;
    }

    public float a() {
        return this.c;
    }

    public sr(float f) {
        this.c = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        this.d = null;
        this.e = null;
        this.c = f;
    }
}
