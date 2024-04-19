package defpackage;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: LazyHeaders.java */
/* renamed from: jl  reason: default package */
/* loaded from: classes.dex */
public final class jl implements hl {
    public final Map<String, List<il>> b;
    public volatile Map<String, String> c;

    /* compiled from: LazyHeaders.java */
    /* renamed from: jl$a */
    /* loaded from: classes.dex */
    public static final class a {
        public static final String b;
        public static final Map<String, List<il>> c;
        public Map<String, List<il>> a = c;

        static {
            String property = System.getProperty("http.agent");
            if (!TextUtils.isEmpty(property)) {
                int length = property.length();
                StringBuilder sb = new StringBuilder(property.length());
                for (int i = 0; i < length; i++) {
                    char charAt = property.charAt(i);
                    if ((charAt > 31 || charAt == '\t') && charAt < 127) {
                        sb.append(charAt);
                    } else {
                        sb.append('?');
                    }
                }
                property = sb.toString();
            }
            b = property;
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(b)) {
                hashMap.put("User-Agent", Collections.singletonList(new b(b)));
            }
            c = Collections.unmodifiableMap(hashMap);
        }
    }

    /* compiled from: LazyHeaders.java */
    /* renamed from: jl$b */
    /* loaded from: classes.dex */
    public static final class b implements il {
        public final String a;

        public b(String str) {
            this.a = str;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.a.equals(((b) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            StringBuilder a = jg.a("StringHeaderFactory{value='");
            a.append(this.a);
            a.append('\'');
            a.append('}');
            return a.toString();
        }
    }

    public jl(Map<String, List<il>> map) {
        this.b = Collections.unmodifiableMap(map);
    }

    @Override // defpackage.hl
    public Map<String, String> a() {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.c = Collections.unmodifiableMap(b());
                }
            }
        }
        return this.c;
    }

    public final Map<String, String> b() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<il>> entry : this.b.entrySet()) {
            List<il> value = entry.getValue();
            StringBuilder sb = new StringBuilder();
            int size = value.size();
            for (int i = 0; i < size; i++) {
                String str = ((b) value.get(i)).a;
                if (!TextUtils.isEmpty(str)) {
                    sb.append(str);
                    if (i != value.size() - 1) {
                        sb.append(',');
                    }
                }
            }
            String sb2 = sb.toString();
            if (!TextUtils.isEmpty(sb2)) {
                hashMap.put(entry.getKey(), sb2);
            }
        }
        return hashMap;
    }

    public boolean equals(Object obj) {
        if (obj instanceof jl) {
            return this.b.equals(((jl) obj).b);
        }
        return false;
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        StringBuilder a2 = jg.a("LazyHeaders{headers=");
        a2.append(this.b);
        a2.append('}');
        return a2.toString();
    }
}
