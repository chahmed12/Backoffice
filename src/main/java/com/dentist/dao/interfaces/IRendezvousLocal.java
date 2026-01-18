package com.dentist.dao.interfaces;

import com.dentist.entity.Rendezvous;

import jakarta.ejb.Local;

//import java.time.LocalDate;
//import java.time.LocalDateTime;
import java.util.List;

@Local
public interface IRendezvousLocal{

    
    Rendezvous getRendezvousById(Long id);
    List<Rendezvous> getAllRendezvous();
    void createRendezvous(Rendezvous rendezvous);
    void updateRendezvous(Rendezvous rendezvous);
    void deleteRendezvous(Long id);


}
