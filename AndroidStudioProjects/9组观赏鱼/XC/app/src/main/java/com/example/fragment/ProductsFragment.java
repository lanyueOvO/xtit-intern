package com.example.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.adapter.ProductLeftAdapter;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.xc.MainActivity;
import com.example.entity.Product;
import java.util.ArrayList;
import java.util.List;
import com.example.adapter.ProductRightAdapter;

import com.example.xc.R;

public class ProductsFragment extends Fragment {
    public static List<List<Product>> list=new ArrayList<>();
    public static RecyclerView rightrv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View  view=inflater.inflate(R.layout.products_fragment,container,false);          //关联布局文件
        initRecyclerView(view);
        return view;
    }

    private void initRecyclerView(View view) {
        RecyclerView leftrv=view.findViewById(R.id.leftRecycler);       //获得左边列表控件对象
        //设置为上下结构的LinearLayout布局
        leftrv.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        //小吃分类名
        String[] classname={"温带淡水鱼","热带淡水鱼","热带海水鱼","鱼生用具"};
        //调用左边列表适配器类
        ProductLeftAdapter leftAdapter=new ProductLeftAdapter(getActivity(),classname);

        leftrv.setAdapter(leftAdapter);                             //把适配器设置给左边列表控件
        //定义5组小吃图片
        int[] nfimage={R.drawable.nf1,R.drawable.nf2,R.drawable.nf3,R.drawable.nf4,R.drawable.nf5,R.drawable.nf6,
                R.drawable.nf7,R.drawable.nf8,R.drawable.nf9,R.drawable.nf10,R.drawable.nf11};
        int[] bfimage={R.drawable.bf1,R.drawable.bf2,R.drawable.bf3,R.drawable.bf4,R.drawable.bf5,
                R.drawable.bf6,R.drawable.bf7,R.drawable.bf8,R.drawable.bf9,R.drawable.bf10,R.drawable.bf11};
        int[] ycimage={R.drawable.yc1,R.drawable.yc2,R.drawable.yc3,R.drawable.yc4,R.drawable.yc5,
                R.drawable.yc6,R.drawable.yc7,R.drawable.yc8,R.drawable.yc9,R.drawable.yc10};
        int[] yzimage={R.drawable.yz1,R.drawable.yz2,R.drawable.yz3,R.drawable.yz4,R.drawable.yz5,
                R.drawable.yz6,R.drawable.yz7,R.drawable.yz8,R.drawable.yz9,R.drawable.yz10,R.drawable.yz11,};
        int[] omimage={R.drawable.om1,R.drawable.om2,R.drawable.om3,R.drawable.om4,R.drawable.om5,
                R.drawable.om6,R.drawable.om7,R.drawable.om8,R.drawable.om9,R.drawable.om10,};
//定义5组小吃名称
        String[] nfname={"百褶尾泰狮","红头锦鲤","锦鲤(大)","小金鱼","红色兰寿","剪尾斗鱼",
                "大金鱼","金玉满堂","鸿运当头","金狮头","大锦鲤"};

        String[] bfname={"红头三色仙鱼","红龙鱼","金龙鱼","红灯鱼","绿莲灯","金大头存鱼",
                "红线鱼","白龙鱼","红眼仙鱼","秘鲁仙鱼","白金仙鱼"};

        String[] ycname={"蝴蝶鱼","黄尾蓝魔","小丑鱼","人字碟","七彩仙鱼","异彩仙鱼",
                "金尾碟","三箭火箭鱼","珊瑚鱼","蓝尾碟"};

        String[] yzname={"生态鱼缸","小型生态缸","海洋生态缸","小鱼缸","复用性大缸","锦鲤王饲料",
                "天然下沉饲料","孔雀鱼饲料","普通饲料","海豚饲料","鲤鱼饲料"};

//        String[] omname={"欧美小吃1","欧美小吃2","欧美小吃3","欧美小吃4","欧美小吃5","欧美小吃6",
//                "欧美小吃7","欧美小吃8","欧美小吃9","欧美小吃10"};
        //定义5组小吃价格
        String[] nfprice={"8.5","9.5","10.5","12.0","14.0","15.0","16.0","12.0","17.0","17.5","18.0"};
        String[] bfprice={"24.5","125.5","126.5","3.0","4.0","5.0","26.0","22.0","27.0","127.5","28.0"};
        String[] ycprice={"34.5","35.5","36.5","33.0","34.0","35.0","36.0","32.0","37.0","37.5"};
        String[] yzprice={"144.5","45.5","246.5","22.0","224.0","35.0","46.0","32.0","27.0","37.5","28.0"};
        String[] omprice={"4.5","5.5","6.5","3.0","4.0","5.0","6.0","2.0","7.0","7.5"};

        //获取南方小吃分类数据，并添加的集合里。
        List<Product>  listright1=getList(nfimage, nfname, nfprice);
        list.add(listright1);
        //获取北方小吃分类数据，并添加的集合里。
        List<Product>  listright2=getList(bfimage, bfname, bfprice);
        list.add(listright2);
        //获取原创小吃分类数据，并添加的集合里。
        List<Product>  listright3=getList(ycimage, ycname, ycprice);
        list.add(listright3);
        //获取亚洲小吃分类数据，并添加的集合里。
        List<Product>  listright4=getList(yzimage, yzname, yzprice);
        list.add(listright4);
        //获取欧美小吃分类数据，并添加的集合里。
//        List<Product>  listright5=getList(omimage, omname, omprice);
//        list.add(listright5);

        rightrv=view.findViewById(R.id.rightRecycler);               //获得右边列表控件对象
        //设置为上下结构的LinearLayout布局
        rightrv.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        //调用右边列表适配器类
        ProductRightAdapter rightAdapter=new ProductRightAdapter(getActivity(),listright1);

        rightrv.setAdapter(rightAdapter);                          //把适配器设置给右边列表控件


    }

    @Override
    public void onResume() {
        MainActivity.initProductBtnColor();
        super.onResume();
    }
    /**
     * 本方法用于生成右边列表选项数据集合
     * @param iamges 传入一组小吃图片
     * @param names 传入一组小吃名称
     * @param prices 传入一组小吃价格
     * @return 返回一个分类的所有小吃数据集合
     */
    public List<Product> getList(int[] iamges, String[] names, String[] prices){
        List<Product>  listright=new ArrayList<>();                 //存放右边列表所有数据
        Product product;                                      //用于存放一个选项数据
        for(int i=0;i<iamges.length;i++){
            product=new Product();
            product.setImage(iamges[i]);
            product.setName(names[i]);
            product.setPrice(prices[i]);
            listright.add(product);
        }
        return listright;
    }


}
