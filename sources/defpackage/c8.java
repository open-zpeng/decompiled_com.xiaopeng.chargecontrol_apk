package defpackage;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import java.io.IOException;
/* compiled from: TypefaceCompatApi29Impl.java */
/* renamed from: c8  reason: default package */
/* loaded from: classes.dex */
public class c8 extends d8 {
    @Override // defpackage.d8
    public w8 a(w8[] w8VarArr, int i) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }

    @Override // defpackage.d8
    public Typeface a(Context context, CancellationSignal cancellationSignal, w8[] w8VarArr, int i) {
        ParcelFileDescriptor openFileDescriptor;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            int length = w8VarArr.length;
            FontFamily.Builder builder = null;
            int i2 = 0;
            while (true) {
                int i3 = 1;
                if (i2 >= length) {
                    if (builder == null) {
                        return null;
                    }
                    return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle((i & 1) != 0 ? 700 : 400, (i & 2) != 0 ? 1 : 0)).build();
                }
                w8 w8Var = w8VarArr[i2];
                try {
                    openFileDescriptor = contentResolver.openFileDescriptor(w8Var.a, "r", cancellationSignal);
                } catch (IOException unused) {
                }
                if (openFileDescriptor != null) {
                    try {
                        Font.Builder weight = new Font.Builder(openFileDescriptor).setWeight(w8Var.c);
                        if (!w8Var.d) {
                            i3 = 0;
                        }
                        Font build = weight.setSlant(i3).setTtcIndex(w8Var.b).build();
                        if (builder == null) {
                            builder = new FontFamily.Builder(build);
                        } else {
                            builder.addFont(build);
                        }
                    } catch (Throwable th) {
                        try {
                            openFileDescriptor.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                        break;
                    }
                } else if (openFileDescriptor == null) {
                    i2++;
                }
                openFileDescriptor.close();
                i2++;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // defpackage.d8
    public Typeface a(Context context, Resources resources, int i, String str, int i2) {
        try {
            Font build = new Font.Builder(resources, i).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(build).build()).setStyle(build.getStyle()).build();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // defpackage.d8
    public Typeface a(Context context, r7 r7Var, Resources resources, int i) {
        try {
            s7[] s7VarArr = r7Var.a;
            int length = s7VarArr.length;
            FontFamily.Builder builder = null;
            int i2 = 0;
            while (true) {
                int i3 = 1;
                if (i2 >= length) {
                    break;
                }
                s7 s7Var = s7VarArr[i2];
                try {
                    Font.Builder weight = new Font.Builder(resources, s7Var.f).setWeight(s7Var.b);
                    if (!s7Var.c) {
                        i3 = 0;
                    }
                    Font build = weight.setSlant(i3).setTtcIndex(s7Var.e).setFontVariationSettings(s7Var.d).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(build);
                    } else {
                        builder.addFont(build);
                    }
                } catch (IOException unused) {
                }
                i2++;
            }
            if (builder == null) {
                return null;
            }
            return new Typeface.CustomFallbackBuilder(builder.build()).setStyle(new FontStyle((i & 1) != 0 ? 700 : 400, (i & 2) != 0 ? 1 : 0)).build();
        } catch (Exception unused2) {
            return null;
        }
    }
}
