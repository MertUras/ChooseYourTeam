package com.example.merturas_hw1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        RadioGroup group = (android.widget.RadioGroup) findViewById(R.id.group);
        ImageView imageView=(ImageView) findViewById(R.id.imageView);

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.judges:
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.judges));
                        break;
                    case R.id.metu:
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.metu));
                        break;
                    case R.id.hacet:
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.hacet));
                        break;


                }
            }
        });
    }
}