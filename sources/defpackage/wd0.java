package defpackage;

import android.util.SparseArray;
/* compiled from: SoundEffectFactory.java */
/* renamed from: wd0  reason: default package */
/* loaded from: classes.dex */
public class wd0 {
    public static SparseArray<yd0> a = new SparseArray<>();

    /* compiled from: SoundEffectFactory.java */
    /* renamed from: wd0$a */
    /* loaded from: classes.dex */
    public static class a extends yd0 {
        public a(String str) {
            super(jg.a("system/media/audio/xiaopeng/cdu/wav/", str), 1, 5);
        }
    }

    static {
        a.put(-1, new a("CDU_touch.wav"));
        a.put(1, new a("CDU_touch.wav"));
        a.put(2, new a("CDU_wheel_scroll_7.wav"));
        a.put(3, new a("CDU_switch_on_2.wav"));
        a.put(4, new a("CDU_switch_off_2.wav"));
        a.put(5, new a("CDU_delete_4.wav"));
        a.clone();
    }
}
