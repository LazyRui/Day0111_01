package com.bawei.day0111_01.contract;

import com.bawei.day0111_01.base.mvp.IBaseModel;
import com.bawei.day0111_01.base.mvp.IBaseView;
import com.bawei.day0111_01.entity.LoginEntity;
import com.bawei.day0111_01.entity.ShoppingEntity;

/**
 * ProjectName: Day0111_01
 * PackageName: com.bawei.day0111_01
 * ClassName:   LoginContract
 * Description: Java类的作用
 * Author: Lazy
 * CreateDate: 2020/1/12_14:42
 */
public interface ShoppingContract {
    interface IModel extends IBaseModel{
        void getData(String phone, String pwd, LoginCallBack loginCallBack);
        interface LoginCallBack{
            void success(ShoppingEntity shoppingEntity);
            void failure(Throwable throwable);
        }
    }

    interface IView extends IBaseView{
        void success(ShoppingEntity shoppingEntity);
        void failure(Throwable throwable);
    }

    interface IPresenter{
        void getData(String userId, String sessionId);
    }
}
