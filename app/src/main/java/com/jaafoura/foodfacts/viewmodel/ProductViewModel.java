package com.jaafoura.foodfacts.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.databinding.BindingAdapter;
import android.os.AsyncTask;
import android.widget.ImageView;

import com.jaafoura.foodfacts.R;
import com.jaafoura.foodfacts.data.ProductDB;
import com.jaafoura.foodfacts.repository.FoodFactsRepository;
import com.jaafoura.foodfacts.repository.ProductRepository;
import com.squareup.picasso.Picasso;

import java.util.Locale;

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
    }
  }
  public static final int NO_DRAWABLE_RESOURCE = 0;

  @BindingAdapter({"bind:imageGrade"})
  public static void getImageGrade(ImageView view, String grade) {
    int drawable = NO_DRAWABLE_RESOURCE;

    if(grade == null){
      return;
    }

    switch (grade.toLowerCase(Locale.getDefault())) {
      case "a":
        drawable = R.drawable.nnc_a;
        break;
      case "b":
        drawable = R.drawable.nnc_b;
        break;
      case "c":
        drawable = R.drawable.nnc_c;
        break;
      case "d":
        drawable = R.drawable.nnc_d;
        break;
      case "e":
        drawable = R.drawable.nnc_e;
        break;
      default:
        break;
    }

    Picasso.with(view.getContext())
            .load(drawable)
            .placeholder(android.R.drawable.ic_dialog_alert)
            .into(view);
  }
  @BindingAdapter({"bind:imageEnvironmentImpact"})
  public static void getImageEnvironmentImpact(ImageView view , String environmentImpact) {
    int drawable = NO_DRAWABLE_RESOURCE;
    if (environmentImpact == null) {
      return;
    }
    if (environmentImpact.isEmpty()) {

      return;
    }
    switch (environmentImpact) {
      case "en:high":
        drawable = R.drawable.ic_co2_high_24dp;
        break;
      case "en:low":
        drawable = R.drawable.ic_co2_low_24dp;
        break;
      case "en:medium":
        drawable = R.drawable.ic_co2_medium_24dp;
        break;
      default:
    }
    Picasso.with(view.getContext())
            .load(drawable)
            .placeholder(android.R.drawable.ic_dialog_alert)
            .into(view);
  }
}
