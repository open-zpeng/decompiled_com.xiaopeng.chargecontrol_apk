package defpackage;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import defpackage.h9;
/* compiled from: AppCompatEditText.java */
/* renamed from: x2  reason: default package */
/* loaded from: classes.dex */
public class x2 extends EditText implements x9, u9 {
    public final r2 c;
    public final m3 d;
    public final l3 e;
    public final cb f;

    public x2(Context context) {
        this(context, null);
    }

    @Override // defpackage.u9
    public h9 a(h9 h9Var) {
        return this.f.a(this, h9Var);
    }

    @Override // android.widget.TextView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        r2 r2Var = this.c;
        if (r2Var != null) {
            r2Var.a();
        }
        m3 m3Var = this.d;
        if (m3Var != null) {
            m3Var.a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        r2 r2Var = this.c;
        if (r2Var != null) {
            return r2Var.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        r2 r2Var = this.c;
        if (r2Var != null) {
            return r2Var.c();
        }
        return null;
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        int i = Build.VERSION.SDK_INT;
        return super.getTextClassifier();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.d.a(this, onCreateInputConnection, editorInfo);
        a.a(onCreateInputConnection, editorInfo, this);
        String[] k = y9.k(this);
        if (onCreateInputConnection == null || k == null) {
            return onCreateInputConnection;
        }
        va.a(editorInfo, k);
        g3 g3Var = new g3(this);
        int i = Build.VERSION.SDK_INT;
        return new wa(onCreateInputConnection, false, g3Var);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onDragEvent(DragEvent dragEvent) {
        Activity activity;
        int i = Build.VERSION.SDK_INT;
        boolean z = false;
        if (dragEvent.getLocalState() == null && y9.k(this) != null) {
            Context context = getContext();
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    activity = null;
                    break;
                } else if (context instanceof Activity) {
                    activity = (Activity) context;
                    break;
                } else {
                    context = ((ContextWrapper) context).getBaseContext();
                }
            }
            if (activity == null) {
                Log.i("ReceiveContent", "Can't handle drop: no activity: view=" + this);
            } else if (dragEvent.getAction() != 1 && dragEvent.getAction() == 3) {
                activity.requestDragAndDropPermissions(dragEvent);
                int offsetForPosition = getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
                beginBatchEdit();
                try {
                    Selection.setSelection((Spannable) getText(), offsetForPosition);
                    y9.a(this, new h9(new h9.a(dragEvent.getClipData(), 3)));
                    endBatchEdit();
                    z = true;
                } catch (Throwable th) {
                    endBatchEdit();
                    throw th;
                }
            }
        }
        if (z) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    @Override // android.widget.TextView
    public boolean onTextContextMenuItem(int i) {
        if ((i == 16908322 || i == 16908337) && y9.k(this) != null) {
            ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
            ClipData primaryClip = clipboardManager == null ? null : clipboardManager.getPrimaryClip();
            if (primaryClip != null && primaryClip.getItemCount() > 0) {
                h9.a aVar = new h9.a(primaryClip, 1);
                aVar.c = i != 16908322 ? 1 : 0;
                y9.a(this, new h9(aVar));
            }
            r0 = 1;
        }
        if (r0 != 0) {
            return true;
        }
        return super.onTextContextMenuItem(i);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        r2 r2Var = this.c;
        if (r2Var != null) {
            r2Var.d();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        r2 r2Var = this.c;
        if (r2Var != null) {
            r2Var.a(i);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        int i = Build.VERSION.SDK_INT;
        super.setCustomSelectionActionModeCallback(callback);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        r2 r2Var = this.c;
        if (r2Var != null) {
            r2Var.b(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        r2 r2Var = this.c;
        if (r2Var != null) {
            r2Var.a(mode);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        m3 m3Var = this.d;
        if (m3Var != null) {
            m3Var.a(context, i);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        int i = Build.VERSION.SDK_INT;
        super.setTextClassifier(textClassifier);
    }

    public x2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, z.editTextStyle);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        int i = Build.VERSION.SDK_INT;
        return super.getText();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        k4.a(context);
        i4.a(this, getContext());
        this.c = new r2(this);
        this.c.a(attributeSet, i);
        this.d = new m3(this);
        this.d.a(attributeSet, i);
        this.d.a();
        this.e = new l3(this);
        this.f = new cb();
    }
}
