package com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.http;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public interface IResponse {
    String body();

    InputStream byteStream();

    int code();

    Throwable getException();

    tk0 getRawResponse();

    String header(String key);

    Map<String, List<String>> headers();

    String message();
}
