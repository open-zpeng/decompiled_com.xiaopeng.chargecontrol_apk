package defpackage;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.Fragment;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* compiled from: FragmentTransitionImpl.java */
@SuppressLint({"UnknownNullness"})
/* renamed from: gd  reason: default package */
/* loaded from: classes.dex */
public abstract class gd {

    /* compiled from: FragmentTransitionImpl.java */
    /* renamed from: gd$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ int c;
        public final /* synthetic */ ArrayList d;
        public final /* synthetic */ ArrayList e;
        public final /* synthetic */ ArrayList f;
        public final /* synthetic */ ArrayList g;

        public a(gd gdVar, int i, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
            this.c = i;
            this.d = arrayList;
            this.e = arrayList2;
            this.f = arrayList3;
            this.g = arrayList4;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i = 0; i < this.c; i++) {
                y9.a((View) this.d.get(i), (String) this.e.get(i));
                int i2 = Build.VERSION.SDK_INT;
                ((View) this.f.get(i)).setTransitionName((String) this.g.get(i));
            }
        }
    }

    public abstract Object a(Object obj, Object obj2, Object obj3);

    public void a(View view, Rect rect) {
        if (y9.q(view)) {
            RectF rectF = new RectF();
            rectF.set(XToggleDrawable.LIGHT_RADIUS_DEFAULT, XToggleDrawable.LIGHT_RADIUS_DEFAULT, view.getWidth(), view.getHeight());
            view.getMatrix().mapRect(rectF);
            rectF.offset(view.getLeft(), view.getTop());
            ViewParent parent = view.getParent();
            while (parent instanceof View) {
                View view2 = (View) parent;
                rectF.offset(-view2.getScrollX(), -view2.getScrollY());
                view2.getMatrix().mapRect(rectF);
                rectF.offset(view2.getLeft(), view2.getTop());
                parent = view2.getParent();
            }
            int[] iArr = new int[2];
            view.getRootView().getLocationOnScreen(iArr);
            rectF.offset(iArr[0], iArr[1]);
            rect.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
        }
    }

    public abstract void a(Object obj, Rect rect);

    public abstract void a(Object obj, View view);

    public abstract void a(Object obj, View view, ArrayList<View> arrayList);

    public abstract void a(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    public abstract void a(Object obj, ArrayList<View> arrayList);

    public abstract void a(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract boolean a(Object obj);

    public abstract Object b(Object obj);

    public abstract Object b(Object obj, Object obj2, Object obj3);

    public abstract void b(Object obj, View view);

    public abstract void b(Object obj, View view, ArrayList<View> arrayList);

    public abstract void b(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    public abstract void c(Object obj, View view);

    public ArrayList<String> a(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = arrayList.get(i);
            arrayList2.add(y9.m(view));
            int i2 = Build.VERSION.SDK_INT;
            view.setTransitionName(null);
        }
        return arrayList2;
    }

    public void a(View view, ArrayList<View> arrayList, ArrayList<View> arrayList2, ArrayList<String> arrayList3, Map<String, String> map) {
        int size = arrayList2.size();
        ArrayList arrayList4 = new ArrayList();
        for (int i = 0; i < size; i++) {
            View view2 = arrayList.get(i);
            String m = y9.m(view2);
            arrayList4.add(m);
            if (m != null) {
                int i2 = Build.VERSION.SDK_INT;
                view2.setTransitionName(null);
                String str = map.get(m);
                int i3 = 0;
                while (true) {
                    if (i3 >= size) {
                        break;
                    } else if (str.equals(arrayList3.get(i3))) {
                        int i4 = Build.VERSION.SDK_INT;
                        arrayList2.get(i3).setTransitionName(m);
                        break;
                    } else {
                        i3++;
                    }
                }
            }
        }
        v9.a(view, new a(this, size, arrayList2, arrayList3, arrayList, arrayList4));
    }

    public void a(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() == 0) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int i = Build.VERSION.SDK_INT;
                if (viewGroup.isTransitionGroup()) {
                    arrayList.add(viewGroup);
                    return;
                }
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    a(arrayList, viewGroup.getChildAt(i2));
                }
                return;
            }
            arrayList.add(view);
        }
    }

    public void a(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String m = y9.m(view);
            if (m != null) {
                map.put(m, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    a(map, viewGroup.getChildAt(i));
                }
            }
        }
    }

    public void a(Fragment fragment, Object obj, m8 m8Var, Runnable runnable) {
        runnable.run();
    }

    public static boolean a(List<View> list, View view, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2) == view) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(List list) {
        return list == null || list.isEmpty();
    }
}
