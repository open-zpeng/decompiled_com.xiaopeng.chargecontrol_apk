package defpackage;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
/* compiled from: XTouchDelegate.java */
/* renamed from: ke0  reason: default package */
/* loaded from: classes.dex */
public class ke0 extends TouchDelegate {
    public View a;

    public ke0(Rect rect, View view) {
        super(rect, view);
        this.a = view;
    }
}
