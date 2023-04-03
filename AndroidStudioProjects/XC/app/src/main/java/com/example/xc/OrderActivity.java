package com.example.xc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class OrderActivity extends AppCompatActivity {

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;

    private TextView tv;

    int num = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        initBtn();
    }

    private void initBtn() {

         btn1 = findViewById(R.id.btn_or1);

         btn2 = findViewById(R.id.btn_or2);
         btn3 = findViewById(R.id.btn_or3);
         btn4 = findViewById(R.id.btn_or4);
         btn5 = findViewById(R.id.btn_or5);
         tv = findViewById(R.id.tv_or);


            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tv.setText("暂时没有订单");
                }
            });

            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tv.setText("暂无待发货记录");
                }
            });

            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tv.setText("暂无待收货记录");
                }
            });

            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tv.setText("暂无已收货记录");
                }
            });

            btn5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    tv.setText("暂无评价记录");
                }
            });

//        switch (num){
//            case 1:
//                btn1.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        tv.setText("暂时没有订单");
//                    }
//                });
//                break;
//            case 2:
//                btn2.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        tv.setText("暂无待发货记录");
//                    }
//                });
//                break;
//            case 3:
//                btn3.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        tv.setText("暂无待收货记录");
//                    }
//                });
//                break;
//            case 4:
//                btn4.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        tv.setText("暂无已收货记录");
//                    }
//                });
//                break;
//            case 5:
//                btn5.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        tv.setText("暂无评价记录");
//                    }
//                });
//                break;
//        }
    }
}