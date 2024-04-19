package com.xiaopeng.xui.drawable.ripple;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import com.xiaopeng.xui.drawable.XToggleDrawable;
/* loaded from: classes.dex */
public class XRipple {
    public static final long ANIMATION_TIME = 400;
    public static final String TAG = "XRipple";
    public AnimTransformListener mAnimTransformListener;
    public ValueAnimator mAnimationPress;
    public ValueAnimator mAnimationUp;
    public int mBackgroundColor;
    public Drawable.Callback mCallback;
    public float mClearDistance;
    public float mCurrentDistance;
    public float mDownX;
    public float mDownY;
    public boolean mIsAnimating;
    public boolean mIsPressAnimating;
    public boolean mIsTouched;
    public boolean mIsUpAnimating;
    public float mMaxPressRadius;
    public boolean mNeedUpAnim;
    public Paint mPaint;
    public float mPressRadius;
    public int mRippleAlpha;
    public int mRippleColor;
    public Path mRipplePath;
    public float mRippleRadius;
    public RectF mRippleRectF;
    public boolean mSupportScale;
    public View mView;

    /* loaded from: classes.dex */
    public interface AnimTransformListener {
        void onDownTransformation(float f, Transformation transformation);

        void onUpTransformation(float f, Transformation transformation);
    }

    public XRipple() {
        init();
    }

    private void drawRippleBackground(Canvas canvas) {
        View view;
        if (this.mRippleColor == 0 && (view = this.mView) != null) {
            this.mRippleColor = view.getContext().getColor(vc0.x_ripple_default_color);
        }
        int i = this.mBackgroundColor;
        if (i != 0) {
            this.mPaint.setColor(i);
            RectF rectF = this.mRippleRectF;
            float f = this.mRippleRadius;
            canvas.drawRoundRect(rectF, f, f, this.mPaint);
        }
        int i2 = this.mRippleColor;
        if (i2 != 0) {
            this.mPaint.setColor(i2);
        }
    }

    private void getView(Drawable.Callback callback) {
        if (callback != null) {
            if (callback instanceof Drawable) {
                getView(((Drawable) callback).getCallback());
                return;
            } else if (callback instanceof View) {
                this.mView = (View) callback;
                return;
            } else {
                String str = TAG;
                be0.a(str, hashCode() + ",callback is " + callback);
                return;
            }
        }
        String str2 = TAG;
        be0.a(str2, hashCode() + ",callback is null");
    }

    private void init() {
        this.mRipplePath = new Path();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        initAnimation();
    }

