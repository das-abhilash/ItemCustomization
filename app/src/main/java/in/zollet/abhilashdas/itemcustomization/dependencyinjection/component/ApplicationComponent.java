package in.zollet.abhilashdas.itemcustomization.dependencyinjection.component;



import javax.inject.Singleton;

import dagger.Component;
import in.zollet.abhilashdas.itemcustomization.ItemApplication;
import in.zollet.abhilashdas.itemcustomization.dependencyinjection.module.AppModule;
import in.zollet.abhilashdas.itemcustomization.dependencyinjection.module.NetworkModule;
import in.zollet.abhilashdas.itemcustomization.network.manager.ItemManager;
import in.zollet.abhilashdas.itemcustomization.view.fragment.MainActivityFragment;
import in.zollet.abhilashdas.itemcustomization.viewmodel.implementation.ItemViewModel;

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class})
public interface ApplicationComponent {


    void inject(ItemManager itemManager);

    void inject(ItemApplication itemApplication);

    void inject(MainActivityFragment mainActivityFragment);

    void inject(ItemViewModel itemViewModel);
}
