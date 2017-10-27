package com.jaafoura.foodfacts.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.BindingAdapter;
import android.os.AsyncTask;
import android.widget.ImageView;
import com.jaafoura.foodfacts.R;
import com.jaafoura.foodfacts.data.ProductDB;
import com.jaafoura.foodfacts.data.mappers.ProductMapper;
import com.jaafoura.foodfacts.repository.FoodFactsRepository;
import com.jaafoura.foodfacts.repository.ProductRepository;
import com.squareup.picasso.Picasso;
import javax.inject.Inject;

/**
 * Created by kjaafoura on 26/10/2017.
 */

public class ProductViewModel extends ViewModel {

  private final FoodFactsRepository mFoodFactsRepository;


  private final ProductRepository mProductRepository;

  @Inject
  public ProductViewModel(FoodFactsRepository foodFactsRepository,
      ProductRepository mProductRepository) {
    this.mFoodFactsRepository = foodFactsRepository;
    this.mProductRepository = mProductRepository;
  }

  public LiveData<ProductDB> getProduct(String barCode) {
    // Product live data will recieve the data
    return mFoodFactsRepository.getProduct(barCode);
  }


  public void addProduct(ProductDB productDB) {
    // Add product in the background thread
    new AddProductAsyncTask(mProductRepository).execute(productDB);
  }

  private static class AddProductAsyncTask extends AsyncTask<ProductDB, Void,
      Void> {

    private ProductRepository productRepository;

    public AddProductAsyncTask(ProductRepository userDatabase) {
      productRepository = userDatabase;
    }

    @Override
    protected Void doInBackground(ProductDB... params) {
      productRepository.insert(params[0]);
      return null;
    }
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
