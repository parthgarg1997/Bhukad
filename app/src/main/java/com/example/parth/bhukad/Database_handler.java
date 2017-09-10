package com.example.parth.bhukad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.Settings;

import java.util.ArrayList;

/**
 * Created by Parth on 1/10/2017.
 */

public class Database_handler extends SQLiteOpenHelper {
    public  static final int Database_Version=1;
    public  static final String DataBase_Name="food.db";
    public  static final String Table_nmae="foods";
    public  static final String column_id="_id";
    public  static final String column_ProductNmae="Food_name";
    public  static final String Total_quantity="total_quantity";


    public Database_handler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DataBase_Name, factory, Database_Version);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query="CREATE TABLE "+Table_nmae+"("+
                column_id+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
                column_ProductNmae+" TEXT, "+
                Total_quantity+" INTEGER NOT NULL"+
                ");";
sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+Table_nmae);
        onCreate(sqLiteDatabase);
    }
    public  void add_products(food_item product)
    {
        ContentValues values =new ContentValues();
        SQLiteDatabase db=getWritableDatabase();
        values.put(column_ProductNmae,product.get_foodName());

       //values.put(Total_quantity,product._Total_Quantity);
        db.insert(Table_nmae,null,values);
        values.put(Total_quantity,0);
        db.insert(Table_nmae,null,values);
        db.close();
    }
    public void delete_product(food_item product)
    {
        SQLiteDatabase db=getWritableDatabase();
        db.execSQL("DELETE FROM "+Table_nmae+" WHERE "+column_ProductNmae+"=\"" +product._foodName+"\";");
    }
    public String queryTOString()
    {   SQLiteDatabase db=getWritableDatabase();
        String dbString="";
        String sql="SELECT "+column_ProductNmae+" FROM "+Table_nmae+" WHERE 1;";
        Cursor c =db.rawQuery(sql,null);
        c.moveToFirst();
        while (!c.isAfterLast())
        {
            if(c.getString(c.getColumnIndex(column_ProductNmae))!=null)
            {
                dbString+=c.getString(c.getColumnIndex(column_ProductNmae));
                dbString+="\n";
            }
            c.moveToNext();
        }
        db.close();
        return dbString;
    }
    public ArrayList<String> queryToArrayList()
    {
        SQLiteDatabase db=getWritableDatabase();
        ArrayList<String> arrayList=new ArrayList<String>();
        String sql="SELECT "+column_ProductNmae+" FROM "+Table_nmae+" WHERE 1 ORDER BY "+column_ProductNmae+" ;";
        Cursor c=db.rawQuery(sql,null);
        c.moveToFirst();
        while (!c.isAfterLast())
        {
            if(c.getString(c.getColumnIndex(column_ProductNmae))!=null)
            {
                arrayList.add(c.getString(c.getColumnIndex(column_ProductNmae)));
            }
            c.moveToNext();
        }
        db.close();
        return arrayList;
    }
    public void update_database(ArrayList<Integer> difference,ArrayList<String> element)
    {   SQLiteDatabase db=getWritableDatabase();
        for(int i=0;i<element.size();i++) {

            String query="UPDATE "+Table_nmae+" SET "+Total_quantity+" = ("+Total_quantity +" + "+difference.get(i)
                    +") WHERE "+column_ProductNmae+" = '"+element.get(i)+"'";
            db.execSQL(query);
        }
    }
    public String final_show()
    {
        SQLiteDatabase db=getWritableDatabase();
        String dbString="";
        String sql="SELECT "+column_ProductNmae+","+Total_quantity+" FROM "+Table_nmae+" WHERE 1;";
        Cursor c =db.rawQuery(sql,null);
        c.moveToFirst();
        while (!c.isAfterLast())
        {
            if(c.getString(c.getColumnIndex(column_ProductNmae))!=null)
            {
                dbString+=c.getString(c.getColumnIndex(Total_quantity))+"\t"+c.getString(c.getColumnIndex(column_ProductNmae));
                dbString+="\n";
            }
            c.moveToNext();
        }
        db.close();
        return dbString;
    }
}
