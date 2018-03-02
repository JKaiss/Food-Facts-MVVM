package com.jaafoura.foodfacts.view.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.jaafoura.foodfacts.R;
import com.jaafoura.foodfacts.view.fragments.MainFragment;

public class MainActivity extends AppCompatActivity {

  // region Life cycle

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    getSupportFragmentManager().beginTransaction()
        .replace(R.id.container, MainFragment.newInstance())
        .commit();
  }

  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
  }

  // endregion
}
