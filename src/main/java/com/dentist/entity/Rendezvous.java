package com.dentist.entity;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
public class Rendezvous {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRv;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idP")
    private Patient patient;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idD")
    private Dentiste dentiste;

    
    @Column(nullable = false)  
    private LocalDate dateRv;

    @JsonbDateFormat("HH:mm")
    @Column(nullable = false)
    private LocalTime heureRv;

    @Column(nullable = false, length = 100)
    private String statutRv;

    @Column(columnDefinition = "TEXT")
    private String detailsRv;
    
    @OneToMany(mappedBy = "rendezvous", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ActeMedical> actes;

	public Long getIdRv() {
		return idRv;
	}

	public void setIdRv(Long idRv) {
		this.idRv = idRv;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Dentiste getDentiste() {
		return dentiste;
	}

	public void setDentiste(Dentiste dentiste) {
		this.dentiste = dentiste;
	}

	public LocalDate getDateRv() {
		return dateRv;
	}

	public void setDateRv(LocalDate dateRv) {
		this.dateRv = dateRv;
	}

	public LocalTime getHeureRv() {
		return heureRv;
	}

	public void setHeureRv(LocalTime heureRv) {
		this.heureRv = heureRv;
	}

	public String getStatutRv() {
		return statutRv;
	}

	public void setStatutRv(String statutRv) {
		this.statutRv = statutRv;
	}

	public String getDetailsRv() {
		return detailsRv;
	}

	public void setDetailsRv(String detailsRv) {
		this.detailsRv = detailsRv;
	}

	public List<ActeMedical> getActes() {
		return actes;
	}

	public void setActes(List<ActeMedical> actes) {
        this.actes = actes;
        
        if(actes != null) {
            for(ActeMedical acte : actes) {
                acte.setRendezvous(this);
            }
        }
    }

	@Override
	public String toString() {
		return "Rendezvous [idRv=" + idRv + ", patient=" + patient + ", dentiste=" + dentiste + ", dateRv=" + dateRv
				+ ", heureRv=" + heureRv + ", statutRv=" + statutRv + ", detailsRv=" + detailsRv + ", actes=" + actes
				+ "]";
	}

    
}
