package com.dentist.rest.ressources;


import com.dentist.dao.interfaces.IActeMedicalLocal;
import com.dentist.dao.interfaces.IRendezvousLocal;
import com.dentist.entity.ActeMedical;
import com.dentist.entity.Rendezvous;

import java.util.List;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@RequestScoped
@Path("/rendezvous")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RendezvousResource {

    @EJB
    private IRendezvousLocal rendezvousService;

    @EJB
    private IActeMedicalLocal acteService;
   
    @GET
    public Response getAll() {
	   List<Rendezvous> rendezvousList = rendezvousService.getAllRendezvous();
        return Response.ok(rendezvousList).build();
    }

   
    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
    	Rendezvous r = rendezvousService.getRendezvousById(id);
    	if(r == null) {
    		return Response.status(Response.Status.NOT_FOUND).entity("{\"message\": \"Rendezvou non trouvé\"}").build();
     	}
    	return Response.ok(r).build();
    }

    
    @POST
    public Response create(Rendezvous rendezvous) {
    	rendezvousService.createRendezvous(rendezvous);
        return Response.status(Response.Status.CREATED).entity(rendezvous).build();
    }

    
    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        Rendezvous existing  = rendezvousService.getRendezvousById(id);
        if(existing == null) {
        	return Response.status(Response.Status.NOT_FOUND).entity("Rendez-vous à supprimer non trouvé").build();
        }
        rendezvousService.deleteRendezvous(id);
        return Response.status(Response.Status.NO_CONTENT).build();   
    }
    
    @GET
    @Path("/{id}/actes")
    public Response getActesByRendezvous(@PathParam("id") Long idRv) {

        List<ActeMedical> actes = acteService.getActesByRendezvousId(idRv);
        return Response.ok(actes).build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Rendezvous rdvRecu) {
        
        if (rdvRecu.getIdRv() == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("ID manquant").build();
        }

        
        Rendezvous rdvExistant = rendezvousService.getRendezvousById(rdvRecu.getIdRv());
        
        if (rdvExistant == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }


        rdvExistant.setStatutRv(rdvRecu.getStatutRv());
        

        rendezvousService.updateRendezvous(rdvExistant);

        return Response.ok(rdvExistant).build();
    }
}