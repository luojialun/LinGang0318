package com.lingang.common;

import android.content.Intent;

import com.lingang.R;
import com.lingang.bean.ShowStateEnum;

import java.io.Serializable;
import java.security.acl.Group;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

/**
 * 公用属性
 */

public class Constants {
    public static final int PAGE_SIZE = 20;  //分页中每页显示的数量

    //glide 图片缓存最大容量，150M，根据自己的需求进行修改
    public static final int GLIDE_CATCH_SIZE = 150 * 1000 * 1000;
    // 图片缓存子目录
    public static final String GLIDE_CARCH_DIR = "image_catch";

    public static final int refreshCode = 90;//刷新状态码
    public static final int SUGGEST_FEEDBACK =91 ;

    /*****************应用是否在前台或后台*****************/
    public static boolean isForeground = true;//标志前台或后台
    public static final int GESTURE_PWD_DELAY_TIME = 300000;//后台运行时间
    //public static final int GESTURE_PWD_DELAY_TIME = 3000;
    public static long stopTime;//停止时间


    public static final String IS_GESTURE_SHIP_LOGIN = "isGestureShipLogin";//是否是手势登录页跳转至登录页面
    public static final String USER_ACCOUNT = "userAccount";
    public static final String USER_PASSWORD = "userPassword";


    public static final String MESSAGE_RECEIVED_ACTION = "com.lingang.action.MESSAGE_RECEIVED_ACTION";
    public static final String KEY_MESSAGE = "message";
    public static final String KEY_EXTRAS = "extras";
    /**
     * 电话权限
     */
    public static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1;

    /***********************分享对话框分享平台类型***********************/
    public static final int SHARE_SINA = 1;  //新浪
    public static final int SHARE_QQ = 2;    //qq
    public static final int SHARE_WX = 3;   //微信
    public static final int SHARE_FRIEND = 4;  // 朋友圈


    public static final int MessageType_Correct = 1;//信息纠错
    public static final int MessageType_Suggest = 2;//意见反馈

    /*****************手势密码相关字段************************/
    public static final String SET_GETSTURE_TYPE = "isMofifyGesture";  //设置手势密码的类型

    //pdf查看相关
    public static final String PDF_TITLE = "title";  //pdf查看intent对应的title
    public static final String PDF_ADDRESS = "address";   //pdf查看intent对应的地址 如果是预览则传网络下载地址，如果是已经下载传文件位置
    public static final String PDF_VIEW_TYPE = "type";   //pdf查看的类型  1为预览 2位下载查看
    public static final int PDF_VIEW_PREVIEW = 1;   //pdf查看的类型  1为预览
    public static final int PDF_VIEW_DOWNLOAD = 2;   //pdf查看的类型 2位下载查看

    public static final String paramTaskId = "taskID";//待办任务ID参数Key
    public static final String paramTaskName = "taskName";//待办任务ID参数Key
    public static final int UserSuggestAdd = 999;//页面跳转标记
    public static final int NexusKeh = 888;//页面跳转标记
    public static final int NexusChengh = 777;//页面跳转标记
    public static final int Need = 666;//页面跳转标记
    public static final int Plan_Ld = 555;//页面跳转标记
    public static final int Plan_Qw = 444;//页面跳转标记
    public static final int Zhuc_Class = 333;//页面跳转标记
    public static final int Lad_Qw = 222;//页面跳转标记
    public static final int Lad_Xz = 111;//页面跳转标记

    public static final int LandGetBack = 716;//土地取得方式


    public static final int Work_Ld = 1000;//页面跳转标记
    public static final int Work_Qw = 1001;//页面跳转标记

    public static final int REQUEST_FINISH = 10000;

    public static final String ALL_STATE = "全部状态";
    public static final String AUDIT = "待审核";
    public static final String CLAIM = "待认领";
    public static final String EXECUTION = "执行中";
    public static final String LANDED = "已落地";
    public static final String REVOKE = "已撤销";
    public static final String BACK = "已退回";

    public static final String ALL_TYPE = "全部类型";
    public static final String FACTORY = "厂房";
    public static final String OFFICE = "研发办公";
    public static final String LAND = "土地";
    public static final String REGISTERED_ENTERPRISE = "注册型企业";

