package com.dentist.dao.impl;

import com.dentist.entity.Patient;


import com.dentist.dao.interfaces.IPatientLocal;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;

import java.util.List;
import java.util.Optional;


@Stateless
public class PatientDAOImpl implements IPatientLocal{

    @PersistenceContext(unitName = "dentistPU")
    private EntityManager em;
    
    @Override
    public Patient getPatientById(Long id) {      
        return em.find(Patient.class, id);      
    }

    @Override
    public List<Patient> getAllPatients() { 
        return em.createQuery("SELECT p FROM Patient p", Patient.class).getResultList(); 
    }

    @Override
    public void createPatient(Patient patient) {
        em.persist(patient);
       
    }

    @Override
    public void updatePatient(Patient patient) {
        em.merge(patient);
    }

    @Override
    public void deletePatient(Long id) {
        Patient patient = em.find(Patient.class, id);
        if (patient != null) {
            em.remove(patient);
        }
    }

    @Override
    public Optional<Patient> findByEmail(String email) {
        try {
            Patient p = em.createQuery("SELECT p FROM Patient p WHERE lower(p.emailP)=:e", Patient.class)
                .setParameter("e", email.toLowerCase())
                .getSingleResult();
            return Optional.of(p);
        } catch (NoResultException ex) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Patient> findPatientsByName(String name) {
        
        return Optional.empty();
    }

    @Override
    public Optional<Patient> findByEmailOrUsername(String login) {
        Optional<Patient> byEmail = findByEmail(login);
        if (byEmail.isPresent()) return byEmail;
        return findPatientsByName(login);
    }
}
