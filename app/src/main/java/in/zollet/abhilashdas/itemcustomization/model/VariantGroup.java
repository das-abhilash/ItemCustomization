package in.zollet.abhilashdas.itemcustomization.model;

import java.util.List;

/**
 * Created by abhilashdas on 05/07/17.
 */

public class VariantGroup {

    private String group_id;
    private String name;
    private List<Variation> variations = null;

    public String getGroupId() {
        return group_id;
    }

    public void setGroupId(String groupId) {
        this.group_id = groupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Variation> getVariations() {
        return variations;
    }

    public void setVariations(List<Variation> variations) {
        this.variations = variations;
    }

}