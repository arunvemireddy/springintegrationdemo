package link.arunv.springintegrationdemo.controller;

import link.arunv.springintegrationdemo.gateway.OrderGateway;
import link.arunv.springintegrationdemo.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for handling order placement requests.
 */
@RestController
public class OrderController {

    /**
     * Gateway for sending orders to the integration flow.
     */
    @Autowired
    public OrderGateway orderGateway;

    /**
     * Places an order by sending it through the integration gateway.
     *
     * @param order the order to be placed
     * @return the response order after processing
     */
    @PostMapping("placeOrder")
    public Order placeOrder(@RequestBody Order order){
        Message<Order> replyObj = orderGateway.placeOrder(order);
        Order response = replyObj.getPayload();
        return response;
    }
}
