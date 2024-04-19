package defpackage;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: LongSerializationPolicy.java */
/* renamed from: av  reason: default package */
/* loaded from: classes.dex */
public abstract class av {
    public static final av c = new a("DEFAULT", 0);
    public static final av d = new av("STRING", 1) { // from class: av.b
    };
    public static final /* synthetic */ av[] e = {c, d};

    /* compiled from: LongSerializationPolicy.java */
    /* renamed from: av$a */
    /* loaded from: classes.dex */
    public enum a extends av {
        public a(String str, int i) {
            super(str, i, null);
        }
    }

    public /* synthetic */ av(String str, int i, a aVar) {
    }

    public static av valueOf(String str) {
        return (av) Enum.valueOf(av.class, str);
    }

    public static av[] values() {
        return (av[]) e.clone();
    }
}
