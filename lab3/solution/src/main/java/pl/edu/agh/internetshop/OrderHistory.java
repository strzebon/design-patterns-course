package pl.edu.agh.internetshop;

import java.util.ArrayList;
import java.util.List;

public class OrderHistory {
    private final List<OrderLog> logs;
    private SearchStrategy strategy;

    public OrderHistory(SearchStrategy strategy){
        this.logs = new ArrayList<>();
        this.strategy = strategy;
    }

    public List<OrderLog> getLogs() {
        return logs;
    }

    public SearchStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(SearchStrategy strategy) {
        this.strategy = strategy;
    }

    public void addLog(OrderLog log){
        logs.add(log);
    }

    public List<OrderLog> filter(){
        List<OrderLog> filtered = new ArrayList<>();
        for(OrderLog log: logs){
            if(strategy.filter(log)){
                filtered.add(log);
            }
        }
        return filtered;
    }
}
