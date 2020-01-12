package com.bawei.day0111_01.api;

import com.bawei.day0111_01.entity.LoginEntity;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * ProjectName: Day0111_01
 * PackageName: com.bawei.day0111_01.api
 * ClassName:   LoginService
 * Description: Java类的作用
 * Author: Lazy
 * CreateDate: 2020/1/12_14:44
 */
public interface LoginService {
    @POST(Api.LOGIN_URL)
    @FormUrlEncoded
    Observable<LoginEntity> getData(@Field("phone") String phone, @Field("pwd") String pwd);

    @POST(Api.REGISTER_URL)
    @FormUrlEncoded
    Observable<LoginEntity> getDatas(@Field("phone") String phone, @Field("pwd") String pwd);
}
