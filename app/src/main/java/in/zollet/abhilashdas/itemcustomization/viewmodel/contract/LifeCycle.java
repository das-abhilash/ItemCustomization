package in.zollet.abhilashdas.itemcustomization.viewmodel.contract;

import android.content.Context;
import android.support.annotation.NonNull;

public interface LifeCycle {

    interface View{
        Context getActivityContext();
        void showProgress();
        void hideProgress();
        void showError(Exception e);
        void showError(Throwable t);
    }

    interface ViewModel{
        void onViewResumed();
        void onViewStarted(@NonNull LifeCycle.View viewCallback);
        void onViewStopped();
        void onDestroy();
    }

}