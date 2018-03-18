package com.lingang.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.google.gson.Gson;
import com.lingang.R;
import com.lingang.activity.business.OpportunityDetailsAc;
import com.lingang.activity.home.ChanYeDetailsAc;
import com.lingang.activity.home.EntryDetailsAc;
import com.lingang.activity.home.MatingDetailesAc;
import com.lingang.activity.home.NewsDetailsAc;
import com.lingang.activity.home.NoticeDetailsAc;
import com.lingang.activity.home.PropertyDettailsAc;
import com.lingang.activity.home.PublicDetailsAc;
import com.lingang.activity.tunity.OppExamineDetailsAc;
import com.lingang.activity.tunity.RlTunityDetailesAc;
import com.lingang.activity.user.UserCorrectDetailsAc;
import com.lingang.activity.user.UserSuggestDetailsAc;
import com.lingang.adapter.PartnerDetailsAc;
import com.lingang.base.BaseAc;
import com.lingang.bean.BaseEntity;
import com.lingang.bean.OppBean;
import com.lingang.bean.UpdateBean;
import com.lingang.common.Constants;
import com.lingang.common.LoginManager;
import com.lingang.dialog.DialogOne;
import com.lingang.event.NewsEvent;
import com.lingang.event.SysmsgEvent;
import com.lingang.fragment.home.HomeFragment;
import com.lingang.fragment.home.InvestmentFragment;
import com.lingang.fragment.home.NewsFragment;
import com.lingang.fragment.home.UserFragment;
import com.lingang.fragment.home.WelfareFragment;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.http.manager.UpdateAppHttpUtil;
import com.lingang.utils.AppUtils;
import com.lingang.utils.CutPictureUtils;
import com.lingang.utils.ScreenSizeUtils;
import com.lingang.utils.ToastUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;
import com.sina.weibo.sdk.utils.UIUtils;
import com.vector.update_app.UpdateAppBean;
import com.vector.update_app.UpdateAppManager;
import com.vector.update_app.UpdateCallback;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.leolin.shortcutbadger.ShortcutBadger;
import okhttp3.Call;
import okhttp3.Response;

