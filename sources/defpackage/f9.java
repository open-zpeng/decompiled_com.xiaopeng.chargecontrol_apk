package defpackage;

import android.os.Build;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import defpackage.la;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
/* compiled from: AccessibilityDelegateCompat.java */
/* renamed from: f9  reason: default package */
/* loaded from: classes.dex */
public class f9 {
    public static final View.AccessibilityDelegate c = new View.AccessibilityDelegate();
    public final View.AccessibilityDelegate a;
    public final View.AccessibilityDelegate b;

    /* compiled from: AccessibilityDelegateCompat.java */
    /* renamed from: f9$a */
    /* loaded from: classes.dex */
    public static final class a extends View.AccessibilityDelegate {
        public final f9 a;

        public a(f9 f9Var) {
            this.a = f9Var;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.a.a(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            ma a = this.a.a(view);
            if (a != null) {
                return (AccessibilityNodeProvider) a.a;
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.a.b(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            la laVar = new la(accessibilityNodeInfo);
            boolean s = y9.s(view);
            int i = Build.VERSION.SDK_INT;
            laVar.a.setScreenReaderFocusable(s);
            Boolean b = new ca(d7.tag_accessibility_heading, Boolean.class, 28).b(view);
            boolean booleanValue = b == null ? false : b.booleanValue();
            int i2 = Build.VERSION.SDK_INT;
            laVar.a.setHeading(booleanValue);
            CharSequence c = y9.c(view);
            int i3 = Build.VERSION.SDK_INT;
            laVar.a.setPaneTitle(c);
            laVar.a(new ba(d7.tag_state_description, CharSequence.class, 64, 30).b(view));
            this.a.a(view, laVar);
            accessibilityNodeInfo.getText();
            int i4 = Build.VERSION.SDK_INT;
            List list = (List) view.getTag(d7.tag_accessibility_actions);
            if (list == null) {
                list = Collections.emptyList();
            }
            for (int i5 = 0; i5 < list.size(); i5++) {
                laVar.a((la.a) list.get(i5));
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.a.c(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.a.a(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return this.a.a(view, i, bundle);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i) {
            this.a.a(view, i);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.a.d(view, accessibilityEvent);
        }
    }

    public f9() {
        this.a = c;
        this.b = new a(this);
    }

    public void a(View view, int i) {
        this.a.sendAccessibilityEvent(view, i);
    }

    public void b(View view, AccessibilityEvent accessibilityEvent) {
        this.a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.a.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void d(View view, AccessibilityEvent accessibilityEvent) {
        this.a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void a(View view, la laVar) {
        this.a.onInitializeAccessibilityNodeInfo(view, laVar.a);
    }

    public f9(View.AccessibilityDelegate accessibilityDelegate) {
        this.a = accessibilityDelegate;
        this.b = new a(this);
    }

    public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public ma a(View view) {
        int i = Build.VERSION.SDK_INT;
        AccessibilityNodeProvider accessibilityNodeProvider = this.a.getAccessibilityNodeProvider(view);
        if (accessibilityNodeProvider != null) {
            return new ma(accessibilityNodeProvider);
        }
        return null;
    }

    public boolean a(View view, int i, Bundle bundle) {
        WeakReference weakReference;
        boolean z;
        List list = (List) view.getTag(d7.tag_accessibility_actions);
        if (list == null) {
            list = Collections.emptyList();
        }
        for (int i2 = 0; i2 < list.size() && ((la.a) list.get(i2)).a() != i; i2++) {
        }
        int i3 = Build.VERSION.SDK_INT;
        boolean performAccessibilityAction = this.a.performAccessibilityAction(view, i, bundle);
        if (performAccessibilityAction || i != d7.accessibility_action_clickable_span) {
            return performAccessibilityAction;
        }
        int i4 = bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1);
        SparseArray sparseArray = (SparseArray) view.getTag(d7.tag_accessibility_clickable_spans);
        if (sparseArray != null && (weakReference = (WeakReference) sparseArray.get(i4)) != null) {
            ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
            if (clickableSpan != null) {
                ClickableSpan[] b = la.b(view.createAccessibilityNodeInfo().getText());
                for (int i5 = 0; b != null && i5 < b.length; i5++) {
                    if (clickableSpan.equals(b[i5])) {
                        z = true;
                        break;
                    }
                }
            }
            z = false;
            if (z) {
                clickableSpan.onClick(view);
                return true;
            }
        }
        return false;
    }
}
