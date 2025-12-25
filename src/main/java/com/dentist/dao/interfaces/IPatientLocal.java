package com.dentist.dao.interfaces;



import com.dentist.entity.Patient;

//import com.dentist.entity.Rendezvous;

import java.util.List;
import java.util.Optional;

public interface IPatientLocal {
    Patient getPatientById(Long id);
    List<Patient> getAllPatients();
    void createPatient(Patient patient);
    void updatePatient(Patient patient);
    void deletePatient(Long id);
    public Optional<Patient> findPatientsByName(String nom);
    //List<Rendezvous> getRendezvousByPatient(Long patientId);
    //boolean exists(Long id);
    public Optional<Patient> findByEmail(String email);
    public Optional<Patient> findByEmailOrUsername(String login);
}
