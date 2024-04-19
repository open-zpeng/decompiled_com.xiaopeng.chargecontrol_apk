package defpackage;

import android.content.Context;
import com.xiaopeng.libtheme.ThemeWrapper;
import defpackage.d00;
import defpackage.my;
import java.util.Map;
/* compiled from: D55CarVcuControllerCompat.java */
/* renamed from: wz  reason: default package */
/* loaded from: classes.dex */
public class wz extends oz {
    public wz(Context context) {
        super(context);
    }

    @Override // defpackage.oz, defpackage.dz
    public void a(Map<Integer, d00<?>> map) {
        super.a(map);
        map.put(557847080, d00.a(new my.j(), new wy(new int[]{0, 1, 2, 3, 4, 5})));
        map.put(557847081, d00.a(new my.l(), new wy(new int[]{0, 2, 3, 4, 16, 18, 19, 20, 1, 5, 6, 7, 15})));
        map.put(557847087, d00.a(new my.e()));
        map.put(557847054, d00.a(new my.c0()));
        map.put(559944302, d00.a(new my.d0()));
        d00.b b = d00.b(new my.b0());
        b.d = false;
        map.put(557847052, b.a());
        map.put(559944196, d00.a(new my.a(), c00.a, ThemeWrapper.TIMEOUT));
        map.put(559944195, d00.a(new my.b(), c00.b, ThemeWrapper.TIMEOUT));
        map.put(557847127, d00.a(new my.e0()));
        map.put(557847128, d00.a(new my.o0(), new vy(0, 1022)));
        map.put(557847140, d00.a(new my.n(), new vy(0, 1022)));
        map.put(557847123, d00.a(new my.d()));
        map.put(557847141, d00.a(new my.i0()));
    }
}
