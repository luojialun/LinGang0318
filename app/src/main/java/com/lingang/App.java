package com.lingang;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.support.multidex.MultiDex;

import com.lingang.greendao.DaoMaster;
import com.lingang.greendao.DaoSession;
import com.lingang.http.HttpApi;
import com.lingang.utils.AppUtils;
import com.lingang.utils.db.DBOpenHelper;
import com.loopj.android.http.MySSLSocketFactory;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cookie.store.CookieStore;
import com.lzy.okgo.cookie.store.PersistentCookieStore;
import com.lzy.okhttputils.OkHttpUtils;
import com.lzy.okhttputils.cache.CacheEntity;
import com.lzy.okserver.download.DownloadManager;
import com.lzy.okserver.download.DownloadService;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

import java.io.IOException;
import java.security.KeyStore;
import java.util.logging.Level;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;

import cn.jpush.android.api.JPushInterface;
import okhttp3.Cookie;
import okhttp3.HttpUrl;

/**
 * Created by Administrator on 2017/4/18 0018.
 */

public class App extends Application {
    private static App instance;
    private DownloadManager downloadManager;
    /**
     * 是否启用设置https证书 (默认已启用信任所有证书)
     */
    public final boolean isCertificates = false;

    public static String Empty = "";
    public static int IntNormal = 0;
    public final static String stateCode = "1000";
    public final static String stateError = "1004";
    /**
     * 解析错误
     */
    public final static String parseError = "9999";
    /*****************Green Dao***********************/
    private DBOpenHelper mHelper;
    private SQLiteDatabase db;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    /*****************Green Dao end***********************/

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        setDatabase();
        initOkGo();
        initDownServicces();
        initOkHttpUtils();
        initVideoHttps();

        Config.DEBUG = true;
        UMShareAPI.get(this);//友盟分享初始化
        MobclickAgent.setScenarioType(this, MobclickAgent.EScenarioType.E_UM_NORMAL);
        UMConfigure.init(this, UMConfigure.DEVICE_TYPE_PHONE, "");

