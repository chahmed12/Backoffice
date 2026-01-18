package com.dentist.rest.ressources;

import com.dentist.dao.interfaces.IDentisteLocal;
import com.dentist.dao.interfaces.IPatientLocal;
import com.dentist.entity.Dentiste;
import com.dentist.entity.Patient;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.Optional;

@RequestScoped
@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthResource {

    @EJB
    private IPatientLocal patientService;

    @EJB
    private IDentisteLocal dentisteService;

    
    public static class LoginRequest {
        public String email;
        public String motDePasse;
    }


    @POST
    @Path("/login")
    public Response login(LoginRequest req) {
        if (req == null || req.email == null || req.motDePasse == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"message\":\"Email et mot de passe requis\"}").build();
        }

       
        Optional<Patient> optPatient = patientService.findByEmail(req.email);
        if (optPatient.isPresent() && req.motDePasse.equals(optPatient.get().getMdpP())) {
             Patient p = optPatient.get();
             
             return Response.ok("{\"id\":" + p.getIdP() + 
                                ", \"role\":\"PATIENT\"" +
                                ", \"nom\":\"" + p.getNomP() + "\"" +
                                ", \"prenom\":\"" + p.getPrenomP() + "\"}").build();
        }


        Optional<Dentiste> optDentiste = dentisteService.findByEmail(req.email);
        if (optDentiste.isPresent() && req.motDePasse.equals(optDentiste.get().getMdpD())) {
             Dentiste d = optDentiste.get();
             return Response.ok("{\"id\":" + d.getIdD() + 
                                ", \"role\":\"DENTISTE\"" +
                                ", \"nom\":\"" + d.getNomD() + "\"" +
                                ", \"prenom\":\"" + d.getPrenomD() + "\"}").build();
        }

        return Response.status(Response.Status.UNAUTHORIZED)
                .entity("{\"message\":\"Identifiants incorrects\"}").build();
    }


    @POST
    @Path("/register/patient")
    public Response registerPatient(Patient patient) { 

        
        if (patient == null || patient.getEmailP() == null || patient.getMdpP() == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"message\":\"Email et mot de passe obligatoires\"}").build();
        }

       
        if (patientService.findByEmail(patient.getEmailP()).isPresent()) {
            return Response.status(Response.Status.CONFLICT)
                    .entity("{\"message\":\"Email déjà utilisé\"}").build();
        }


        patientService.createPatient(patient);

        return Response.status(Response.Status.CREATED)
                .entity("{\"message\":\"Patient créé avec succès\"}").build();
    }

    @POST
    @Path("/register/dentiste")
    public Response registerDentiste(Dentiste dentiste) {
        
        if (dentiste == null || dentiste.getEmailD() == null || dentiste.getMdpD() == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        if (dentisteService.findByEmail(dentiste.getEmailD()).isPresent()) {
             return Response.status(Response.Status.CONFLICT).entity("{\"message\":\"Email déjà utilisé\"}").build();
        }

        dentisteService.createDentiste(dentiste);

        return Response.status(Response.Status.CREATED)
                .entity("{\"message\":\"Compte professionnel créé\"}").build();
    }
}