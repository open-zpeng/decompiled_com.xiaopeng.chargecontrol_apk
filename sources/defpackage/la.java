package defpackage;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.accessibility.AccessibilityNodeInfo;
import com.bumptech.glide.integration.webp.WebpBitmapFactory;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IInputController;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IRadioController;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* compiled from: AccessibilityNodeInfoCompat.java */
/* renamed from: la  reason: default package */
/* loaded from: classes.dex */
public class la {
    public final AccessibilityNodeInfo a;
    public int b = -1;
    public int c = -1;

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* renamed from: la$a */
    /* loaded from: classes.dex */
    public static class a {
        public static final a c;
        public static final a d;
        public static final a e;
        public static final a f;
        public final Object a;
        public final Class<? extends na> b;

        static {
            new a(null, 1, null, null);
            new a(null, 2, null, null);
            new a(null, 4, null, null);
            new a(null, 8, null, null);
            new a(null, 16, null, null);
            new a(null, 32, null, null);
            new a(null, 64, null, null);
            new a(null, 128, null, null);
            new a(null, IRadioController.TEF663x_PCHANNEL, null, oa.class);
            new a(null, IInputController.KEYCODE_BACK_BUTTON, null, oa.class);
            new a(null, 1024, null, pa.class);
            new a(null, 2048, null, pa.class);
            c = new a(null, 4096, null, null);
            d = new a(null, WebpBitmapFactory.IN_TEMP_BUFFER_SIZE, null, null);
            new a(null, 16384, null, null);
            new a(null, 32768, null, null);
            new a(null, 65536, null, null);
            new a(null, 131072, null, ta.class);
            new a(null, 262144, null, null);
            new a(null, 524288, null, null);
            new a(null, 1048576, null, null);
            new a(null, 2097152, null, ua.class);
            int i = Build.VERSION.SDK_INT;
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, 16908342, null, null);
            int i2 = Build.VERSION.SDK_INT;
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, 16908343, null, ra.class);
            int i3 = Build.VERSION.SDK_INT;
            e = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, 16908344, null, null);
            int i4 = Build.VERSION.SDK_INT;
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, 16908345, null, null);
            int i5 = Build.VERSION.SDK_INT;
            f = new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, 16908346, null, null);
            int i6 = Build.VERSION.SDK_INT;
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, 16908347, null, null);
            new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP : null, 16908358, null, null);
            new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN : null, 16908359, null, null);
            new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT : null, 16908360, null, null);
            new a(Build.VERSION.SDK_INT >= 29 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT : null, 16908361, null, null);
            int i7 = Build.VERSION.SDK_INT;
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, 16908348, null, null);
            int i8 = Build.VERSION.SDK_INT;
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS, 16908349, null, sa.class);
            int i9 = Build.VERSION.SDK_INT;
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW, 16908354, null, qa.class);
            int i10 = Build.VERSION.SDK_INT;
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP, 16908356, null, null);
            int i11 = Build.VERSION.SDK_INT;
            new a(AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP, 16908357, null, null);
            new a(Build.VERSION.SDK_INT >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD : null, 16908362, null, null);
            new a(Build.VERSION.SDK_INT >= 30 ? AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER : null, 16908372, null, null);
        }

        public a(Object obj, int i, CharSequence charSequence, Class cls) {
            int i2 = Build.VERSION.SDK_INT;
            if (obj == null) {
                this.a = new AccessibilityNodeInfo.AccessibilityAction(i, charSequence);
            } else {
                this.a = obj;
            }
            this.b = cls;
        }

        public int a() {
            int i = Build.VERSION.SDK_INT;
            return ((AccessibilityNodeInfo.AccessibilityAction) this.a).getId();
        }

        public boolean equals(Object obj) {
            if (obj != null && (obj instanceof a)) {
                a aVar = (a) obj;
                Object obj2 = this.a;
                return obj2 == null ? aVar.a == null : obj2.equals(aVar.a);
            }
            return false;
        }

        public int hashCode() {
            Object obj = this.a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* renamed from: la$b */
    /* loaded from: classes.dex */
    public static class b {
        public final Object a;

        public b(Object obj) {
            this.a = obj;
        }
    }

    /* compiled from: AccessibilityNodeInfoCompat.java */
    /* renamed from: la$c */
    /* loaded from: classes.dex */
    public static class c {
        public final Object a;

        public c(Object obj) {
            this.a = obj;
        }
    }

    public la(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.a = accessibilityNodeInfo;
    }

    public static String a(int i) {
        if (i != 1) {
            if (i != 2) {
                switch (i) {
                    case 4:
                        return "ACTION_SELECT";
                    case 8:
                        return "ACTION_CLEAR_SELECTION";
                    case 16:
                        return "ACTION_CLICK";
                    case 32:
                        return "ACTION_LONG_CLICK";
                    case 64:
                        return "ACTION_ACCESSIBILITY_FOCUS";
                    case 128:
                        return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
                    case IRadioController.TEF663x_PCHANNEL /* 256 */:
                        return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
                    case IInputController.KEYCODE_BACK_BUTTON /* 512 */:
                        return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
                    case 1024:
                        return "ACTION_NEXT_HTML_ELEMENT";
                    case 2048:
                        return "ACTION_PREVIOUS_HTML_ELEMENT";
                    case 4096:
                        return "ACTION_SCROLL_FORWARD";
                    case WebpBitmapFactory.IN_TEMP_BUFFER_SIZE /* 8192 */:
                        return "ACTION_SCROLL_BACKWARD";
                    case 16384:
                        return "ACTION_COPY";
                    case 32768:
                        return "ACTION_PASTE";
                    case 65536:
                        return "ACTION_CUT";
                    case 131072:
                        return "ACTION_SET_SELECTION";
                    case 262144:
                        return "ACTION_EXPAND";
                    case 524288:
                        return "ACTION_COLLAPSE";
                    case 2097152:
                        return "ACTION_SET_TEXT";
                    case 16908354:
                        return "ACTION_MOVE_WINDOW";
                    case 16908372:
                        return "ACTION_IME_ENTER";
                    default:
                        switch (i) {
                            case 16908342:
                                return "ACTION_SHOW_ON_SCREEN";
                            case 16908343:
                                return "ACTION_SCROLL_TO_POSITION";
                            case 16908344:
                                return "ACTION_SCROLL_UP";
                            case 16908345:
                                return "ACTION_SCROLL_LEFT";
                            case 16908346:
                                return "ACTION_SCROLL_DOWN";
                            case 16908347:
                                return "ACTION_SCROLL_RIGHT";
                            case 16908348:
                                return "ACTION_CONTEXT_CLICK";
                            case 16908349:
                                return "ACTION_SET_PROGRESS";
                            default:
                                switch (i) {
                                    case 16908356:
                                        return "ACTION_SHOW_TOOLTIP";
                                    case 16908357:
                                        return "ACTION_HIDE_TOOLTIP";
                                    case 16908358:
                                        return "ACTION_PAGE_UP";
                                    case 16908359:
                                        return "ACTION_PAGE_DOWN";
                                    case 16908360:
                                        return "ACTION_PAGE_LEFT";
                                    case 16908361:
                                        return "ACTION_PAGE_RIGHT";
                                    case 16908362:
                                        return "ACTION_PRESS_AND_HOLD";
                                    default:
                                        return "ACTION_UNKNOWN";
                                }
                        }
                }
            }
            return "ACTION_CLEAR_FOCUS";
        }
        return "ACTION_FOCUS";
    }

    public static ClickableSpan[] b(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    public void a(CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.a.setStateDescription(charSequence);
            return;
        }
        int i = Build.VERSION.SDK_INT;
        this.a.getExtras().putCharSequence("androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY", charSequence);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof la)) {
            la laVar = (la) obj;
            AccessibilityNodeInfo accessibilityNodeInfo = this.a;
            if (accessibilityNodeInfo == null) {
                if (laVar.a != null) {
                    return false;
                }
            } else if (!accessibilityNodeInfo.equals(laVar.a)) {
                return false;
            }
            return this.c == laVar.c && this.b == laVar.b;
        }
        return false;
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.a;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.CharSequence] */
    /* JADX WARN: Type inference failed for: r6v3, types: [android.text.SpannableString, android.text.Spannable] */
    public String toString() {
        ?? text;
        List emptyList;
        ?? sb = new StringBuilder();
        sb.append(super.toString());
        Rect rect = new Rect();
        this.a.getBoundsInParent(rect);
        sb.append("; boundsInParent: " + rect);
        this.a.getBoundsInScreen(rect);
        sb.append("; boundsInScreen: " + rect);
        sb.append("; packageName: ");
        sb.append(this.a.getPackageName());
        sb.append("; className: ");
        sb.append(this.a.getClassName());
        sb.append("; text: ");
        if (!a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY").isEmpty()) {
            List<Integer> a2 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY");
            List<Integer> a3 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY");
            List<Integer> a4 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY");
            List<Integer> a5 = a("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY");
            text = new SpannableString(TextUtils.substring(this.a.getText(), 0, this.a.getText().length()));
            for (int i = 0; i < a2.size(); i++) {
                text.setSpan(new ka(a5.get(i).intValue(), this, a().getInt("androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY")), a2.get(i).intValue(), a3.get(i).intValue(), a4.get(i).intValue());
            }
        } else {
            text = this.a.getText();
        }
        sb.append(text);
        sb.append("; contentDescription: ");
        sb.append(this.a.getContentDescription());
        sb.append("; viewId: ");
        int i2 = Build.VERSION.SDK_INT;
        sb.append(this.a.getViewIdResourceName());
        sb.append("; checkable: ");
        sb.append(this.a.isCheckable());
        sb.append("; checked: ");
        sb.append(this.a.isChecked());
        sb.append("; focusable: ");
        sb.append(this.a.isFocusable());
        sb.append("; focused: ");
        sb.append(this.a.isFocused());
        sb.append("; selected: ");
        sb.append(this.a.isSelected());
        sb.append("; clickable: ");
        sb.append(this.a.isClickable());
        sb.append("; longClickable: ");
        sb.append(this.a.isLongClickable());
        sb.append("; enabled: ");
        sb.append(this.a.isEnabled());
        sb.append("; password: ");
        sb.append(this.a.isPassword());
        sb.append("; scrollable: " + this.a.isScrollable());
        sb.append("; [");
        int i3 = Build.VERSION.SDK_INT;
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = this.a.getActionList();
        if (actionList != null) {
            emptyList = new ArrayList();
            int size = actionList.size();
            for (int i4 = 0; i4 < size; i4++) {
                emptyList.add(new a(actionList.get(i4), 0, null, null));
            }
        } else {
            emptyList = Collections.emptyList();
        }
        for (int i5 = 0; i5 < emptyList.size(); i5++) {
            a aVar = (a) emptyList.get(i5);
            String a6 = a(aVar.a());
            if (a6.equals("ACTION_UNKNOWN")) {
                int i6 = Build.VERSION.SDK_INT;
                if (((AccessibilityNodeInfo.AccessibilityAction) aVar.a).getLabel() != null) {
                    int i7 = Build.VERSION.SDK_INT;
                    a6 = ((AccessibilityNodeInfo.AccessibilityAction) aVar.a).getLabel().toString();
                }
            }
            sb.append(a6);
            if (i5 != emptyList.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public void b(Object obj) {
        int i = Build.VERSION.SDK_INT;
        this.a.setCollectionItemInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionItemInfo) ((c) obj).a);
    }

    public final List<Integer> a(String str) {
        int i = Build.VERSION.SDK_INT;
        ArrayList<Integer> integerArrayList = this.a.getExtras().getIntegerArrayList(str);
        if (integerArrayList == null) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            this.a.getExtras().putIntegerArrayList(str, arrayList);
            return arrayList;
        }
        return integerArrayList;
    }

    public void a(a aVar) {
        int i = Build.VERSION.SDK_INT;
        this.a.addAction((AccessibilityNodeInfo.AccessibilityAction) aVar.a);
    }

    public boolean a(int i, Bundle bundle) {
        int i2 = Build.VERSION.SDK_INT;
        return this.a.performAction(i, bundle);
    }

    public void a(Object obj) {
        int i = Build.VERSION.SDK_INT;
        this.a.setCollectionInfo(obj == null ? null : (AccessibilityNodeInfo.CollectionInfo) ((b) obj).a);
    }

    public Bundle a() {
        int i = Build.VERSION.SDK_INT;
        return this.a.getExtras();
    }
}
