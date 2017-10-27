package com.jaafoura.foodfacts.viewmodel;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.Nullable;
import com.jaafoura.foodfacts.data.ProductDB;
import com.jaafoura.foodfacts.repository.ProductRepository;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by kjaafoura on 27/10/2017.
 */

public class HistoryViewModel extends ViewModel {

  private final ProductRepository mProductRepository;

  @Inject
  public HistoryViewModel(ProductRepository mProductRepository) {
    this.mProductRepository = mProductRepository;
  }

  public LiveData<List<ProductDB>> getProducts(LifecycleOwner owner) {
    // Product live data will recieve the data
    final MutableLiveData<List<ProductDB>> liveData = new MutableLiveData<>();
    mProductRepository.findAll().observe(owner, new Observer<List<ProductDB>>() {
      @Override
      public void onChanged(@Nullable List<ProductDB> productDBS) {
        liveData.setValue(productDBS);
      }
    });
    return liveData;
  }

}
