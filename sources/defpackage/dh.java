package defpackage;

import android.graphics.Bitmap;
import android.util.Log;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IRadioController;
import com.xiaopeng.xui.drawable.XLoadingDrawable;
import defpackage.zg;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
/* compiled from: StandardGifDecoder.java */
/* renamed from: dh  reason: default package */
/* loaded from: classes.dex */
public class dh implements zg {
    public int[] a;
    public final zg.a c;
    public ByteBuffer d;
    public byte[] e;
    public short[] f;
    public byte[] g;
    public byte[] h;
    public byte[] i;
    public int[] j;
    public int k;
    public Bitmap m;
    public boolean n;
    public int o;
    public int p;
    public int q;
    public int r;
    public Boolean s;
    public final int[] b = new int[IRadioController.TEF663x_PCHANNEL];
    public Bitmap.Config t = Bitmap.Config.ARGB_8888;
    public bh l = new bh();

    public dh(zg.a aVar, bh bhVar, ByteBuffer byteBuffer, int i) {
        this.c = aVar;
        a(bhVar, byteBuffer, i);
    }

    @Override // defpackage.zg
    public int a() {
        return this.k;
    }

    @Override // defpackage.zg
    public synchronized Bitmap b() {
        if (this.l.c <= 0 || this.k < 0) {
            if (Log.isLoggable("dh", 3)) {
                Log.d("dh", "Unable to decode frame, frameCount=" + this.l.c + ", framePointer=" + this.k);
            }
            this.o = 1;
        }
        if (this.o != 1 && this.o != 2) {
            this.o = 0;
            if (this.e == null) {
                this.e = ((tn) this.c).a(XLoadingDrawable.ALPHA_MAX);
            }
            ah ahVar = this.l.e.get(this.k);
            int i = this.k - 1;
            ah ahVar2 = i >= 0 ? this.l.e.get(i) : null;
            this.a = ahVar.k != null ? ahVar.k : this.l.a;
            if (this.a == null) {
                if (Log.isLoggable("dh", 3)) {
                    Log.d("dh", "No valid color table found for frame #" + this.k);
                }
                this.o = 1;
                return null;
            }
            if (ahVar.f) {
                System.arraycopy(this.a, 0, this.b, 0, this.a.length);
                this.a = this.b;
                this.a[ahVar.h] = 0;
                if (ahVar.g == 2 && this.k == 0) {
                    this.s = true;
                }
            }
            return a(ahVar, ahVar2);
        }
        if (Log.isLoggable("dh", 3)) {
            Log.d("dh", "Unable to decode frame, status=" + this.o);
        }
        return null;
    }

    @Override // defpackage.zg
    public void c() {
        this.k = (this.k + 1) % this.l.c;
    }

    @Override // defpackage.zg
    public void clear() {
        ck ckVar;
        ck ckVar2;
        ck ckVar3;
        this.l = null;
        byte[] bArr = this.i;
        if (bArr != null && (ckVar3 = ((tn) this.c).b) != null) {
            ((jk) ckVar3).a((jk) bArr);
        }
        int[] iArr = this.j;
        if (iArr != null && (ckVar2 = ((tn) this.c).b) != null) {
            ((jk) ckVar2).a((jk) iArr);
        }
        Bitmap bitmap = this.m;
        if (bitmap != null) {
            ((tn) this.c).a.a(bitmap);
        }
        this.m = null;
        this.d = null;
        this.s = null;
        byte[] bArr2 = this.e;
        if (bArr2 == null || (ckVar = ((tn) this.c).b) == null) {
            return;
        }
        ((jk) ckVar).a((jk) bArr2);
    }

    @Override // defpackage.zg
    public int d() {
        return this.l.c;
    }

    @Override // defpackage.zg
    public int e() {
        int i;
        bh bhVar = this.l;
        int i2 = bhVar.c;
        if (i2 <= 0 || (i = this.k) < 0) {
            return 0;
        }
        if (i < 0 || i >= i2) {
            return -1;
        }
        return bhVar.e.get(i).i;
    }

    @Override // defpackage.zg
    public int f() {
        return (this.j.length * 4) + this.d.limit() + this.i.length;
    }

    @Override // defpackage.zg
    public void g() {
        this.k = -1;
    }

    @Override // defpackage.zg
    public ByteBuffer getData() {
        return this.d;
    }

    public final Bitmap h() {
        Boolean bool = this.s;
        Bitmap a = ((tn) this.c).a(this.r, this.q, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.t);
        a.setHasAlpha(true);
        return a;
    }

    public final int i() {
        return this.d.get() & 255;
    }

    public synchronized void a(bh bhVar, ByteBuffer byteBuffer, int i) {
        int[] iArr;
        if (i > 0) {
            int highestOneBit = Integer.highestOneBit(i);
            this.o = 0;
            this.l = bhVar;
            this.k = -1;
            this.d = byteBuffer.asReadOnlyBuffer();
            this.d.position(0);
            this.d.order(ByteOrder.LITTLE_ENDIAN);
            this.n = false;
            Iterator<ah> it = bhVar.e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().g == 3) {
                    this.n = true;
                    break;
                }
            }
            this.p = highestOneBit;
            int i2 = bhVar.f;
            this.r = i2 / highestOneBit;
            int i3 = bhVar.g;
            this.q = i3 / highestOneBit;
            this.i = ((tn) this.c).a(i2 * i3);
            zg.a aVar = this.c;
            int i4 = this.r * this.q;
            ck ckVar = ((tn) aVar).b;
            if (ckVar == null) {
                iArr = new int[i4];
            } else {
                iArr = (int[]) ((jk) ckVar).b(i4, int[].class);
            }
            this.j = iArr;
        } else {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
        }
    }

    @Override // defpackage.zg
    public void a(Bitmap.Config config) {
        if (config != Bitmap.Config.ARGB_8888 && config != Bitmap.Config.RGB_565) {
            throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
        }
        this.t = config;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0045, code lost:
        if (r3.j == r38.h) goto L33;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Bitmap a(defpackage.ah r38, defpackage.ah r39) {
        /*
            Method dump skipped, instructions count: 1107
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dh.a(ah, ah):android.graphics.Bitmap");
    }
}
