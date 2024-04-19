package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
/* compiled from: ConstraintAttribute.java */
/* renamed from: r6  reason: default package */
/* loaded from: classes.dex */
public class r6 {
    public boolean a;
    public String b;
    public a c;
    public int d;
    public float e;
    public String f;
    public boolean g;
    public int h;

    /* compiled from: ConstraintAttribute.java */
    /* renamed from: r6$a */
    /* loaded from: classes.dex */
    public enum a {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE,
        REFERENCE_TYPE
    }

    public r6(String name, a attributeType, Object value, boolean method) {
        this.a = false;
        this.b = name;
        this.c = attributeType;
        this.a = method;
        a(value);
    }

    public void a(Object value) {
        switch (this.c.ordinal()) {
            case 0:
            case 7:
                this.d = ((Integer) value).intValue();
                return;
            case 1:
                this.e = ((Float) value).floatValue();
                return;
            case 2:
            case 3:
                this.h = ((Integer) value).intValue();
                return;
            case 4:
                this.f = (String) value;
                return;
            case 5:
                this.g = ((Boolean) value).booleanValue();
                return;
            case 6:
                this.e = ((Float) value).floatValue();
                return;
            default:
                return;
        }
    }

    public r6(r6 source, Object value) {
        this.a = false;
        this.b = source.b;
        this.c = source.c;
        a(value);
    }

    public static void a(View view, HashMap<String, r6> map) {
        Class<?> cls = view.getClass();
        for (String str : map.keySet()) {
            r6 r6Var = map.get(str);
            String a2 = !r6Var.a ? jg.a("set", str) : str;
            try {
                switch (r6Var.c.ordinal()) {
                    case 0:
                        cls.getMethod(a2, Integer.TYPE).invoke(view, Integer.valueOf(r6Var.d));
                        break;
                    case 1:
                        cls.getMethod(a2, Float.TYPE).invoke(view, Float.valueOf(r6Var.e));
                        break;
                    case 2:
                        cls.getMethod(a2, Integer.TYPE).invoke(view, Integer.valueOf(r6Var.h));
                        break;
                    case 3:
                        Method method = cls.getMethod(a2, Drawable.class);
                        ColorDrawable colorDrawable = new ColorDrawable();
                        colorDrawable.setColor(r6Var.h);
                        method.invoke(view, colorDrawable);
                        break;
                    case 4:
                        cls.getMethod(a2, CharSequence.class).invoke(view, r6Var.f);
                        break;
                    case 5:
                        cls.getMethod(a2, Boolean.TYPE).invoke(view, Boolean.valueOf(r6Var.g));
                        break;
                    case 6:
                        cls.getMethod(a2, Float.TYPE).invoke(view, Float.valueOf(r6Var.e));
                        break;
                    case 7:
                        cls.getMethod(a2, Integer.TYPE).invoke(view, Integer.valueOf(r6Var.d));
                        break;
                }
            } catch (IllegalAccessException e) {
                StringBuilder a3 = jg.a(" Custom Attribute \"", str, "\" not found on ");
                a3.append(cls.getName());
                Log.e("TransitionLayout", a3.toString());
                e.printStackTrace();
            } catch (NoSuchMethodException e2) {
                Log.e("TransitionLayout", e2.getMessage());
                Log.e("TransitionLayout", " Custom Attribute \"" + str + "\" not found on " + cls.getName());
                StringBuilder sb = new StringBuilder();
                sb.append(cls.getName());
                sb.append(" must have a method ");
                sb.append(a2);
                Log.e("TransitionLayout", sb.toString());
            } catch (InvocationTargetException e3) {
                StringBuilder a4 = jg.a(" Custom Attribute \"", str, "\" not found on ");
                a4.append(cls.getName());
                Log.e("TransitionLayout", a4.toString());
                e3.printStackTrace();
            }
        }
    }

    public static void a(Context context, XmlPullParser parser, HashMap<String, r6> custom) {
        a aVar;
        Object valueOf;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(parser), a7.CustomAttribute);
        int indexCount = obtainStyledAttributes.getIndexCount();
        String str = null;
        Object obj = null;
        a aVar2 = null;
        boolean z = false;
        for (int i = 0; i < indexCount; i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == a7.CustomAttribute_attributeName) {
                str = obtainStyledAttributes.getString(index);
                if (str != null && str.length() > 0) {
                    str = Character.toUpperCase(str.charAt(0)) + str.substring(1);
                }
            } else if (index == a7.CustomAttribute_methodName) {
                str = obtainStyledAttributes.getString(index);
                z = true;
            } else if (index == a7.CustomAttribute_customBoolean) {
                obj = Boolean.valueOf(obtainStyledAttributes.getBoolean(index, false));
                aVar2 = a.BOOLEAN_TYPE;
            } else {
                if (index == a7.CustomAttribute_customColorValue) {
                    aVar = a.COLOR_TYPE;
                    valueOf = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else if (index == a7.CustomAttribute_customColorDrawableValue) {
                    aVar = a.COLOR_DRAWABLE_TYPE;
                    valueOf = Integer.valueOf(obtainStyledAttributes.getColor(index, 0));
                } else if (index == a7.CustomAttribute_customPixelDimension) {
                    aVar = a.DIMENSION_TYPE;
                    valueOf = Float.valueOf(TypedValue.applyDimension(1, obtainStyledAttributes.getDimension(index, XToggleDrawable.LIGHT_RADIUS_DEFAULT), context.getResources().getDisplayMetrics()));
                } else if (index == a7.CustomAttribute_customDimension) {
                    aVar = a.DIMENSION_TYPE;
                    valueOf = Float.valueOf(obtainStyledAttributes.getDimension(index, XToggleDrawable.LIGHT_RADIUS_DEFAULT));
                } else if (index == a7.CustomAttribute_customFloatValue) {
                    aVar = a.FLOAT_TYPE;
                    valueOf = Float.valueOf(obtainStyledAttributes.getFloat(index, Float.NaN));
                } else if (index == a7.CustomAttribute_customIntegerValue) {
                    aVar = a.INT_TYPE;
                    valueOf = Integer.valueOf(obtainStyledAttributes.getInteger(index, -1));
                } else if (index == a7.CustomAttribute_customStringValue) {
                    aVar = a.STRING_TYPE;
                    valueOf = obtainStyledAttributes.getString(index);
                } else if (index == a7.CustomAttribute_customReference) {
                    aVar = a.REFERENCE_TYPE;
                    int resourceId = obtainStyledAttributes.getResourceId(index, -1);
                    if (resourceId == -1) {
                        resourceId = obtainStyledAttributes.getInt(index, -1);
                    }
                    valueOf = Integer.valueOf(resourceId);
                }
                Object obj2 = valueOf;
                aVar2 = aVar;
                obj = obj2;
            }
        }
        if (str != null && obj != null) {
            custom.put(str, new r6(str, aVar2, obj, z));
        }
        obtainStyledAttributes.recycle();
    }
}
