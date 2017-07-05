package in.zollet.abhilashdas.itemcustomization.view.adapter;

import android.support.annotation.IntRange;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import in.zollet.abhilashdas.itemcustomization.model.VariantGroup;
import in.zollet.abhilashdas.itemcustomization.viewmodel.BaseViewModel;


public class ExapndableAdapter extends BaseRecyclerAdapter {

    List<VariantGroup> variantGroups;

    private BaseViewModel baseViewModel;
    private int parentLayout;
    private int childLayout;

    public ExapndableAdapter(BaseViewModel baseViewModel,int parentLayout, int childLayout){
        setHasStableIds(true); // it is required
        variantGroups = new ArrayList<>();
        this.baseViewModel = baseViewModel;
        this.parentLayout = parentLayout;
        this.childLayout = childLayout;
    }



    @Override
    public BaseViewModel getViewModel() {
        return baseViewModel;
    }

    @Override
    public void setViewModel(BaseViewModel viewModel) {
        this.baseViewModel = baseViewModel;
    }

    @Override
    protected Object getChildObjForPosition(int groupPosition, int childPosition) {
        return variantGroups.get(groupPosition).getVariations().get(childPosition);
    }

    @Override
    protected Object getParentObjForPosition(int position) {
       return variantGroups.get(position);
    }

    @Override
    protected int getLayoutIdForParentPosition(int position) {
        return parentLayout;
    }

    @Override
    protected int getLayoutIdForChildPosition(int groupPosition, int position) {
        return childLayout;
    }

    @Override
    public void updateList(List list) {
        variantGroups = list;
        notifyDataSetChanged();
    }


    @Override
    public List getParentData() {
        return variantGroups;
    }

    @Override
    public List getChildData(int groupPosition) {

        return variantGroups.get(groupPosition).getVariations();

    }

    @Override
    public void remvoeItemFromList(int position) {

    }

    @Override
    public int getGroupCount() {
        return variantGroups == null ? 0 : variantGroups.size();
    }

    @Override
    public int getChildCount(int groupPosition) {
       return variantGroups.get(groupPosition).getVariations().size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return groupPosition + childPosition;
    }
}
