package defpackage;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* compiled from: XTouchDelegateGroup.java */
/* renamed from: le0  reason: default package */
/* loaded from: classes.dex */
public class le0 extends TouchDelegate {
    public static final Rect c = new Rect();
    public List<ke0> a;
    public TouchDelegate b;

    public le0(View view) {
        super(c, view);
        this.a = new ArrayList();
    }

    public void a(ke0 ke0Var) {
        if (ke0Var == null) {
            return;
        }
        Iterator<ke0> it = this.a.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ke0 next = it.next();
            if (next.a.equals(ke0Var.a)) {
                this.a.remove(next);
                break;
            }
        }
        this.a.add(ke0Var);
    }

    @Override // android.view.TouchDelegate
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        boolean z = false;
        if (actionMasked == 0) {
            if (motionEvent.getPointerCount() > 1) {
                return false;
            }
            for (int size = this.a.size() - 1; size >= 0; size--) {
                ke0 ke0Var = this.a.get(size);
                View view = ke0Var.a;
                if (view == null || view.getVisibility() == 0) {
                    float x = motionEvent.getX();
                    float y = motionEvent.getY();
                    boolean onTouchEvent = ke0Var.onTouchEvent(motionEvent);
                    motionEvent.setLocation(x, y);
                    if (onTouchEvent) {
                        this.b = ke0Var;
                        return true;
                    }
                }
            }
            return false;
        }
        TouchDelegate touchDelegate = this.b;
        if (touchDelegate != null && touchDelegate.onTouchEvent(motionEvent)) {
            z = true;
        }
        if (actionMasked == 1 || actionMasked == 32) {
            this.b = null;
        }
        return z;
    }
}
