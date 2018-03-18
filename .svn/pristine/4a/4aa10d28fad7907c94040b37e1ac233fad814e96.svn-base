package com.lingang.activity.tunity;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.lingang.R;
import com.lingang.activity.MainActivity;
import com.lingang.base.BaseAc;
import com.lingang.bean.NeedBean;
import com.lingang.bean.TjTunityOneBean;
import com.lingang.bean.TjtunityTwoBean;
import com.lingang.bean.TunityDetailesBean;
import com.lingang.callback.DialogConfirmListion;
import com.lingang.callback.PermissionCallback;
import com.lingang.common.Constants;
import com.lingang.common.LoginManager;
import com.lingang.dialog.DialogTwo;
import com.lingang.http.HttpApi;
import com.lingang.http.ResCallBack;
import com.lingang.utils.JsonUtil;
import com.lingang.utils.PermissionUtils;
import com.lingang.utils.SPUtils;
import com.lingang.utils.ToastUtils;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.HttpParams;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Response;

public class TjTunityOneAc extends BaseAc implements DialogConfirmListion,
        RadioGroup.OnCheckedChangeListener, TextWatcher, PermissionCallback {

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
    private DialogTwo dialogTwo;
    private String kh_valueId;
    private String tvChId;
    private String keyId;
    private String opportunityId;
    private String tagState;//主要用于区分  提交数据时候是编辑商机还是重新发布商机

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contentView(R.layout.activity_tj_one_tunity);
        setTitle("推荐商机");
        setRightTv("规则");

        rgZc.setOnCheckedChangeListener(this);
        editText.addTextChangedListener(this);
        initView();
        scLl.smoothScrollTo(0, 0);
    }

    private void initView() {
        String tag = getIntent().getStringExtra("tag");
        if (tag.equals("home")) {//重首页进入时清空
            tagState = "send";
            cleanData();//防止进程被手动或者系统回首时 缓存的数据还在
        } else if (tag.equals("preview")) {//预览
            tagState = "send";
            fillViewData();
        } else if (tag.equals("edit")) {//编辑
            cleanData();//防止进程被手动或者系统回首时 缓存的数据还在
            tagState = "edit";
            keyId = getIntent().getStringExtra(Constants.KEY_ID);
            opportunityId = getIntent().getStringExtra(Constants.OPPORTUNITY_ID);
            opportunityDetail();
        } else if (tag.equals("repeat")) {//重发
            cleanData();//防止进程被手动或者系统回首时 缓存的数据还在
            tagState = "send";
            keyId = getIntent().getStringExtra(Constants.KEY_ID);
            opportunityId = getIntent().getStringExtra(Constants.OPPORTUNITY_ID);
            opportunityDetail();
        }
    }

    //填充数据
    private void fillViewData() {
        String tjTunityone = (String) SPUtils.get(this, "TjTunityOneBean", "");
        if (!tjTunityone.isEmpty()) {
            TjTunityOneBean tjTunityOneBean = JsonUtil.getGson().fromJson(tjTunityone, TjTunityOneBean.class);
            viewFillData(tjTunityOneBean.getName(), etName);
            viewFillData(tjTunityOneBean.getPhone(), etPhone);
            viewFillData(tjTunityOneBean.getNexus(), tvKehu);
            kh_valueId = tjTunityOneBean.getNexusId();
            viewFillData(tjTunityOneBean.getCall(), tvCh);
            tvChId = tjTunityOneBean.getCallId();
            viewFillData(tjTunityOneBean.getMailBox(), etMail);
            viewFillData(tjTunityOneBean.getCompanyName(), etGsname);
            viewFillData(tjTunityOneBean.getCompanyLable(), editText);
            rgZc.check(tjTunityOneBean.isZhuc() ? R.id.rb_zc : R.id.rb_zccd);
        }
    }

    @Override
    public void clickLeft() {
        showDialog();
    }

    @Override
    public void onBackPressed() {
        showDialog();
    }

    private void showDialog() {
        if (dialogTwo == null)
            dialogTwo = new DialogTwo(this, this);

        dialogTwo.show("取消", "确定", "退出后，商机信息将不会保存，请确认是否退出。");
    }


    //商机详情
    private void opportunityDetail() {
        HttpParams httpParams = new HttpParams();
        httpParams.put("keyId", keyId);
        httpParams.put("token", LoginManager.getInstance().getToken());
        OkGo.post(HttpApi.opportunity_detail)
                .params(httpParams)
                .execute(new ResCallBack<TunityDetailesBean>(this) {
                    @Override
                    public void onCall(TunityDetailesBean cluster, Call call, Response response) {
                        TunityDetailesBean.DataBean data = cluster.getData();
                        if (data != null)
                            keepData(data);
                    }
                });
    }

    private void keepData(TunityDetailesBean.DataBean data) {
        //缓存第一步数据
        TjTunityOneBean tjTunityOneBean = new TjTunityOneBean();
        tjTunityOneBean.setName(data.getCustomerName());
        tjTunityOneBean.setPhone(data.getCustomerTel());
        tjTunityOneBean.setNexus(data.getCustomerRelationshipName());
        tjTunityOneBean.setNexusId(data.getCustomerRelationshipId());
        tjTunityOneBean.setCall(data.getCustomerCallName());
        tjTunityOneBean.setCallId(data.getCustomerCallId());
        tjTunityOneBean.setMailBox(data.getCustomerMail());
        tjTunityOneBean.setZhuc(data.getCustomerEnterpriseIsregister().equals("1") ? true : false);
        tjTunityOneBean.setCompanyName(data.getCustomerEnterpriseName());
        tjTunityOneBean.setCompanyLable(data.getCustomerEnterpriseKeywords());

        String json = JsonUtil.getGson().toJson(tjTunityOneBean);
        SPUtils.put(TjTunityOneAc.this, "TjTunityOneBean", json);
        fillViewData();


        //缓存第二步数据
        TjtunityTwoBean tjtunityTwoBean = new TjtunityTwoBean();
        tjtunityTwoBean.setPlan_ld(TextUtils.isEmpty(data.getWorkshopTypeName()) ? "" : data.getWorkshopTypeName());
        tjtunityTwoBean.setPlan_ld_ID(data.getWorkshopTypeId());
        tjtunityTwoBean.setPlan_qw(TextUtils.isEmpty(data.getWorkshopLocationName()) ? "" : data.getWorkshopLocationName());
        tjtunityTwoBean.setPlan_qw_ID(data.getWorkshopLocationId());
        tjtunityTwoBean.setPlan_mj(data.getWorkshopArea());
        tjtunityTwoBean.setZhuc_money(data.getRegisteredEnterpriseMoney());
        tjtunityTwoBean.setZhuc_class(TextUtils.isEmpty(data.getRegisteredEnterpriseTypeName()) ? "" : data.getRegisteredEnterpriseTypeName());
        tjtunityTwoBean.setZhuc_class_ID(data.getRegisteredEnterpriseType());
        tjtunityTwoBean.setLad_qw(TextUtils.isEmpty(data.getLandLocationName()) ? "" : data.getLandLocationName());
        tjtunityTwoBean.setLad_qw_Id(data.getLandLocation());
        tjtunityTwoBean.setLad_xz(TextUtils.isEmpty(data.getLandTypeName()) ? "" : data.getLandTypeName());
        tjtunityTwoBean.setLad_xz_Id(data.getLandType());
        tjtunityTwoBean.setLad_mj(data.getLandArea());
        tjtunityTwoBean.setWork_ld(TextUtils.isEmpty(data.getOfficeTypeName()) ? "" : data.getOfficeTypeName());
        tjtunityTwoBean.setWork_ld_ID(data.getOfficeTypeId());
        tjtunityTwoBean.setWork_qw(TextUtils.isEmpty(data.getOfficeLocationName()) ? "" : data.getOfficeLocationName());
        tjtunityTwoBean.setWork_qw_ID(data.getOfficeLocationId());
        tjtunityTwoBean.setWork_mj(data.getOfficeArea());
        tjtunityTwoBean.setEtExplan(data.getSupplementaryNotes());

        SPUtils.put(TjTunityOneAc.this, "tjtunityTwoBean", JsonUtil.getGson().toJson(tjtunityTwoBean));

        //缓存添加view的状态
        ArrayList<NeedBean> viewList = new ArrayList<>();
        if (!TextUtils.isEmpty(data.getWorkshopArea()))
            viewList.add(new NeedBean("厂房", true));

        if (!TextUtils.isEmpty(data.getOfficeArea()))
            viewList.add(new NeedBean("研发办公", true));

        if (!TextUtils.isEmpty(data.getLandArea()))
            viewList.add(new NeedBean("土地", true));

        if (!TextUtils.isEmpty(data.getRegisteredEnterpriseTypeName()))
            viewList.add(new NeedBean("注册型企业", true));

        if (viewList.size() > 0)
            SPUtils.put(TjTunityOneAc.this, "TjTunityTwoAc", JsonUtil.getGson().toJson(viewList));
    }

    @OnClick({R.id.ll_keh, R.id.ll_chengh, R.id.btn_next, R.id.btn_contacts})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_keh://客户关系
                startActivityForResult(new Intent(this, NexusAc.class)
                        .putExtra("tag", "客户关系")
                        .putExtra("basicsType", "18"), Constants.NexusKeh);
                break;
            case R.id.ll_chengh://称呼
                startActivityForResult(new Intent(this, NexusAc.class)
                        .putExtra("tag", "称呼")
                        .putExtra("basicsType", "19"), Constants.NexusChengh);
                break;
            case R.id.btn_next://下一步
                if (testData()) {
                    //缓存数据
                    SPUtils.put(this, "TjTunityOneBean", JsonUtil.getGson().toJson(severData()));
                    Intent intent = new Intent(this, TjTunityTwoAc.class);
                    intent.putExtra("keyId", keyId);
                    intent.putExtra("opportunityId", opportunityId);
                    intent.putExtra("tagState", tagState);
                    startActivity(intent);
                }
                break;
            case R.id.btn_contacts://通讯录
                PermissionUtils.checkPermission(this
                        , new String[]{Manifest.permission.READ_CONTACTS, Manifest.permission.READ_PHONE_STATE
                        }, this);
                break;
        }
    }

    private void viewFillData(String text, TextView view) {
        if (!TextUtils.isEmpty(text)) {
            view.setText(text);
            view.setTextColor(getResources().getColor(R.color.black));
        }
    }

    @NonNull
    private TjTunityOneBean severData() {
        TjTunityOneBean tjTunityOneBean = new TjTunityOneBean();
        tjTunityOneBean.setName(etName.getText().toString());
        tjTunityOneBean.setPhone(etPhone.getText().toString());
        tjTunityOneBean.setNexus(TextUtils.isEmpty(kh_valueId) ? "" : tvKehu.getText().toString());
        tjTunityOneBean.setNexusId(kh_valueId);
        tjTunityOneBean.setCall(TextUtils.isEmpty(tvChId) ? "" : tvCh.getText().toString());
        tjTunityOneBean.setCallId(tvChId);
        tjTunityOneBean.setMailBox(etMail.getText().toString());
        tjTunityOneBean.setCompanyName(etGsname.getText().toString());
        tjTunityOneBean.setCompanyLable(editText.getText().toString());
        tjTunityOneBean.setZhuc(rbZc.isChecked());
        return tjTunityOneBean;
    }

    //验证数据是否填充
    private boolean testData() {
        if (TextUtils.isEmpty(etName.getText().toString().trim())) {
            ToastUtils.showToast(this, "请输入客户姓名");
            return false;
        }

        if (TextUtils.isEmpty(etPhone.getText().toString().trim())) {
            ToastUtils.showToast(this, "请输入客户手机");
            return false;
        }

        if (etPhone.getText().toString().length() != 11) {
            ToastUtils.showToast(this, "客户手机号有误，请重新输入");
            return false;
        }


        if (TextUtils.isEmpty(kh_valueId)) {
            ToastUtils.showToast(this, "请输入客户关系");
            return false;
        }

        if (!TextUtils.isEmpty(etMail.getText().toString())) {
            if (!checkEmaile(etMail.getText().toString())) {
                ToastUtils.showToast(this, "邮箱格式有误，请检查");
                return false;
            }
        }

        if (rbZc.isChecked()) {
            if (TextUtils.isEmpty(etGsname.getText().toString().trim())) {
                ToastUtils.showToast(this, "请输入企业名称");
                return false;
            }
        }
        return true;
    }

    /**
     * 正则表达式校验邮箱
     *
     * @param emaile 待匹配的邮箱
     * @return 匹配成功返回true 否则返回false;
     */
    private boolean checkEmaile(String emaile) {
        String RULE_EMAIL = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
        //正则表达式的模式
        Pattern p = Pattern.compile(RULE_EMAIL);
        //正则表达式的匹配器
        Matcher m = p.matcher(emaile);
        //进行正则匹配
        return m.matches();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case Constants.NexusChengh://称呼
                if (resultCode == Constants.NexusChengh && data != null) {
                    tvChId = data.getStringExtra("valueId");
                    tvCh.setText(data.getStringExtra("value"));
                    tvCh.setTextColor(getResources().getColor(R.color.black));
                }
                break;
            case Constants.NexusKeh://客户关系
                if (resultCode == Constants.NexusKeh && data != null) {
                    kh_valueId = data.getStringExtra("valueId");
                    tvKehu.setText(data.getStringExtra("value"));
                    tvKehu.setTextColor(getResources().getColor(R.color.black));
                }
                break;
            case Constants.Work_Ld://通讯录
                if (resultCode == RESULT_OK && data != null) {
                    Uri uri = data.getData();
                    String[] contacts = getPhoneContacts(uri);
                    if (!TextUtils.isEmpty(contacts[0]))
                        etName.setText(contacts[0]);
                    if (!TextUtils.isEmpty(contacts[1]))
                        etPhone.setText(contacts[1].replaceAll(" ", "").replace("-", "").replace("+86",""));
                }
                break;
        }
    }

    @Override
    public void confirmClick(String sign) {
        String tag = getIntent().getStringExtra("tag");
        if (tag.equals("repeat") || tag.equals("edit") ) {//|| tag.equals("preview")
            finish();
        }else {
            startActivity(new Intent(this, MainActivity.class), true);
        }

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
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        etNum.setText(s.length() + "/50");
    }

    @Override
    public void afterTextChanged(Editable s) {

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        cleanData();
    }

    /**
     * 清楚缓存的数据 view
     */
    private void cleanData() {
        SPUtils.remove(this, "TjTunityOneBean");
        SPUtils.remove(this, "TjTunityTwoAc");
        SPUtils.remove(this, "tjtunityTwoBean");
        SPUtils.remove(this, "TjTunityThree");
    }

    /**
     * 获取选择后的联系人信息
     */
    private String[] getPhoneContacts(Uri uri) {
        String[] contact = new String[2];
        //得到ContentResolver对象
        ContentResolver cr = getContentResolver();
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
//                for (int i = 0; i < phone.getCount(); i++) {
//                    phone.moveToNext();
//                    Log.e("phone",phone.getString(phone.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)));
//                }
            }
            phone.close();
            cursor.close();
        } else {
            return null;
        }
        return contact;
    }

    @Override
    public void onRequestCallBack(boolean isSuccess) {
        if (isSuccess) {
            startActivityForResult(new Intent(Intent.ACTION_PICK,
                    ContactsContract.Contacts.CONTENT_URI), Constants.Work_Ld);
        }
    }
}
