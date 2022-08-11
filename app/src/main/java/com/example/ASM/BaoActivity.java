package com.example.ASM;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class BaoActivity extends AppCompatActivity {
    String [] ten_loai={"Trang chủ","Tin tức trong ngày ","Bóng đá","ASIAN CUP 2019"};

    String [] rss_loai={"https://www.24h.com.vn/upload/rss/trangchu24h.rss",
            "https://www.24h.com.vn/upload/rss/tintuctrongngay.rss",
            "https://www.24h.com.vn/upload/rss/bongda.rss",
            "https://www.24h.com.vn/upload/rss/asiancup2019.rss"
    };

    ListView lv ;

    ArrayList<Item>ds=new ArrayList<Item>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bao);
        lv= findViewById(R.id.lv);
        ArrayAdapter<String> adapter=new
                ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,ten_loai);
        lv.setAdapter(adapter);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                // TODO Auto-generated method stub
                //arg2 chính là vị trí (index) được nhấn
                Intent intent=new Intent(getApplicationContext(),TinTheoLoaiActivity.class);
                intent.putExtra("diachi_rss", rss_loai[arg2]);
                startActivity(intent);

            }
        });



    }
}