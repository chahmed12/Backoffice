package com.dentist.dao.impl;
import com.dentist.dao.interfaces.IPublicationLocal;
import com.dentist.entity.Publication;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
@Stateless
public class PublicationDAOImpl implements IPublicationLocal {
    @PersistenceContext(unitName = "dentistPU") 
    private EntityManager em;
    @Override
    public Publication createPublication(Publication publication) {
        em.persist(publication);
        return publication;
    }
    @Override
    public Publication findPublicationById(Long id) {
        return em.find(Publication.class, id);
    }
    @Override
    public List<Publication> findAllPublications() {
        return em.createQuery("SELECT p FROM Publication p ORDER BY p.datePublication DESC", Publication.class)
                 .getResultList();
    }
    @Override
    public Publication updatePublication(Publication publication) {
        return em.merge(publication);
    }
    @Override
    public void deletePublication(Long id) {
        Publication pub = findPublicationById(id);
        if (pub != null) {
            em.remove(pub);
        }
    }
    @Override
    public List<Publication> findPublicationsByCategorie(String categorie) {
        return em.createQuery("SELECT p FROM Publication p WHERE p.categorie = :cat", Publication.class)
                 .setParameter("cat", categorie)
                 .getResultList();
    }
}