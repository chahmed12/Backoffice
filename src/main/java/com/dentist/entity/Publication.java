package com.dentist.entity;

import jakarta.persistence.*;
import jakarta.json.bind.annotation.JsonbDateFormat;
import java.time.LocalDate;

@Entity
@Table(name = "publication")
public class Publication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPub;

    @Column(nullable = false)
    private String titre;

    @Column(columnDefinition = "TEXT") 
    private String resume;

    @Column(name = "date_publication")
    @JsonbDateFormat("yyyy-MM-dd")
    private LocalDate datePublication;
    
    @Column
    private String categorie;
    
    
    private String photo;
    private String fichier;
    
    
    @Column(length = 100)
    private String auteur;
    
    public String getAuteur() { return auteur; }
    public void setAuteur(String auteur) { this.auteur = auteur; }

    
    

	public Long getIdPub() {
		return idPub;
	}

	public void setIdPub(Long idPub) {
		this.idPub = idPub;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public LocalDate getDatePublication() {
		return datePublication;
	}

	public void setDatePublication(LocalDate datePublication) {
		this.datePublication = datePublication;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getFichier() {
		return fichier;
	}

	public void setFichier(String fichier) {
		this.fichier = fichier;
	}

    
}