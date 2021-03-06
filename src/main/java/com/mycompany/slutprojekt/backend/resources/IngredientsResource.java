/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.slutprojekt.backend.resources;

import com.mycompany.slutprojekt.backend.beans.IngredientsBean;
import com.mycompany.slutprojekt.backend.entities.Ingredients;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
/**
 *
 * @author TE4
 */
@Path("")
public class IngredientsResource {
    
    @EJB
    IngredientsBean ingredientsBean;
    
    @GET
    @Path("ingredients")
    @Produces (MediaType.APPLICATION_JSON)
    public Response getItems() {
        List<Ingredients> ingredients = ingredientsBean.getIngredients();
        if(ingredients.isEmpty()) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        return Response.ok(ingredients).build();
    }
    
}
