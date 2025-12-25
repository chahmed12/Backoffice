package com.dentist.rest.ressources;

import com.dentist.dao.interfaces.IServiceMedicalLocal;

import com.dentist.entity.ServiceMedical;

import java.util.List;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@RequestScoped
@Path("/services")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ServiceMedicalResource {

    
	@EJB 
	private IServiceMedicalLocal serviceMedical ;
    @GET
    public Response getAll() {
    	List<ServiceMedical> services = serviceMedical.getAllServicesMedical();
        return Response.ok(services).build();
    }

    
    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        ServiceMedical existing = serviceMedical.getServiceMedicalById(id);
        if (existing == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("Service non trouvé").build();
        }
        return Response.ok(existing).build();
    }

    
    @POST
    public Response create(ServiceMedical service) {
        serviceMedical.createServiceMedical(service);
        return Response.status(Response.Status.CREATED).entity(service).build();
    }
}