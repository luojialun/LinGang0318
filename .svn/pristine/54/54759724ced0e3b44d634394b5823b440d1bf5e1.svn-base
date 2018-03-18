package com.lingang.base;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.App;
import com.lingang.R;
import com.lingang.activity.home.ChanYeDetailsAc;
import com.lingang.activity.login.LoginAc;
import com.lingang.activity.login.StartAc;
import com.lingang.activity.user.GestureLockLoginActivity;
import com.lingang.callback.PermissionCallback;
import com.lingang.callback.RefreshListion;
import com.lingang.common.Constants;
import com.lingang.common.LoginManager;
import com.lingang.utils.AppUtils;
import com.lingang.utils.SystemBarHelper;
import com.lingang.utils.ToastUtils;
import com.lingang.view.RefreshView;
import com.lingang.view.swipView.BaseSwipeLayout;
import com.lingang.view.swipView.SwipeHelper;
import com.lzy.okgo.OkGo;
import com.tbruyelle.rxpermissions.RxPermissions;
import com.umeng.analytics.MobclickAgent;
import com.vector.update_app.UpdateAppManager;

import butterknife.ButterKnife;
import rx.functions.Action1;

/**
 * Created by Administrator on 2017/4/18 0018.
 */

public class BaseAc extends AppCompatActivity{
    public ImageView ib_left, ib_right, ib_right2;
    private TextView tv_title, tv_right;
    private LinearLayout ll_content;
    protected View contentView;
    private RelativeLayout rl_base;
    private SwipeHelper mSwipeHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_base);
        SystemBarHelper.immersiveStatusBar(this);//沉浸式状态栏
        initView();
        mSwipeHelper = new SwipeHelper(this);
        mSwipeHelper.onActivityCreate();
        mSwipeHelper.setSwipeEdge(BaseSwipeLayout.flg);//禁止滑动关闭ac
    }
    private void initView() {
        ib_left = (ImageView) findViewById(R.id.ib_left);
        ib_right = (ImageView) findViewById(R.id.ib_right);
        ib_right2 = (ImageView) findViewById(R.id.ib_right2);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_right = (TextView) findViewById(R.id.tv_right);
        ll_content = (LinearLayout) findViewById(R.id.ll_content);
        rl_base = (RelativeLayout) findViewById(R.id.rl_base);
        //左侧返回键事件
        ib_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                clickLeft();
            }
        });
        //右侧按钮事件
        ib_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ibClickRight();
            }
        });
        tv_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ibClickRight();
            }
        });
        //右侧按钮事件
        ib_right2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                ibClickRight2();
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mSwipeHelper.onPostCreate();
    }

    /**
     * 加入页面内容布局
     *
     * @param layoutId
     */
    protected void contentView(int layoutId) {
        contentView = getLayoutInflater().inflate(layoutId, null);
        scollCloseAc();
        if (ll_content.getChildCount() > 0) {
            ll_content.removeAllViews();
        }
        if (contentView != null) {
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                    RelativeLayout.LayoutParams.MATCH_PARENT);
            ll_content.addView(contentView, params);
        }
        ButterKnife.bind(this);


    }

    /**
     * 左边按钮点击事件
     */
    public void clickLeft() {
            finish();
    }

    /**
     * 右边按钮点击事件
     */
    public void ibClickRight() {
    }

    /**
     * 右边按钮2点击事件
     */
    public void ibClickRight2() {
    }

    //设置标题
    public void setTitle(String title) {
        tv_title.setText(title);
    }

    //设置右侧tv显示
    public void setRightBtn() {
        tv_right.setVisibility(View.VISIBLE);
    }

    //设置右侧按钮的文本
    public void setRightTv(String right) {
        tv_right.setText(right);
        setRightBtn();
    }

    //设置右侧btn显示
    public void setRightBtnVi() {
        ib_right.setVisibility(View.VISIBLE);
    }

    //返回title的父布局
    public RelativeLayout getTitleViewRg() {
        return rl_base;
    }

    //返回标题view
    public TextView getTitleView() {
        return tv_title;
    }

    //返回左边的按钮
    public ImageView getLeftView() {
        return ib_left;
    }

    //返回右边的按钮
    public ImageView getRightView() {
        setRightBtnVi();
        return ib_right;
    }

    //返回右边的按钮
    public ImageView getRightView2() {
        ib_right2.setVisibility(View.VISIBLE);
        return ib_right2;
    }

    /**
     * 返回右边文本按钮
     *
     * @return
     */
    public TextView getRightTextView() {
        setRightBtn();
        return tv_right;
    }



    //设置滑动关闭ac
    public void scollCloseAc() {
//        mSwipeHelper.setSwipeEdge(ViewDragHelper.EDGE_LEFT);//开启滑动关闭ac
    }

    //设置recycleview的分割线
    public void setRefreshViewLine(RecyclerView recyclerview, int id) {
        DividerItemDecoration dividerItemDecoration1 = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        dividerItemDecoration1.setDrawable(getResources().getDrawable(id));//R.drawable.main_item_divider
        recyclerview.addItemDecoration(dividerItemDecoration1);
    }


    //设置下拉刷新的头控件
    public void setRefreshHead(TwinklingRefreshLayout refresh) {
        RefreshView headerView = new RefreshView(this);
        refresh.setHeaderView(headerView);
    }

    //设置recycleview LinearLayoutManager
    public void setRecycleAspect(RecyclerView recyclerview) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(layoutManager);
    }

    //设置recycleview LinearLayoutManager
    public void setRecycleHorizontal(RecyclerView recyclerview) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerview.setLayoutManager(layoutManager);
    }

    //设置recycleview GrideviewManager
    public void setRecycleGride(RecyclerView recyclerview, int spanCount) {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, spanCount);
        recyclerview.setLayoutManager(gridLayoutManager);
    }

    /**
     * 设置默认RecycleView简单样式
     * @param recyclerview
     */
    public void setRecycleSimpleStyle(RecyclerView recyclerview)
    {
        setRecycleSimpleStyle(recyclerview,LinearLayoutManager.VERTICAL,R.drawable.main_item_divider);
    }

    /**
     * 设置默认RecycleView简单样式
     * @param recyclerview
     * @param dividerId 分割线
     */
    public void setRecycleSimpleStyle(RecyclerView recyclerview, int dividerId)
    {
        setRecycleSimpleStyle(recyclerview,LinearLayoutManager.VERTICAL,dividerId);
    }
    /**
     * 设置默认RecycleView简单样式
     * @param recyclerview
     * @param orientation 方向
     * @param dividerId 分割线
     */
    public void setRecycleSimpleStyle(RecyclerView recyclerview, int orientation,int dividerId)
    {
        /**
         *列表方向
         */
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(orientation);
        recyclerview.setLayoutManager(layoutManager);
        /**
         *分割线
         */
        DividerItemDecoration dividerItemDecoration1 = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        dividerItemDecoration1.setDrawable(getResources().getDrawable(dividerId));
        recyclerview.addItemDecoration(dividerItemDecoration1);
    }

    //设置刷新回调
    public void setRefreshLison(final TwinklingRefreshLayout refresh, final RefreshListion listion) {
        refresh.setOnRefreshListener(new RefreshListenerAdapter() {

            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {
                refresh.finishRefreshing();
                listion.refresh();
            }

            @Override
            public void onLoadMore(TwinklingRefreshLayout refreshLayout) {
                refresh.finishLoadmore();
                listion.loadMore();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
        String gestureSwitch = LoginManager.getInstance().getGestureState();
        if (!TextUtils.isEmpty(gestureSwitch) && Integer.parseInt(gestureSwitch)==Constants.GestureSwitch.GESTURE_SWITCH_OPEN && !(BaseAc.this instanceof LoginAc)) {
            if (!Constants.isForeground) {
                Constants.isForeground = true;
                if (System.currentTimeMillis() - Constants.stopTime >= Constants.GESTURE_PWD_DELAY_TIME) {
                    Intent intent = new Intent(this, GestureLockLoginActivity.class);
                    intent.putExtra(Constants.IS_GESTURE_SHIP_LOGIN, true);
                    startActivity(intent);
                }

            }
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        if (!AppUtils.isAppOnForeground(this)) {
            Constants.isForeground = false;
            Constants.stopTime = System.currentTimeMillis();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        OkGo.getInstance().cancelTag(this);
        //MobclickAgent.onKillProcess(this);//友盟退出时
    }

    /**
     * 重写 activity切换方法 消除系统自带动画
     * @param intent
     */
    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        overridePendingTransition(R.anim.right_in, R.anim.left_out);//从左边滑动进入
//        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);//淡入淡出动画
    }

    //用于处理多个Ac来回切换动画错乱的情况  一般情况请勿 使用
    public void startActivity(Intent intent,boolean isOpen) {
        if (isOpen){
            super.startActivity(intent);
            overridePendingTransition(R.anim.left_in, R.anim.out_to_right);
        }
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.out_to_right_abit, R.anim.out_to_right);//从左边滑动退出
//        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);//淡入淡出动画
    }
    @Override
    public void startActivityForResult(Intent intent, int requestCode, @Nullable Bundle options) {
        super.startActivityForResult(intent, requestCode, options);
        overridePendingTransition(R.anim.right_in, R.anim.left_out);
//        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        super.startActivityForResult(intent, requestCode);
        overridePendingTransition(R.anim.right_in, R.anim.left_out);
//        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    /**
     * 检测当的网络（WLAN、3G/2G）状态
     * @return
     */
    protected boolean isNetwork()
    {
        return AppUtils.isNetworkAvailable(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == UpdateAppManager.resultCloseCode) {//监听更新界面的关闭事件
            boolean isForceUpdate=data.getBooleanExtra("isForceUpdate",false);
            if(isForceUpdate){
                Intent intent = new Intent(this, LoginAc.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        }
    }

}

