package com.jaafoura.foodfacts.view.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.jaafoura.foodfacts.view.fragments.MainFragment;
import me.dm7.barcodescanner.zbar.Result;
import me.dm7.barcodescanner.zbar.ZBarScannerView;


public class ScanActivity extends Activity implements ZBarScannerView.ResultHandler {

  private ZBarScannerView mScannerView;

  @Override
  public void onCreate(Bundle state) {
    super.onCreate(state);
    mScannerView = new ZBarScannerView(this);
    setContentView(mScannerView);
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

  @Override
  public void handleResult(Result rawResult) {
    mScannerView.resumeCameraPreview(this);
    Intent returnIntent = new Intent();
    returnIntent.putExtra(MainFragment.EXTRA_SCAN_BARCODE, rawResult.getContents());
    setResult(Activity.RESULT_OK, returnIntent);
    finish();
  }
}
