package in.zollet.abhilashdas.itemcustomization.dependencyinjection.module;

import dagger.Module;
import dagger.Provides;
import in.zollet.abhilashdas.itemcustomization.network.service.ItemService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


@Module
public class NetworkModule {

    @Provides
    OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        return client.build();
    }


    @Provides
    Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.myjson.com/")
                .client( okHttpClient)
                .build();
        return retrofit;
    }


    @Provides
    ItemService provideItemService(Retrofit retrofit) {
        return retrofit.create(ItemService.class);
    }

}
