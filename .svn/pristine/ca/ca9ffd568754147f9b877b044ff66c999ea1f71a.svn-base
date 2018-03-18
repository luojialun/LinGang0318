package com.lingang.fragment.home;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lingang.R;
import com.lingang.activity.business.BoardAc;
import com.lingang.activity.business.MyClaimAc;
import com.lingang.activity.business.OpportunityDetailsAc;
import com.lingang.activity.contacts.ContactsAc;
import com.lingang.activity.contacts.NewAddAc;
import com.lingang.activity.home.BusinessAc;
import com.lingang.activity.home.EntryAc;
import com.lingang.activity.home.GroupAc;
import com.lingang.activity.home.MatingAc;
import com.lingang.activity.home.MessageAc;
import com.lingang.activity.home.NeedAc;
import com.lingang.activity.home.NoticeAc;
import com.lingang.activity.home.PolicyListAc;
import com.lingang.activity.home.WebAc;
import com.lingang.activity.home.WeekPlanAc;
import com.lingang.activity.home.YuanQuAc;
import com.lingang.activity.home.search.HomeSearchActivity;
import com.lingang.activity.tunity.KanBanOppoListAc;
import com.lingang.activity.tunity.MyExamineAc;
import com.lingang.activity.tunity.OppExamineDetailsAc;
import com.lingang.activity.tunity.RlTunityAc;
import com.lingang.activity.tunity.TjTunityOneAc;
import com.lingang.activity.tunity.execute.MyExecute;
import com.lingang.activity.user.UserAppShare;
import com.lingang.activity.user.UserFavoritesAc;
import com.lingang.activity.user.UserSuggestAddAc;
import com.lingang.adapter.HomeGvAdapter;
import com.lingang.adapter.HomeMsgLvAdapter;
import com.lingang.adapter.PopupWindowAdapter;
import com.lingang.base.BaseFragment;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.HomeBanner;
import com.lingang.bean.HomeModeBean;
import com.lingang.bean.HomeSwitchTv;
import com.lingang.bean.KanbanBean;
import com.lingang.bean.MsgBean;
import com.lingang.bean.PopWindowBean;
import com.lingang.common.Constants;
import com.lingang.common.Constants.Home;
import com.lingang.common.LoginManager;
import com.lingang.common.PagerHelper;
import com.lingang.dialog.DialogOne;
import com.lingang.event.SysmsgEvent;
import com.lingang.event.UpdateSysmsgEvent;
import com.lingang.glide.GlideImageLoader;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.utils.BannerJumpUtils;
import com.lingang.utils.JsonUtil;
import com.lingang.utils.SPUtils;
import com.lingang.utils.ToastUtils;
import com.lingang.view.AutoVerticalScrollTextView;
import com.lingang.view.ExtraGridView;
import com.lingang.view.ExtraListView;
import com.lingang.view.RefreshView;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerClickListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import okhttp3.Call;
import okhttp3.Response;

public class HomeFragment extends BaseFragment implements AdapterView.OnItemClickListener {

