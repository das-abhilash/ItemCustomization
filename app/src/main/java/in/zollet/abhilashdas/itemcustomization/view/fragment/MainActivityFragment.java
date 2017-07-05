package in.zollet.abhilashdas.itemcustomization.view.fragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import in.zollet.abhilashdas.itemcustomization.ItemApplication;
import in.zollet.abhilashdas.itemcustomization.R;
import in.zollet.abhilashdas.itemcustomization.databinding.FragmentMainBinding;
import in.zollet.abhilashdas.itemcustomization.viewmodel.contract.ItemViewModelContract;
import in.zollet.abhilashdas.itemcustomization.viewmodel.contract.LifeCycle;
import in.zollet.abhilashdas.itemcustomization.viewmodel.implementation.ItemViewModel;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends BaseFragment implements ItemViewModelContract.View {

    public MainActivityFragment() {
    }

    @Inject
    ItemViewModel itemViewModel;
    FragmentMainBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((ItemApplication) getActivity().getApplication()).component().inject(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);

        binding.setModel(itemViewModel);

        return binding.getRoot();
    }

    @Override
    public LifeCycle.ViewModel getViewModel() {
        return itemViewModel;
    }

    @Override
    public void onBackPress() {

    }

    @Override
    public void onFinish() {

    }

    @Override
    public Context getActivityContext() {
        return getActivity();
    }
}
