package com.example.ASM;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ASM.Model.LopHoc;

public class ThemSuaLopActivity extends AppCompatActivity {
    TextView tv_id, tv_tieude;
    EditText et_tenlop;
    Button bt_themsualop , bt_huy;
    int loai;
    LopHoc lh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_sua_lop);
        tv_id=findViewById(R.id.tv_id);
        tv_tieude=findViewById(R.id.tv_tieude);
        et_tenlop=findViewById(R.id.et_tenlop);
        bt_themsualop=findViewById(R.id.bt_themsualop);
        bt_huy=findViewById(R.id.bt_huy);

        loai = getIntent().getExtras().getInt("loai");
        if(loai == 1){
            tv_tieude.setText("Thêm Lớp Học");
            bt_themsualop.setText("Thêm Lớp");
        }
        if(loai == 2){
            tv_tieude.setText("Sửa Lớp Học");
            bt_themsualop.setText("Sửa Lớp");
            lh = (LopHoc)getIntent().getExtras().get("lophoc");
            tv_id.setText(lh._id+"");
            et_tenlop.setText(lh.tenlop);
        }
        bt_themsualop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(loai == 1) {
                    String tenlop = et_tenlop.getText().toString();
                    LopHoc Lophoc = new LopHoc(tenlop);
                    Intent i = new Intent();
                    i.putExtra("lophoc", Lophoc);
                    setResult(RESULT_OK, i);
                    finish();
                }else{
                    if(loai == 2){
                        String tenlop = et_tenlop.getText().toString();
                        lh.tenlop = tenlop;
                        Intent i = new Intent();
                        i.putExtra("lophoc", lh);
                        setResult(RESULT_OK, i);
                        finish();
                    }
                }

            }
        });
        bt_huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                setResult(RESULT_CANCELED, i);
                finish();
            }
        });
    }
}
