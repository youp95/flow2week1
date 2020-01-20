/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Customer;
import entities.ItemType;

/**
 *
 * @author Younes
 */
public class ItemTypeDTO {
    private int id;
    private String name;
    private String desc;
    private String price;

    public ItemTypeDTO(ItemType item) {
        this.id = item.getId();
        this.name = item.getName();
        this.desc = item.getDesc();
        this.price = item.getPrice();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}