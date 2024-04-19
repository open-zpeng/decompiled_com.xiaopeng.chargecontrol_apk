package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import defpackage.l1;
/* compiled from: ActionBar.java */
/* renamed from: j0  reason: default package */
/* loaded from: classes.dex */
public abstract class j0 {

    /* compiled from: ActionBar.java */
    /* renamed from: j0$b */
    /* loaded from: classes.dex */
    public interface b {
        void a(boolean z);
    }

    /* compiled from: ActionBar.java */
    @Deprecated
    /* renamed from: j0$c */
    /* loaded from: classes.dex */
    public static abstract class c {
        public abstract CharSequence a();

        public abstract View b();

        public abstract Drawable c();

        public abstract CharSequence d();

        public abstract void e();
    }

    public abstract l1 a(l1.a aVar);

    public abstract void a(Configuration configuration);

    public abstract void a(CharSequence charSequence);

    public abstract void a(boolean z);

    public abstract boolean a();

    public abstract boolean a(int i, KeyEvent keyEvent);

    public abstract int b();

    public abstract void b(boolean z);

    public abstract Context c();

    public abstract void c(boolean z);

    public void d() {
    }

    /* compiled from: ActionBar.java */
    /* renamed from: j0$a */
    /* loaded from: classes.dex */
    public static class a extends ViewGroup.MarginLayoutParams {
        public int a;

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i0.ActionBarLayout);
            this.a = obtainStyledAttributes.getInt(i0.ActionBarLayout_android_layout_gravity, 0);
            obtainStyledAttributes.recycle();
        }

        public a(int i, int i2) {
            super(i, i2);
            this.a = 0;
            this.a = 8388627;
        }

        public a(a aVar) {
            super((ViewGroup.MarginLayoutParams) aVar);
            this.a = 0;
            this.a = aVar.a;
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 0;
        }
    }
}
