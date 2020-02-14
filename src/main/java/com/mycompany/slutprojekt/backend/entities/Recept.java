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
    private String category;
    private String comment;
    private String ingredients;
    private int likings;

    public Recept(int id, String category, String comment, String ingredients, int likings) {
        this.id = id;
        this.category = category;
        this.comment = comment;
        this.ingredients = ingredients;
        this.likings = likings;
    }

    public Recept() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public int getLikings() {
        return likings;
    }

    public void setLikings(int likings) {
        this.likings = likings;
    }
}
