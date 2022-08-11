package com.example.ASM;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.ASM.Model.SinhVien;
import com.example.ASM.Model.SinhVienAdapter;
import com.example.ASM.SQLite.SinhVienDAO;

import java.util.ArrayList;

public class SinhVienActivity extends AppCompatActivity {
    Button bt_themsinhvien;
    ListView lv_sinhvien;
    SinhVienDAO sinhviendao;
    ArrayList<SinhVien> ds = new ArrayList<SinhVien>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sinh_vien);
        bt_themsinhvien = findViewById(R.id.bt_themsinhvien);
        lv_sinhvien = findViewById(R.id.lv_sinhvien);
        sinhviendao = new SinhVienDAO(SinhVienActivity.this);

        capnhatListview();

        bt_themsinhvien.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SinhVienActivity.this, ThemSuaSinhVienActivity.class);
                i.putExtra("loai", 1);
                startActivityForResult(i, 999);
            }
        }));
    }
    public void suaSinhVien(SinhVien sv) {
        Intent i = new Intent(SinhVienActivity.this, ThemSuaSinhVienActivity.class);
        i.putExtra("loai", 2);
        i.putExtra("sinhvien", sv);
        startActivityForResult(i, 333);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 999 && resultCode == RESULT_OK) {
            SinhVien sinhvien = (SinhVien) data.getSerializableExtra("sinhvien");
            sinhviendao.themSinhVien(sinhvien);
            capnhatListview();
        }
        if(requestCode==333 && resultCode == RESULT_OK){
            SinhVien sv = (SinhVien) data.getSerializableExtra("sinhvien");
            sinhviendao.SuaSinhVien(sv);
            capnhatListview();
        }
    }

    public void capnhatListview() {
        ds = sinhviendao.xemSinhVien();
        SinhVienAdapter adapter = new SinhVienAdapter(SinhVienActivity.this, ds);
        lv_sinhvien.setAdapter(adapter);
    }

    public void xoaSinhVien(int _id) {
        sinhviendao.XoaSinhVien(_id);
        capnhatListview();
    }
}
