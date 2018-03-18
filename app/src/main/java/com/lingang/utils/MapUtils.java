package com.lingang.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by luojialun on 2017/12/5.
 */

public class MapUtils {

    /**
     * 检查手机上是否安装了指定的软件
     *
     * @param context
     * @param packageName：应用包名
     * @return
     */
    public static boolean isAvilible(Context context, String packageName) {
        //获取packagemanager
        final PackageManager packageManager = context.getPackageManager();
        //获取所有已安装程序的包信息
        List<PackageInfo> packageInfos = packageManager.getInstalledPackages(0);
        //用于存储所有已安装程序的包名
        List<String> packageNames = new ArrayList<String>();
        //从pinfo中将包名字逐一取出，压入pName list中
        if (packageInfos != null) {
            for (int i = 0; i < packageInfos.size(); i++) {
                String packName = packageInfos.get(i).packageName;
                packageNames.add(packName);
            }
        }
        //判断packageNames中是否有目标程序的包名，有TRUE，没有FALSE
        return packageNames.contains(packageName);
    }

    /**
     * 百度地图
     *
     * @param context
     * @param address
     */
    public static void goBaiduMap(Context context, String address) {

        if (isAvilible(context, "com.baidu.BaiduMap")) {//传入指定应用包名
            /* try {
                //intent = Intent.getIntent("intent://map/direction?origin=latlng:34.264642646862,108.95108518068|name:我家&destination=大雁塔&mode=driving®ion=西安&src=yourCompanyName|yourAppName#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end");
                intent = Intent.getIntent("intent://map/direction?" +
                        "destination=" + address        //终点
                        + "#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end");

                context.startActivity(intent); //启动调用
            } catch (URISyntaxException e) {
                Log.e("intent", e.getMessage());
            }*/
            Intent i1 = new Intent();
            // 地址解析  http://lbsyun.baidu.com/index.php?title=uri/api/android
            i1.setData(Uri.parse("baidumap://map/geocoder?src=openApiDemo&address=" + address));
            context.startActivity(i1);

        } else {
            //market为路径，id为包名
            //显示手机上所有的market商店
            Toast.makeText(context, "您尚未安装百度地图", Toast.LENGTH_LONG).show();
            Uri uri = Uri.parse("market://details?id=com.baidu.BaiduMap");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            context.startActivity(intent);
        }
    }

    /**
     * 高德地图
     *
     * @param context
     * @param address
     */
    public static void goGaodeMap(Context context, String address) {
       /*  Intent intent;
       if (isAvilible(context, "com.autonavi.minimap")) {
            try {
                intent = Intent.getIntent("androidamap://viewGeo?sourceApplication=amap&addr=" + address);
                context.startActivity(intent);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        } else {
            Toast.makeText(context, "您尚未安装高德地图", Toast.LENGTH_LONG).show();
            Uri uri = Uri.parse("market://details?id=com.autonavi.minimap");
            intent = new Intent(Intent.ACTION_VIEW, uri);
            context.startActivity(intent);
        }*/

        //路径规划  http://lbs.amap.com/api/amap-mobile/guide/android/route
        if (isAvilible(context, "com.autonavi.minimap")) {
            try {
                Intent intent1 = new Intent("android.intent.action.VIEW");
                intent1.addCategory("android.intent.category.DEFAULT");
                intent1.setPackage("com.autonavi.minimap");
                Uri uri = android.net.Uri.parse("amapuri://route/plan/?sid=BGVIS1&did=BGVIS2&dname=" + address + "&dev=0&t=0");
                intent1.setData(uri);
                context.startActivity(intent1);
            } catch (Exception e) {
                e.printStackTrace();
                Uri uri = Uri.parse("market://details?id=com.autonavi.minimap");
                Intent intent2 = new Intent(Intent.ACTION_VIEW, uri);
                context.startActivity(intent2);
            }
        } else {
            Toast.makeText(context, "您尚未安装高德地图", Toast.LENGTH_LONG).show();
        }

    }

    /**
     * 谷歌地图
     *
     * @param context
     * @param address
     */
    public static void goGoogleMap(Context context, String address) {
        Intent intent;
        if (isAvilible(context, "com.google.android.apps.maps")) {
            Uri gmmIntentUri = Uri.parse("google.navigation:q=" + "34.264642646862,108.95108518068" + ", + Sydney +Australia");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            context.startActivity(mapIntent);
        } else {
            Toast.makeText(context, "您尚未安装谷歌地图", Toast.LENGTH_LONG).show();

            Uri uri = Uri.parse("market://details?id=com.google.android.apps.maps");
            intent = new Intent(Intent.ACTION_VIEW, uri);
            context.startActivity(intent);
        }
    }


}
