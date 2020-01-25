package com.jaafoura.foodfacts.view.activities;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jaafoura.foodfacts.R;
import com.jaafoura.foodfacts.dagger.AppComponent;
import com.jaafoura.foodfacts.data.ProductDB;
import com.jaafoura.foodfacts.databinding.FragmentProductSheetBinding;
import com.jaafoura.foodfacts.repository.ProductRepository;
import com.jaafoura.foodfacts.viewmodel.ProductViewModel;

import javax.inject.Inject;

import me.dm7.barcodescanner.zbar.Result;
import me.dm7.barcodescanner.zbar.ZBarScannerView;


public class ScanActivity extends LifecycleActivity implements ZBarScannerView.ResultHandler {

    private FragmentProductSheetBinding viewDataBinding;
    private ZBarScannerView mScannerView;
    @Inject
    ProductViewModel productViewModel;

    @Inject
    public ProductRepository productRepository;
    private String lastBarCodeScanned = "";
    private BottomSheetDialog mBottomSheetDialog;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        mScannerView = new ZBarScannerView(this);
        setContentView(mScannerView);
        AppComponent.from(this).inject(this);
        initView();
    }

    private void initView() {
        mBottomSheetDialog = new BottomSheetDialog(this);
        viewDataBinding = DataBindingUtil
                .inflate(LayoutInflater.from(this), R.layout.fragment_product_sheet, ((ViewGroup) (findViewById(android.R.id.content))), false);
        mBottomSheetDialog.setContentView(viewDataBinding.getRoot());
        mBottomSheetDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                mScannerView.setResultHandler(null);
            }
        });
        mBottomSheetDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                mScannerView.setResultHandler(ScanActivity.this);
                mScannerView.resumeCameraPreview(ScanActivity.this);
                lastBarCodeScanned = "";
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    private void getProduct(String currentQuery) {
        // show the progress bar when fetching to the product
        viewDataBinding.quickViewImageProgress.setVisibility(View.VISIBLE);
        productViewModel.getProduct(currentQuery)
                .observe(ScanActivity.this, new Observer<ProductDB>() {
                    @Override
                    public void onChanged(@Nullable ProductDB product) {
                        viewDataBinding.quickViewImageProgress.setVisibility(View.GONE);
                        viewDataBinding.setProduct(product);
                        if (product != null) {
                            productViewModel.addProduct(product);
                        }
                    }
                });
    }

    @Override
    public void handleResult(Result rawResult) {
        if (!rawResult.getContents().equals(lastBarCodeScanned)) {
            mScannerView.resumeCameraPreview(this);

            lastBarCodeScanned = rawResult.getContents();

            mBottomSheetDialog.show();
            getProduct(rawResult.getContents());
        }

    }

}
