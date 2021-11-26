package at.htl.graveyard.boundary;

import at.htl.graveyard.control.GraveyardRepository;
import at.htl.graveyard.entity.Graveyard;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("Graveyard")
public class GraveyardEndpoint {
    @Inject
    GraveyardRepository graveyardRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(Graveyard graveyard) {
        Graveyard graveyard1 = graveyardRepository.save(graveyard);
        return Response
                .status(Response.Status.OK)
                .header("created", graveyard)
                .build();
    }

    @DELETE
    @Path("delete/{id}")
    @Transactional
    public Response delete(@PathParam("id") long id) {
        graveyardRepository.delete(id);
        return Response
                .status(Response.Status.OK)
                .build();
    }

    @PUT
    @Transactional
    public Response update(Graveyard graveyard) {
        Graveyard graveyard1 = new Graveyard();
        graveyard1.setName(graveyard.getName());
        graveyard1.setAddress(graveyard.getAddress());
        graveyardRepository.save(graveyard1);
        return Response
                .status(Response.Status.OK)
                .header("PUT", graveyard1)
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/findAll")
    public Response findAll() {
        final List<Graveyard> graveyardList =  graveyardRepository.findAllGraveyards();
        return Response
                .status(Response.Status.OK)
                .header("GET", graveyardList)
                .build();
    }

    @GET
    @Path("/findById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") long id) {
        final Graveyard graveyard = graveyardRepository.findById(id);
        return Response
                .status(Response.Status.OK)
                .header("GET", graveyard)
                .build();
    }

    @GET
    @Path("/findByName/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByName(@PathParam("name") String name) {
        final Graveyard graveyard = graveyardRepository.findByName(name);
        return Response
                .status(Response.Status.OK)
                .header("GET", graveyard)
                .build();
    }

}
