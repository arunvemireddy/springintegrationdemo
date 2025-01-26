package link.arunv.springintegrationdemo.model;

import lombok.Data;

@Data
public class Order {
    private int orderId;
    private String itemName;
    private double price;
    private String orderStatus;
}
