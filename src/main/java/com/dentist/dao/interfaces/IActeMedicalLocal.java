package com.dentist.dao.interfaces;

import com.dentist.entity.ActeMedical;

import jakarta.ejb.Local;

import java.util.List;

@Local
public interface IActeMedicalLocal {

    // CRUD de base
    ActeMedical getActeMedicalById(Long id);
    List<ActeMedical> getAllActesMedicals();
    void createActeMedical(ActeMedical acte);
    void updateActeMedical(ActeMedical acte);
    void deleteActeMedical(Long id);

    // Méthodes métier
    //List<ActeMedical> getActesByRendezvous(Long rendezvousId);
    //List<ActeMedical> getActesByServiceMedical(Long serviceId);
    //double getTotalTarifByRendezvous(Long rendezvousId);
}
