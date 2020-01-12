package com.bawei.day0111_01.model;

import com.bawei.day0111_01.ShoppingActivity;
import com.bawei.day0111_01.api.ShoppingService;
import com.bawei.day0111_01.contract.LoginContract;
import com.bawei.day0111_01.contract.ShoppingContract;
import com.bawei.day0111_01.entity.ShoppingEntity;
import com.bawei.day0111_01.utils.RetrofitUtils;
import com.bawei.day0111_01.view.adapter.MyRvAdapter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * ProjectName: Day0111_01
 * PackageName: com.bawei.day0111_01.model
 * ClassName:   ShoppingModel
 * Description: Java类的作用
 * Author: Lazy
 * CreateDate: 2020/1/12_16:30
 */
public class ShoppingModel implements ShoppingContract.IModel {

    @Override
    public void getData(String phone, String pwd, LoginCallBack loginCallBack) {
        RetrofitUtils.getInstance().createService(ShoppingService.class)
                .getDatas("27875", "157881480039927875")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ShoppingEntity>() {
                    @Override
                    public void accept(ShoppingEntity shoppingEntity) throws Exception {
                        if (loginCallBack != null) {
                            loginCallBack.success(shoppingEntity);
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
