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
  private String code;
  private String imageUrl;
  private String ingredientsText;
  private String productNameFr;
  private String energy;
  private String nutriScore;
  private String environmentImpactLevelTags;

  public ProductDB(String code, String imageUrl, String ingredientsText,
      String productNameFr, String energy, String nutriScore, String environmentImpactLevelTags) {
    this.code = code;
    this.imageUrl = imageUrl;
    this.ingredientsText = ingredientsText;
    this.productNameFr = productNameFr;
    this.energy = energy;
    this.nutriScore = nutriScore;
    this.environmentImpactLevelTags = environmentImpactLevelTags;
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

  public String getNutriScore() {
    return nutriScore;
  }

  public void setNutriScore(String nutriScore) {
    this.nutriScore = nutriScore;
  }

  public String getEnvironmentImpactLevelTags() {
    return environmentImpactLevelTags;
  }

  public void setEnvironmentImpactLevelTags(String environmentImpactLevelTags) {
    this.environmentImpactLevelTags = environmentImpactLevelTags;
  }
}
