package com.letsbyjames.letstravel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.google.gson.Gson;
import java.util.LinkedList;


public class DBHelper extends SQLiteOpenHelper {

    //These data types are all strings for insertion purposes.  See DataRow.java for actual types.
    private static final String DATABASE_NAME = "packs.db";
    private static final String TABLE_NAME = "pack_table";
    private static final String Name = "Name";
    private static final String Category = "Category";
    private static final String PurchasedPacks = "PurchasedPacks";
    private static final String myPacks = "myPacks";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (" + Category + " TEXT PRIMARY KEY, " + Name + " TEXT, " + PurchasedPacks + " TEXT, " + myPacks);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

    public boolean insertData(InsertItem item){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(Category, item.getCategory());
        contentValues.put(PurchasedPacks, serializeToJson(item.getPurchasedPacks()));
        contentValues.put(myPacks, serializeToJson(item.getMyPacks()));

        long result = db.insert(TABLE_NAME, null, contentValues);

        if(result == -1){
            return false;
        }else{
            return true;
        }
    }

    public InsertItem getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        InsertItem result = null;

        ContentValues contentValues = new ContentValues();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);

        return result;
    }

    public String serializeToJson(LinkedList<Pack> packs){
        Gson gson = new Gson();
        return gson.toJson(packs);
    }

    public Pack deserializeFromJson(String bits){
        Gson gson = new Gson();
        return gson.fromJson(bits, Pack.class);
    }
/*
    public String getStringFromBool(boolean bool){
        if(bool){
            //its true
            return "1";
        }else{
            return "0";
        }
    }
    */
}
