package com.lingang.fragment.update;


import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.activity.business.UpdateTunityAc;
import com.lingang.activity.tunity.NexusAc;
import com.lingang.base.BaseFragment;
import com.lingang.bean.TunityDetailesBean;
import com.lingang.common.Constants;
import com.lingang.common.LoginManager;
import com.lingang.common.MyTextWatcher;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.utils.PermissionUtils;
import com.lingang.utils.ToastUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import okhttp3.Call;
import okhttp3.Response;

import static android.app.Activity.RESULT_OK;

public class UpdateTunityOneFr extends BaseFragment implements RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.tv_kehu)
    TextView tvKehu;
    @BindView(R.id.tv_ch)
    TextView tvCh;
    @BindView(R.id.rg_zc)
    RadioGroup rgZc;
    @BindView(R.id.img_name)
    ImageView imgName;
    @BindView(R.id.et_num)
    TextView etNum;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.rb_zc)
    RadioButton rbZc;
    @BindView(R.id.et_gsname)
    EditText etGsname;
    @BindView(R.id.et_mail)
    EditText etMail;
    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.sc_ll)
    ScrollView scLl;
    @BindView(R.id.tv_title)
    TextView titleTv;

    private UpdateTunityAc mActivity;
    private Unbinder unbinder;
    private String kh_valueId;
    private String tvChId;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (UpdateTunityAc) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_update_tunity_one, container, false);
        unbinder = ButterKnife.bind(this, view);

        titleTv.setText("更新商机信息");
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        PermissionUtils.checkPermission(getActivity(), new String[]{Manifest.permission.READ_CONTACTS, Manifest.permission.READ_PHONE_STATE});
        rgZc.setOnCheckedChangeListener(this);
        if (!TextUtils.isEmpty(mActivity.keyId)) {
            opportunityDetail();
        }

        editText.addTextChangedListener(new MyTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                etNum.setText(s.length() + "/50");
            }
        });

        scLl.smoothScrollTo(0, 0);
    }

    @OnClick({R.id.ll_keh, R.id.ll_chengh, R.id.btn_next, R.id.btn_contacts, R.id.ib_left})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_keh://客户关系
                startActivityForResult(new Intent(getActivity(), NexusAc.class)
                        .putExtra("tag", "客户关系")
                        .putExtra("basicsType", "18"), Constants.NexusKeh);
                break;
            case R.id.ll_chengh://称呼
                startActivityForResult(new Intent(getActivity(), NexusAc.class)
                        .putExtra("tag", "称呼")
                        .putExtra("basicsType", "19"), Constants.NexusChengh);
                break;
            case R.id.btn_next://下一步
                if (testData()) {
                    severData();
                    mActivity.addFragment(new UpdateTunityTwoFr());
                    mActivity.showFragment(1);
                }
                break;
            case R.id.btn_contacts://通讯录
                startActivityForResult(new Intent(Intent.ACTION_PICK,
                        ContactsContract.Contacts.CONTENT_URI), Constants.Work_Ld);
                break;
            case R.id.ib_left:
                getActivity().finish();
                break;
        }
    }

    /**
     * 判空
     *
     * @return
     */
    private boolean testData() {
        if (TextUtils.isEmpty(etName.getText().toString().trim())) {
            ToastUtils.showToast(getActivity(), "请输入客户姓名");
            return false;
        }

        if (TextUtils.isEmpty(etPhone.getText().toString().trim())) {
            ToastUtils.showToast(getActivity(), "请输入客户手机");
            return false;
        }

        if (TextUtils.isEmpty(kh_valueId)) {
            ToastUtils.showToast(getActivity(), "请输入客户关系");
            return false;
        }

        if (rbZc.isChecked()) {
            if (TextUtils.isEmpty(etGsname.getText().toString().trim())) {
                ToastUtils.showToast(getActivity(), "请输入企业名称");
                return false;
            }
        }
        return true;
    }

    /**
     * 获取商机详情数据
     */
    private void opportunityDetail() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("keyId", mActivity.keyId);
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.opportunity_detail)
                .params(httpParams)
                .execute(new ResCallBack<TunityDetailesBean>(getActivity()) {
                    @Override
                    public void onCall(TunityDetailesBean responseBean, Call call, Response response) {
                        if (null != responseBean) {
                            mActivity.setTunityDetailesBean(responseBean);
                            fillViewData();
                        }
                    }
                });
    }

    /**
     * 填充数据
     */
    private void fillViewData() {
        if (null != mActivity.getTunityDetailesBean()) {
            TunityDetailesBean.DataBean data = mActivity.getTunityDetailesBean().getData();
            if (null != data) {
                viewFillData(data.getCustomerName(), etName);
                viewFillData(data.getCustomerTel(), etPhone);
                viewFillData(data.getCustomerRelationshipName(), tvKehu);
                kh_valueId = data.getCustomerRelationshipId();
                viewFillData(data.getCustomerCallName(), tvCh);
                tvChId = data.getCustomerCallId();
                viewFillData(data.getCustomerMail(), etMail);
                viewFillData(data.getCustomerEnterpriseName(), etGsname);
                viewFillData(data.getCustomerEnterpriseKeywords(), editText);
                rgZc.check(data.getCustomerEnterpriseIsregister().equals("1") ? R.id.rb_zc : R.id.rb_zccd);
            }
        }
    }

    /**
     * 保存数据
     *
     * @return
     */
    private TunityDetailesBean.DataBean severData() {
        if (null != mActivity.getTunityDetailesBean()) {
            TunityDetailesBean.DataBean data = mActivity.getTunityDetailesBean().getData();
            if (null != data) {
                data.setCustomerName(etName.getText().toString());
                data.setCustomerTel(etPhone.getText().toString());
                data.setCustomerRelationshipId(kh_valueId);
                data.setCustomerRelationshipName(TextUtils.isEmpty(tvChId) ? "" : tvKehu.getText().toString());
                data.setCustomerCallId(tvChId);
                data.setCustomerCallName(TextUtils.isEmpty(tvChId) ? "" : tvCh.getText().toString());
                data.setCustomerMail(etMail.getText().toString());
                data.setCustomerEnterpriseName(etGsname.getText().toString());
                data.setCustomerEnterpriseKeywords(editText.getText().toString());
                data.setCustomerEnterpriseIsregister(rbZc.isChecked() ? "1" : "0");
                return data;
            }
        }
        return null;
    }

    private void viewFillData(String text, TextView view) {
        if (!TextUtils.isEmpty(text)) {
            view.setText(text);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case Constants.NexusChengh://称呼
                if (resultCode == Constants.NexusChengh && data != null) {
                    tvChId = data.getStringExtra("valueId");
                    tvCh.setText(data.getStringExtra("value"));
                }
                break;
            case Constants.NexusKeh://客户关系
                if (resultCode == Constants.NexusKeh && data != null) {
                    kh_valueId = data.getStringExtra("valueId");
                    tvKehu.setText(data.getStringExtra("value"));
                }
                break;
            case Constants.Work_Ld://通讯录
                if (resultCode == RESULT_OK && data != null) {
                    Uri uri = data.getData();
                    String[] contacts = getPhoneContacts(uri);
                    if (!TextUtils.isEmpty(contacts[0]))
                        etName.setText(contacts[0]);
                    if (!TextUtils.isEmpty(contacts[1]))
                        etPhone.setText(getPhone(contacts[1]));
                }
                break;
        }
    }

    public String getPhone(String phone){
        return phone.replace("-","");
    }

    /**
     * 获取选择后的联系人信息
     */
    private String[] getPhoneContacts(Uri uri) {
        String[] contact = new String[2];
        //得到ContentResolver对象
        ContentResolver cr = getActivity().getContentResolver();
        //取得电话本中开始一项的光标
        Cursor cursor = cr.query(uri, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            //取得联系人姓名
            int nameFieldColumnIndex = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
            contact[0] = cursor.getString(nameFieldColumnIndex);
            //取得电话号码
            String ContactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
            Cursor phone = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=" + ContactId, null, null);
            if (phone != null) {
                phone.moveToFirst();
                contact[1] = phone.getString(phone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            }
            phone.close();
            cursor.close();
        } else {
            return null;
        }
        return contact;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.rb_zc:
                imgName.setVisibility(View.VISIBLE);
                break;
            case R.id.rb_zccd:
                imgName.setVisibility(View.INVISIBLE);
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
