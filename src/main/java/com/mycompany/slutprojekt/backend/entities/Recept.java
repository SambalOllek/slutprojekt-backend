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
public class Recept {

    private int id;
    private String name;
    private String description;
    private String tutorial;

    public Recept(int id,String name, String description,String tutorial) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.tutorial = tutorial;
    }

    public Recept() {
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTutorial() {
        return tutorial;
    }

    public void setTutorial(String tutorial) {
        this.tutorial = tutorial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
