package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import com.xiaopeng.xui.drawable.XToggleDrawable;
/* compiled from: AbsActionBarView.java */
/* renamed from: n2  reason: default package */
/* loaded from: classes.dex */
public abstract class n2 extends ViewGroup {
    public final a c;
    public final Context d;
    public ActionMenuView e;
    public p2 f;
    public int g;
    public fa h;
    public boolean i;
    public boolean j;

    /* compiled from: AbsActionBarView.java */
    /* renamed from: n2$a */
    /* loaded from: classes.dex */
    public class a implements ga {
        public boolean a = false;
        public int b;

        public a() {
        }

        @Override // defpackage.ga
        public void a(View view) {
            this.a = true;
        }

        @Override // defpackage.ga
        public void b(View view) {
            if (this.a) {
                return;
            }
            n2 n2Var = n2.this;
            n2Var.h = null;
            n2.super.setVisibility(this.b);
        }

        @Override // defpackage.ga
        public void c(View view) {
            n2.super.setVisibility(0);
            this.a = false;
        }
    }

    public n2(Context context) {
        this(context, null);
    }

    public int getAnimatedVisibility() {
        if (this.h != null) {
            return this.c.b;
        }
        return getVisibility();
    }

    public int getContentHeight() {
        return this.g;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, i0.ActionBar, z.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(i0.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        p2 p2Var = this.f;
        if (p2Var != null) {
            if (!p2Var.s) {
                Configuration configuration2 = p2Var.d.getResources().getConfiguration();
                int i = configuration2.screenWidthDp;
                int i2 = configuration2.screenHeightDp;
                p2Var.r = (configuration2.smallestScreenWidthDp > 600 || i > 600 || (i > 960 && i2 > 720) || (i > 720 && i2 > 960)) ? 5 : (i >= 500 || (i > 640 && i2 > 480) || (i > 480 && i2 > 640)) ? 4 : i >= 360 ? 3 : 2;
            }
            z1 z1Var = p2Var.e;
            if (z1Var != null) {
                z1Var.b(true);
            }
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.j = false;
        }
        if (!this.j) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.j = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.j = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.i = false;
        }
        if (!this.i) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.i = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.i = false;
        }
        return true;
    }

    public abstract void setContentHeight(int i);

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i != getVisibility()) {
            fa faVar = this.h;
            if (faVar != null) {
                faVar.a();
            }
            super.setVisibility(i);
        }
    }

    public n2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public fa a(int i, long j) {
        fa faVar = this.h;
        if (faVar != null) {
            faVar.a();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                setAlpha(XToggleDrawable.LIGHT_RADIUS_DEFAULT);
            }
            fa a2 = y9.a(this);
            a2.a(1.0f);
            a2.a(j);
            a aVar = this.c;
            n2.this.h = a2;
            aVar.b = i;
            a2.a(aVar);
            return a2;
        }
        fa a3 = y9.a(this);
        a3.a(XToggleDrawable.LIGHT_RADIUS_DEFAULT);
        a3.a(j);
        a aVar2 = this.c;
        n2.this.h = a3;
        aVar2.b = i;
        a3.a(aVar2);
        return a3;
    }

    public n2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int i2;
        this.c = new a();
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(z.actionBarPopupTheme, typedValue, true) && (i2 = typedValue.resourceId) != 0) {
            this.d = new ContextThemeWrapper(context, i2);
        } else {
            this.d = context;
        }
    }

    public int a(View view, int i, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    public int a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = ((i3 - measuredHeight) / 2) + i2;
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }
}
