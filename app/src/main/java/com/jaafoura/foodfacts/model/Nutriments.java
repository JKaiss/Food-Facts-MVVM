
package com.jaafoura.foodfacts.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Nutriments {

  @SerializedName("energy_100g")
  @Expose
  private String energy100g;


  public String getEnergy100g() {
    return energy100g;
  }

  public void setEnergy100g(String energy100g) {
    this.energy100g = energy100g;
  }


}
