package com.jaafoura.foodfacts.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.annotation.Nullable;
import com.jaafoura.foodfacts.data.ProductDB;
import com.jaafoura.foodfacts.repository.ProductRepository;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by kjaafoura on 27/10/2017.
 */

public class HistoryViewModel extends ViewModel {

  private final ProductRepository mProductRepository;
  private MutableLiveData<List<ProductDB>> liveData;

  @Inject
  public HistoryViewModel(ProductRepository mProductRepository) {
    this.mProductRepository = mProductRepository;
  }

  public LiveData<List<ProductDB>> getProducts(LifecycleOwner owner) {
    // Product live data will recieve the data
    if (liveData != null) {
      return liveData;
    }
    liveData = new MutableLiveData<>();
    mProductRepository.findAll().observe(owner, new Observer<List<ProductDB>>() {
      @Override
      public void onChanged(@Nullable List<ProductDB> productDBS) {
        liveData.setValue(productDBS);
      }
    });
    return liveData;
  }

}
