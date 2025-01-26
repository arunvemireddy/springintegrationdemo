package link.arunv.springintegrationdemo.controller;

import link.arunv.springintegrationdemo.gateway.OrderGateway;
import link.arunv.springintegrationdemo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    public OrderGateway orderGateway;

    @PostMapping("placeOrder")
    public Order placeOrder(@RequestBody Order order){
        Message<Order> replyObj = orderGateway.placeOrder(order);
        Order response = replyObj.getPayload();
        return response;
    }
}
