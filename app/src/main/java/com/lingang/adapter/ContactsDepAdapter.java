package com.lingang.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.lingang.R;
import com.lingang.base.RecycleBaseAdapter;
import com.lingang.bean.ContactsBean;
import com.lingang.common.LoginManager;
import com.lingang.glide.GlideImgManager;
import com.lingang.http.HttpApi;
import com.lingang.utils.adapterUtils.BaseViewHolder;

import java.util.List;

/**
 * Created by jason on 17/5/24.
 * 通信录-部门adapter
 */
public class ContactsDepAdapter extends RecycleBaseAdapter<ContactsBean> {

    private Context mContext;
//    private boolean dividerType = true;

    public ContactsDepAdapter(Context context, List<ContactsBean> data) {
        super(context, data);
        mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder holder, ContactsBean item, int position) {
        if (mData.get(position).getSign().equals("1")) {//布局1
            ImageView imageView=holder.getView(R.id.img_txhead);
//            String imgUrl = "https://apptest.shlingang.com/lingang-consumer/apiUtil/getUserPhoto.do?token=8E1BBC05281E4F1AAFF98D32B2F02950&userid=E07BE549-45B1-4414-BD43-1DA6621AD202";
            String imgUrl = HttpApi.HEADER + "?token=" + LoginManager.getInstance().getToken() + "&userid=" + item.getUserID();
            GlideImgManager.glideLoaderHead(mContext,imgUrl,imageView);
            holder.setText(R.id.contacts_emp_name, item.getUserCHName());
            holder.setText(R.id.tv_job, item.getJobName());
        } else {//布局2
            holder.setText(R.id.contacts_dep_name, item.getGroupName());
            LinearLayout depRL = holder.getView(R.id.contacts_dep_rl);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(depRL.getLayoutParams());
            if (item.isShowLine()) {
                lp.setMargins(0, 30, 0, 0);
                depRL.setLayoutParams(lp);
            } else {//防止服用
                lp.setMargins(0, 0, 0, 0);
                depRL.setLayoutParams(lp);
            }
        }

    }

    @Override
    protected int getItemViewLayoutId(int position, ContactsBean item) {
        //切换布局
        return mData.get(position).getSign().equals("1") ? R.layout.item_contacts_emp : R.layout.item_contacts_dep;
    }
}