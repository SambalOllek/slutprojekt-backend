/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.slutprojekt.backend.beans;

import com.mycompany.slutprojekt.backend.ConnectionFactory;
import com.mycompany.slutprojekt.backend.entities.Recept;
import com.sun.org.slf4j.internal.LoggerFactory;
import java.lang.System.Logger;
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
public class ReceptBean {
    //int id, String category, String comment, String ingredients, int likings
    public List<Recept> getRecept() {
        List<Recept> recepten = new ArrayList();
        try (Connection connection = ConnectionFactory.getConnection()) {
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM recipe";
            ResultSet data = stmt.executeQuery(sql);
            while (data.next()) {
                Recept recept = new Recept();
                recept.setId(data.getInt("id"));
                recept.setName(data.getString("name"));
                recept.setDescription(data.getString("description"));
                recept.setTutorial(data.getString("tutorial"));
                recepten.add(recept);
                       
            }
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        return recepten;
    }
    public int addRecipe(Recept recepten) {
        try(Connection connection = ConnectionFactory.getConnection()) {
            Statement stmt = connection.createStatement();
            String sql = String.format("INSERT INTO `recipe` (`id`,`name`,`description`,`tutorial`) VALUES (NULL, '%s', '%s','%s')",
            recepten.getName(),recepten.getDescription(),recepten.getTutorial());
            return stmt.executeUpdate(sql);
        } catch(Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return 0;
    }

    public List<Recept> getReceptByCat(int cat) {
        List<Recept> recepten = new ArrayList();
        try(Connection connection = ConnectionFactory.getConnection()) {
            Statement stmt = connection.createStatement();
            String sql = String.format("SELECT * FROM `recipe` WHERE id IN (SELECT category_recipe.recipeid FROM category_recipe WHERE category_recipe.categoryid = %d)",cat);
            ResultSet data = stmt.executeQuery(sql);
            while (data.next()) {
                Recept recept = new Recept();
                recept.setId(data.getInt("id"));
                recept.setName(data.getString("name"));
                recept.setDescription(data.getString("description"));
                recept.setTutorial(data.getString("tutorial"));
                recepten.add(recept);
            }
        } catch (Exception e) {
            System.out.println("Error" +e.getMessage());
        }
        return recepten;
        }
}
