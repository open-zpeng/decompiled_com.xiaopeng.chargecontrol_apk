package defpackage;

import android.content.ClipData;
import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
/* compiled from: TextViewOnReceiveContentListener.java */
/* renamed from: cb  reason: default package */
/* loaded from: classes.dex */
public final class cb implements t9 {
    public h9 a(View view, h9 h9Var) {
        if (Log.isLoggable("ReceiveContent", 3)) {
            Log.d("ReceiveContent", "onReceive: " + h9Var);
        }
        int i = h9Var.b;
        if (i == 2) {
            return h9Var;
        }
        int i2 = 0;
        if (i == 3) {
            TextView textView = (TextView) view;
            ClipData clipData = h9Var.a;
            Context context = textView.getContext();
            int i3 = h9Var.c;
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            while (i2 < clipData.getItemCount()) {
                CharSequence a = a(context, clipData.getItemAt(i2), i3);
                if (a != null) {
                    spannableStringBuilder.append(a);
                }
                i2++;
            }
            a((Editable) textView.getText(), spannableStringBuilder);
            return null;
        }
        ClipData clipData2 = h9Var.a;
        int i4 = h9Var.c;
        TextView textView2 = (TextView) view;
        Editable editable = (Editable) textView2.getText();
        Context context2 = textView2.getContext();
        boolean z = false;
        while (i2 < clipData2.getItemCount()) {
            CharSequence a2 = a(context2, clipData2.getItemAt(i2), i4);
            if (a2 != null) {
                if (!z) {
                    a(editable, a2);
                    z = true;
                } else {
                    editable.insert(Selection.getSelectionEnd(editable), "\n");
                    editable.insert(Selection.getSelectionEnd(editable), a2);
                }
            }
            i2++;
        }
        return null;
    }

    public static CharSequence a(Context context, ClipData.Item item, int i) {
        int i2 = Build.VERSION.SDK_INT;
        if ((i & 1) != 0) {
            CharSequence coerceToText = item.coerceToText(context);
            return coerceToText instanceof Spanned ? coerceToText.toString() : coerceToText;
        }
        return item.coerceToStyledText(context);
    }

    public static void a(Editable editable, CharSequence charSequence) {
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        int max = Math.max(0, Math.min(selectionStart, selectionEnd));
        int max2 = Math.max(0, Math.max(selectionStart, selectionEnd));
        Selection.setSelection(editable, max2);
        editable.replace(max, max2, charSequence);
    }
}
