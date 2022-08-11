package com.example.ASM.Model;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.ASM.LopHocActivity;
import com.example.ASM.R;

import java.util.ArrayList;

public class LopHocAdapter extends BaseAdapter {
    ArrayList<LopHoc>ds;
    Context c;
    public LopHocAdapter(Context c , ArrayList<LopHoc>ds)
    {
        this.ds=ds;
        this.c=c;
    }
    @Override
    public int getCount() {
        return ds.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inf=((Activity)c).getLayoutInflater();
        view=inf.inflate(R.layout.one_item_lophoc,null);

        TextView tv_id = view.findViewById(R.id.tv_id);
        TextView tv_tenlop = view.findViewById(R.id.tv_tenlop);
        Button bt_sua = view.findViewById(R.id.bt_sua);
        Button bt_xoa = view.findViewById(R.id.bt_xoa);

        tv_id.setText(ds.get(i)._id+"");
        tv_tenlop.setText(ds.get(i).tenlop);
        bt_xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int _id = ds.get(i)._id;
                ((LopHocActivity)c).xoaLopHoc(_id);
            }
        });
        bt_sua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LopHoc lh =ds.get(i);
                ((LopHocActivity)c).suaLopHoc(lh);
            }
        });
        return view;

    }
}

