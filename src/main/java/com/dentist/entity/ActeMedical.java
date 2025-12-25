package com.dentist.entity;


import jakarta.persistence.*;


@Entity
@Table(name = "acteMedical")
public class ActeMedical {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAM;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idRv")
    private Rendezvous rendezvous;

    @ManyToOne(optional = false)
    @JoinColumn(name = "numSM")
    private ServiceMedical serviceMedical;

    @Column(columnDefinition = "TEXT")
    private String descriptionAM;

    private double tarifAM;

    // Getters & Setters

    public Long getIdAM() {
        return idAM;
    }

    public void setIdAM(Long idAM) {
        this.idAM = idAM;
    }

    public Rendezvous getRendezvous() {
        return rendezvous;
    }

    public void setRendezvous(Rendezvous rendezvous) {
        this.rendezvous = rendezvous;
    }

    public ServiceMedical getServiceMedical() {
        return serviceMedical;
    }

    public void setServiceMedical(ServiceMedical serviceMedical) {
        this.serviceMedical = serviceMedical;
    }

    public String getDescriptionAM() {
        return descriptionAM;
    }

    public void setDescriptionAM(String descriptionAM) {
        this.descriptionAM = descriptionAM;
    }

    public double getTarifAM() {
        return tarifAM;
    }

    public void setTarifAM(double tarifAM) {
        this.tarifAM = tarifAM;
    }
}
