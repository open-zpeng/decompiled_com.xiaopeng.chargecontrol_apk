package com.xiaopeng.speech.vui.utils;

import android.content.Context;
import com.xiaopeng.libtheme.ThemeManager;
import com.xiaopeng.libtheme.ThemeParser;
/* loaded from: classes.dex */
public class ResourceUtil {
    public static int getAnimId(Context context, String str) {
        return getIdentifierByType(context, str, "anim");
    }

    public static int getArrayId(Context context, String str) {
        return getIdentifierByType(context, str, "array");
    }

    public static int getAttrId(Context context, String str) {
        return getIdentifierByType(context, str, ThemeParser._ATTR);
    }

    public static int getBoolId(Context context, String str) {
        return getIdentifierByType(context, str, "bool");
    }

    public static int getColorId(Context context, String str) {
        return getIdentifierByType(context, str, "color");
    }

    public static int getDimenId(Context context, String str) {
        return getIdentifierByType(context, str, "dimen");
    }

    public static int getDrawableId(Context context, String str) {
        return getIdentifierByType(context, str, "drawable");
    }

    public static int getId(Context context, String str) {
        return getIdentifierByType(context, str, "id");
    }

    public static int getIdentifierByType(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, context.getPackageName());
    }

    public static int getIntegerId(Context context, String str) {
        return getIdentifierByType(context, str, "integer");
    }

    public static int getLayoutId(Context context, String str) {
        return getIdentifierByType(context, str, "layout");
    }

    public static int getMipmapId(Context context, String str) {
        return getIdentifierByType(context, str, "mipmap");
    }

    public static int getStringId(Context context, String str) {
        return getIdentifierByType(context, str, "string");
    }

    public static int getStyleId(Context context, String str) {
        return getIdentifierByType(context, str, ThemeManager.AttributeSet.STYLE);
    }
}
