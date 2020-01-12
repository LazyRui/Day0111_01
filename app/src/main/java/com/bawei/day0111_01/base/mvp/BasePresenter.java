package com.bawei.day0111_01.base.mvp;

import java.lang.ref.WeakReference;

/**
 * ProjectName: Day0111_01
 * PackageName: com.bawei.day0111_01.base.mvp
 * ClassName:   BasePresenter
 * Description: Java类的作用
 * Author: Lazy
 * CreateDate: 2020/1/12_14:29
 */
public abstract class BasePresenter<M extends IBaseModel, V extends IBaseView> {
    protected M model;
    private WeakReference<V> weakReference;

    public BasePresenter() {
        model = initModel();
    }

    public void attach(V v) {
        weakReference = new WeakReference<>(v);
    }

    protected abstract M initModel();

    public void detach() {
        if (weakReference != null) {
            weakReference.clear();
            weakReference = null;
        }
    }

    public V getView(){
        return weakReference.get();
    }
}
