package in.zollet.abhilashdas.itemcustomization.network.service;

import java.util.Map;

import in.zollet.abhilashdas.itemcustomization.model.ServerResponse;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

public interface ItemService {

    @GET("bins/3b0u2")
    Observable<Response<ServerResponse>> getItemData();
}
