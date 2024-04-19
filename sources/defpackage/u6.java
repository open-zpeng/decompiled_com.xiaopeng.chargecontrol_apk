package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.xiaopeng.libconfig.ipc.cfc.CFCHelper;
import com.xiaopeng.xui.drawable.XLoadingDrawable;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import defpackage.v6;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: ConstraintSet.java */
/* renamed from: u6  reason: default package */
/* loaded from: classes.dex */
public class u6 {
    public static final int[] d = {0, 4, 8};
    public static SparseIntArray e = new SparseIntArray();
    public static SparseIntArray f = new SparseIntArray();
    public HashMap<String, r6> a = new HashMap<>();
    public boolean b = true;
    public HashMap<Integer, a> c = new HashMap<>();

    static {
        e.append(a7.Constraint_layout_constraintLeft_toLeftOf, 25);
        e.append(a7.Constraint_layout_constraintLeft_toRightOf, 26);
        e.append(a7.Constraint_layout_constraintRight_toLeftOf, 29);
        e.append(a7.Constraint_layout_constraintRight_toRightOf, 30);
        e.append(a7.Constraint_layout_constraintTop_toTopOf, 36);
        e.append(a7.Constraint_layout_constraintTop_toBottomOf, 35);
        e.append(a7.Constraint_layout_constraintBottom_toTopOf, 4);
        e.append(a7.Constraint_layout_constraintBottom_toBottomOf, 3);
        e.append(a7.Constraint_layout_constraintBaseline_toBaselineOf, 1);
        e.append(a7.Constraint_layout_constraintBaseline_toTopOf, 91);
        e.append(a7.Constraint_layout_constraintBaseline_toBottomOf, 92);
        e.append(a7.Constraint_layout_editor_absoluteX, 6);
        e.append(a7.Constraint_layout_editor_absoluteY, 7);
        e.append(a7.Constraint_layout_constraintGuide_begin, 17);
        e.append(a7.Constraint_layout_constraintGuide_end, 18);
        e.append(a7.Constraint_layout_constraintGuide_percent, 19);
        e.append(a7.Constraint_android_orientation, 27);
        e.append(a7.Constraint_layout_constraintStart_toEndOf, 32);
        e.append(a7.Constraint_layout_constraintStart_toStartOf, 33);
        e.append(a7.Constraint_layout_constraintEnd_toStartOf, 10);
        e.append(a7.Constraint_layout_constraintEnd_toEndOf, 9);
        e.append(a7.Constraint_layout_goneMarginLeft, 13);
        e.append(a7.Constraint_layout_goneMarginTop, 16);
        e.append(a7.Constraint_layout_goneMarginRight, 14);
        e.append(a7.Constraint_layout_goneMarginBottom, 11);
        e.append(a7.Constraint_layout_goneMarginStart, 15);
        e.append(a7.Constraint_layout_goneMarginEnd, 12);
        e.append(a7.Constraint_layout_constraintVertical_weight, 40);
        e.append(a7.Constraint_layout_constraintHorizontal_weight, 39);
        e.append(a7.Constraint_layout_constraintHorizontal_chainStyle, 41);
        e.append(a7.Constraint_layout_constraintVertical_chainStyle, 42);
        e.append(a7.Constraint_layout_constraintHorizontal_bias, 20);
        e.append(a7.Constraint_layout_constraintVertical_bias, 37);
        e.append(a7.Constraint_layout_constraintDimensionRatio, 5);
        e.append(a7.Constraint_layout_constraintLeft_creator, 87);
        e.append(a7.Constraint_layout_constraintTop_creator, 87);
        e.append(a7.Constraint_layout_constraintRight_creator, 87);
        e.append(a7.Constraint_layout_constraintBottom_creator, 87);
        e.append(a7.Constraint_layout_constraintBaseline_creator, 87);
        e.append(a7.Constraint_android_layout_marginLeft, 24);
        e.append(a7.Constraint_android_layout_marginRight, 28);
        e.append(a7.Constraint_android_layout_marginStart, 31);
        e.append(a7.Constraint_android_layout_marginEnd, 8);
        e.append(a7.Constraint_android_layout_marginTop, 34);
        e.append(a7.Constraint_android_layout_marginBottom, 2);
        e.append(a7.Constraint_android_layout_width, 23);
        e.append(a7.Constraint_android_layout_height, 21);
        e.append(a7.Constraint_layout_constraintWidth, 95);
        e.append(a7.Constraint_layout_constraintHeight, 96);
        e.append(a7.Constraint_android_visibility, 22);
        e.append(a7.Constraint_android_alpha, 43);
        e.append(a7.Constraint_android_elevation, 44);
        e.append(a7.Constraint_android_rotationX, 45);
        e.append(a7.Constraint_android_rotationY, 46);
        e.append(a7.Constraint_android_rotation, 60);
        e.append(a7.Constraint_android_scaleX, 47);
        e.append(a7.Constraint_android_scaleY, 48);
        e.append(a7.Constraint_android_transformPivotX, 49);
        e.append(a7.Constraint_android_transformPivotY, 50);
        e.append(a7.Constraint_android_translationX, 51);
        e.append(a7.Constraint_android_translationY, 52);
        e.append(a7.Constraint_android_translationZ, 53);
        e.append(a7.Constraint_layout_constraintWidth_default, 54);
        e.append(a7.Constraint_layout_constraintHeight_default, 55);
        e.append(a7.Constraint_layout_constraintWidth_max, 56);
        e.append(a7.Constraint_layout_constraintHeight_max, 57);
        e.append(a7.Constraint_layout_constraintWidth_min, 58);
        e.append(a7.Constraint_layout_constraintHeight_min, 59);
        e.append(a7.Constraint_layout_constraintCircle, 61);
        e.append(a7.Constraint_layout_constraintCircleRadius, 62);
        e.append(a7.Constraint_layout_constraintCircleAngle, 63);
        e.append(a7.Constraint_animateRelativeTo, 64);
        e.append(a7.Constraint_transitionEasing, 65);
        e.append(a7.Constraint_drawPath, 66);
        e.append(a7.Constraint_transitionPathRotate, 67);
        e.append(a7.Constraint_motionStagger, 79);
        e.append(a7.Constraint_android_id, 38);
        e.append(a7.Constraint_motionProgress, 68);
        e.append(a7.Constraint_layout_constraintWidth_percent, 69);
        e.append(a7.Constraint_layout_constraintHeight_percent, 70);
        e.append(a7.Constraint_layout_wrapBehaviorInParent, 97);
        e.append(a7.Constraint_chainUseRtl, 71);
        e.append(a7.Constraint_barrierDirection, 72);
        e.append(a7.Constraint_barrierMargin, 73);
        e.append(a7.Constraint_constraint_referenced_ids, 74);
        e.append(a7.Constraint_barrierAllowsGoneWidgets, 75);
        e.append(a7.Constraint_pathMotionArc, 76);
        e.append(a7.Constraint_layout_constraintTag, 77);
        e.append(a7.Constraint_visibilityMode, 78);
        e.append(a7.Constraint_layout_constrainedWidth, 80);
        e.append(a7.Constraint_layout_constrainedHeight, 81);
        e.append(a7.Constraint_polarRelativeTo, 82);
        e.append(a7.Constraint_transformPivotTarget, 83);
        e.append(a7.Constraint_quantizeMotionSteps, 84);
        e.append(a7.Constraint_quantizeMotionPhase, 85);
        e.append(a7.Constraint_quantizeMotionInterpolator, 86);
        f.append(a7.ConstraintOverride_layout_editor_absoluteY, 6);
        f.append(a7.ConstraintOverride_layout_editor_absoluteY, 7);
        f.append(a7.ConstraintOverride_android_orientation, 27);
        f.append(a7.ConstraintOverride_layout_goneMarginLeft, 13);
        f.append(a7.ConstraintOverride_layout_goneMarginTop, 16);
        f.append(a7.ConstraintOverride_layout_goneMarginRight, 14);
        f.append(a7.ConstraintOverride_layout_goneMarginBottom, 11);
        f.append(a7.ConstraintOverride_layout_goneMarginStart, 15);
        f.append(a7.ConstraintOverride_layout_goneMarginEnd, 12);
        f.append(a7.ConstraintOverride_layout_constraintVertical_weight, 40);
        f.append(a7.ConstraintOverride_layout_constraintHorizontal_weight, 39);
        f.append(a7.ConstraintOverride_layout_constraintHorizontal_chainStyle, 41);
        f.append(a7.ConstraintOverride_layout_constraintVertical_chainStyle, 42);
        f.append(a7.ConstraintOverride_layout_constraintHorizontal_bias, 20);
        f.append(a7.ConstraintOverride_layout_constraintVertical_bias, 37);
        f.append(a7.ConstraintOverride_layout_constraintDimensionRatio, 5);
        f.append(a7.ConstraintOverride_layout_constraintLeft_creator, 87);
        f.append(a7.ConstraintOverride_layout_constraintTop_creator, 87);
        f.append(a7.ConstraintOverride_layout_constraintRight_creator, 87);
        f.append(a7.ConstraintOverride_layout_constraintBottom_creator, 87);
        f.append(a7.ConstraintOverride_layout_constraintBaseline_creator, 87);
        f.append(a7.ConstraintOverride_android_layout_marginLeft, 24);
        f.append(a7.ConstraintOverride_android_layout_marginRight, 28);
        f.append(a7.ConstraintOverride_android_layout_marginStart, 31);
        f.append(a7.ConstraintOverride_android_layout_marginEnd, 8);
        f.append(a7.ConstraintOverride_android_layout_marginTop, 34);
        f.append(a7.ConstraintOverride_android_layout_marginBottom, 2);
        f.append(a7.ConstraintOverride_android_layout_width, 23);
        f.append(a7.ConstraintOverride_android_layout_height, 21);
        f.append(a7.ConstraintOverride_layout_constraintWidth, 95);
        f.append(a7.ConstraintOverride_layout_constraintHeight, 96);
        f.append(a7.ConstraintOverride_android_visibility, 22);
        f.append(a7.ConstraintOverride_android_alpha, 43);
        f.append(a7.ConstraintOverride_android_elevation, 44);
        f.append(a7.ConstraintOverride_android_rotationX, 45);
        f.append(a7.ConstraintOverride_android_rotationY, 46);
        f.append(a7.ConstraintOverride_android_rotation, 60);
        f.append(a7.ConstraintOverride_android_scaleX, 47);
        f.append(a7.ConstraintOverride_android_scaleY, 48);
        f.append(a7.ConstraintOverride_android_transformPivotX, 49);
        f.append(a7.ConstraintOverride_android_transformPivotY, 50);
        f.append(a7.ConstraintOverride_android_translationX, 51);
        f.append(a7.ConstraintOverride_android_translationY, 52);
        f.append(a7.ConstraintOverride_android_translationZ, 53);
        f.append(a7.ConstraintOverride_layout_constraintWidth_default, 54);
        f.append(a7.ConstraintOverride_layout_constraintHeight_default, 55);
        f.append(a7.ConstraintOverride_layout_constraintWidth_max, 56);
        f.append(a7.ConstraintOverride_layout_constraintHeight_max, 57);
        f.append(a7.ConstraintOverride_layout_constraintWidth_min, 58);
        f.append(a7.ConstraintOverride_layout_constraintHeight_min, 59);
        f.append(a7.ConstraintOverride_layout_constraintCircleRadius, 62);
        f.append(a7.ConstraintOverride_layout_constraintCircleAngle, 63);
        f.append(a7.ConstraintOverride_animateRelativeTo, 64);
        f.append(a7.ConstraintOverride_transitionEasing, 65);
        f.append(a7.ConstraintOverride_drawPath, 66);
        f.append(a7.ConstraintOverride_transitionPathRotate, 67);
        f.append(a7.ConstraintOverride_motionStagger, 79);
        f.append(a7.ConstraintOverride_android_id, 38);
        f.append(a7.ConstraintOverride_motionTarget, 98);
        f.append(a7.ConstraintOverride_motionProgress, 68);
        f.append(a7.ConstraintOverride_layout_constraintWidth_percent, 69);
        f.append(a7.ConstraintOverride_layout_constraintHeight_percent, 70);
        f.append(a7.ConstraintOverride_chainUseRtl, 71);
        f.append(a7.ConstraintOverride_barrierDirection, 72);
        f.append(a7.ConstraintOverride_barrierMargin, 73);
        f.append(a7.ConstraintOverride_constraint_referenced_ids, 74);
        f.append(a7.ConstraintOverride_barrierAllowsGoneWidgets, 75);
        f.append(a7.ConstraintOverride_pathMotionArc, 76);
        f.append(a7.ConstraintOverride_layout_constraintTag, 77);
        f.append(a7.ConstraintOverride_visibilityMode, 78);
        f.append(a7.ConstraintOverride_layout_constrainedWidth, 80);
        f.append(a7.ConstraintOverride_layout_constrainedHeight, 81);
        f.append(a7.ConstraintOverride_polarRelativeTo, 82);
        f.append(a7.ConstraintOverride_transformPivotTarget, 83);
        f.append(a7.ConstraintOverride_quantizeMotionSteps, 84);
        f.append(a7.ConstraintOverride_quantizeMotionPhase, 85);
        f.append(a7.ConstraintOverride_quantizeMotionInterpolator, 86);
        f.append(a7.ConstraintOverride_layout_wrapBehaviorInParent, 97);
    }

