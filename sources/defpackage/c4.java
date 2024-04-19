package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.lang.reflect.Method;
/* compiled from: MenuPopupWindow.java */
/* renamed from: c4  reason: default package */
/* loaded from: classes.dex */
public class c4 extends a4 implements b4 {
    public static Method K;
    public b4 J;

    /* compiled from: MenuPopupWindow.java */
    /* renamed from: c4$a */
    /* loaded from: classes.dex */
    public static class a extends u3 {
        public final int q;
        public final int r;
        public b4 s;
        public MenuItem t;

        public a(Context context, boolean z) {
            super(context, z);
            Configuration configuration = context.getResources().getConfiguration();
            int i = Build.VERSION.SDK_INT;
            if (1 == configuration.getLayoutDirection()) {
                this.q = 21;
                this.r = 22;
                return;
            }
            this.q = 22;
            this.r = 21;
        }

        @Override // defpackage.u3, android.view.View
        public boolean onHoverEvent(MotionEvent motionEvent) {
            int i;
            y1 y1Var;
            int pointToPosition;
            int i2;
            if (this.s != null) {
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i = headerViewListAdapter.getHeadersCount();
                    y1Var = (y1) headerViewListAdapter.getWrappedAdapter();
                } else {
                    i = 0;
                    y1Var = (y1) adapter;
                }
                c2 c2Var = null;
                if (motionEvent.getAction() != 10 && (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) != -1 && (i2 = pointToPosition - i) >= 0 && i2 < y1Var.getCount()) {
                    c2Var = y1Var.getItem(i2);
                }
                MenuItem menuItem = this.t;
                if (menuItem != c2Var) {
                    z1 z1Var = y1Var.c;
                    if (menuItem != null) {
                        this.s.b(z1Var, menuItem);
                    }
                    this.t = c2Var;
                    if (c2Var != null) {
                        this.s.a(z1Var, c2Var);
                    }
                }
            }
            return super.onHoverEvent(motionEvent);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int i, KeyEvent keyEvent) {
            y1 y1Var;
            ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
            if (listMenuItemView != null && i == this.q) {
                if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                    performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
                }
                return true;
            } else if (listMenuItemView != null && i == this.r) {
                setSelection(-1);
                ListAdapter adapter = getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    y1Var = (y1) ((HeaderViewListAdapter) adapter).getWrappedAdapter();
                } else {
                    y1Var = (y1) adapter;
                }
                y1Var.c.a(false);
                return true;
            } else {
                return super.onKeyDown(i, keyEvent);
            }
        }

        public void setHoverListener(b4 b4Var) {
            this.s = b4Var;
        }

        @Override // defpackage.u3, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
            super.setSelector(drawable);
        }
    }

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                K = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    public c4(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    @Override // defpackage.a4
    public u3 a(Context context, boolean z) {
        a aVar = new a(context, z);
        aVar.setHoverListener(this);
        return aVar;
    }

    @Override // defpackage.b4
    public void b(z1 z1Var, MenuItem menuItem) {
        b4 b4Var = this.J;
        if (b4Var != null) {
            b4Var.b(z1Var, menuItem);
        }
    }

    public void a(Object obj) {
        int i = Build.VERSION.SDK_INT;
        this.G.setExitTransition((Transition) obj);
    }

    @Override // defpackage.b4
    public void a(z1 z1Var, MenuItem menuItem) {
        b4 b4Var = this.J;
        if (b4Var != null) {
            b4Var.a(z1Var, menuItem);
        }
    }
}
