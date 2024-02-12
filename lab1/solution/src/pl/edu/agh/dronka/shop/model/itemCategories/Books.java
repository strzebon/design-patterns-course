package pl.edu.agh.dronka.shop.model.itemCategories;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.filter.ItemSpec;

import java.util.Map;

public class Books extends Item {
    private int pages;
    private boolean hardcover;

    public Books(String name, Category category, int price, int quantity, int pages, boolean hardcover){
        super(name, category, price, quantity);
        this.pages = pages;
        this.hardcover = hardcover;
    }

    @Override
    public void putProperties(Map<String, Object> propertiesMap) {
        propertiesMap.put("Liczba stron", pages);
        propertiesMap.put("Twarda oprawa", hardcover);
    }

    @Override
    public boolean appliesTo(ItemSpec itemSpec) {
        return !itemSpec.isHardcover() || hardcover;
    }
}
