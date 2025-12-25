package com.dentist.rest.ressources;


import com.dentist.dao.interfaces.IPatientLocal;

import com.dentist.entity.Patient;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@RequestScoped
@Path("/patients")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PatientResource {

    @EJB
    private IPatientLocal patientService ;

    @GET
    public Response getAll() {
        List<Patient> patients = patientService.getAllPatients();
        return Response.ok(patients).build();
    }

    @GET
    @Path("/{id}")
    public Response getById(@PathParam("id") Long id) {
        Patient p = patientService.getPatientById(id);
        if (p == null) {
            return Response.status(Response.Status.NOT_FOUND)
                .entity("{\"message\": \"Patient non trouvé\"}")
                .build();
        }
        return Response.ok(p).build();
    }

    @POST
    public Response create(Patient patient) {
        patientService.createPatient(patient);
        return Response.status(Response.Status.CREATED).entity(patient).build();
    }
}
    
    
