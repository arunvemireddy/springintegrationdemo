package link.arunv.springintegrationdemo.service;

import link.arunv.springintegrationdemo.gateway.OrderGateway;
import link.arunv.springintegrationdemo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @ServiceActivator(inputChannel="request-in-channel",outputChannel = "order-process-channel")
    public Message<Order> placeOrder(Message<Order> order){
        return order;
    }

    @ServiceActivator(inputChannel="order-process-channel",outputChannel = "order-reply-channel")
    public Message<Order> processOrder(Message<Order> order){
        order.getPayload().setOrderStatus("Order successfully placed");
        return order;
    }

    @ServiceActivator(inputChannel="order-reply-channel")
    public void replyOrder(Message<Order> order){
        MessageChannel replyChannel = (MessageChannel) order.getHeaders().getReplyChannel();
        replyChannel.send(order);
    }
}
