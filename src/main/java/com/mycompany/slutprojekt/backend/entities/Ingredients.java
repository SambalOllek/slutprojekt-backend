/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.slutprojekt.backend.entities;

/**
 *
 * @author TE4
 */
public class Ingredients {
    private int id;
    private String name;
    private String amount;

    public Ingredients(int id, String name, String amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    public Ingredients() {
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
    
    
}
