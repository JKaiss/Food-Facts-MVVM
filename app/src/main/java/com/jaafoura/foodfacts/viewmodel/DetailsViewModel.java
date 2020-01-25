package com.jaafoura.foodfacts.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.databinding.BindingAdapter;
import androidx.annotation.Nullable;
import android.widget.ImageView;
import com.jaafoura.foodfacts.data.ProductDB;
import com.jaafoura.foodfacts.repository.ProductRepository;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

/**
 * Created by kjaafoura on 27/10/2017.
 */

public class DetailsViewModel extends ViewModel {

  private final ProductRepository mProductRepository;

  @Inject
  public DetailsViewModel(ProductRepository mProductRepository) {
    this.mProductRepository = mProductRepository;
  }

  public LiveData<ProductDB> getProduct(LifecycleOwner owner, String code) {
    final MutableLiveData<ProductDB> liveData = new MutableLiveData<>();

    mProductRepository.findByCode(code).observe(owner, new Observer<ProductDB>() {
      @Override
      public void onChanged(@Nullable ProductDB productDB) {
        liveData.setValue(productDB);
      }
    });
    return liveData;
  }
}
