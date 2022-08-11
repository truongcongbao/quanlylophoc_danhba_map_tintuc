package com.example.ASM.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper  {
    public DbHelper(@Nullable Context context) {
        super(context, "qlsv", null, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase spLiteDatabase) {
        String qlsv1 = "create table lophoc(_id integer primary key autoincrement,tenlop text)";
        String qlsv2 = "create table sinhvien (_id integer primary key autoincrement, tensinhvien text, id_lop integer, foreign key (id_lop) references lophoc(_id))";
        spLiteDatabase.execSQL(qlsv1);
        spLiteDatabase.execSQL(qlsv2);

        spLiteDatabase.execSQL("insert into lophoc(tenlop) values('LT123')");
        spLiteDatabase.execSQL("insert into lophoc(tenlop) values('LT456')");
        spLiteDatabase.execSQL("insert into lophoc(tenlop) values('LT789')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("Drop table if exists sinhvien");
        db.execSQL("Drop table if exists lophoc");
        onCreate(db);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        db.setForeignKeyConstraintsEnabled(true);
        super.onConfigure(db);
    }
}
