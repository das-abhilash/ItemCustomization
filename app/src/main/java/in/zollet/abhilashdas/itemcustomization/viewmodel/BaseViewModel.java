package in.zollet.abhilashdas.itemcustomization.viewmodel;

import android.support.annotation.CallSuper;

import java.util.HashMap;
import java.util.Map;


import in.zollet.abhilashdas.itemcustomization.viewmodel.contract.LifeCycle;
import rx.Observable;
import rx.Observer;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;


public abstract class BaseViewModel implements LifeCycle.ViewModel {

    protected CompositeSubscription compositeSubscription=new CompositeSubscription();

    @Override
    public void onDestroy() {
        if(compositeSubscription!=null && !compositeSubscription.isUnsubscribed()){
            compositeSubscription.unsubscribe();
        }
    }

}