    public static final String WAIT_EXAMINE = "待审核";
    public static final String EXAMINED = "已审核";

    public static final String RECOMMAND_EXAMINE = "推荐审核";
    public static final String LAND_EXAMINE = "落地审核";

    public static final String TRANSFER = "已转移";
    public static final String ASSIGN = "已指派";

    public static final String ALL_SOURCE = "全部来源";
    public static final String A = "A类";
    public static final String B = "B类";
    public static final String C = "C类";

    public static final String OPPORTUNITY_ID = "opportunityId";
    public static final String CHOOSE_PARK_ID = "chooseParkId";
    public static final String CHOOSE_USER_ID = "chooseUserId";
    public static final String KEY_ID = "keyId";
    public static final String BEAN = "bean";
    public static final String UNDO = "undo";
    public static final String RETURN_BUSINESS = "returnBusiness";

    public static final String JUMP_TYPE = "跳转类型";
    public static final String REDISTRIBUTE = "重新发布";
    public static final String EDIT_OPPORTUNITY = "编辑商机";
    public static final String TRANSFER_OPP = "转移商机";
    public static final String ASSIGN_OPP = "指派商机";
    public static final String TRANSFER_ILL = "转移说明";
    public static final String ASSIGN_ILL = "指派说明";
    public static final String USER_NAME = "转移/指派对象";

    public static final int STATE = 0;  //全部状态
    public static final int TYPE = 1;   //全部类型
    public static final int SOURCE = 2; //全部来源
    public static final int PARK = 3;   //全部园区

    public static final String QUERY_STATE = "queryState"; //看板数据 查询状态
    public static final String QUERY_PARK = "parkbean";      //园区类

    public static final String VERSION_CONTENT = "version_content";

    public static final String NETWORK_ERROR = "无网络，请检查网络是否连接";
    public static final String isActive="isactive";
    public static final String TITLE="title";
    public static final String DETAILS_TYPE="details";
    public static final String EXAMINE_DETAILS="examine_details";  //商机审核详情
    public static final String RECOMMEND_DETAILS="recommend_details";
    public static final String EXECUTE_DETAILS="execute_details";

    public static final String RENT="租赁";
    public static final String BUY="购买";

    /**
     * 消息状态
     */
    public class MessageState {
        //未回复
        public final static int notReply = 1;
        //已回复
        public final static int reply = 2;
        //已删除
        public final static int delete = 3;
        //未读
        public final static int unread = 4;
        //已读
        public final static int read = 5;
    }

    /**
     * 弹出框选择类型
     */
    public class DialogSelectType {
        public final static int ok = 1;
        public final static int cancel = 0;
    }

    /**
     * 手势状态
     */
    public class GestureState {
        //1为第一次登陆时提醒设置
        public static final int SET_GETSTURE_TYPE_FIRSR_LOGIN = 1;
        //2 修改设置
        public static final int SET_GETSTURE_TYPE_MODIFY = 2;
        //3 当登陆时未设置
        public static final int SET_GETSTURE_TYPE_SETTING_INTO = 3;
    }

    /**
     * 启用手势密码的开关状态
     */
    public class GestureSwitch {
        //1.开启
        public static final int GESTURE_SWITCH_OPEN = 1;
        //2.关闭
        public static final int GESTURE_SWITCH_CLOSE = 2;
    }

    /**
     * 登录类型
     */
    public class LoginType {
        //普通密码登录
        public static final int loginNormal = 1;
        //手势密码登录
        public static final int loginPwdGesture = 2;
        //默认登录
        public static final int defaultNormal = 3;
    }

    /**
     * 是否有子流程
     */
    public class FlowIsSubState {
        /**
         * 有
         */
        public static final String yes = "1";
        /**
         * 无
         */
        public static final String no = "0";
    }

    /**
     * 待办流程-单个任务流转状态
     */
    public class FlowTaskNodeType {
        //开始0
        public static final int nodeTypeStart = 0;
        public static final String nodeTypeStartText = "开始";
        //审批1
        public static final int nodeTypeReview = 1;
        public static final String nodeTypeReviewText = "已通过";

        public static final String nodeTypeProcessText = "进行中";
        //结束6
        public static final int nodeTypeEnd = 6;
        public static final String nodeTypeEndText = "已完成";
    }

