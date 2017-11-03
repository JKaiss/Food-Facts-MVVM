
package com.jaafoura.foodfacts.model;

import android.text.Html;
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

  public String getProductName() {
    if (productNameFr != null && !productNameFr.isEmpty()) {
      return String.valueOf(Html.fromHtml(productNameFr));
    }

    if (productNameEn != null && !productNameEn.isEmpty()) {
      return String.valueOf(Html.fromHtml(productNameEn));
    }
    return null;
  }

  public String getEnergy() {
    if (nutriments != null) {
      return nutriments.getEnergy100g();
    } else {
      return null;
    }
  }

}
