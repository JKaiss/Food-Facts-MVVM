package com.jaafoura.foodfacts.view.fragments;

import static android.app.Activity.RESULT_OK;

import androidx.lifecycle.Observer;
import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.arlib.floatingsearchview.FloatingSearchView;
import com.arlib.floatingsearchview.FloatingSearchView.OnSearchListener;
import com.arlib.floatingsearchview.suggestions.model.SearchSuggestion;
import com.jaafoura.foodfacts.R;
import com.jaafoura.foodfacts.dagger.AppComponent;
import com.jaafoura.foodfacts.data.ProductDB;
import com.jaafoura.foodfacts.databinding.FragmentMainBinding;
import com.jaafoura.foodfacts.repository.ProductRepository;
import com.jaafoura.foodfacts.view.activities.DetailsActivity;
import com.jaafoura.foodfacts.view.activities.HistoryActivity;
import com.jaafoura.foodfacts.view.activities.ScanActivity;
import com.jaafoura.foodfacts.view.adapters.ProductAdapter;
import com.jaafoura.foodfacts.view.adapters.ProductAdapter.OnItemClickListener;
import com.jaafoura.foodfacts.viewmodel.ProductViewModel;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

  private static final int SCAN_BARCODE_REQUEST = 18;
  public static final String EXTRA_SCAN_BARCODE =  "extra_scan_barcode";

  // region Properties

  private FragmentMainBinding viewDataBinding;
  private ProductAdapter mProductAdapter;
  Observer<List<ProductDB>> observer;
  @Inject
  ProductViewModel productViewModel;

  @Inject
  public ProductRepository productRepository;

  // endregion

  // region Constructor

  public static Fragment newInstance() {
    return new MainFragment();
  }

  public MainFragment() {
    // Required empty public constructor
  }

  // endregion

  // region Life cycle

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    //get the databinding from the layout
    this.viewDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
    return viewDataBinding.getRoot();
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    AppComponent.from(getContext()).inject(this);
    // 3329770057258
    mProductAdapter = new ProductAdapter(new OnItemClickListener() {
      @Override
      public void onItemClick(ProductDB item) {
        Intent intent = new Intent(getActivity(), DetailsActivity.class);
        intent.putExtra(DetailsActivity.EXTRA_CODE, item.getCode());
        startActivity(intent);
      }
    });
    viewDataBinding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    viewDataBinding.recyclerView.setAdapter(mProductAdapter);

    // Search query
    viewDataBinding.floatingSearchView.setOnSearchListener(new OnSearchListener() {
      @Override
      public void onSuggestionClicked(SearchSuggestion searchSuggestion) {

      }

      @Override
      public void onSearchAction(String currentQuery) {
        if (observer != null) {
          productRepository.findAll().removeObserver(observer);
        }
        getProduct(currentQuery);
      }
    });

    viewDataBinding.floatingSearchView
        .setOnMenuItemClickListener(new FloatingSearchView.OnMenuItemClickListener() {
          /**
           * Called when a menu item in has been
           * selected.
           *
           * @param item the selected menu item.
           */
          @Override
          public void onActionMenuItemSelected(MenuItem item) {
            showScanner();
          }

        });

    // Fab click for history
    viewDataBinding.fab.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        getHistory();
      }
    });

  }

  // endregion

  // region Private methods

  private void getHistory() {
    Intent intent = new Intent(getActivity(), HistoryActivity.class);
    getActivity().startActivity(intent);
  }

  private void showScanner() {
    Intent intent = new Intent(getActivity(), ScanActivity.class);
    startActivityForResult(intent, SCAN_BARCODE_REQUEST);
  }

  private void getProduct(String currentQuery) {
    // show the progress bar when fetching to the product
    viewDataBinding.progressBar.setVisibility(View.VISIBLE);
    viewDataBinding.emptyView.setVisibility(View.GONE);
    productViewModel.getProduct(currentQuery)
        .observe(MainFragment.this, new Observer<ProductDB>() {
          @Override
          public void onChanged(@Nullable ProductDB product) {
            viewDataBinding.progressBar.setVisibility(View.GONE);
            if (product != null) {
              viewDataBinding.emptyView.setVisibility(View.GONE);
              List<ProductDB> products = new ArrayList<>();
              products.add(product);
              mProductAdapter.setRepos(products);
              productViewModel.addProduct(product);
            } else {
              // Clear list
              mProductAdapter.clear();
              // show message for empty data
              viewDataBinding.emptyView.setVisibility(View.VISIBLE);
            }
          }
        });
  }

  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    // Check which request we're responding to
    if (requestCode == SCAN_BARCODE_REQUEST) {
      // Make sure the request was successful
      if (resultCode == RESULT_OK) {
        // The user picked a contact.
        // The Intent's data Uri identifies which contact was selected.
        if (data != null) {
          getProduct(data.getStringExtra(EXTRA_SCAN_BARCODE));
        }
        // Do something with the contact here (bigger example below)
      }
    }
  }

  // endregion
}
