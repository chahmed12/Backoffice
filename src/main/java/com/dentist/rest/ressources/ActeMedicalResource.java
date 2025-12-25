package com.dentist.rest.ressources;

import java.util.List;


import com.dentist.dao.interfaces.IActeMedicalLocal;
import com.dentist.entity.ActeMedical;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@RequestScoped
@Path("/actes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ActeMedicalResource {
    
	
	
	@EJB 
	private IActeMedicalLocal acteMedicalService  ;
	
    @GET
    public Response getAll() {
    	List<ActeMedical> actes = acteMedicalService.getAllActesMedicals();
        return Response.ok(actes).build();
    }

    
    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        ActeMedical acte = acteMedicalService.getActeMedicalById(id);
        if (acte == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("{\"message\":\"Acte médical non trouvé\"}").build();
        }
        return Response.ok(acte).build();
    }

    
    @POST
    public Response create(ActeMedical acte) {
    	acteMedicalService.createActeMedical(acte);
        return Response.status(Response.Status.CREATED).entity(acte).build();
    }
}