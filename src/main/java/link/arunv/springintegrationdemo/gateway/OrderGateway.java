package link.arunv.springintegrationdemo.gateway;

import link.arunv.springintegrationdemo.model.Order;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.Message;

/**
 * Messaging gateway interface for placing orders.
 * Uses Spring Integration to send {@link Order} objects to the request channel.
 */
@MessagingGateway
public interface OrderGateway {

    /**
     * Sends an {@link Order} to the "request-in-channel".
     *
     * @param order the order to place
     * @return the message containing the order
     */
    @Gateway(requestChannel = "request-in-channel")
    Message<Order> placeOrder(Order order);
}
