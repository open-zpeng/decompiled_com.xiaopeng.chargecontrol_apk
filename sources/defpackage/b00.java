package defpackage;

import android.content.Context;
import com.xiaopeng.libtheme.ThemeWrapper;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import defpackage.d00;
import defpackage.my;
import java.util.Map;
/* compiled from: F30CarVcuControllerCompat.java */
/* renamed from: b00  reason: default package */
/* loaded from: classes.dex */
public class b00 extends oz {
    public b00(Context context) {
        super(context);
    }

    @Override // defpackage.oz, defpackage.dz
    public void a(Map<Integer, d00<?>> map) {
        super.a(map);
        map.put(557847080, d00.a(new my.j(), new wy(new int[]{0, 1, 2, 3, 4, 5})));
        map.put(557847081, d00.a(new my.l(), new wy(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 15})));
        map.put(557847059, d00.b(new my.m()).a());
        map.put(559944302, d00.b(new my.c0()).a());
        d00.b b = d00.b(new my.b0());
        b.d = true;
        map.put(557847052, b.a());
        map.put(559944196, d00.a(new my.a()));
        map.put(559944195, d00.a(new my.b()));
        map.put(559944198, d00.a(new my.v()));
        map.put(559944199, d00.a(new my.y()));
        map.put(559944337, d00.a(new my.j0(), c00.e, ThemeWrapper.TIMEOUT));
        d00.b b2 = d00.b(new my.e0());
        b2.d = true;
        map.put(557847127, b2.a());
        map.put(559944315, d00.a(new my.p0(), new xy(XToggleDrawable.LIGHT_RADIUS_DEFAULT, 1638.3f)));
        map.put(559944314, d00.a(new my.o(), new xy(XToggleDrawable.LIGHT_RADIUS_DEFAULT, 1638.3f)));
        map.put(557847123, d00.a(new my.d()));
        map.put(557847141, d00.a(new my.i0()));
        map.put(557847146, d00.a(new my.x()));
        map.put(557847148, d00.a(new my.w()));
        map.put(557847160, d00.a(new my.z()));
        map.put(557847166, d00.a(new my.n0()));
        map.put(557847188, d00.a(new my.u()));
    }
}
