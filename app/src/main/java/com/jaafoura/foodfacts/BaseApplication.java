package com.jaafoura.foodfacts;

import android.app.Application;
import com.jaafoura.foodfacts.dagger.AppComponent;
import com.jaafoura.foodfacts.dagger.AppModule;
import com.jaafoura.foodfacts.dagger.DaggerAppComponent;
import com.jaafoura.foodfacts.dagger.RoomModule;

/**
 * Created by kjaafoura on 26/10/2017.
 */

public class BaseApplication extends Application {

  private AppComponent appComponent;

  @Override
  public void onCreate() {
    super.onCreate();

    this.appComponent = DaggerAppComponent.builder()
        .appModule(new AppModule(this))
        .roomModule(new RoomModule(this))
        .build();
  }

  public AppComponent getAppComponent() {
    return appComponent;
  }
}
