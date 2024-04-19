package defpackage;

import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
/* compiled from: EditorInfoCompat.java */
/* renamed from: va  reason: default package */
/* loaded from: classes.dex */
public final class va {
    public static final String[] a = new String[0];

    public static void a(EditorInfo editorInfo, String[] strArr) {
        int i = Build.VERSION.SDK_INT;
        editorInfo.contentMimeTypes = strArr;
    }

    public static void a(EditorInfo editorInfo, CharSequence charSequence) {
        CharSequence subSequence;
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            a.a(editorInfo, charSequence, 0);
        } else if (charSequence == null) {
            throw new NullPointerException();
        } else {
            if (i >= 30) {
                a.a(editorInfo, charSequence, 0);
                return;
            }
            int i2 = editorInfo.initialSelStart;
            int i3 = editorInfo.initialSelEnd;
            int i4 = i2 > i3 ? i3 - 0 : i2 + 0;
            int i5 = editorInfo.initialSelStart;
            int i6 = editorInfo.initialSelEnd;
            int i7 = i5 > i6 ? i5 - 0 : i6 + 0;
            int length = charSequence.length();
            if (i4 >= 0 && i7 <= length) {
                int i8 = editorInfo.inputType & 4095;
                if (i8 == 129 || i8 == 225 || i8 == 18) {
                    a(editorInfo, null, 0, 0);
                    return;
                } else if (length <= 2048) {
                    a(editorInfo, charSequence, i4, i7);
                    return;
                } else {
                    int i9 = i7 - i4;
                    int i10 = i9 > 1024 ? 0 : i9;
                    int i11 = 2048 - i10;
                    int min = Math.min(charSequence.length() - i7, i11 - Math.min(i4, (int) (i11 * 0.8d)));
                    int min2 = Math.min(i4, i11 - min);
                    int i12 = i4 - min2;
                    if (a(charSequence, i12, 0)) {
                        i12++;
                        min2--;
                    }
                    if (a(charSequence, (i7 + min) - 1, 1)) {
                        min--;
                    }
                    int i13 = min2 + i10 + min;
                    if (i10 != i9) {
                        subSequence = TextUtils.concat(charSequence.subSequence(i12, i12 + min2), charSequence.subSequence(i7, min + i7));
                    } else {
                        subSequence = charSequence.subSequence(i12, i13 + i12);
                    }
                    int i14 = min2 + 0;
                    a(editorInfo, subSequence, i14, i10 + i14);
                    return;
                }
            }
            a(editorInfo, null, 0, 0);
        }
    }

    public static boolean a(CharSequence charSequence, int i, int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                return false;
            }
            return Character.isHighSurrogate(charSequence.charAt(i));
        }
        return Character.isLowSurrogate(charSequence.charAt(i));
    }

    public static void a(EditorInfo editorInfo, CharSequence charSequence, int i, int i2) {
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT", charSequence != null ? new SpannableStringBuilder(charSequence) : null);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD", i);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END", i2);
    }
}
