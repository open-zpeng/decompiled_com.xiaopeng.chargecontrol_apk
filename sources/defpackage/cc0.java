package defpackage;

import android.util.ArrayMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
/* compiled from: OverallUtils.java */
/* renamed from: cc0  reason: default package */
/* loaded from: classes.dex */
public class cc0 {
    public static Map<String, String[]> a = new ArrayMap();
    public static Map<String, String[]> b;
    public static Map<String, String[]> c;
    public static Map<String, String[]> d;

    static {
        a.put("com.youku.iot", new String[]{"command://video.control.play", "command://video.control.resume", "command://video.control.pause", "command://video.control.stop", "command://video.forward", "command://video.backward", "command://video.settime", "command://video.control.collect", "command://video.control.collect.cancel", "command://video.control.prev", "command://video.control.next", "command://video.fullscreen", "command://video.fullscreen.exit", "command://video.definition.set", "command://video.play.page.exit", "command://video.play.select"});
        d = new ArrayMap();
        d.put("com.youku.iot", new String[]{"native://com.youku.iot.video.info.query"});
        c = new ArrayMap();
        c.put("com.youku.iot", new String[]{"isPlaying:false|play", "isPlaying:false|continue", "isPlaying:true|pause", "isPlaying:true|stop", "isInPlayPage:true|fastforward", "isInPlayPage:true|backforward", "isInPlayPage:true|settime", "isInPlayPage:true|favor", "isInPlayPage:true|unfavor", "isInPlayPage:true|previous", "isInPlayPage:true|next", "isFullScreen:false|fullscreen", "isFullScreen:true|unfullscreen", "isInPlayPage:true|definition", "isInPlayPage:true|back", "isInPlayPage:true|select"});
        b = new ArrayMap();
        b.put("com.youku.iot", new String[]{"isInPlayPage|isFullScreen|isPlaying|videoDuration|definitions|isLogin"});
    }

    public static List<String> a(String str) {
        if (b.containsKey(str)) {
            return Arrays.asList(b.get(str));
        }
        return null;
    }

    public static List<String> b(String str) {
        if (d.containsKey(str)) {
            return Arrays.asList(d.get(str));
        }
        return null;
    }
}
