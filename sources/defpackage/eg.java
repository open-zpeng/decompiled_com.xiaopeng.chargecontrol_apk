package defpackage;

import android.os.Parcelable;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/* compiled from: VersionedParcel.java */
/* renamed from: eg  reason: default package */
/* loaded from: classes.dex */
public abstract class eg {
    public final y4<String, Method> a;
    public final y4<String, Method> b;
    public final y4<String, Class> c;

    public eg(y4<String, Method> y4Var, y4<String, Method> y4Var2, y4<String, Class> y4Var3) {
        this.a = y4Var;
        this.b = y4Var2;
        this.c = y4Var3;
    }

    public abstract void a();

    public abstract boolean a(int i);

    public boolean a(boolean z, int i) {
        return !a(i) ? z : ((fg) this).e.readInt() != 0;
    }

    public abstract eg b();

    public abstract void b(int i);

    public void b(int i, int i2) {
        b(i2);
        ((fg) this).e.writeInt(i);
    }

    public <T extends gg> T c() {
        String readString = ((fg) this).e.readString();
        if (readString == null) {
            return null;
        }
        try {
            return (T) a(readString).invoke(null, b());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (InvocationTargetException e4) {
            if (e4.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e4.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
        }
    }

    public void d() {
    }

    public int a(int i, int i2) {
        return !a(i2) ? i : ((fg) this).e.readInt();
    }

    public void b(Parcelable parcelable, int i) {
        b(i);
        ((fg) this).e.writeParcelable(parcelable, 0);
    }

    public String a(String str, int i) {
        return !a(i) ? str : ((fg) this).e.readString();
    }

    public final Method b(Class cls) {
        Method orDefault = this.b.getOrDefault(cls.getName(), null);
        if (orDefault == null) {
            Class a = a(cls);
            System.currentTimeMillis();
            Method declaredMethod = a.getDeclaredMethod("write", cls, eg.class);
            this.b.put(cls.getName(), declaredMethod);
            return declaredMethod;
        }
        return orDefault;
    }

    public <T extends Parcelable> T a(T t, int i) {
        return !a(i) ? t : (T) ((fg) this).e.readParcelable(fg.class.getClassLoader());
    }

    public CharSequence a(CharSequence charSequence, int i) {
        return !a(i) ? charSequence : (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((fg) this).e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(gg ggVar) {
        if (ggVar == null) {
            ((fg) this).e.writeString(null);
            return;
        }
        try {
            ((fg) this).e.writeString(a((Class<? extends gg>) ggVar.getClass()).getName());
            eg b = b();
            try {
                b(ggVar.getClass()).invoke(null, ggVar, b);
                b.a();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
            } catch (NoSuchMethodException e3) {
                throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
            } catch (InvocationTargetException e4) {
                if (e4.getCause() instanceof RuntimeException) {
                    throw ((RuntimeException) e4.getCause());
                }
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
            }
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException(ggVar.getClass().getSimpleName() + " does not have a Parcelizer", e5);
        }
    }

    public final Method a(String str) {
        Method orDefault = this.a.getOrDefault(str, null);
        if (orDefault == null) {
            System.currentTimeMillis();
            Method declaredMethod = Class.forName(str, true, eg.class.getClassLoader()).getDeclaredMethod("read", eg.class);
            this.a.put(str, declaredMethod);
            return declaredMethod;
        }
        return orDefault;
    }

    public final Class a(Class<? extends gg> cls) {
        Class orDefault = this.c.getOrDefault(cls.getName(), null);
        if (orDefault == null) {
            Class<?> cls2 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
            this.c.put(cls.getName(), cls2);
            return cls2;
        }
        return orDefault;
    }
}
