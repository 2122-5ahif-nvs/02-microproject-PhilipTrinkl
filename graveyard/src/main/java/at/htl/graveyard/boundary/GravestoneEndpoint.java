package at.htl.graveyard.boundary;

import at.htl.graveyard.control.GravestoneRepository;
import at.htl.graveyard.entity.Gravestone;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/Gravestone")
public class GravestoneEndpoint {
    @Inject
    GravestoneRepository gravestoneRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(Gravestone gravestone) {
        Gravestone gravestone1 = gravestoneRepository.save(gravestone);
        return Response
                .status(Response.Status.OK)
                .header("created", gravestone1)
                .build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Transactional
    public Response delete(@PathParam("id") long id) {
        gravestoneRepository.delete(id);
        return Response
                .status(Response.Status.OK)
                .build();
    }

    @PUT
    @Transactional
    public Response update(Gravestone gravestone) {
        Gravestone gravestone1 = new Gravestone();
        gravestone1.setName(gravestone.getName());
        gravestone1.setDateofdeath(gravestone.getDateofdeath());
        gravestone1.setInscription(gravestone.getInscription());
        gravestoneRepository.save(gravestone1);
        return Response
                .status(Response.Status.OK)
                .header("PUT", gravestone1)
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/findAll")
    public Response findAll() {
        final List<Gravestone> gravestoneList =  gravestoneRepository.findAllGravestones();
        return Response
                .status(Response.Status.OK)
                .header("GET", gravestoneList)
                .build();
    }

    @GET
    @Path("/findById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") long id) {
        final Gravestone gravestone = gravestoneRepository.findById(id);
        return Response
                .status(Response.Status.OK)
                .header("GET", gravestone)
                .build();
    }

    @GET
    @Path("/findByName/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByName(@PathParam("name") String name) {
        final Gravestone gravestone = gravestoneRepository.findByName(name);
        return Response
                .status(Response.Status.OK)
                .header("GET", gravestone)
                .build();
    }
}