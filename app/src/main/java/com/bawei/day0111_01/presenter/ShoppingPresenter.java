package com.bawei.day0111_01.presenter;

import com.bawei.day0111_01.base.mvp.BasePresenter;
import com.bawei.day0111_01.contract.LoginContract;
import com.bawei.day0111_01.contract.ShoppingContract;
import com.bawei.day0111_01.entity.ShoppingEntity;
import com.bawei.day0111_01.model.ShoppingModel;

/**
 * ProjectName: Day0111_01
 * PackageName: com.bawei.day0111_01.presenter
 * ClassName:   ShoppingPresenter
 * Description: Java类的作用
 * Author: Lazy
 * CreateDate: 2020/1/12_16:33
 */
public class ShoppingPresenter extends BasePresenter<ShoppingModel, ShoppingContract.IView> implements ShoppingContract.IPresenter {
    @Override
    protected ShoppingModel initModel() {
        return new ShoppingModel();
    }


    @Override
    public void getData(String userId, String sessionId) {
        model.getData(userId, sessionId, new ShoppingContract.IModel.LoginCallBack() {
            @Override
            public void success(ShoppingEntity shoppingEntity) {
                getView().success(shoppingEntity);
            }

            @Override
            public void failure(Throwable throwable) {
                getView().failure(throwable);
            }
        });
    }
}
