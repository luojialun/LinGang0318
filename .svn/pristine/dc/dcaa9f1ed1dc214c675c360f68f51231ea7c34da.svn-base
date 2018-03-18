package com.lingang.activity.business;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lingang.App;
import com.lingang.R;
import com.lingang.activity.home.NewsAc;
import com.lingang.base.BaseAc;
import com.lingang.bean.NewsTabBean;
import com.lingang.fragment.home.NewsCategoryFragment;
import com.lingang.glide.GlideImgManager;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.luck.picture.lib.model.FunctionConfig;
import com.luck.picture.lib.model.LocalMediaLoader;
import com.luck.picture.lib.model.PictureConfig;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;
import com.yalantis.ucrop.entity.LocalMedia;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

public class ContracAc extends BaseAc implements PictureConfig.OnSelectResultCallback {
    @BindView(R.id.btn_fengm)
    ImageView btnFengm;
    @BindView(R.id.btn_qianz)
    ImageView btnQianz;
    @BindView(R.id.shanc1)
    ImageView shanc1;
    @BindView(R.id.shanc2)
    ImageView shanc2;
    @BindView(R.id.tv_ld)
    TextView tvLd;
    @BindView(R.id.ll_luodi)
    LinearLayout llLuodi;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.ll_name)
    LinearLayout llName;
    private FunctionConfig config;
    private List<LocalMedia> selectMedia = new ArrayList<>();
    private int tag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_contrac);
        setTitle("招商合同");
        initSelectPhoto();
    }

    //初始化图片选择器
    private void initSelectPhoto() {
        /**
         * type --> 1图片 or 2视频
         * copyMode -->裁剪比例，默认、1:1、3:4、3:2、16:9
         * maxSelectNum --> 可选择图片的数量
         * selectMode         --> 单选 or 多选
         * isShow       --> 是否显示拍照选项 这里自动根据type 启动拍照或录视频
         * isPreview    --> 是否打开预览选项
         * isCrop       --> 是否打开剪切选项
         * isPreviewVideo -->是否预览视频(播放) mode or 多选有效
         * ThemeStyle -->主题颜色
         * CheckedBoxDrawable -->图片勾选样式
         * cropW-->裁剪宽度 值不能小于100  如果值大于图片原始宽高 将返回原图大小
         * cropH-->裁剪高度 值不能小于100
         * isCompress -->是否压缩图片
         * setEnablePixelCompress 是否启用像素压缩
         * setEnableQualityCompress 是否启用质量压缩
         * setRecordVideoSecond 录视频的秒数，默认不限制
         * setRecordVideoDefinition 视频清晰度  Constants.HIGH 清晰  Constants.ORDINARY 低质量
         * setImageSpanCount -->每行显示个数
         * setCheckNumMode 是否显示QQ选择风格(带数字效果)
         * setPreviewColor 预览文字颜色
         * setCompleteColor 完成文字颜色
         * setPreviewBottomBgColor 预览界面底部背景色
         * setBottomBgColor 选择图片页面底部背景色
         * setCompressQuality 设置裁剪质量，默认无损裁剪
         * setSelectMedia 已选择的图片
         * setCompressFlag 1为系统自带压缩  2为第三方luban压缩
         * 注意-->type为2时 设置isPreview or isCrop 无效
         * 注意：Options可以为空，默认标准模式
         */
        config = new FunctionConfig();
        config.setType(LocalMediaLoader.TYPE_IMAGE);//1 图片 or 2 视频 LocalMediaLoader.TYPE_IMAGE, TYPE_VIDEO
//        config.setCopyMode(copyMode);//裁剪比例 默认 1:1 3:4 3:2 16:9 可参考 Constants.COPY_MODEL_1_1
        config.setCompress(true);//是否压缩
        config.setMaxSelectNum(1);//最大可选数量
        config.setSelectMode(2);//2 单选 or 1 多选 MODE_MULTIPLE MODE_SINGLE
        config.setShowCamera(true);//是否显示相机
        config.setEnablePreview(true);//是否预览
        config.setEnableCrop(false);//是否裁剪
        config.setCheckNumMode(false);//是否显示QQ选择风格(带数字效果)
        PictureConfig.init(config);
    }

    @OnClick({R.id.btn_fengm, R.id.btn_qianz, R.id.shanc1, R.id.shanc2, R.id.ll_luodi, R.id.ll_name})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_fengm:
                tag = 1;
                //进入相册
                config.setSelectMedia(selectMedia); // 每次选定之后回调里都是一个新集合，所以无法在初始化的时候设置
                PictureConfig.getPictureConfig().openPhoto(this, this);
                break;
            case R.id.btn_qianz:
                //进入相册
                tag = 2;
                config.setSelectMedia(selectMedia); // 每次选定之后回调里都是一个新集合，所以无法在初始化的时候设置
                PictureConfig.getPictureConfig().openPhoto(this, this);
                break;
            case R.id.shanc1:
                GlideImgManager.glideLoader(this,R.mipmap.tianjiatupian,btnFengm);
                break;
            case R.id.shanc2:
                GlideImgManager.glideLoader(this,R.mipmap.tianjiatupian,btnQianz);
                break;
            case R.id.ll_luodi:
                startActivity(new Intent(this, InvestmentTypeAc.class).putExtra("tag", "claim"));
                break;
            case R.id.ll_name:

                break;
        }
    }

    @Override
    public void onSelectSuccess(List<LocalMedia> list) {
        if (tag == 1) {
            GlideImgManager.glideLoader(this, list.get(0).getCompressPath(), btnFengm);
//            getTab(list.get(0).getPath());
            shanc1.setVisibility(View.VISIBLE);
        } else if (tag == 2) {
            GlideImgManager.glideLoader(this, list.get(0).getCompressPath(), btnQianz);
            shanc2.setVisibility(View.VISIBLE);
        }

    }

    private void getTab(String file) {
        HttpParams httpParams = new HttpParams();
        httpParams.put("myFile", new File(file));
        OkGo.post(HttpApi.SERVER + "chanceImgUpload/imageUpload.do")
                .params(httpParams)
                .execute(new ResCallBack<String>(this) {
                    @Override
                    public void onCall(String s, Call call, Response response) {
                        Log.e("SERVER ", s);
                    }
                });

    }
}
