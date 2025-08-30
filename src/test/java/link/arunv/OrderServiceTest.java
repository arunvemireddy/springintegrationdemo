package link.arunv;
import link.arunv.springintegrationdemo.model.Order;
import link.arunv.springintegrationdemo.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderServiceTest {

    private OrderService orderService;

    @BeforeEach
    void setUp() {
        orderService = new OrderService();
    }

    @Test
    void testPlaceOrderReturnsSameMessage() {
        Order order = new Order();
        Message<Order> message = MessageBuilder.withPayload(order).build();

        Message<Order> result = orderService.placeOrder(message);

        assertSame(message, result);
    }

    @Test
    void testProcessOrderSetsOrderStatus() {
        Order order = new Order();
        Message<Order> message = MessageBuilder.withPayload(order).build();

        Message<Order> result = orderService.processOrder(message);

        assertEquals("Order successfully placed", result.getPayload().getOrderStatus());
    }

    @Test
    void testReplyOrderSendsMessageToReplyChannel() {
        Order order = new Order();
        MessageChannel replyChannel = mock(MessageChannel.class);
        Message<Order> message = MessageBuilder.withPayload(order)
                .setReplyChannel(replyChannel)
                .build();

        orderService.replyOrder(message);

        verify(replyChannel, times(1)).send(message);
    }
}