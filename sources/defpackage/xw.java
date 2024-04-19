package defpackage;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
/* compiled from: TypeAdapters.java */
/* renamed from: xw  reason: default package */
/* loaded from: classes.dex */
public final class xw {
    public static final bv<Class> a = new k().nullSafe();
    public static final cv b = new y(Class.class, a);
    public static final bv<BitSet> c = new v().nullSafe();
    public static final cv d = new y(BitSet.class, c);
    public static final bv<Boolean> e = new z();
    public static final bv<Boolean> f = new a0();
    public static final cv g = new yw(Boolean.TYPE, Boolean.class, e);
    public static final bv<Number> h = new b0();
    public static final cv i = new yw(Byte.TYPE, Byte.class, h);
    public static final bv<Number> j = new c0();
    public static final cv k = new yw(Short.TYPE, Short.class, j);
    public static final bv<Number> l = new d0();
    public static final cv m = new yw(Integer.TYPE, Integer.class, l);
    public static final bv<AtomicInteger> n = new e0().nullSafe();
    public static final cv o = new y(AtomicInteger.class, n);
    public static final bv<AtomicBoolean> p = new f0().nullSafe();
    public static final cv q = new y(AtomicBoolean.class, p);
    public static final bv<AtomicIntegerArray> r = new a().nullSafe();
    public static final cv s = new y(AtomicIntegerArray.class, r);
    public static final bv<Number> t = new b();
    public static final bv<Number> u = new c();
    public static final bv<Number> v = new d();
    public static final bv<Number> w = new e();
    public static final cv x = new y(Number.class, w);
    public static final bv<Character> y = new f();
    public static final cv z = new yw(Character.TYPE, Character.class, y);
    public static final bv<String> A = new g();
    public static final bv<BigDecimal> B = new h();
    public static final bv<BigInteger> C = new i();
    public static final cv D = new y(String.class, A);
    public static final bv<StringBuilder> E = new j();
    public static final cv F = new y(StringBuilder.class, E);
    public static final bv<StringBuffer> G = new l();
    public static final cv H = new y(StringBuffer.class, G);
    public static final bv<URL> I = new m();
    public static final cv J = new y(URL.class, I);
    public static final bv<URI> K = new n();
    public static final cv L = new y(URI.class, K);
    public static final bv<InetAddress> M = new o();
    public static final cv N = new ax(InetAddress.class, M);
    public static final bv<UUID> O = new p();
    public static final cv P = new y(UUID.class, O);
    public static final bv<Currency> Q = new q().nullSafe();
    public static final cv R = new y(Currency.class, Q);
    public static final cv S = new r();
    public static final bv<Calendar> T = new s();
    public static final cv U = new zw(Calendar.class, GregorianCalendar.class, T);
    public static final bv<Locale> V = new t();
    public static final cv W = new y(Locale.class, V);
    public static final bv<ru> X = new u();
    public static final cv Y = new ax(ru.class, X);
    public static final cv Z = new w();

    /* compiled from: TypeAdapters.java */
    /* renamed from: xw$a */
    /* loaded from: classes.dex */
    public class a extends bv<AtomicIntegerArray> {
        @Override // defpackage.bv
        public AtomicIntegerArray read(gx gxVar) {
            ArrayList arrayList = new ArrayList();
            gxVar.a();
            while (gxVar.h()) {
                try {
                    arrayList.add(Integer.valueOf(gxVar.m()));
                } catch (NumberFormatException e) {
                    throw new zu(e);
                }
            }
            gxVar.e();
            int size = arrayList.size();
            AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
            for (int i = 0; i < size; i++) {
                atomicIntegerArray.set(i, ((Integer) arrayList.get(i)).intValue());
            }
            return atomicIntegerArray;
        }

