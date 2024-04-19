package defpackage;

import com.xiaopeng.xui.drawable.XLoadingDrawable;
import defpackage.vr;
import java.util.ArrayList;
import java.util.List;
/* compiled from: DataSet.java */
/* renamed from: ur  reason: default package */
/* loaded from: classes.dex */
public abstract class ur<T extends vr> extends rr<T> {
    public List<T> s;
    public float t;
    public float u;
    public float v;
    public float w;

    /* compiled from: DataSet.java */
    /* renamed from: ur$a */
    /* loaded from: classes.dex */
    public enum a {
        UP,
        DOWN,
        CLOSEST
    }

    public ur(List<T> list, String str) {
        super(str);
        this.s = null;
        this.t = -3.4028235E38f;
        this.u = Float.MAX_VALUE;
        this.v = -3.4028235E38f;
        this.w = Float.MAX_VALUE;
        this.s = list;
        if (this.s == null) {
            this.s = new ArrayList();
        }
        m();
    }

    public void a(T t) {
        if (t.a() < this.u) {
            this.u = t.a();
        }
        if (t.a() > this.t) {
            this.t = t.a();
        }
    }

    public int b(float f, float f2, a aVar) {
        int i;
        T t;
        List<T> list = this.s;
        if (list == null || list.isEmpty()) {
            return -1;
        }
        int i2 = 0;
        int size = this.s.size() - 1;
        while (i2 < size) {
            int i3 = (i2 + size) / 2;
            float b = this.s.get(i3).b() - f;
            int i4 = i3 + 1;
            float abs = Math.abs(b);
            float abs2 = Math.abs(this.s.get(i4).b() - f);
            if (abs2 >= abs) {
                if (abs >= abs2) {
                    double d = b;
                    if (d < XLoadingDrawable.DEFAULT_RADIANS) {
                        if (d < XLoadingDrawable.DEFAULT_RADIANS) {
                        }
                    }
                }
                size = i3;
            }
            i2 = i4;
        }
        if (size != -1) {
            float b2 = this.s.get(size).b();
            if (aVar == a.UP) {
                if (b2 < f && size < this.s.size() - 1) {
                    size++;
                }
            } else if (aVar == a.DOWN && b2 > f && size > 0) {
                size--;
            }
            if (Float.isNaN(f2)) {
                return size;
            }
            while (size > 0 && this.s.get(size - 1).b() == b2) {
                size--;
            }
            float a2 = this.s.get(size).a();
            loop2: while (true) {
                i = size;
                do {
                    size++;
                    if (size >= this.s.size()) {
                        break loop2;
                    }
                    t = this.s.get(size);
                    if (t.b() != b2) {
                        break loop2;
                    }
                } while (Math.abs(t.a() - f2) >= Math.abs(a2 - f2));
                a2 = f2;
            }
            return i;
        }
        return size;
    }

    public T d(int i) {
        return this.s.get(i);
    }

    public void m() {
        List<T> list = this.s;
        if (list == null || list.isEmpty()) {
            return;
        }
        this.t = -3.4028235E38f;
        this.u = Float.MAX_VALUE;
        this.v = -3.4028235E38f;
        this.w = Float.MAX_VALUE;
        for (T t : this.s) {
            if (t != null) {
                if (t.b() < this.w) {
                    this.w = t.b();
                }
                if (t.b() > this.v) {
                    this.v = t.b();
                }
                a((ur<T>) t);
            }
        }
    }

    public int n() {
        return this.s.size();
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        StringBuilder a2 = jg.a("DataSet, label: ");
        String str = this.e;
        if (str == null) {
            str = "";
        }
        a2.append(str);
        a2.append(", entries: ");
        a2.append(this.s.size());
        a2.append("\n");
        stringBuffer2.append(a2.toString());
        stringBuffer.append(stringBuffer2.toString());
        for (int i = 0; i < this.s.size(); i++) {
            stringBuffer.append(this.s.get(i).toString() + " ");
        }
        return stringBuffer.toString();
    }

    public T a(float f, float f2, a aVar) {
        int b = b(f, f2, aVar);
        if (b > -1) {
            return this.s.get(b);
        }
        return null;
    }

    public T a(float f, float f2) {
        return a(f, f2, a.CLOSEST);
    }

    public List<T> b(float f) {
        ArrayList arrayList = new ArrayList();
        int size = this.s.size() - 1;
        int i = 0;
        while (true) {
            if (i > size) {
                break;
            }
            int i2 = (size + i) / 2;
            T t = this.s.get(i2);
            if (f == t.b()) {
                while (i2 > 0 && this.s.get(i2 - 1).b() == f) {
                    i2--;
                }
                int size2 = this.s.size();
                while (i2 < size2) {
                    T t2 = this.s.get(i2);
                    if (t2.b() != f) {
                        break;
                    }
                    arrayList.add(t2);
                    i2++;
                }
            } else if (f > t.b()) {
                i = i2 + 1;
            } else {
                size = i2 - 1;
            }
        }
        return arrayList;
    }
}
