package com.bawei.day0111_01.presenter;

import com.bawei.day0111_01.base.mvp.BasePresenter;
import com.bawei.day0111_01.base.mvp.IBaseModel;
import com.bawei.day0111_01.contract.LoginContract;
import com.bawei.day0111_01.entity.LoginEntity;
import com.bawei.day0111_01.model.LoginModel;

/**
 * ProjectName: Day0111_01
 * PackageName: com.bawei.day0111_01
 * ClassName:   LoginPresenter
 * Description: Java类的作用
 * Author: Lazy
 * CreateDate: 2020/1/12_14:47
 */
public class LoginPresenter extends BasePresenter<LoginModel, LoginContract.IView> implements LoginContract.IPresenter {
    @Override
    protected LoginModel initModel() {
        return new LoginModel();
    }

    @Override
    public void getLoginData(String phone, String pwd) {
        model.getLoginData(phone, pwd, new LoginContract.IModel.LoginCallBack() {
            @Override
            public void success(LoginEntity loginEntity) {
                getView().success(loginEntity);
            }

            @Override
            public void failure(Throwable throwable) {
                getView().failure(throwable);
            }
        });
    }

    @Override
    public void getRegisterData(String phone, String pwd) {
        model.getRegisternData(phone, pwd, new LoginContract.IModel.LoginCallBack() {
            @Override
            public void success(LoginEntity loginEntity) {
                getView().success(loginEntity);
            }

            @Override
            public void failure(Throwable throwable) {
                getView().failure(throwable);
            }
        });
    }
}
