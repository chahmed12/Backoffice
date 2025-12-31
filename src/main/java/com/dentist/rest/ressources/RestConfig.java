package com.dentist.rest.ressources;

import java.util.HashSet;
import java.util.Set;

import jakarta.enterprise.context.RequestScoped;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;




@ApplicationPath("/api")
public class RestConfig extends Application {
    
    
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        
        // --- Ressources de l'application ---
        resources.add(ActeMedicalResource.class);
        resources.add(DentisteResource.class);
        resources.add(PatientResource.class);
        resources.add(RendezvousResource.class);
        resources.add(ServiceMedicalResource.class);
        resources.add(AuthResource.class);
        resources.add(PublicationRessource.class);
        

       
        
        return resources;
    }
}