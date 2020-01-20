/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;
import entities.OrderLine;
import entities.Order;
import java.util.List;

/**
 *
 * @author Younes
 */
public class OrderDTO {
    private int customerId;
    private int orderId;

    public OrderDTO(Order o) {
        this.orderId = o.getId();
        this.customerId = o.getCustomer().getId();
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}