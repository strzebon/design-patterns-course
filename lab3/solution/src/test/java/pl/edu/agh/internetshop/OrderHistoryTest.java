package pl.edu.agh.internetshop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class OrderHistoryTest {

    @Test
    public void TestOrderHistoryFilter(){
        SearchStrategy strategy = mock(SearchStrategy.class);

        OrderLog log1 = mock(OrderLog.class);
        OrderLog log2 = mock(OrderLog.class);
        OrderLog log3 = mock(OrderLog.class);

        given(strategy.filter(log1)).willReturn(true);
        given(strategy.filter(log2)).willReturn(false);
        given(strategy.filter(log3)).willReturn(true);

        OrderHistory history = new OrderHistory(strategy);

        history.addLog(log1);
        history.addLog(log2);
        history.addLog(log3);


        List<OrderLog> got = history.filter();

        assertEquals(2, got.size());
        assertEquals(log1, got.get(0));
        assertEquals(log3, got.get(1));
    }
}
