package com.dentist.dao.interfaces;

import com.dentist.entity.Dentiste;
import com.dentist.entity.Patient;

import jakarta.ejb.Local;

//import com.dentist.entity.Rendezvous;

import java.util.List;
import java.util.Optional;

@Local
public interface IDentisteLocal {
    Dentiste getDentisteById(Long id);
    List<Dentiste> getAllDentistes();
    void createDentiste(Dentiste dentiste);
    void updateDentiste(Dentiste dentiste);
    void deleteDentiste(Long id);
    public Optional<Dentiste> findByEmail(String email);
    
}
