package com.example.ASM.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ASM.Model.SinhVien;

import java.util.ArrayList;

public class SinhVienDAO {
    SQLiteDatabase db;
    public SinhVienDAO (Context c)

    {
        DbHelper helper=new DbHelper (c);
        db=helper.getWritableDatabase();

    }

    public void themSinhVien(SinhVien sinhvien)
    {
        ContentValues values =  new ContentValues();
        values.put("tensinhvien",sinhvien.tensinhvien);
        values.put("id_lop",sinhvien.id_lop);
        db.insert("sinhvien",null,values);
    }
    public ArrayList<SinhVien> xemSinhVien()

    {
        ArrayList<SinhVien>ds = new ArrayList<SinhVien>();
        Cursor c =db.rawQuery("select * from sinhvien",null);
        if( c.moveToFirst())
        {
            do{
                int _id=c.getInt(0);
                String tensinhvien= c.getString(1);
                int id_lop = c.getInt(2);
                SinhVien sv =new SinhVien (_id,tensinhvien,id_lop);
                ds.add(sv);
            }while (c.moveToNext());
        }
        return ds;
    }
    public void XoaSinhVien(int _id)
    {
        db.delete("sinhvien","_id=?",new String[]{_id+""});
    }
    public void SuaSinhVien(SinhVien sinhvien){
        ContentValues values = new ContentValues();
        values.put("tensinhvien",sinhvien.tensinhvien);
        values.put("id_lop",sinhvien.id_lop);
        db.update ("sinhvien",values,"_id=?",new String[]{sinhvien._id+""});
    }
}
