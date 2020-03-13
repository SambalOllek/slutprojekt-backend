/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.slutprojekt.backend.beans;

import com.mycompany.slutprojekt.backend.ConnectionFactory;
import com.mycompany.slutprojekt.backend.entities.Ingredients;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author TE4
 */
@Stateless
public class IngredientsBean {
    public List<Ingredients> getIngredients() {
        List<Ingredients> ingredients = new ArrayList();
        try (Connection connection = ConnectionFactory.getConnection()){
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM ingredients";
            ResultSet data = stmt.executeQuery(sql);
            while (data.next()) {
                Ingredients ingredient = new Ingredients();
                ingredient.setId(data.getInt("id"));
                ingredient.setName(data.getString("name"));
                ingredient.setAmount(data.getString("amount"));
                ingredients.add(ingredient);
            }
        } catch (Exception e) {
            System.out.println("Error" +e.getMessage());
        }
        return ingredients;
    }


public static int RecipeIngredients(List<Ingredients> ingredients, int recipeId) {
    try(Connection connection = ConnectionFactory.getConnection()) {
        for (Ingredients ingredient : ingredients) {
            String sql = "INSERT INTO recipe_ingredients VALUES (?,?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, recipeId);
            stmt.setInt(2, ingredient.getId());
            stmt.executeUpdate();
        }
        return 1;
    } catch (Exception e) {
        System.out.println("Error" + e.getMessage());
    }
return 0;
}

}

