/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.websen.httprequest_day1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author Menja
 */
@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of
     * eu.websen.httprequest_day1.GenericResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Path("default")
    @Produces(MediaType.APPLICATION_JSON)
    public String getDefault() {
        return "{Json Object}";
    }

    @GET
    @Path("disallow")
    @Produces(MediaType.APPLICATION_JSON)
    public String getDisallowCors() {
        return "{Json Object}";
    }

    @GET
    @Path("allow")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllowedCors() {
        String json = "{}";

        return Response.ok(json)
                .header("Access-Control-Allow-Methods", "*")
                .build();
    }

    @GET
    @Path("proxyCors")
    @Produces(MediaType.APPLICATION_JSON)
    public String getProxyCors() throws Exception {
        URL url = new URL("http://ip.jsontest.com/?alloworigin=false");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("User-Agent", "");

        StringBuilder result = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        String line = "";

        while ((line = br.readLine()) != null) {
            result.append(line);
        }
        return result.toString();
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
