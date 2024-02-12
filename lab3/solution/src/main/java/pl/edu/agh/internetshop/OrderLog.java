package pl.edu.agh.internetshop;

import java.util.Date;

public class OrderLog {

    final Order order;
    final Date date;

    public OrderLog (Order order){
        this.order = order;
        this.date = new Date();
    }



}
