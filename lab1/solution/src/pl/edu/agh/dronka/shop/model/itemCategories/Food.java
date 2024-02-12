package pl.edu.agh.dronka.shop.model.itemCategories;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class Food extends Item {
    private Date expirationDate;
    private String stringDate;
    public static SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

    public Food(String name, Category category, int price, int quantity, String expirationDate){
        super(name, category, price, quantity);
        stringDate = expirationDate;
        try {
            this.expirationDate = convertToDate(expirationDate);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date");
        }
    }

    private Date convertToDate(String string) throws ParseException {
        return formatter.parse(string);
    }

    @Override
    public void putProperties(Map<String, Object> propertiesMap) {
        propertiesMap.put("Data przydatności do spożycia", stringDate);
    }
}
