package com.jaafoura.foodfacts.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import com.jaafoura.foodfacts.model.Product;
import com.jaafoura.foodfacts.model.ResponseEntity;
import com.jaafoura.foodfacts.network.FoodFactsApi;
import org.w3c.dom.Entity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by kjaafoura on 26/10/2017.
 */

public class FoodFactsRepositoryImp implements FoodFactsRepository {
  private final FoodFactsApi foodFactsApi;

  public FoodFactsRepositoryImp(FoodFactsApi foodFactsApi) {
    this.foodFactsApi = foodFactsApi;
  }

  @Override public LiveData<Product> getProduct(long codeBare) {
    final MutableLiveData<Product> liveData = new MutableLiveData<>();
    foodFactsApi.getProduct(codeBare).enqueue(new Callback<ResponseEntity>() {
      @Override
      public void onResponse(Call<ResponseEntity> call, Response<ResponseEntity> response) {
        // Return a Product in the LiveData
        liveData.setValue(response.body().getProduct());
      }

      @Override public void onFailure(Call<ResponseEntity> call, Throwable t) {

      }
    });
    return liveData;
  }
}
