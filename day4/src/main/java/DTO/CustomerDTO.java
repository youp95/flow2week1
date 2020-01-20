  
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Customer;

/**
 *
 * @author Younes
 */
public class CustomerDTO {
    private int id;
    private String name;
    private String email;

    public CustomerDTO(Customer c) {
        this.name = c.getName();
        this.email = c.getEmail();
        this.id = c.getId();
    }
    public CustomerDTO(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}