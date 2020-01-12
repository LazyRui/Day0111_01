package com.bawei.day0111_01.view.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.day0111_01.R;
import com.bawei.day0111_01.ShoppingActivity;
import com.bawei.day0111_01.entity.ShoppingEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * ProjectName: Day0111_01
 * PackageName: com.bawei.day0111_01.view.adapter
 * ClassName:   MyRvAdapter
 * Description: Java类的作用
 * Author: Lazy
 * CreateDate: 2020/1/12_15:20
 */
public class MyRvAdapter extends RecyclerView.Adapter<MyRvAdapter.VH> {


    private final Context context;
    private final List<ShoppingEntity.ResultBean> result;


    public MyRvAdapter(Context context, List<ShoppingEntity.ResultBean> result) {
        this.context = context;
        this.result = result;
    }

    public List<ShoppingEntity.ResultBean> getResult() {
        return result;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(View.inflate(context, R.layout.item, null));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        ShoppingActivity shoppingActivity = (ShoppingActivity) context;
        ShoppingEntity.ResultBean lsit = result.get(position);

        holder.tvOrderId.setText(lsit.getCategoryName());

        holder.cb.setChecked(lsit.getTag());
        holder.rv1.setLayoutManager(new LinearLayoutManager(context));
        MyRv1Adapter myRv1Adapter = new MyRv1Adapter(context, lsit.getShoppingCartList());
        holder.rv1.setAdapter(myRv1Adapter);

        holder.cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.cb.isChecked()) {
                    List<ShoppingEntity.ResultBean.ShoppingCartListBean> result = myRv1Adapter.getResult();
                    for (ShoppingEntity.ResultBean.ShoppingCartListBean shoppingCartListBean : result) {
                        shoppingCartListBean.setTag(true);
                    }
                } else {
                    List<ShoppingEntity.ResultBean.ShoppingCartListBean> result = myRv1Adapter.getResult();
                    for (ShoppingEntity.ResultBean.ShoppingCartListBean shoppingCartListBean : result) {
                        shoppingCartListBean.setTag(false);
                    }
                }
                myRv1Adapter.notifyDataSetChanged();

                shoppingActivity.totoPrice();
            }
        });


        myRv1Adapter.setA(new MyRv1Adapter.A() {
            @Override
            public void a(List<ShoppingEntity.ResultBean.ShoppingCartListBean> result) {
                StringBuffer stringBuffer = new StringBuffer();
                for (ShoppingEntity.ResultBean.ShoppingCartListBean shoppingCartListBean : result) {
                    stringBuffer.append(shoppingCartListBean.getTag());
                }
                if (stringBuffer.toString().contains("false")){
                    holder.cb.setChecked(false);
                }else {
                    holder.cb.setChecked(true);
                }
            }
        });

        holder.cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Log.e("xxx",b+"");

                result.get(position).setTag(b);

                shoppingActivity.totoPrice();
            }
        });

    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    static class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.cb)
        CheckBox cb;
        @BindView(R.id.tv_order_id)
        TextView tvOrderId;
        @BindView(R.id.rv1)
        RecyclerView rv1;

        public VH(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
    private A a;

    public void setA(A a) {
        this.a = a;
    }

    public interface A {
        void a(List<ShoppingEntity.ResultBean> result);
    }
}
