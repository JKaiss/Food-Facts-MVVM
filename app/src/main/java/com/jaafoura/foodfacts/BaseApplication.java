package com.jaafoura.foodfacts;

import android.app.Application;
import com.jaafoura.foodfacts.dagger.AppComponent;
import com.jaafoura.foodfacts.dagger.AppModule;
import com.jaafoura.foodfacts.dagger.DaggerAppComponent;
import com.jaafoura.foodfacts.dagger.RoomModule;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by kjaafoura on 26/10/2017.
 */

public class BaseApplication extends Application {

  private AppComponent appComponent;

  @Override
  public void onCreate() {
    super.onCreate();
    if (LeakCanary.isInAnalyzerProcess(this)) {
      // This process is dedicated to LeakCanary for heap analysis.
      // You should not init your app in this process.
      return;
    }
    LeakCanary.install(this);

    this.appComponent = DaggerAppComponent.builder()
        .appModule(new AppModule(this))
        .roomModule(new RoomModule(this))
        .build();
  }

  public AppComponent getAppComponent() {
    return appComponent;
  }
}
