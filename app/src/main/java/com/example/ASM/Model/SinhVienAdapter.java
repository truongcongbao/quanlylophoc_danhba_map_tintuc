package com.example.ASM.Model;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.ASM.R;
import com.example.ASM.SinhVienActivity;

import java.util.ArrayList;

public class SinhVienAdapter extends BaseAdapter {
    ArrayList<SinhVien>ds;
    Context c;
    public SinhVienAdapter(Context c , ArrayList<SinhVien>ds)
    {
        this.ds=ds;
        this.c=c;
    }
    @Override
    public int getCount() {
        return ds.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        LayoutInflater inf=((Activity)c).getLayoutInflater();
        view=inf.inflate(R.layout.one_item_sinh_vien,null);

        TextView tv_id = view.findViewById(R.id.tv_id);
        TextView tv_tensinhvien = view.findViewById(R.id.tv_tensinhvien);
        TextView tv_idlop = view.findViewById(R.id.tv_idlop);
        Button bt_suasinhvien = view.findViewById(R.id.bt_suasinhvien);
        Button bt_xoasinhvien = view.findViewById(R.id.bt_xoasinhvien);

        tv_id.setText(ds.get(i)._id+"");
        tv_tensinhvien.setText(ds.get(i).tensinhvien);
        tv_idlop.setText(ds.get(i).id_lop+"");
        bt_xoasinhvien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int _id = ds.get(i)._id;
                ((SinhVienActivity)c).xoaSinhVien(_id);
            }
        });
        bt_suasinhvien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SinhVien sv =ds.get(i);
                ((SinhVienActivity)c).suaSinhVien(sv);
            }
        });
        return view;
    }
}
