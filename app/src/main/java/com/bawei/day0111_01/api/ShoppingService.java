package com.bawei.day0111_01.api;

import com.bawei.day0111_01.entity.LoginEntity;
import com.bawei.day0111_01.entity.ShoppingEntity;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

/**
 * ProjectName: Day0111_01
 * PackageName: com.bawei.day0111_01.api
 * ClassName:   ShoppingService
 * Description: Java类的作用
 * Author: Lazy
 * CreateDate: 2020/1/12_15:22
 */
public interface ShoppingService {
    @GET(Api.SHOPPING_URL)
    Observable<ShoppingEntity> getDatas(@Header("userId") String uid, @Header("sessionId") String ssid);
}
