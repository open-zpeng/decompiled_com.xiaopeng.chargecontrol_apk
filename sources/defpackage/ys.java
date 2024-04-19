package defpackage;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.os.Build;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.xiaopeng.xui.drawable.XLoadingDrawable;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import defpackage.zs;
/* compiled from: BarLineChartTouchListener.java */
/* renamed from: ys  reason: default package */
/* loaded from: classes.dex */
public class ys extends zs<br<? extends qr<? extends rs<? extends vr>>>> {
    public Matrix h;
    public Matrix i;
    public vt j;
    public vt k;
    public float l;
    public float m;
    public float n;
    public ts o;
    public VelocityTracker p;
    public long q;
    public vt r;
    public vt s;
    public float t;
    public float u;

    public ys(br<? extends qr<? extends rs<? extends vr>>> brVar, Matrix matrix, float f) {
        super(brVar);
        this.h = new Matrix();
        this.i = new Matrix();
        this.j = vt.a(XToggleDrawable.LIGHT_RADIUS_DEFAULT, XToggleDrawable.LIGHT_RADIUS_DEFAULT);
        this.k = vt.a(XToggleDrawable.LIGHT_RADIUS_DEFAULT, XToggleDrawable.LIGHT_RADIUS_DEFAULT);
        this.l = 1.0f;
        this.m = 1.0f;
        this.n = 1.0f;
        this.q = 0L;
        this.r = vt.a(XToggleDrawable.LIGHT_RADIUS_DEFAULT, XToggleDrawable.LIGHT_RADIUS_DEFAULT);
        this.s = vt.a(XToggleDrawable.LIGHT_RADIUS_DEFAULT, XToggleDrawable.LIGHT_RADIUS_DEFAULT);
        this.h = matrix;
        this.t = zt.a(f);
        this.u = zt.a(3.5f);
    }

    public static float b(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((y * y) + (x * x));
    }

