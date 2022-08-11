package com.example.ASM;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.ASM.Model.LopHocAdapter;
import com.example.ASM.Model.LopHoc;
import com.example.ASM.SQLite.LopHocDAO;

import java.util.ArrayList;

public class LopHocActivity extends AppCompatActivity {
    Button bt_themlop;
    ListView lv_lophoc;
    LopHocDAO lophocdao;
    ArrayList<LopHoc>ds=new ArrayList<LopHoc>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lop_hoc);
        bt_themlop=findViewById(R.id.bt_themlop);
        lv_lophoc=findViewById(R.id.lv_lophoc);
        lophocdao = new LopHocDAO( LopHocActivity.this);
        ds = lophocdao.xemlop();
        LopHocAdapter adapter = new LopHocAdapter(LopHocActivity.this,ds);
        lv_lophoc.setAdapter(adapter);
        capnhatListview();
        bt_themlop.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LopHocActivity.this,ThemSuaLopActivity.class);
                i.putExtra("loai", 1);
                startActivityForResult(i,999);
            }
        }));
    }
    public void xoaLopHoc(int _id){
        lophocdao.XoaLop(_id);
        capnhatListview();
    }
    public void capnhatListview(){
        ds = lophocdao.xemlop();
        LopHocAdapter adapter = new LopHocAdapter(LopHocActivity.this, ds);
        lv_lophoc.setAdapter(adapter);
    }
    public void suaLopHoc(LopHoc lh){
        Intent i = new Intent(LopHocActivity.this,ThemSuaLopActivity.class);
        i.putExtra("loai", 2);
        i.putExtra("lophoc",lh);
        startActivityForResult(i,333);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 999 && resultCode == RESULT_OK)
        {
            LopHoc lh = (LopHoc)data.getSerializableExtra("lophoc");
            lophocdao.themLop(lh);
            capnhatListview();
        }
        if(requestCode==333 && resultCode == RESULT_OK){
            LopHoc lh = (LopHoc)data.getSerializableExtra("lophoc");
            lophocdao.SuaLop(lh);
            capnhatListview();
        }
    }
}