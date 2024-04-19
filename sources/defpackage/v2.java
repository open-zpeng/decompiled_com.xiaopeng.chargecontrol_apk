package defpackage;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.CompoundButton;
/* compiled from: AppCompatCompoundButtonHelper.java */
/* renamed from: v2  reason: default package */
/* loaded from: classes.dex */
public class v2 {
    public final CompoundButton a;
    public ColorStateList b = null;
    public PorterDuff.Mode c = null;
    public boolean d = false;
    public boolean e = false;
    public boolean f;

    public v2(CompoundButton compoundButton) {
        this.a = compoundButton;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0068 A[Catch: all -> 0x0076, TryCatch #0 {all -> 0x0076, blocks: (B:3:0x001d, B:5:0x0025, B:7:0x002d, B:11:0x0041, B:13:0x0049, B:15:0x0051, B:16:0x0060, B:18:0x0068, B:21:0x0078, B:23:0x0080), top: B:29:0x001d }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0080 A[Catch: all -> 0x0076, TRY_LEAVE, TryCatch #0 {all -> 0x0076, blocks: (B:3:0x001d, B:5:0x0025, B:7:0x002d, B:11:0x0041, B:13:0x0049, B:15:0x0051, B:16:0x0060, B:18:0x0068, B:21:0x0078, B:23:0x0080), top: B:29:0x001d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(android.util.AttributeSet r11, int r12) {
        /*
            r10 = this;
            android.widget.CompoundButton r0 = r10.a
            android.content.Context r0 = r0.getContext()
            int[] r1 = defpackage.i0.CompoundButton
            r2 = 0
            n4 r0 = defpackage.n4.a(r0, r11, r1, r12, r2)
            android.widget.CompoundButton r3 = r10.a
            android.content.Context r4 = r3.getContext()
            int[] r5 = defpackage.i0.CompoundButton
            android.content.res.TypedArray r7 = r0.b
            r9 = 0
            r6 = r11
            r8 = r12
            defpackage.y9.a(r3, r4, r5, r6, r7, r8, r9)
            int r11 = defpackage.i0.CompoundButton_buttonCompat     // Catch: java.lang.Throwable -> L76
            boolean r11 = r0.f(r11)     // Catch: java.lang.Throwable -> L76
            if (r11 == 0) goto L3e
            int r11 = defpackage.i0.CompoundButton_buttonCompat     // Catch: java.lang.Throwable -> L76
            int r11 = r0.e(r11, r2)     // Catch: java.lang.Throwable -> L76
            if (r11 == 0) goto L3e
            android.widget.CompoundButton r12 = r10.a     // Catch: android.content.res.Resources.NotFoundException -> L3e java.lang.Throwable -> L76
            android.widget.CompoundButton r1 = r10.a     // Catch: android.content.res.Resources.NotFoundException -> L3e java.lang.Throwable -> L76
            android.content.Context r1 = r1.getContext()     // Catch: android.content.res.Resources.NotFoundException -> L3e java.lang.Throwable -> L76
            android.graphics.drawable.Drawable r11 = defpackage.i1.b(r1, r11)     // Catch: android.content.res.Resources.NotFoundException -> L3e java.lang.Throwable -> L76
            r12.setButtonDrawable(r11)     // Catch: android.content.res.Resources.NotFoundException -> L3e java.lang.Throwable -> L76
            r11 = 1
            goto L3f
        L3e:
            r11 = r2
        L3f:
            if (r11 != 0) goto L60
            int r11 = defpackage.i0.CompoundButton_android_button     // Catch: java.lang.Throwable -> L76
            boolean r11 = r0.f(r11)     // Catch: java.lang.Throwable -> L76
            if (r11 == 0) goto L60
            int r11 = defpackage.i0.CompoundButton_android_button     // Catch: java.lang.Throwable -> L76
            int r11 = r0.e(r11, r2)     // Catch: java.lang.Throwable -> L76
            if (r11 == 0) goto L60
            android.widget.CompoundButton r12 = r10.a     // Catch: java.lang.Throwable -> L76
            android.widget.CompoundButton r1 = r10.a     // Catch: java.lang.Throwable -> L76
            android.content.Context r1 = r1.getContext()     // Catch: java.lang.Throwable -> L76
            android.graphics.drawable.Drawable r11 = defpackage.i1.b(r1, r11)     // Catch: java.lang.Throwable -> L76
            r12.setButtonDrawable(r11)     // Catch: java.lang.Throwable -> L76
        L60:
            int r11 = defpackage.i0.CompoundButton_buttonTint     // Catch: java.lang.Throwable -> L76
            boolean r11 = r0.f(r11)     // Catch: java.lang.Throwable -> L76
            if (r11 == 0) goto L78
            android.widget.CompoundButton r11 = r10.a     // Catch: java.lang.Throwable -> L76
            int r12 = defpackage.i0.CompoundButton_buttonTint     // Catch: java.lang.Throwable -> L76
            android.content.res.ColorStateList r12 = r0.a(r12)     // Catch: java.lang.Throwable -> L76
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L76
            r11.setButtonTintList(r12)     // Catch: java.lang.Throwable -> L76
            goto L78
        L76:
            r11 = move-exception
            goto L99
        L78:
            int r11 = defpackage.i0.CompoundButton_buttonTintMode     // Catch: java.lang.Throwable -> L76
            boolean r11 = r0.f(r11)     // Catch: java.lang.Throwable -> L76
            if (r11 == 0) goto L93
            android.widget.CompoundButton r11 = r10.a     // Catch: java.lang.Throwable -> L76
            int r12 = defpackage.i0.CompoundButton_buttonTintMode     // Catch: java.lang.Throwable -> L76
            r1 = -1
            int r12 = r0.c(r12, r1)     // Catch: java.lang.Throwable -> L76
            r1 = 0
            android.graphics.PorterDuff$Mode r12 = defpackage.t3.a(r12, r1)     // Catch: java.lang.Throwable -> L76
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L76
            r11.setButtonTintMode(r12)     // Catch: java.lang.Throwable -> L76
        L93:
            android.content.res.TypedArray r11 = r0.b
            r11.recycle()
            return
        L99:
            android.content.res.TypedArray r12 = r0.b
            r12.recycle()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.v2.a(android.util.AttributeSet, int):void");
    }

    public void a() {
        CompoundButton compoundButton = this.a;
        int i = Build.VERSION.SDK_INT;
        Drawable buttonDrawable = compoundButton.getButtonDrawable();
        if (buttonDrawable != null) {
            if (this.d || this.e) {
                int i2 = Build.VERSION.SDK_INT;
                Drawable mutate = buttonDrawable.mutate();
                if (this.d) {
                    ColorStateList colorStateList = this.b;
                    int i3 = Build.VERSION.SDK_INT;
                    mutate.setTintList(colorStateList);
                }
                if (this.e) {
                    PorterDuff.Mode mode = this.c;
                    int i4 = Build.VERSION.SDK_INT;
                    mutate.setTintMode(mode);
                }
                if (mutate.isStateful()) {
                    mutate.setState(this.a.getDrawableState());
                }
                this.a.setButtonDrawable(mutate);
            }
        }
    }

    public int a(int i) {
        int i2 = Build.VERSION.SDK_INT;
        return i;
    }
}
