/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.slutprojekt.backend.resources;

import com.mycompany.slutprojekt.backend.beans.OauthBean;
import javax.ejb.EJB;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author TE4
 */
@Path("")
public class OathResponse {
    
    @EJB
    OauthBean oauthBean;
    
    //SKAPA TOKEN
    @GET
    @Path("token")
    @Produces (MediaType.TEXT_PLAIN)
    public Response getToken(@QueryParam("code") String code) {
        return Response.ok(oauthBean.getToken(code)).build();
    }
    
    //REST TJÄNST
    @GET
    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEvents(@QueryParam("token") String token) {
        return Response.ok(oauthBean.githubAuth(token)).build();
    }
    
    public JsonObject githubAuth(String token) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("https://api.github.com/user?access_token=" + token);
        return target.request(MediaType.APPLICATION_JSON).get(JsonObject.class);
    }
}
