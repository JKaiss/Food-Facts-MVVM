package com.jaafoura.foodfacts.view.adapters;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.jaafoura.foodfacts.R;
import com.jaafoura.foodfacts.data.ProductDB;
import com.jaafoura.foodfacts.databinding.ProductItemBinding;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kjaafoura on 26/10/2017.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

  private final List<ProductDB> productDBS = new ArrayList<>();
  private final OnItemClickListener listener;


  public interface OnItemClickListener {

    void onItemClick(ProductDB item);
  }

  public ProductAdapter(OnItemClickListener listener) {
    this.listener = listener;

  }

  @Override
  public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    final ProductItemBinding binding = DataBindingUtil
        .inflate(LayoutInflater.from(parent.getContext()), R.layout.product_item, parent, false);
    return new ProductViewHolder(binding);
  }

  @Override
  public void onBindViewHolder(ProductViewHolder holder, int position) {
    holder.bind(holder, productDBS.get(position), listener);
  }

  public void setRepos(List<ProductDB> repos) {
    this.productDBS.clear();
    this.productDBS.addAll(repos);
    notifyDataSetChanged();
  }

  public void clear() {
    this.productDBS.clear();
    notifyDataSetChanged();
  }

  /**
   * Returns the total number of items in the data set held by the adapter.
   *
   * @return The total number of items in this adapter.
   */
  @Override
  public int getItemCount() {
    return productDBS.size();
  }

  public class ProductViewHolder extends RecyclerView.ViewHolder {

    final ProductItemBinding binding;

    public ProductViewHolder(ProductItemBinding binding) {
      super(binding.getRoot());
      this.binding = binding;
    }

    public void bind(ProductViewHolder holder, final ProductDB item,
        final OnItemClickListener listener) {
      holder.binding.setProduct(item);
      holder.binding.getRoot().setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          listener.onItemClick(item);
        }
      });
    }
  }
}
