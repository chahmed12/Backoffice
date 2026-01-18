package com.dentist.dao.interfaces;

import com.dentist.entity.ActeMedical;

import jakarta.ejb.Local;

import java.util.List;

@Local
public interface IActeMedicalLocal {


    ActeMedical getActeMedicalById(Long id);
    List<ActeMedical> getAllActesMedicals();
    void createActeMedical(ActeMedical acte);
    void updateActeMedical(ActeMedical acte);
    void deleteActeMedical(Long id);
    List<ActeMedical> getActesByRendezvousId(Long idRv);


}
