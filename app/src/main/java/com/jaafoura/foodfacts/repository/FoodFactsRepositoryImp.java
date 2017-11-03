package com.jaafoura.foodfacts.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;
import com.jaafoura.foodfacts.data.ProductDB;
import com.jaafoura.foodfacts.data.mappers.ProductMapper;
import com.jaafoura.foodfacts.model.ResponseEntity;
import com.jaafoura.foodfacts.network.FoodFactsApi;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by kjaafoura on 26/10/2017.
 */

public class FoodFactsRepositoryImp implements FoodFactsRepository {

  private final FoodFactsApi mFoodFactsApi;

  private final ProductMapper mProductMapper;

  public FoodFactsRepositoryImp(FoodFactsApi foodFactsApi, ProductMapper mProductMapper) {
    this.mFoodFactsApi = foodFactsApi;
    this.mProductMapper = mProductMapper;
  }


  @Override
  public LiveData<ProductDB> getProduct(String codeBare) {
    final MutableLiveData<ProductDB> liveData = new MutableLiveData<>();
    mFoodFactsApi.getProduct(codeBare).enqueue(new Callback<ResponseEntity>() {
      @Override
      public void onResponse(Call<ResponseEntity> call, Response<ResponseEntity> response) {
        // Return a Product in the LiveData
        liveData.setValue(mProductMapper.createObject(response.body().getProduct()));
      }

      @Override
      public void onFailure(Call<ResponseEntity> call, Throwable t) {
        Log.d("error : ", call.toString());
        liveData.setValue(null);
      }
    });
    return liveData;
  }
}
