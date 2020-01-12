package com.bawei.day0111_01;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.day0111_01.api.ShoppingService;
import com.bawei.day0111_01.base.BaseActivity;
import com.bawei.day0111_01.contract.ShoppingContract;
import com.bawei.day0111_01.entity.ShoppingEntity;
import com.bawei.day0111_01.presenter.ShoppingPresenter;
import com.bawei.day0111_01.utils.RetrofitUtils;
import com.bawei.day0111_01.view.adapter.MyRvAdapter;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ShoppingActivity extends BaseActivity<ShoppingPresenter> implements ShoppingContract.IView {

    @BindView(R.id.iv)
    ImageView iv;
    @BindView(R.id.num)
    TextView num;
    @BindView(R.id.rv)
    RecyclerView rv;
    @BindView(R.id.cc)
    CheckBox cc;
    private List<ShoppingEntity.ResultBean> result;
    private MyRvAdapter myRvAdapter;

    @Override
    protected void initData() {
        presenter.getData("27875", "157881480039927875");
    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);


        String userPic = getIntent().getStringExtra("userPic");

        if (userPic != null) {
            Glide.with(this).load(userPic).into(iv);
        }

        rv.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected ShoppingPresenter initPresneter() {
        return new ShoppingPresenter();
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_shopping;
    }

    public void totoPrice() {
        double price = 0.00d;
        StringBuffer stringBuffer = new StringBuffer();
        List<ShoppingEntity.ResultBean> result = myRvAdapter.getResult();
        for (ShoppingEntity.ResultBean resultBean : result) {
            stringBuffer.append(resultBean.getTag());
            for (ShoppingEntity.ResultBean.ShoppingCartListBean shoppingCartListBean : resultBean.getShoppingCartList()) {
                stringBuffer.append(shoppingCartListBean.getTag());

                if (shoppingCartListBean.getTag()) {
                    price += shoppingCartListBean.getPrice();
                }
            }
        }
        Log.e("xxx",stringBuffer.toString());
        if (stringBuffer.toString().contains("false")){
            cc.setChecked(false);
        }else {
            cc.setChecked(true);
        }

        num.setText("总价：" + price);
    }


    @OnClick(R.id.cc)
    public void onViewClicked() {
        boolean checked = cc.isChecked();
        if (checked){
            List<ShoppingEntity.ResultBean> result = myRvAdapter.getResult();
            for (ShoppingEntity.ResultBean resultBean : result) {
                resultBean.setTag(true);
                for (ShoppingEntity.ResultBean.ShoppingCartListBean shoppingCartListBean : resultBean.getShoppingCartList()) {
                    shoppingCartListBean.setTag(true);
                }
            }
        }else {
            List<ShoppingEntity.ResultBean> result = myRvAdapter.getResult();
            for (ShoppingEntity.ResultBean resultBean : result) {
                resultBean.setTag(false);
                for (ShoppingEntity.ResultBean.ShoppingCartListBean shoppingCartListBean : resultBean.getShoppingCartList()) {
                    shoppingCartListBean.setTag(false);
                }
            }
        }
            myRvAdapter.notifyDataSetChanged();
            totoPrice();
    }

    @Override
    public void success(ShoppingEntity shoppingEntity) {
        if (shoppingEntity != null) {
            result = shoppingEntity.getResult();
            myRvAdapter = new MyRvAdapter(ShoppingActivity.this, result);
            rv.setAdapter(myRvAdapter);
        }
    }

    @Override
    public void failure(Throwable throwable) {

    }
}
