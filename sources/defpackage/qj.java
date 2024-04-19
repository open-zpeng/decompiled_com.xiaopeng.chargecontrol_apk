package defpackage;

import android.util.Log;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* compiled from: GlideException.java */
/* renamed from: qj  reason: default package */
/* loaded from: classes.dex */
public final class qj extends Exception {
    public static final StackTraceElement[] h = new StackTraceElement[0];
    public final List<Throwable> c;
    public zh d;
    public uh e;
    public Class<?> f;
    public String g;

    public qj(String str) {
        List<Throwable> emptyList = Collections.emptyList();
        this.g = str;
        setStackTrace(h);
        this.c = emptyList;
    }

    public static void b(List<Throwable> list, Appendable appendable) {
        int size = list.size();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            appendable.append("Cause (").append(String.valueOf(i2)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th = list.get(i);
            if (th instanceof qj) {
                ((qj) th).a(appendable);
            } else {
                a(th, appendable);
            }
            i = i2;
        }
    }

    public void a(Exception exc) {
    }

    public void a(zh zhVar, uh uhVar, Class<?> cls) {
        this.d = zhVar;
        this.e = uhVar;
        this.f = cls;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder(71);
        sb.append(this.g);
        String str3 = "";
        if (this.f != null) {
            StringBuilder a2 = jg.a(", ");
            a2.append(this.f);
            str = a2.toString();
        } else {
            str = "";
        }
        sb.append(str);
        if (this.e != null) {
            StringBuilder a3 = jg.a(", ");
            a3.append(this.e);
            str2 = a3.toString();
        } else {
            str2 = "";
        }
        sb.append(str2);
        if (this.d != null) {
            StringBuilder a4 = jg.a(", ");
            a4.append(this.d);
            str3 = a4.toString();
        }
        sb.append(str3);
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        if (arrayList.isEmpty()) {
            return sb.toString();
        }
        if (arrayList.size() == 1) {
            sb.append("\nThere was 1 cause:");
        } else {
            sb.append("\nThere were ");
            sb.append(arrayList.size());
            sb.append(" causes:");
        }
        for (Throwable th : arrayList) {
            sb.append('\n');
            sb.append(th.getClass().getName());
            sb.append('(');
            sb.append(th.getMessage());
            sb.append(')');
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        a(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        a(printStream);
    }

    public void a(String str) {
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            StringBuilder a2 = jg.a("Root cause (");
            int i2 = i + 1;
            a2.append(i2);
            a2.append(" of ");
            a2.append(size);
            a2.append(")");
            Log.i(str, a2.toString(), arrayList.get(i));
            i = i2;
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        a(printWriter);
    }

    /* compiled from: GlideException.java */
    /* renamed from: qj$a */
    /* loaded from: classes.dex */
    public static final class a implements Appendable {
        public final Appendable c;
        public boolean d = true;

        public a(Appendable appendable) {
            this.c = appendable;
        }

        @Override // java.lang.Appendable
        public Appendable append(char c) {
            if (this.d) {
                this.d = false;
                this.c.append("  ");
            }
            this.d = c == '\n';
            this.c.append(c);
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence) {
            if (charSequence == null) {
                charSequence = "";
            }
            append(charSequence, 0, charSequence.length());
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence, int i, int i2) {
            if (charSequence == null) {
                charSequence = "";
            }
            boolean z = false;
            if (this.d) {
                this.d = false;
                this.c.append("  ");
            }
            if (charSequence.length() > 0 && charSequence.charAt(i2 - 1) == '\n') {
                z = true;
            }
            this.d = z;
            this.c.append(charSequence, i, i2);
            return this;
        }
    }

    public qj(String str, Throwable th) {
        List<Throwable> singletonList = Collections.singletonList(th);
        this.g = str;
        setStackTrace(h);
        this.c = singletonList;
    }

    public final void a(Throwable th, List<Throwable> list) {
        if (th instanceof qj) {
            for (Throwable th2 : ((qj) th).c) {
                a(th2, list);
            }
            return;
        }
        list.add(th);
    }

    public qj(String str, List<Throwable> list) {
        this.g = str;
        setStackTrace(h);
        this.c = list;
    }

    public final void a(Appendable appendable) {
        a(this, appendable);
        a(this.c, new a(appendable));
    }

    public static void a(Throwable th, Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append('\n');
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    public static void a(List<Throwable> list, Appendable appendable) {
        try {
            b(list, appendable);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
