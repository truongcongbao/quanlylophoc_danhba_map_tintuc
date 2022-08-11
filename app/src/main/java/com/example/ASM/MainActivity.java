package com.example.ASM;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button bt_lophoc, bt_sinhvien;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState); setContentView(R.layout.activity_main);

        bt_lophoc=findViewById(R.id.bt_qllop);
        bt_sinhvien=findViewById(R.id.bt_qlsv);

        bt_lophoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,LopHocActivity.class);
                startActivity(i);

            }
        });
        bt_sinhvien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,SinhVienActivity.class);
                startActivity(i);

            }
        });

    }

}