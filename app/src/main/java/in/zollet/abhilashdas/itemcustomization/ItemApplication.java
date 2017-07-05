package in.zollet.abhilashdas.itemcustomization;

import android.app.Application;
import android.content.Context;

import in.zollet.abhilashdas.itemcustomization.dependencyinjection.component.ApplicationComponent;
import in.zollet.abhilashdas.itemcustomization.dependencyinjection.component.DaggerApplicationComponent;
import in.zollet.abhilashdas.itemcustomization.dependencyinjection.module.AppModule;

public class ItemApplication extends Application {

    private ApplicationComponent component;
    private static ItemApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        component = DaggerApplicationComponent.builder()
                .appModule(new AppModule(this))
                .build();
        component().inject(this);


    }

    public static ItemApplication get(Context context) {
        return (ItemApplication) context.getApplicationContext();
    }

    public static ItemApplication getInstance() {
        return application;
    }


    public ApplicationComponent component() {
        return component;
    }

}
