package in.zollet.abhilashdas.itemcustomization.model;

import java.util.List;

/**
 * Created by abhilashdas on 05/07/17.
 */

public class Variants {

    private List<VariantGroup> variant_groups = null;
    private List<List<ExcludeList>> exclude_list = null;

    public List<VariantGroup> getVariantGroups() {
        return variant_groups;
    }

    public void setVariantGroups(List<VariantGroup> variantGroups) {
        this.variant_groups = variantGroups;
    }

    public List<List<ExcludeList>> getExcludeList() {
        return exclude_list;
    }

    public void setExcludeList(List<List<ExcludeList>> excludeList) {
        this.exclude_list = excludeList;
    }

}