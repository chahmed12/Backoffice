package com.dentist.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "dentiste")
public class Dentiste {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idD;

    @Column(nullable = false, length = 100)
    private String nomD;

    @Column(nullable = false, length = 100)
    private String prenomD;

    @Column(nullable = false, unique = true, length = 100)
    private String emailD;

    @Column(length = 100)
    private String specialiteD;

    @Column(nullable = false, length = 10)
    private String mdpD;

    @Column(length = 100)
    private String photoD;

    @Column(nullable = false, length = 1)
    private String sexeD;

    private String telD;

    @OneToMany(mappedBy = "dentiste")
    private List<Rendezvous> rendezvousList;

    // =====================
    // Getters & Setters
    // =====================

    public Long getIdD() {
        return idD;
    }

    public void setIdD(Long idD) {
        this.idD = idD;
    }

    public String getNomD() {
        return nomD;
    }

    public void setNomD(String nomD) {
        this.nomD = nomD;
    }

    public String getPrenomD() {
        return prenomD;
    }

    public void setPrenomD(String prenomD) {
        this.prenomD = prenomD;
    }

    public String getEmailD() {
        return emailD;
    }

    public void setEmailD(String emailD) {
        this.emailD = emailD;
    }

    public String getSpecialiteD() {
        return specialiteD;
    }

    public void setSpecialiteD(String specialiteD) {
        this.specialiteD = specialiteD;
    }

    public String getMdpD() {
        return mdpD;
    }

    public void setMdpD(String mdpD) {
        this.mdpD = mdpD;
    }

    public String getPhotoD() {
        return photoD;
    }

    public void setPhotoD(String photoD) {
        this.photoD = photoD;
    }

    public String getSexeD() {
        return sexeD;
    }

    public void setSexeD(String sexeD) {
        this.sexeD = sexeD;
    }

    public String getTelD() {
        return telD;
    }

    public void setTelD(String telephone) {
        this.telD = telephone;
    }

    public List<Rendezvous> getRendezvousList() {
        return rendezvousList;
    }

    public void setRendezvousList(List<Rendezvous> rendezvousList) {
        this.rendezvousList = rendezvousList;
    }

    @Override
    public String toString() {
        return "Dentiste [idD=" + idD + ", nomD=" + nomD + ", prenomD=" + prenomD +
               ", emailD=" + emailD + ", specialiteD=" + specialiteD + ", photoD=" +
               photoD + ", sexeD=" + sexeD + ", telD=" + telD + "]";
    }

	
}
