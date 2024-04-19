package defpackage;

import android.os.Parcel;
import android.util.SparseIntArray;
import java.lang.reflect.Method;
/* compiled from: VersionedParcelParcel.java */
/* renamed from: fg  reason: default package */
/* loaded from: classes.dex */
public class fg extends eg {
    public final SparseIntArray d;
    public final Parcel e;
    public final int f;
    public final int g;
    public final String h;
    public int i;
    public int j;
    public int k;

    public fg(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new y4(), new y4(), new y4());
    }

    @Override // defpackage.eg
    public boolean a(int i) {
        while (this.j < this.g) {
            int i2 = this.k;
            if (i2 == i) {
                return true;
            }
            if (String.valueOf(i2).compareTo(String.valueOf(i)) > 0) {
                return false;
            }
            this.e.setDataPosition(this.j);
            int readInt = this.e.readInt();
            this.k = this.e.readInt();
            this.j += readInt;
        }
        return this.k == i;
    }

    @Override // defpackage.eg
    public void b(int i) {
        a();
        this.i = i;
        this.d.put(i, this.e.dataPosition());
        this.e.writeInt(0);
        this.e.writeInt(i);
    }

    public fg(Parcel parcel, int i, int i2, String str, y4<String, Method> y4Var, y4<String, Method> y4Var2, y4<String, Class> y4Var3) {
        super(y4Var, y4Var2, y4Var3);
        this.d = new SparseIntArray();
        this.i = -1;
        this.j = 0;
        this.k = -1;
        this.e = parcel;
        this.f = i;
        this.g = i2;
        this.j = this.f;
        this.h = str;
    }

    @Override // defpackage.eg
    public eg b() {
        Parcel parcel = this.e;
        int dataPosition = parcel.dataPosition();
        int i = this.j;
        if (i == this.f) {
            i = this.g;
        }
        return new fg(parcel, dataPosition, i, jg.a(new StringBuilder(), this.h, "  "), this.a, this.b, this.c);
    }

    @Override // defpackage.eg
    public void a() {
        int i = this.i;
        if (i >= 0) {
            int i2 = this.d.get(i);
            int dataPosition = this.e.dataPosition();
            this.e.setDataPosition(i2);
            this.e.writeInt(dataPosition - i2);
            this.e.setDataPosition(dataPosition);
        }
    }
}
