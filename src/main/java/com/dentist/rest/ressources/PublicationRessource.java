package com.dentist.rest.ressources;
import com.dentist.entity.Publication;
import com.dentist.dao.interfaces.IPublicationLocal;
import jakarta.ejb.EJB;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/publications")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PublicationRessource {
    @EJB
    private IPublicationLocal publicationService;
    @GET
    public List<Publication> getAllPublications() {
        return publicationService.findAllPublications();
    }
    @GET
    @Path("/{id}")
    public Response getPublication(@PathParam("id") Long id) {
        Publication pub = publicationService.findPublicationById(id);
        if (pub != null) {
            return Response.ok(pub).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    @POST
    public Response createPublication(Publication publication) {
        try {
            Publication newPub = publicationService.createPublication(publication);
            return Response.status(Response.Status.CREATED).entity(newPub).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("{\"error\":\"Erreur lors de la création\"}").build();
        }
    }
    @DELETE
    @Path("/{id}")
    public Response deletePublication(@PathParam("id") Long id) {
        publicationService.deletePublication(id);
        return Response.noContent().build();
    }
}