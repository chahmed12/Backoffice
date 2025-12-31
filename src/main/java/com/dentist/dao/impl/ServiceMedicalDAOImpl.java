package com.dentist.dao.impl;
import com.dentist.entity.ServiceMedical;


import com.dentist.dao.interfaces.IServiceMedicalLocal;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;


@Stateless
public class ServiceMedicalDAOImpl implements IServiceMedicalLocal{

    
    @PersistenceContext(unitName = "dentistPU")
    private EntityManager em;
    
    @Override
    public ServiceMedical getServiceMedicalById(Long id) {
    	return em.find(ServiceMedical.class, id);
    
    }
    
    @Override
    public List<ServiceMedical> getAllServicesMedical(){
    	return em.createQuery("SELECT a FROM ServiceMedical a", ServiceMedical.class).getResultList(); 
    }
    
    @Override
    public void createServiceMedical(ServiceMedical serviceMedical) {
    	em.persist(serviceMedical);
    }
     
    @Override 
    public void updateServiceMedical(ServiceMedical serviceMedical) {
    	em.merge(serviceMedical);
    	}
    
    @Override
    public void deleteServiceMedical(Long ID) {
    	ServiceMedical serviceMedical = em.find( ServiceMedical.class, ID);   
    	if(serviceMedical !=  null)
    	{
    		em.remove(serviceMedical);
    	}
    }     
}
    
   