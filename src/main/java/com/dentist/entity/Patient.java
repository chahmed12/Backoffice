package com.dentist.entity;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "patient")
public class Patient{

    

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(length = 8)
    private Long idP;

    @Column(nullable = false, length = 100)
    private String nomP;

    @Column(nullable = false, length = 100)
    private String prenomP;

    @Column(nullable = false, unique = true, length = 100)
    private String emailP;

    @Column(length = 10)
    private String groupSanguinP;

    @Column(length = 100)
    private String photoP;

    @Column(nullable = false, length = 1)
    private String sexeP;

    @Column(name = "date_naissance")
    private LocalDate dateNP;

    @Column(length = 100)
    private String recouvrementP;

    @Column(nullable = false, length = 10)
    private String mdpP;

    @OneToMany(mappedBy = "patient")
    @JsonbTransient
    private List<Rendezvous> rendezvousList;
    
    
    @Column(length = 20) 
    private String telP;
    
    @Column(length = 255)
    private String adresseP;

    
    public Long getIdP() {
        return idP;
    }

    public void setIdP(Long idP) {
        this.idP = idP;
    }

    public String getNomP() {
        return nomP;
    }

    public void setNomP(String nomP) {
        this.nomP = nomP;
    }

    public String getPrenomP() {
        return prenomP;
    }

    public void setPrenomP(String prenomP) {
        this.prenomP = prenomP;
    }

    public String getEmailP() {
        return emailP;
    }

    public void setEmailP(String emailP) {
        this.emailP = emailP;
    }

    public String getGroupSanguinP() {
        return groupSanguinP;
    }

    public void setGroupSanguinP(String groupSanguinP) {
        this.groupSanguinP = groupSanguinP;
    }

    public String getPhotoP() {
        return photoP;
    }

    public void setPhotoP(String photoP) {
        this.photoP = photoP;
    }

    public String getSexeP() {
        return sexeP;
    }

    public void setSexeP(String sexeP) {
        this.sexeP = sexeP;
    }

    public LocalDate getDateNP() {
        return dateNP;
    }

    public void setDateNP(LocalDate localDate) {
        this.dateNP = localDate;
    }

    public String getRecouvrementP() {
        return recouvrementP;
    }

    public void setRecouvrementP(String recouvrementP) {
        this.recouvrementP = recouvrementP;
    }

    public String getMdpP() {
        return mdpP;
    }

    public void setMdpP(String mdpP) {
        this.mdpP = mdpP;
    }
    


    public List<Rendezvous> getRendezvousList() {
        return rendezvousList;
    }

    public void setRendezvousList(List<Rendezvous> rendezvousList) {
        this.rendezvousList = rendezvousList;
    }

    public String getTelP() { return telP; }
    public void setTelP(String telP) { this.telP = telP; }
    
    public String getAdresseP() { return adresseP; }
    public void setAdresseP(String adresseP) { this.adresseP = adresseP; }

	@Override
	public String toString() {
		return "Patient [idP=" + idP + ", nomP=" + nomP + ", prenomP=" + prenomP + ", emailP=" + emailP
				+ ", groupSanguinP=" + groupSanguinP + ", photoP=" + photoP + ", sexeP=" + sexeP + ", dateNP=" + dateNP
				+ ", recouvrementP=" + recouvrementP + ", rendezvousList=" + rendezvousList + "]";
	}
}
