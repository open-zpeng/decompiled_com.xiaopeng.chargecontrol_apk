package defpackage;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
/* compiled from: AppCompatCheckedTextView.java */
/* renamed from: u2  reason: default package */
/* loaded from: classes.dex */
public class u2 extends CheckedTextView {
    public static final int[] d = {16843016};
    public final m3 c;

    public u2(Context context) {
        this(context, null);
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        m3 m3Var = this.c;
        if (m3Var != null) {
            m3Var.a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        a.a(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(i1.b(getContext(), i));
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        int i = Build.VERSION.SDK_INT;
        super.setCustomSelectionActionModeCallback(callback);
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        m3 m3Var = this.c;
        if (m3Var != null) {
            m3Var.a(context, i);
        }
    }

    public u2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        k4.a(context);
        i4.a(this, getContext());
        this.c = new m3(this);
        this.c.a(attributeSet, i);
        this.c.a();
        n4 a = n4.a(getContext(), attributeSet, d, i, 0);
        setCheckMarkDrawable(a.b(0));
        a.b.recycle();
    }
}
