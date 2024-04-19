package defpackage;

import android.view.ActionMode;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
/* compiled from: WindowCallbackWrapper.java */
/* renamed from: s1  reason: default package */
/* loaded from: classes.dex */
public class s1 implements Window.Callback {
    public final Window.Callback c;

    public s1(Window.Callback callback) {
        if (callback != null) {
            this.c = callback;
            return;
        }
        throw new IllegalArgumentException("Window callback may not be null");
    }

    @Override // android.view.Window.Callback
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.c.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.c.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.c.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.c.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public void onActionModeFinished(ActionMode actionMode) {
        this.c.onActionModeFinished(actionMode);
    }

    @Override // android.view.Window.Callback
    public void onActionModeStarted(ActionMode actionMode) {
        this.c.onActionModeStarted(actionMode);
    }

    @Override // android.view.Window.Callback
    public void onAttachedToWindow() {
        this.c.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public View onCreatePanelView(int i) {
        return this.c.onCreatePanelView(i);
    }

    @Override // android.view.Window.Callback
    public void onDetachedFromWindow() {
        this.c.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return this.c.onMenuItemSelected(i, menuItem);
    }

    @Override // android.view.Window.Callback
    public void onPointerCaptureChanged(boolean z) {
        this.c.onPointerCaptureChanged(z);
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested(SearchEvent searchEvent) {
        return this.c.onSearchRequested(searchEvent);
    }

    @Override // android.view.Window.Callback
    public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.c.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        this.c.onWindowFocusChanged(z);
    }

    @Override // android.view.Window.Callback
    public boolean onSearchRequested() {
        return this.c.onSearchRequested();
    }
}
