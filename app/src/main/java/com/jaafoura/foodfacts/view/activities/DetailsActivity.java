package com.jaafoura.foodfacts.view.activities;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import com.jaafoura.foodfacts.R;
import com.jaafoura.foodfacts.dagger.AppComponent;
import com.jaafoura.foodfacts.data.ProductDB;
import com.jaafoura.foodfacts.databinding.ActivityDetailsBinding;
import com.jaafoura.foodfacts.repository.ProductRepository;
import com.jaafoura.foodfacts.viewmodel.DetailsViewModel;
import javax.inject.Inject;

public class DetailsActivity extends AppCompatActivity {

  // region Properties

  public static final String EXTRA_CODE = "product_id";

  ActivityDetailsBinding activityDetailsBinding;

  @Inject
  public ProductRepository productRepository;

  @Inject
  DetailsViewModel detailsViewModel;

  // endregion

  // region Life Cycle

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.activityDetailsBinding =
        DataBindingUtil.setContentView(this, R.layout.activity_details);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
  }

  @Override
  protected void onResume() {
    super.onResume();
    AppComponent.from(this).inject(this);
    Intent intent = getIntent();
    if (intent != null) {
      String code = intent.getStringExtra(EXTRA_CODE);
      productRepository.findByCode(code).observe(this, new Observer<ProductDB>() {
        @Override
        public void onChanged(@Nullable ProductDB productDB) {
          activityDetailsBinding.setProduct(productDB);
        }
      });
    }
  }

  // endregion

}
