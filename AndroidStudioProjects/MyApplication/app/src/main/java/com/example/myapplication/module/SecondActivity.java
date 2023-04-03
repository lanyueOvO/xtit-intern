package com.example.myapplication.module;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        demo();
        transform();
    }
    private void demo(){
        RatingBar ratingBar = findViewById(R.id.ratingBar);
//        ratingBar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                System.out.print(view);
//            }
//        });
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                System.out.println("v: "+v);
                System.out.println("b: "+b);
                System.out.println("ra:"+ratingBar);
            }
        });
    }
    private void transform(){
        float f[] = {0};
        ProgressBar id = findViewById(R.id.progressBar2);
        ImageView viewById = findViewById(R.id.imageView2);
        id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewById.setRotation(f[0]+=50);
            }
        });

    }

}
