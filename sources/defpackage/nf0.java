package defpackage;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.xiaopeng.xui.widget.XEditText;
/* compiled from: XEditText.java */
/* renamed from: nf0  reason: default package */
/* loaded from: classes.dex */
public class nf0 implements ActionMode.Callback {
    public nf0(XEditText xEditText) {
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return false;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        return false;
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode actionMode) {
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        return false;
    }
}
