package com.dentist.entity;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "serviceMedical")
public class ServiceMedical {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numSM;

    @Column(nullable = false, length = 100)
    private String nomSM;

    @Column(nullable = false, length = 100)
    private String typeSM;

    @Column(columnDefinition = "TEXT")
    private String descriptionSM;
    
    @Column
    private double tarifSM;
    
    @JsonbTransient
    @OneToMany(mappedBy = "serviceMedical",cascade = CascadeType.ALL)
    private List<ActeMedical> actes;

	public Long getNumSM() {
		return numSM;
	}

	public void setNumSM(Long numSM) {
		this.numSM = numSM;
	}

	public String getNomSM() {
		return nomSM;
	}

	public void setNomSM(String nomSM) {
		this.nomSM = nomSM;
	}

	public String getTypeSM() {
		return typeSM;
	}

	public void setTypeSM(String typeSM) {
		this.typeSM = typeSM;
	}

	public String getDescriptionSM() {
		return descriptionSM;
	}

	public void setDescriptionSM(String descriptionSM) {
		this.descriptionSM = descriptionSM;
	}

	public double getTarifSM() {
		return tarifSM;
	}

	public void setTarifSM(double tarifSM) {
		this.tarifSM = tarifSM;
	}

	@Override
	public String toString() {
		return "ServiceMedical [numSM=" + numSM + ", nomSM=" + nomSM + ", typeSM=" + typeSM + ", descriptionSM="
				+ descriptionSM + ", tarifSM=" + tarifSM + ", actes=" + actes + "]";
	}

	public List<ActeMedical> getActes() {
		return actes;
	}

	public void setActes(List<ActeMedical> actes) {
		this.actes = actes;
	}

    
}
