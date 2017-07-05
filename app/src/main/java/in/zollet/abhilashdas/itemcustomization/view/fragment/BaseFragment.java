package in.zollet.abhilashdas.itemcustomization.view.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MenuItem;

import in.zollet.abhilashdas.itemcustomization.utility.Util;
import in.zollet.abhilashdas.itemcustomization.viewmodel.contract.LifeCycle;


public abstract class BaseFragment extends Fragment implements LifeCycle.View {

    public abstract LifeCycle.ViewModel getViewModel();
    public static final String TAG="BaseFragment";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onResume() {
        super.onResume();
        getViewModel().onViewResumed();
    }

    @Override
    public void onStart() {
        super.onStart();
        getViewModel().onViewStarted(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        getViewModel().onViewStopped();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getViewModel().onDestroy();
    }

    @Override
    public void showProgress() {
    }

    @Override
    public void hideProgress() {
    }

    @Override
    public void  showError(Throwable e){
    }

    @Override
    public void  showError(Exception e){
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==android.R.id.home){
            getActivity().onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
