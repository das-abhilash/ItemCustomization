package in.zollet.abhilashdas.itemcustomization.viewmodel.implementation;


import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import in.zollet.abhilashdas.itemcustomization.ItemApplication;
import in.zollet.abhilashdas.itemcustomization.model.ExcludeList;
import in.zollet.abhilashdas.itemcustomization.model.ServerResponse;
import in.zollet.abhilashdas.itemcustomization.model.VariantGroup;
import in.zollet.abhilashdas.itemcustomization.model.Variation;
import in.zollet.abhilashdas.itemcustomization.network.manager.ItemManager;
import in.zollet.abhilashdas.itemcustomization.viewmodel.BaseViewModel;
import in.zollet.abhilashdas.itemcustomization.viewmodel.contract.ItemViewModelContract;
import in.zollet.abhilashdas.itemcustomization.viewmodel.contract.LifeCycle;
import rx.Observable;
import rx.Observer;

public class ItemViewModel extends BaseViewModel implements ItemViewModelContract.ViewModel{


    public ObservableField<List<VariantGroup>> list = new ObservableField<>();
    public ObservableBoolean toggle = new ObservableBoolean();
    private Map<Integer,List<Variation> > excludeList = new HashMap<>();
    private Map<String,Variation> finalList = new HashMap<>();
    private ServerResponse respoce;


    @Inject
    public ItemManager manager;
    private ItemViewModelContract.View viewCallback;
    @Override
    public void onViewResumed() {

    }

    public ItemViewModel(){
        ItemApplication.getInstance().component().inject(this);

    }

    @Override
    public void onViewStarted(@NonNull LifeCycle.View viewCallback) {
        this.viewCallback = (ItemViewModelContract.View) viewCallback;
        doApiCall();
    }

    private void doApiCall(){
        compositeSubscription.add(manager.getItemData().subscribe(new ItemObserver()));
    }
    @Override
    public void onViewStopped() {

    }

    public class ItemObserver implements Observer<ServerResponse> {

        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Toast.makeText(viewCallback.getActivityContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNext(ServerResponse serverResponse) {
            respoce = serverResponse;
            list.set(serverResponse.getVariants().getVariantGroups());

            excludeList.clear();

            int i = 0;
                for (List<ExcludeList> list: serverResponse.getVariants().getExcludeList()) {

                    int groupId  = Integer.parseInt(list.get(0).getGroupId());
                    int childId  = Integer.parseInt(list.get(0).getVariationId());

                    Variation key = fingParent(serverResponse,String.valueOf(groupId),String.valueOf(childId));

                    int groupIdV  = Integer.parseInt(list.get(1).getGroupId());
                    int childIdV  = Integer.parseInt(list.get(1).getVariationId());

                    Variation value = fingParent(serverResponse,String.valueOf(groupIdV),String.valueOf(childIdV));

                    List<Variation> exList = new ArrayList<>();
                    exList.add(key);
                    exList.add(value);

                    excludeList.put(i,exList);
                    i ++;

                }

        }
    }

    private Variation fingParent(ServerResponse serverResponse, String id, String childID){
        for (int i = 0; i < serverResponse.getVariants().getVariantGroups().size(); i++) {
            if(serverResponse.getVariants().getVariantGroups().get(i).getGroupId().equalsIgnoreCase(id)){
                for (Variation v :
                        serverResponse.getVariants().getVariantGroups().get(i).getVariations() ) {
                    if(v.getId().equalsIgnoreCase(childID)){
                        return v;
                    }

                }
            }


        }
        return null;
    }

    public boolean isEnabled(boolean flag,Variation variation){
        toggle.set(!flag);
        if(variation.getInStock()== 0)
            return false;

        if(finalList.containsValue(getExcludeItem(variation)))
            return false;

        return true;
    }

    public boolean isSelected (boolean flag,Variation variation){
        toggle.set(!flag);
        return finalList.containsValue(variation);
    }

    private Variation getExcludeItem(Variation variation) {

        for (int i = 0; i < excludeList.size(); i++) {
            for (int j = 0; j < excludeList.get(i).size(); j++) {
               List<Variation> l =  excludeList.get(i);
                if(l.get(0).equals(variation))
                    return l.get(1);
                else if(l.get(1).equals(variation)){
                    return l.get(0);
                }
            }
        }

        return new Variation();
    }

    public void itemClickde(int varientPosition,Variation variation){
        if(isEnabled(toggle.get(),variation)) {
            finalList.put(respoce.getVariants().getVariantGroups().get(varientPosition).getGroupId(), variation);
        }
    }
}
