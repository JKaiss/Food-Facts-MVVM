package com.jaafoura.foodfacts.dagger;

import android.content.Context;
import android.support.annotation.NonNull;
import com.jaafoura.foodfacts.BaseApplication;
import com.jaafoura.foodfacts.view.activities.DetailsActivity;
import com.jaafoura.foodfacts.view.activities.HistoryActivity;
import com.jaafoura.foodfacts.view.fragments.MainFragment;
import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by kjaafoura on 26/10/2017.
 */

@Singleton
@Component(dependencies = {}, modules = {AppModule.class, RoomModule.class})
public abstract class AppComponent {

  public static AppComponent from(@NonNull Context context) {
    return ((BaseApplication) context.getApplicationContext()).getAppComponent();
  }

  public abstract void inject(MainFragment mainFragment);

  public abstract void inject(HistoryActivity historyActivity);

  public abstract void inject(DetailsActivity detailsActivity);

}
