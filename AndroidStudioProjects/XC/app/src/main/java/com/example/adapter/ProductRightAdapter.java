package com.example.adapter;

import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import com.example.entity.Product;
import java.util.List;
import com.example.xc.R;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.LayoutInflater;
import com.example.data.AppData;
import android.widget.Toast;


public class ProductRightAdapter extends RecyclerView.Adapter<ProductRightAdapter.ViewHolder> {
    private FragmentActivity activity;
    private List<Product> list;
    private AppData app;

    public ProductRightAdapter(FragmentActivity activity, List<Product> list){
        this.activity=activity;
        this.list=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        app=(AppData) parent.getContext().getApplicationContext();   //获得全局类
        //获得选项布局对象
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.productright_item,parent,false);
        ViewHolder holder=new ViewHolder(view);                  //调用内部类ViewHolder
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Product product=list.get(position);           	//获得选项数据集合
        //异步加载选项数据
        new Thread(new Runnable() {
            @Override
            public void run() {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if((list.size()!=0)){
                            holder.iv.setImageResource(product.getImage());
                            holder.nametv.setText(product.getName());
                            holder.pricetv.setText(" "+product.getPrice());
                        }
                    }
                });
            }
        }).start();
        //点击选项里的添加按钮要执行的操作
        holder.bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //如果已选的小吃数据集合里没有该小吃
                if(!app.selectedproduct.contains(list.get(position))){
                    product.setNumber(1);            //设置数量
                    app.selectedproduct.add(product);  //添加当前选项数据到集合
                    //添加当前选项价格到总价
                    app.countprice +=Double.parseDouble(product.getPrice());
                    Toast.makeText(activity,"添加成功",Toast.LENGTH_SHORT).show();
                }else{                              //如果已选的小吃数据集合里已有该小吃
                    Toast.makeText(activity,"已经有了",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return  list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView nametv;
        TextView pricetv;
        Button bt;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.rightImage);           //获得选项放小吃图片的控件
            nametv=itemView.findViewById(R.id.rightName);      //获得选项放小吃名称的控件
            pricetv=itemView.findViewById(R.id.rightPrice);        //获得选项放小吃价格的控件
            bt=itemView.findViewById(R.id.addProduct);          //获得选项添加按钮控件
        }

    }

}
