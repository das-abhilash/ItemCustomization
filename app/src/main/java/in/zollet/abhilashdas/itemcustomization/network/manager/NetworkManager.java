package in.zollet.abhilashdas.itemcustomization.network.manager;

import java.net.HttpRetryException;
import java.net.SocketTimeoutException;

import in.zollet.abhilashdas.itemcustomization.dataprovider.exception.NoInternetException;
import in.zollet.abhilashdas.itemcustomization.dataprovider.exception.ServerRuntimeException;
import in.zollet.abhilashdas.itemcustomization.model.ServerResponse;
import in.zollet.abhilashdas.itemcustomization.utility.Util;
import retrofit2.Response;
import retrofit2.adapter.rxjava.HttpException;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class NetworkManager {

    private int DEFAULT_RETRY_ATTEMPT = 3;

    protected Observable<ServerResponse> handleApiObservable(Observable<Response<ServerResponse>> t) {

        return t.doOnSubscribe(
                () -> {
                    if (!Util.isNetworkConnected()) {
                        throw new NoInternetException("Please check internet connection.");}

                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .retry((integer, throwable) -> integer<DEFAULT_RETRY_ATTEMPT && throwable instanceof SocketTimeoutException)
                .onErrorResumeNext(this::handleHttpError)
                .filter(responseServerResponse -> responseServerResponse.isSuccessful() && responseServerResponse.body() != null)
                .map(Response::body);
    }


    private Observable<Response<ServerResponse>> handleHttpError(Throwable throwable) throws RuntimeException {
        if (throwable instanceof HttpException) {
            int status = ((HttpRetryException) throwable).responseCode();
                throw new ServerRuntimeException("Server runtime exception" + "- status code - " + status);
        } else if (throwable instanceof NoInternetException) {
            throw new NoInternetException("Please check your internet connection.");

        } else {
            throw new NoInternetException("Something went wrong. Please try again");
        }
    }
}
