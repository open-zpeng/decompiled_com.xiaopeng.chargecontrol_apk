package com.xiaopeng.xui.drawable.shimmer;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Deprecated
/* loaded from: classes.dex */
public class XShimmer {
    public static final int COMPONENT_COUNT = 4;
    public static boolean msGlobalEnable;
    public long repeatDelay;
    public final float[] positions = new float[4];
    public final int[] colors = new int[4];
    public int direction = 0;
    public int highlightColor = 1728053247;
    public int baseColor = 16777215;
    public int shape = 0;
    public int fixedWidth = 0;
    public int fixedHeight = 0;
    public float widthRatio = 1.0f;
    public float heightRatio = 1.0f;
    public float intensity = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
    public float dropoff = 0.5f;
    public float tilt = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
    public boolean clipToChildren = true;
    public boolean autoStart = true;
    public boolean alphaShimmer = true;
    public int repeatCount = -1;
    public int repeatMode = 1;
    public long animationDuration = 1000;

    /* loaded from: classes.dex */
    public static class AlphaHighlightBuilder extends Builder<AlphaHighlightBuilder> {
        public AlphaHighlightBuilder() {
            this.mShimmer.alphaShimmer = true;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.xiaopeng.xui.drawable.shimmer.XShimmer.Builder
        public AlphaHighlightBuilder getThis() {
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static class ColorHighlightBuilder extends Builder<ColorHighlightBuilder> {
        public ColorHighlightBuilder() {
            this.mShimmer.alphaShimmer = false;
        }

        @Override // com.xiaopeng.xui.drawable.shimmer.XShimmer.Builder
        public ColorHighlightBuilder getThis() {
            return this;
        }

        @Override // com.xiaopeng.xui.drawable.shimmer.XShimmer.Builder
        public ColorHighlightBuilder consumeAttributes(TypedArray typedArray) {
            super.consumeAttributes(typedArray);
            if (typedArray.hasValue(dd0.XShimmerDrawable_shimmer_base_color)) {
                setBaseColor(typedArray.getColor(dd0.XShimmerDrawable_shimmer_base_color, this.mShimmer.baseColor));
            }
            if (typedArray.hasValue(dd0.XShimmerDrawable_shimmer_highlight_color)) {
                setHighlightColor(typedArray.getColor(dd0.XShimmerDrawable_shimmer_highlight_color, this.mShimmer.highlightColor));
            }
            return getThis();
        }

        @Override // com.xiaopeng.xui.drawable.shimmer.XShimmer.Builder
        public ColorHighlightBuilder setBaseColor(int i) {
            XShimmer xShimmer = this.mShimmer;
            xShimmer.baseColor = (i & 16777215) | (xShimmer.baseColor & (-16777216));
            return getThis();
        }

        @Override // com.xiaopeng.xui.drawable.shimmer.XShimmer.Builder
        public ColorHighlightBuilder setHighlightColor(int i) {
            this.mShimmer.highlightColor = i;
            return getThis();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Direction {
        public static final int BOTTOM_TO_TOP = 3;
        public static final int LEFT_TO_RIGHT = 0;
        public static final int RIGHT_TO_LEFT = 2;
        public static final int TOP_TO_BOTTOM = 1;
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Shape {
        public static final int LINEAR = 0;
        public static final int RADIAL = 1;
    }

    public int height(int i) {
        int i2 = this.fixedHeight;
        return i2 > 0 ? i2 : Math.round(this.heightRatio * i);
    }

    public void updateColors() {
        if (this.shape != 1) {
            int[] iArr = this.colors;
            int i = this.baseColor;
            iArr[0] = i;
            int i2 = this.highlightColor;
            iArr[1] = i2;
            iArr[2] = i2;
            iArr[3] = i;
            return;
        }
        int[] iArr2 = this.colors;
        int i3 = this.highlightColor;
        iArr2[0] = i3;
        iArr2[1] = i3;
        int i4 = this.baseColor;
        iArr2[2] = i4;
        iArr2[3] = i4;
    }

    public void updatePositions() {
        if (this.shape != 1) {
            this.positions[0] = Math.max(((1.0f - this.intensity) - this.dropoff) / 2.0f, (float) XToggleDrawable.LIGHT_RADIUS_DEFAULT);
            this.positions[1] = Math.max((1.0f - this.intensity) / 2.0f, (float) XToggleDrawable.LIGHT_RADIUS_DEFAULT);
            this.positions[2] = Math.min((this.intensity + 1.0f) / 2.0f, 1.0f);
            this.positions[3] = Math.min(((this.intensity + 1.0f) + this.dropoff) / 2.0f, 1.0f);
            return;
        }
        float[] fArr = this.positions;
        fArr[0] = 0.0f;
        fArr[1] = Math.min(this.intensity, 1.0f);
        this.positions[2] = Math.min(this.intensity + this.dropoff, 1.0f);
        this.positions[3] = 1.0f;
    }

    public int width(int i) {
        int i2 = this.fixedWidth;
        return i2 > 0 ? i2 : Math.round(this.widthRatio * i);
    }

    /* loaded from: classes.dex */
    public static abstract class Builder<T extends Builder<T>> {
        public final XShimmer mShimmer = new XShimmer();

        public static float clamp(float f, float f2, float f3) {
            return Math.min(f2, Math.max(f, f3));
        }

        public XShimmer build() {
            this.mShimmer.updateColors();
            this.mShimmer.updatePositions();
            return this.mShimmer;
        }

        public T consumeAttributes(Context context, AttributeSet attributeSet) {
            return consumeAttributes(context.obtainStyledAttributes(attributeSet, dd0.XShimmerDrawable, 0, 0));
        }

        public T copyFrom(XShimmer xShimmer) {
            setDirection(xShimmer.direction);
            setShape(xShimmer.shape);
            setFixedWidth(xShimmer.fixedWidth);
            setFixedHeight(xShimmer.fixedHeight);
            setWidthRatio(xShimmer.widthRatio);
            setHeightRatio(xShimmer.heightRatio);
            setIntensity(xShimmer.intensity);
            setDropoff(xShimmer.dropoff);
            setTilt(xShimmer.tilt);
            setClipToChildren(xShimmer.clipToChildren);
            setAutoStart(xShimmer.autoStart);
            setRepeatCount(xShimmer.repeatCount);
            setRepeatMode(xShimmer.repeatMode);
            setRepeatDelay(xShimmer.repeatDelay);
            setDuration(xShimmer.animationDuration);
            XShimmer xShimmer2 = this.mShimmer;
            xShimmer2.baseColor = xShimmer.baseColor;
            xShimmer2.highlightColor = xShimmer.highlightColor;
            return getThis();
        }

        public abstract T getThis();

        public T setAutoStart(boolean z) {
            this.mShimmer.autoStart = z;
            return getThis();
        }

        public T setBaseAlpha(float f) {
            XShimmer xShimmer = this.mShimmer;
            xShimmer.baseColor = (((int) (clamp(XToggleDrawable.LIGHT_RADIUS_DEFAULT, 1.0f, f) * 255.0f)) << 24) | (xShimmer.baseColor & 16777215);
            return getThis();
        }

        public T setBaseColor(int i) {
            return getThis();
        }

        public T setClipToChildren(boolean z) {
            this.mShimmer.clipToChildren = z;
            return getThis();
        }

        public T setDirection(int i) {
            this.mShimmer.direction = i;
            return getThis();
        }

        public T setDropoff(float f) {
            if (f >= XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
                this.mShimmer.dropoff = f;
                return getThis();
            }
            throw new IllegalArgumentException("Given invalid dropoff value: " + f);
        }

        public T setDuration(long j) {
            if (j >= 0) {
                this.mShimmer.animationDuration = j;
                return getThis();
            }
            throw new IllegalArgumentException("Given a negative duration: " + j);
        }

        public T setFixedHeight(int i) {
            if (i >= 0) {
                this.mShimmer.fixedHeight = i;
                return getThis();
            }
            throw new IllegalArgumentException(jg.a("Given invalid height: ", i));
        }

        public T setFixedWidth(int i) {
            if (i >= 0) {
                this.mShimmer.fixedWidth = i;
                return getThis();
            }
            throw new IllegalArgumentException(jg.a("Given invalid width: ", i));
        }

        public T setHeightRatio(float f) {
            if (f >= XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
                this.mShimmer.heightRatio = f;
                return getThis();
            }
            throw new IllegalArgumentException("Given invalid height ratio: " + f);
        }

        public T setHighlightAlpha(float f) {
            XShimmer xShimmer = this.mShimmer;
            xShimmer.highlightColor = (((int) (clamp(XToggleDrawable.LIGHT_RADIUS_DEFAULT, 1.0f, f) * 255.0f)) << 24) | (xShimmer.highlightColor & 16777215);
            return getThis();
        }

        public T setHighlightColor(int i) {
            return getThis();
        }

        public T setIntensity(float f) {
            if (f >= XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
                this.mShimmer.intensity = f;
                return getThis();
            }
            throw new IllegalArgumentException("Given invalid intensity value: " + f);
        }

        public T setRepeatCount(int i) {
            this.mShimmer.repeatCount = i;
            return getThis();
        }

        public T setRepeatDelay(long j) {
            if (j >= 0) {
                this.mShimmer.repeatDelay = j;
                return getThis();
            }
            throw new IllegalArgumentException("Given a negative repeat delay: " + j);
        }

        public T setRepeatMode(int i) {
            this.mShimmer.repeatMode = i;
            return getThis();
        }

        public T setShape(int i) {
            this.mShimmer.shape = i;
            return getThis();
        }

        public T setTilt(float f) {
            this.mShimmer.tilt = f;
            return getThis();
        }

        public T setWidthRatio(float f) {
            if (f >= XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
                this.mShimmer.widthRatio = f;
                return getThis();
            }
            throw new IllegalArgumentException("Given invalid width ratio: " + f);
        }

        public T consumeAttributes(TypedArray typedArray) {
            if (typedArray.hasValue(dd0.XShimmerDrawable_shimmer_clip_to_children)) {
                setClipToChildren(typedArray.getBoolean(dd0.XShimmerDrawable_shimmer_clip_to_children, this.mShimmer.clipToChildren));
            }
            if (typedArray.hasValue(dd0.XShimmerDrawable_shimmer_auto_start)) {
                setAutoStart(typedArray.getBoolean(dd0.XShimmerDrawable_shimmer_auto_start, this.mShimmer.autoStart));
            }
            if (typedArray.hasValue(dd0.XShimmerDrawable_shimmer_base_alpha)) {
                setBaseAlpha(typedArray.getFloat(dd0.XShimmerDrawable_shimmer_base_alpha, 0.3f));
            }
            if (typedArray.hasValue(dd0.XShimmerDrawable_shimmer_highlight_alpha)) {
                setHighlightAlpha(typedArray.getFloat(dd0.XShimmerDrawable_shimmer_highlight_alpha, 1.0f));
            }
            if (typedArray.hasValue(dd0.XShimmerDrawable_shimmer_duration)) {
                setDuration(typedArray.getInt(dd0.XShimmerDrawable_shimmer_duration, (int) this.mShimmer.animationDuration));
            }
            if (typedArray.hasValue(dd0.XShimmerDrawable_shimmer_repeat_count)) {
                setRepeatCount(typedArray.getInt(dd0.XShimmerDrawable_shimmer_repeat_count, this.mShimmer.repeatCount));
            }
            if (typedArray.hasValue(dd0.XShimmerDrawable_shimmer_repeat_delay)) {
                setRepeatDelay(typedArray.getInt(dd0.XShimmerDrawable_shimmer_repeat_delay, (int) this.mShimmer.repeatDelay));
            }
            if (typedArray.hasValue(dd0.XShimmerDrawable_shimmer_repeat_mode)) {
                setRepeatMode(typedArray.getInt(dd0.XShimmerDrawable_shimmer_repeat_mode, this.mShimmer.repeatMode));
            }
            if (typedArray.hasValue(dd0.XShimmerDrawable_shimmer_direction)) {
                setDirection(typedArray.getInt(dd0.XShimmerDrawable_shimmer_direction, this.mShimmer.direction));
            }
            if (typedArray.hasValue(dd0.XShimmerDrawable_shimmer_shape)) {
                setShape(typedArray.getInt(dd0.XShimmerDrawable_shimmer_shape, this.mShimmer.shape));
            }
            if (typedArray.hasValue(dd0.XShimmerDrawable_shimmer_dropoff)) {
                setDropoff(typedArray.getFloat(dd0.XShimmerDrawable_shimmer_dropoff, this.mShimmer.dropoff));
            }
            if (typedArray.hasValue(dd0.XShimmerDrawable_shimmer_fixed_width)) {
                setFixedWidth(typedArray.getDimensionPixelSize(dd0.XShimmerDrawable_shimmer_fixed_width, this.mShimmer.fixedWidth));
            }
            if (typedArray.hasValue(dd0.XShimmerDrawable_shimmer_fixed_height)) {
                setFixedHeight(typedArray.getDimensionPixelSize(dd0.XShimmerDrawable_shimmer_fixed_height, this.mShimmer.fixedHeight));
            }
            if (typedArray.hasValue(dd0.XShimmerDrawable_shimmer_intensity)) {
                setIntensity(typedArray.getFloat(dd0.XShimmerDrawable_shimmer_intensity, this.mShimmer.intensity));
            }
            if (typedArray.hasValue(dd0.XShimmerDrawable_shimmer_width_ratio)) {
                setWidthRatio(typedArray.getFloat(dd0.XShimmerDrawable_shimmer_width_ratio, this.mShimmer.widthRatio));
            }
            if (typedArray.hasValue(dd0.XShimmerDrawable_shimmer_height_ratio)) {
                setHeightRatio(typedArray.getFloat(dd0.XShimmerDrawable_shimmer_height_ratio, this.mShimmer.heightRatio));
            }
            if (typedArray.hasValue(dd0.XShimmerDrawable_shimmer_tilt)) {
                setTilt(typedArray.getFloat(dd0.XShimmerDrawable_shimmer_tilt, this.mShimmer.tilt));
            }
            if (typedArray.hasValue(dd0.XShimmerDrawable_shimmer_global_configuration_enable) && typedArray.getBoolean(dd0.XShimmerDrawable_shimmer_global_configuration_enable, false)) {
                setAutoStart(XShimmer.msGlobalEnable);
            }
            return getThis();
        }
    }
}
