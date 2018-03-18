package com.lingang.dialog;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.lingang.App;
import com.lingang.R;
import com.lingang.common.Constants;
import com.lingang.http.HttpApi;
import com.lingang.utils.ToastUtils;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;


/**
 * 使用友盟分享集成的自定义分享对话框,注意以下配置
 * 1.在Application配置初始化UMShareAPI.get(this); 和微信，QQ，新浪账号
 * 2.在AndroidManifest.xml配置友盟账号和微信，QQ，新浪账号等分享启动的activity
 * 3.debug模式下,需要 app/build.gradle里面配置debug签名和umeng相关分享程序的jar包
 * 4.使用 ShareDialog的示例代码
 * //初始化最好写在activity onCreate中
 * ShareDialog shareDialog=new ShareDialog(this);
 * //分享，写在按钮事件中
 * shareDialog.share(new ShareAction(this)
 * .withTitle("title")
 * .withTargetUrl("http://www.share.com/123.html"), new ShareDialog.OnshareResultListener() {
 *
 * @Override public void onResult(int shareType) {
 * LogUtil.d(TAG, "分享成功");
 * }
 * @Override public void onError(int shareType) {
 * LogUtil.d(TAG, "分享失败");
 * }
 * @Override public void onCancle(int shareType) {
 * LogUtil.d(TAG, "分享取消");
 * }
 * });
 * shareDialog.show();
 */

public class ShareDialog extends Dialog implements View.OnClickListener {
    private static final String TAG = "ShareDialog";
    private OnShareDialigItemClickListener itemClick;
    private OnshareResultListener shareListener;
    public ShareAction shareAction;

    public int shareType;

    public ShareDialog(Context context) {
        this(context, R.style.bottomShareDialogStyle);
    }

    public ShareDialog(Context context, int themeResId) {
        super(context, themeResId);
        init(context);
    }

    protected ShareDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        init(context);
    }

    private void init(Context context) {
        //设置dialog的宽
        Window dialogWindow = getWindow();
        dialogWindow.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.BOTTOM;
        dialogWindow.setAttributes(lp);

        View container = View.inflate(context, R.layout.widget_dialog_share, null);
        TextView sinaTv = (TextView) container.findViewById(R.id.share_dialog_sina);
        TextView qqTv = (TextView) container.findViewById(R.id.share_dialog_qq);
        TextView weixinTv = (TextView) container.findViewById(R.id.share_dialog_weixin);
        TextView friendTv = (TextView) container.findViewById(R.id.share_dialog_friend);
        Button cancelBtn = (Button) container.findViewById(R.id.cancel_btn);
        cancelBtn.setOnClickListener(this);
        sinaTv.setOnClickListener(this);
        qqTv.setOnClickListener(this);
        weixinTv.setOnClickListener(this);
        friendTv.setOnClickListener(this);
        setCanceledOnTouchOutside(true);
        setContentView(container);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.share_dialog_sina:
                if (itemClick != null) {
                    itemClick.itemClickListener(Constants.SHARE_SINA);
                }
                shareType = Constants.SHARE_SINA;
                if (shareAction != null && shareListener != null) {
                    shareAction.setPlatform(SHARE_MEDIA.SINA)
                            .setCallback(umShareListener).share();
                    dismiss();
                }
                //ToastUtils.showToast(getContext(),"暂不支持");
                break;
            case R.id.share_dialog_qq:
                if (itemClick != null) {
                    itemClick.itemClickListener(Constants.SHARE_QQ);
                }
                shareType = Constants.SHARE_QQ;
                if (shareAction != null && shareListener != null) {
                    shareAction.setPlatform(SHARE_MEDIA.QQ)
                            .setCallback(umShareListener)
                            .share();
                    dismiss();
                }
                break;
            case R.id.share_dialog_weixin:
                if (itemClick != null) {
                    itemClick.itemClickListener(Constants.SHARE_WX);
                }
                shareType = Constants.SHARE_WX;
                if (shareAction != null && shareListener != null) {
                    shareAction.setPlatform(SHARE_MEDIA.WEIXIN)
                            .setCallback(umShareListener)
                            .share();
                    dismiss();
                }
                break;
            case R.id.share_dialog_friend:
                if (itemClick != null) {
                    itemClick.itemClickListener(Constants.SHARE_FRIEND);
                }
                shareType = Constants.SHARE_FRIEND;
                if (shareAction != null && shareListener != null) {
                    shareAction.setPlatform(SHARE_MEDIA.WEIXIN_CIRCLE)
                            .setCallback(umShareListener)
                            .share();
                    dismiss();
                }
                break;
            case R.id.cancel_btn:
                dismiss();
                break;
        }

    }

    //友盟分享自定义对话框入口
    public void share(ShareAction shareAction, OnshareResultListener resultListener) {
        this.shareAction = shareAction;
        this.shareListener = resultListener;
        show();
    }


    //友盟分享结果的回调监听
    private UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Log.d("plat", "platform" + platform);
            shareListener.onResult(shareType);
        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            if (t != null) {
                Log.d("throw", "throw:" + t.getMessage());
            }
            shareListener.onError(shareType);
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            shareListener.onCancle(shareType);
        }

        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

    };


    //分享结果的监听
    public interface OnshareResultListener {
        void onResult(int shareType);

        void onError(int shareType);

        void onCancle(int shareType);
    }

    public interface OnShareDialigItemClickListener {
        void itemClickListener(int type);
    }

    public void setOnShareDialogItemClickListener(OnShareDialigItemClickListener listener) {
        this.itemClick = listener;
    }

}

