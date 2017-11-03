package com.jaafoura.foodfacts.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by kjaafoura on 26/10/2017.
 */

@Entity
public class ProductDB {


  @NonNull
  @PrimaryKey
  String code;
  String imageUrl;
  String ingredientsText;
  String productNameFr;
  String energy;

  public ProductDB(String code, String imageUrl, String ingredientsText,
      String productNameFr, String energy) {
    this.code = code;
    this.imageUrl = imageUrl;
    this.ingredientsText = ingredientsText;
    this.productNameFr = productNameFr;
    this.energy = energy;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public String getIngredientsText() {
    return ingredientsText;
  }

  public void setIngredientsText(String ingredientsText) {
    this.ingredientsText = ingredientsText;
  }

  public String getProductNameFr() {
    return productNameFr;
  }

  public void setProductNameFr(String productNameFr) {
    this.productNameFr = productNameFr;
  }

  public String getEnergy() {
    return energy;
  }

  public void setEnergy(String energy) {
    this.energy = energy;
  }
}
