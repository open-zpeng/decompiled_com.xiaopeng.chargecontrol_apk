package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
/* compiled from: HelpBaseHolder.java */
/* renamed from: x40  reason: default package */
/* loaded from: classes.dex */
public abstract class x40 {
    public View a;
    public ImageView b;

    public abstract int a();

    public void a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.a = layoutInflater.inflate(b(), viewGroup, true);
        this.b = (ImageView) this.a.findViewById(o90.banner);
        ImageView imageView = this.b;
        if (imageView != null) {
            imageView.setImageResource(a());
        }
    }

    public abstract int b();

    public abstract int c();

    public boolean d() {
        return true;
    }
}
