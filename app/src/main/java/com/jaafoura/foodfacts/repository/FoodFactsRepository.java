package com.jaafoura.foodfacts.repository;

import android.arch.lifecycle.LiveData;
import com.jaafoura.foodfacts.data.ProductDB;
import com.jaafoura.foodfacts.model.Product;
import org.w3c.dom.Entity;

/**
 * Created by kjaafoura on 26/10/2017.
 */

public interface FoodFactsRepository {

  LiveData<ProductDB> getProduct(String codeBare);
}
