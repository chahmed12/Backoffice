package com.dentist.dao.impl;
import com.dentist.entity.Rendezvous;


import com.dentist.dao.interfaces.IRendezvousLocal;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;


@Stateless
public class RendezvousDAOImpl implements IRendezvousLocal{

    
    @PersistenceContext(unitName = "dentistPU")
    private EntityManager em;
    
    
    @Override
    public Rendezvous getRendezvousById(Long id) {
    	return em.find(Rendezvous.class, id);
    
    }
    
    @Override
    public List<Rendezvous> getAllRendezvous(){
    	return em.createQuery("SELECT r FROM Rendezvous r", Rendezvous.class).getResultList(); 
    }
    
    @Override
    public void createRendezvous(Rendezvous rendezvous) {
    	em.persist(rendezvous);
    }
     
    @Override 
    public void updateRendezvous(Rendezvous rendezvous) {
    	em.merge(rendezvous);
    	}
    
    @Override
    public void deleteRendezvous(Long ID) {
    	Rendezvous rendezvous = em.find(Rendezvous.class, ID);   
    	if(rendezvous !=  null)
    	{
    		em.remove(rendezvous);
    	}
    }
    
    
    
    	
}
    
    