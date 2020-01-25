package com.jaafoura.foodfacts.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import java.util.List;

/**
 * Created by kjaafoura on 26/10/2017.
 */

@Dao
public interface ProductDao {
  @Query("SELECT * FROM ProductDB WHERE code=:code")
  LiveData<ProductDB> findByCode(String code);

  @Query("SELECT * FROM ProductDB")
  LiveData<List<ProductDB>> findAll();

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  long insert(ProductDB product);

  @Delete
  int delete(ProductDB product);
}
