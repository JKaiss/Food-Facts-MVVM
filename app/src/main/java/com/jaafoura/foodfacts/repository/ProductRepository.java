package com.jaafoura.foodfacts.repository;

import androidx.lifecycle.LiveData;
import com.jaafoura.foodfacts.data.ProductDB;

import java.util.List;

/**
 * Created by kjaafoura on 26/10/2017.
 */

public interface ProductRepository {

  LiveData<ProductDB> findByCode(String id);

  LiveData<List<ProductDB>> findAll();

  long insert(ProductDB product);

  int delete(ProductDB product);

}
