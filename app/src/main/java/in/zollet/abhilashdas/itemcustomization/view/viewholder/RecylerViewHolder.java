package in.zollet.abhilashdas.itemcustomization.view.viewholder;

import android.databinding.ViewDataBinding;

import com.h6ah4i.android.widget.advrecyclerview.utils.AbstractExpandableItemViewHolder;

import in.zollet.abhilashdas.itemcustomization.BR;
import in.zollet.abhilashdas.itemcustomization.view.adapter.BaseRecyclerAdapter;
import in.zollet.abhilashdas.itemcustomization.viewmodel.BaseViewModel;

public class RecylerViewHolder extends AbstractExpandableItemViewHolder {

    private final ViewDataBinding mBinding;

    public RecylerViewHolder(ViewDataBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bind(Object item, int groupPosition, int childPosition, BaseRecyclerAdapter adapter, BaseViewModel viewModel, boolean isExpanded) {
        mBinding.setVariable(BR.item, item);
        mBinding.setVariable(BR.position, groupPosition);
        mBinding.setVariable(BR.childPosition, childPosition);
        mBinding.setVariable(BR.model, viewModel);
        mBinding.setVariable(BR.adapter, adapter);
        mBinding.setVariable(BR.isExpanded, isExpanded);
        mBinding.executePendingBindings();
    }
}