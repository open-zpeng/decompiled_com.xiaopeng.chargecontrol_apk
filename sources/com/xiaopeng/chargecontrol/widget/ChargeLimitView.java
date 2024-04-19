package com.xiaopeng.chargecontrol.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.xiaopeng.chargecontrol.R;
import com.xiaopeng.xui.widget.XImageView;
import defpackage.y60;
/* loaded from: classes.dex */
public class ChargeLimitView extends XImageView {
    public static final int[] f = {R.drawable.charge_limit_50, R.drawable.charge_limit_51, R.drawable.charge_limit_52, R.drawable.charge_limit_53, R.drawable.charge_limit_54, R.drawable.charge_limit_55, R.drawable.charge_limit_56, R.drawable.charge_limit_57, R.drawable.charge_limit_58, R.drawable.charge_limit_59, R.drawable.charge_limit_60, R.drawable.charge_limit_61, R.drawable.charge_limit_62, R.drawable.charge_limit_63, R.drawable.charge_limit_64, R.drawable.charge_limit_65, R.drawable.charge_limit_66, R.drawable.charge_limit_67, R.drawable.charge_limit_68, R.drawable.charge_limit_69, R.drawable.charge_limit_70, R.drawable.charge_limit_71, R.drawable.charge_limit_72, R.drawable.charge_limit_73, R.drawable.charge_limit_74, R.drawable.charge_limit_75, R.drawable.charge_limit_76, R.drawable.charge_limit_77, R.drawable.charge_limit_78, R.drawable.charge_limit_79, R.drawable.charge_limit_80, R.drawable.charge_limit_81, R.drawable.charge_limit_82, R.drawable.charge_limit_83, R.drawable.charge_limit_84, R.drawable.charge_limit_85, R.drawable.charge_limit_86, R.drawable.charge_limit_87, R.drawable.charge_limit_88, R.drawable.charge_limit_89, R.drawable.charge_limit_90, R.drawable.charge_limit_91, R.drawable.charge_limit_92, R.drawable.charge_limit_93, R.drawable.charge_limit_94, R.drawable.charge_limit_95, R.drawable.charge_limit_96, R.drawable.charge_limit_97, R.drawable.charge_limit_98, R.drawable.charge_limit_99, R.drawable.charge_limit_100};

    public ChargeLimitView(Context context) {
        this(context, null);
    }

    public void setLimit(int i) {
        int i2 = i - y60.a.a;
        setImageResource(f[(i2 < 0 || i2 > f.length) ? 0 : 0]);
    }

    public ChargeLimitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
