package com.example.ASM;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.ASM.Model.LopHoc;
import com.example.ASM.Model.SinhVien;
import com.example.ASM.SQLite.LopHocDAO;

import java.util.ArrayList;

public class ThemSuaSinhVienActivity extends AppCompatActivity {
    TextView tv_id, tv_tieude;
    EditText et_tensinhvien;
    Button bt_themsuasinhvien, bt_huyy;
    Spinner sp_tenlop;
    int loai;
    SinhVien sv;
    LopHocDAO lophocdao;
    ArrayList<LopHoc> dslophoc = new ArrayList<LopHoc>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_sua_sinh_vien);
        tv_id = findViewById(R.id.tv_id);
        tv_tieude = findViewById(R.id.tv_tieude);
        et_tensinhvien = findViewById(R.id.et_tensinhvien);
        bt_themsuasinhvien = findViewById(R.id.bt_themsuasinhvien);
        bt_huyy = findViewById(R.id.bt_huyy);
        sp_tenlop = findViewById(R.id.sp_tenlop);
        lophocdao = new LopHocDAO(ThemSuaSinhVienActivity.this);
        dslophoc = lophocdao.xemlop();

        ArrayList<String> dstenlophoc = new ArrayList<String>();
        for (int i = 0; i < dslophoc.size(); i++)
            dstenlophoc.add(dslophoc.get(i).tenlop);

        ArrayAdapter adapter = new ArrayAdapter(ThemSuaSinhVienActivity.this, android.R.layout.simple_list_item_1, dstenlophoc);
        sp_tenlop.setAdapter(adapter);

        loai = getIntent().getExtras().getInt("loai");

        if (loai == 1) {
            tv_tieude.setText("Thêm Sinh Viên");
            bt_themsuasinhvien.setText("Thêm Sinh Viên");
            bt_themsuasinhvien.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String tensinhvien = et_tensinhvien.getText().toString();
                    int index = sp_tenlop.getSelectedItemPosition();
                    int id_lop = dslophoc.get(index)._id;
                    SinhVien sinhvien = new SinhVien(tensinhvien, id_lop);
                    Intent i = new Intent();
                    i.putExtra("sinhvien", sinhvien);
                    setResult(RESULT_OK, i);
                    finish();
                }
            });
        }
        bt_huyy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent y = new Intent();
                setResult(RESULT_CANCELED, y);
                finish();
            }
        });
        if (loai == 2) {
            tv_tieude.setText("Sua Sinh Vien");
            bt_themsuasinhvien.setText("Sua Sinh Vien");
            sv = (SinhVien) getIntent().getExtras().get("sinhvien");
            tv_id.setText(sv._id+"");
            et_tensinhvien.setText(sv.tensinhvien);
            bt_themsuasinhvien.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String tensinhvien = et_tensinhvien.getText().toString();
                    sv.tensinhvien = tensinhvien;
                    Intent i = new Intent();
                    i.putExtra("sinhvien", sv);
                    setResult(RESULT_OK, i);
                    finish();
                    }
            });
        }
    }
}