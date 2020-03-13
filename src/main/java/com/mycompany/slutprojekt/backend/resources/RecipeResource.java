/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.slutprojekt.backend.resources;

import com.mycompany.slutprojekt.backend.beans.ReceptBean;
import com.mycompany.slutprojekt.backend.entities.Recept;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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
public class RecipeResource {

    @EJB
    ReceptBean recipeBean;

    @GET
    @Path("recipes")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItems() {
        List<Recept> recipes = recipeBean.getRecept();
        if (recipes.isEmpty()) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        return Response.ok(recipes).build();
    }

    @GET
    @Path("recipes/category/{cat}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getItemsByCategory(@PathParam("cat") int cat) {
        List<Recept> recipes = recipeBean.getReceptByCat(cat);
        if (recipes.isEmpty()) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        return Response.ok(recipes).build();
    }

    @POST
    @Path("recipes")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postItems(Recept recipe) {
        int result = recipeBean.addRecipe(recipe);
        if (result == 1) {
            return Response.status(Response.Status.CREATED).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

}
