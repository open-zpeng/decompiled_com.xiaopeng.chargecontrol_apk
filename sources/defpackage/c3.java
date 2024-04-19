package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
/* compiled from: AppCompatPopupWindow.java */
/* renamed from: c3  reason: default package */
/* loaded from: classes.dex */
public class c3 extends PopupWindow {
    public static final boolean b;
    public boolean a;

    static {
        int i = Build.VERSION.SDK_INT;
        b = false;
    }

    public c3(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Drawable drawable;
        int resourceId;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i0.PopupWindow, i, i2);
        if (obtainStyledAttributes.hasValue(i0.PopupWindow_overlapAnchor)) {
            boolean z = obtainStyledAttributes.getBoolean(i0.PopupWindow_overlapAnchor, false);
            if (b) {
                this.a = z;
            } else {
                a.a(this, z);
            }
        }
        int i3 = i0.PopupWindow_android_popupBackground;
        if (obtainStyledAttributes.hasValue(i3) && (resourceId = obtainStyledAttributes.getResourceId(i3, 0)) != 0) {
            drawable = i1.b(context, resourceId);
        } else {
            drawable = obtainStyledAttributes.getDrawable(i3);
        }
        setBackgroundDrawable(drawable);
        obtainStyledAttributes.recycle();
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2) {
        if (b && this.a) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i, int i2, int i3, int i4) {
        if (b && this.a) {
            i2 -= view.getHeight();
        }
        super.update(view, i, i2, i3, i4);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (b && this.a) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }
}
