package com.lingang.activity.business;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.adapter.GridImageAdapter;
import com.lingang.base.BaseAc;
import com.lingang.callback.DialogOnclinck;
import com.lingang.dialog.BottomDialog;
import com.lingang.utils.FullyGridLayoutManager;
import com.lingang.utils.ToastUtils;
import com.lingang.view.flowlayout.TagFlowLayout;
import com.luck.picture.lib.model.FunctionConfig;
import com.luck.picture.lib.model.LocalMediaLoader;
import com.luck.picture.lib.model.PictureConfig;
import com.yalantis.ucrop.entity.LocalMedia;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import me.next.tagview.TagCloudView;

public class GroomAc extends BaseAc implements GridImageAdapter.onAddPicClickListener,
        GridImageAdapter.OnItemClickListener,
        PictureConfig.OnSelectResultCallback
        ,DialogOnclinck {

    @BindView(R.id.tc_class)
    TagCloudView tcClass;
    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.tf_tuijian)
    TagCloudView tfTuijian;
    @BindView(R.id.btn_comit)
    Button btnComit;
    @BindView(R.id.tv_class)
    TextView tvClass;
    @BindView(R.id.tv_claim)
    TextView tvClaim;
    private ArrayList<String> classList, tuijList;
    private GridImageAdapter adapter;
    private List<LocalMedia> selectMedia = new ArrayList<>();
    private FunctionConfig config;
    private BottomDialog bottomDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_groom);
        setTitle("商机推荐");
        setRightTv("规则");

        initTabData();
        initSelectPhoto();
        initRecycler();
    }

    private void initTabData() {
        classList = new ArrayList<>();
        classList.add("注册企业");
        classList.add("租住场地");
        classList.add("购买土地");
        tcClass.setTags(classList);

        tuijList = new ArrayList<>();
        tuijList.add("临港装备产业区");
        tuijList.add("自贸区洋山保税区");
        tuijList.add("临港科技城");
        tuijList.add("枫泾新兴产业区");
        tfTuijian.setTags(tuijList);

        tcClass.setOnTagClickListener(new TagCloudView.OnTagClickListener() {
            @Override
            public void onTagClick(int position) {

            }
        });
        tfTuijian.setOnTagClickListener(new TagCloudView.OnTagClickListener() {
            @Override
            public void onTagClick(int position) {

            }
        });
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
        config.setMaxSelectNum(4);//最大可选数量
        config.setSelectMode(1);//2 单选 or 1 多选 MODE_MULTIPLE MODE_SINGLE
        config.setShowCamera(true);//是否显示相机
        config.setEnablePreview(true);//是否预览
        config.setEnableCrop(false);//是否裁剪
        config.setCheckNumMode(true);//是否显示QQ选择风格(带数字效果)
        PictureConfig.init(config);
    }

    private void initRecycler() {
        FullyGridLayoutManager manager = new FullyGridLayoutManager(this, 4, GridLayoutManager.VERTICAL, false);

        recycler.setLayoutManager(manager);
        adapter = new GridImageAdapter(this, this);
        adapter.setSelectMax(4);
        adapter.setOnItemClickListener(this);//预览图片
        recycler.setAdapter(adapter);
    }

    @Override
    public void onAddPicClick(int type, int position) {
        switch (type) {
            case 0:
                //进入相册
                config.setSelectMedia(selectMedia); // 每次选定之后回调里都是一个新集合，所以无法在初始化的时候设置
                PictureConfig.getPictureConfig().openPhoto(this, this);
                break;
            case 1:
                // 删除图片
                selectMedia.remove(position);
                adapter.notifyItemRemoved(position);
                break;
        }
    }

    @Override
    public void onItemClick(int position, View v) {
        // 这里可预览图片
        PictureConfig.getPictureConfig().externalPicturePreview(this, position, selectMedia);
    }

    @Override
    public void onSelectSuccess(List<LocalMedia> list) {
        selectMedia = list;
        Log.i("callBack_result", selectMedia.size() + "");
        if (selectMedia != null) {
            adapter.setList(selectMedia);
            adapter.notifyDataSetChanged();
        }
    }

    @OnClick({R.id.tv_class, R.id.tv_claim,R.id.btn_comit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_class:
                Intent intent = new Intent(this, InvestmentTypeAc.class);
                intent.putExtra("tag", "type");//商机类型
                startActivity(intent);
                break;
            case R.id.tv_claim:
                if (bottomDialog == null) {
                    bottomDialog = new BottomDialog(this, this);
                }
                bottomDialog.setSign("claim");
                bottomDialog.show("全集团", "指定园区", "指定招商人员");
                break;

            case R.id.btn_comit:
//                if (selectMedia != null && selectMedia.size() > 0) {
                    startActivity(new Intent(this, SuccessAc.class));
                    //upDataServices(selectMedia.get(0).getCompressPath());
//                }
                break;
        }

    }


    @Override
    public void dialogOnclicCall(String btnTag, String sign) {
        if (sign.equals("claim")) {
            switch (btnTag) {
                case "btn_one":
                    ToastUtils.showToast(this, "全集团");
                    break;
                case "btn_two":
                    Intent intent = new Intent(this, InvestmentTypeAc.class);
                    intent.putExtra("tag", "claim");//选择园区
                    startActivity(intent);
                    break;
                case "btn_there":
                    startActivity(new Intent(this, ParkAc.class));//指定招商人员
                    break;
            }

        } else if (sign.equals("")) {
            switch (btnTag) {
                case "btn_one":
                    break;
                case "btn_two":
                    break;
                case "btn_there":
                    break;
            }
        }
    }

}
