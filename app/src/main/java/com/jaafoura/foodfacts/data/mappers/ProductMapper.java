package com.jaafoura.foodfacts.data.mappers;

import android.support.annotation.NonNull;
import android.text.Html;
import com.jaafoura.foodfacts.data.ProductDB;
import com.jaafoura.foodfacts.model.Product;
import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by kjaafoura on 26/10/2017.
 */
@Singleton
public class ProductMapper extends BaseDataMapper<Product, ProductDB> {

  @Inject
  public ProductMapper() {
  }

  /**
   * Create a {@link ProductDB} object from a non null {@link Product} object.
   *
   * @param sourceObject source object used for creation the new one
   * @return R object
   */
  @NonNull
  @Override
  public ProductDB createObject(@NonNull Product sourceObject) {
    if (sourceObject != null
        && sourceObject.getCode() != null) {
      return new ProductDB(sourceObject.getCode(), sourceObject.getImageUrl(),
          sourceObject.getIngredientsText(),
          sourceObject.getProductName(),
          sourceObject.getEnergy());
    } else {
      return null;
    }
  }
}
