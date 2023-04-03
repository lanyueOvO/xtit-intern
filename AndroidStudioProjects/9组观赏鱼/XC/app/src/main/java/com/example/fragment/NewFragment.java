package com.example.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.xc.MainActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.example.adapter.NewAdapter;


import com.example.xc.R;

public class NewFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  view=inflater.inflate(R.layout.new_fragment,container,false);          //关联布局文件
        initRecyclerView(view);
        return view;
    }

    private void initRecyclerView(View view) {
        RecyclerView  rv=view.findViewById(R.id.newRecycler);       //获得RecyclerView控件对象                                                                              														   //设置为StaggeredGridLayout流式布局
        rv.setLayoutManager(new StaggeredGridLayoutManager(2,RecyclerView.VERTICAL));                                                                              														   //定义新品小吃图片数组
        int[] image={R.drawable.bf11,R.drawable.bf3,R.drawable.yz1,R.drawable.yz6,R.drawable.yc1,
                R.drawable.nf10,R.drawable.nf8};                                                                              														   //定义新品小吃说明数组
        String[] text={"白金仙鱼","金龙鱼","生态鱼缸","锦鲤王饲料",
                "蝴蝶鱼","金狮头","金玉满堂"};

        NewAdapter adapter=new NewAdapter(getActivity(),image,text); //调用适配器

        rv.setAdapter(adapter);

    }

    //
    @Override
    public void onResume() {
        MainActivity.initHomeBtnColor();
        super.onResume();
    }


}
