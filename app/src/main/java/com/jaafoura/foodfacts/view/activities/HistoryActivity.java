package com.jaafoura.foodfacts.view.activities;

import android.arch.lifecycle.Observer;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import com.jaafoura.foodfacts.R;
import com.jaafoura.foodfacts.dagger.AppComponent;
import com.jaafoura.foodfacts.data.ProductDB;
import com.jaafoura.foodfacts.databinding.ActivityHistoryBinding;
import com.jaafoura.foodfacts.view.adapters.ProductAdapter;
import com.jaafoura.foodfacts.view.adapters.ProductAdapter.OnItemClickListener;
import com.jaafoura.foodfacts.viewmodel.HistoryViewModel;
import java.util.List;
import javax.inject.Inject;

public class HistoryActivity extends AppCompatActivity {

  // region Properties

  @Inject
  HistoryViewModel historyViewModel;
  private ProductAdapter mProductAdapter;
  ActivityHistoryBinding activityHistoryBinding;

  // endregion

  // region Life cycle

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.activityHistoryBinding =
        DataBindingUtil.setContentView(this, R.layout.activity_history);
    AppComponent.from(this).inject(this);

    mProductAdapter = new ProductAdapter(new OnItemClickListener() {
      @Override
      public void onItemClick(ProductDB item) {
        Intent intent = new Intent(HistoryActivity.this, DetailsActivity.class);
        intent.putExtra(DetailsActivity.EXTRA_CODE, item.getCode());
        startActivity(intent);
      }
    });
    activityHistoryBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    activityHistoryBinding.recyclerView.setAdapter(mProductAdapter);
    historyViewModel.getProducts(this).observe(this, new Observer<List<ProductDB>>() {
      @Override
      public void onChanged(@Nullable List<ProductDB> productDBS) {
        mProductAdapter.setRepos(productDBS);
      }
    });
  }

  // endregion

}