        @Override // defpackage.bv
        public void write(ix ixVar, AtomicIntegerArray atomicIntegerArray) {
            AtomicIntegerArray atomicIntegerArray2 = atomicIntegerArray;
            ixVar.b();
            int length = atomicIntegerArray2.length();
            for (int i = 0; i < length; i++) {
                ixVar.a(atomicIntegerArray2.get(i));
            }
            ixVar.d();
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: xw$a0 */
    /* loaded from: classes.dex */
    public class a0 extends bv<Boolean> {
        @Override // defpackage.bv
        public Boolean read(gx gxVar) {
            if (gxVar.s() == hx.NULL) {
                gxVar.p();
                return null;
            }
            return Boolean.valueOf(gxVar.q());
        }

        @Override // defpackage.bv
        public void write(ix ixVar, Boolean bool) {
            Boolean bool2 = bool;
            ixVar.c(bool2 == null ? "null" : bool2.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: xw$b */
    /* loaded from: classes.dex */
    public class b extends bv<Number> {
        @Override // defpackage.bv
        public Number read(gx gxVar) {
            if (gxVar.s() == hx.NULL) {
                gxVar.p();
                return null;
            }
            try {
                return Long.valueOf(gxVar.n());
            } catch (NumberFormatException e) {
                throw new zu(e);
            }
        }

        @Override // defpackage.bv
        public void write(ix ixVar, Number number) {
            ixVar.a(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: xw$b0 */
    /* loaded from: classes.dex */
    public class b0 extends bv<Number> {
        @Override // defpackage.bv
        public Number read(gx gxVar) {
            if (gxVar.s() == hx.NULL) {
                gxVar.p();
                return null;
            }
            try {
                return Byte.valueOf((byte) gxVar.m());
            } catch (NumberFormatException e) {
                throw new zu(e);
            }
        }

        @Override // defpackage.bv
        public void write(ix ixVar, Number number) {
            ixVar.a(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: xw$c */
    /* loaded from: classes.dex */
    public class c extends bv<Number> {
        @Override // defpackage.bv
        public Number read(gx gxVar) {
            if (gxVar.s() == hx.NULL) {
                gxVar.p();
                return null;
            }
            return Float.valueOf((float) gxVar.l());
        }

        @Override // defpackage.bv
        public void write(ix ixVar, Number number) {
            ixVar.a(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: xw$c0 */
    /* loaded from: classes.dex */
    public class c0 extends bv<Number> {
        @Override // defpackage.bv
        public Number read(gx gxVar) {
            if (gxVar.s() == hx.NULL) {
                gxVar.p();
                return null;
            }
            try {
                return Short.valueOf((short) gxVar.m());
            } catch (NumberFormatException e) {
                throw new zu(e);
            }
        }

        @Override // defpackage.bv
        public void write(ix ixVar, Number number) {
            ixVar.a(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: xw$d */
    /* loaded from: classes.dex */
    public class d extends bv<Number> {
        @Override // defpackage.bv
        public Number read(gx gxVar) {
            if (gxVar.s() == hx.NULL) {
                gxVar.p();
                return null;
            }
            return Double.valueOf(gxVar.l());
        }

        @Override // defpackage.bv
        public void write(ix ixVar, Number number) {
            ixVar.a(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: xw$d0 */
    /* loaded from: classes.dex */
    public class d0 extends bv<Number> {
        @Override // defpackage.bv
        public Number read(gx gxVar) {
            if (gxVar.s() == hx.NULL) {
                gxVar.p();
                return null;
            }
            try {
                return Integer.valueOf(gxVar.m());
            } catch (NumberFormatException e) {
                throw new zu(e);
            }
        }

        @Override // defpackage.bv
        public void write(ix ixVar, Number number) {
            ixVar.a(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: xw$e */
    /* loaded from: classes.dex */
    public class e extends bv<Number> {
        @Override // defpackage.bv
        public Number read(gx gxVar) {
            hx s = gxVar.s();
            int ordinal = s.ordinal();
            if (ordinal == 5 || ordinal == 6) {
                return new aw(gxVar.q());
            }
            if (ordinal == 8) {
                gxVar.p();
                return null;
            }
            throw new zu("Expecting number, got: " + s);
        }

        @Override // defpackage.bv
        public void write(ix ixVar, Number number) {
            ixVar.a(number);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: xw$e0 */
    /* loaded from: classes.dex */
    public class e0 extends bv<AtomicInteger> {
        @Override // defpackage.bv
        public AtomicInteger read(gx gxVar) {
            try {
                return new AtomicInteger(gxVar.m());
            } catch (NumberFormatException e) {
                throw new zu(e);
            }
        }

        @Override // defpackage.bv
        public void write(ix ixVar, AtomicInteger atomicInteger) {
            ixVar.a(atomicInteger.get());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: xw$f */
    /* loaded from: classes.dex */
    public class f extends bv<Character> {
        @Override // defpackage.bv
        public Character read(gx gxVar) {
            if (gxVar.s() == hx.NULL) {
                gxVar.p();
                return null;
            }
            String q = gxVar.q();
            if (q.length() == 1) {
                return Character.valueOf(q.charAt(0));
            }
            throw new zu(jg.a("Expecting character, got: ", q));
        }

        @Override // defpackage.bv
        public void write(ix ixVar, Character ch) {
            Character ch2 = ch;
            ixVar.c(ch2 == null ? null : String.valueOf(ch2));
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: xw$f0 */
    /* loaded from: classes.dex */
    public class f0 extends bv<AtomicBoolean> {
        @Override // defpackage.bv
        public AtomicBoolean read(gx gxVar) {
            return new AtomicBoolean(gxVar.k());
        }

        @Override // defpackage.bv
        public void write(ix ixVar, AtomicBoolean atomicBoolean) {
            ixVar.a(atomicBoolean.get());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: xw$g */
    /* loaded from: classes.dex */
    public class g extends bv<String> {
        @Override // defpackage.bv
        public String read(gx gxVar) {
            hx s = gxVar.s();
            if (s == hx.NULL) {
                gxVar.p();
                return null;
            } else if (s == hx.BOOLEAN) {
                return Boolean.toString(gxVar.k());
            } else {
                return gxVar.q();
            }
        }

        @Override // defpackage.bv
        public void write(ix ixVar, String str) {
            ixVar.c(str);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: xw$g0 */
    /* loaded from: classes.dex */
    public static final class g0<T extends Enum<T>> extends bv<T> {
        public final Map<String, T> a = new HashMap();
        public final Map<T, String> b = new HashMap();

        public g0(Class<T> cls) {
            T[] enumConstants;
            try {
                for (T t : cls.getEnumConstants()) {
                    String name = t.name();
                    fv fvVar = (fv) cls.getField(name).getAnnotation(fv.class);
                    if (fvVar != null) {
                        name = fvVar.value();
                        for (String str : fvVar.alternate()) {
                            this.a.put(str, t);
                        }
                    }
                    this.a.put(name, t);
                    this.b.put(t, name);
                }
            } catch (NoSuchFieldException e) {
                throw new AssertionError(e);
            }
        }

        @Override // defpackage.bv
        public Object read(gx gxVar) {
            if (gxVar.s() == hx.NULL) {
                gxVar.p();
                return null;
            }
            return this.a.get(gxVar.q());
        }

        @Override // defpackage.bv
        public void write(ix ixVar, Object obj) {
            Enum r3 = (Enum) obj;
            ixVar.c(r3 == null ? null : this.b.get(r3));
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: xw$h */
    /* loaded from: classes.dex */
    public class h extends bv<BigDecimal> {
        @Override // defpackage.bv
        public BigDecimal read(gx gxVar) {
            if (gxVar.s() == hx.NULL) {
                gxVar.p();
                return null;
            }
            try {
                return new BigDecimal(gxVar.q());
            } catch (NumberFormatException e) {
                throw new zu(e);
            }
        }

        @Override // defpackage.bv
        public void write(ix ixVar, BigDecimal bigDecimal) {
            ixVar.a(bigDecimal);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: xw$i */
    /* loaded from: classes.dex */
    public class i extends bv<BigInteger> {
        @Override // defpackage.bv
        public BigInteger read(gx gxVar) {
            if (gxVar.s() == hx.NULL) {
                gxVar.p();
                return null;
            }
            try {
                return new BigInteger(gxVar.q());
            } catch (NumberFormatException e) {
                throw new zu(e);
            }
        }

        @Override // defpackage.bv
        public void write(ix ixVar, BigInteger bigInteger) {
            ixVar.a(bigInteger);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: xw$j */
    /* loaded from: classes.dex */
    public class j extends bv<StringBuilder> {
        @Override // defpackage.bv
        public StringBuilder read(gx gxVar) {
            if (gxVar.s() == hx.NULL) {
                gxVar.p();
                return null;
            }
            return new StringBuilder(gxVar.q());
        }

        @Override // defpackage.bv
        public void write(ix ixVar, StringBuilder sb) {
            StringBuilder sb2 = sb;
            ixVar.c(sb2 == null ? null : sb2.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: xw$k */
    /* loaded from: classes.dex */
    public class k extends bv<Class> {
        @Override // defpackage.bv
        public Class read(gx gxVar) {
            throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        }

        @Override // defpackage.bv
        public void write(ix ixVar, Class cls) {
            StringBuilder a = jg.a("Attempted to serialize java.lang.Class: ");
            a.append(cls.getName());
            a.append(". Forgot to register a type adapter?");
            throw new UnsupportedOperationException(a.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: xw$l */
    /* loaded from: classes.dex */
    public class l extends bv<StringBuffer> {
        @Override // defpackage.bv
        public StringBuffer read(gx gxVar) {
            if (gxVar.s() == hx.NULL) {
                gxVar.p();
                return null;
            }
            return new StringBuffer(gxVar.q());
        }

        @Override // defpackage.bv
        public void write(ix ixVar, StringBuffer stringBuffer) {
            StringBuffer stringBuffer2 = stringBuffer;
            ixVar.c(stringBuffer2 == null ? null : stringBuffer2.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: xw$m */
    /* loaded from: classes.dex */
    public class m extends bv<URL> {
        @Override // defpackage.bv
        public URL read(gx gxVar) {
            if (gxVar.s() == hx.NULL) {
                gxVar.p();
                return null;
            }
            String q = gxVar.q();
            if ("null".equals(q)) {
                return null;
            }
            return new URL(q);
        }

        @Override // defpackage.bv
        public void write(ix ixVar, URL url) {
            URL url2 = url;
            ixVar.c(url2 == null ? null : url2.toExternalForm());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: xw$n */
    /* loaded from: classes.dex */
    public class n extends bv<URI> {
        @Override // defpackage.bv
        public URI read(gx gxVar) {
            if (gxVar.s() == hx.NULL) {
                gxVar.p();
                return null;
            }
            try {
                String q = gxVar.q();
                if ("null".equals(q)) {
                    return null;
                }
                return new URI(q);
            } catch (URISyntaxException e) {
                throw new su(e);
            }
        }

        @Override // defpackage.bv
        public void write(ix ixVar, URI uri) {
            URI uri2 = uri;
            ixVar.c(uri2 == null ? null : uri2.toASCIIString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: xw$o */
    /* loaded from: classes.dex */
    public class o extends bv<InetAddress> {
        @Override // defpackage.bv
        public InetAddress read(gx gxVar) {
            if (gxVar.s() == hx.NULL) {
                gxVar.p();
                return null;
            }
            return InetAddress.getByName(gxVar.q());
        }

        @Override // defpackage.bv
        public void write(ix ixVar, InetAddress inetAddress) {
            InetAddress inetAddress2 = inetAddress;
            ixVar.c(inetAddress2 == null ? null : inetAddress2.getHostAddress());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: xw$p */
    /* loaded from: classes.dex */
    public class p extends bv<UUID> {
        @Override // defpackage.bv
        public UUID read(gx gxVar) {
            if (gxVar.s() == hx.NULL) {
                gxVar.p();
                return null;
            }
            return UUID.fromString(gxVar.q());
        }

        @Override // defpackage.bv
        public void write(ix ixVar, UUID uuid) {
            UUID uuid2 = uuid;
            ixVar.c(uuid2 == null ? null : uuid2.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: xw$q */
    /* loaded from: classes.dex */
    public class q extends bv<Currency> {
        @Override // defpackage.bv
        public Currency read(gx gxVar) {
            return Currency.getInstance(gxVar.q());
        }

        @Override // defpackage.bv
        public void write(ix ixVar, Currency currency) {
            ixVar.c(currency.getCurrencyCode());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: xw$r */
    /* loaded from: classes.dex */
    public class r implements cv {

        /* compiled from: TypeAdapters.java */
        /* renamed from: xw$r$a */
        /* loaded from: classes.dex */
        public class a extends bv<Timestamp> {
            public final /* synthetic */ bv a;

            public a(r rVar, bv bvVar) {
                this.a = bvVar;
            }

            @Override // defpackage.bv
            public Timestamp read(gx gxVar) {
                Date date = (Date) this.a.read(gxVar);
                if (date != null) {
                    return new Timestamp(date.getTime());
                }
                return null;
            }

            @Override // defpackage.bv
            public void write(ix ixVar, Timestamp timestamp) {
                this.a.write(ixVar, timestamp);
            }
        }

        @Override // defpackage.cv
        public <T> bv<T> a(lu luVar, fx<T> fxVar) {
            if (fxVar.a != Timestamp.class) {
                return null;
            }
            return new a(this, luVar.a((Class) Date.class));
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: xw$s */
    /* loaded from: classes.dex */
    public class s extends bv<Calendar> {
        @Override // defpackage.bv
        public Calendar read(gx gxVar) {
            if (gxVar.s() == hx.NULL) {
                gxVar.p();
                return null;
            }
            gxVar.b();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (gxVar.s() != hx.END_OBJECT) {
                String o = gxVar.o();
                int m = gxVar.m();
                if ("year".equals(o)) {
                    i = m;
                } else if ("month".equals(o)) {
                    i2 = m;
                } else if ("dayOfMonth".equals(o)) {
                    i3 = m;
                } else if ("hourOfDay".equals(o)) {
                    i4 = m;
                } else if ("minute".equals(o)) {
                    i5 = m;
                } else if ("second".equals(o)) {
                    i6 = m;
                }
            }
            gxVar.f();
            return new GregorianCalendar(i, i2, i3, i4, i5, i6);
        }

        @Override // defpackage.bv
        public void write(ix ixVar, Calendar calendar) {
            Calendar calendar2 = calendar;
            if (calendar2 == null) {
                ixVar.g();
                return;
            }
            ixVar.c();
            ixVar.a("year");
            ixVar.a(calendar2.get(1));
            ixVar.a("month");
            ixVar.a(calendar2.get(2));
            ixVar.a("dayOfMonth");
            ixVar.a(calendar2.get(5));
            ixVar.a("hourOfDay");
            ixVar.a(calendar2.get(11));
            ixVar.a("minute");
            ixVar.a(calendar2.get(12));
            ixVar.a("second");
            ixVar.a(calendar2.get(13));
            ixVar.e();
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: xw$t */
    /* loaded from: classes.dex */
    public class t extends bv<Locale> {
        @Override // defpackage.bv
        public Locale read(gx gxVar) {
            if (gxVar.s() == hx.NULL) {
                gxVar.p();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(gxVar.q(), "_");
            String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            if (nextToken2 == null && nextToken3 == null) {
                return new Locale(nextToken);
            }
            if (nextToken3 == null) {
                return new Locale(nextToken, nextToken2);
            }
            return new Locale(nextToken, nextToken2, nextToken3);
        }

        @Override // defpackage.bv
        public void write(ix ixVar, Locale locale) {
            Locale locale2 = locale;
            ixVar.c(locale2 == null ? null : locale2.toString());
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: xw$u */
    /* loaded from: classes.dex */
    public class u extends bv<ru> {
        @Override // defpackage.bv
        /* renamed from: a */
        public void write(ix ixVar, ru ruVar) {
            if (ruVar != null && !(ruVar instanceof tu)) {
                if (ruVar instanceof wu) {
                    wu c = ruVar.c();
                    Object obj = c.a;
                    if (obj instanceof Number) {
                        ixVar.a(c.h());
                        return;
                    } else if (obj instanceof Boolean) {
                        ixVar.a(c.a());
                        return;
                    } else {
                        ixVar.c(c.d());
                        return;
                    }
                }
                boolean z = ruVar instanceof ou;
                if (z) {
                    ixVar.b();
                    if (z) {
                        Iterator<ru> it = ((ou) ruVar).iterator();
                        while (it.hasNext()) {
                            write(ixVar, it.next());
                        }
                        ixVar.d();
                        return;
                    }
                    throw new IllegalStateException("Not a JSON Array: " + ruVar);
                }
                boolean z2 = ruVar instanceof uu;
                if (z2) {
                    ixVar.c();
                    if (z2) {
                        for (Map.Entry<String, ru> entry : ((uu) ruVar).h()) {
                            ixVar.a(entry.getKey());
                            write(ixVar, entry.getValue());
                        }
                        ixVar.e();
                        return;
                    }
                    throw new IllegalStateException("Not a JSON Object: " + ruVar);
                }
                StringBuilder a = jg.a("Couldn't write ");
                a.append(ruVar.getClass());
                throw new IllegalArgumentException(a.toString());
            }
            ixVar.g();
        }

        @Override // defpackage.bv
        public ru read(gx gxVar) {
            int ordinal = gxVar.s().ordinal();
            if (ordinal == 0) {
                ou ouVar = new ou();
                gxVar.a();
                while (gxVar.h()) {
                    ru read = read(gxVar);
                    if (read == null) {
                        read = tu.a;
                    }
                    ouVar.c.add(read);
                }
                gxVar.e();
                return ouVar;
            } else if (ordinal == 2) {
                uu uuVar = new uu();
                gxVar.b();
                while (gxVar.h()) {
                    uuVar.a(gxVar.o(), read(gxVar));
                }
                gxVar.f();
                return uuVar;
            } else if (ordinal != 5) {
                if (ordinal != 6) {
                    if (ordinal != 7) {
                        if (ordinal == 8) {
                            gxVar.p();
                            return tu.a;
                        }
                        throw new IllegalArgumentException();
                    }
                    return new wu(Boolean.valueOf(gxVar.k()));
                }
                return new wu(new aw(gxVar.q()));
            } else {
                return new wu(gxVar.q());
            }
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: xw$v */
    /* loaded from: classes.dex */
    public class v extends bv<BitSet> {
        /* JADX WARN: Code restructure failed: missing block: B:15:0x003f, code lost:
            if (r7.m() != 0) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x004a, code lost:
            if (java.lang.Integer.parseInt(r1) != 0) goto L23;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x004c, code lost:
            r1 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x004e, code lost:
            r1 = false;
         */
        @Override // defpackage.bv
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.util.BitSet read(defpackage.gx r7) {
            /*
                r6 = this;
                java.util.BitSet r0 = new java.util.BitSet
                r0.<init>()
                r7.a()
                hx r1 = r7.s()
                r2 = 0
                r3 = r2
            Le:
                hx r4 = defpackage.hx.END_ARRAY
                if (r1 == r4) goto L67
                int r4 = r1.ordinal()
                r5 = 5
                if (r4 == r5) goto L42
                r5 = 6
                if (r4 == r5) goto L3b
                r5 = 7
                if (r4 != r5) goto L24
                boolean r1 = r7.k()
                goto L4f
            L24:
                zu r7 = new zu
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r2 = "Invalid bitset value type: "
                r0.append(r2)
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r7.<init>(r0)
                throw r7
            L3b:
                int r1 = r7.m()
                if (r1 == 0) goto L4e
                goto L4c
            L42:
                java.lang.String r1 = r7.q()
                int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.NumberFormatException -> L5b
                if (r1 == 0) goto L4e
            L4c:
                r1 = 1
                goto L4f
            L4e:
                r1 = r2
            L4f:
                if (r1 == 0) goto L54
                r0.set(r3)
            L54:
                int r3 = r3 + 1
                hx r1 = r7.s()
                goto Le
            L5b:
                zu r7 = new zu
                java.lang.String r0 = "Error: Expecting: bitset number value (1, 0), Found: "
                java.lang.String r0 = defpackage.jg.a(r0, r1)
                r7.<init>(r0)
                throw r7
            L67:
                r7.e()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.xw.v.read(gx):java.lang.Object");
        }

        @Override // defpackage.bv
        public void write(ix ixVar, BitSet bitSet) {
            BitSet bitSet2 = bitSet;
            ixVar.b();
            int length = bitSet2.length();
            for (int i = 0; i < length; i++) {
                ixVar.a(bitSet2.get(i) ? 1L : 0L);
            }
            ixVar.d();
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: xw$w */
    /* loaded from: classes.dex */
    public class w implements cv {
        @Override // defpackage.cv
        public <T> bv<T> a(lu luVar, fx<T> fxVar) {
            Class<? super T> cls = fxVar.a;
            if (!Enum.class.isAssignableFrom(cls) || cls == Enum.class) {
                return null;
            }
            if (!cls.isEnum()) {
                cls = cls.getSuperclass();
            }
            return new g0(cls);
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: xw$x */
    /* loaded from: classes.dex */
    public class x implements cv {
        public final /* synthetic */ fx c;
        public final /* synthetic */ bv d;

        public x(fx fxVar, bv bvVar) {
            this.c = fxVar;
            this.d = bvVar;
        }

        @Override // defpackage.cv
        public <T> bv<T> a(lu luVar, fx<T> fxVar) {
            if (fxVar.equals(this.c)) {
                return this.d;
            }
            return null;
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: xw$y */
    /* loaded from: classes.dex */
    public class y implements cv {
        public final /* synthetic */ Class c;
        public final /* synthetic */ bv d;

        public y(Class cls, bv bvVar) {
            this.c = cls;
            this.d = bvVar;
        }

        @Override // defpackage.cv
        public <T> bv<T> a(lu luVar, fx<T> fxVar) {
            if (fxVar.a == this.c) {
                return this.d;
            }
            return null;
        }

        public String toString() {
            StringBuilder a = jg.a("Factory[type=");
            a.append(this.c.getName());
            a.append(",adapter=");
            a.append(this.d);
            a.append("]");
            return a.toString();
        }
    }

    /* compiled from: TypeAdapters.java */
    /* renamed from: xw$z */
    /* loaded from: classes.dex */
    public class z extends bv<Boolean> {
        @Override // defpackage.bv
        public Boolean read(gx gxVar) {
            hx s = gxVar.s();
            if (s == hx.NULL) {
                gxVar.p();
                return null;
            } else if (s == hx.STRING) {
                return Boolean.valueOf(Boolean.parseBoolean(gxVar.q()));
            } else {
                return Boolean.valueOf(gxVar.k());
            }
        }

        @Override // defpackage.bv
        public void write(ix ixVar, Boolean bool) {
            ixVar.a(bool);
        }
    }

    public static <TT> cv a(fx<TT> fxVar, bv<TT> bvVar) {
        return new x(fxVar, bvVar);
    }

    public static <TT> cv a(Class<TT> cls, bv<TT> bvVar) {
        return new y(cls, bvVar);
    }
}
