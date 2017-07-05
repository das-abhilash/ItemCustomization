package in.zollet.abhilashdas.itemcustomization.viewmodel.contract;


public interface ItemViewModelContract {


    interface View extends LifeCycle.View{
        void onBackPress();
        void onFinish();
    }

    interface ViewModel extends LifeCycle.ViewModel{
    }

}
