
package com.jaafoura.foodfacts.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Product {

  @SerializedName("product_name_fr")
  @Expose
  private String productNameFr;
  @SerializedName("product_name_en")
  @Expose
  private String productNameEn;
  @SerializedName("nutriments")
  @Expose
  private Nutriments nutriments;
  @SerializedName("ingredients_text")
  @Expose
  private String ingredientsText;
  @SerializedName("code")
  @Expose
  private String code;
  @SerializedName("image_url")
  @Expose
  private String imageUrl;

  public String getCode() {
    return code;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public String getProductNameFr() {
    return productNameFr;
  }

  public String getIngredientsText() {
    return ingredientsText;
  }

  public Nutriments getNutriments() {
    return nutriments;
  }

  public String getProductNameEn() {
    return productNameEn;
  }

  public void setProductNameEn(String productNameEn) {
    this.productNameEn = productNameEn;
  }
}
