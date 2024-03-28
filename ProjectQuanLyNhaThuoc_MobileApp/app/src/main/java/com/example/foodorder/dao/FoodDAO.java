package com.example.foodorder.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.foodorder.database.DBHelper;
import com.example.foodorder.model.Food;

import java.util.ArrayList;
import java.util.List;

public class FoodDAO {
    DBHelper dbHelper;
    public FoodDAO(Context context) {
        dbHelper = new DBHelper(context);
    }
    public List<Food> GetAll()
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        List<Food> listProduct = new ArrayList<>();
        String query = "SELECT * FROM product";
        Cursor c =  db.rawQuery(query, null);
        while (c.moveToNext())
        {
            Food temp = new Food();
            temp.setId(c.getInt(0));
            temp.setImage(c.getString(1));
            temp.setBanner(c.getString(2));
            temp.setDescription(c.getString(3));
            temp.setPrice(c.getInt(4));
            temp.setSale(c.getInt(5));
            temp.setCount(c.getInt(6));
            temp.setTotalPrice(c.getInt(7));
            listProduct.add(temp);
        }
        return listProduct;
    }
    public void Insert(Food p) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        //c1: sử dụng contentValues
        ContentValues values = new ContentValues();
        // values.put("id", p.getId());
        values.put("name", p.getName());
        values.put("image", p.getImage());
        values.put("banner", p.getBanner());
        values.put("des", p.getDescription());
        values.put("price", p.getPrice());
        values.put("sale", p.getSale());
        values.put("count", p.getCount());
        values.put("TotalPrice", p.getTotalPrice());
        db.insert("product", null, values);
        //c2: sử dụng câu queyry thuần
        //String query = String.format("INSERT INTO %s VALUES('%s','%s',%f, '%s')", "product", p.getId(),p.getName(), p.getImage(), p.getPrice());
        //db.execSQL(query);
    }
    public void Delete(int foodId) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        //c1: sử dụng delete
        db.delete("food", "id=?", new String[] { String.valueOf(foodId) });
        //c2: sử dụng câu queyry thuần
        // String query = String.format("delete * from %s where id = %d", "product", productId);
        //db.execSQL(query);
    }
}
