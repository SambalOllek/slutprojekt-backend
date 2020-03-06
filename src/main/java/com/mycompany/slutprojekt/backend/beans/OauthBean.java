/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.slutprojekt.backend.beans;

import javax.ejb.Stateless;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author TE4
 */
@Stateless
public class OauthBean {

    private final String CLIENT_ID = "c292a6020ce35b214c2e";
    private final String CLIENTSECRET = "8b08695e8baa7d38e97aa037fde017b6d2c9c0ee";

    public String getToken(String code) {
        String url = String.format("https://github.com/login/oauth/access_token?client_id=%s&client_secret=%s&code=%s", CLIENT_ID, CLIENTSECRET, code);

        Client client = ClientBuilder.newClient();
        String result = client.target(url).request().post(null, String.class);  
            return result.substring(13,result.indexOf("&"));
    }


    public JsonObject githubAuth(String token) {
        Client client = ClientBuilder.newClient();
        System.out.println(token);
        //token = "beb590eed8c7e055301e195e1771f6753e217e4f";
        System.out.println(token);
        WebTarget target = client.target("https://api.github.com/user?access_token=" + token);
        return target.request(MediaType.APPLICATION_JSON).get(JsonObject.class);
    }

}
