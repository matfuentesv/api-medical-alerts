package cl.medical.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "SignosVitales")
@JsonIgnoreProperties(ignoreUnknown = true)
public class SignosVitales  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "frecuenciaCardiaca")
    private double frecuenciaCardiaca;

    @Column(name = "presionArterial")
    private double presionArterial;

    @Column(name = "nivelOxígeno")
    private double nivelOxigeno;


    public Long getId() {
        return id;
    }

    public SignosVitales setId(Long id) {
        this.id = id;
        return this;
    }

    public double getFrecuenciaCardiaca() {
        return frecuenciaCardiaca;
    }

    public SignosVitales setFrecuenciaCardiaca(double frecuenciaCardiaca) {
        this.frecuenciaCardiaca = frecuenciaCardiaca;
        return this;
    }

    public double getPresionArterial() {
        return presionArterial;
    }

    public SignosVitales setPresionArterial(double presionArterial) {
        this.presionArterial = presionArterial;
        return this;
    }

    public double getNivelOxigeno() {
        return nivelOxigeno;
    }

    public SignosVitales setNivelOxigeno(double nivelOxigeno) {
        this.nivelOxigeno = nivelOxigeno;
        return this;
    }

}
