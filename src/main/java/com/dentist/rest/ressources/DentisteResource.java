package com.dentist.rest.ressources;

import com.dentist.dao.interfaces.IDentisteLocal;

import com.dentist.entity.Dentiste;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;


@RequestScoped
@Path("/dentistes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DentisteResource {

    @EJB
    private IDentisteLocal dentisteService;

    
    @GET
    public Response getAll() {
        List<Dentiste> dentistes = dentisteService.getAllDentistes();
        return Response.ok(dentistes).build();
    }

    
    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        Dentiste dentiste = dentisteService.getDentisteById(id);
        if (dentiste == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"message\":\"Dentiste non trouvé\"}")
                    .build();
        }
        return Response.ok(dentiste).build();
    }

    
    @POST
    public Response create(Dentiste dentiste) {
        dentisteService.createDentiste(dentiste);
        return Response.status(Response.Status.CREATED).entity(dentiste).build();
    }

    
    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, Dentiste updatedDentiste) {
        Dentiste existing = dentisteService.getDentisteById(id);
        if (existing == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"message\":\"Dentiste à mettre à jour non trouvé\"}")
                    .build();
        }
        updatedDentiste.setIdD(id);
        dentisteService.updateDentiste(updatedDentiste);
        return Response.ok(updatedDentiste).build();
    }

    
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        Dentiste existing = dentisteService.getDentisteById(id);
        if (existing == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("{\"message\":\"Dentiste à supprimer non trouvé\"}")
                    .build();
        }
        dentisteService.deleteDentiste(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