    private void initAnimation() {
        AccelerateDecelerateInterpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
        this.mAnimationPress = ValueAnimator.ofFloat(XToggleDrawable.LIGHT_RADIUS_DEFAULT, 1.0f).setDuration(400L);
        this.mAnimationPress.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.xui.drawable.ripple.XRipple.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                XRipple xRipple = XRipple.this;
                xRipple.mPressRadius = xRipple.mMaxPressRadius * floatValue;
                if (XRipple.this.mAnimTransformListener != null) {
                    XRipple.this.mAnimTransformListener.onDownTransformation(floatValue, null);
                }
                if (XRipple.this.mView != null && XRipple.this.mSupportScale) {
                    float f = 1.0f - (floatValue * 0.1f);
                    XRipple.this.mView.setScaleX(f);
                    XRipple.this.mView.setScaleY(f);
                }
                XRipple.this.invalidateSelf();
            }
        });
        this.mAnimationPress.addListener(new Animator.AnimatorListener() { // from class: com.xiaopeng.xui.drawable.ripple.XRipple.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (XRipple.this.mIsPressAnimating) {
                    XRipple.this.mIsPressAnimating = false;
                    if (XRipple.this.mNeedUpAnim) {
                        XRipple.this.mNeedUpAnim = false;
                        XRipple.this.mAnimationUp.start();
                        XRipple.this.mIsUpAnimating = true;
                    }
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                XRipple.this.mPaint.setAlpha(XRipple.this.mRippleAlpha);
                XRipple.this.mIsPressAnimating = true;
                XRipple.this.mIsAnimating = true;
            }
        });
        this.mAnimationPress.setInterpolator(accelerateDecelerateInterpolator);
        this.mAnimationPress.setDuration(400L);
        this.mAnimationUp = ValueAnimator.ofFloat(XToggleDrawable.LIGHT_RADIUS_DEFAULT, 1.0f).setDuration(400L);
        this.mAnimationUp.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.xiaopeng.xui.drawable.ripple.XRipple.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                XRipple xRipple = XRipple.this;
                float f = 1.0f - floatValue;
                xRipple.mCurrentDistance = xRipple.mClearDistance * f;
                if (XRipple.this.mAnimTransformListener != null) {
                    XRipple.this.mAnimTransformListener.onUpTransformation(floatValue, null);
                }
                XRipple.this.mPaint.setAlpha((int) (XRipple.this.mRippleAlpha * f));
                if (XRipple.this.mView != null && XRipple.this.mSupportScale) {
                    float f2 = (floatValue * 0.1f) + 0.9f;
                    XRipple.this.mView.setScaleX(f2);
                    XRipple.this.mView.setScaleY(f2);
                }
                XRipple.this.invalidateSelf();
            }
        });
        this.mAnimationUp.addListener(new Animator.AnimatorListener() { // from class: com.xiaopeng.xui.drawable.ripple.XRipple.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                XRipple.this.mPaint.setAlpha(XRipple.this.mRippleAlpha);
                XRipple.this.mIsUpAnimating = false;
                XRipple.this.mIsAnimating = false;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                XRipple.this.mIsUpAnimating = true;
            }
        });
        this.mAnimationUp.setInterpolator(accelerateDecelerateInterpolator);
        this.mAnimationUp.setDuration(400L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invalidateSelf() {
        Drawable.Callback callback = this.mCallback;
        if (callback != null) {
            if (callback instanceof View) {
                ((View) callback).invalidate();
                return;
            } else if (callback instanceof Drawable) {
                ((Drawable) callback).invalidateSelf();
                return;
            } else {
                return;
            }
        }
        be0.a(TAG, "Callback is null");
    }

    private boolean isVisible() {
        Drawable.Callback callback = this.mCallback;
        if (callback != null) {
            if (callback instanceof View) {
                return ((View) callback).getVisibility() == 0;
            } else if (callback instanceof Drawable) {
                return ((Drawable) callback).isVisible();
            }
        }
        return true;
    }

    private void resetPath() {
        if (this.mRippleRectF != null) {
            this.mRipplePath.reset();
            Path path = this.mRipplePath;
            RectF rectF = this.mRippleRectF;
            float f = this.mRippleRadius;
            path.addRoundRect(rectF, f, f, Path.Direction.CW);
        }
    }

    public void drawRipple(Canvas canvas) {
        if (isVisible()) {
            if (this.mRippleRectF == null) {
                setRippleRect(new RectF(XToggleDrawable.LIGHT_RADIUS_DEFAULT, XToggleDrawable.LIGHT_RADIUS_DEFAULT, canvas.getWidth(), canvas.getHeight()));
            }
            if (this.mIsPressAnimating && this.mIsAnimating) {
                drawRippleBackground(canvas);
                int saveLayer = canvas.saveLayer(XToggleDrawable.LIGHT_RADIUS_DEFAULT, XToggleDrawable.LIGHT_RADIUS_DEFAULT, canvas.getWidth(), canvas.getHeight(), null);
                canvas.clipPath(this.mRipplePath);
                canvas.drawCircle(this.mDownX, this.mDownY, this.mPressRadius, this.mPaint);
                canvas.restoreToCount(saveLayer);
            } else if (this.mIsUpAnimating && this.mIsAnimating) {
                drawRippleBackground(canvas);
                int saveLayer2 = canvas.saveLayer(XToggleDrawable.LIGHT_RADIUS_DEFAULT, XToggleDrawable.LIGHT_RADIUS_DEFAULT, canvas.getWidth(), canvas.getHeight(), null);
                RectF rectF = this.mRippleRectF;
                float f = this.mRippleRadius;
                canvas.drawRoundRect(rectF, f, f, this.mPaint);
                this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
                float f2 = this.mCurrentDistance;
                float f3 = (1.0f - (f2 / this.mClearDistance)) * this.mRippleRadius;
                RectF rectF2 = this.mRippleRectF;
                float f4 = f2 + rectF2.left;
                float f5 = f2 + rectF2.top;
                float width = rectF2.width() - this.mCurrentDistance;
                RectF rectF3 = this.mRippleRectF;
                canvas.drawRoundRect(f4, f5, width + rectF3.left, (rectF3.height() - this.mCurrentDistance) + this.mRippleRectF.top, f3, f3, this.mPaint);
                this.mPaint.setXfermode(null);
                canvas.restoreToCount(saveLayer2);
            } else if (this.mIsTouched && this.mIsAnimating) {
                drawRippleBackground(canvas);
                RectF rectF4 = this.mRippleRectF;
                float f6 = this.mRippleRadius;
                canvas.drawRoundRect(rectF4, f6, f6, this.mPaint);
            }
        }
    }

    public void onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            pressDown(motionEvent.getX(), motionEvent.getY());
        } else if (action == 1 || action == 3) {
            pressUp();
        }
    }

    public void pressDown(float f, float f2) {
        RectF rectF;
        if (!isVisible() || (rectF = this.mRippleRectF) == null) {
            return;
        }
        this.mDownX = f;
        this.mDownY = f2;
        this.mNeedUpAnim = false;
        this.mIsAnimating = false;
        float f3 = this.mDownX - rectF.left;
        float f4 = this.mDownY - rectF.top;
        if (f3 < rectF.width() / 2.0f) {
            f3 = this.mRippleRectF.width() - f3;
        }
        if (f4 < this.mRippleRectF.height() / 2.0f) {
            f4 = this.mRippleRectF.height() - f4;
        }
        this.mMaxPressRadius = (float) Math.sqrt((f4 * f4) + (f3 * f3));
        if (this.mIsUpAnimating) {
            this.mIsUpAnimating = false;
            this.mAnimationUp.cancel();
        }
        this.mIsPressAnimating = true;
        if (this.mAnimationPress.isRunning()) {
            this.mAnimationPress.cancel();
        }
        this.mAnimationPress.start();
        this.mIsTouched = true;
    }

    public void pressUp() {
        if (isVisible()) {
            this.mIsTouched = false;
            if (this.mIsPressAnimating) {
                this.mNeedUpAnim = true;
                return;
            }
            this.mAnimationUp.start();
            this.mIsUpAnimating = true;
        }
    }

    public void setAnimTransformListener(AnimTransformListener animTransformListener) {
        this.mAnimTransformListener = animTransformListener;
    }

    public void setCallback(Drawable.Callback callback) {
        this.mCallback = callback;
        getView(callback);
    }

    public void setPressDuration(long j) {
        this.mAnimationPress.setDuration(j);
    }

    public void setPressInterpolator(Interpolator interpolator) {
        this.mAnimationPress.setInterpolator(interpolator);
    }

    public void setRippleBackgroundColor(int i) {
        this.mBackgroundColor = i;
    }

    public void setRippleColor(int i) {
        this.mRippleColor = i;
        this.mPaint.setColor(i);
        this.mRippleAlpha = this.mPaint.getAlpha();
    }

    public void setRippleRadius(float f) {
        this.mRippleRadius = f;
        resetPath();
    }

    public void setRippleRect(RectF rectF) {
        this.mRippleRectF = rectF;
        if (this.mRippleRectF.width() > this.mRippleRectF.height()) {
            this.mClearDistance = this.mRippleRectF.height() / 2.0f;
        } else {
            this.mClearDistance = this.mRippleRectF.width() / 2.0f;
        }
        resetPath();
    }

    public void setSupportScale(boolean z) {
        this.mSupportScale = false;
    }

    public void setUpDuration(long j) {
        this.mAnimationUp.setDuration(j);
    }

    public void setUpInterpolator(Interpolator interpolator) {
        this.mAnimationUp.setInterpolator(interpolator);
    }

    @Deprecated
    public void setView(Drawable.Callback callback) {
        this.mCallback = callback;
        getView(callback);
    }

    public void setVisible(boolean z) {
        if (!z) {
            this.mAnimationPress.cancel();
            this.mAnimationUp.cancel();
            this.mIsPressAnimating = false;
            this.mIsUpAnimating = false;
            this.mIsAnimating = false;
            this.mPressRadius = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
            this.mCurrentDistance = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
            return;
        }
        View view = this.mView;
        if (view == null || !this.mSupportScale) {
            return;
        }
        view.setScaleX(1.0f);
        this.mView.setScaleY(1.0f);
    }

    public XRipple(Drawable.Callback callback) {
        this.mCallback = callback;
        getView(callback);
        init();
    }
}