        JPushInterface.setDebugMode(true);//设置开启日志,发布时请关闭日志
        JPushInterface.init(this);// 初始化激光JPush
    }

    private void initDownServicces() {
        downloadManager = DownloadService.getDownloadManager();
        downloadManager.setTargetFolder(Environment.getExternalStorageDirectory().getAbsolutePath() + "/lingang/");
    }

    private void initOkGo() {
        OkGo.init(this);
        try {
            OkGo okGo = OkGo.getInstance();
            okGo.setCertificates()
                    .setCookieStore(new PersistentCookieStore())          //cookie持久化存储，如果cookie不过期，则一直有效
//                    .setCookieStore(new MemoryCookieStore())//cookie使用内存缓存（app退出后，cookie消失）

//                    .setCacheMode(CacheMode.REQUEST_FAILED_READ_CACHE)//缓存模式
                    // 打开该调试开关,打印级别INFO,并不是异常,是为了显眼,不需要就不要加入该行
                    // 最后的true表示是否打印okgo的内部异常，一般打开方便调试错误
                    .debug("OkGo", Level.INFO, true);

            if (isCertificates) {//启动数字证书
                okGo.setCertificates(getAssets().open("server.cer"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

//                //如果使用默认的 60秒,以下三行也不需要传
//                .setConnectTimeout(OkGo.DEFAULT_MILLISECONDS)  //全局的连接超时时间
//                .setReadTimeOut(OkGo.DEFAULT_MILLISECONDS)     //全局的读取超时时间
//                .setWriteTimeOut(OkGo.DEFAULT_MILLISECONDS);   //全局的写入超时时间
    }

    public static CookieStore getCookieStore(String url) {
        HttpUrl httpUrl = HttpUrl.parse(url);
        Cookie.Builder builder = new Cookie.Builder();
        Cookie cookie = builder.name("terminalType").value("1").domain(httpUrl.host()).build();
        String appVersion = AppUtils.getVersionName(getInstance());
        Cookie cookie2 = builder.name("appVersion").value(appVersion).domain(httpUrl.host()).build();
        CookieStore cookieStore = OkGo.getInstance().getCookieJar().getCookieStore();
        cookieStore.saveCookie(httpUrl, cookie);
        cookieStore.saveCookie(httpUrl, cookie2);

        return cookieStore;
    }

    public static App getInstance() {
        return instance;
    }

    //返回downServices
    public DownloadManager getDownServices() {
        return downloadManager;
    }


    /**************友盟分享配置************************/ {

        PlatformConfig.setWeixin("wxd02d4cda1d19a71a", "18da415266dc03f1839f8bf6083f67b7");
        PlatformConfig.setQQZone("101366515", "168d2162875e780ef02b3f536b76d6a9");
        PlatformConfig.setSinaWeibo("150238588", "48f61d3675a929159e34c951f207a9b4", "http://sns.whalecloud.com");
    }

//    下面两个方法需要换成 LoginManager类中的方法
//    public void writeUserInfo(LoginBase user) {
//        token = user.getDataMap().getToken();
//        SPUtils.put(this, userInfo, new Gson().toJson(user));
//    }
//    public LoginBase getUserInfo() {
//        return new Gson().fromJson((String) SPUtils.get(this, userInfo, ""), LoginBase.class);
//    }


    /*****************************setting green Dao*******************************/
    /**
     * 设置greenDao
     */
    private void setDatabase() {
        // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        mHelper = new DBOpenHelper(this, "lingang-db", null);

        db = mHelper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        mDaoMaster = new DaoMaster(db);
        mDaoSession = mDaoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    public SQLiteDatabase getDb() {
        return db;
    }
    /*****************************end green Dao*******************************/

    /**
     * okhttputils的设置入口
     */

    private void initOkHttpUtils() {
        //必须调用初始化
        OkHttpUtils.init(this);

        //以下都不是必须的，根据需要自行选择,一般来说只需要 debug,缓存相关,cookie相关的 就可以了
        OkHttpUtils okHttpUtils = OkHttpUtils.getInstance();
        okHttpUtils.setCertificates()
                //打开该调试开关,控制台会使用 红色error 级别打印log,并不是错误,是为了显眼,不需要就不要加入该行
                .debug("OkHttpUtils")
                //如果使用默认的 60秒,以下三行也不需要传
                .setConnectTimeout(OkHttpUtils.DEFAULT_MILLISECONDS)               //全局的连接超时时间
                .setReadTimeOut(OkHttpUtils.DEFAULT_MILLISECONDS)                  //全局的读取超时时间
                .setWriteTimeOut(OkHttpUtils.DEFAULT_MILLISECONDS)                 //全局的写入超时时间

                //可以全局统一设置缓存模式,默认就是Default,可以不传,具体其他模式看 github 介绍 https://github.com/jeasonlzy0216/
                .setCacheMode(com.lzy.okhttputils.cache.CacheMode.DEFAULT)

                //可以全局统一设置缓存时间,默认永不过期,具体使用方法看 github 介绍
                .setCacheTime(CacheEntity.CACHE_NEVER_EXPIRE)

                //如果不想让框架管理cookie,以下不需要
//                .setCookieStore(new MemoryCookieStore())                          //cookie使用内存缓存（app退出后，cookie消失）
                .setCookieStore(new com.lzy.okhttputils.cookie.store.PersistentCookieStore());                      //cookie持久化存储，如果cookie不过期，则一直有效

        if (isCertificates) {//启动数字证书
            try {
                okHttpUtils.setCertificates(getAssets().open("server.cer"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 初始化自带数字证书设置https
     */
    private void initVideoHttps() {
        //☆☆☆需要gradle引用下面类库☆☆☆
        //compile 'com.loopj.android:android-async-http:1.4.7'
        //测试https地址
        //https://apitest.shlingang.com/image/upload/park/20170407/201704071714234824.mp4
        //设置跳过https
        try {
            KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
            trustStore.load(null, null);
            MySSLSocketFactory sf = new MySSLSocketFactory(trustStore);
            sf.setHostnameVerifier(MySSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            sf.fixHttpsURLConnection();
            HostnameVerifier hostnameVerifier = org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;
            HttpsURLConnection.setDefaultHostnameVerifier(hostnameVerifier);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
