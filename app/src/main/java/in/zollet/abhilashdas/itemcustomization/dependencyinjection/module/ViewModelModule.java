package in.zollet.abhilashdas.itemcustomization.dependencyinjection.module;

import dagger.Module;
import dagger.Provides;
import in.zollet.abhilashdas.itemcustomization.viewmodel.implementation.ItemViewModel;


@Module
public class ViewModelModule {

    @Provides
    public ItemViewModel provideSignInViewModel() {
        return new ItemViewModel();
    }

}
