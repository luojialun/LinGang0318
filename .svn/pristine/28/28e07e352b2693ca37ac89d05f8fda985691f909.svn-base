package com.lingang.http.manager;

import android.support.annotation.NonNull;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.request.BaseRequest;
import com.vector.update_app.HttpManager;
import org.json.JSONException;
import java.io.File;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by Vector
 * on 2017/6/19 0019.
 */

public class UpdateAppHttpUtil implements HttpManager {
    /**
     * 异步get
     *
     * @param url      get请求地址
     * @param params   get参数
     * @param callBack 回调
     */
    @Override
    public void asyncGet(@NonNull String url, @NonNull Map<String, String> params, @NonNull final Callback callBack) {
        OkGo.get(url)
                .tag(this)
                .params(params)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        callBack.onResponse(s);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        callBack.onError(validateError(e, response));
                    }
                });
    }

    /**
     * 异步post
     *
     * @param url      post请求地址
     * @param params   post请求参数
     * @param callBack 回调
     */
    @Override
    public void asyncPost(@NonNull String url, @NonNull Map<String, String> params, @NonNull final Callback callBack) {
        OkGo.post(url)
                .tag(this)
                .params(params)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(String s, Call call, Response response) {
                        callBack.onResponse(s);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        callBack.onError(validateError(e, response));
                    }
                });

    }

    /**
     * 下载
     *
     * @param url      下载地址
     * @param path     文件保存路径
     * @param fileName 文件名称
     * @param callback 回调
     */
    @Override
    public void download(@NonNull String url, @NonNull String path, @NonNull String fileName, @NonNull final FileCallback callback) {
        OkGo.get(url)//
                .tag(this)//
                .execute(new com.lzy.okgo.callback.FileCallback(path,fileName) {
                    @Override
                    public void onSuccess(File file, Call call, Response response) {
                        callback.onResponse(file);
                    }

                    @Override
                    public void downloadProgress(long currentSize, long totalSize, float progress, long networkSpeed) {
                        super.downloadProgress(currentSize, totalSize, progress, networkSpeed);
                        callback.onProgress(progress,totalSize);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        super.onError(call, response, e);
                        callback.onError(validateError(e, response));
                    }

                    @Override
                    public void onBefore(BaseRequest request) {
                        super.onBefore(request);
                        callback.onBefore();
                    }
                });

    }

    protected String validateError(Exception error, Response response) {

        if (error != null) {
           if (error instanceof SocketTimeoutException) {
                return "网络连接超时，请稍候重试";
            } else if (error instanceof JSONException) {
                return "json转化异常";
            } else if (error instanceof ConnectException) {
                return "服务器网络异常或宕机，请稍候重试";
            }
        }


        if (response != null) {
            int code = response.code();
            if (code >= 500) {
                return "服务器异常，请稍候重试";
            } else if (code < 500 && code >= 400) {
                return "接口异常，请稍候重试";
            } else {
                return String.format("未知异常 code = %d，请稍候重试", code);
            }
        }


        return "未知异常，请稍候重试";

    }

    /**
     *取消请求
     */
    public void cancelTag()
    {
        OkGo.getInstance().cancelTag(this);
    }
}