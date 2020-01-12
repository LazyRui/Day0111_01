package com.bawei.day0111_01.model;

import com.bawei.day0111_01.api.LoginService;
import com.bawei.day0111_01.contract.LoginContract;
import com.bawei.day0111_01.entity.LoginEntity;
import com.bawei.day0111_01.utils.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * ProjectName: Day0111_01
 * PackageName: com.bawei.day0111_01.model
 * ClassName:   LoginModel
 * Description: Java类的作用
 * Author: Lazy
 * CreateDate: 2020/1/12_14:45
 */
public class LoginModel implements LoginContract.IModel {
    @Override
    public void getLoginData(String phone, String pwd, final LoginCallBack loginCallBack) {
        RetrofitUtils.getInstance().createService(LoginService.class)
                .getData(phone, pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginEntity>() {
                    @Override
                    public void accept(LoginEntity loginEntity) throws Exception {
                        if (loginCallBack != null) {
                            loginCallBack.success(loginEntity);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (loginCallBack != null) {
                            loginCallBack.failure(throwable);
                        }
                    }
                });
    }

    @Override
    public void getRegisternData(String phone, String pwd, LoginCallBack loginCallBack) {
        RetrofitUtils.getInstance().createService(LoginService.class)
                .getDatas(phone, pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginEntity>() {
                    @Override
                    public void accept(LoginEntity loginEntity) throws Exception {
                        if (loginCallBack != null) {
                            loginCallBack.success(loginEntity);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (loginCallBack != null) {
                            loginCallBack.failure(throwable);
                        }
                    }
                });
    }
}
