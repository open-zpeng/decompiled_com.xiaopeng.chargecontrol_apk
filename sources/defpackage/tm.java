package defpackage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import java.util.concurrent.locks.Lock;
/* compiled from: DrawableToBitmapConverter.java */
/* renamed from: tm  reason: default package */
/* loaded from: classes.dex */
public final class tm {
    public static final ek a = new a();

    /* compiled from: DrawableToBitmapConverter.java */
    /* renamed from: tm$a */
    /* loaded from: classes.dex */
    public class a extends fk {
        @Override // defpackage.fk, defpackage.ek
        public void a(Bitmap bitmap) {
        }
    }

    public static vj<Bitmap> a(ek ekVar, Drawable drawable, int i, int i2) {
        Drawable current = drawable.getCurrent();
        boolean z = false;
        Bitmap bitmap = null;
        if (current instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) current).getBitmap();
        } else if (!(current instanceof Animatable)) {
            if (i == Integer.MIN_VALUE && current.getIntrinsicWidth() <= 0) {
                if (Log.isLoggable("DrawableToBitmap", 5)) {
                    Log.w("DrawableToBitmap", "Unable to draw " + current + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
                }
            } else if (i2 == Integer.MIN_VALUE && current.getIntrinsicHeight() <= 0) {
                if (Log.isLoggable("DrawableToBitmap", 5)) {
                    Log.w("DrawableToBitmap", "Unable to draw " + current + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
                }
            } else {
                if (current.getIntrinsicWidth() > 0) {
                    i = current.getIntrinsicWidth();
                }
                if (current.getIntrinsicHeight() > 0) {
                    i2 = current.getIntrinsicHeight();
                }
                Lock lock = fn.d;
                lock.lock();
                Bitmap a2 = ekVar.a(i, i2, Bitmap.Config.ARGB_8888);
                try {
                    Canvas canvas = new Canvas(a2);
                    current.setBounds(0, 0, i, i2);
                    current.draw(canvas);
                    canvas.setBitmap(null);
                    lock.unlock();
                    bitmap = a2;
                } catch (Throwable th) {
                    lock.unlock();
                    throw th;
                }
            }
            z = true;
        }
        if (!z) {
            ekVar = a;
        }
        return km.a(bitmap, ekVar);
    }
}
