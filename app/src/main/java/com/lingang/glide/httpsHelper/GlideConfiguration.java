package com.lingang.glide.httpsHelper;

import android.content.Context;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.module.GlideModule;
import com.lingang.App;
import com.lingang.common.Constants;

import java.io.InputStream;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;

/**
 * A {@link GlideModule} implementation to replace Glide's default
 * {@link java.net.HttpURLConnection} based {@link com.bumptech.glide.load.model.ModelLoader} with an OkHttp based
 * {@link com.bumptech.glide.load.model.ModelLoader}.
 * <p/>
 * <p>
 * If you're using gradle, you can include this module simply by depending on the aar, the module will be merged
 * in by manifest merger. For other build systems or for more more information, see
 * {@link GlideModule}.
 * </p>
 */
/*
   //1.引用 gradle 引用
   // glide lib
    compile 'com.github.bumptech.glide:glide:3.7.0'
    //glide https helper
    compile 'com.squareup.okhttp3:okhttp:3.4.1'

   //2.加入代码
    GlideConfiguration.java ,OkHttpStreamFetcher.java ,OkHttpUrlLoader.java

   //3.AndroidManifest.xml 加入
     <meta-data android:name="com.lingang.glide.httpsHelper.GlideConfiguration" android:value="GlideModule"/>
 */
public class GlideConfiguration implements GlideModule
{
    @Override
    public void applyOptions(Context context, GlideBuilder builder)
    {
        //自定义缓存目录
        builder.setDiskCache(new InternalCacheDiskCacheFactory(context,
                Constants.GLIDE_CARCH_DIR,
                Constants.GLIDE_CATCH_SIZE));
    }

    @Override
    public void registerComponents(Context context, Glide glide)
    {
        if(App.getInstance().isCertificates) {
            //启用http数字证书
            OkHttpClient.Builder builder = new OkHttpClient.Builder()
                    .sslSocketFactory(overlockCard().getSocketFactory())
                    .hostnameVerifier(new HostnameVerifier() {
                        @Override
                        public boolean verify(String hostname, SSLSession session) {
                            return true;
                        }
                    });
            glide.register(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(builder.build()));
        }
    }

    /**
     * 忽略所有https证书
     */
    private SSLContext overlockCard()
    {
        final TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager()
        {
            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) throws
                    CertificateException
            {
            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) throws
                    CertificateException
            {
            }

            @Override
            public X509Certificate[] getAcceptedIssuers()
            {
                X509Certificate[] x509Certificates = new X509Certificate[0];
                return x509Certificates;
            }
        }};
        try
        {
            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            return sslContext;
        }
        catch (Exception e)
        {
            Log.e(GlideConfiguration.class.getSimpleName(), "ssl出现异常");
            return null;
        }
    }
}
