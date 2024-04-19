package defpackage;

import android.text.TextUtils;
import android.util.Log;
import defpackage.ji;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
/* compiled from: HttpUrlFetcher.java */
/* renamed from: pi  reason: default package */
/* loaded from: classes.dex */
public class pi implements ji<InputStream> {
    public static final b i = new a();
    public final gl c;
    public final int d;
    public final b e;
    public HttpURLConnection f;
    public InputStream g;
    public volatile boolean h;

    /* compiled from: HttpUrlFetcher.java */
    /* renamed from: pi$a */
    /* loaded from: classes.dex */
    public static class a implements b {
        public HttpURLConnection a(URL url) {
            return (HttpURLConnection) url.openConnection();
        }
    }

    /* compiled from: HttpUrlFetcher.java */
    /* renamed from: pi$b */
    /* loaded from: classes.dex */
    public interface b {
    }

    public pi(gl glVar, int i2) {
        b bVar = i;
        this.c = glVar;
        this.d = i2;
        this.e = bVar;
    }

    @Override // defpackage.ji
    public void a(qg qgVar, ji.a<? super InputStream> aVar) {
        StringBuilder sb;
        long a2 = oq.a();
        try {
            try {
                aVar.a((ji.a<? super InputStream>) a(this.c.b(), 0, null, this.c.b.a()));
            } catch (IOException e) {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Failed to load data for url", e);
                }
                aVar.a((Exception) e);
                if (!Log.isLoggable("HttpUrlFetcher", 2)) {
                    return;
                }
                sb = new StringBuilder();
            }
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                sb = new StringBuilder();
                sb.append("Finished http url fetcher fetch in ");
                sb.append(oq.a(a2));
                Log.v("HttpUrlFetcher", sb.toString());
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                StringBuilder a3 = jg.a("Finished http url fetcher fetch in ");
                a3.append(oq.a(a2));
                Log.v("HttpUrlFetcher", a3.toString());
            }
            throw th;
        }
    }

    @Override // defpackage.ji
    public void b() {
        InputStream inputStream = this.g;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f = null;
    }

    @Override // defpackage.ji
    public uh c() {
        return uh.REMOTE;
    }

    @Override // defpackage.ji
    public void cancel() {
        this.h = true;
    }

    public final InputStream a(URL url, int i2, URL url2, Map<String, String> map) {
        if (i2 < 5) {
            if (url2 != null) {
                try {
                    if (url.toURI().equals(url2.toURI())) {
                        throw new yh("In re-direct loop");
                    }
                } catch (URISyntaxException unused) {
                }
            }
            this.f = ((a) this.e).a(url);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.f.addRequestProperty(entry.getKey(), entry.getValue());
            }
            this.f.setConnectTimeout(this.d);
            this.f.setReadTimeout(this.d);
            this.f.setUseCaches(false);
            this.f.setDoInput(true);
            this.f.setInstanceFollowRedirects(false);
            this.f.connect();
            this.g = this.f.getInputStream();
            if (this.h) {
                return null;
            }
            int responseCode = this.f.getResponseCode();
            int i3 = responseCode / 100;
            if (i3 == 2) {
                HttpURLConnection httpURLConnection = this.f;
                if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
                    this.g = new lq(httpURLConnection.getInputStream(), httpURLConnection.getContentLength());
                } else {
                    if (Log.isLoggable("HttpUrlFetcher", 3)) {
                        StringBuilder a2 = jg.a("Got non empty content encoding: ");
                        a2.append(httpURLConnection.getContentEncoding());
                        Log.d("HttpUrlFetcher", a2.toString());
                    }
                    this.g = httpURLConnection.getInputStream();
                }
                return this.g;
            }
            if (!(i3 == 3)) {
                if (responseCode == -1) {
                    throw new yh(responseCode);
                }
                throw new yh(this.f.getResponseMessage(), responseCode);
            }
            String headerField = this.f.getHeaderField("Location");
            if (!TextUtils.isEmpty(headerField)) {
                URL url3 = new URL(url, headerField);
                b();
                return a(url3, i2 + 1, url, map);
            }
            throw new yh("Received empty or null redirect url");
        }
        throw new yh("Too many (> 5) redirects!");
    }

    @Override // defpackage.ji
    public Class<InputStream> a() {
        return InputStream.class;
    }
}
