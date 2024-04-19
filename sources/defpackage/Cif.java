package defpackage;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import defpackage.nf;
/* compiled from: LinearSmoothScroller.java */
/* renamed from: if  reason: invalid class name and default package */
/* loaded from: classes.dex */
public class Cif extends nf.y {
    public static final boolean DEBUG = false;
    public static final float MILLISECONDS_PER_INCH = 25.0f;
    public static final int SNAP_TO_ANY = 0;
    public static final int SNAP_TO_END = 1;
    public static final int SNAP_TO_START = -1;
    public static final float TARGET_SEEK_EXTRA_SCROLL_RATIO = 1.2f;
    public static final int TARGET_SEEK_SCROLL_DISTANCE_PX = 10000;
    public final DisplayMetrics mDisplayMetrics;
    public float mMillisPerPixel;
    public PointF mTargetVector;
    public final LinearInterpolator mLinearInterpolator = new LinearInterpolator();
    public final DecelerateInterpolator mDecelerateInterpolator = new DecelerateInterpolator();
    public boolean mHasCalculatedMillisPerPixel = false;
    public int mInterimTargetDx = 0;
    public int mInterimTargetDy = 0;

    public Cif(Context context) {
        this.mDisplayMetrics = context.getResources().getDisplayMetrics();
    }

    private int clampApplyScroll(int i, int i2) {
        int i3 = i - i2;
        if (i * i3 <= 0) {
            return 0;
        }
        return i3;
    }

    private float getSpeedPerPixel() {
        if (!this.mHasCalculatedMillisPerPixel) {
            this.mMillisPerPixel = calculateSpeedPerPixel(this.mDisplayMetrics);
            this.mHasCalculatedMillisPerPixel = true;
        }
        return this.mMillisPerPixel;
    }

    public int calculateDtToFit(int i, int i2, int i3, int i4, int i5) {
        if (i5 != -1) {
            if (i5 != 0) {
                if (i5 == 1) {
                    return i4 - i2;
                }
                throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
            }
            int i6 = i3 - i;
            if (i6 > 0) {
                return i6;
            }
            int i7 = i4 - i2;
            if (i7 < 0) {
                return i7;
            }
            return 0;
        }
        return i3 - i;
    }

    public int calculateDxToMakeVisible(View view, int i) {
        nf.n layoutManager = getLayoutManager();
        if (layoutManager == null || !layoutManager.a()) {
            return 0;
        }
        nf.o oVar = (nf.o) view.getLayoutParams();
        return calculateDtToFit(layoutManager.f(view) - ((ViewGroup.MarginLayoutParams) oVar).leftMargin, layoutManager.i(view) + ((ViewGroup.MarginLayoutParams) oVar).rightMargin, layoutManager.o(), layoutManager.s() - layoutManager.p(), i);
    }

    public int calculateDyToMakeVisible(View view, int i) {
        nf.n layoutManager = getLayoutManager();
        if (layoutManager == null || !layoutManager.b()) {
            return 0;
        }
        nf.o oVar = (nf.o) view.getLayoutParams();
        return calculateDtToFit(layoutManager.j(view) - ((ViewGroup.MarginLayoutParams) oVar).topMargin, layoutManager.e(view) + ((ViewGroup.MarginLayoutParams) oVar).bottomMargin, layoutManager.q(), layoutManager.h() - layoutManager.n(), i);
    }

    public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        return 25.0f / displayMetrics.densityDpi;
    }

    public int calculateTimeForDeceleration(int i) {
        return (int) Math.ceil(calculateTimeForScrolling(i) / 0.3356d);
    }

    public int calculateTimeForScrolling(int i) {
        return (int) Math.ceil(Math.abs(i) * getSpeedPerPixel());
    }

    public int getHorizontalSnapPreference() {
        PointF pointF = this.mTargetVector;
        if (pointF != null) {
            float f = pointF.x;
            if (f != XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
                return f > XToggleDrawable.LIGHT_RADIUS_DEFAULT ? 1 : -1;
            }
        }
        return 0;
    }

    public int getVerticalSnapPreference() {
        PointF pointF = this.mTargetVector;
        if (pointF != null) {
            float f = pointF.y;
            if (f != XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
                return f > XToggleDrawable.LIGHT_RADIUS_DEFAULT ? 1 : -1;
            }
        }
        return 0;
    }

    @Override // defpackage.nf.y
    public void onSeekTargetStep(int i, int i2, nf.z zVar, nf.y.a aVar) {
        if (getChildCount() == 0) {
            stop();
            return;
        }
        this.mInterimTargetDx = clampApplyScroll(this.mInterimTargetDx, i);
        this.mInterimTargetDy = clampApplyScroll(this.mInterimTargetDy, i2);
        if (this.mInterimTargetDx == 0 && this.mInterimTargetDy == 0) {
            updateActionForInterimTarget(aVar);
        }
    }

    @Override // defpackage.nf.y
    public void onStart() {
    }

    @Override // defpackage.nf.y
    public void onStop() {
        this.mInterimTargetDy = 0;
        this.mInterimTargetDx = 0;
        this.mTargetVector = null;
    }

    @Override // defpackage.nf.y
    public void onTargetFound(View view, nf.z zVar, nf.y.a aVar) {
        int calculateDxToMakeVisible = calculateDxToMakeVisible(view, getHorizontalSnapPreference());
        int calculateDyToMakeVisible = calculateDyToMakeVisible(view, getVerticalSnapPreference());
        int calculateTimeForDeceleration = calculateTimeForDeceleration((int) Math.sqrt((calculateDyToMakeVisible * calculateDyToMakeVisible) + (calculateDxToMakeVisible * calculateDxToMakeVisible)));
        if (calculateTimeForDeceleration > 0) {
            DecelerateInterpolator decelerateInterpolator = this.mDecelerateInterpolator;
            aVar.a = -calculateDxToMakeVisible;
            aVar.b = -calculateDyToMakeVisible;
            aVar.c = calculateTimeForDeceleration;
            aVar.e = decelerateInterpolator;
            aVar.f = true;
        }
    }

    public void updateActionForInterimTarget(nf.y.a aVar) {
        PointF computeScrollVectorForPosition = computeScrollVectorForPosition(getTargetPosition());
        if (computeScrollVectorForPosition != null && (computeScrollVectorForPosition.x != XToggleDrawable.LIGHT_RADIUS_DEFAULT || computeScrollVectorForPosition.y != XToggleDrawable.LIGHT_RADIUS_DEFAULT)) {
            normalize(computeScrollVectorForPosition);
            this.mTargetVector = computeScrollVectorForPosition;
            this.mInterimTargetDx = (int) (computeScrollVectorForPosition.x * 10000.0f);
            this.mInterimTargetDy = (int) (computeScrollVectorForPosition.y * 10000.0f);
            int calculateTimeForScrolling = calculateTimeForScrolling(10000);
            LinearInterpolator linearInterpolator = this.mLinearInterpolator;
            aVar.a = (int) (this.mInterimTargetDx * 1.2f);
            aVar.b = (int) (this.mInterimTargetDy * 1.2f);
            aVar.c = (int) (calculateTimeForScrolling * 1.2f);
            aVar.e = linearInterpolator;
            aVar.f = true;
            return;
        }
        aVar.d = getTargetPosition();
        stop();
    }
}
