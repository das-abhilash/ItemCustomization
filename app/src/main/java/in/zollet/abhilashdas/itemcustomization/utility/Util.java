package in.zollet.abhilashdas.itemcustomization.utility;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import in.zollet.abhilashdas.itemcustomization.ItemApplication;

public class Util {

    public static boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) ItemApplication.getInstance()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        return activeNetwork != null && activeNetwork.isConnected();
    }

}
