package defpackage;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
/* compiled from: NestedScrollingChildHelper.java */
/* renamed from: n9  reason: default package */
/* loaded from: classes.dex */
public class n9 {
    public ViewParent a;
    public ViewParent b;
    public final View c;
    public boolean d;
    public int[] e;

    public n9(View view) {
        this.c = view;
    }

    public boolean a(float f, float f2, boolean z) {
        ViewParent a;
        if (!this.d || (a = a(0)) == null) {
            return false;
        }
        View view = this.c;
        int i = Build.VERSION.SDK_INT;
        try {
            return a.onNestedFling(view, f, f2, z);
        } catch (AbstractMethodError e) {
            Log.e("ViewParentCompat", "ViewParent " + a + " does not implement interface method onNestedFling", e);
            return false;
        }
    }

    public final boolean b(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        ViewParent a;
        int i6;
        int i7;
        int[] iArr3;
        if (!this.d || (a = a(i5)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        if (iArr != null) {
            this.c.getLocationInWindow(iArr);
            i6 = iArr[0];
            i7 = iArr[1];
        } else {
            i6 = 0;
            i7 = 0;
        }
        if (iArr2 == null) {
            if (this.e == null) {
                this.e = new int[2];
            }
            int[] iArr4 = this.e;
            iArr4[0] = 0;
            iArr4[1] = 0;
            iArr3 = iArr4;
        } else {
            iArr3 = iArr2;
        }
        View view = this.c;
        if (a instanceof p9) {
            ((p9) a).a(view, i, i2, i3, i4, i5, iArr3);
        } else {
            iArr3[0] = iArr3[0] + i3;
            iArr3[1] = iArr3[1] + i4;
            if (a instanceof o9) {
                ((o9) a).a(view, i, i2, i3, i4, i5);
            } else if (i5 == 0) {
                int i8 = Build.VERSION.SDK_INT;
                try {
                    a.onNestedScroll(view, i, i2, i3, i4);
                } catch (AbstractMethodError e) {
                    Log.e("ViewParentCompat", "ViewParent " + a + " does not implement interface method onNestedScroll", e);
                }
            }
        }
        if (iArr != null) {
            this.c.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i6;
            iArr[1] = iArr[1] - i7;
        }
        return true;
    }

    public void c(int i) {
        ViewParent a = a(i);
        if (a != null) {
            View view = this.c;
            if (a instanceof o9) {
                ((o9) a).a(view, i);
            } else if (i == 0) {
                int i2 = Build.VERSION.SDK_INT;
                try {
                    a.onStopNestedScroll(view);
                } catch (AbstractMethodError e) {
                    Log.e("ViewParentCompat", "ViewParent " + a + " does not implement interface method onStopNestedScroll", e);
                }
            }
            if (i == 0) {
                this.a = null;
            } else if (i != 1) {
            } else {
                this.b = null;
            }
        }
    }

    public boolean a(float f, float f2) {
        ViewParent a;
        if (!this.d || (a = a(0)) == null) {
            return false;
        }
        View view = this.c;
        int i = Build.VERSION.SDK_INT;
        try {
            return a.onNestedPreFling(view, f, f2);
        } catch (AbstractMethodError e) {
            Log.e("ViewParentCompat", "ViewParent " + a + " does not implement interface method onNestedPreFling", e);
            return false;
        }
    }

    public boolean a(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        ViewParent a;
        int i4;
        int i5;
        int[] iArr3;
        if (!this.d || (a = a(i3)) == null) {
            return false;
        }
        if (i == 0 && i2 == 0) {
            if (iArr2 != null) {
                iArr2[0] = 0;
                iArr2[1] = 0;
            }
            return false;
        }
        if (iArr2 != null) {
            this.c.getLocationInWindow(iArr2);
            i4 = iArr2[0];
            i5 = iArr2[1];
        } else {
            i4 = 0;
            i5 = 0;
        }
        if (iArr == null) {
            if (this.e == null) {
                this.e = new int[2];
            }
            iArr3 = this.e;
        } else {
            iArr3 = iArr;
        }
        iArr3[0] = 0;
        iArr3[1] = 0;
        View view = this.c;
        if (a instanceof o9) {
            ((o9) a).a(view, i, i2, iArr3, i3);
        } else if (i3 == 0) {
            int i6 = Build.VERSION.SDK_INT;
            try {
                a.onNestedPreScroll(view, i, i2, iArr3);
            } catch (AbstractMethodError e) {
                Log.e("ViewParentCompat", "ViewParent " + a + " does not implement interface method onNestedPreScroll", e);
            }
        }
        if (iArr2 != null) {
            this.c.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i4;
            iArr2[1] = iArr2[1] - i5;
        }
        return (iArr3[0] == 0 && iArr3[1] == 0) ? false : true;
    }

    public boolean b(int i) {
        return a(i) != null;
    }

    public boolean a(int i, int i2) {
        boolean z;
        if (a(i2) != null) {
            return true;
        }
        if (this.d) {
            View view = this.c;
            for (ViewParent parent = this.c.getParent(); parent != null; parent = parent.getParent()) {
                View view2 = this.c;
                boolean z2 = parent instanceof o9;
                if (z2) {
                    z = ((o9) parent).b(view, view2, i, i2);
                } else {
                    if (i2 == 0) {
                        int i3 = Build.VERSION.SDK_INT;
                        try {
                            z = parent.onStartNestedScroll(view, view2, i);
                        } catch (AbstractMethodError e) {
                            Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onStartNestedScroll", e);
                        }
                    }
                    z = false;
                }
                if (z) {
                    if (i2 == 0) {
                        this.a = parent;
                    } else if (i2 == 1) {
                        this.b = parent;
                    }
                    View view3 = this.c;
                    if (z2) {
                        ((o9) parent).a(view, view3, i, i2);
                    } else if (i2 == 0) {
                        int i4 = Build.VERSION.SDK_INT;
                        try {
                            parent.onNestedScrollAccepted(view, view3, i);
                        } catch (AbstractMethodError e2) {
                            Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onNestedScrollAccepted", e2);
                        }
                    }
                    return true;
                }
                if (parent instanceof View) {
                    view = parent;
                }
            }
        }
        return false;
    }

    public boolean a(int i, int i2, int i3, int i4, int[] iArr) {
        return b(i, i2, i3, i4, iArr, 0, null);
    }

    public void a(int i, int i2, int i3, int i4, int[] iArr, int i5, int[] iArr2) {
        b(i, i2, i3, i4, iArr, i5, iArr2);
    }

    public final ViewParent a(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return this.b;
        }
        return this.a;
    }
}
