package in.zollet.abhilashdas.itemcustomization.network.manager;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import in.zollet.abhilashdas.itemcustomization.ItemApplication;
import in.zollet.abhilashdas.itemcustomization.model.ServerResponse;
import in.zollet.abhilashdas.itemcustomization.network.service.ItemService;
import retrofit2.Response;
import rx.Observable;

public class ItemManager extends NetworkManager {

    @Inject
    ItemService itemService;

    public ItemManager() {
        ItemApplication.getInstance().component().inject(this);
    }

    public Observable<ServerResponse> getItemData() {

        Observable<Response<ServerResponse>> bookingData = itemService.getItemData();
        return handleApiObservable(bookingData);
    }
}
