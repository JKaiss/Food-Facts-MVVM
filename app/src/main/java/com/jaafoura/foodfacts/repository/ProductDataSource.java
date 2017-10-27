package com.jaafoura.foodfacts.repository;


import android.arch.lifecycle.LiveData;
import com.jaafoura.foodfacts.data.ProductDB;
import com.jaafoura.foodfacts.data.ProductDao;
import com.jaafoura.foodfacts.model.Product;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by kjaafoura on 26/10/2017.
 */

public class ProductDataSource implements ProductRepository {

  private ProductDao productDao;

  @Inject
  public ProductDataSource(ProductDao productDao) {
    this.productDao = productDao;
  }

  @Override
  public LiveData<ProductDB> findByCode(String id) {
    return productDao.findByCode(id);
  }

  @Override
  public LiveData<List<ProductDB>> findAll() {
    return productDao.findAll();
  }

  @Override
  public long insert(ProductDB product) {
    return productDao.insert(product);
  }

  @Override
  public int delete(ProductDB product) {
    return productDao.delete(product);
  }
}
