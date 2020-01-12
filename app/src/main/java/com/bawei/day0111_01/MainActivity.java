package com.bawei.day0111_01;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.day0111_01.base.BaseActivity;
import com.bawei.day0111_01.contract.LoginContract;
import com.bawei.day0111_01.entity.LoginEntity;
import com.bawei.day0111_01.presenter.LoginPresenter;
import com.blankj.utilcode.util.EncryptUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<LoginPresenter> implements LoginContract.IView {


    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.bt_login)
    Button btLogin;
    @BindView(R.id.bt_register)
    Button btRegister;

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
    }

    @Override
    protected LoginPresenter initPresneter() {
        return new LoginPresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void success(LoginEntity loginEntity) {
        if (loginEntity != null) {
            Toast.makeText(this, loginEntity.getMessage(), Toast.LENGTH_SHORT).show();
            if (loginEntity.getStatus().equals("0000") && loginEntity.getMessage().equals("登录成功")){
                Intent intent = new Intent(MainActivity.this, ShoppingActivity.class);
                intent.putExtra("userPic",loginEntity.getResult().getHeadPic());
                startActivity(intent);
            }
        }
    }

    @Override
    public void failure(Throwable throwable) {

    }

    @OnClick({R.id.bt_login, R.id.bt_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_login:
                String s = etName.getText().toString();
                if (TextUtils.isEmpty(s)) {
                    return;
                }


                String s1 = etPwd.getText().toString();
                if (TextUtils.isEmpty(s1)) {
                    return;
                }
                String substring1 = EncryptUtils.encryptMD5ToString(s1).substring(0, 8);
                Log.e("xxx","login============"+substring1);

                presenter.getLoginData(s, substring1);
                break;
            case R.id.bt_register:
                String n = etName.getText().toString();
                if (TextUtils.isEmpty(n)) {
                    return;
                }


                String n1 = etPwd.getText().toString();
                if (TextUtils.isEmpty(n1)) {
                    return;
                }
                String substrin1 = EncryptUtils.encryptMD5ToString(n1).substring(0, 8);
                Log.e("xxx","register============"+substrin1);

                presenter.getRegisterData(n,substrin1 );
                break;
        }
    }
}
