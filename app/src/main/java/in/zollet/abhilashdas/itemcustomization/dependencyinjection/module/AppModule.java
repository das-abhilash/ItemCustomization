package in.zollet.abhilashdas.itemcustomization.dependencyinjection.module;

import android.content.Context;
import android.location.LocationManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import in.zollet.abhilashdas.itemcustomization.ItemApplication;
import in.zollet.abhilashdas.itemcustomization.dependencyinjection.qualifier.ForApplication;
import in.zollet.abhilashdas.itemcustomization.network.manager.ItemManager;

import static android.content.Context.LOCATION_SERVICE;

@Module(includes = {ViewModelModule.class})
public class AppModule {

    private final ItemApplication application;

    public AppModule(ItemApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    @ForApplication
    Context provideApplicationContext() {
        return application;
    }

    @Provides
    @Singleton
    LocationManager provideLocationManager() {
        return (LocationManager) application.getSystemService(LOCATION_SERVICE);
    }

    @Provides
    @Singleton
    ItemManager provideProfileManager() {
        return new ItemManager();
    }


}
