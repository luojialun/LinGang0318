package com.lingang.dialog;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.base.BaseListAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jason on 17/5/31.
 */

public class ContactsSelectTypeDialog implements AdapterView.OnItemClickListener {
    private PopupWindow popupWindow;
    private View view;
    private Context mContext;
    private List<ContactsSearchType> mList;
    private ListView mListView;
    private OnSelectCallback onSelectListener;
    public ContactsSelectTypeDialog(Context context) {
        mContext = context;
        initData();
        if (popupWindow == null) {
            LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.view_contact_search_dialog, null);
            popupWindow = new PopupWindow(view, 400, 720);
        }
        mListView = (ListView) view.findViewById(R.id.contacts_search_lv);
        // 使其聚集
        popupWindow.setFocusable(true);
        // 设置允许在外点击消失
        popupWindow.setOutsideTouchable(true);
        // 这个是为了点击“返回Back”也能使其消失，并且并不会影响你的背景
        popupWindow.setBackgroundDrawable(new BitmapDrawable());

        ContactsSearchTypeAdapter adapter = new ContactsSearchTypeAdapter(mContext);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String name=mList.get(position).getName();
        if(onSelectListener !=null)
        {
            onSelectListener.onSelectItem(name);
        }
        popupWindow.dismiss();
    }

    private void initData() {
        mList = new ArrayList<>();
        mList.add(new ContactsSearchType(R.mipmap.ic_ygxm, "员工姓名"));
        mList.add(new ContactsSearchType(R.mipmap.ic_ygzh, "员工账号"));
        mList.add(new ContactsSearchType(R.mipmap.ic_sjhm, "手机号码"));
        mList.add(new ContactsSearchType(R.mipmap.ic_neixian, "内线电话"));
        mList.add(new ContactsSearchType(R.mipmap.ic_waixian, "直线电话"));
    }

    public void show(View parent) {

        WindowManager windowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        // 显示的位置为:屏幕的宽度的一半-PopupWindow的高度的一半
        int xPos = windowManager.getDefaultDisplay().getWidth() / 2
                - popupWindow.getWidth() / 2;
        popupWindow.showAsDropDown(parent, 0, 10);
    }

    /**
     * Adapter
     */
    public class ContactsSearchTypeAdapter extends BaseListAdapter<ContactsSearchType> {
        public ContactsSearchTypeAdapter(Context ctx) {
            super(ctx);
        }

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_contacts_dialog, null, false);
                viewHolder=new ViewHolder(convertView);
                convertView.setTag(viewHolder);
            }
            viewHolder= (ViewHolder) convertView.getTag();

            viewHolder.contactItemIconTxt.setImageResource(mList.get(position).getIcon());
            viewHolder.contactItemTxt.setText(mList.get(position).getName());
            return convertView;
        }
    }
    public class ViewHolder {
        @BindView(R.id.contact_item_icon_txt)
        ImageView contactItemIconTxt;
        @BindView(R.id.contact_item_txt)
        TextView contactItemTxt;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
    /**
     * 实体
     */
    public class ContactsSearchType {
        private int icon;
        private String name;

        public ContactsSearchType(int icon, String name) {
            this.icon = icon;
            this.name = name;
        }

        public int getIcon() {
            return icon;
        }

        public void setIcon(int icon) {
            this.icon = icon;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    /**
     * 设置选择回调
     * @param onListener
     */
    public void setSelectCallback(OnSelectCallback onListener)
    {
        onSelectListener=onListener;
    }
    public interface  OnSelectCallback
    {
        void onSelectItem(String selectName);
    }
}