    /**
     * 收藏类型
     */
    public class FavoritesType {
        //1.集团园区
        public static final int Group = 1;
        //2.合作伙伴
        public static final int PARTNER = 2;
        //3.服务机构
        public static final int SERVICE = 3;
        //4.入驻企业
        public static final int ENTRY = 4;
        //5.公共平台
        public static final int PUBLIC = 5;
        //6.租售物业
        public static final int BUSINESS = 6;
        //7.新闻
        public static final int NEWS = 7;
        //8.政策
        public static final int POLICY = 8;
    }

    /**
     * 纠错类型
     */
    public class CorrectType {
        //新闻
        public static final int NEWS = 1;
        //政策列表
        public static final int POLICY = 2;
        //产业园区
        public static final int PARK = 3;
        //合作伙伴
        public static final int Partner = 4;
        //产业集群
        public static final int Industry = 5;
        //配套服务
        public static final int Mating = 6;
        //企业入驻
        public static final int Entry = 7;
        //公共平台
        public static final int Public = 8;
        //个人中心
        public static final int Mine = 9;
        //租售物业
        public static final int Business = 10;
    }

    /**
     * 记录类型
     */
    public class RecordType {
        //产业园区
        public static final int PARK = 3;
        //企业入驻
        public static final int Entry = 4;
        //合作伙伴
        public static final int Partner = 5;
        //(租售物业)招商项目
        public static final int Business = 6;
        //(配套服务)服务机构
        public static final int Service = 7;
        //公共平台
        public static final int Public = 8;
    }

    public class MessageType {
        //信息纠错
        public static final int Correc = 1;
        //意见反馈
        public static final int Message = 2;
        //产业园区
        public static final int PARK = 3;
        //入驻企业
        public static final int Entry = 4;
        //合作伙伴
        public static final int Partner = 5;
        //(租售物业)招商项目
        public static final int Business = 6;
        //(配套服务)服务机构
        public static final int Service = 7;
        //公共平台
        public static final int Public = 8;
        //系统公告
        public static final int System = 9;
        //版本更新
        public static final int UpdateVersion = 10;

    }

    /**
     * 更新类型
     */
    public class UpdateType {
        //Android
        public static final String ANDROID = "1";
        //ios
        public static final String IOS = "2";
    }

    /**
     * 收藏类型
     */
    public class CollectState {
        //未收藏
        public static final String collect = "0";
        //已收藏
        public static final String collected = "1";
    }

    //商机列表=》商机详情 KEY
    public static final String OPP_DETAILS_ID = "opp_details_id";
    public static final String OPP_SHOW_STATE="show_state";
    public static final String OPP_DETAILS_SHOW_STATE = "opp_details_show_state";
    public static final String OPP_PAGE_STATE_TYPE = "opp_page_state_type";
    public static final String OPP_LAND_TYPE = "opp_land_type";
    public static final String OPP_OPP_BEAN = "opp_opp_bean";
    public static final String OPP_USER_NAME = "user_name";
    public static final String OPP_USER_ID = "user_id";

    /**
     * ShowState页面类型
     */
    public enum OppPageStateType implements Serializable {
        //我的审核
        MyExamine,
        //我的执行
        MyExecute,
        //我的推荐
        MyClaimAc,
        //商机看板列表
        KanbanOppo
    }

    //我的推荐 枚举状态
    public class OppState {
        //待审核
        public static final int PendingState = 1;
        public static final String Pending = "待审核";
        //待认领
        public static final int ClaimedState = 2;
        public static final String Claimed = "待认领";
        //执行中
        public static final int ExecutionState = 3;
        public static final String Execution = "执行中";
        //已落地
        public static final int LandedState = 4;
        public static final String Landed = "已落地";
        //已撤销
        public static final int RevokedState = 5;
        public static final String Revoked = "已撤销";
        //已退回
        public static final int ReturnedState = 6;
        public static final String Returned = "已退回";
        //已撤回
//        public static final int WithdrawnState = 7;
//        public static final String Withdrawn = "已撤回";
    }

    //我的推荐 列表
    public static Map<Integer, ShowStateEnum> recShowState = new HashMap<>();