    Unbinder unbinder;
    @BindView(R.id.logo)
    ImageView logo;
    @BindView(R.id.more)
    ImageView more;
    @BindView(R.id.home_banner)
    Banner banner;
    //    @BindView(R.id.home_ranking_lv)
    //    HorizontalListView homeRankingLv;
    @BindView(R.id.home_meg)
    ExtraListView homeMeg;
    @BindView(R.id.refresh)
    TwinklingRefreshLayout refresh;
    @BindView(R.id.home_sc)
    ScrollView home_sc;
    @BindView(R.id.home_search_all)
    RelativeLayout homeSearchAll;
    @BindView(R.id.toast_content)
    AutoVerticalScrollTextView toastContent;
    @BindView(R.id.ll_switch)
    LinearLayout llSwitch;
    @BindView(R.id.yiluodi_tv)
    TextView yiluodiTv;
    @BindView(R.id.total_tv)
    TextView totalTv;
    @BindView(R.id.img_state)
    ImageView imgState;
    @BindView(R.id.home_gv)
    ExtraGridView homeGv;
    @BindView(R.id.banner_img)
    ImageView bannerImg;
    //    @BindView(R.id.home_meg)
    //    ExtraListView homeMeg;
    //    private HomeLvAdapter homeLvAdapter;
    private HomeGvAdapter homeGvAdapter;
    private HomeMsgLvAdapter homeMsgLvAdapter;
    private int[] img, imgMsg;
    private String[] title, titleMsg, contentMsg;
    private PagerHelper pagerHelper;
    private ArrayList<HomeModeBean> homeLvMsg;
    private DialogOne dialogOne;
    private List<HomeSwitchTv.DataBean> msgBeanData;
    private int number = 1;
    private String userType;
    private PopupWindow popupWindow;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EventBus.getDefault().register(this);
        userType = LoginManager.getInstance().getUserInfo().getUserType();
        initRefresh();
        //        initRanking();
        initGvData();
        initLvMsg();
        home_sc.smoothScrollTo(0, 0);

        String banner = (String) SPUtils.get(getActivity(), "banner", "");
        if (!TextUtils.isEmpty(banner)) {
            bannerImg.setVisibility(View.GONE);
            HomeBanner homeBanner = JsonUtil.getGson().fromJson(banner, HomeBanner.class);
            installBannerData(homeBanner);
        }
        getBanner();
    }

    private void initRefresh() {
        RefreshView headerView = new RefreshView(getActivity());
        refresh.setHeaderView(headerView);
        refresh.setEnableLoadmore(false);
        refresh.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getBanner();
                        getUnreadMsg();
                        getNewestOpp();
                        refresh.finishRefreshing();
                    }
                }, 1000);
            }
        });
        pagerHelper = new PagerHelper(getContext(), 0, 50);
    }

