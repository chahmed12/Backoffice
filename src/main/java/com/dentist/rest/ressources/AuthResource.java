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

    // ==========================================
    // DTOs (Data Transfer Objects)
    // ==========================================

    public static class LoginRequest {
        public String email;
        public String motDePasse;
    }

    public static class RegisterPatientRequest {
        public String nom;
        public String prenom;
        public String email;
        public String dateNaissance; // "yyyy-MM-dd"
        public String groupeSanguin;
        public String sexe;
        public String motDePasse;
        public String recouvrementSocial; 
    }

    public static class RegisterDentistRequest {
        public String nom;
        public String prenom;
        public String email;
        public String telephone;
        public String specialite;
        public String sexe;
        public String motDePasse;
    }

    public static class AuthResponse {
        public Long id;
        public String email;
        public String role;
        public String nom;
        public String prenom;

        // Constructeur corrigé : suppression du paramètre 'token' inutile
        public AuthResponse(Long id, String email, String role, String nom, String prenom) {
            this.id = id;
            this.email = email;
            this.role = role;
            this.nom = nom;
            this.prenom = prenom;
        }
    }

    // ==========================================
    // Endpoints
    // ==========================================

    @POST
    @Path("/login")
    public Response login(LoginRequest req) {
        if (req == null || req.email == null || req.motDePasse == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"message\":\"Email et mot de passe requis\"}").build();
        }

        // 1. Vérification Patient
        Optional<Patient> optPatient = patientService.findByEmail(req.email);
        if (optPatient.isPresent()) {
            Patient p = optPatient.get();
            // Comparaison simple (SANS HACHAGE)
            if (req.motDePasse.equals(p.getMdpP())) { 
                // Appel corrigé : plus de token
                return Response.ok(new AuthResponse(p.getIdP(), p.getEmailP(), "PATIENT", p.getNomP(), p.getPrenomP())).build();
            }
        }

        // 2. Vérification Dentiste
        Optional<Dentiste> optDentiste = dentisteService.findByEmail(req.email);
        if (optDentiste.isPresent()) {
            Dentiste d = optDentiste.get();
            // Comparaison simple (SANS HACHAGE)
            if (req.motDePasse.equals(d.getMdpD())) { 
                // Appel corrigé : plus de token
                return Response.ok(new AuthResponse(d.getIdD(), d.getEmailD(), "DENTISTE", d.getNomD(), d.getPrenomD())).build();
            }
        }

        return Response.status(Response.Status.UNAUTHORIZED)
                .entity("{\"message\":\"Identifiants incorrects\"}").build();
    }

    @POST
    @Path("/register/patient")
    public Response registerPatient(RegisterPatientRequest req) {
        if (req == null || req.email == null || req.motDePasse == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("{\"message\":\"Données manquantes\"}").build();
        }

        if (patientService.findByEmail(req.email).isPresent()) {
            return Response.status(Response.Status.CONFLICT).entity("{\"message\":\"Email déjà utilisé\"}").build();
        }

        Patient p = new Patient();
        p.setNomP(req.nom);
        p.setPrenomP(req.prenom);
        p.setEmailP(req.email);
        
        if(req.dateNaissance != null && !req.dateNaissance.isEmpty()) {
             try {
                p.setDateNP(java.time.LocalDate.parse(req.dateNaissance));
             } catch (Exception e) {
                 // Gérer l'erreur de date si nécessaire
             }
        }
        p.setGroupSanguinP(req.groupeSanguin);
        p.setSexeP(req.sexe);
        p.setRecouvrementP(req.recouvrementSocial);
        p.setMdpP(req.motDePasse);

        patientService.createPatient(p);

        return Response.status(Response.Status.CREATED)
                .entity("{\"message\":\"Patient créé avec succès\"}").build();
    }

    @POST
    @Path("/register/dentiste")
    public Response registerDentiste(RegisterDentistRequest req) {
        if (req == null || req.email == null || req.motDePasse == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("{\"message\":\"Données manquantes\"}").build();
        }

        if (dentisteService.findByEmail(req.email).isPresent()) {
             return Response.status(Response.Status.CONFLICT).entity("{\"message\":\"Email déjà utilisé\"}").build();
        }

        Dentiste d = new Dentiste();
        d.setNomD(req.nom);
        d.setPrenomD(req.prenom);
        d.setEmailD(req.email);
        d.setTelD(req.telephone);
        d.setSpecialiteD(req.specialite);
        d.setMdpD(req.motDePasse);

        dentisteService.createDentiste(d);

        return Response.status(Response.Status.CREATED)
                .entity("{\"message\":\"Compte professionnel créé avec succès\"}").build();
    }
}