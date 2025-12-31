package com.dentist.dao.interfaces;
import com.dentist.entity.Publication;
import jakarta.ejb.Local;
import java.util.List;

@Local
public interface IPublicationLocal {
    Publication createPublication(Publication publication);
    Publication findPublicationById(Long id);
    List<Publication> findAllPublications();
    Publication updatePublication(Publication publication);
    void deletePublication(Long id);
    List<Publication> findPublicationsByCategorie(String categorie);
}