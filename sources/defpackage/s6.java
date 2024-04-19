package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import java.util.Arrays;
import java.util.HashMap;
/* compiled from: ConstraintHelper.java */
/* renamed from: s6  reason: default package */
/* loaded from: classes.dex */
public abstract class s6 extends View {
    public int[] c;
    public int d;
    public Context e;
    public w5 f;
    public boolean g;
    public String h;
    public String i;
    public View[] j;
    public HashMap<Integer, String> k;

    public s6(Context context) {
        super(context);
        this.c = new int[32];
        this.g = false;
        this.j = null;
        this.k = new HashMap<>();
        this.e = context;
        a((AttributeSet) null);
    }

    public void a(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, a7.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == a7.ConstraintLayout_Layout_constraint_referenced_ids) {
                    this.h = obtainStyledAttributes.getString(index);
                    setIds(this.h);
                } else if (index == a7.ConstraintLayout_Layout_constraint_referenced_tags) {
                    this.i = obtainStyledAttributes.getString(index);
                    setReferenceTags(this.i);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void a(t5 widget, boolean isRtl) {
    }

    public void b() {
    }

    public void b(ConstraintLayout container) {
    }

    public final void b(String tagString) {
        if (tagString == null || tagString.length() == 0 || this.e == null) {
            return;
        }
        String trim = tagString.trim();
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        if (constraintLayout == null) {
            Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
            return;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            if ((layoutParams instanceof ConstraintLayout.a) && trim.equals(((ConstraintLayout.a) layoutParams).Z)) {
                if (childAt.getId() == -1) {
                    StringBuilder a = jg.a("to use ConstraintTag view ");
                    a.append(childAt.getClass().getSimpleName());
                    a.append(" must have an ID");
                    Log.w("ConstraintHelper", a.toString());
                } else {
                    a(childAt.getId());
                }
            }
        }
    }

    public void c() {
    }

    public void c(ConstraintLayout container) {
        String str;
        int a;
        if (isInEditMode()) {
            setIds(this.h);
        }
        w5 w5Var = this.f;
        if (w5Var == null) {
            return;
        }
        x5 x5Var = (x5) w5Var;
        x5Var.v0 = 0;
        Arrays.fill(x5Var.u0, (Object) null);
        for (int i = 0; i < this.d; i++) {
            int i2 = this.c[i];
            View b = container.b(i2);
            if (b == null && (a = a(container, (str = this.k.get(Integer.valueOf(i2))))) != 0) {
                this.c[i] = a;
                this.k.put(Integer.valueOf(a), str);
                b = container.b(a);
            }
            if (b != null) {
                ((x5) this.f).a(container.b(b));
            }
        }
        this.f.a(container.e);
    }

    public void d() {
    }

    public void e() {
        if (this.f == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.a) {
            ((ConstraintLayout.a) layoutParams).s0 = (t5) this.f;
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.c, this.d);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.h;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.i;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (this.g) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void setIds(String idList) {
        this.h = idList;
        if (idList == null) {
            return;
        }
        int i = 0;
        this.d = 0;
        while (true) {
            int indexOf = idList.indexOf(44, i);
            if (indexOf == -1) {
                a(idList.substring(i));
                return;
            } else {
                a(idList.substring(i, indexOf));
                i = indexOf + 1;
            }
        }
    }

    public void setReferenceTags(String tagList) {
        this.i = tagList;
        if (tagList == null) {
            return;
        }
        int i = 0;
        this.d = 0;
        while (true) {
            int indexOf = tagList.indexOf(44, i);
            if (indexOf == -1) {
                b(tagList.substring(i));
                return;
            } else {
                b(tagList.substring(i, indexOf));
                i = indexOf + 1;
            }
        }
    }

    public void setReferencedIds(int[] ids) {
        this.h = null;
        this.d = 0;
        for (int i : ids) {
            a(i);
        }
    }

    @Override // android.view.View
    public void setTag(int key, Object tag) {
        super.setTag(key, tag);
        if (tag == null && this.h == null) {
            a(key);
        }
    }

    public final void a(int id) {
        if (id == getId()) {
            return;
        }
        int i = this.d + 1;
        int[] iArr = this.c;
        if (i > iArr.length) {
            this.c = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.c;
        int i2 = this.d;
        iArr2[i2] = id;
        this.d = i2 + 1;
    }

    public final void a(String idString) {
        if (idString == null || idString.length() == 0 || this.e == null) {
            return;
        }
        String trim = idString.trim();
        if (getParent() instanceof ConstraintLayout) {
            ConstraintLayout constraintLayout = (ConstraintLayout) getParent();
        }
        ConstraintLayout constraintLayout2 = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        int i = 0;
        if (isInEditMode() && constraintLayout2 != null) {
            Object a = constraintLayout2.a(0, trim);
            if (a instanceof Integer) {
                i = ((Integer) a).intValue();
            }
        }
        if (i == 0 && constraintLayout2 != null) {
            i = a(constraintLayout2, trim);
        }
        if (i == 0) {
            try {
                i = z6.class.getField(trim).getInt(null);
            } catch (Exception unused) {
            }
        }
        if (i == 0) {
            i = this.e.getResources().getIdentifier(trim, "id", this.e.getPackageName());
        }
        if (i != 0) {
            this.k.put(Integer.valueOf(i), trim);
            a(i);
            return;
        }
        Log.w("ConstraintHelper", "Could not find id of \"" + trim + "\"");
    }

    public final int a(ConstraintLayout container, String idString) {
        Resources resources;
        if (idString == null || container == null || (resources = this.e.getResources()) == null) {
            return 0;
        }
        int childCount = container.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = container.getChildAt(i);
            if (childAt.getId() != -1) {
                String str = null;
                try {
                    str = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                }
                if (idString.equals(str)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    public void a(ConstraintLayout container) {
        int visibility = getVisibility();
        int i = Build.VERSION.SDK_INT;
        float elevation = getElevation();
        for (int i2 = 0; i2 < this.d; i2++) {
            View b = container.b(this.c[i2]);
            if (b != null) {
                b.setVisibility(visibility);
                if (elevation > XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
                    int i3 = Build.VERSION.SDK_INT;
                    b.setTranslationZ(b.getTranslationZ() + elevation);
                }
            }
        }
    }

    public void a() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ConstraintLayout)) {
            return;
        }
        a((ConstraintLayout) parent);
    }
}
