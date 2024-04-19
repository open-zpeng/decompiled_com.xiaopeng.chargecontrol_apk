package defpackage;

import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.xiaopeng.xui.drawable.XToggleDrawable;
/* compiled from: VirtualLayout.java */
/* renamed from: c7  reason: default package */
/* loaded from: classes.dex */
public abstract class c7 extends s6 {
    public boolean l;
    public boolean m;

    @Override // defpackage.s6
    public void a(AttributeSet attrs) {
        super.a(attrs);
        if (attrs != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, a7.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == a7.ConstraintLayout_Layout_android_visibility) {
                    this.l = true;
                } else if (index == a7.ConstraintLayout_Layout_android_elevation) {
                    this.m = true;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    @Override // defpackage.s6
    public void b(ConstraintLayout container) {
        a(container);
    }

    public void f() {
    }

    @Override // defpackage.s6, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.l || this.m) {
            ViewParent parent = getParent();
            if (parent instanceof ConstraintLayout) {
                ConstraintLayout constraintLayout = (ConstraintLayout) parent;
                int visibility = getVisibility();
                int i = Build.VERSION.SDK_INT;
                float elevation = getElevation();
                for (int i2 = 0; i2 < this.d; i2++) {
                    View b = constraintLayout.b(this.c[i2]);
                    if (b != null) {
                        if (this.l) {
                            b.setVisibility(visibility);
                        }
                        if (this.m && elevation > XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
                            int i3 = Build.VERSION.SDK_INT;
                            b.setTranslationZ(b.getTranslationZ() + elevation);
                        }
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float elevation) {
        super.setElevation(elevation);
        a();
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        a();
    }
}
