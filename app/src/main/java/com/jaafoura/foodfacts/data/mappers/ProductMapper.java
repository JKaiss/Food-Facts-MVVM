package com.jaafoura.foodfacts.data.mappers;

import android.support.annotation.NonNull;
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
        && sourceObject.getCode() != null
        && sourceObject.getImageUrl() != null
        && sourceObject.getIngredientsText() != null
        && (sourceObject.getProductNameFr() != null || sourceObject.getProductNameEn() != null)
        && sourceObject.getNutriments() != null) {
      return new ProductDB(sourceObject.getCode(), sourceObject.getImageUrl(),
          sourceObject.getIngredientsText(),
          sourceObject.getProductNameFr().isEmpty() ? sourceObject.getProductNameEn()
              : sourceObject.getProductNameFr(), // If fr name is empty set the En name
          sourceObject.getNutriments().getEnergy100g());
    } else {
      return null;
    }


  }
}