public class MainActivity extends BaseAc implements RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.main_activity_fragment_container)
    FrameLayout mainActivityFragmentContainer;
    @BindView(R.id.rb_menu_home)
    RadioButton rbMenuHome;
    @BindView(R.id.rb_menu_query)
    RadioButton rbMenuQuery;
    @BindView(R.id.rb_menu_statistics)
    RadioButton rbMenuStatistics;
    @BindView(R.id.rb_menu_mine)
    RadioButton rbMenuMine;
    @BindView(R.id.main_bottom_navigation_rg)
    RadioGroup mainBottomNavigationRg;
    @BindView(R.id.rg_rl)
    RelativeLayout rgRl;

    private HomeFragment homeFragmet;//首页
    private InvestmentFragment investFragment;//招商
    private WelfareFragment wefareFragment;//福利
    private NewsFragment newsFragment;
    private UserFragment userFragment;//个人中心
    private long lastestTime;

    public static boolean isForeground = false;
    private DialogOne dialogOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        //处理接收数据
        processReceive();
        EventBus.getDefault().register(this);
    }

    private void initView() {
        mainBottomNavigationRg.setOnCheckedChangeListener(this);
        mainBottomNavigationRg.check(R.id.rb_menu_home);  //设置进主界面默认选中首页
        //设置StatusBar透明
//        SystemBarHelper.immersiveStatusBar(this, 0);
        //设置6.0以上StatusBar字体颜色
//        StatusBarUtil.from(this)
//        .setLightStatusBar(true)
//        .process();
    }

    public void hideAllFragment(FragmentTransaction transaction) {
        if (homeFragmet != null) {
            transaction.hide(homeFragmet);
        }
        if (investFragment != null) {
            transaction.hide(investFragment);
        }
      /*  if (wefareFragment != null) {
            transaction.hide(wefareFragment);
        }*/
        if (null != newsFragment) {
            transaction.hide(newsFragment);
        }
        if (userFragment != null) {
            transaction.hide(userFragment);
        }
    }

    @Override
    protected void onResume() {
        isForeground = true;
        super.onResume();
    }

    @Override
    protected void onPause() {
        isForeground = false;
        super.onPause();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideAllFragment(transaction);
        switch (checkedId) {
            case R.id.rb_menu_home:
                if (homeFragmet == null) {
                    homeFragmet = new HomeFragment();
                    transaction.add(R.id.main_activity_fragment_container, homeFragmet);
                } else {
                    transaction.show(homeFragmet);
                }
                break;
            case R.id.rb_menu_query:
                if (investFragment == null) {
                    investFragment = new InvestmentFragment();
                    transaction.add(R.id.main_activity_fragment_container, investFragment);
                } else {
                    transaction.show(investFragment);
                }
                break;
            case R.id.rb_menu_statistics:
//                if (wefareFragment == null) {
//                    wefareFragment = new WelfareFragment();
//                    transaction.add(R.id.main_activity_fragment_container, wefareFragment);
//                } else {
//                    transaction.show(wefareFragment);
//                }
                if (null == newsFragment) {
                    newsFragment = new NewsFragment();
                    transaction.add(R.id.main_activity_fragment_container, newsFragment);
                } else {
                    transaction.show(newsFragment);
                }
                break;
            case R.id.rb_menu_mine:
                if (userFragment == null) {
                    userFragment = new UserFragment();
                    transaction.add(R.id.main_activity_fragment_container, userFragment);
                } else {
                    transaction.show(userFragment);
                }
                break;
        }
        transaction.commit();
    }


    @Override
    public void onBackPressed() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastestTime < 2000) {
            super.onBackPressed();
        } else {
            ToastUtils.showToast(this, "再按一次退出程序");
            lastestTime = currentTime;
        }
    }

    /**
     * 页面跳转
     *
     * @param context
     */
    public static void goToMainActivity(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    /**
     *
     */
    private void processReceive() {
    }

    /**
     * 极光推送消息
     * @param intent
     */
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String extras = intent.getStringExtra(Constants.KEY_EXTRAS);
        if (!TextUtils.isEmpty(extras)) {
            try {
                JSONObject json = new JSONObject(extras);
                String messageId = json.optString("messageId");
                String messageType = json.optString("messageType");
                String isactive = json.optString("isactive");
                String showState = json.optString("showState");
                switch (Integer.parseInt(messageType)) {
                    case Constants.MessageType.Correc:      //信息纠错
                        UserCorrectDetailsAc.goToUserCorrectDetailsAc(MainActivity.this, Integer.parseInt(messageId));
                        break;
                    case Constants.MessageType.Message:     //意见反馈
                        UserSuggestDetailsAc.goToUserSuggestDetailsAc(MainActivity.this, Integer.parseInt(messageId));
                        break;
                    case Constants.MessageType.PARK:        //产业园区
                        startActivity(new Intent(MainActivity.this, ChanYeDetailsAc.class).putExtra("id", messageId));
                        break;
                    case Constants.MessageType.Entry:       //入驻企业
                        startActivity(new Intent(MainActivity.this, EntryDetailsAc.class).putExtra("id", messageId));
                        break;
                    case Constants.MessageType.Partner:         //合作伙伴
                        startActivity(new Intent(MainActivity.this, PartnerDetailsAc.class).putExtra("id", messageId));
                        break;
                    case Constants.MessageType.Business:         //(租售物业)招商项目
                        startActivity(new Intent(MainActivity.this, PropertyDettailsAc.class).putExtra("id", messageId));
                        break;
                    case Constants.MessageType.Service:         //(配套服务)服务机构
                        startActivity(new Intent(MainActivity.this, MatingDetailesAc.class).putExtra("id", messageId));
                        break;
                    case Constants.MessageType.Public:          //公共平台
                        startActivity(new Intent(MainActivity.this, PublicDetailsAc.class).putExtra("id", messageId));
                        break;
                    case 20:                                    //系统公告
                        startActivity(new Intent(MainActivity.this, NoticeDetailsAc.class).putExtra("id", messageId));
                        break;
                    case Constants.MessageType.UpdateVersion:    //版本更新
                        AppUtils.checkUpdate(this,"当前是最新版!");
                        break;
                    case 11:  //新闻
                        NewsDetailsAc.goToNewsDetailsAc(this, messageId);
                        EventBus.getDefault().post(new NewsEvent());
                        break;
                    //我的推荐
                    case 70: //执行人更新推荐商机的信息
                    case 79: //推荐商机发布申请已通过
                    case 80: //提交的推荐商机发布申请已被退回
                    case 81: //园区认领了推荐的商机
                    case 82: //推荐的商机已成功落地
                    case 84: //推荐的商机已被撤销。
                    case 88: //执行人更新推荐人的商机执行状态
                        getOppDetail(messageId, Constants.recommend, isactive, "", "", showState);
                        break;
                    //我的执行
                    case 75: //转移商机
                    case 83: //提交的商机落地申请已被退回
                    case 85: //科产办新推荐给园区一条商机
                    case 86: //执行的商机已成功落地
                    case 87: //推荐人更新商机补充说明
                        getOppDetail(messageId, Constants.exacute, isactive, "", "", showState);
                        break;
                    //我的审核
                    case 71: //有新的推荐商机发布申请待审核
                        getOppDetail(messageId, Constants.examine, isactive, "1", "1", showState);
                        break;
                    case 74: //有一条新的商机落地申请待审核
                        getOppDetail(messageId, Constants.examine, isactive, "1", "2", showState);
                        break;
                    //认领商机
                    default:
                        if (Integer.parseInt(messageType) > 70) {
                            getOppDetail(messageId, Constants.claim, isactive, "", "", showState);
                        }
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 获取商机详情
     *
     * @param kid      商机id
     * @param code     类型代码
     * @param isActive 1 可操作  其他 不可操作
     * @param type1    1 待审核    2 已审核
     * @param type2    1 推荐审核  2 落地审核
     */
    public void getOppDetail(String kid, final int code, final String isActive, final String type1, final String type2, final String showState) {
        HttpParams httpParams = new HttpParams();
        httpParams.put("token", LoginManager.getInstance().getToken());
        httpParams.put("keyId", kid);
        OkGo.post(HttpApi.opportunity_detail)
                .params(httpParams)
                .tag(this)
                .execute(new ResCallBack<BaseEntity<OppBean, Object>>(MainActivity.this) {
                    @Override
                    public void onCall(BaseEntity<OppBean, Object> oppBeanEntity, Call call, Response response) throws JSONException {
                        OppBean oppBean = oppBeanEntity.getData();
                        Constants.ParamLandType paramLandType = new Constants.ParamLandType(
                                TextUtils.isEmpty(oppBean.getWorkshopTypeName()) ? "0" : "1",
                                TextUtils.isEmpty(oppBean.getOfficeTypeName()) ? "0" : "1",
                                TextUtils.isEmpty(oppBean.getLandTypeName()) ? "0" : "1",
                                TextUtils.isEmpty(oppBean.getRegisteredEnterpriseTypeName()) ? "0" : "1");
                        switch (code) {
                            case Constants.recommend:
                                if ("4".equals(showState)) {
                                    Intent intent = new Intent(MainActivity.this, OppExamineDetailsAc.class);
                                    intent.putExtra(Constants.isActive, isActive);
                                    intent.putExtra(Constants.DETAILS_TYPE, Constants.RECOMMEND_DETAILS);
                                    intent.putExtra(Constants.OppState.Landed, Constants.OppState.Landed);
                                    intent.putExtra(Constants.OPP_SHOW_STATE, showState);
                                    intent.putExtra(Constants.OPP_DETAILS_SHOW_STATE, "2");//1 待审核    2 已审核
                                    intent.putExtra(Constants.OPP_PAGE_STATE_TYPE, Constants.OppPageStateType.MyExamine);
                                    intent.putExtra(Constants.ALL_TYPE, "2");  //2 落地审核
                                    intent.putExtra(Constants.OPP_DETAILS_ID, oppBean.getKeyId());//商机详情ID
                                    intent.putExtra(Constants.OPP_LAND_TYPE, paramLandType);//需求类型(厂房,研发办公,土地,注册型企业)
                                    startActivityForResult(intent, Constants.refreshCode);
                                } else {
                                    OpportunityDetailsAc.gotoOpportunityDetailsAc(MainActivity.this,
                                            isActive,
                                            oppBean.getKeyId(),
                                            showState,
                                            Constants.OppPageStateType.MyClaimAc,
                                            paramLandType);
                                }
                                break;
                            case Constants.exacute:
                                Intent intent = null;
                                if ("6".equals(showState)) {  //已落地
                                    intent = new Intent(MainActivity.this, OppExamineDetailsAc.class);
                                    intent.putExtra(Constants.isActive, isActive);
                                    intent.putExtra(Constants.DETAILS_TYPE, Constants.EXECUTE_DETAILS);
                                    intent.putExtra(Constants.OppState.Landed, Constants.OppState.Landed);
                                    intent.putExtra(Constants.OPP_SHOW_STATE, showState);
                                    intent.putExtra(Constants.OPP_DETAILS_SHOW_STATE, "2");//1 待审核    2 已审核
                                    intent.putExtra(Constants.OPP_PAGE_STATE_TYPE, Constants.OppPageStateType.MyExamine);
                                    intent.putExtra(Constants.ALL_TYPE, "2");  //2 落地审核
                                } else {                //其他
                                    intent = new Intent(MainActivity.this, OpportunityDetailsAc.class);
                                    if (!"1".equals(isActive)) {
                                        intent.putExtra(Constants.JUMP_TYPE, isActive);
                                    }
                                    intent.putExtra(Constants.OPP_DETAILS_SHOW_STATE, showState);//状态类型
                                    intent.putExtra(Constants.OPP_PAGE_STATE_TYPE, Constants.OppPageStateType.MyExecute);//页面类型(推荐商机，我的审核，我的执行)
                                }
                                intent.putExtra(Constants.OPP_DETAILS_ID, oppBean.getKeyId());//商机详情ID
                                intent.putExtra(Constants.OPP_LAND_TYPE, paramLandType);//需求类型(厂房,研发办公,土地,注册型企业)
                                startActivityForResult(intent, Constants.refreshCode);
                                break;
                            case Constants.examine:
                                Intent examineIntent = new Intent(MainActivity.this, OppExamineDetailsAc.class);
//                                examineIntent.putExtra(Constants.EXAMINE_DETAILS, Constants.EXAMINE_DETAILS);
                                examineIntent.putExtra(Constants.OPP_DETAILS_ID, oppBean.getKeyId());//商机详情ID
                                examineIntent.putExtra(Constants.OPP_DETAILS_SHOW_STATE, type1);//1 待审核    2 已审核
                                examineIntent.putExtra(Constants.OPP_PAGE_STATE_TYPE, Constants.OppPageStateType.MyExamine);
                                examineIntent.putExtra(Constants.ALL_TYPE, type2);  // 1 推荐审核 2 落地审核
                                examineIntent.putExtra(Constants.OPP_LAND_TYPE, paramLandType);//需求类型(厂房,研发办公,土地,注册型企业)
                                examineIntent.putExtra(Constants.isActive, isActive);
                                startActivityForResult(examineIntent, Constants.refreshCode);
                                break;
                            case Constants.claim:
                                Intent claimIntent = new Intent(MainActivity.this, RlTunityDetailesAc.class);
                                claimIntent.putExtra("id", oppBean.getKeyId());
                                claimIntent.putExtra(Constants.isActive, isActive);
                                claimIntent.putExtra("showState", showState);
                                startActivityForResult(claimIntent, Constants.refreshCode);
                                break;
                        }
                    }
                });
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    /**
     * 更新底部小圆点
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void sysmsgShow(SysmsgEvent event) {
        if ((int) event.getObj() > 0) {
            iniSpot();
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.leftMargin = ScreenSizeUtils.getInstance(this).getScreenWidth() / 8;
            params.topMargin = UIUtils.dip2px(8, this);
            rgRl.removeView(img);
            rgRl.addView(img, params);
        } else {
            if (img != null) {
                rgRl.removeView(img);
            }
        }

        if (event != null && event.getObj() != null) {
            if (Integer.parseInt(event.getObj().toString()) > 0) {
                ShortcutBadger.applyCount(MainActivity.this, Integer.parseInt(event.getObj().toString()));
            } else {
                ShortcutBadger.removeCount(MainActivity.this);
            }
        }
    }

    private ImageView img;

    private void iniSpot() {
        if (null == img) {
            img = new ImageView(this);
            img.setBackgroundResource(R.drawable.red_point);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CutPictureUtils.CODE_RESULT_REQUEST && userFragment != null) {
            userFragment.onActivityResult(requestCode, resultCode, data);
        }

        if (resultCode == Constants.SUGGEST_FEEDBACK) {
            if (dialogOne == null) {
                dialogOne = new DialogOne(this);
            }
            dialogOne.show("您的反馈对我们非常重要，我们将更加努力的改善我们的APP");
        }

    }
}