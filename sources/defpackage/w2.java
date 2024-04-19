package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import defpackage.d4;
/* compiled from: AppCompatDrawableManager.java */
/* renamed from: w2  reason: default package */
/* loaded from: classes.dex */
public final class w2 {
    public static final PorterDuff.Mode b = PorterDuff.Mode.SRC_IN;
    public static w2 c;
    public d4 a;

    public static synchronized w2 a() {
        w2 w2Var;
        synchronized (w2.class) {
            if (c == null) {
                b();
            }
            w2Var = c;
        }
        return w2Var;
    }

    public static synchronized void b() {
        synchronized (w2.class) {
            if (c == null) {
                c = new w2();
                c.a = d4.a();
                c.a.a(new a());
            }
        }
    }

    public synchronized Drawable a(Context context, int i) {
        return this.a.b(context, i);
    }

    public synchronized Drawable a(Context context, int i, boolean z) {
        return this.a.a(context, i, z);
    }

    public synchronized void a(Context context) {
        this.a.a(context);
    }

    public synchronized ColorStateList b(Context context, int i) {
        return this.a.c(context, i);
    }

    public static void a(Drawable drawable, l4 l4Var, int[] iArr) {
        d4.a(drawable, l4Var, iArr);
    }

    /* compiled from: AppCompatDrawableManager.java */
    /* renamed from: w2$a */
    /* loaded from: classes.dex */
    public class a implements d4.c {
        public final int[] a = {d0.abc_textfield_search_default_mtrl_alpha, d0.abc_textfield_default_mtrl_alpha, d0.abc_ab_share_pack_mtrl_alpha};
        public final int[] b = {d0.abc_ic_commit_search_api_mtrl_alpha, d0.abc_seekbar_tick_mark_material, d0.abc_ic_menu_share_mtrl_alpha, d0.abc_ic_menu_copy_mtrl_am_alpha, d0.abc_ic_menu_cut_mtrl_alpha, d0.abc_ic_menu_selectall_mtrl_alpha, d0.abc_ic_menu_paste_mtrl_am_alpha};
        public final int[] c = {d0.abc_textfield_activated_mtrl_alpha, d0.abc_textfield_search_activated_mtrl_alpha, d0.abc_cab_background_top_mtrl_alpha, d0.abc_text_cursor_material, d0.abc_text_select_handle_left_mtrl, d0.abc_text_select_handle_middle_mtrl, d0.abc_text_select_handle_right_mtrl};
        public final int[] d = {d0.abc_popup_background_mtrl_mult, d0.abc_cab_background_internal_bg, d0.abc_menu_hardkey_panel_mtrl_mult};
        public final int[] e = {d0.abc_tab_indicator_material, d0.abc_textfield_search_material};
        public final int[] f = {d0.abc_btn_check_material, d0.abc_btn_radio_material, d0.abc_btn_check_material_anim, d0.abc_btn_radio_material_anim};

