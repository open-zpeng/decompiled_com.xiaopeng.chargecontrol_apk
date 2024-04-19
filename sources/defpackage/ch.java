package defpackage;

import android.util.Log;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IRadioController;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
/* compiled from: GifHeaderParser.java */
/* renamed from: ch  reason: default package */
/* loaded from: classes.dex */
public class ch {
    public ByteBuffer b;
    public bh c;
    public final byte[] a = new byte[IRadioController.TEF663x_PCHANNEL];
    public int d = 0;

    public final int[] a(int i) {
        byte[] bArr = new byte[i * 3];
        int[] iArr = null;
        try {
            this.b.get(bArr);
            iArr = new int[IRadioController.TEF663x_PCHANNEL];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = i3 + 1;
                int i5 = i4 + 1;
                int i6 = i5 + 1;
                int i7 = i2 + 1;
                iArr[i2] = ((bArr[i3] & 255) << 16) | (-16777216) | ((bArr[i4] & 255) << 8) | (bArr[i5] & 255);
                i3 = i6;
                i2 = i7;
            }
        } catch (BufferUnderflowException e) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e);
            }
            this.c.b = 1;
        }
        return iArr;
    }

    public bh b() {
        int c;
        if (this.b != null) {
            if (a()) {
                return this.c;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                sb.append((char) c());
            }
            if (!sb.toString().startsWith("GIF")) {
                this.c.b = 1;
            } else {
                this.c.f = e();
                this.c.g = e();
                this.c.h = (c() & 128) != 0;
                this.c.i = (int) Math.pow(2.0d, (c & 7) + 1);
                this.c.j = c();
                this.c.k = c();
                if (this.c.h && !a()) {
                    bh bhVar = this.c;
                    bhVar.a = a(bhVar.i);
                    bh bhVar2 = this.c;
                    bhVar2.l = bhVar2.a[bhVar2.j];
                }
            }
            if (!a()) {
                boolean z = false;
                while (!z && !a() && this.c.c <= Integer.MAX_VALUE) {
                    int c2 = c();
                    if (c2 == 33) {
                        int c3 = c();
                        if (c3 == 1) {
                            f();
                        } else if (c3 == 249) {
                            this.c.d = new ah();
                            c();
                            int c4 = c();
                            ah ahVar = this.c.d;
                            ahVar.g = (c4 & 28) >> 2;
                            if (ahVar.g == 0) {
                                ahVar.g = 1;
                            }
                            this.c.d.f = (c4 & 1) != 0;
                            int e = e();
                            if (e < 2) {
                                e = 10;
                            }
                            ah ahVar2 = this.c.d;
                            ahVar2.i = e * 10;
                            ahVar2.h = c();
                            c();
                        } else if (c3 == 254) {
                            f();
                        } else if (c3 != 255) {
                            f();
                        } else {
                            d();
                            StringBuilder sb2 = new StringBuilder();
                            for (int i2 = 0; i2 < 11; i2++) {
                                sb2.append((char) this.a[i2]);
                            }
                            if (sb2.toString().equals("NETSCAPE2.0")) {
                                do {
                                    d();
                                    byte[] bArr = this.a;
                                    if (bArr[0] == 1) {
                                        this.c.m = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
                                    }
                                    if (this.d > 0) {
                                    }
                                } while (!a());
                            } else {
                                f();
                            }
                        }
                    } else if (c2 == 44) {
                        bh bhVar3 = this.c;
                        if (bhVar3.d == null) {
                            bhVar3.d = new ah();
                        }
                        this.c.d.a = e();
                        this.c.d.b = e();
                        this.c.d.c = e();
                        this.c.d.d = e();
                        int c5 = c();
                        boolean z2 = (c5 & 128) != 0;
                        int pow = (int) Math.pow(2.0d, (c5 & 7) + 1);
                        this.c.d.e = (c5 & 64) != 0;
                        if (z2) {
                            this.c.d.k = a(pow);
                        } else {
                            this.c.d.k = null;
                        }
                        this.c.d.j = this.b.position();
                        c();
                        f();
                        if (!a()) {
                            bh bhVar4 = this.c;
                            bhVar4.c++;
                            bhVar4.e.add(bhVar4.d);
                        }
                    } else if (c2 != 59) {
                        this.c.b = 1;
                    } else {
                        z = true;
                    }
                }
                bh bhVar5 = this.c;
                if (bhVar5.c < 0) {
                    bhVar5.b = 1;
                }
            }
            return this.c;
        }
        throw new IllegalStateException("You must call setData() before parseHeader()");
    }

    public final int c() {
        try {
            return this.b.get() & 255;
        } catch (Exception unused) {
            this.c.b = 1;
            return 0;
        }
    }

    public final void d() {
        this.d = c();
        if (this.d > 0) {
            int i = 0;
            int i2 = 0;
            while (i < this.d) {
                try {
                    i2 = this.d - i;
                    this.b.get(this.a, i, i2);
                    i += i2;
                } catch (Exception e) {
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        StringBuilder a = jg.a("Error Reading Block n: ", i, " count: ", i2, " blockSize: ");
                        a.append(this.d);
                        Log.d("GifHeaderParser", a.toString(), e);
                    }
                    this.c.b = 1;
                    return;
                }
            }
        }
    }

    public final int e() {
        return this.b.getShort();
    }

    public final void f() {
        int c;
        do {
            c = c();
            this.b.position(Math.min(this.b.position() + c, this.b.limit()));
        } while (c > 0);
    }

    public final boolean a() {
        return this.c.b != 0;
    }
}