/*    private void initRanking() {
        List<RankingBean> rankingList = new ArrayList<>();
        rankingList.add(new RankingBean(R.mipmap.rangking3, "商机推荐榜(公司)", "周冠军", R.mipmap.ic_zhaixingbang, "集团本部", "89", "临开发"));
        rankingList.add(new RankingBean(R.mipmap.rangking1, "商机推荐榜(个人)", "周冠军", R.mipmap.ic_yingxionga, "赵大志", "9", "漕开发总公司"));
        rankingList.add(new RankingBean(R.mipmap.rangking3, "商机落地榜", "周冠军", R.mipmap.ic_yingxiongb, "临港松江科技城", "29", "松江公司"));
        homeLvAdapter = new HomeLvAdapter(getActivity(), rankingList);
        homeRankingLv.setAdapter(homeLvAdapter);
        homeRankingLv.setOnItemClickListener(this);
    }*/

    private void initLvMsg() {
        if ("2".equals(userType) || "5".equals(userType)) {
            imgMsg = new int[]{R.mipmap.home_13, R.mipmap.home_shangjishenhe, R.mipmap.home_14, R.mipmap.home_16, R.mipmap.home_17};
            titleMsg = new String[]{Home.DAIBAN, Home.SHANGJI, Home.SYSMSG, Home.SYSGONGGAO, Home.ADD};
            contentMsg = new String[]{"您有@num条待处理的OA流程", "您有@num条待审核的商机申请", "您有@num条未读系统消息", "您有@num条未读系统公告", "本月招商共享信息库已新增@num条记录"};
        } else {
            imgMsg = new int[]{R.mipmap.home_13, R.mipmap.home_14, R.mipmap.home_16, R.mipmap.home_17};
            titleMsg = new String[]{Home.DAIBAN, Home.SYSMSG, Home.SYSGONGGAO, Home.ADD};
            contentMsg = new String[]{"您有@num条待处理的OA流程", "您有@num条未读系统消息", "您有@num条未读系统公告", "本月招商共享信息库已新增@num条记录"};
        }
        homeLvMsg = new ArrayList<>();
        for (int i = 0; i < titleMsg.length; i++) {
            HomeModeBean homeModeBean = new HomeModeBean();
            homeModeBean.setImg(imgMsg[i]);
            homeModeBean.setTitle(titleMsg[i]);
            homeModeBean.setName(contentMsg[i]);
            homeLvMsg.add(homeModeBean);
        }
        homeMsgLvAdapter = new HomeMsgLvAdapter(getActivity(), homeLvMsg);
        homeMeg.setAdapter(homeMsgLvAdapter);
        homeMeg.setOnItemClickListener(this);
    }

    private void initGvData() {
        img = new int[]{R.mipmap.home_2, R.mipmap.home_6, R.mipmap.home_7, R.mipmap.home_9,
                R.mipmap.home_4, R.mipmap.home_10, R.mipmap.home_11, R.mipmap.home_wodezhixing,
                R.mipmap.home_shangjikanban, R.mipmap.home_shangjituijian, R.mipmap.home_wodetuijian, R.mipmap.home_renlingshangji};
        title = new String[]{"产业园区", "租售物业", "配套服务", "招商政策",
                "存量客户", "通讯录", "一周安排", "我的执行",
                "商机看板", "我的推荐", "推荐商机", "认领商机"};
        ArrayList<HomeModeBean> homeGvList = new ArrayList<>();
        for (int i = 0; i < title.length; i++) {
            HomeModeBean homeModeBean = new HomeModeBean();
            homeModeBean.setImg(img[i]);
            homeModeBean.setTitle(title[i]);
            homeGvList.add(homeModeBean);
        }
        homeGvAdapter = new HomeGvAdapter(getActivity(), homeGvList);
        homeGv.setAdapter(homeGvAdapter);
        homeGv.setOnItemClickListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.more, R.id.home_search_all, R.id.logo, R.id.ll_land, R.id.ll_total})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.logo:
                startActivity(new Intent(getActivity(), GroupAc.class));
                break;
            case R.id.more:
                //                NewsAc.goToNewsAc(getContext());
                showPopupWindow(more);
                break;
            case R.id.home_search_all:
                HomeSearchActivity.goToHomeSearchActivity(getContext());
                break;
            case R.id.ll_land:
                String userType = LoginManager.getInstance().getUserInfo().getUserType();
                if (userType.equals("4") || userType.equals("5") || userType.equals("6")) {
                    jumToKanbanOppoList("4", "已落地商机");
                }
                break;
            case R.id.ll_total:
                String userT = LoginManager.getInstance().getUserInfo().getUserType();
                if (userT.equals("4") || userT.equals("5") || userT.equals("6")) {
                    jumToKanbanOppoList("", "全部商机");
                }
                break;
        }
    }

    /**
     * 显示popupwindow
     *
     * @param parent
     */
    public void showPopupWindow(View parent) {
        if (null == popupWindow) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.view_popupwindow, null);
            popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
            popupWindow.setContentView(view);
            popupWindow.setOutsideTouchable(true);
            popupWindow.setBackgroundDrawable(new BitmapDrawable());
            RecyclerView contentRv = (RecyclerView) view.findViewById(R.id.content_rv);
            contentRv.setLayoutManager(new LinearLayoutManager(getActivity()));
            PopupWindowAdapter adapter = new PopupWindowAdapter(getActivity(), initPopData());
            contentRv.setAdapter(adapter);

            adapter.setOnItemClickListener(new RecycleBaseAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View view, Object item, int position) {

                    switch (position) {
                        case 0://推荐商机
                            Intent intent = new Intent(getActivity(), TjTunityOneAc.class);
                            intent.putExtra("tag", "home");
                            startActivity(intent);
                            break;
                        case 1://我的收藏
                            UserFavoritesAc.goToUserFavoritesAc(getContext());
                            break;
                        case 2://意见反馈
                            startActivity(new Intent(getActivity(), UserSuggestAddAc.class));
                            break;
                        case 3://应用分享
                            UserAppShare.gotoUserAppShare(getContext());
                            break;
                    }
                    popupWindow.dismiss();
                }
            });
        }
        popupWindow.showAsDropDown(parent, -100, 0);
    }

    /**
     * 初始化popupwindow数据
     *
     * @return
     */
    private List<PopWindowBean> initPopData() {
        List<PopWindowBean> mList = new ArrayList<>();
        PopWindowBean bean1 = new PopWindowBean(R.mipmap.home_pop_tuijian, "推荐商机");
        PopWindowBean bean2 = new PopWindowBean(R.mipmap.home_pop_collect, "我的收藏");
        PopWindowBean bean3 = new PopWindowBean(R.mipmap.home_pop_feedback, "意见反馈");
        PopWindowBean bean4 = new PopWindowBean(R.mipmap.home_pop_share, "应用分享");

        mList.add(bean1);
        mList.add(bean2);
        mList.add(bean3);
        mList.add(bean4);

        return mList;
    }

    /**
     * 集团  园区  跳转到详情
     *
     * @param state
     */
    public void jumToKanbanOppoList(String state, String title) {
        Intent intent = new Intent(getActivity(), KanBanOppoListAc.class);
        intent.putExtra(Constants.TITLE, title);
        intent.putExtra(Constants.QUERY_STATE, state);
        startActivity(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Intent intent = new Intent();
        if (adapterView.getId() == R.id.home_gv) {//gv
            switch (position) {
                case 0://产业园区
                    intent.setClass(getActivity(), YuanQuAc.class);
                    startActivity(intent);
                    break;
                case 1://租售物业
                    intent.setClass(getActivity(), BusinessAc.class);
                    startActivity(intent);
                    break;
                case 2://配套服务
                    intent.setClass(getActivity(), MatingAc.class);
                    startActivity(intent);
                    break;
                case 3://招商政策
                    intent.setClass(getActivity(), PolicyListAc.class);
                    startActivity(intent);
                    break;
                case 4://存量客户
                    intent.setClass(getActivity(), EntryAc.class);
                    startActivity(intent);
                    break;
                case 5://通讯录    ContactsCompanyAc
                    intent.setClass(getActivity(), ContactsAc.class);
                    startActivity(intent);
                    break;
                case 6://一周安排
                    intent.setClass(getActivity(), WeekPlanAc.class);
                    startActivity(intent);
                    break;
                case 7://我的执行
                    if ("1".equals(userType) || "2".equals(userType)
                            || "3".equals(userType) || "4".equals(userType)
                            || "5".equals(userType)) {
                        intent.setClass(getActivity(), MyExecute.class);
                        startActivityForResult(intent, Constants.UserSuggestAdd);
                    } else {
                        ToastUtils.showToast(getActivity(), "权限不足");//该用户没有权限执行商机
                    }
                    break;
                case 8://商机看板
                    intent.setClass(getActivity(), BoardAc.class);
                    startActivity(intent);
                    break;
                case 9://我的推荐
                    intent.setClass(getActivity(), MyClaimAc.class);
                    startActivity(intent);
                    break;
                case 10: //推荐商机
                    intent.setClass(getActivity(), TjTunityOneAc.class);//GroomAc
                    intent.putExtra("tag", "home");
                    startActivity(intent);
                    break;
                case 11://认领商机
                    if ("1".equals(userType) || "2".equals(userType)
                            || "3".equals(userType) || "4".equals(userType)
                            || "5".equals(userType)) {
                        intent.setClass(getActivity(), RlTunityAc.class);//ClaimAc
                        intent.putExtra("tag", "home");
                        startActivity(intent);
                    } else {
                        ToastUtils.showToast(getActivity(), "权限不足");//该用户没有权限认领商机
                    }
                    break;
            }
        } else if (adapterView.getId() == R.id.home_meg) {// 消息通知
            String title = titleMsg[position];
            switch (title) {
                case Home.DAIBAN://代办流程
                    NeedAc.goToNeedAc(getActivity());
                    break;
                case Home.SHANGJI://商机审核
                    intent.setClass(getActivity(), MyExamineAc.class);
                    startActivity(intent);
                    break;
                case Home.SYSMSG://系统消息
                    intent.setClass(getActivity(), MessageAc.class);
                    startActivity(intent);
                    break;
                case Home.SYSGONGGAO://系统公告
                    intent.setClass(getActivity(), NoticeAc.class);
                    startActivity(intent);
                    break;
                case Home.ADD://最近新增
                    intent.setClass(getActivity(), NewAddAc.class);
                    startActivity(intent);
                    break;
            }
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constants.UserSuggestAdd && resultCode == Constants.refreshCode) {
            if (dialogOne == null)
                dialogOne = new DialogOne(getActivity());
            dialogOne.show("您的反馈对我们非常重要，我们将更加努力的改善我们的APP");
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            getUnreadMsg();
            getNewestOpp();
        }
    }

    /**
     * 获取消息数量
     */
    private void getUnreadMsg() {
        HttpParams params = new HttpParams();
        params.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.UNREAD_NUM).params(params)
                .tag(this).execute(new ResCallBack<MsgBean>(getActivity(), false) {
            @Override
            public void onCall(MsgBean msgBean, Call call, Response response) throws JSONException {
                if (null != msgBean) {
                    for (int i = 0; i < titleMsg.length; i++) {
                        String sysTitle = titleMsg[i];
                        if (Home.DAIBAN.equals(sysTitle)) {//待办流程
                            homeLvMsg.get(i).setCount(Integer.parseInt(msgBean.getData().getOaNum()));
                            continue;
                        }
                        if (Home.SHANGJI.equals(sysTitle)) {    //商机审核
                            homeLvMsg.get(i).setCount(Integer.parseInt(msgBean.getData().getReviewNum()));
                            continue;
                        }
                        if (Home.SYSMSG.equals(sysTitle)) {  //系统消息
                            homeLvMsg.get(i).setCount(Integer.parseInt(msgBean.getData().getSystemNum()));
                            continue;
                        }
                        if (Home.SYSGONGGAO.equals(sysTitle)) {//系统公告
                            homeLvMsg.get(i).setCount(Integer.parseInt(msgBean.getData().getEnterpriseNoticeNum()));
                            continue;
                        }
                        if (Home.ADD.equals(sysTitle)) {//本月新增
                            homeLvMsg.get(i).setCount(Integer.parseInt(msgBean.getData().getRecentlyAddedNum()));
                        }
                    }
                    homeMsgLvAdapter.notifyDataSetChanged();
                    int msgTotalCount = Integer.parseInt(msgBean.getData().getOaNum())
                            + Integer.parseInt(msgBean.getData().getReviewNum())
                            + Integer.parseInt(msgBean.getData().getSystemNum())
                            + Integer.parseInt(msgBean.getData().getEnterpriseNoticeNum());

                    EventBus.getDefault().post(new SysmsgEvent(SysmsgEvent.Type.SHORTCUT_UPDATE, msgTotalCount));
                }
            }
        });
    }

    /**
     * 获取轮播图数据
     */
    private void getBanner() {
        HttpParams params = new HttpParams();
        params.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.queryShowAdvertising)
                .params(params)
                .tag(this)
                .execute(new ResCallBack<HomeBanner>(getActivity()) {
                    @Override
                    public void onCall(HomeBanner msgBean, Call call, Response response) {
                        //缓存数据
                        List<HomeBanner.DataBean> data = msgBean.getData();
                        if (data.size() != 0) {
                            SPUtils.put(getActivity(), "banner", JsonUtil.getGson().toJson(msgBean));
                            bannerImg.setVisibility(View.GONE);
                        }
                        getNewestOpp();
                        installBannerData(msgBean);
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        getNewestOpp();
                    }
                });
    }

    private void installBannerData(HomeBanner msgBean) {
        ArrayList<String> bannerImg = new ArrayList<>();
        List<HomeBanner.DataBean> data = msgBean.getData();
        for (HomeBanner.DataBean homeBanner :
                data) {
            bannerImg.add(HttpApi.IMAGE_BASE_SERVER + homeBanner.getShowUrl());
        }
        initBanner(data, bannerImg);
    }

    private void initBanner(final List<HomeBanner.DataBean> data, ArrayList<String> imgList) {
        if (null != imgList && imgList.size() > 0) {
            banner.setImageLoader(new GlideImageLoader());
            //设置图片集合
            banner.setImages(imgList);
            //设置banner动画效果
            banner.setBannerAnimation(Transformer.Default);
            //设置标题集合（当banner样式有显示title时）
//        banner.setBannerTitles(bannerTv);
            //设置自动轮播，默认为true
            banner.isAutoPlay(true);
            //设置轮播时间
            banner.setDelayTime(5000);
            //设置指示器位置（当banner模式中有指示器时）
            banner.setIndicatorGravity(BannerConfig.RIGHT);
            banner.setOnBannerClickListener(new OnBannerClickListener() {
                @Override
                public void OnBannerClick(int position) {
                    typeJumpAc(data, position);
                }
            });
            //banner设置方法全部调用完毕时最后调用
            banner.start();
        }
    }

    private void typeJumpAc(List<HomeBanner.DataBean> data, int position) {
        if (data != null && position - 1 <= data.size()) {
            HomeBanner.DataBean dataBean = data.get(position - 1);
            switch (dataBean.getAdvertisingType()) {
                case "1"://无响应事件
                    break;
                case "2"://2.进入“route”中心，根据modelType判断需要跳转的View，如果modelMessageId不为null则直接显示详细页面。
                    startActivity(BannerJumpUtils.getInstance().getTypeIntent(getActivity(), dataBean));
                    break;
                case "3"://弹出webView，显示detailUrl记录的H5页面
                    Intent intent = new Intent(getActivity(), WebAc.class);
                    intent.putExtra("title", "");
                    intent.putExtra("url", HttpApi.IMAGE_BASE_SERVER + dataBean.getDetailUrl());
                    startActivity(intent);
                    break;
            }
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        //开始轮播
        banner.startAutoPlay();
        handler.sendEmptyMessageDelayed(199, 3000);
    }

    @Override
    public void onStop() {
        super.onStop();
        //结束轮播
        banner.stopAutoPlay();
        handler.removeMessages(199);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        handler.removeMessages(199);
        EventBus.getDefault().unregister(this);
    }

    /**
     * 获取全员招商
     */
    private void getNewestOpp() {
        HttpParams params = new HttpParams();
        params.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.queryNewestOpportunity)
                .params(params)
                .tag(this)
                .execute(new ResCallBack<HomeSwitchTv>(getActivity(), false) {
                    @Override
                    public void onCall(HomeSwitchTv msgBean, Call call, Response response) {
                        getKanBanData();
                        msgBeanData = msgBean.getData();
                        if (msgBeanData.size() > 0) {
                            llSwitch.setVisibility(View.VISIBLE);
                            toastContent.setText(msgBeanData.get(0).getShowContent());
                            setTunityState(msgBeanData.get(0).getShowState());
                            handler.removeMessages(199);
                            handler.sendEmptyMessageDelayed(199, 3000);
                        } else {
                            llSwitch.setVisibility(View.GONE);
                        }
                    }

                    @Override
                    public void onError(Call call, Response response, Exception e) {
                        getKanBanData();
                    }
                });
    }

    private void setTunityState(String state) {
        switch (state) {
            case "2"://待认领
                imgState.setImageResource(R.mipmap.ic_sy_dairenling);
                break;
            case "3"://执行中
                imgState.setImageResource(R.mipmap.ic_sy_zhixingzhong);
                break;
            case "4"://已落地
                imgState.setImageResource(R.mipmap.ic_sy_yiluodi);
                break;
            default:
                imgState.setImageResource(0);
                break;
        }
    }

    /**
     * 商机看板数据
     */
    private void getKanBanData() {
        HttpParams params = new HttpParams();
        params.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.KANBAN).params(params)
                .execute(new ResCallBack<KanbanBean>(getActivity(), false) {
                    @Override
                    public void onCall(KanbanBean responseBean, Call call, Response response) throws JSONException {
                        totalTv.setText(responseBean.getData().getTotalNum());
                        yiluodiTv.setText(responseBean.getData().getSuccess());
                    }
                });
    }

    /**
     * 全员招商点击事件
     */
    @OnClick(R.id.ll_switch)
    public void onViewClicked() {
        String userType = LoginManager.getInstance().getUserInfo().getUserType();
        if (userType.equals("6") || userType.equals("5") || userType.equals("4")) {
            String showState = msgBeanData.get(number - 1).getShowState();
            if (showState.equals("2") || showState.equals("3")) { //wo de tuij

                OpportunityDetailsAc.gotoOpportunityDetailsAc(getActivity(), "HomeFragment",
                        msgBeanData.get(number - 1).getKeyId(),
                        msgBeanData.get(number - 1).getShowState(),
                        Constants.OppPageStateType.MyClaimAc,
                        new Constants.ParamLandType(msgBeanData.get(number - 1).getHaveWorkshop(),
                                msgBeanData.get(number - 1).getHaveOffice(),
                                msgBeanData.get(number - 1).getHaveLand(),
                                msgBeanData.get(number - 1).getHaveEnterpriseType()));
            } else if (showState.equals("4")) {
                Intent intent = new Intent(getActivity(), OppExamineDetailsAc.class);
//                intent.putExtra(Constants.isActive, "0");  //只能查看，不能操作
                intent.putExtra(Constants.OPP_DETAILS_SHOW_STATE, "2");//1 待审核    2 已审核
                intent.putExtra(Constants.DETAILS_TYPE, Constants.RECOMMEND_DETAILS);
                intent.putExtra(Constants.OPP_PAGE_STATE_TYPE, Constants.OppPageStateType.MyExamine);
                intent.putExtra(Constants.ALL_TYPE, "2");  //2 落地审核
                intent.putExtra(Constants.OPP_DETAILS_ID, msgBeanData.get(number - 1).getKeyId());//商机详情ID
                intent.putExtra(Constants.OppState.Landed, Constants.OppState.Landed);
                intent.putExtra(Constants.OPP_SHOW_STATE, showState);
                intent.putExtra(Constants.OPP_LAND_TYPE, new Constants.ParamLandType(msgBeanData.get(number - 1).getHaveWorkshop(),
                        msgBeanData.get(number - 1).getHaveOffice(),
                        msgBeanData.get(number - 1).getHaveLand(),
                        msgBeanData.get(number - 1).getHaveEnterpriseType()));//需求类型(厂房,研发办公,土地,注册型企业)
                startActivity(intent);
            }
        }
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 199) {
                if (msgBeanData != null && msgBeanData.size() > 1) {
                    if (number < msgBeanData.size()) {
                        toastContent.setText(msgBeanData.get(number).getShowContent());
                        setTunityState(msgBeanData.get(number).getShowState());
                        number++;
                    } else {
                        toastContent.setText(msgBeanData.get(0).getShowContent());
                        setTunityState(msgBeanData.get(0).getShowState());
                        number = 1;
                    }
                    handler.sendEmptyMessageDelayed(199, 3000);
                }
            }
        }
    };

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void updateSysmsg(UpdateSysmsgEvent event) {
        getUnreadMsg();
    }
}

