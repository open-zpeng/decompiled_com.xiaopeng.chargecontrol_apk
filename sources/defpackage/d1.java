package defpackage;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.xiaopeng.libtheme.ThemeParser;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* compiled from: AppCompatViewInflater.java */
/* renamed from: d1  reason: default package */
/* loaded from: classes.dex */
public class d1 {
    public static final Class<?>[] b = {Context.class, AttributeSet.class};
    public static final int[] c = {16843375};
    public static final String[] d = {"android.widget.", "android.view.", "android.webkit."};
    public static final f5<String, Constructor<? extends View>> e = new f5<>();
    public final Object[] a = new Object[2];

    /* compiled from: AppCompatViewInflater.java */
    /* renamed from: d1$a */
    /* loaded from: classes.dex */
    public static class a implements View.OnClickListener {
        public final View c;
        public final String d;
        public Method e;
        public Context f;

        public a(View view, String str) {
            this.c = view;
            this.d = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String sb;
            Method method;
            if (this.e == null) {
                Context context = this.c.getContext();
                while (context != null) {
                    try {
                        if (!context.isRestricted() && (method = context.getClass().getMethod(this.d, View.class)) != null) {
                            this.e = method;
                            this.f = context;
                        }
                    } catch (NoSuchMethodException unused) {
                    }
                    context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
                }
                int id = this.c.getId();
                if (id == -1) {
                    sb = "";
                } else {
                    StringBuilder a = jg.a(" with id '");
                    a.append(this.c.getContext().getResources().getResourceEntryName(id));
                    a.append("'");
                    sb = a.toString();
                }
                StringBuilder a2 = jg.a("Could not find method ");
                a2.append(this.d);
                a2.append("(View) in a parent or ancestor Context for android:onClick attribute defined on view ");
                a2.append(this.c.getClass());
                a2.append(sb);
                throw new IllegalStateException(a2.toString());
            }
            try {
                this.e.invoke(this.f, view);
            } catch (IllegalAccessException e) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
            } catch (InvocationTargetException e2) {
                throw new IllegalStateException("Could not execute method for android:onClick", e2);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:112:0x01d7 -> B:124:0x01d8). Please submit an issue!!! */
    public final View a(View view, String str, Context context, AttributeSet attributeSet, boolean z, boolean z2, boolean z3, boolean z4) {
        char c2;
        View view2;
        n1 context2 = (!z || view == null) ? context : view.getContext();
        if (z2 || z3) {
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, i0.View, 0, 0);
            int resourceId = z2 ? obtainStyledAttributes.getResourceId(i0.View_android_theme, 0) : 0;
            if (z3 && resourceId == 0 && (resourceId = obtainStyledAttributes.getResourceId(i0.View_theme, 0)) != 0) {
                Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
            }
            obtainStyledAttributes.recycle();
            if (resourceId != 0 && (!(context2 instanceof n1) || ((n1) context2).a != resourceId)) {
                context2 = new n1(context2, resourceId);
            }
        }
        if (z4) {
            k4.a(context2);
        }
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    c2 = 11;
                    break;
                }
                c2 = 65535;
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    c2 = '\b';
                    break;
                }
                c2 = 65535;
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    c2 = '\n';
                    break;
                }
                c2 = 65535;
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -937446323:
                if (str.equals("ImageButton")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case -658531749:
                if (str.equals("SeekBar")) {
                    c2 = '\f';
                    break;
                }
                c2 = 65535;
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case 799298502:
                if (str.equals("ToggleButton")) {
                    c2 = '\r';
                    break;
                }
                c2 = 65535;
                break;
            case 1125864064:
                if (str.equals("ImageView")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    c2 = '\t';
                    break;
                }
                c2 = 65535;
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                view2 = new o3(context2, attributeSet);
                a(view2, str);
                break;
            case 1:
                view2 = new a3(context2, attributeSet);
                a(view2, str);
                break;
            case 2:
                view2 = new s2(context2, attributeSet);
                a(view2, str);
                break;
            case 3:
                view2 = new x2(context2, attributeSet);
                a(view2, str);
                break;
            case 4:
                view2 = new k3(context2, attributeSet, z.spinnerStyle);
                a(view2, str);
                break;
            case 5:
                view2 = new y2(context2, attributeSet);
                a(view2, str);
                break;
            case 6:
                view2 = new t2(context2, attributeSet);
                a(view2, str);
                break;
            case 7:
                view2 = new e3(context2, attributeSet);
                a(view2, str);
                break;
            case '\b':
                view2 = new u2(context2, attributeSet);
                a(view2, str);
                break;
            case '\t':
                view2 = new q2(context2, attributeSet);
                a(view2, str);
                break;
            case '\n':
                view2 = new b3(context2, attributeSet);
                a(view2, str);
                break;
            case 11:
                view2 = new f3(context2, attributeSet);
                a(view2, str);
                break;
            case '\f':
                view2 = new h3(context2, attributeSet);
                a(view2, str);
                break;
            case '\r':
                view2 = new q3(context2, attributeSet);
                a(view2, str);
                break;
            default:
                view2 = null;
                break;
        }
        if (view2 == null && context != context2) {
            if (str.equals(ThemeParser.NODE)) {
                str = attributeSet.getAttributeValue(null, "class");
            }
            try {
                this.a[0] = context2;
                this.a[1] = attributeSet;
            } catch (Exception unused) {
            } finally {
                Object[] objArr = this.a;
                objArr[0] = null;
                objArr[1] = null;
            }
            if (-1 == str.indexOf(46)) {
                for (int i = 0; i < d.length; i++) {
                    view2 = a(context2, str, d[i]);
                    if (view2 == null) {
                    }
                }
                view2 = null;
            } else {
                View a2 = a(context2, str, null);
                Object[] objArr2 = this.a;
                objArr2[0] = null;
                objArr2[1] = null;
                view2 = a2;
            }
        }
        if (view2 != null) {
            Context context3 = view2.getContext();
            if (context3 instanceof ContextWrapper) {
                int i2 = Build.VERSION.SDK_INT;
                if (y9.o(view2)) {
                    TypedArray obtainStyledAttributes2 = context3.obtainStyledAttributes(attributeSet, c);
                    String string = obtainStyledAttributes2.getString(0);
                    if (string != null) {
                        view2.setOnClickListener(new a(view2, string));
                    }
                    obtainStyledAttributes2.recycle();
                }
            }
        }
        return view2;
    }

    public final void a(View view, String str) {
        if (view != null) {
            return;
        }
        throw new IllegalStateException(d1.class.getName() + " asked to inflate view for <" + str + ">, but returned null");
    }

    public final View a(Context context, String str, String str2) {
        String str3;
        Constructor<? extends View> orDefault = e.getOrDefault(str, null);
        if (orDefault == null) {
            if (str2 != null) {
                try {
                    str3 = str2 + str;
                } catch (Exception unused) {
                    return null;
                }
            } else {
                str3 = str;
            }
            orDefault = Class.forName(str3, false, context.getClassLoader()).asSubclass(View.class).getConstructor(b);
            e.put(str, orDefault);
        }
        orDefault.setAccessible(true);
        return orDefault.newInstance(this.a);
    }
}