    public final void a(MotionEvent motionEvent) {
        this.i.set(this.h);
        this.j.b = motionEvent.getX();
        this.j.c = motionEvent.getY();
        this.o = ((br) this.g).c(motionEvent.getX(), motionEvent.getY());
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        this.c = zs.a.DOUBLE_TAP;
        at onChartGestureListener = ((br) this.g).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.a(motionEvent);
        }
        if (((br) this.g).r() && ((qr) ((br) this.g).getData()).b() > 0) {
            vt a = a(motionEvent.getX(), motionEvent.getY());
            T t = this.g;
            ((br) t).b(((br) t).y() ? 1.4f : 1.0f, ((br) this.g).z() ? 1.4f : 1.0f, a.b, a.c);
            if (((br) this.g).j()) {
                StringBuilder a2 = jg.a("Double-Tap, Zooming In, x: ");
                a2.append(a.b);
                a2.append(", y: ");
                a2.append(a.c);
                Log.i("BarlineChartTouch", a2.toString());
            }
            vt.d.a((wt<vt>) a);
        }
        return super.onDoubleTap(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.c = zs.a.FLING;
        at onChartGestureListener = ((br) this.g).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.a(motionEvent, motionEvent2, f, f2);
        }
        return super.onFling(motionEvent, motionEvent2, f, f2);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        this.c = zs.a.LONG_PRESS;
        at onChartGestureListener = ((br) this.g).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.c(motionEvent);
        }
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        this.c = zs.a.SINGLE_TAP;
        at onChartGestureListener = ((br) this.g).getOnChartGestureListener();
        if (onChartGestureListener != null) {
            onChartGestureListener.b(motionEvent);
        }
        if (((br) this.g).i()) {
            is a = ((br) this.g).a(motionEvent.getX(), motionEvent.getY());
            if (a != null && !a.a(this.e)) {
                this.g.a(a, true);
                this.e = a;
            } else {
                this.g.a(null, true);
                this.e = null;
            }
            return super.onSingleTapUp(motionEvent);
        }
        return false;
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        is a;
        VelocityTracker velocityTracker;
        if (this.p == null) {
            this.p = VelocityTracker.obtain();
        }
        this.p.addMovement(motionEvent);
        if (motionEvent.getActionMasked() == 3 && (velocityTracker = this.p) != null) {
            velocityTracker.recycle();
            this.p = null;
        }
        if (this.d == 0) {
            this.f.onTouchEvent(motionEvent);
        }
        if (((br) this.g).s() || ((br) this.g).y() || ((br) this.g).z()) {
            int action = motionEvent.getAction() & XLoadingDrawable.ALPHA_MAX;
            if (action != 0) {
                int i = 0;
                if (action != 1) {
                    float f = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
                    if (action == 2) {
                        int i2 = this.d;
                        if (i2 == 1) {
                            ((br) this.g).e();
                            float x = ((br) this.g).t() ? motionEvent.getX() - this.j.b : 0.0f;
                            if (((br) this.g).u()) {
                                f = motionEvent.getY() - this.j.c;
                            }
                            a(motionEvent, x, f);
                        } else if (i2 == 2 || i2 == 3 || i2 == 4) {
                            ((br) this.g).e();
                            if ((((br) this.g).y() || ((br) this.g).z()) && motionEvent.getPointerCount() >= 2) {
                                at onChartGestureListener = ((br) this.g).getOnChartGestureListener();
                                float b = b(motionEvent);
                                if (b > this.u) {
                                    vt vtVar = this.k;
                                    vt a2 = a(vtVar.b, vtVar.c);
                                    au viewPortHandler = ((br) this.g).getViewPortHandler();
                                    int i3 = this.d;
                                    if (i3 == 4) {
                                        this.c = zs.a.PINCH_ZOOM;
                                        float f2 = b / this.n;
                                        boolean z = f2 < 1.0f;
                                        boolean z2 = !z ? viewPortHandler.i >= viewPortHandler.h : viewPortHandler.i <= viewPortHandler.g;
                                        if (!z ? viewPortHandler.j < viewPortHandler.f : viewPortHandler.j > viewPortHandler.e) {
                                            i = 1;
                                        }
                                        float f3 = ((br) this.g).y() ? f2 : 1.0f;
                                        if (!((br) this.g).z()) {
                                            f2 = 1.0f;
                                        }
                                        if (i != 0 || z2) {
                                            this.h.set(this.i);
                                            this.h.postScale(f3, f2, a2.b, a2.c);
                                            if (onChartGestureListener != null) {
                                                onChartGestureListener.a(motionEvent, f3, f2);
                                            }
                                        }
                                    } else if (i3 == 2 && ((br) this.g).y()) {
                                        this.c = zs.a.X_ZOOM;
                                        float abs = Math.abs(motionEvent.getX(0) - motionEvent.getX(1)) / this.l;
                                        if (!(abs < 1.0f) ? viewPortHandler.i < viewPortHandler.h : viewPortHandler.i > viewPortHandler.g) {
                                            i = 1;
                                        }
                                        if (i != 0) {
                                            this.h.set(this.i);
                                            this.h.postScale(abs, 1.0f, a2.b, a2.c);
                                            if (onChartGestureListener != null) {
                                                onChartGestureListener.a(motionEvent, abs, 1.0f);
                                            }
                                        }
                                    } else if (this.d == 3 && ((br) this.g).z()) {
                                        this.c = zs.a.Y_ZOOM;
                                        float abs2 = Math.abs(motionEvent.getY(0) - motionEvent.getY(1)) / this.m;
                                        if (!(abs2 < 1.0f) ? viewPortHandler.j < viewPortHandler.f : viewPortHandler.j > viewPortHandler.e) {
                                            i = 1;
                                        }
                                        if (i != 0) {
                                            this.h.set(this.i);
                                            this.h.postScale(1.0f, abs2, a2.b, a2.c);
                                            if (onChartGestureListener != null) {
                                                onChartGestureListener.a(motionEvent, 1.0f, abs2);
                                            }
                                        }
                                    }
                                    vt.d.a((wt<vt>) a2);
                                }
                            }
                        } else if (i2 == 0) {
                            float x2 = motionEvent.getX() - this.j.b;
                            float y = motionEvent.getY() - this.j.c;
                            if (Math.abs((float) Math.sqrt((y * y) + (x2 * x2))) > this.t && ((br) this.g).s()) {
                                if (!((br) this.g).v() || !((br) this.g).o()) {
                                    i = 1;
                                }
                                if (i != 0) {
                                    float abs3 = Math.abs(motionEvent.getX() - this.j.b);
                                    float abs4 = Math.abs(motionEvent.getY() - this.j.c);
                                    if ((((br) this.g).t() || abs4 >= abs3) && (((br) this.g).u() || abs4 <= abs3)) {
                                        this.c = zs.a.DRAG;
                                        this.d = 1;
                                    }
                                } else if (((br) this.g).w()) {
                                    this.c = zs.a.DRAG;
                                    if (((br) this.g).w() && (a = ((br) this.g).a(motionEvent.getX(), motionEvent.getY())) != null && !a.a(this.e)) {
                                        this.e = a;
                                        ((br) this.g).a(a, true);
                                    }
                                }
                            }
                        }
                    } else if (action == 3) {
                        this.d = 0;
                        at onChartGestureListener2 = this.g.getOnChartGestureListener();
                        if (onChartGestureListener2 != null) {
                            onChartGestureListener2.b(motionEvent, this.c);
                        }
                    } else if (action != 5) {
                        if (action == 6) {
                            VelocityTracker velocityTracker2 = this.p;
                            velocityTracker2.computeCurrentVelocity(1000, zt.c);
                            int actionIndex = motionEvent.getActionIndex();
                            int pointerId = motionEvent.getPointerId(actionIndex);
                            float xVelocity = velocityTracker2.getXVelocity(pointerId);
                            float yVelocity = velocityTracker2.getYVelocity(pointerId);
                            int pointerCount = motionEvent.getPointerCount();
                            while (true) {
                                if (i >= pointerCount) {
                                    break;
                                }
                                if (i != actionIndex) {
                                    int pointerId2 = motionEvent.getPointerId(i);
                                    if ((velocityTracker2.getYVelocity(pointerId2) * yVelocity) + (velocityTracker2.getXVelocity(pointerId2) * xVelocity) < XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
                                        velocityTracker2.clear();
                                        break;
                                    }
                                }
                                i++;
                            }
                            this.d = 5;
                        }
                    } else if (motionEvent.getPointerCount() >= 2) {
                        ((br) this.g).e();
                        a(motionEvent);
                        this.l = Math.abs(motionEvent.getX(0) - motionEvent.getX(1));
                        this.m = Math.abs(motionEvent.getY(0) - motionEvent.getY(1));
                        this.n = b(motionEvent);
                        if (this.n > 10.0f) {
                            if (((br) this.g).x()) {
                                this.d = 4;
                            } else if (((br) this.g).y() != ((br) this.g).z()) {
                                this.d = ((br) this.g).y() ? 2 : 3;
                            } else {
                                this.d = this.l > this.m ? 2 : 3;
                            }
                        }
                        vt vtVar2 = this.k;
                        float x3 = motionEvent.getX(1) + motionEvent.getX(0);
                        float y2 = motionEvent.getY(0);
                        vtVar2.b = x3 / 2.0f;
                        vtVar2.c = (motionEvent.getY(1) + y2) / 2.0f;
                    }
                } else {
                    VelocityTracker velocityTracker3 = this.p;
                    int pointerId3 = motionEvent.getPointerId(0);
                    velocityTracker3.computeCurrentVelocity(1000, zt.c);
                    float yVelocity2 = velocityTracker3.getYVelocity(pointerId3);
                    float xVelocity2 = velocityTracker3.getXVelocity(pointerId3);
                    if ((Math.abs(xVelocity2) > zt.b || Math.abs(yVelocity2) > zt.b) && this.d == 1 && ((br) this.g).h()) {
                        b();
                        this.q = AnimationUtils.currentAnimationTimeMillis();
                        this.r.b = motionEvent.getX();
                        this.r.c = motionEvent.getY();
                        vt vtVar3 = this.s;
                        vtVar3.b = xVelocity2;
                        vtVar3.c = yVelocity2;
                        T t = this.g;
                        int i4 = Build.VERSION.SDK_INT;
                        t.postInvalidateOnAnimation();
                    }
                    int i5 = this.d;
                    if (i5 == 2 || i5 == 3 || i5 == 4 || i5 == 5) {
                        ((br) this.g).d();
                        ((br) this.g).postInvalidate();
                    }
                    this.d = 0;
                    ((br) this.g).f();
                    VelocityTracker velocityTracker4 = this.p;
                    if (velocityTracker4 != null) {
                        velocityTracker4.recycle();
                        this.p = null;
                    }
                    at onChartGestureListener3 = this.g.getOnChartGestureListener();
                    if (onChartGestureListener3 != null) {
                        onChartGestureListener3.b(motionEvent, this.c);
                    }
                }
            } else {
                at onChartGestureListener4 = this.g.getOnChartGestureListener();
                if (onChartGestureListener4 != null) {
                    onChartGestureListener4.a(motionEvent, this.c);
                }
                b();
                a(motionEvent);
            }
            au viewPortHandler2 = ((br) this.g).getViewPortHandler();
            Matrix matrix = this.h;
            viewPortHandler2.a(matrix, this.g, true);
            this.h = matrix;
            return true;
        }
        return true;
    }

    public void b() {
        vt vtVar = this.s;
        vtVar.b = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        vtVar.c = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
    }

    public final void a(MotionEvent motionEvent, float f, float f2) {
        this.c = zs.a.DRAG;
        this.h.set(this.i);
        at onChartGestureListener = ((br) this.g).getOnChartGestureListener();
        if (a()) {
            if (this.g instanceof dr) {
                f = -f;
            } else {
                f2 = -f2;
            }
        }
        this.h.postTranslate(f, f2);
        if (onChartGestureListener != null) {
            onChartGestureListener.b(motionEvent, f, f2);
        }
    }

    public vt a(float f, float f2) {
        float f3;
        au viewPortHandler = ((br) this.g).getViewPortHandler();
        float f4 = f - viewPortHandler.b.left;
        if (a()) {
            f3 = -(f2 - viewPortHandler.b.top);
        } else {
            f3 = -((((br) this.g).getMeasuredHeight() - f2) - viewPortHandler.d());
        }
        return vt.a(f4, f3);
    }

    public final boolean a() {
        ts tsVar;
        return (this.o == null && ((br) this.g).p()) || ((tsVar = this.o) != null && ((br) this.g).b(((rr) tsVar).f));
    }
}
