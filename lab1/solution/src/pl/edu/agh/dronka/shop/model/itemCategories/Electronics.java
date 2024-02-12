package pl.edu.agh.dronka.shop.model.itemCategories;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.filter.ItemSpec;

import java.util.Map;

public class Electronics extends Item {
    private boolean mobile;
    private boolean guarantee;

    public Electronics(String name, Category category, int price, int quantity, boolean mobile, boolean guarantee){
        super(name, category, price, quantity);
        this.mobile = mobile;
        this.guarantee = guarantee;
    }

    @Override
    public void putProperties(Map<String, Object> propertiesMap) {
        propertiesMap.put("Mobilny", mobile);
        propertiesMap.put("Gwarancja", guarantee);
    }

    @Override
    public boolean appliesTo(ItemSpec itemSpec) {
        return (!itemSpec.isMobile() || mobile) && (!itemSpec.isGuarantee() || guarantee);
    }
}
