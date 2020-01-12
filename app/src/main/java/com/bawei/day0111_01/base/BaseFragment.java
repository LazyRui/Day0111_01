package com.bawei.day0111_01.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bawei.day0111_01.base.mvp.BasePresenter;
import com.bawei.day0111_01.base.mvp.IBaseView;

/**
 * ProjectName: Day0111_01
 * PackageName: com.bawei.day0111_01.base
 * ClassName:   BaseFragment
 * Description: Java类的作用
 * Author: Lazy
 * CreateDate: 2020/1/12_14:33
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements IBaseView {
    protected P presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(),layoutId(),null);
        presenter = initPresneter();
        if (presenter != null) {
            presenter.attach(this);
        }
        initView(view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    protected abstract void initData();

    protected abstract void initView(View view);

    protected abstract P initPresneter();

    protected abstract int layoutId();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.detach();
        }
    }


}