    static {
        //待审核
        recShowState.put(OppState.PendingState, new ShowStateEnum(OppState.Pending, R.color.c_7eb2ec));
        //待认领
        recShowState.put(OppState.ClaimedState, new ShowStateEnum(OppState.Claimed, R.color.c_7eb2ec));
        //执行中
        recShowState.put(OppState.ExecutionState, new ShowStateEnum(OppState.Execution, R.color.f8943e));
        //已落地
        recShowState.put(OppState.LandedState, new ShowStateEnum(OppState.Landed, R.color.c_52d68e));
        //已退回
        recShowState.put(OppState.ReturnedState, new ShowStateEnum(OppState.Returned, R.color.c5c5c5));
        //已撤销
        recShowState.put(OppState.RevokedState, new ShowStateEnum(OppState.Revoked, R.color.c5c5c5));
    }


    //我的执行 枚举
    public class ExecuteState {
        //执行中
        public static final int ExecutionState = 1;
        public static final String Execution = "执行中";
        //待审核
        public static final int PendingState = 2;
        public static final String Pending = "待审核";
        //已转移
        public static final int MoveState = 3;
        public static final String Move = "已转移";
        //已委派
        public static final int AgentState = 4;
        public static final String Agent = "已指派";
        //已退回
        public static final int ReturnedState = 5;
        public static final String Returned = "已退回";
        //已落地
        public static final int LandedState = 6;
        public static final String Landed = "已落地";
        //已撤销
        public static final int RevokedState = 7;
        public static final String Revoked = "已撤销";

    }

    //我的执行 列表
    public static HashMap<Integer, ShowStateEnum> executeShowState = new HashMap<Integer, ShowStateEnum>();

    static {
        //执行中
        executeShowState.put(ExecuteState.ExecutionState, new ShowStateEnum(ExecuteState.Execution, R.color.f8943e));
        //待审核
        executeShowState.put(ExecuteState.PendingState, new ShowStateEnum(ExecuteState.Pending, R.color.c_7eb2ec));
        //已转移
        executeShowState.put(ExecuteState.MoveState, new ShowStateEnum(ExecuteState.Move, R.color.c5c5c5));
        //已指派
        executeShowState.put(ExecuteState.AgentState, new ShowStateEnum(ExecuteState.Agent, R.color.c5c5c5));//c_52d68e
        //已退回
        executeShowState.put(ExecuteState.ReturnedState, new ShowStateEnum(ExecuteState.Returned, R.color.c5c5c5));
        //已落地
        executeShowState.put(ExecuteState.LandedState, new ShowStateEnum(ExecuteState.Landed, R.color.c_52d68e));
        //已撤销
        executeShowState.put(ExecuteState.RevokedState, new ShowStateEnum(ExecuteState.Revoked, R.color.c5c5c5));
    }

    //审核状态
    public static Map<Integer, ShowStateEnum> exaShowState = new HashMap<>();

    static {
        exaShowState.put(1, new ShowStateEnum("待审核", R.color.c_7eb2ec));
        exaShowState.put(2, new ShowStateEnum("已审核", R.color.c_52d68e));
    }

    public static Map<Integer, ShowStateEnum> exaShowState2 = new HashMap<>();

    static {
        exaShowState2.put(1, new ShowStateEnum("审核已通过", R.color.c_52d68e));
        exaShowState2.put(2, new ShowStateEnum("审核未通过", R.color.c5c5c5));
    }

    //企业注册类型
    public static HashMap<Integer, String> regBusinessType = new HashMap<Integer, String>();

    static {
        regBusinessType.put(0, "未注册");
        regBusinessType.put(1, "已注册");
    }

    //看板商机数据
    public static HashMap<Integer, ShowStateEnum> oppoState = new HashMap<>();

    static {
        //待认领
        oppoState.put(2, new ShowStateEnum(OppState.Claimed, R.color.c_7eb2ec));
        //执行中
        oppoState.put(3, new ShowStateEnum(OppState.Execution, R.color.f8943e));
        //已落地
        oppoState.put(4, new ShowStateEnum(ExecuteState.Landed, R.color.c_52d68e));

    }

