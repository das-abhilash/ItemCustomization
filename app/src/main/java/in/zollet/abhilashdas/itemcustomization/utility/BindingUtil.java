package in.zollet.abhilashdas.itemcustomization.utility;

import android.databinding.BindingAdapter;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.h6ah4i.android.widget.advrecyclerview.expandable.RecyclerViewExpandableItemManager;

import java.util.List;
import java.util.Map;

import in.zollet.abhilashdas.itemcustomization.R;
import in.zollet.abhilashdas.itemcustomization.model.VariantGroup;
import in.zollet.abhilashdas.itemcustomization.view.CustumDecoration;
import in.zollet.abhilashdas.itemcustomization.view.adapter.BaseRecyclerAdapter;
import in.zollet.abhilashdas.itemcustomization.view.adapter.ExapndableAdapter;
import in.zollet.abhilashdas.itemcustomization.viewmodel.BaseViewModel;


public class BindingUtil {

    @BindingAdapter({"listItem", "viewModel"})
    public static <T> void setListAdapter(RecyclerView recyclerView, List<T> listItem, BaseViewModel viewModel) {


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext(), LinearLayoutManager.VERTICAL, false);
        RecyclerViewExpandableItemManager expMgr = new RecyclerViewExpandableItemManager(null);

        ExapndableAdapter adapter = new ExapndableAdapter(viewModel, R.layout.adapter_parent, R.layout.adapter_child);
        adapter.updateList(listItem);
        recyclerView.setAdapter(expMgr.createWrappedAdapter(adapter));
        recyclerView.setLayoutManager(linearLayoutManager);
        expMgr.attachRecyclerView(recyclerView);
        recyclerView.addItemDecoration(new CustumDecoration());
        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);

    }
}
