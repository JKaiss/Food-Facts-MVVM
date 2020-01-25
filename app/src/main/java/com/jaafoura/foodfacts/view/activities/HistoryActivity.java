package com.jaafoura.foodfacts.view.activities;

import androidx.lifecycle.Observer;
import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.appcompat.widget.Toolbar;
import com.jaafoura.foodfacts.R;
import com.jaafoura.foodfacts.dagger.AppComponent;
import com.jaafoura.foodfacts.data.ProductDB;
import com.jaafoura.foodfacts.databinding.ActivityHistoryBinding;
import com.jaafoura.foodfacts.view.adapters.ProductAdapter;
import com.jaafoura.foodfacts.view.adapters.ProductAdapter.OnItemClickListener;
import com.jaafoura.foodfacts.viewmodel.HistoryViewModel;
import java.util.Collections;
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

    setSupportActionBar(activityHistoryBinding.toolbar);
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
        // Reverse list to get recent at the top
        Collections.reverse(productDBS);
        mProductAdapter.setRepos(productDBS);
      }
    });
  }

  // endregion

}