        public final ColorStateList a(Context context, int i) {
            int b = i4.b(context, z.colorControlHighlight);
            return new ColorStateList(new int[][]{i4.b, i4.d, i4.c, i4.f}, new int[]{i4.a(context, z.colorButtonNormal), w7.a(b, i), w7.a(b, i), i});
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0063 A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean b(android.content.Context r7, int r8, android.graphics.drawable.Drawable r9) {
            /*
                r6 = this;
                android.graphics.PorterDuff$Mode r0 = defpackage.w2.b
                int[] r1 = r6.a
                boolean r1 = r6.a(r1, r8)
                r2 = 16842801(0x1010031, float:2.3693695E-38)
                r3 = -1
                r4 = 0
                r5 = 1
                if (r1 == 0) goto L16
                int r2 = defpackage.z.colorControlNormal
            L12:
                r1 = r0
                r0 = r3
            L14:
                r8 = r5
                goto L46
            L16:
                int[] r1 = r6.c
                boolean r1 = r6.a(r1, r8)
                if (r1 == 0) goto L21
                int r2 = defpackage.z.colorControlActivated
                goto L12
            L21:
                int[] r1 = r6.d
                boolean r1 = r6.a(r1, r8)
                if (r1 == 0) goto L2c
                android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
                goto L12
            L2c:
                int r1 = defpackage.d0.abc_list_divider_mtrl_alpha
                if (r8 != r1) goto L3d
                r2 = 16842800(0x1010030, float:2.3693693E-38)
                r8 = 1109603123(0x42233333, float:40.8)
                int r8 = java.lang.Math.round(r8)
                r1 = r0
                r0 = r8
                goto L14
            L3d:
                int r1 = defpackage.d0.abc_dialog_material_background
                if (r8 != r1) goto L42
                goto L12
            L42:
                r1 = r0
                r0 = r3
                r8 = r4
                r2 = r8
            L46:
                if (r8 == 0) goto L63
                boolean r8 = defpackage.t3.a(r9)
                if (r8 == 0) goto L52
                android.graphics.drawable.Drawable r9 = r9.mutate()
            L52:
                int r7 = defpackage.i4.b(r7, r2)
                android.graphics.PorterDuffColorFilter r7 = defpackage.w2.a(r7, r1)
                r9.setColorFilter(r7)
                if (r0 == r3) goto L62
                r9.setAlpha(r0)
            L62:
                return r5
            L63:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.w2.a.b(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
        }

        public Drawable a(d4 d4Var, Context context, int i) {
            if (i == d0.abc_cab_background_top_material) {
                return new LayerDrawable(new Drawable[]{d4Var.b(context, d0.abc_cab_background_internal_bg), d4Var.b(context, d0.abc_cab_background_top_mtrl_alpha)});
            }
            if (i == d0.abc_ratingbar_material) {
                return b(d4Var, context, c0.abc_star_big);
            }
            if (i == d0.abc_ratingbar_indicator_material) {
                return b(d4Var, context, c0.abc_star_medium);
            }
            if (i == d0.abc_ratingbar_small_material) {
                return b(d4Var, context, c0.abc_star_small);
            }
            return null;
        }

        public final LayerDrawable b(d4 d4Var, Context context, int i) {
            BitmapDrawable bitmapDrawable;
            BitmapDrawable bitmapDrawable2;
            BitmapDrawable bitmapDrawable3;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i);
            Drawable b = d4Var.b(context, d0.abc_star_black_48dp);
            Drawable b2 = d4Var.b(context, d0.abc_star_half_black_48dp);
            if ((b instanceof BitmapDrawable) && b.getIntrinsicWidth() == dimensionPixelSize && b.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable = (BitmapDrawable) b;
                bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
            } else {
                Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                b.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                b.draw(canvas);
                bitmapDrawable = new BitmapDrawable(createBitmap);
                bitmapDrawable2 = new BitmapDrawable(createBitmap);
            }
            bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
            if ((b2 instanceof BitmapDrawable) && b2.getIntrinsicWidth() == dimensionPixelSize && b2.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable3 = (BitmapDrawable) b2;
            } else {
                Bitmap createBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap2);
                b2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                b2.draw(canvas2);
                bitmapDrawable3 = new BitmapDrawable(createBitmap2);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
            layerDrawable.setId(0, 16908288);
            layerDrawable.setId(1, 16908303);
            layerDrawable.setId(2, 16908301);
            return layerDrawable;
        }

        public final void a(Drawable drawable, int i, PorterDuff.Mode mode) {
            if (t3.a(drawable)) {
                drawable = drawable.mutate();
            }
            if (mode == null) {
                mode = w2.b;
            }
            drawable.setColorFilter(w2.a(i, mode));
        }

        public boolean a(Context context, int i, Drawable drawable) {
            if (i == d0.abc_seekbar_track_material) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                a(layerDrawable.findDrawableByLayerId(16908288), i4.b(context, z.colorControlNormal), w2.b);
                a(layerDrawable.findDrawableByLayerId(16908303), i4.b(context, z.colorControlNormal), w2.b);
                a(layerDrawable.findDrawableByLayerId(16908301), i4.b(context, z.colorControlActivated), w2.b);
                return true;
            } else if (i == d0.abc_ratingbar_material || i == d0.abc_ratingbar_indicator_material || i == d0.abc_ratingbar_small_material) {
                LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                a(layerDrawable2.findDrawableByLayerId(16908288), i4.a(context, z.colorControlNormal), w2.b);
                a(layerDrawable2.findDrawableByLayerId(16908303), i4.b(context, z.colorControlActivated), w2.b);
                a(layerDrawable2.findDrawableByLayerId(16908301), i4.b(context, z.colorControlActivated), w2.b);
                return true;
            } else {
                return false;
            }
        }

        public ColorStateList b(Context context, int i) {
            if (i == d0.abc_edit_text_material) {
                return i1.a(context, b0.abc_tint_edittext);
            }
            if (i == d0.abc_switch_track_mtrl_alpha) {
                return i1.a(context, b0.abc_tint_switch_track);
            }
            if (i == d0.abc_switch_thumb_material) {
                int[][] iArr = new int[3];
                int[] iArr2 = new int[3];
                ColorStateList c = i4.c(context, z.colorSwitchThumbNormal);
                if (c != null && c.isStateful()) {
                    iArr[0] = i4.b;
                    iArr2[0] = c.getColorForState(iArr[0], 0);
                    iArr[1] = i4.e;
                    iArr2[1] = i4.b(context, z.colorControlActivated);
                    iArr[2] = i4.f;
                    iArr2[2] = c.getDefaultColor();
                } else {
                    iArr[0] = i4.b;
                    iArr2[0] = i4.a(context, z.colorSwitchThumbNormal);
                    iArr[1] = i4.e;
                    iArr2[1] = i4.b(context, z.colorControlActivated);
                    iArr[2] = i4.f;
                    iArr2[2] = i4.b(context, z.colorSwitchThumbNormal);
                }
                return new ColorStateList(iArr, iArr2);
            } else if (i == d0.abc_btn_default_mtrl_shape) {
                return a(context, i4.b(context, z.colorButtonNormal));
            } else {
                if (i == d0.abc_btn_borderless_material) {
                    return a(context, 0);
                }
                if (i == d0.abc_btn_colored_material) {
                    return a(context, i4.b(context, z.colorAccent));
                }
                if (i != d0.abc_spinner_mtrl_am_alpha && i != d0.abc_spinner_textfield_background_material) {
                    if (a(this.b, i)) {
                        return i4.c(context, z.colorControlNormal);
                    }
                    if (a(this.e, i)) {
                        return i1.a(context, b0.abc_tint_default);
                    }
                    if (a(this.f, i)) {
                        return i1.a(context, b0.abc_tint_btn_checkable);
                    }
                    if (i == d0.abc_seekbar_thumb_material) {
                        return i1.a(context, b0.abc_tint_seek_thumb);
                    }
                    return null;
                }
                return i1.a(context, b0.abc_tint_spinner);
            }
        }

        public final boolean a(int[] iArr, int i) {
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
            return false;
        }

        public PorterDuff.Mode a(int i) {
            if (i == d0.abc_switch_thumb_material) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }
    }

    public static synchronized PorterDuffColorFilter a(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter a2;
        synchronized (w2.class) {
            a2 = d4.a(i, mode);
        }
        return a2;
    }
}
