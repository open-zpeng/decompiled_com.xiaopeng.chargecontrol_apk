package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.SystemProperties;
import android.util.SparseArray;
import android.view.View;
import android.view.WindowManager;
import defpackage.ye0;
import java.lang.reflect.Field;
import java.util.Arrays;
/* compiled from: VuiFloatingLayer.java */
/* renamed from: xe0  reason: default package */
/* loaded from: classes.dex */
public class xe0 implements ve0 {
    public Context a;
    public WindowManager e;
    public SparseArray<ye0> b = new SparseArray<>();
    public SparseArray<b> c = new SparseArray<>();
    public SparseArray<a> d = new SparseArray<>();
    public Handler f = new Handler();
    public SparseArray<d> g = new SparseArray<>();
    public SparseArray<c> h = new SparseArray<>();

    /* compiled from: VuiFloatingLayer.java */
    /* renamed from: xe0$a */
    /* loaded from: classes.dex */
    public class a implements ye0.b {
        public int a;

        public a(int i) {
            this.a = i;
        }
    }

    /* compiled from: VuiFloatingLayer.java */
    /* renamed from: xe0$b */
    /* loaded from: classes.dex */
    public class b {
        public int a;
        public int b;
        public int[] c;
        public int d;
        public int e;

        public b(xe0 xe0Var) {
        }

        public String toString() {
            StringBuilder a = jg.a("LayerInfo{targetWidth=");
            a.append(this.a);
            a.append(", targetHeight=");
            a.append(this.b);
            a.append(", location=");
            a.append(Arrays.toString(this.c));
            a.append(", mCenterOffsetX=");
            a.append(this.d);
            a.append(", mCenterOffsetY=");
            a.append(this.e);
            a.append('}');
            return a.toString();
        }
    }

    /* compiled from: VuiFloatingLayer.java */
    /* renamed from: xe0$c */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        public int c;

