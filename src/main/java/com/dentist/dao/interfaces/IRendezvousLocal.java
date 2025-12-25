package com.dentist.dao.interfaces;

import com.dentist.entity.Rendezvous;

//import java.time.LocalDate;
//import java.time.LocalDateTime;
import java.util.List;

public interface IRendezvousLocal{

    // CRUD de base
    Rendezvous getRendezvousById(Long id);
    List<Rendezvous> getAllRendezvous();
    void createRendezvous(Rendezvous rendezvous);
    void updateRendezvous(Rendezvous rendezvous);
    void deleteRendezvous(Long id);

    // Méthodes métier
    //List<Rendezvous> getRendezvousByPatient(Long patientId);
    //List<Rendezvous> getRendezvousByDentiste(Long dentisteId);
    //List<Rendezvous> getRendezvousByDate(LocalDate date);
    //boolean isSlotAvailable(Long dentisteId, LocalDateTime dateHeure);
}
