package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.xiaopeng.xui.drawable.XToggleDrawable;
/* compiled from: Constraints.java */
/* renamed from: v6  reason: default package */
/* loaded from: classes.dex */
public class v6 extends ViewGroup {
    public u6 c;

    public u6 getConstraintSet() {
        if (this.c == null) {
            this.c = new u6();
        }
        this.c.a(this);
        return this.c;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int l, int t, int r, int b) {
    }

    @Override // android.view.ViewGroup
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    @Override // android.view.ViewGroup
    public a generateLayoutParams(AttributeSet attrs) {
        return new a(getContext(), attrs);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        return new ConstraintLayout.a(p);
    }

    /* compiled from: Constraints.java */
    /* renamed from: v6$a */
    /* loaded from: classes.dex */
    public static class a extends ConstraintLayout.a {
        public float A0;
        public float B0;
        public float C0;
        public float D0;
        public float E0;
        public float F0;
        public float G0;
        public float u0;
        public boolean v0;
        public float w0;
        public float x0;
        public float y0;
        public float z0;

        public a(int width, int height) {
            super(width, height);
            this.u0 = 1.0f;
            this.v0 = false;
            this.w0 = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
            this.x0 = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
            this.y0 = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
            this.z0 = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
            this.A0 = 1.0f;
            this.B0 = 1.0f;
            this.C0 = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
            this.D0 = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
            this.E0 = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
            this.F0 = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
            this.G0 = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        }

        public a(Context c, AttributeSet attrs) {
            super(c, attrs);
            this.u0 = 1.0f;
            this.v0 = false;
            this.w0 = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
            this.x0 = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
            this.y0 = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
            this.z0 = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
            this.A0 = 1.0f;
            this.B0 = 1.0f;
            this.C0 = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
            this.D0 = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
            this.E0 = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
            this.F0 = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
            this.G0 = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
            TypedArray obtainStyledAttributes = c.obtainStyledAttributes(attrs, a7.ConstraintSet);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == a7.ConstraintSet_android_alpha) {
                    this.u0 = obtainStyledAttributes.getFloat(index, this.u0);
                } else if (index == a7.ConstraintSet_android_elevation) {
                    int i2 = Build.VERSION.SDK_INT;
                    this.w0 = obtainStyledAttributes.getFloat(index, this.w0);
                    this.v0 = true;
                } else if (index == a7.ConstraintSet_android_rotationX) {
                    this.y0 = obtainStyledAttributes.getFloat(index, this.y0);
                } else if (index == a7.ConstraintSet_android_rotationY) {
                    this.z0 = obtainStyledAttributes.getFloat(index, this.z0);
                } else if (index == a7.ConstraintSet_android_rotation) {
                    this.x0 = obtainStyledAttributes.getFloat(index, this.x0);
                } else if (index == a7.ConstraintSet_android_scaleX) {
                    this.A0 = obtainStyledAttributes.getFloat(index, this.A0);
                } else if (index == a7.ConstraintSet_android_scaleY) {
                    this.B0 = obtainStyledAttributes.getFloat(index, this.B0);
                } else if (index == a7.ConstraintSet_android_transformPivotX) {
                    this.C0 = obtainStyledAttributes.getFloat(index, this.C0);
                } else if (index == a7.ConstraintSet_android_transformPivotY) {
                    this.D0 = obtainStyledAttributes.getFloat(index, this.D0);
                } else if (index == a7.ConstraintSet_android_translationX) {
                    this.E0 = obtainStyledAttributes.getFloat(index, this.E0);
                } else if (index == a7.ConstraintSet_android_translationY) {
                    this.F0 = obtainStyledAttributes.getFloat(index, this.F0);
                } else if (index == a7.ConstraintSet_android_translationZ) {
                    int i3 = Build.VERSION.SDK_INT;
                    this.G0 = obtainStyledAttributes.getFloat(index, this.G0);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }
}