        public c(int i) {
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            xe0 xe0Var = xe0.this;
            StringBuilder a = jg.a("RunnableTimeOut type ");
            a.append(this.c);
            xe0Var.a(a.toString());
            xe0.this.b(this.c).b();
            xe0.this.d(this.c);
        }
    }

    /* compiled from: VuiFloatingLayer.java */
    /* renamed from: xe0$d */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        public int c;

        public d(int i) {
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            xe0 xe0Var = xe0.this;
            StringBuilder a = jg.a("touch RunnableTouch type ");
            a.append(this.c);
            xe0Var.a(a.toString());
            xe0.this.d(this.c);
        }
    }

    public xe0(Context context) {
        this.a = context;
        this.e = (WindowManager) this.a.getSystemService("window");
    }

    public final void a(WindowManager.LayoutParams layoutParams, int i) {
        be0.a("VuiFloatingLayer", "setXpFlags screenId : " + i);
        try {
            Field field = WindowManager.LayoutParams.class.getField("xpFlags");
            int i2 = field.getInt(layoutParams);
            if (i == 1) {
                i2 |= 16;
            } else if (i == 2) {
                i2 |= 32;
            }
            field.setInt(layoutParams, i2);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public final ye0 b(final int i) {
        ye0 ye0Var = this.b.get(i);
        if (ye0Var == null) {
            ye0 ye0Var2 = new ye0(this.a, i);
            this.b.put(i, ye0Var2);
            ye0Var2.setOnTouchListener(new ye0.c() { // from class: ue0
                @Override // defpackage.ye0.c
                public final void a(int i2) {
                    xe0.this.a(i, i2);
                }
            });
            return ye0Var2;
        }
        return ye0Var;
    }

    public void c(int i) {
        be0.a("VuiFloatingLayer", "hideFloatingLayer...type : " + i);
        ye0 b2 = b(i);
        if (b2 != null) {
            b2.d();
        } else {
            be0.a("VuiFloatingLayer", "view is null");
        }
        d(i);
    }

    public final void d(int i) {
        ye0 b2 = b(i);
        if (b2 != null) {
            b2.d();
        } else {
            be0.a("VuiFloatingLayer", "view is null");
        }
        if (b2 != null && b2.getParent() != null) {
            this.e.removeView(b2);
            this.f.removeCallbacks(a(i));
            be0.c("VuiFloatingLayer", "remove window..type : " + i);
            return;
        }
        be0.a("VuiFloatingLayer", "view is null or view all in window");
    }

    public /* synthetic */ void a(int i, int i2) {
        Handler handler = this.f;
        d dVar = this.g.get(i);
        if (dVar == null) {
            dVar = new d(i);
            this.g.put(i, dVar);
        }
        handler.postDelayed(dVar, 150L);
    }

    public final c a(int i) {
        c cVar = this.h.get(i);
        if (cVar == null) {
            c cVar2 = new c(i);
            this.h.put(i, cVar2);
            return cVar2;
        }
        return cVar;
    }

    public void a(View view, final int i, int i2, int i3) {
        int i4;
        char c2;
        be0.c("VuiFloatingLayer", "showFloatingLayer...type : " + i + " , view " + view);
        Handler handler = this.f;
        d dVar = this.g.get(i);
        if (dVar == null) {
            dVar = new d(i);
            this.g.put(i, dVar);
        }
        handler.removeCallbacks(dVar);
        this.f.removeCallbacks(a(i));
        b bVar = this.c.get(i);
        if (bVar == null) {
            bVar = new b(this);
            this.c.put(i, bVar);
        }
        bVar.a = view.getMeasuredWidth();
        bVar.b = view.getMeasuredHeight();
        bVar.d = i2;
        bVar.e = i3;
        bVar.c = new int[2];
        view.getLocationOnScreen(bVar.c);
        be0.a("VuiFloatingLayer", bVar.toString());
        final ye0 b2 = b(i);
        final a aVar = this.d.get(i);
        if (aVar == null) {
            aVar = new a(i);
            this.d.put(i, aVar);
        }
        b2.e();
        b2.postDelayed(new Runnable() { // from class: te0
            @Override // java.lang.Runnable
            public final void run() {
                xe0.this.a(i, b2, aVar);
            }
        }, 500L);
        d(i);
        b2.a();
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.gravity = 8388659;
        layoutParams.type = 2049;
        layoutParams.packageName = this.a.getPackageName();
        layoutParams.flags = 328488;
        layoutParams.format = -2;
        int visibleWidth = b2.getVisibleWidth();
        int visibleHeight = b2.getVisibleHeight();
        layoutParams.width = visibleWidth;
        layoutParams.height = visibleHeight;
        int[] iArr = new int[2];
        int[] iArr2 = bVar.c;
        int i5 = iArr2[0];
        int i6 = 1;
        if (i != 0) {
            if (i == 1) {
                int i7 = bVar.a;
                int i8 = (((i7 / 2) + i5) - (visibleWidth / 2)) + bVar.d;
                int i9 = (iArr2[1] - visibleHeight) + 35 + bVar.e;
                if ((i8 < i5 || i8 > i5 + i7) && be0.a(2)) {
                    c2 = 0;
                    be0.a(2, "VuiFloatingLocation", "offset more or less than current view width", null, false);
                } else {
                    c2 = 0;
                }
                iArr[c2] = i8;
                i6 = 1;
                iArr[1] = i9;
            }
            i4 = 0;
        } else {
            int i10 = bVar.a;
            int i11 = ((bVar.b / 2) + iArr2[1]) - (visibleHeight / 2);
            int i12 = (((i10 / 2) + i5) - (visibleWidth / 2)) + bVar.d;
            int i13 = i11 + bVar.e;
            if ((i12 < i5 || i12 > i5 + i10) && be0.a(2)) {
                i4 = 0;
                be0.a(2, "VuiFloatingLocation", "offset more or less than current view width", null, false);
            } else {
                i4 = 0;
            }
            iArr[i4] = i12;
            iArr[1] = i13;
            i6 = 1;
        }
        layoutParams.x = iArr[i4];
        layoutParams.y = iArr[i6];
        if (SystemProperties.getInt("persist.sys.xp.shared_display.enable", i4) == i6) {
            int i14 = layoutParams.x;
            if (i14 >= 2348) {
                layoutParams.x = i14 - 2400;
                a(layoutParams, 2);
            } else {
                a(layoutParams, 1);
            }
        }
        StringBuilder a2 = jg.a("setFloatingLocation  point : ");
        a2.append(iArr[0]);
        a2.append(" mLayoutParams.x: ");
        jg.a(a2, layoutParams.x, " ,viewWidth: ", visibleWidth, " info:");
        a2.append(bVar);
        be0.c("VuiFloatingLayer", a2.toString());
        b2.a(layoutParams.x, layoutParams.y);
        if (b2.getParent() == null) {
            this.e.addView(b2, layoutParams);
            be0.c("VuiFloatingLayer", "add to window x : " + layoutParams.x + ", y :" + layoutParams.y + " , w : " + layoutParams.width + " ,h : " + layoutParams.height);
        } else {
            this.e.updateViewLayout(b2, layoutParams);
            be0.c("VuiFloatingLayer", "update to window x : " + layoutParams.x + ", y :" + layoutParams.y + " , w : " + layoutParams.width + " ,h : " + layoutParams.height);
        }
        this.f.postDelayed(a(i), ze0.a(i));
        be0.a("VuiFloatingLayer", "startAnimation...");
        b2.c();
    }

    public /* synthetic */ void a(int i, ye0 ye0Var, a aVar) {
        be0.a("VuiFloatingLayer", "registerAnimationCallback...type : " + i);
        ye0Var.a(aVar);
    }

    public final void a(String str) {
        be0.a("VuiFloatingLayer", str);
    }
}
