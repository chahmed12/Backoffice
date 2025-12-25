package com.dentist.dao.impl;

import com.dentist.entity.Dentiste;
import com.dentist.dao.interfaces.IDentisteLocal;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Stateless
public class DentisteDAOImpl implements IDentisteLocal {

    @PersistenceContext(unitName = "dentistPU")
    private EntityManager em;

    @Override
    public Dentiste getDentisteById(Long id) {
        return em.find(Dentiste.class, id);
    }
    
    @Override
    public Optional<Dentiste> findByEmail(String email) {
        try {
            Dentiste d = em.createQuery("SELECT d FROM Patient d WHERE lower(d.emailD)=:e", Dentiste.class)
                .setParameter("e", email.toLowerCase())
                .getSingleResult();
            return Optional.of(d);
        } catch (NoResultException ex) {
            return Optional.empty();
        }
    }

    @Override
    public List<Dentiste> getAllDentistes() {
        return em.createQuery("SELECT d FROM Dentiste d", Dentiste.class)
                 .getResultList();
    }

    @Override
    public void createDentiste(Dentiste dentiste) {
        em.persist(dentiste);
    }

    @Override
    public void updateDentiste(Dentiste dentiste) {
        em.merge(dentiste);
    }

    @Override
    public void deleteDentiste(Long id) {
        Dentiste dentiste = em.find(Dentiste.class, id);
        if (dentiste != null) {
            em.remove(dentiste);
        }
    }
}
