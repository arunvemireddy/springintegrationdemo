package link.arunv.springintegrationdemo.controller;

import link.arunv.springintegrationdemo.gateway.OrderGateway;
import link.arunv.springintegrationdemo.model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.messaging.Message;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderControllerTest {

    @Mock
    private OrderGateway orderGateway;

    @Mock
    private Message<Order> message;

    @InjectMocks
    private OrderController orderController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testPlaceOrder() {
        Order order = new Order();
        Order responseOrder = new Order();
        when(orderGateway.placeOrder(order)).thenReturn(message);
        when(message.getPayload()).thenReturn(responseOrder);

        Order result = orderController.placeOrder(order);
        assertEquals(responseOrder, result);
        verify(orderGateway).placeOrder(order);
        verify(message).getPayload();
    }
}
