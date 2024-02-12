package pl.edu.agh.internetshop;

import java.util.ArrayList;
import java.util.List;

public class CompositeSearchStrategy implements SearchStrategy{
    List<SearchStrategy> strategies;

    public CompositeSearchStrategy() {
        strategies = new ArrayList<>();
    }


    @Override
    public boolean filter(OrderLog log) {
        for(SearchStrategy strategy: strategies){
            if(!strategy.filter(log)) return false;
        }
        return true;
    }

    public void addStrategy(SearchStrategy strategy){
        strategies.add(strategy);
    }
}
