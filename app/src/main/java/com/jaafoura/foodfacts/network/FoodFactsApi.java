package com.jaafoura.foodfacts.network;

import com.jaafoura.foodfacts.model.ResponseEntity;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by kjaafoura on 25/10/2017.
 */

public interface FoodFactsApi {

  String baseURL = "https://world.openfoodfacts.org/api/v0/product/";

  @GET("/{barcodeNumber}.json") Call<ResponseEntity> getProduct(@Path("barcodeNumber") long codeBare);

}
