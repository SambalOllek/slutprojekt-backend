/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.slutprojekt.backend.beans;

import com.mycompany.slutprojekt.backend.ConnectionFactory;
import com.mycompany.slutprojekt.backend.entities.Category;
import java.sql.Connection;
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
public class CategoryBean {
    public List<Category> getCategory() {
        List<Category> categories = new ArrayList();
 
    try (Connection connection = ConnectionFactory.getConnection()) {
    Statement stmt = connection.createStatement();
    String sql = "Select * FROM category";
    ResultSet data = stmt.executeQuery(sql);
    while (data.next()) {
        Category category = new Category();
        category.setId(data.getInt("id"));
        category.setName(data.getString("name"));
    }
} catch (Exception e) {
            System.out.println("Error" + e.getMessage());
}
return categories;
}
}