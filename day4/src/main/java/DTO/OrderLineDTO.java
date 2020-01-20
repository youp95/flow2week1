/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;
import entities.ItemType;
import entities.OrderLine;

/**
 *
 * @author Younes
 */
public class OrderLineDTO {
    private int id;
    private int qty;
    private ItemType itemType;
    private String item;

    public OrderLineDTO(OrderLine o) {
        this.id = o.getId();
        this.qty = o.getQty();
        this.itemType = o.getItemType();
    }
    public OrderLineDTO(int qty, String item) {
        this.qty = qty;
        this.item = item;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
    
}