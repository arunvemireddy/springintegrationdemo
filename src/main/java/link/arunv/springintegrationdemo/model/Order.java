package link.arunv.springintegrationdemo.model;

import lombok.Data;

/**
 * Represents an order in the system.
 */
@Data
public class Order {
    /**
     * Unique identifier for the order.
     */
    private int orderId;

    /**
     * Name of the item ordered.
     */
    private String itemName;

    /**
     * Price of the item.
     */
    private double price;

    /**
     * Status of the order.
     */
    private String orderStatus;
}
