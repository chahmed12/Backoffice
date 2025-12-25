package com.dentist.dao.impl;
import com.dentist.entity.ActeMedical;





import com.dentist.dao.interfaces.IActeMedicalLocal;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;


@Stateless
public class ActeMedicalDAOImpl implements IActeMedicalLocal{

    
    @PersistenceContext(unitName = "dentistPU")
    private EntityManager em;
    
    
    @Override
    public ActeMedical getActeMedicalById(Long id) {
    	return em.find(ActeMedical.class, id);
    
    }
    
    @Override
    public List<ActeMedical> getAllActesMedicals(){
    	return em.createQuery("SELECT a FROM ActeMedical a", ActeMedical.class).getResultList(); 
    }
    
    @Override
    public void createActeMedical(ActeMedical acteMedical) {
    	em.persist(acteMedical);
    }
     
    @Override 
    public void updateActeMedical(ActeMedical acteMedical) {
    	em.merge(acteMedical);
    	}
    
    @Override
    public void deleteActeMedical(Long ID) {
    	 ActeMedical acteMedical = em.find( ActeMedical.class, ID);   
    	if(acteMedical !=  null)
    	{
    		em.remove(acteMedical);
    	}
    }
    
    
    
    	
}
    
    