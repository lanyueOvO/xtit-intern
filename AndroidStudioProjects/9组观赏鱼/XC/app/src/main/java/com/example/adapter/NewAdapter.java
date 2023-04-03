package com.example.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.xc.R;

public class NewAdapter  extends  RecyclerView.Adapter<NewAdapter.ViewHolder>{

    private FragmentActivity activity;
    private int[] image;
    private String[] text;


    public NewAdapter(FragmentActivity activity, int[] image, String[] text){
        this.activity=activity;
        this.image=image;
        this.text=text;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.new_item,parent,false);
        ViewHolder holder=new ViewHolder(view);                     //调用内部类ViewHolder
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if((image.length!=0)&&(text.length!=0)){
                            holder.iv.setImageResource(image[position]);
                            holder.tv.setText(text[position]);
                        }
                    }
                });
            }
        }).start();

    }

    @Override
    public int getItemCount() {
        ;
        return image.length;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView tv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.newImage);               //获得列表选项图片控件
            tv=itemView.findViewById(R.id.newText);                 //获得列表选项文本控件
        }
    }

}
