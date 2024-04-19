package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
/* compiled from: FragmentLayoutInflaterFactory.java */
/* renamed from: mc  reason: default package */
/* loaded from: classes.dex */
public class mc implements LayoutInflater.Factory2 {
    public final oc c;

    /* compiled from: FragmentLayoutInflaterFactory.java */
    /* renamed from: mc$a */
    /* loaded from: classes.dex */
    public class a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ vc c;

        public a(vc vcVar) {
            this.c = vcVar;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            vc vcVar = this.c;
            Fragment fragment = vcVar.c;
            vcVar.k();
            ld.a((ViewGroup) fragment.J.getParent(), mc.this.c).b();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    public mc(oc ocVar) {
        this.c = ocVar;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        vc d;
        if (ic.class.getName().equals(str)) {
            return new ic(context, attributeSet, this.c);
        }
        if ("fragment".equals(str)) {
            String attributeValue = attributeSet.getAttributeValue(null, "class");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, nb.Fragment);
            if (attributeValue == null) {
                attributeValue = obtainStyledAttributes.getString(nb.Fragment_android_name);
            }
            int resourceId = obtainStyledAttributes.getResourceId(nb.Fragment_android_id, -1);
            String string = obtainStyledAttributes.getString(nb.Fragment_android_tag);
            obtainStyledAttributes.recycle();
            if (attributeValue == null || !kc.b(context.getClassLoader(), attributeValue)) {
                return null;
            }
            int id = view != null ? view.getId() : 0;
            if (id == -1 && resourceId == -1 && string == null) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
            }
            Fragment b = resourceId != -1 ? this.c.b(resourceId) : null;
            if (b == null && string != null) {
                b = this.c.c.c(string);
            }
            if (b == null && id != -1) {
                b = this.c.b(id);
            }
            if (b == null) {
                b = this.c.m().a(context.getClassLoader(), attributeValue);
                b.p = true;
                b.y = resourceId != 0 ? resourceId : id;
                b.z = id;
                b.A = string;
                b.q = true;
                oc ocVar = this.c;
                b.u = ocVar;
                lc<?> lcVar = ocVar.r;
                b.v = lcVar;
                Context context2 = lcVar.d;
                b.a(attributeSet, b.d);
                d = this.c.a(b);
                if (oc.c(2)) {
                    Log.v("FragmentManager", "Fragment " + b + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                }
            } else if (!b.q) {
                b.q = true;
                oc ocVar2 = this.c;
                b.u = ocVar2;
                lc<?> lcVar2 = ocVar2.r;
                b.v = lcVar2;
                Context context3 = lcVar2.d;
                b.a(attributeSet, b.d);
                d = this.c.d(b);
                if (oc.c(2)) {
                    Log.v("FragmentManager", "Retained Fragment " + b + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                }
            } else {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
            }
            b.I = (ViewGroup) view;
            d.k();
            d.j();
            View view2 = b.J;
            if (view2 != null) {
                if (resourceId != 0) {
                    view2.setId(resourceId);
                }
                if (b.J.getTag() == null) {
                    b.J.setTag(string);
                }
                b.J.addOnAttachStateChangeListener(new a(d));
                return b.J;
            }
            throw new IllegalStateException(jg.b("Fragment ", attributeValue, " did not create a view."));
        }
        return null;
    }
}
