package defpackage;

import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import defpackage.ki;
import java.io.IOException;
/* compiled from: ParcelFileDescriptorRewinder.java */
/* renamed from: si  reason: default package */
/* loaded from: classes.dex */
public final class si implements ki<ParcelFileDescriptor> {
    public final b a;

    /* compiled from: ParcelFileDescriptorRewinder.java */
    /* renamed from: si$b */
    /* loaded from: classes.dex */
    public static final class b {
        public final ParcelFileDescriptor a;

        public b(ParcelFileDescriptor parcelFileDescriptor) {
            this.a = parcelFileDescriptor;
        }

        public ParcelFileDescriptor a() {
            try {
                Os.lseek(this.a.getFileDescriptor(), 0L, OsConstants.SEEK_SET);
                return this.a;
            } catch (ErrnoException e) {
                throw new IOException(e);
            }
        }
    }

    public si(ParcelFileDescriptor parcelFileDescriptor) {
        this.a = new b(parcelFileDescriptor);
    }

    @Override // defpackage.ki
    public void b() {
    }

    /* compiled from: ParcelFileDescriptorRewinder.java */
    /* renamed from: si$a */
    /* loaded from: classes.dex */
    public static final class a implements ki.a<ParcelFileDescriptor> {
        @Override // defpackage.ki.a
        public ki<ParcelFileDescriptor> a(ParcelFileDescriptor parcelFileDescriptor) {
            return new si(parcelFileDescriptor);
        }

        @Override // defpackage.ki.a
        public Class<ParcelFileDescriptor> a() {
            return ParcelFileDescriptor.class;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // defpackage.ki
    public ParcelFileDescriptor a() {
        return this.a.a();
    }
}
