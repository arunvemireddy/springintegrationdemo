package link.arunv.springintegrationdemo.gateway;

import link.arunv.springintegrationdemo.model.Order;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

@MessagingGateway
public interface OrderGateway {

    @Gateway(requestChannel = "request-in-channel")
    public Message<Order> placeOrder(Order order);
}
