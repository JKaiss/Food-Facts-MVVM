package com.jaafoura.foodfacts.repository;

import androidx.lifecycle.LiveData;
import com.jaafoura.foodfacts.data.ProductDB;

/**
 * Created by kjaafoura on 26/10/2017.
 */

public interface FoodFactsRepository {

  LiveData<ProductDB> getProduct(String codeBare);
}
