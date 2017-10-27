package com.jaafoura.foodfacts.viewmodel;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.databinding.BindingAdapter;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import com.jaafoura.foodfacts.data.ProductDB;
import com.jaafoura.foodfacts.repository.ProductRepository;
import com.squareup.picasso.Picasso;
import java.util.List;
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

  @BindingAdapter({"bind:imageUrl"})
  public static void loadImage(ImageView view, String imageUrl) {
    if (imageUrl != null && !imageUrl.isEmpty()) {
      Picasso.with(view.getContext())
          .load(imageUrl)
          .placeholder(android.R.drawable.ic_dialog_alert)
          .into(view);
    } else {
      Picasso.with(view.getContext())
          .load(android.R.drawable.ic_dialog_alert)
          .into(view);
    }
  }
}
