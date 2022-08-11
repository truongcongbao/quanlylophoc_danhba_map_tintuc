package com.example.ASM.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ASM.Model.LopHoc;

import java.util.ArrayList;

public class LopHocDAO {
    SQLiteDatabase db; public LopHocDAO (Context c)
    {
        DbHelper helper=new DbHelper (c);
        db=helper.getWritableDatabase();
    }

    public void themLop(LopHoc lophoc)
    {
        ContentValues values =  new ContentValues();
        values.put("tenlop",lophoc.tenlop);
        db.insert("lophoc",null,values);
    }
    public ArrayList<LopHoc> xemlop()

    {
        ArrayList<LopHoc>ds = new ArrayList<LopHoc>();
        Cursor c =db.rawQuery("select * from lophoc",null);
        if( c.moveToFirst())
        {
            do{
                int _id=c.getInt(0);
                String tenlop= c.getString(1);
                LopHoc lh =new LopHoc (_id,tenlop);
                ds.add(lh);
            }while (c.moveToNext());
        }
        return ds;
    }
    public void XoaLop(int _id)
    {
        db.delete("lophoc","_id=?",new String[]{_id+""});
    }
    public void SuaLop(LopHoc lophoc){
        ContentValues values = new ContentValues();
        values.put("tenlop",lophoc.tenlop);
        db.update ("lophoc",values,"_id=?",new String[]{lophoc._id+""});
    }
}
