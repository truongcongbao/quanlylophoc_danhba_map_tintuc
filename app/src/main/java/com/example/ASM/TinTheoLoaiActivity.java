package com.example.ASM;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class TinTheoLoaiActivity extends AppCompatActivity {
    String diachi_rss;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tin_theo_loai);
        lv = findViewById(R.id.lv);
        diachi_rss=getIntent().getExtras().getString("diachi_rss");
        com.example.ASM.MyAsyncTask gandulieu=new com.example.ASM.MyAsyncTask(TinTheoLoaiActivity.this,diachi_rss);
        gandulieu.execute();

    }
}