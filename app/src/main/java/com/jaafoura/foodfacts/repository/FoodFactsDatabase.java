package com.jaafoura.foodfacts.repository;


import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.jaafoura.foodfacts.data.ProductDB;
import com.jaafoura.foodfacts.data.ProductDao;

/**
 * Created by kjaafoura on 26/10/2017.
 */

@Database(entities = {ProductDB.class}, version = FoodFactsDatabase.VERSION)
public abstract class FoodFactsDatabase extends RoomDatabase {

  static final int VERSION = 4; // version of database

  public abstract ProductDao getProductDao();

}
