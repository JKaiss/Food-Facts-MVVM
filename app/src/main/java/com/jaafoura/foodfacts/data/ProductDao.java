package com.jaafoura.foodfacts.data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
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
