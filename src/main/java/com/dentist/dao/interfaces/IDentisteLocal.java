package com.dentist.dao.interfaces;

import com.dentist.entity.Dentiste;
import com.dentist.entity.Patient;

//import com.dentist.entity.Rendezvous;

import java.util.List;
import java.util.Optional;

public interface IDentisteLocal {
    Dentiste getDentisteById(Long id);
    List<Dentiste> getAllDentistes();
    void createDentiste(Dentiste dentiste);
    void updateDentiste(Dentiste dentiste);
    void deleteDentiste(Long id);
    public Optional<Dentiste> findByEmail(String email);
    //List<Rendezvous> getRendezvousByDentiste(Long dentisteId);
    //boolean exists(Long id);
}
