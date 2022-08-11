package com.example.ASM;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivityChinh extends AppCompatActivity {
    Button bt1, bt2, bt3, bt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_chinh);
        bt1 = findViewById(R.id.bt1);
        bt2 = findViewById(R.id.bt2);
        bt3 = findViewById(R.id.bt3);
        bt4 = findViewById(R.id.bt4);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hoctap=new Intent(MainActivityChinh.this,MainActivity.class);
                startActivity(hoctap);
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent map=new Intent(MainActivityChinh.this,MapActivity.class);
                startActivity(map);
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tintuc=new Intent(MainActivityChinh.this,BaoActivity.class);
                startActivity(tintuc);
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent danhba=new Intent(MainActivityChinh.this,DanhBaActivity.class);
                startActivity(danhba);
            }
        });

    }

}