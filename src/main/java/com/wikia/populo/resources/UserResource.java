package com.wikia.populo.resources;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import com.wikia.populo.core.User;
import javax.ws.rs.core.MediaType;
import static javax.ws.rs.core.Response.*;
import com.wikia.populo.jdbi.UserDAO;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    private final UserDAO userDAO;

    public UserResource(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GET
    @Path("/{name}")
    public Response show(@PathParam("name") String name) {
        User user = userDAO.findByName(name);
        if (user == null) {
            return Response.status(Status.NOT_FOUND).build();
        }
        return Response.status(Status.OK).entity(user).build();
    }
}