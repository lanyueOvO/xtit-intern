package com.example.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.xc.LoginActivity;
import com.example.xc.MainActivity;
import androidx.cardview.widget.CardView;

import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import com.example.data.AppData;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.content.SharedPreferences;
import android.content.Context;

import com.example.xc.OrderActivity;
import com.example.xc.R;
import com.example.xc.ServiceActivity;

public class UserFragment extends Fragment {
    private String s1="";                                     //用于存放是否不要葱
    private String s2="";                                    //用于存放是否不要香菜
    private String s3="";                                    //用于存放是否不要蒜
    private String s4="";                                    //用于存放是否不要动物油
    private String s5="";                                    //用于存放是否不要醋
    private String s6="";                                    //用于存放辣味
    private AppData app;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View  view = inflater.inflate(R.layout.user_fragment,container,false);          //关联布局文件
        app= (AppData) getActivity().getApplication();
        initView(view);
        initCheckBox(view);
        return view;
    }

    private void initCheckBox(View view) {
        //点击不要葱多选框
        final CheckBox cb1=view.findViewById(R.id.checkBox1);
        TextView textView = view.findViewById(R.id.tv_us);
//
        MainActivity mainActivity = new MainActivity();
        System.out.println("username:"+mainActivity.initUsername());
        textView.setText(mainActivity.initUsername());

        cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b){                                       //如果选中，
                    s1="-"+cb1.getText().toString();              //就获得选框里的值
                }
                else{                                       //如果没选中
                    s1="";                                  //就赋值为空
                }
                app.countremarks=s1+s2+s3+s4+s5+s6;
            }
        });
        //点击不要香菜多选框
        final CheckBox cb2=view.findViewById(R.id.checkBox2);
        cb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    s2="-"+cb2.getText().toString();
                }
                else{
                    s2="";
                }
                app.countremarks=s1+s2+s3+s4+s5+s6;
            }
        });
        //点击不要蒜多选框
        final CheckBox cb3=view.findViewById(R.id.checkBox3);
        cb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    s3="-"+cb3.getText().toString();
                }
                else{
                    s3="";
                }
                app.countremarks=s1+s2+s3+s4+s5+s6;
            }
        });
        //点击不要动物油多选框
//        final CheckBox cb4=view.findViewById(R.id.checkBox4);
//        cb4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if(b){
//                    s4="-"+cb4.getText().toString();
//                }
//                else{
//                    s4="";
//                }
//                app.countremarks=s1+s2+s3+s4+s5+s6;
//            }
//        });
        //点击不要醋多选框
//        final CheckBox cb5=view.findViewById(R.id.checkBox5);
//        cb5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if(b){
//                    s5="-"+cb5.getText().toString();
//                }
//                else{
//                    s5="";
//                }
//                app.countremarks=s1+s2+s3+s4+s5+s6;
//            }
//        });
        RadioGroup radioGroup=view.findViewById(R.id.radio);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioButton=view.findViewById(i);       //获得选中的单选框
                s6="-"+radioButton.getText().toString();
                app.countremarks=s1+s2+s3+s4+s5+s6;
            }
        });

    }

    private void initView(View view) {
        //点击购物评价入口
        CardView evaluate=view.findViewById(R.id.evaluate);
        evaluate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"暂不提供",Toast.LENGTH_SHORT).show();
            }
        });
        //点击购买记录入口
        CardView record=view.findViewById(R.id.record);
        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), OrderActivity.class);
                startActivity(intent);
//                Toast.makeText(getActivity(),"暂不提供",Toast.LENGTH_SHORT).show();
            }
        });
        //点击收货地址入口
        CardView adress=view.findViewById(R.id.adress);
        adress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"暂不提供",Toast.LENGTH_SHORT).show();
            }
        });
        //点击联系客服入口
        CardView server=view.findViewById(R.id.server);
        server.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ServiceActivity.class);
                startActivity(intent);
//                Toast.makeText(getActivity(),"暂不提供",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onResume() {
        MainActivity.initUserBtnColor();
        super.onResume();
    }

}
