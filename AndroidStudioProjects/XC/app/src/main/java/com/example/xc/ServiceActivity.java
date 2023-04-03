package com.example.xc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

public class ServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        initTextView();
    }
    private void initTextView(){
//        TextView tx1 = findViewById(R.id.tx_sv2);
//        tx1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                tx1.setText(Html.fromHtml("<a href='https://cn.bing.com/search?q=淘宝买货发什么快递'></a>"));
//                tx1.setMovementMethod(LinkMovementMethod.getInstance());
//            }
//        });
    }
}