    public static void a(Object data, TypedArray a2, int attr, int orientation) {
        int dimensionPixelSize;
        if (data == null) {
            return;
        }
        int i = a2.peekValue(attr).type;
        boolean z = false;
        if (i != 3) {
            if (i != 5) {
                dimensionPixelSize = a2.getInt(attr, 0);
                if (dimensionPixelSize == -4) {
                    dimensionPixelSize = -2;
                    z = true;
                } else if (dimensionPixelSize == -3 || (dimensionPixelSize != -2 && dimensionPixelSize != -1)) {
                    dimensionPixelSize = 0;
                }
            } else {
                dimensionPixelSize = a2.getDimensionPixelSize(attr, 0);
            }
            if (data instanceof ConstraintLayout.a) {
                ConstraintLayout.a aVar = (ConstraintLayout.a) data;
                if (orientation == 0) {
                    ((ViewGroup.MarginLayoutParams) aVar).width = dimensionPixelSize;
                    aVar.X = z;
                    return;
                }
                ((ViewGroup.MarginLayoutParams) aVar).height = dimensionPixelSize;
                aVar.Y = z;
                return;
            } else if (data instanceof b) {
                b bVar = (b) data;
                if (orientation == 0) {
                    bVar.c = dimensionPixelSize;
                    bVar.l0 = z;
                    return;
                }
                bVar.d = dimensionPixelSize;
                bVar.m0 = z;
                return;
            } else if (data instanceof a.C0012a) {
                a.C0012a c0012a = (a.C0012a) data;
                if (orientation == 0) {
                    c0012a.a(23, dimensionPixelSize);
                    c0012a.a(80, z);
                    return;
                }
                c0012a.a(21, dimensionPixelSize);
                c0012a.a(81, z);
                return;
            } else {
                return;
            }
        }
        String string = a2.getString(attr);
        if (string == null) {
            return;
        }
        int indexOf = string.indexOf(61);
        int length = string.length();
        if (indexOf <= 0 || indexOf >= length - 1) {
            return;
        }
        String substring = string.substring(0, indexOf);
        String substring2 = string.substring(indexOf + 1);
        if (substring2.length() > 0) {
            String trim = substring.trim();
            String trim2 = substring2.trim();
            if ("ratio".equalsIgnoreCase(trim)) {
                if (data instanceof ConstraintLayout.a) {
                    ConstraintLayout.a aVar2 = (ConstraintLayout.a) data;
                    if (orientation == 0) {
                        ((ViewGroup.MarginLayoutParams) aVar2).width = 0;
                    } else {
                        ((ViewGroup.MarginLayoutParams) aVar2).height = 0;
                    }
                    a(aVar2, trim2);
                    return;
                } else if (data instanceof b) {
                    ((b) data).y = trim2;
                    return;
                } else if (data instanceof a.C0012a) {
                    ((a.C0012a) data).a(5, trim2);
                    return;
                } else {
                    return;
                }
            }
            try {
                if ("weight".equalsIgnoreCase(trim)) {
                    float parseFloat = Float.parseFloat(trim2);
                    if (data instanceof ConstraintLayout.a) {
                        ConstraintLayout.a aVar3 = (ConstraintLayout.a) data;
                        if (orientation == 0) {
                            ((ViewGroup.MarginLayoutParams) aVar3).width = 0;
                            aVar3.I = parseFloat;
                        } else {
                            ((ViewGroup.MarginLayoutParams) aVar3).height = 0;
                            aVar3.J = parseFloat;
                        }
                    } else if (data instanceof b) {
                        b bVar2 = (b) data;
                        if (orientation == 0) {
                            bVar2.c = 0;
                            bVar2.U = parseFloat;
                        } else {
                            bVar2.d = 0;
                            bVar2.T = parseFloat;
                        }
                    } else if (data instanceof a.C0012a) {
                        a.C0012a c0012a2 = (a.C0012a) data;
                        if (orientation == 0) {
                            c0012a2.a(23, 0);
                            c0012a2.a(39, parseFloat);
                        } else {
                            c0012a2.a(21, 0);
                            c0012a2.a(40, parseFloat);
                        }
                    }
                } else if (!"parent".equalsIgnoreCase(trim)) {
                } else {
                    float max = Math.max((float) XToggleDrawable.LIGHT_RADIUS_DEFAULT, Math.min(1.0f, Float.parseFloat(trim2)));
                    if (data instanceof ConstraintLayout.a) {
                        ConstraintLayout.a aVar4 = (ConstraintLayout.a) data;
                        if (orientation == 0) {
                            ((ViewGroup.MarginLayoutParams) aVar4).width = 0;
                            aVar4.S = max;
                            aVar4.M = 2;
                        } else {
                            ((ViewGroup.MarginLayoutParams) aVar4).height = 0;
                            aVar4.T = max;
                            aVar4.N = 2;
                        }
                    } else if (data instanceof b) {
                        b bVar3 = (b) data;
                        if (orientation == 0) {
                            bVar3.c = 0;
                            bVar3.d0 = max;
                            bVar3.X = 2;
                        } else {
                            bVar3.d = 0;
                            bVar3.e0 = max;
                            bVar3.Y = 2;
                        }
                    } else if (data instanceof a.C0012a) {
                        a.C0012a c0012a3 = (a.C0012a) data;
                        if (orientation == 0) {
                            c0012a3.a(23, 0);
                            c0012a3.a(54, 2);
                        } else {
                            c0012a3.a(21, 0);
                            c0012a3.a(55, 2);
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
    }

    public void b(Context context, int resourceId) {
        XmlResourceParser xml = context.getResources().getXml(resourceId);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                    continue;
                } else if (eventType != 2) {
                    continue;
                } else {
                    String name = xml.getName();
                    a a2 = a(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        a2.d.a = true;
                    }
                    this.c.put(Integer.valueOf(a2.a), a2);
                    continue;
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (XmlPullParserException e3) {
            e3.printStackTrace();
        }
    }

    /* compiled from: ConstraintSet.java */
    /* renamed from: u6$a */
    /* loaded from: classes.dex */
    public static class a {
        public int a;
        public final d b = new d();
        public final c c = new c();
        public final b d = new b();
        public final e e = new e();
        public HashMap<String, r6> f = new HashMap<>();
        public C0012a g;

        public final void a(int viewId, v6.a param) {
            a(viewId, (ConstraintLayout.a) param);
            this.b.d = param.u0;
            e eVar = this.e;
            eVar.b = param.x0;
            eVar.c = param.y0;
            eVar.d = param.z0;
            eVar.e = param.A0;
            eVar.f = param.B0;
            eVar.g = param.C0;
            eVar.h = param.D0;
            eVar.j = param.E0;
            eVar.k = param.F0;
            eVar.l = param.G0;
            eVar.n = param.w0;
            eVar.m = param.v0;
        }

        public Object clone() {
            a aVar = new a();
            aVar.d.a(this.d);
            aVar.c.a(this.c);
            aVar.b.a(this.b);
            aVar.e.a(this.e);
            aVar.a = this.a;
            aVar.g = this.g;
            return aVar;
        }

        /* compiled from: ConstraintSet.java */
        /* renamed from: u6$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0012a {
            public int[] a = new int[10];
            public int[] b = new int[10];
            public int c = 0;
            public int[] d = new int[10];
            public float[] e = new float[10];
            public int f = 0;
            public int[] g = new int[5];
            public String[] h = new String[5];
            public int i = 0;
            public int[] j = new int[4];
            public boolean[] k = new boolean[4];
            public int l = 0;

            public void a(int type, int value) {
                int i = this.c;
                int[] iArr = this.a;
                if (i >= iArr.length) {
                    this.a = Arrays.copyOf(iArr, iArr.length * 2);
                    int[] iArr2 = this.b;
                    this.b = Arrays.copyOf(iArr2, iArr2.length * 2);
                }
                int[] iArr3 = this.a;
                int i2 = this.c;
                iArr3[i2] = type;
                int[] iArr4 = this.b;
                this.c = i2 + 1;
                iArr4[i2] = value;
            }

            public void a(int type, float value) {
                int i = this.f;
                int[] iArr = this.d;
                if (i >= iArr.length) {
                    this.d = Arrays.copyOf(iArr, iArr.length * 2);
                    float[] fArr = this.e;
                    this.e = Arrays.copyOf(fArr, fArr.length * 2);
                }
                int[] iArr2 = this.d;
                int i2 = this.f;
                iArr2[i2] = type;
                float[] fArr2 = this.e;
                this.f = i2 + 1;
                fArr2[i2] = value;
            }

            public void a(int type, String value) {
                int i = this.i;
                int[] iArr = this.g;
                if (i >= iArr.length) {
                    this.g = Arrays.copyOf(iArr, iArr.length * 2);
                    String[] strArr = this.h;
                    this.h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                }
                int[] iArr2 = this.g;
                int i2 = this.i;
                iArr2[i2] = type;
                String[] strArr2 = this.h;
                this.i = i2 + 1;
                strArr2[i2] = value;
            }

            public void a(int type, boolean value) {
                int i = this.l;
                int[] iArr = this.j;
                if (i >= iArr.length) {
                    this.j = Arrays.copyOf(iArr, iArr.length * 2);
                    boolean[] zArr = this.k;
                    this.k = Arrays.copyOf(zArr, zArr.length * 2);
                }
                int[] iArr2 = this.j;
                int i2 = this.l;
                iArr2[i2] = type;
                boolean[] zArr2 = this.k;
                this.l = i2 + 1;
                zArr2[i2] = value;
            }
        }

        public final void a(int viewId, ConstraintLayout.a param) {
            this.a = viewId;
            b bVar = this.d;
            bVar.h = param.d;
            bVar.i = param.e;
            bVar.j = param.f;
            bVar.k = param.g;
            bVar.l = param.h;
            bVar.m = param.i;
            bVar.n = param.j;
            bVar.o = param.k;
            bVar.p = param.l;
            bVar.q = param.m;
            bVar.r = param.n;
            bVar.s = param.r;
            bVar.t = param.s;
            bVar.u = param.t;
            bVar.v = param.u;
            bVar.w = param.D;
            bVar.x = param.E;
            bVar.y = param.F;
            bVar.z = param.o;
            bVar.A = param.p;
            bVar.B = param.q;
            bVar.C = param.U;
            bVar.D = param.V;
            bVar.E = param.W;
            bVar.g = param.c;
            bVar.e = param.a;
            bVar.f = param.b;
            bVar.c = ((ViewGroup.MarginLayoutParams) param).width;
            this.d.d = ((ViewGroup.MarginLayoutParams) param).height;
            b bVar2 = this.d;
            bVar2.F = ((ViewGroup.MarginLayoutParams) param).leftMargin;
            bVar2.G = ((ViewGroup.MarginLayoutParams) param).rightMargin;
            bVar2.H = ((ViewGroup.MarginLayoutParams) param).topMargin;
            bVar2.I = ((ViewGroup.MarginLayoutParams) param).bottomMargin;
            bVar2.L = param.C;
            bVar2.T = param.J;
            bVar2.U = param.I;
            bVar2.W = param.L;
            bVar2.V = param.K;
            bVar2.l0 = param.X;
            bVar2.m0 = param.Y;
            bVar2.X = param.M;
            bVar2.Y = param.N;
            bVar2.Z = param.Q;
            bVar2.a0 = param.R;
            bVar2.b0 = param.O;
            bVar2.c0 = param.P;
            bVar2.d0 = param.S;
            bVar2.e0 = param.T;
            bVar2.k0 = param.Z;
            bVar2.N = param.w;
            bVar2.P = param.y;
            bVar2.M = param.v;
            bVar2.O = param.x;
            bVar2.R = param.z;
            bVar2.Q = param.A;
            bVar2.S = param.B;
            bVar2.o0 = param.a0;
            int i = Build.VERSION.SDK_INT;
            bVar2.J = param.getMarginEnd();
            this.d.K = param.getMarginStart();
        }

        public void a(ConstraintLayout.a param) {
            b bVar = this.d;
            param.d = bVar.h;
            param.e = bVar.i;
            param.f = bVar.j;
            param.g = bVar.k;
            param.h = bVar.l;
            param.i = bVar.m;
            param.j = bVar.n;
            param.k = bVar.o;
            param.l = bVar.p;
            param.m = bVar.q;
            param.n = bVar.r;
            param.r = bVar.s;
            param.s = bVar.t;
            param.t = bVar.u;
            param.u = bVar.v;
            ((ViewGroup.MarginLayoutParams) param).leftMargin = bVar.F;
            ((ViewGroup.MarginLayoutParams) param).rightMargin = bVar.G;
            ((ViewGroup.MarginLayoutParams) param).topMargin = bVar.H;
            ((ViewGroup.MarginLayoutParams) param).bottomMargin = bVar.I;
            param.z = bVar.R;
            param.A = bVar.Q;
            param.w = bVar.N;
            param.y = bVar.P;
            param.D = bVar.w;
            param.E = bVar.x;
            param.o = bVar.z;
            param.p = bVar.A;
            param.q = bVar.B;
            param.F = bVar.y;
            param.U = bVar.C;
            param.V = bVar.D;
            param.J = bVar.T;
            param.I = bVar.U;
            param.L = bVar.W;
            param.K = bVar.V;
            param.X = bVar.l0;
            param.Y = bVar.m0;
            param.M = bVar.X;
            param.N = bVar.Y;
            param.Q = bVar.Z;
            param.R = bVar.a0;
            param.O = bVar.b0;
            param.P = bVar.c0;
            param.S = bVar.d0;
            param.T = bVar.e0;
            param.W = bVar.E;
            param.c = bVar.g;
            param.a = bVar.e;
            param.b = bVar.f;
            ((ViewGroup.MarginLayoutParams) param).width = bVar.c;
            ((ViewGroup.MarginLayoutParams) param).height = bVar.d;
            String str = bVar.k0;
            if (str != null) {
                param.Z = str;
            }
            b bVar2 = this.d;
            param.a0 = bVar2.o0;
            int i = Build.VERSION.SDK_INT;
            param.setMarginStart(bVar2.K);
            param.setMarginEnd(this.d.J);
            param.a();
        }
    }

    /* compiled from: ConstraintSet.java */
    /* renamed from: u6$d */
    /* loaded from: classes.dex */
    public static class d {
        public boolean a = false;
        public int b = 0;
        public int c = 0;
        public float d = 1.0f;
        public float e = Float.NaN;

        public void a(d src) {
            this.a = src.a;
            this.b = src.b;
            this.d = src.d;
            this.e = src.e;
            this.c = src.c;
        }

        public void a(Context context, AttributeSet attrs) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, a7.PropertySet);
            this.a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == a7.PropertySet_android_alpha) {
                    this.d = obtainStyledAttributes.getFloat(index, this.d);
                } else if (index == a7.PropertySet_android_visibility) {
                    this.b = obtainStyledAttributes.getInt(index, this.b);
                    this.b = u6.d[this.b];
                } else if (index == a7.PropertySet_visibilityMode) {
                    this.c = obtainStyledAttributes.getInt(index, this.c);
                } else if (index == a7.PropertySet_motionProgress) {
                    this.e = obtainStyledAttributes.getFloat(index, this.e);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* compiled from: ConstraintSet.java */
    /* renamed from: u6$c */
    /* loaded from: classes.dex */
    public static class c {
        public static SparseIntArray o = new SparseIntArray();
        public boolean a = false;
        public int b = -1;
        public int c = 0;
        public String d = null;
        public int e = -1;
        public int f = 0;
        public float g = Float.NaN;
        public int h = -1;
        public float i = Float.NaN;
        public float j = Float.NaN;
        public int k = -1;
        public String l = null;
        public int m = -3;
        public int n = -1;

        static {
            o.append(a7.Motion_motionPathRotate, 1);
            o.append(a7.Motion_pathMotionArc, 2);
            o.append(a7.Motion_transitionEasing, 3);
            o.append(a7.Motion_drawPath, 4);
            o.append(a7.Motion_animateRelativeTo, 5);
            o.append(a7.Motion_animateCircleAngleTo, 6);
            o.append(a7.Motion_motionStagger, 7);
            o.append(a7.Motion_quantizeMotionSteps, 8);
            o.append(a7.Motion_quantizeMotionPhase, 9);
            o.append(a7.Motion_quantizeMotionInterpolator, 10);
        }

        public void a(c src) {
            this.a = src.a;
            this.b = src.b;
            this.d = src.d;
            this.e = src.e;
            this.f = src.f;
            this.i = src.i;
            this.g = src.g;
            this.h = src.h;
        }

        public void a(Context context, AttributeSet attrs) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, a7.Motion);
            this.a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                switch (o.get(index)) {
                    case 1:
                        this.i = obtainStyledAttributes.getFloat(index, this.i);
                        break;
                    case 2:
                        this.e = obtainStyledAttributes.getInt(index, this.e);
                        break;
                    case 3:
                        if (obtainStyledAttributes.peekValue(index).type == 3) {
                            this.d = obtainStyledAttributes.getString(index);
                            break;
                        } else {
                            this.d = o5.c[obtainStyledAttributes.getInteger(index, 0)];
                            break;
                        }
                    case 4:
                        this.f = obtainStyledAttributes.getInt(index, 0);
                        break;
                    case 5:
                        this.b = u6.a(obtainStyledAttributes, index, this.b);
                        break;
                    case 6:
                        this.c = obtainStyledAttributes.getInteger(index, this.c);
                        break;
                    case 7:
                        this.g = obtainStyledAttributes.getFloat(index, this.g);
                        break;
                    case 8:
                        this.k = obtainStyledAttributes.getInteger(index, this.k);
                        break;
                    case 9:
                        this.j = obtainStyledAttributes.getFloat(index, this.j);
                        break;
                    case 10:
                        int i2 = obtainStyledAttributes.peekValue(index).type;
                        if (i2 == 1) {
                            this.n = obtainStyledAttributes.getResourceId(index, -1);
                            if (this.n != -1) {
                                this.m = -2;
                                break;
                            } else {
                                break;
                            }
                        } else if (i2 == 3) {
                            this.l = obtainStyledAttributes.getString(index);
                            if (this.l.indexOf("/") > 0) {
                                this.n = obtainStyledAttributes.getResourceId(index, -1);
                                this.m = -2;
                                break;
                            } else {
                                this.m = -1;
                                break;
                            }
                        } else {
                            this.m = obtainStyledAttributes.getInteger(index, this.n);
                            break;
                        }
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* compiled from: ConstraintSet.java */
    /* renamed from: u6$e */
    /* loaded from: classes.dex */
    public static class e {
        public static SparseIntArray o = new SparseIntArray();
        public boolean a = false;
        public float b = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        public float c = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        public float d = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        public float e = 1.0f;
        public float f = 1.0f;
        public float g = Float.NaN;
        public float h = Float.NaN;
        public int i = -1;
        public float j = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        public float k = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        public float l = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        public boolean m = false;
        public float n = XToggleDrawable.LIGHT_RADIUS_DEFAULT;

        static {
            o.append(a7.Transform_android_rotation, 1);
            o.append(a7.Transform_android_rotationX, 2);
            o.append(a7.Transform_android_rotationY, 3);
            o.append(a7.Transform_android_scaleX, 4);
            o.append(a7.Transform_android_scaleY, 5);
            o.append(a7.Transform_android_transformPivotX, 6);
            o.append(a7.Transform_android_transformPivotY, 7);
            o.append(a7.Transform_android_translationX, 8);
            o.append(a7.Transform_android_translationY, 9);
            o.append(a7.Transform_android_translationZ, 10);
            o.append(a7.Transform_android_elevation, 11);
            o.append(a7.Transform_transformPivotTarget, 12);
        }

        public void a(e src) {
            this.a = src.a;
            this.b = src.b;
            this.c = src.c;
            this.d = src.d;
            this.e = src.e;
            this.f = src.f;
            this.g = src.g;
            this.h = src.h;
            this.i = src.i;
            this.j = src.j;
            this.k = src.k;
            this.l = src.l;
            this.m = src.m;
            this.n = src.n;
        }

        public void a(Context context, AttributeSet attrs) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, a7.Transform);
            this.a = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                switch (o.get(index)) {
                    case 1:
                        this.b = obtainStyledAttributes.getFloat(index, this.b);
                        break;
                    case 2:
                        this.c = obtainStyledAttributes.getFloat(index, this.c);
                        break;
                    case 3:
                        this.d = obtainStyledAttributes.getFloat(index, this.d);
                        break;
                    case 4:
                        this.e = obtainStyledAttributes.getFloat(index, this.e);
                        break;
                    case 5:
                        this.f = obtainStyledAttributes.getFloat(index, this.f);
                        break;
                    case 6:
                        this.g = obtainStyledAttributes.getDimension(index, this.g);
                        break;
                    case 7:
                        this.h = obtainStyledAttributes.getDimension(index, this.h);
                        break;
                    case 8:
                        this.j = obtainStyledAttributes.getDimension(index, this.j);
                        break;
                    case 9:
                        this.k = obtainStyledAttributes.getDimension(index, this.k);
                        break;
                    case 10:
                        int i2 = Build.VERSION.SDK_INT;
                        this.l = obtainStyledAttributes.getDimension(index, this.l);
                        break;
                    case 11:
                        int i3 = Build.VERSION.SDK_INT;
                        this.m = true;
                        this.n = obtainStyledAttributes.getDimension(index, this.n);
                        break;
                    case 12:
                        this.i = u6.a(obtainStyledAttributes, index, this.i);
                        break;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    /* compiled from: ConstraintSet.java */
    /* renamed from: u6$b */
    /* loaded from: classes.dex */
    public static class b {
        public static SparseIntArray p0 = new SparseIntArray();
        public int c;
        public int d;
        public int[] i0;
        public String j0;
        public String k0;
        public boolean a = false;
        public boolean b = false;
        public int e = -1;
        public int f = -1;
        public float g = -1.0f;
        public int h = -1;
        public int i = -1;
        public int j = -1;
        public int k = -1;
        public int l = -1;
        public int m = -1;
        public int n = -1;
        public int o = -1;
        public int p = -1;
        public int q = -1;
        public int r = -1;
        public int s = -1;
        public int t = -1;
        public int u = -1;
        public int v = -1;
        public float w = 0.5f;
        public float x = 0.5f;
        public String y = null;
        public int z = -1;
        public int A = 0;
        public float B = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        public int C = -1;
        public int D = -1;
        public int E = -1;
        public int F = 0;
        public int G = 0;
        public int H = 0;
        public int I = 0;
        public int J = 0;
        public int K = 0;
        public int L = 0;
        public int M = Integer.MIN_VALUE;
        public int N = Integer.MIN_VALUE;
        public int O = Integer.MIN_VALUE;
        public int P = Integer.MIN_VALUE;
        public int Q = Integer.MIN_VALUE;
        public int R = Integer.MIN_VALUE;
        public int S = Integer.MIN_VALUE;
        public float T = -1.0f;
        public float U = -1.0f;
        public int V = 0;
        public int W = 0;
        public int X = 0;
        public int Y = 0;
        public int Z = -1;
        public int a0 = -1;
        public int b0 = -1;
        public int c0 = -1;
        public float d0 = 1.0f;
        public float e0 = 1.0f;
        public int f0 = -1;
        public int g0 = 0;
        public int h0 = -1;
        public boolean l0 = false;
        public boolean m0 = false;
        public boolean n0 = true;
        public int o0 = 0;

        static {
            p0.append(a7.Layout_layout_constraintLeft_toLeftOf, 24);
            p0.append(a7.Layout_layout_constraintLeft_toRightOf, 25);
            p0.append(a7.Layout_layout_constraintRight_toLeftOf, 28);
            p0.append(a7.Layout_layout_constraintRight_toRightOf, 29);
            p0.append(a7.Layout_layout_constraintTop_toTopOf, 35);
            p0.append(a7.Layout_layout_constraintTop_toBottomOf, 34);
            p0.append(a7.Layout_layout_constraintBottom_toTopOf, 4);
            p0.append(a7.Layout_layout_constraintBottom_toBottomOf, 3);
            p0.append(a7.Layout_layout_constraintBaseline_toBaselineOf, 1);
            p0.append(a7.Layout_layout_editor_absoluteX, 6);
            p0.append(a7.Layout_layout_editor_absoluteY, 7);
            p0.append(a7.Layout_layout_constraintGuide_begin, 17);
            p0.append(a7.Layout_layout_constraintGuide_end, 18);
            p0.append(a7.Layout_layout_constraintGuide_percent, 19);
            p0.append(a7.Layout_android_orientation, 26);
            p0.append(a7.Layout_layout_constraintStart_toEndOf, 31);
            p0.append(a7.Layout_layout_constraintStart_toStartOf, 32);
            p0.append(a7.Layout_layout_constraintEnd_toStartOf, 10);
            p0.append(a7.Layout_layout_constraintEnd_toEndOf, 9);
            p0.append(a7.Layout_layout_goneMarginLeft, 13);
            p0.append(a7.Layout_layout_goneMarginTop, 16);
            p0.append(a7.Layout_layout_goneMarginRight, 14);
            p0.append(a7.Layout_layout_goneMarginBottom, 11);
            p0.append(a7.Layout_layout_goneMarginStart, 15);
            p0.append(a7.Layout_layout_goneMarginEnd, 12);
            p0.append(a7.Layout_layout_constraintVertical_weight, 38);
            p0.append(a7.Layout_layout_constraintHorizontal_weight, 37);
            p0.append(a7.Layout_layout_constraintHorizontal_chainStyle, 39);
            p0.append(a7.Layout_layout_constraintVertical_chainStyle, 40);
            p0.append(a7.Layout_layout_constraintHorizontal_bias, 20);
            p0.append(a7.Layout_layout_constraintVertical_bias, 36);
            p0.append(a7.Layout_layout_constraintDimensionRatio, 5);
            p0.append(a7.Layout_layout_constraintLeft_creator, 76);
            p0.append(a7.Layout_layout_constraintTop_creator, 76);
            p0.append(a7.Layout_layout_constraintRight_creator, 76);
            p0.append(a7.Layout_layout_constraintBottom_creator, 76);
            p0.append(a7.Layout_layout_constraintBaseline_creator, 76);
            p0.append(a7.Layout_android_layout_marginLeft, 23);
            p0.append(a7.Layout_android_layout_marginRight, 27);
            p0.append(a7.Layout_android_layout_marginStart, 30);
            p0.append(a7.Layout_android_layout_marginEnd, 8);
            p0.append(a7.Layout_android_layout_marginTop, 33);
            p0.append(a7.Layout_android_layout_marginBottom, 2);
            p0.append(a7.Layout_android_layout_width, 22);
            p0.append(a7.Layout_android_layout_height, 21);
            p0.append(a7.Layout_layout_constraintWidth, 41);
            p0.append(a7.Layout_layout_constraintHeight, 42);
            p0.append(a7.Layout_layout_constrainedWidth, 41);
            p0.append(a7.Layout_layout_constrainedHeight, 42);
            p0.append(a7.Layout_layout_wrapBehaviorInParent, 97);
            p0.append(a7.Layout_layout_constraintCircle, 61);
            p0.append(a7.Layout_layout_constraintCircleRadius, 62);
            p0.append(a7.Layout_layout_constraintCircleAngle, 63);
            p0.append(a7.Layout_layout_constraintWidth_percent, 69);
            p0.append(a7.Layout_layout_constraintHeight_percent, 70);
            p0.append(a7.Layout_chainUseRtl, 71);
            p0.append(a7.Layout_barrierDirection, 72);
            p0.append(a7.Layout_barrierMargin, 73);
            p0.append(a7.Layout_constraint_referenced_ids, 74);
            p0.append(a7.Layout_barrierAllowsGoneWidgets, 75);
        }

        public void a(b src) {
            this.a = src.a;
            this.c = src.c;
            this.b = src.b;
            this.d = src.d;
            this.e = src.e;
            this.f = src.f;
            this.g = src.g;
            this.h = src.h;
            this.i = src.i;
            this.j = src.j;
            this.k = src.k;
            this.l = src.l;
            this.m = src.m;
            this.n = src.n;
            this.o = src.o;
            this.p = src.p;
            this.q = src.q;
            this.r = src.r;
            this.s = src.s;
            this.t = src.t;
            this.u = src.u;
            this.v = src.v;
            this.w = src.w;
            this.x = src.x;
            this.y = src.y;
            this.z = src.z;
            this.A = src.A;
            this.B = src.B;
            this.C = src.C;
            this.D = src.D;
            this.E = src.E;
            this.F = src.F;
            this.G = src.G;
            this.H = src.H;
            this.I = src.I;
            this.J = src.J;
            this.K = src.K;
            this.L = src.L;
            this.M = src.M;
            this.N = src.N;
            this.O = src.O;
            this.P = src.P;
            this.Q = src.Q;
            this.R = src.R;
            this.S = src.S;
            this.T = src.T;
            this.U = src.U;
            this.V = src.V;
            this.W = src.W;
            this.X = src.X;
            this.Y = src.Y;
            this.Z = src.Z;
            this.a0 = src.a0;
            this.b0 = src.b0;
            this.c0 = src.c0;
            this.d0 = src.d0;
            this.e0 = src.e0;
            this.f0 = src.f0;
            this.g0 = src.g0;
            this.h0 = src.h0;
            this.k0 = src.k0;
            int[] iArr = src.i0;
            if (iArr != null) {
                this.i0 = Arrays.copyOf(iArr, iArr.length);
            } else {
                this.i0 = null;
            }
            this.j0 = src.j0;
            this.l0 = src.l0;
            this.m0 = src.m0;
            this.n0 = src.n0;
            this.o0 = src.o0;
        }

        public void a(Context context, AttributeSet attrs) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, a7.Layout);
            this.b = true;
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                int i2 = p0.get(index);
                if (i2 == 80) {
                    this.l0 = obtainStyledAttributes.getBoolean(index, this.l0);
                } else if (i2 == 81) {
                    this.m0 = obtainStyledAttributes.getBoolean(index, this.m0);
                } else if (i2 != 97) {
                    switch (i2) {
                        case 1:
                            this.p = u6.a(obtainStyledAttributes, index, this.p);
                            continue;
                        case 2:
                            this.I = obtainStyledAttributes.getDimensionPixelSize(index, this.I);
                            continue;
                        case 3:
                            this.o = u6.a(obtainStyledAttributes, index, this.o);
                            continue;
                        case 4:
                            this.n = u6.a(obtainStyledAttributes, index, this.n);
                            continue;
                        case 5:
                            this.y = obtainStyledAttributes.getString(index);
                            continue;
                        case 6:
                            this.C = obtainStyledAttributes.getDimensionPixelOffset(index, this.C);
                            continue;
                        case 7:
                            this.D = obtainStyledAttributes.getDimensionPixelOffset(index, this.D);
                            continue;
                        case 8:
                            int i3 = Build.VERSION.SDK_INT;
                            this.J = obtainStyledAttributes.getDimensionPixelSize(index, this.J);
                            continue;
                        case 9:
                            this.v = u6.a(obtainStyledAttributes, index, this.v);
                            continue;
                        case 10:
                            this.u = u6.a(obtainStyledAttributes, index, this.u);
                            continue;
                        case 11:
                            this.P = obtainStyledAttributes.getDimensionPixelSize(index, this.P);
                            continue;
                        case 12:
                            this.Q = obtainStyledAttributes.getDimensionPixelSize(index, this.Q);
                            continue;
                        case 13:
                            this.M = obtainStyledAttributes.getDimensionPixelSize(index, this.M);
                            continue;
                        case 14:
                            this.O = obtainStyledAttributes.getDimensionPixelSize(index, this.O);
                            continue;
                        case 15:
                            this.R = obtainStyledAttributes.getDimensionPixelSize(index, this.R);
                            continue;
                        case 16:
                            this.N = obtainStyledAttributes.getDimensionPixelSize(index, this.N);
                            continue;
                        case 17:
                            this.e = obtainStyledAttributes.getDimensionPixelOffset(index, this.e);
                            continue;
                        case 18:
                            this.f = obtainStyledAttributes.getDimensionPixelOffset(index, this.f);
                            continue;
                        case 19:
                            this.g = obtainStyledAttributes.getFloat(index, this.g);
                            continue;
                        case 20:
                            this.w = obtainStyledAttributes.getFloat(index, this.w);
                            continue;
                        case 21:
                            this.d = obtainStyledAttributes.getLayoutDimension(index, this.d);
                            continue;
                        case 22:
                            this.c = obtainStyledAttributes.getLayoutDimension(index, this.c);
                            continue;
                        case 23:
                            this.F = obtainStyledAttributes.getDimensionPixelSize(index, this.F);
                            continue;
                        case 24:
                            this.h = u6.a(obtainStyledAttributes, index, this.h);
                            continue;
                        case 25:
                            this.i = u6.a(obtainStyledAttributes, index, this.i);
                            continue;
                        case 26:
                            this.E = obtainStyledAttributes.getInt(index, this.E);
                            continue;
                        case 27:
                            this.G = obtainStyledAttributes.getDimensionPixelSize(index, this.G);
                            continue;
                        case 28:
                            this.j = u6.a(obtainStyledAttributes, index, this.j);
                            continue;
                        case 29:
                            this.k = u6.a(obtainStyledAttributes, index, this.k);
                            continue;
                        case 30:
                            int i4 = Build.VERSION.SDK_INT;
                            this.K = obtainStyledAttributes.getDimensionPixelSize(index, this.K);
                            continue;
                        case 31:
                            this.s = u6.a(obtainStyledAttributes, index, this.s);
                            continue;
                        case 32:
                            this.t = u6.a(obtainStyledAttributes, index, this.t);
                            continue;
                        case 33:
                            this.H = obtainStyledAttributes.getDimensionPixelSize(index, this.H);
                            continue;
                        case 34:
                            this.m = u6.a(obtainStyledAttributes, index, this.m);
                            continue;
                        case 35:
                            this.l = u6.a(obtainStyledAttributes, index, this.l);
                            continue;
                        case 36:
                            this.x = obtainStyledAttributes.getFloat(index, this.x);
                            continue;
                        case 37:
                            this.U = obtainStyledAttributes.getFloat(index, this.U);
                            continue;
                        case 38:
                            this.T = obtainStyledAttributes.getFloat(index, this.T);
                            continue;
                        case 39:
                            this.V = obtainStyledAttributes.getInt(index, this.V);
                            continue;
                        case 40:
                            this.W = obtainStyledAttributes.getInt(index, this.W);
                            continue;
                        case 41:
                            u6.a(this, obtainStyledAttributes, index, 0);
                            continue;
                        case 42:
                            u6.a(this, obtainStyledAttributes, index, 1);
                            continue;
                        default:
                            switch (i2) {
                                case 54:
                                    this.X = obtainStyledAttributes.getInt(index, this.X);
                                    continue;
                                case 55:
                                    this.Y = obtainStyledAttributes.getInt(index, this.Y);
                                    continue;
                                case 56:
                                    this.Z = obtainStyledAttributes.getDimensionPixelSize(index, this.Z);
                                    continue;
                                case 57:
                                    this.a0 = obtainStyledAttributes.getDimensionPixelSize(index, this.a0);
                                    continue;
                                case 58:
                                    this.b0 = obtainStyledAttributes.getDimensionPixelSize(index, this.b0);
                                    continue;
                                case 59:
                                    this.c0 = obtainStyledAttributes.getDimensionPixelSize(index, this.c0);
                                    continue;
                                default:
                                    switch (i2) {
                                        case 61:
                                            this.z = u6.a(obtainStyledAttributes, index, this.z);
                                            continue;
                                        case 62:
                                            this.A = obtainStyledAttributes.getDimensionPixelSize(index, this.A);
                                            continue;
                                        case 63:
                                            this.B = obtainStyledAttributes.getFloat(index, this.B);
                                            continue;
                                        default:
                                            switch (i2) {
                                                case 69:
                                                    this.d0 = obtainStyledAttributes.getFloat(index, 1.0f);
                                                    continue;
                                                case 70:
                                                    this.e0 = obtainStyledAttributes.getFloat(index, 1.0f);
                                                    continue;
                                                case 71:
                                                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                                    continue;
                                                case 72:
                                                    this.f0 = obtainStyledAttributes.getInt(index, this.f0);
                                                    continue;
                                                case 73:
                                                    this.g0 = obtainStyledAttributes.getDimensionPixelSize(index, this.g0);
                                                    continue;
                                                case 74:
                                                    this.j0 = obtainStyledAttributes.getString(index);
                                                    continue;
                                                case 75:
                                                    this.n0 = obtainStyledAttributes.getBoolean(index, this.n0);
                                                    continue;
                                                case 76:
                                                    StringBuilder a = jg.a("unused attribute 0x");
                                                    a.append(Integer.toHexString(index));
                                                    a.append("   ");
                                                    a.append(p0.get(index));
                                                    Log.w("ConstraintSet", a.toString());
                                                    continue;
                                                case 77:
                                                    this.k0 = obtainStyledAttributes.getString(index);
                                                    continue;
                                                default:
                                                    switch (i2) {
                                                        case 91:
                                                            this.q = u6.a(obtainStyledAttributes, index, this.q);
                                                            continue;
                                                        case 92:
                                                            this.r = u6.a(obtainStyledAttributes, index, this.r);
                                                            continue;
                                                        case 93:
                                                            this.L = obtainStyledAttributes.getDimensionPixelSize(index, this.L);
                                                            continue;
                                                        case 94:
                                                            this.S = obtainStyledAttributes.getDimensionPixelSize(index, this.S);
                                                            continue;
                                                        default:
                                                            StringBuilder a2 = jg.a("Unknown attribute 0x");
                                                            a2.append(Integer.toHexString(index));
                                                            a2.append("   ");
                                                            a2.append(p0.get(index));
                                                            Log.w("ConstraintSet", a2.toString());
                                                            continue;
                                                            continue;
                                                            continue;
                                                            continue;
                                                            continue;
                                                    }
                                            }
                                    }
                            }
                    }
                } else {
                    this.o0 = obtainStyledAttributes.getInt(index, this.o0);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public static void a(ConstraintLayout.a params, String value) {
        float f2 = Float.NaN;
        int i = -1;
        if (value != null) {
            int length = value.length();
            int indexOf = value.indexOf(44);
            int i2 = 0;
            if (indexOf > 0 && indexOf < length - 1) {
                String substring = value.substring(0, indexOf);
                if (substring.equalsIgnoreCase("W")) {
                    i = 0;
                } else if (substring.equalsIgnoreCase("H")) {
                    i = 1;
                }
                i2 = indexOf + 1;
            }
            int indexOf2 = value.indexOf(58);
            try {
                if (indexOf2 >= 0 && indexOf2 < length - 1) {
                    String substring2 = value.substring(i2, indexOf2);
                    String substring3 = value.substring(indexOf2 + 1);
                    if (substring2.length() > 0 && substring3.length() > 0) {
                        float parseFloat = Float.parseFloat(substring2);
                        float parseFloat2 = Float.parseFloat(substring3);
                        if (parseFloat > XToggleDrawable.LIGHT_RADIUS_DEFAULT && parseFloat2 > XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
                            if (i == 1) {
                                f2 = Math.abs(parseFloat2 / parseFloat);
                            } else {
                                f2 = Math.abs(parseFloat / parseFloat2);
                            }
                        }
                    }
                } else {
                    String substring4 = value.substring(i2);
                    if (substring4.length() > 0) {
                        f2 = Float.parseFloat(substring4);
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        params.F = value;
        params.G = f2;
        params.H = i;
    }

    public void a(Context context, int constraintLayoutId) {
        u6 u6Var = this;
        ConstraintLayout constraintLayout = (ConstraintLayout) LayoutInflater.from(context).inflate(constraintLayoutId, (ViewGroup) null);
        int childCount = constraintLayout.getChildCount();
        u6Var.c.clear();
        int i = 0;
        while (i < childCount) {
            View childAt = constraintLayout.getChildAt(i);
            ConstraintLayout.a aVar = (ConstraintLayout.a) childAt.getLayoutParams();
            int id = childAt.getId();
            if (u6Var.b && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!u6Var.c.containsKey(Integer.valueOf(id))) {
                u6Var.c.put(Integer.valueOf(id), new a());
            }
            a aVar2 = u6Var.c.get(Integer.valueOf(id));
            if (aVar2 != null) {
                HashMap<String, r6> hashMap = u6Var.a;
                HashMap<String, r6> hashMap2 = new HashMap<>();
                Class<?> cls = childAt.getClass();
                for (String str : hashMap.keySet()) {
                    r6 r6Var = hashMap.get(str);
                    try {
                    } catch (IllegalAccessException e2) {
                        e = e2;
                    } catch (NoSuchMethodException e3) {
                        e = e3;
                    } catch (InvocationTargetException e4) {
                        e = e4;
                    }
                    if (str.equals("BackgroundColor")) {
                        hashMap2.put(str, new r6(r6Var, Integer.valueOf(((ColorDrawable) childAt.getBackground()).getColor())));
                    } else {
                        try {
                            hashMap2.put(str, new r6(r6Var, cls.getMethod("getMap" + str, new Class[0]).invoke(childAt, new Object[0])));
                        } catch (IllegalAccessException e5) {
                            e = e5;
                            e.printStackTrace();
                        } catch (NoSuchMethodException e6) {
                            e = e6;
                            e.printStackTrace();
                        } catch (InvocationTargetException e7) {
                            e = e7;
                            e.printStackTrace();
                        }
                    }
                }
                aVar2.f = hashMap2;
                aVar2.a(id, aVar);
                aVar2.b.b = childAt.getVisibility();
                int i2 = Build.VERSION.SDK_INT;
                aVar2.b.d = childAt.getAlpha();
                aVar2.e.b = childAt.getRotation();
                aVar2.e.c = childAt.getRotationX();
                aVar2.e.d = childAt.getRotationY();
                aVar2.e.e = childAt.getScaleX();
                aVar2.e.f = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != XLoadingDrawable.DEFAULT_RADIANS || pivotY != XLoadingDrawable.DEFAULT_RADIANS) {
                    e eVar = aVar2.e;
                    eVar.g = pivotX;
                    eVar.h = pivotY;
                }
                aVar2.e.j = childAt.getTranslationX();
                aVar2.e.k = childAt.getTranslationY();
                int i3 = Build.VERSION.SDK_INT;
                aVar2.e.l = childAt.getTranslationZ();
                e eVar2 = aVar2.e;
                if (eVar2.m) {
                    eVar2.n = childAt.getElevation();
                }
                if (childAt instanceof q6) {
                    q6 q6Var = (q6) childAt;
                    aVar2.d.n0 = q6Var.getAllowsGoneWidget();
                    aVar2.d.i0 = q6Var.getReferencedIds();
                    aVar2.d.f0 = q6Var.getType();
                    aVar2.d.g0 = q6Var.getMargin();
                }
            }
            i++;
            u6Var = this;
        }
    }

    public void a(v6 constraints) {
        int childCount = constraints.getChildCount();
        this.c.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraints.getChildAt(i);
            v6.a aVar = (v6.a) childAt.getLayoutParams();
            int id = childAt.getId();
            if (this.b && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.c.containsKey(Integer.valueOf(id))) {
                this.c.put(Integer.valueOf(id), new a());
            }
            a aVar2 = this.c.get(Integer.valueOf(id));
            if (aVar2 != null) {
                if (childAt instanceof s6) {
                    s6 s6Var = (s6) childAt;
                    aVar2.a(id, aVar);
                    if (s6Var instanceof q6) {
                        b bVar = aVar2.d;
                        bVar.h0 = 1;
                        q6 q6Var = (q6) s6Var;
                        bVar.f0 = q6Var.getType();
                        aVar2.d.i0 = q6Var.getReferencedIds();
                        aVar2.d.g0 = q6Var.getMargin();
                    }
                }
                aVar2.a(id, aVar);
            }
        }
    }

    public void a(ConstraintLayout constraintLayout, boolean applyPostLayout) {
        View findViewById;
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.c.keySet());
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            int id = childAt.getId();
            if (!this.c.containsKey(Integer.valueOf(id))) {
                StringBuilder a2 = jg.a("id unknown ");
                a2.append(defpackage.a.a(childAt));
                Log.w("ConstraintSet", a2.toString());
            } else if (this.b && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else {
                if (id != -1) {
                    if (this.c.containsKey(Integer.valueOf(id))) {
                        hashSet.remove(Integer.valueOf(id));
                        a aVar = this.c.get(Integer.valueOf(id));
                        if (aVar != null) {
                            if (childAt instanceof q6) {
                                aVar.d.h0 = 1;
                                q6 q6Var = (q6) childAt;
                                q6Var.setId(id);
                                q6Var.setType(aVar.d.f0);
                                q6Var.setMargin(aVar.d.g0);
                                q6Var.setAllowsGoneWidget(aVar.d.n0);
                                b bVar = aVar.d;
                                int[] iArr = bVar.i0;
                                if (iArr != null) {
                                    q6Var.setReferencedIds(iArr);
                                } else {
                                    String str = bVar.j0;
                                    if (str != null) {
                                        bVar.i0 = a(q6Var, str);
                                        q6Var.setReferencedIds(aVar.d.i0);
                                    }
                                }
                            }
                            ConstraintLayout.a aVar2 = (ConstraintLayout.a) childAt.getLayoutParams();
                            aVar2.a();
                            aVar.a(aVar2);
                            if (applyPostLayout) {
                                r6.a(childAt, aVar.f);
                            }
                            childAt.setLayoutParams(aVar2);
                            d dVar = aVar.b;
                            if (dVar.c == 0) {
                                childAt.setVisibility(dVar.b);
                            }
                            int i2 = Build.VERSION.SDK_INT;
                            childAt.setAlpha(aVar.b.d);
                            childAt.setRotation(aVar.e.b);
                            childAt.setRotationX(aVar.e.c);
                            childAt.setRotationY(aVar.e.d);
                            childAt.setScaleX(aVar.e.e);
                            childAt.setScaleY(aVar.e.f);
                            e eVar = aVar.e;
                            if (eVar.i != -1) {
                                if (((View) childAt.getParent()).findViewById(aVar.e.i) != null) {
                                    float bottom = (findViewById.getBottom() + findViewById.getTop()) / 2.0f;
                                    float right = (findViewById.getRight() + findViewById.getLeft()) / 2.0f;
                                    if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                        childAt.setPivotX(right - childAt.getLeft());
                                        childAt.setPivotY(bottom - childAt.getTop());
                                    }
                                }
                            } else {
                                if (!Float.isNaN(eVar.g)) {
                                    childAt.setPivotX(aVar.e.g);
                                }
                                if (!Float.isNaN(aVar.e.h)) {
                                    childAt.setPivotY(aVar.e.h);
                                }
                            }
                            childAt.setTranslationX(aVar.e.j);
                            childAt.setTranslationY(aVar.e.k);
                            int i3 = Build.VERSION.SDK_INT;
                            childAt.setTranslationZ(aVar.e.l);
                            e eVar2 = aVar.e;
                            if (eVar2.m) {
                                childAt.setElevation(eVar2.n);
                            }
                        }
                    } else {
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id);
                    }
                }
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            a aVar3 = this.c.get(num);
            if (aVar3 != null) {
                if (aVar3.d.h0 == 1) {
                    q6 q6Var2 = new q6(constraintLayout.getContext());
                    q6Var2.setId(num.intValue());
                    b bVar2 = aVar3.d;
                    int[] iArr2 = bVar2.i0;
                    if (iArr2 != null) {
                        q6Var2.setReferencedIds(iArr2);
                    } else {
                        String str2 = bVar2.j0;
                        if (str2 != null) {
                            bVar2.i0 = a(q6Var2, str2);
                            q6Var2.setReferencedIds(aVar3.d.i0);
                        }
                    }
                    q6Var2.setType(aVar3.d.f0);
                    q6Var2.setMargin(aVar3.d.g0);
                    ConstraintLayout.a generateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                    q6Var2.e();
                    aVar3.a(generateDefaultLayoutParams);
                    constraintLayout.addView(q6Var2, generateDefaultLayoutParams);
                }
                if (aVar3.d.a) {
                    View x6Var = new x6(constraintLayout.getContext());
                    x6Var.setId(num.intValue());
                    ConstraintLayout.a generateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                    aVar3.a(generateDefaultLayoutParams2);
                    constraintLayout.addView(x6Var, generateDefaultLayoutParams2);
                }
            }
        }
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt2 = constraintLayout.getChildAt(i4);
            if (childAt2 instanceof s6) {
                ((s6) childAt2).b(constraintLayout);
            }
        }
    }

    public static /* synthetic */ int a(TypedArray typedArray, int i, int i2) {
        int resourceId = typedArray.getResourceId(i, i2);
        return resourceId == -1 ? typedArray.getInt(i, -1) : resourceId;
    }

    public final a a(Context context, AttributeSet attrs, boolean override) {
        a aVar = new a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, override ? a7.ConstraintOverride : a7.Constraint);
        int i = 0;
        int i2 = 1;
        if (override) {
            int indexCount = obtainStyledAttributes.getIndexCount();
            a.C0012a c0012a = new a.C0012a();
            aVar.g = c0012a;
            aVar.c.a = false;
            aVar.d.b = false;
            aVar.b.a = false;
            aVar.e.a = false;
            int i3 = 3;
            int i4 = 0;
            while (i < indexCount) {
                int index = obtainStyledAttributes.getIndex(i);
                switch (f.get(index)) {
                    case 2:
                        c0012a.a(2, obtainStyledAttributes.getDimensionPixelSize(index, aVar.d.I));
                        break;
                    case 3:
                    case 4:
                    case 9:
                    case 10:
                    case 25:
                    case 26:
                    case 29:
                    case 30:
                    case 32:
                    case 33:
                    case 35:
                    case 36:
                    case 61:
                    case 88:
                    case 89:
                    case 90:
                    case 91:
                    case 92:
                    default:
                        StringBuilder a2 = jg.a("Unknown attribute 0x");
                        a2.append(Integer.toHexString(index));
                        a2.append("   ");
                        a2.append(e.get(index));
                        Log.w("ConstraintSet", a2.toString());
                        break;
                    case 5:
                        c0012a.a(5, obtainStyledAttributes.getString(index));
                        break;
                    case 6:
                        c0012a.a(6, obtainStyledAttributes.getDimensionPixelOffset(index, aVar.d.C));
                        break;
                    case 7:
                        c0012a.a(7, obtainStyledAttributes.getDimensionPixelOffset(index, aVar.d.D));
                        break;
                    case 8:
                        int i5 = Build.VERSION.SDK_INT;
                        c0012a.a(8, obtainStyledAttributes.getDimensionPixelSize(index, aVar.d.J));
                        break;
                    case 11:
                        c0012a.a(11, obtainStyledAttributes.getDimensionPixelSize(index, aVar.d.P));
                        break;
                    case 12:
                        c0012a.a(12, obtainStyledAttributes.getDimensionPixelSize(index, aVar.d.Q));
                        break;
                    case 13:
                        c0012a.a(13, obtainStyledAttributes.getDimensionPixelSize(index, aVar.d.M));
                        break;
                    case 14:
                        c0012a.a(14, obtainStyledAttributes.getDimensionPixelSize(index, aVar.d.O));
                        break;
                    case 15:
                        c0012a.a(15, obtainStyledAttributes.getDimensionPixelSize(index, aVar.d.R));
                        break;
                    case 16:
                        c0012a.a(16, obtainStyledAttributes.getDimensionPixelSize(index, aVar.d.N));
                        break;
                    case 17:
                        c0012a.a(17, obtainStyledAttributes.getDimensionPixelOffset(index, aVar.d.e));
                        break;
                    case 18:
                        c0012a.a(18, obtainStyledAttributes.getDimensionPixelOffset(index, aVar.d.f));
                        break;
                    case 19:
                        c0012a.a(19, obtainStyledAttributes.getFloat(index, aVar.d.g));
                        break;
                    case 20:
                        c0012a.a(20, obtainStyledAttributes.getFloat(index, aVar.d.w));
                        break;
                    case 21:
                        c0012a.a(21, obtainStyledAttributes.getLayoutDimension(index, aVar.d.d));
                        break;
                    case 22:
                        c0012a.a(22, d[obtainStyledAttributes.getInt(index, aVar.b.b)]);
                        break;
                    case 23:
                        c0012a.a(23, obtainStyledAttributes.getLayoutDimension(index, aVar.d.c));
                        break;
                    case 24:
                        c0012a.a(24, obtainStyledAttributes.getDimensionPixelSize(index, aVar.d.F));
                        break;
                    case 27:
                        c0012a.a(27, obtainStyledAttributes.getInt(index, aVar.d.E));
                        break;
                    case 28:
                        c0012a.a(28, obtainStyledAttributes.getDimensionPixelSize(index, aVar.d.G));
                        break;
                    case 31:
                        int i6 = Build.VERSION.SDK_INT;
                        c0012a.a(31, obtainStyledAttributes.getDimensionPixelSize(index, aVar.d.K));
                        break;
                    case 34:
                        c0012a.a(34, obtainStyledAttributes.getDimensionPixelSize(index, aVar.d.H));
                        break;
                    case 37:
                        c0012a.a(37, obtainStyledAttributes.getFloat(index, aVar.d.x));
                        break;
                    case 38:
                        aVar.a = obtainStyledAttributes.getResourceId(index, aVar.a);
                        c0012a.a(38, aVar.a);
                        break;
                    case 39:
                        c0012a.a(39, obtainStyledAttributes.getFloat(index, aVar.d.U));
                        break;
                    case 40:
                        c0012a.a(40, obtainStyledAttributes.getFloat(index, aVar.d.T));
                        break;
                    case 41:
                        c0012a.a(41, obtainStyledAttributes.getInt(index, aVar.d.V));
                        break;
                    case 42:
                        c0012a.a(42, obtainStyledAttributes.getInt(index, aVar.d.W));
                        break;
                    case 43:
                        c0012a.a(43, obtainStyledAttributes.getFloat(index, aVar.b.d));
                        break;
                    case 44:
                        int i7 = Build.VERSION.SDK_INT;
                        c0012a.a(44, true);
                        c0012a.a(44, obtainStyledAttributes.getDimension(index, aVar.e.n));
                        break;
                    case 45:
                        c0012a.a(45, obtainStyledAttributes.getFloat(index, aVar.e.c));
                        break;
                    case 46:
                        c0012a.a(46, obtainStyledAttributes.getFloat(index, aVar.e.d));
                        break;
                    case 47:
                        c0012a.a(47, obtainStyledAttributes.getFloat(index, aVar.e.e));
                        break;
                    case 48:
                        c0012a.a(48, obtainStyledAttributes.getFloat(index, aVar.e.f));
                        break;
                    case 49:
                        c0012a.a(49, obtainStyledAttributes.getDimension(index, aVar.e.g));
                        break;
                    case 50:
                        c0012a.a(50, obtainStyledAttributes.getDimension(index, aVar.e.h));
                        break;
                    case 51:
                        c0012a.a(51, obtainStyledAttributes.getDimension(index, aVar.e.j));
                        break;
                    case 52:
                        c0012a.a(52, obtainStyledAttributes.getDimension(index, aVar.e.k));
                        break;
                    case 53:
                        int i8 = Build.VERSION.SDK_INT;
                        c0012a.a(53, obtainStyledAttributes.getDimension(index, aVar.e.l));
                        break;
                    case 54:
                        c0012a.a(54, obtainStyledAttributes.getInt(index, aVar.d.X));
                        break;
                    case 55:
                        c0012a.a(55, obtainStyledAttributes.getInt(index, aVar.d.Y));
                        break;
                    case 56:
                        c0012a.a(56, obtainStyledAttributes.getDimensionPixelSize(index, aVar.d.Z));
                        break;
                    case 57:
                        c0012a.a(57, obtainStyledAttributes.getDimensionPixelSize(index, aVar.d.a0));
                        break;
                    case 58:
                        c0012a.a(58, obtainStyledAttributes.getDimensionPixelSize(index, aVar.d.b0));
                        break;
                    case 59:
                        c0012a.a(59, obtainStyledAttributes.getDimensionPixelSize(index, aVar.d.c0));
                        break;
                    case 60:
                        c0012a.a(60, obtainStyledAttributes.getFloat(index, aVar.e.b));
                        break;
                    case 62:
                        c0012a.a(62, obtainStyledAttributes.getDimensionPixelSize(index, aVar.d.A));
                        break;
                    case 63:
                        c0012a.a(63, obtainStyledAttributes.getFloat(index, aVar.d.B));
                        break;
                    case 64:
                        int resourceId = obtainStyledAttributes.getResourceId(index, aVar.c.b);
                        if (resourceId == -1) {
                            resourceId = obtainStyledAttributes.getInt(index, -1);
                        }
                        c0012a.a(64, resourceId);
                        break;
                    case 65:
                        if (obtainStyledAttributes.peekValue(index).type == 3) {
                            c0012a.a(65, obtainStyledAttributes.getString(index));
                            break;
                        } else {
                            c0012a.a(65, o5.c[obtainStyledAttributes.getInteger(index, i4)]);
                            break;
                        }
                    case 66:
                        c0012a.a(66, obtainStyledAttributes.getInt(index, 0));
                        break;
                    case 67:
                        c0012a.a(67, obtainStyledAttributes.getFloat(index, aVar.c.i));
                        break;
                    case 68:
                        c0012a.a(68, obtainStyledAttributes.getFloat(index, aVar.b.e));
                        break;
                    case 69:
                        c0012a.a(69, obtainStyledAttributes.getFloat(index, 1.0f));
                        break;
                    case 70:
                        c0012a.a(70, obtainStyledAttributes.getFloat(index, 1.0f));
                        break;
                    case 71:
                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                        break;
                    case 72:
                        c0012a.a(72, obtainStyledAttributes.getInt(index, aVar.d.f0));
                        break;
                    case 73:
                        c0012a.a(73, obtainStyledAttributes.getDimensionPixelSize(index, aVar.d.g0));
                        break;
                    case 74:
                        c0012a.a(74, obtainStyledAttributes.getString(index));
                        break;
                    case 75:
                        c0012a.a(75, obtainStyledAttributes.getBoolean(index, aVar.d.n0));
                        break;
                    case 76:
                        c0012a.a(76, obtainStyledAttributes.getInt(index, aVar.c.e));
                        break;
                    case 77:
                        c0012a.a(77, obtainStyledAttributes.getString(index));
                        break;
                    case 78:
                        c0012a.a(78, obtainStyledAttributes.getInt(index, aVar.b.c));
                        break;
                    case 79:
                        c0012a.a(79, obtainStyledAttributes.getFloat(index, aVar.c.g));
                        break;
                    case 80:
                        c0012a.a(80, obtainStyledAttributes.getBoolean(index, aVar.d.l0));
                        break;
                    case 81:
                        c0012a.a(81, obtainStyledAttributes.getBoolean(index, aVar.d.m0));
                        break;
                    case 82:
                        c0012a.a(82, obtainStyledAttributes.getInteger(index, aVar.c.c));
                        break;
                    case 83:
                        int resourceId2 = obtainStyledAttributes.getResourceId(index, aVar.e.i);
                        if (resourceId2 == -1) {
                            resourceId2 = obtainStyledAttributes.getInt(index, -1);
                        }
                        c0012a.a(83, resourceId2);
                        break;
                    case 84:
                        c0012a.a(84, obtainStyledAttributes.getInteger(index, aVar.c.k));
                        break;
                    case 85:
                        c0012a.a(85, obtainStyledAttributes.getFloat(index, aVar.c.j));
                        break;
                    case 86:
                        int i9 = obtainStyledAttributes.peekValue(index).type;
                        if (i9 == i2) {
                            aVar.c.n = obtainStyledAttributes.getResourceId(index, -1);
                            c0012a.a(89, aVar.c.n);
                            c cVar = aVar.c;
                            if (cVar.n != -1) {
                                cVar.m = -2;
                                c0012a.a(88, cVar.m);
                                break;
                            } else {
                                break;
                            }
                        } else if (i9 == 3) {
                            aVar.c.l = obtainStyledAttributes.getString(index);
                            c0012a.a(90, aVar.c.l);
                            if (aVar.c.l.indexOf("/") > 0) {
                                aVar.c.n = obtainStyledAttributes.getResourceId(index, -1);
                                c0012a.a(89, aVar.c.n);
                                c cVar2 = aVar.c;
                                cVar2.m = -2;
                                c0012a.a(88, cVar2.m);
                                break;
                            } else {
                                c cVar3 = aVar.c;
                                cVar3.m = -1;
                                c0012a.a(88, cVar3.m);
                                break;
                            }
                        } else {
                            c cVar4 = aVar.c;
                            cVar4.m = obtainStyledAttributes.getInteger(index, cVar4.n);
                            c0012a.a(88, aVar.c.m);
                            break;
                        }
                    case 87:
                        StringBuilder a3 = jg.a("unused attribute 0x");
                        a3.append(Integer.toHexString(index));
                        a3.append("   ");
                        a3.append(e.get(index));
                        Log.w("ConstraintSet", a3.toString());
                        break;
                    case 93:
                        c0012a.a(93, obtainStyledAttributes.getDimensionPixelSize(index, aVar.d.L));
                        break;
                    case 94:
                        c0012a.a(94, obtainStyledAttributes.getDimensionPixelSize(index, aVar.d.S));
                        break;
                    case 95:
                        a(c0012a, obtainStyledAttributes, index, i4);
                        break;
                    case 96:
                        a(c0012a, obtainStyledAttributes, index, i2);
                        break;
                    case 97:
                        c0012a.a(97, obtainStyledAttributes.getInt(index, aVar.d.o0));
                        break;
                    case 98:
                        if (obtainStyledAttributes.peekValue(index).type == i3) {
                            obtainStyledAttributes.getString(index);
                            break;
                        } else {
                            aVar.a = obtainStyledAttributes.getResourceId(index, aVar.a);
                            break;
                        }
                }
                i++;
                i3 = 3;
                i4 = 0;
                i2 = 1;
            }
        } else {
            int indexCount2 = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount2; i10++) {
                int index2 = obtainStyledAttributes.getIndex(i10);
                if (index2 != a7.Constraint_android_id && a7.Constraint_android_layout_marginStart != index2 && a7.Constraint_android_layout_marginEnd != index2) {
                    aVar.c.a = true;
                    aVar.d.b = true;
                    aVar.b.a = true;
                    aVar.e.a = true;
                }
                switch (e.get(index2)) {
                    case 1:
                        b bVar = aVar.d;
                        int resourceId3 = obtainStyledAttributes.getResourceId(index2, bVar.p);
                        if (resourceId3 == -1) {
                            resourceId3 = obtainStyledAttributes.getInt(index2, -1);
                        }
                        bVar.p = resourceId3;
                        break;
                    case 2:
                        b bVar2 = aVar.d;
                        bVar2.I = obtainStyledAttributes.getDimensionPixelSize(index2, bVar2.I);
                        break;
                    case 3:
                        b bVar3 = aVar.d;
                        int resourceId4 = obtainStyledAttributes.getResourceId(index2, bVar3.o);
                        if (resourceId4 == -1) {
                            resourceId4 = obtainStyledAttributes.getInt(index2, -1);
                        }
                        bVar3.o = resourceId4;
                        break;
                    case 4:
                        b bVar4 = aVar.d;
                        int resourceId5 = obtainStyledAttributes.getResourceId(index2, bVar4.n);
                        if (resourceId5 == -1) {
                            resourceId5 = obtainStyledAttributes.getInt(index2, -1);
                        }
                        bVar4.n = resourceId5;
                        break;
                    case 5:
                        aVar.d.y = obtainStyledAttributes.getString(index2);
                        break;
                    case 6:
                        b bVar5 = aVar.d;
                        bVar5.C = obtainStyledAttributes.getDimensionPixelOffset(index2, bVar5.C);
                        break;
                    case 7:
                        b bVar6 = aVar.d;
                        bVar6.D = obtainStyledAttributes.getDimensionPixelOffset(index2, bVar6.D);
                        break;
                    case 8:
                        int i11 = Build.VERSION.SDK_INT;
                        b bVar7 = aVar.d;
                        bVar7.J = obtainStyledAttributes.getDimensionPixelSize(index2, bVar7.J);
                        break;
                    case 9:
                        b bVar8 = aVar.d;
                        int resourceId6 = obtainStyledAttributes.getResourceId(index2, bVar8.v);
                        if (resourceId6 == -1) {
                            resourceId6 = obtainStyledAttributes.getInt(index2, -1);
                        }
                        bVar8.v = resourceId6;
                        break;
                    case 10:
                        b bVar9 = aVar.d;
                        int resourceId7 = obtainStyledAttributes.getResourceId(index2, bVar9.u);
                        if (resourceId7 == -1) {
                            resourceId7 = obtainStyledAttributes.getInt(index2, -1);
                        }
                        bVar9.u = resourceId7;
                        break;
                    case 11:
                        b bVar10 = aVar.d;
                        bVar10.P = obtainStyledAttributes.getDimensionPixelSize(index2, bVar10.P);
                        break;
                    case 12:
                        b bVar11 = aVar.d;
                        bVar11.Q = obtainStyledAttributes.getDimensionPixelSize(index2, bVar11.Q);
                        break;
                    case 13:
                        b bVar12 = aVar.d;
                        bVar12.M = obtainStyledAttributes.getDimensionPixelSize(index2, bVar12.M);
                        break;
                    case 14:
                        b bVar13 = aVar.d;
                        bVar13.O = obtainStyledAttributes.getDimensionPixelSize(index2, bVar13.O);
                        break;
                    case 15:
                        b bVar14 = aVar.d;
                        bVar14.R = obtainStyledAttributes.getDimensionPixelSize(index2, bVar14.R);
                        break;
                    case 16:
                        b bVar15 = aVar.d;
                        bVar15.N = obtainStyledAttributes.getDimensionPixelSize(index2, bVar15.N);
                        break;
                    case 17:
                        b bVar16 = aVar.d;
                        bVar16.e = obtainStyledAttributes.getDimensionPixelOffset(index2, bVar16.e);
                        break;
                    case 18:
                        b bVar17 = aVar.d;
                        bVar17.f = obtainStyledAttributes.getDimensionPixelOffset(index2, bVar17.f);
                        break;
                    case 19:
                        b bVar18 = aVar.d;
                        bVar18.g = obtainStyledAttributes.getFloat(index2, bVar18.g);
                        break;
                    case 20:
                        b bVar19 = aVar.d;
                        bVar19.w = obtainStyledAttributes.getFloat(index2, bVar19.w);
                        break;
                    case 21:
                        b bVar20 = aVar.d;
                        bVar20.d = obtainStyledAttributes.getLayoutDimension(index2, bVar20.d);
                        break;
                    case 22:
                        d dVar = aVar.b;
                        dVar.b = obtainStyledAttributes.getInt(index2, dVar.b);
                        d dVar2 = aVar.b;
                        dVar2.b = d[dVar2.b];
                        break;
                    case 23:
                        b bVar21 = aVar.d;
                        bVar21.c = obtainStyledAttributes.getLayoutDimension(index2, bVar21.c);
                        break;
                    case 24:
                        b bVar22 = aVar.d;
                        bVar22.F = obtainStyledAttributes.getDimensionPixelSize(index2, bVar22.F);
                        break;
                    case 25:
                        b bVar23 = aVar.d;
                        int resourceId8 = obtainStyledAttributes.getResourceId(index2, bVar23.h);
                        if (resourceId8 == -1) {
                            resourceId8 = obtainStyledAttributes.getInt(index2, -1);
                        }
                        bVar23.h = resourceId8;
                        break;
                    case 26:
                        b bVar24 = aVar.d;
                        int resourceId9 = obtainStyledAttributes.getResourceId(index2, bVar24.i);
                        if (resourceId9 == -1) {
                            resourceId9 = obtainStyledAttributes.getInt(index2, -1);
                        }
                        bVar24.i = resourceId9;
                        break;
                    case 27:
                        b bVar25 = aVar.d;
                        bVar25.E = obtainStyledAttributes.getInt(index2, bVar25.E);
                        break;
                    case 28:
                        b bVar26 = aVar.d;
                        bVar26.G = obtainStyledAttributes.getDimensionPixelSize(index2, bVar26.G);
                        break;
                    case 29:
                        b bVar27 = aVar.d;
                        int resourceId10 = obtainStyledAttributes.getResourceId(index2, bVar27.j);
                        if (resourceId10 == -1) {
                            resourceId10 = obtainStyledAttributes.getInt(index2, -1);
                        }
                        bVar27.j = resourceId10;
                        break;
                    case 30:
                        b bVar28 = aVar.d;
                        int resourceId11 = obtainStyledAttributes.getResourceId(index2, bVar28.k);
                        if (resourceId11 == -1) {
                            resourceId11 = obtainStyledAttributes.getInt(index2, -1);
                        }
                        bVar28.k = resourceId11;
                        break;
                    case 31:
                        int i12 = Build.VERSION.SDK_INT;
                        b bVar29 = aVar.d;
                        bVar29.K = obtainStyledAttributes.getDimensionPixelSize(index2, bVar29.K);
                        break;
                    case 32:
                        b bVar30 = aVar.d;
                        int resourceId12 = obtainStyledAttributes.getResourceId(index2, bVar30.s);
                        if (resourceId12 == -1) {
                            resourceId12 = obtainStyledAttributes.getInt(index2, -1);
                        }
                        bVar30.s = resourceId12;
                        break;
                    case 33:
                        b bVar31 = aVar.d;
                        int resourceId13 = obtainStyledAttributes.getResourceId(index2, bVar31.t);
                        if (resourceId13 == -1) {
                            resourceId13 = obtainStyledAttributes.getInt(index2, -1);
                        }
                        bVar31.t = resourceId13;
                        break;
                    case 34:
                        b bVar32 = aVar.d;
                        bVar32.H = obtainStyledAttributes.getDimensionPixelSize(index2, bVar32.H);
                        break;
                    case 35:
                        b bVar33 = aVar.d;
                        int resourceId14 = obtainStyledAttributes.getResourceId(index2, bVar33.m);
                        if (resourceId14 == -1) {
                            resourceId14 = obtainStyledAttributes.getInt(index2, -1);
                        }
                        bVar33.m = resourceId14;
                        break;
                    case 36:
                        b bVar34 = aVar.d;
                        int resourceId15 = obtainStyledAttributes.getResourceId(index2, bVar34.l);
                        if (resourceId15 == -1) {
                            resourceId15 = obtainStyledAttributes.getInt(index2, -1);
                        }
                        bVar34.l = resourceId15;
                        break;
                    case 37:
                        b bVar35 = aVar.d;
                        bVar35.x = obtainStyledAttributes.getFloat(index2, bVar35.x);
                        break;
                    case 38:
                        aVar.a = obtainStyledAttributes.getResourceId(index2, aVar.a);
                        break;
                    case 39:
                        b bVar36 = aVar.d;
                        bVar36.U = obtainStyledAttributes.getFloat(index2, bVar36.U);
                        break;
                    case 40:
                        b bVar37 = aVar.d;
                        bVar37.T = obtainStyledAttributes.getFloat(index2, bVar37.T);
                        break;
                    case 41:
                        b bVar38 = aVar.d;
                        bVar38.V = obtainStyledAttributes.getInt(index2, bVar38.V);
                        break;
                    case 42:
                        b bVar39 = aVar.d;
                        bVar39.W = obtainStyledAttributes.getInt(index2, bVar39.W);
                        break;
                    case 43:
                        d dVar3 = aVar.b;
                        dVar3.d = obtainStyledAttributes.getFloat(index2, dVar3.d);
                        break;
                    case 44:
                        int i13 = Build.VERSION.SDK_INT;
                        e eVar = aVar.e;
                        eVar.m = true;
                        eVar.n = obtainStyledAttributes.getDimension(index2, eVar.n);
                        break;
                    case 45:
                        e eVar2 = aVar.e;
                        eVar2.c = obtainStyledAttributes.getFloat(index2, eVar2.c);
                        break;
                    case 46:
                        e eVar3 = aVar.e;
                        eVar3.d = obtainStyledAttributes.getFloat(index2, eVar3.d);
                        break;
                    case 47:
                        e eVar4 = aVar.e;
                        eVar4.e = obtainStyledAttributes.getFloat(index2, eVar4.e);
                        break;
                    case 48:
                        e eVar5 = aVar.e;
                        eVar5.f = obtainStyledAttributes.getFloat(index2, eVar5.f);
                        break;
                    case 49:
                        e eVar6 = aVar.e;
                        eVar6.g = obtainStyledAttributes.getDimension(index2, eVar6.g);
                        break;
                    case 50:
                        e eVar7 = aVar.e;
                        eVar7.h = obtainStyledAttributes.getDimension(index2, eVar7.h);
                        break;
                    case 51:
                        e eVar8 = aVar.e;
                        eVar8.j = obtainStyledAttributes.getDimension(index2, eVar8.j);
                        break;
                    case 52:
                        e eVar9 = aVar.e;
                        eVar9.k = obtainStyledAttributes.getDimension(index2, eVar9.k);
                        break;
                    case 53:
                        int i14 = Build.VERSION.SDK_INT;
                        e eVar10 = aVar.e;
                        eVar10.l = obtainStyledAttributes.getDimension(index2, eVar10.l);
                        break;
                    case 54:
                        b bVar40 = aVar.d;
                        bVar40.X = obtainStyledAttributes.getInt(index2, bVar40.X);
                        break;
                    case 55:
                        b bVar41 = aVar.d;
                        bVar41.Y = obtainStyledAttributes.getInt(index2, bVar41.Y);
                        break;
                    case 56:
                        b bVar42 = aVar.d;
                        bVar42.Z = obtainStyledAttributes.getDimensionPixelSize(index2, bVar42.Z);
                        break;
                    case 57:
                        b bVar43 = aVar.d;
                        bVar43.a0 = obtainStyledAttributes.getDimensionPixelSize(index2, bVar43.a0);
                        break;
                    case 58:
                        b bVar44 = aVar.d;
                        bVar44.b0 = obtainStyledAttributes.getDimensionPixelSize(index2, bVar44.b0);
                        break;
                    case 59:
                        b bVar45 = aVar.d;
                        bVar45.c0 = obtainStyledAttributes.getDimensionPixelSize(index2, bVar45.c0);
                        break;
                    case 60:
                        e eVar11 = aVar.e;
                        eVar11.b = obtainStyledAttributes.getFloat(index2, eVar11.b);
                        break;
                    case 61:
                        b bVar46 = aVar.d;
                        int resourceId16 = obtainStyledAttributes.getResourceId(index2, bVar46.z);
                        if (resourceId16 == -1) {
                            resourceId16 = obtainStyledAttributes.getInt(index2, -1);
                        }
                        bVar46.z = resourceId16;
                        break;
                    case 62:
                        b bVar47 = aVar.d;
                        bVar47.A = obtainStyledAttributes.getDimensionPixelSize(index2, bVar47.A);
                        break;
                    case 63:
                        b bVar48 = aVar.d;
                        bVar48.B = obtainStyledAttributes.getFloat(index2, bVar48.B);
                        break;
                    case 64:
                        c cVar5 = aVar.c;
                        int resourceId17 = obtainStyledAttributes.getResourceId(index2, cVar5.b);
                        if (resourceId17 == -1) {
                            resourceId17 = obtainStyledAttributes.getInt(index2, -1);
                        }
                        cVar5.b = resourceId17;
                        break;
                    case 65:
                        if (obtainStyledAttributes.peekValue(index2).type == 3) {
                            aVar.c.d = obtainStyledAttributes.getString(index2);
                            break;
                        } else {
                            aVar.c.d = o5.c[obtainStyledAttributes.getInteger(index2, 0)];
                            break;
                        }
                    case 66:
                        aVar.c.f = obtainStyledAttributes.getInt(index2, 0);
                        break;
                    case 67:
                        c cVar6 = aVar.c;
                        cVar6.i = obtainStyledAttributes.getFloat(index2, cVar6.i);
                        break;
                    case 68:
                        d dVar4 = aVar.b;
                        dVar4.e = obtainStyledAttributes.getFloat(index2, dVar4.e);
                        break;
                    case 69:
                        aVar.d.d0 = obtainStyledAttributes.getFloat(index2, 1.0f);
                        break;
                    case 70:
                        aVar.d.e0 = obtainStyledAttributes.getFloat(index2, 1.0f);
                        break;
                    case 71:
                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                        break;
                    case 72:
                        b bVar49 = aVar.d;
                        bVar49.f0 = obtainStyledAttributes.getInt(index2, bVar49.f0);
                        break;
                    case 73:
                        b bVar50 = aVar.d;
                        bVar50.g0 = obtainStyledAttributes.getDimensionPixelSize(index2, bVar50.g0);
                        break;
                    case 74:
                        aVar.d.j0 = obtainStyledAttributes.getString(index2);
                        break;
                    case 75:
                        b bVar51 = aVar.d;
                        bVar51.n0 = obtainStyledAttributes.getBoolean(index2, bVar51.n0);
                        break;
                    case 76:
                        c cVar7 = aVar.c;
                        cVar7.e = obtainStyledAttributes.getInt(index2, cVar7.e);
                        break;
                    case 77:
                        aVar.d.k0 = obtainStyledAttributes.getString(index2);
                        break;
                    case 78:
                        d dVar5 = aVar.b;
                        dVar5.c = obtainStyledAttributes.getInt(index2, dVar5.c);
                        break;
                    case 79:
                        c cVar8 = aVar.c;
                        cVar8.g = obtainStyledAttributes.getFloat(index2, cVar8.g);
                        break;
                    case 80:
                        b bVar52 = aVar.d;
                        bVar52.l0 = obtainStyledAttributes.getBoolean(index2, bVar52.l0);
                        break;
                    case 81:
                        b bVar53 = aVar.d;
                        bVar53.m0 = obtainStyledAttributes.getBoolean(index2, bVar53.m0);
                        break;
                    case 82:
                        c cVar9 = aVar.c;
                        cVar9.c = obtainStyledAttributes.getInteger(index2, cVar9.c);
                        break;
                    case 83:
                        e eVar12 = aVar.e;
                        int resourceId18 = obtainStyledAttributes.getResourceId(index2, eVar12.i);
                        if (resourceId18 == -1) {
                            resourceId18 = obtainStyledAttributes.getInt(index2, -1);
                        }
                        eVar12.i = resourceId18;
                        break;
                    case 84:
                        c cVar10 = aVar.c;
                        cVar10.k = obtainStyledAttributes.getInteger(index2, cVar10.k);
                        break;
                    case 85:
                        c cVar11 = aVar.c;
                        cVar11.j = obtainStyledAttributes.getFloat(index2, cVar11.j);
                        break;
                    case 86:
                        int i15 = obtainStyledAttributes.peekValue(index2).type;
                        if (i15 == 1) {
                            aVar.c.n = obtainStyledAttributes.getResourceId(index2, -1);
                            c cVar12 = aVar.c;
                            if (cVar12.n != -1) {
                                cVar12.m = -2;
                                break;
                            } else {
                                break;
                            }
                        } else if (i15 == 3) {
                            aVar.c.l = obtainStyledAttributes.getString(index2);
                            if (aVar.c.l.indexOf("/") > 0) {
                                aVar.c.n = obtainStyledAttributes.getResourceId(index2, -1);
                                aVar.c.m = -2;
                                break;
                            } else {
                                aVar.c.m = -1;
                                break;
                            }
                        } else {
                            c cVar13 = aVar.c;
                            cVar13.m = obtainStyledAttributes.getInteger(index2, cVar13.n);
                            break;
                        }
                    case 87:
                        StringBuilder a4 = jg.a("unused attribute 0x");
                        a4.append(Integer.toHexString(index2));
                        a4.append("   ");
                        a4.append(e.get(index2));
                        Log.w("ConstraintSet", a4.toString());
                        break;
                    case 88:
                    case 89:
                    case 90:
                    default:
                        StringBuilder a5 = jg.a("Unknown attribute 0x");
                        a5.append(Integer.toHexString(index2));
                        a5.append("   ");
                        a5.append(e.get(index2));
                        Log.w("ConstraintSet", a5.toString());
                        break;
                    case 91:
                        b bVar54 = aVar.d;
                        int resourceId19 = obtainStyledAttributes.getResourceId(index2, bVar54.q);
                        if (resourceId19 == -1) {
                            resourceId19 = obtainStyledAttributes.getInt(index2, -1);
                        }
                        bVar54.q = resourceId19;
                        break;
                    case 92:
                        b bVar55 = aVar.d;
                        int resourceId20 = obtainStyledAttributes.getResourceId(index2, bVar55.r);
                        if (resourceId20 == -1) {
                            resourceId20 = obtainStyledAttributes.getInt(index2, -1);
                        }
                        bVar55.r = resourceId20;
                        break;
                    case 93:
                        b bVar56 = aVar.d;
                        bVar56.L = obtainStyledAttributes.getDimensionPixelSize(index2, bVar56.L);
                        break;
                    case 94:
                        b bVar57 = aVar.d;
                        bVar57.S = obtainStyledAttributes.getDimensionPixelSize(index2, bVar57.S);
                        break;
                    case 95:
                        a(aVar.d, obtainStyledAttributes, index2, 0);
                        break;
                    case 96:
                        a(aVar.d, obtainStyledAttributes, index2, 1);
                        break;
                    case 97:
                        b bVar58 = aVar.d;
                        bVar58.o0 = obtainStyledAttributes.getInt(index2, bVar58.o0);
                        break;
                }
            }
        }
        obtainStyledAttributes.recycle();
        return aVar;
    }

    public final int[] a(View view, String referenceIdString) {
        int i;
        Object a2;
        String[] split = referenceIdString.split(CFCHelper.SIGNAL_CFC_SPLIT);
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i2 = 0;
        int i3 = 0;
        while (i2 < split.length) {
            String trim = split[i2].trim();
            try {
                i = z6.class.getField(trim).getInt(null);
            } catch (Exception unused) {
                i = 0;
            }
            if (i == 0) {
                i = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (a2 = ((ConstraintLayout) view.getParent()).a(0, trim)) != null && (a2 instanceof Integer)) {
                i = ((Integer) a2).intValue();
            }
            iArr[i3] = i;
            i2++;
            i3++;
        }
        return i3 != split.length ? Arrays.copyOf(iArr, i3) : iArr;
    }
}
