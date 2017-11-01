package com.jaafoura.foodfacts.dagger;

import android.app.Application;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jaafoura.foodfacts.data.mappers.ProductMapper;
import com.jaafoura.foodfacts.network.FoodFactsApi;
import com.jaafoura.foodfacts.repository.FoodFactsRepository;
import com.jaafoura.foodfacts.repository.FoodFactsRepositoryImp;
import dagger.Module;
import dagger.Provides;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import okhttp3.CipherSuite;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.TlsVersion;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kjaafoura on 26/10/2017.
 */

@Module
public class AppModule {

  private static final long TIME_OUT = 10000;
  private final Application application;

  public AppModule(Application application) {
    this.application = application;
  }

  @Provides
  @Singleton
  public FoodFactsApi providesFoodFactsApi() {
    return new Retrofit.Builder().baseUrl(FoodFactsApi.baseURL)
        .client(createClient())
        .addConverterFactory(GsonConverterFactory.create(getGsonViaBuilder()))
        .build()
        .create(FoodFactsApi.class);
  }

  private static Gson getGsonViaBuilder() {
    return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
  }

  private OkHttpClient createClient() {

    ConnectionSpec spec =
        new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
            .tlsVersions(TlsVersion.TLS_1_0) // add tls version 1.1 and 1.0
            .cipherSuites(
                // Android 5.0
                CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256,
                CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256,
                CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256,
                // Android 4.4
                CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA,
                CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA,
                CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA,
                CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA,
                CipherSuite.TLS_DHE_RSA_WITH_AES_128_CBC_SHA,
                CipherSuite.TLS_DHE_DSS_WITH_AES_128_CBC_SHA,
                CipherSuite.TLS_DHE_RSA_WITH_AES_256_CBC_SHA,
                CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256,
                CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA,
                CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA,
                CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA
            )
            .build();
    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
    logging.setLevel(HttpLoggingInterceptor.Level.BODY);
    OkHttpClient.Builder b = new OkHttpClient.Builder();
    b.connectTimeout(TIME_OUT, TimeUnit.MILLISECONDS);
    b.readTimeout(TIME_OUT, TimeUnit.MILLISECONDS);
    b.writeTimeout(TIME_OUT, TimeUnit.MILLISECONDS);
    b.addInterceptor(logging);
    b.connectionSpecs(Collections.singletonList(spec));
    OkHttpClient okHttpClient = b.build();

    return okHttpClient;
  }


  @Provides
  @Singleton
  public FoodFactsRepository providesFoodFactsRepository(FoodFactsApi foodFactsApi,
      ProductMapper productMapper) {
    return new FoodFactsRepositoryImp(foodFactsApi, productMapper);
  }
}
