package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
/* compiled from: TintTypedArray.java */
/* renamed from: n4  reason: default package */
/* loaded from: classes.dex */
public class n4 {
    public final Context a;
    public final TypedArray b;
    public TypedValue c;

    public n4(Context context, TypedArray typedArray) {
        this.a = context;
        this.b = typedArray;
    }

    public static n4 a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new n4(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public Drawable b(int i) {
        int resourceId;
        if (this.b.hasValue(i) && (resourceId = this.b.getResourceId(i, 0)) != 0) {
            return i1.b(this.a, resourceId);
        }
        return this.b.getDrawable(i);
    }

    public Drawable c(int i) {
        int resourceId;
        if (!this.b.hasValue(i) || (resourceId = this.b.getResourceId(i, 0)) == 0) {
            return null;
        }
        return w2.a().a(this.a, resourceId, true);
    }

    public String d(int i) {
        return this.b.getString(i);
    }

    public CharSequence e(int i) {
        return this.b.getText(i);
    }

    public boolean f(int i) {
        return this.b.hasValue(i);
    }

    public static n4 a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new n4(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public int d(int i, int i2) {
        return this.b.getLayoutDimension(i, i2);
    }

    public int e(int i, int i2) {
        return this.b.getResourceId(i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00c8 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.graphics.Typeface a(int r13, int r14, defpackage.u7 r15) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.n4.a(int, int, u7):android.graphics.Typeface");
    }

    public int c(int i, int i2) {
        return this.b.getInt(i, i2);
    }

    public int b(int i, int i2) {
        return this.b.getDimensionPixelSize(i, i2);
    }

    public boolean a(int i, boolean z) {
        return this.b.getBoolean(i, z);
    }

    public ColorStateList a(int i) {
        int resourceId;
        ColorStateList a;
        return (!this.b.hasValue(i) || (resourceId = this.b.getResourceId(i, 0)) == 0 || (a = i1.a(this.a, resourceId)) == null) ? this.b.getColorStateList(i) : a;
    }

    public int a(int i, int i2) {
        return this.b.getDimensionPixelOffset(i, i2);
    }
}
