package pl.edu.agh.dronka.shop.model.itemCategories;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Genre;
import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.filter.ItemSpec;

import java.util.Map;

public class Music extends Item {
    private boolean video;
    private Genre genre;

    public Music(String name, Category category, int price, int quantity, Genre genre, boolean video){
        super(name, category, price, quantity);
        this.genre = genre;
        this.video = video;
    }

    @Override
    public void putProperties(Map<String, Object> propertiesMap) {
        propertiesMap.put("Gatunek muzyczny", genre);
        propertiesMap.put("Dołączone video", video);
    }

    @Override
    public boolean appliesTo(ItemSpec itemSpec) {
        return !itemSpec.isVideo() || video;
    }
}