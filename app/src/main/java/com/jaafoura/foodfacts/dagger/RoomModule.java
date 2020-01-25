package com.jaafoura.foodfacts.dagger;

import android.app.Application;
import androidx.room.Room;
import com.jaafoura.foodfacts.data.ProductDao;
import com.jaafoura.foodfacts.repository.FoodFactsDatabase;
import com.jaafoura.foodfacts.repository.ProductDataSource;
import com.jaafoura.foodfacts.repository.ProductRepository;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by kjaafoura on 26/10/2017.
 */

@Module
public class RoomModule {

  private FoodFactsDatabase foodFactsDatabase;

  public RoomModule(Application mApplication) {
    foodFactsDatabase = Room.databaseBuilder(mApplication, FoodFactsDatabase.class, "food-db")
        .fallbackToDestructiveMigration() // migration from version of database with destruct data because we have occurrence, in other case we use migration schema
        .build();
  }

  @Singleton
  @Provides
  FoodFactsDatabase providesRoomDatabase() {
    return foodFactsDatabase;
  }

  @Singleton
  @Provides
  ProductDao providesProductDao(FoodFactsDatabase demoDatabase) {
    return demoDatabase.getProductDao();
  }

  @Singleton
  @Provides
  ProductRepository productRepository(ProductDao productDao) {
    return new ProductDataSource(productDao);
  }
}
