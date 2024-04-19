package com.xiaopeng.speech.vui.event;

import android.content.Context;
/* loaded from: classes.dex */
public class EndSmoothScroller extends Cif {
    public EndSmoothScroller(Context context) {
        super(context);
    }

    @Override // defpackage.Cif
    public int getHorizontalSnapPreference() {
        return 1;
    }

    @Override // defpackage.Cif
    public int getVerticalSnapPreference() {
        return 1;
    }
}
