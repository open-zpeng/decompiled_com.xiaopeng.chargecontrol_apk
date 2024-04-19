package defpackage;
/* compiled from: ViewModelProvider.java */
/* renamed from: le  reason: default package */
/* loaded from: classes.dex */
public abstract class le extends me implements ke {
    @Override // defpackage.ke
    public <T extends je> T a(Class<T> cls) {
        throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
    }

    public abstract <T extends je> T a(String str, Class<T> cls);
}
