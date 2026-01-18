package com.dentist.dao.interfaces;

import com.dentist.entity.ServiceMedical;

import jakarta.ejb.Local;

import java.util.List;

@Local
public interface IServiceMedicalLocal {

    
    ServiceMedical getServiceMedicalById(Long id);
    List<ServiceMedical> getAllServicesMedical();
    void createServiceMedical(ServiceMedical service);
    void updateServiceMedical(ServiceMedical service);
    void deleteServiceMedical(Long id);
    void removeServiceMedical(Long id);
    



}