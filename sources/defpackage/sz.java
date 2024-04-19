package defpackage;

import android.content.Context;
import com.xiaopeng.libtheme.ThemeWrapper;
import defpackage.my;
import java.util.Map;
/* compiled from: D21CarVcuControllerCompat.java */
/* renamed from: sz  reason: default package */
/* loaded from: classes.dex */
public class sz extends oz {
    public sz(Context context) {
        super(context);
    }

    @Override // defpackage.oz, defpackage.dz
    public void a(Map<Integer, d00<?>> map) {
        super.a(map);
        map.put(559944196, d00.a(new my.a(), c00.a, ThemeWrapper.TIMEOUT));
        map.put(559944195, d00.a(new my.b(), c00.b, ThemeWrapper.TIMEOUT));
        map.put(557847087, d00.a(new my.e()));
        map.put(557847080, d00.a(new my.j(), new wy(new int[]{0, 1, 2})));
        map.put(557847081, d00.a(new my.l(), new wy(new int[]{0, 2, 3, 4, 16, 18, 19, 20, 1})));
        map.put(557847123, d00.a(new my.d()));
    }
}