    public class OperateState {
        //开始
        public static final int Start = 0;
        //申请
        public static final int Apply = 1;
        //推荐审核
        public static final int RecomReview = 2;
        //推荐审核通过
        public static final int RecomReviewPassed = 3;
        //推荐审核不通过
        public static final int RecomReviewNot = 4;
        //逾期
        public static final int Overdue = 5;
        //认领
        public static final int Claim = 6;
        //发布
        public static final int Publish = 7;
        //撤回
        public static final int Withdraw = 8;
        //委派
        public static final int Agent = 9;
        //退回商机
        public static final int Returned = 10;
        //提交落地审核
        public static final int LandedReview = 11;
        //落地审核通过
        public static final int LandedReviewPassed = 12;
        //落地审核不通过
        public static final int LandedReviewNot = 13;
        //科产办撤销商机
        public static final int ExecutionFailed = 14;
        //转移
        public static final int Move = 15;
        //落地
        public static final int Landed = 16;
        //结束
        public static final int End = 17;
        //个人撤销
        public static final int Revoked = 18;
    }

    /**
     * 商机详情页刷新类型
     */
    public class OppDetailRefreshType {
        //请求类型
        public static final int RequestCode = 600;
        //更新执行
        public static final int UpdateExecute = 601;
        //更新商机
        public static final int UpdateOpp = 602;
        //提交落地
        public static final int SubmitLanded = 603;
        //转移/指派说明
        public static final int MoveOpp = 604;
        //补充信息
        public static final int BackSupple = 605;
        //
        public static final int RESPONSE_FINISH = 700;

    }

    /**
     * 土地需求类型
     */
    public static class ParamLandType implements Serializable {
        //有
        public static final String Yes = "1";
        //无
        public static final String No = "0";
        //厂房
        private String haveWorkshop;
        //研发办公
        private String haveOffice;
        //土地
        private String haveLand;
        //注册型企业
        private String haveEnterpriseType;
        //落地行驶
        private String typeId;

        public ParamLandType(String haveWorkshop, String haveOffice, String haveLand, String haveEnterpriseType, String typeId) {
            this.haveWorkshop = haveWorkshop;
            this.haveOffice = haveOffice;
            this.haveLand = haveLand;
            this.haveEnterpriseType = haveEnterpriseType;
            this.typeId = typeId;
        }

        public ParamLandType(String haveWorkshop, String haveOffice, String haveLand, String haveEnterpriseType) {
            this.haveWorkshop = haveWorkshop;
            this.haveOffice = haveOffice;
            this.haveLand = haveLand;
            this.haveEnterpriseType = haveEnterpriseType;
        }

        public String getHaveWorkshop() {
            return haveWorkshop;
        }

        public boolean hasHaveWorkshop() {
            return haveWorkshop.equals(Yes) ? true : false;
        }

        public void setHaveWorkshop(String haveWorkshop) {
            this.haveWorkshop = haveWorkshop;
        }

        public String getHaveOffice() {
            return haveOffice;
        }

        public boolean hasHaveOffice() {
            return haveOffice.equals(Yes) ? true : false;
        }

        public void setHaveOffice(String haveOffice) {
            this.haveOffice = haveOffice;
        }

        public String getHaveLand() {
            return haveLand;
        }

        public boolean hasHaveLand() {
            return haveLand.equals(Yes) ? true : false;
        }

        public void setHaveLand(String haveLand) {
            this.haveLand = haveLand;
        }

        public String getHaveEnterpriseType() {
            return haveEnterpriseType;
        }

        public boolean hasHaveEnterpriseType() {
            return haveEnterpriseType.equals(Yes) ? true : false;
        }

        public void setHaveEnterpriseType(String haveEnterpriseType) {
            this.haveEnterpriseType = haveEnterpriseType;
        }
    }

    public class Investment {
        public static final String TjTunityOne = "推荐商机";
        public static final String RlTunity = "认领商机";
        public static final String MyClaim = "我的推荐";
        public static final String EXECUTE = "我的执行";
        public static final String EXAMINE = "我的审核";
        public static final String KANBAN = "商机看板";

    }

    public class Home {
        public static final String DAIBAN = "待办流程";
        public static final String SHANGJI = "商机审核";
        public static final String SYSMSG = "系统消息";
        public static final String SYSGONGGAO = "系统公告";
        public static final String ADD = "最近新增";

    }

    public static final int recommend = 0; //我的推荐
    public static final int exacute = 1; //我的执行
    public static final int examine = 2; //我的审核
    public static final int claim = 3; //我的认领


}
