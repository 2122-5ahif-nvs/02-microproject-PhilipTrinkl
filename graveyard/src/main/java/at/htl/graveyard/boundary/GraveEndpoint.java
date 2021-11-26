package at.htl.graveyard.boundary;

import at.htl.graveyard.control.GraveRepository;
import at.htl.graveyard.entity.Grave;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/Grave")
public class GraveEndpoint {
    @Inject
    GraveRepository graveRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(Grave grave) {
        Grave grave1 = graveRepository.save(grave);
        return Response
                .status(Response.Status.OK)
                .header("created", grave1)
                .build();
    }

    @DELETE
    @Path("delete/{id}")
    @Transactional
    public Response delete(@PathParam("id") long id) {
        graveRepository.delete(id);
        return Response
                .status(Response.Status.OK)
                .build();
    }

    @PUT
    @Transactional
    @Path("/put")
    public Response update(Grave grave) {
        Grave grave1 = new Grave();
        grave1.setSection(grave.getSection());
        grave1.setRented(grave.isRented());
        grave1.setBeginrent(grave.getBeginrent());
        grave1.setEndrent(grave.getEndrent());
        return Response
                .status(Response.Status.OK)
                .header("PUT", grave1)
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/findAll")
    public Response findAll() {
        final List<Grave> graveList =  graveRepository.findAllGraves();
        return Response
                .status(Response.Status.OK)
                .header("GET", graveList)
                .build();
    }

    @GET
    @Path("/findById/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") long id) {
        final Grave grave = graveRepository.findById(id);
        return Response
                .status(Response.Status.OK)
                .header("GET", grave)
                .build();
    }

}
