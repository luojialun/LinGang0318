package com.lingang.http;

import com.lzy.okgo.model.HttpHeaders;
import com.lzy.okgo.request.BaseBodyRequest;
import com.lzy.okgo.utils.HttpUtils;
import com.lzy.okgo.utils.OkLogger;

import java.io.IOException;

import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by Administrator on 2017/4/10 0010.
 */

public class PatchRequest extends BaseBodyRequest<PatchRequest> {

    public PatchRequest(String url) {
        super(url);
        method = "PATCH";
    }

    @Override
    public Request generateRequest(RequestBody requestBody) {
        try {
            headers.put(HttpHeaders.HEAD_KEY_CONTENT_LENGTH, String.valueOf(requestBody.contentLength()));
        } catch (IOException e) {
            OkLogger.e(e);
        }
        Request.Builder requestBuilder = HttpUtils.appendHeaders(headers);
        return requestBuilder.method("PATCH", requestBody).url(url).tag(tag).build();
    }
}
