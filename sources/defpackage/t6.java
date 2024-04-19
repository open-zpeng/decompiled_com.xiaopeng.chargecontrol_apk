package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: ConstraintLayoutStates.java */
/* renamed from: t6  reason: default package */
/* loaded from: classes.dex */
public class t6 {
    public final ConstraintLayout a;
    public int b = -1;
    public int c = -1;
    public SparseArray<a> d = new SparseArray<>();
    public SparseArray<u6> e = new SparseArray<>();

    /* compiled from: ConstraintLayoutStates.java */
    /* renamed from: t6$a */
    /* loaded from: classes.dex */
    public static class a {
        public int a;
        public ArrayList<b> b = new ArrayList<>();
        public int c;
        public u6 d;

        public a(Context context, XmlPullParser parser) {
            this.c = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(parser), a7.State);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == a7.State_android_id) {
                    this.a = obtainStyledAttributes.getResourceId(index, this.a);
                } else if (index == a7.State_constraints) {
                    this.c = obtainStyledAttributes.getResourceId(index, this.c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.c);
                    context.getResources().getResourceName(this.c);
                    if ("layout".equals(resourceTypeName)) {
                        this.d = new u6();
                        this.d.a(context, this.c);
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* compiled from: ConstraintLayoutStates.java */
    /* renamed from: t6$b */
    /* loaded from: classes.dex */
    public static class b {
        public float a;
        public float b;
        public float c;
        public float d;
        public int e;
        public u6 f;

        public b(Context context, XmlPullParser parser) {
            this.a = Float.NaN;
            this.b = Float.NaN;
            this.c = Float.NaN;
            this.d = Float.NaN;
            this.e = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(parser), a7.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == a7.Variant_constraints) {
                    this.e = obtainStyledAttributes.getResourceId(index, this.e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.e);
                    context.getResources().getResourceName(this.e);
                    if ("layout".equals(resourceTypeName)) {
                        this.f = new u6();
                        this.f.a(context, this.e);
                    }
                } else if (index == a7.Variant_region_heightLessThan) {
                    this.d = obtainStyledAttributes.getDimension(index, this.d);
                } else if (index == a7.Variant_region_heightMoreThan) {
                    this.b = obtainStyledAttributes.getDimension(index, this.b);
                } else if (index == a7.Variant_region_widthLessThan) {
                    this.c = obtainStyledAttributes.getDimension(index, this.c);
                } else if (index == a7.Variant_region_widthMoreThan) {
                    this.a = obtainStyledAttributes.getDimension(index, this.a);
                } else {
                    Log.v("ConstraintLayoutStates", "Unknown tag");
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public t6(Context context, ConstraintLayout layout, int resourceID) {
        boolean z;
        this.a = layout;
        XmlResourceParser xml = context.getResources().getXml(resourceID);
        a aVar = null;
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                    continue;
                } else if (eventType != 2) {
                    continue;
                } else {
                    String name = xml.getName();
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals("ConstraintSet")) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 80204913:
                            if (name.equals("State")) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 1657696882:
                            if (name.equals("layoutDescription")) {
                                z = false;
                                break;
                            }
                            z = true;
                            break;
                        case 1901439077:
                            if (name.equals("Variant")) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        default:
                            z = true;
                            break;
                    }
                    if (z && !z) {
                        if (z) {
                            aVar = new a(context, xml);
                            this.d.put(aVar.a, aVar);
                            continue;
                        } else if (z) {
                            b bVar = new b(context, xml);
                            if (aVar != null) {
                                aVar.b.add(bVar);
                                continue;
                            } else {
                                continue;
                            }
                        } else if (!z) {
                            continue;
                        } else {
                            a(context, xml);
                            continue;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:143:0x022a, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(android.content.Context r12, org.xmlpull.v1.XmlPullParser r13) {
        /*
            Method dump skipped, instructions count: 664
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.t6.a(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public void a(w6 constraintsChangedListener) {
    }
}
