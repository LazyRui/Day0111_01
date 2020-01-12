package com.bawei.day0111_01.view.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.day0111_01.R;
import com.bawei.day0111_01.ShoppingActivity;
import com.bawei.day0111_01.entity.ShoppingEntity;
import com.bumptech.glide.Glide;

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
public class MyRv1Adapter extends RecyclerView.Adapter<MyRv1Adapter.VH> {


    private final Context context;


    private List<ShoppingEntity.ResultBean.ShoppingCartListBean> result;


    public MyRv1Adapter(Context context, List<ShoppingEntity.ResultBean.ShoppingCartListBean> result) {
        this.context = context;
        this.result = result;
    }

    public List<ShoppingEntity.ResultBean.ShoppingCartListBean> getResult() {
        return result;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(View.inflate(context, R.layout.item1, null));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        ShoppingActivity shoppingActivity = (ShoppingActivity) context;
        ShoppingEntity.ResultBean.ShoppingCartListBean list = result.get(position);

        Glide.with(context).load(list.getPic()).into(holder.iv);
        holder.name.setText(list.getCommodityName());
        holder.price.setText(list.getPrice() + "");
        holder.cb1.setChecked(list.getTag());
        holder.cb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.cb1.isChecked()) {
                    list.setTag(true);
                } else {
                    list.setTag(false);
                }
                shoppingActivity.totoPrice();

                if (a != null) {
                    a.a(result);
                }
            }
        });




    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    static class VH extends RecyclerView.ViewHolder {
        @BindView(R.id.cb1)
        CheckBox cb1;
        @BindView(R.id.iv)
        ImageView iv;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.price)
        TextView price;

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
        void a(List<ShoppingEntity.ResultBean.ShoppingCartListBean> result);
    }
}
