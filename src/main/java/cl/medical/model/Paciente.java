package cl.medical.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Paciente")
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "edad")
    private String edad;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "alertaMensaje")
    private String alertaMensaje;

    @Column(name = "alertaNivel")
    private String alertaNivel;

    @Column(name = "alertaFechaHora")
    private String alertaFechaHora;

    @Column(name = "frecuenciaCardiaca")
    private Double frecuenciaCardiaca;

    @Column(name = "presionArterialSistolica")
    private Double presionArterialSistolica;

    @Column(name = "presionArterialDiastolica")
    private Double presionArterialDiastolica;

    @Column(name = "temperatura")
    private Double temperatura;

    @Column(name = "senalVitalFechaHora")
    private String senalVitalFechaHora;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getAlertaMensaje() {
        return alertaMensaje;
    }

    public void setAlertaMensaje(String alertaMensaje) {
        this.alertaMensaje = alertaMensaje;
    }

    public String getAlertaNivel() {
        return alertaNivel;
    }

    public void setAlertaNivel(String alertaNivel) {
        this.alertaNivel = alertaNivel;
    }

    public String getAlertaFechaHora() {
        return alertaFechaHora;
    }

    public void setAlertaFechaHora(String alertaFechaHora) {
        this.alertaFechaHora = alertaFechaHora;
    }

    public Double getFrecuenciaCardiaca() {
        return frecuenciaCardiaca;
    }

    public void setFrecuenciaCardiaca(Double frecuenciaCardiaca) {
        this.frecuenciaCardiaca = frecuenciaCardiaca;
    }

    public Double getPresionArterialSistolica() {
        return presionArterialSistolica;
    }

    public void setPresionArterialSistolica(Double presionArterialSistolica) {
        this.presionArterialSistolica = presionArterialSistolica;
    }

    public Double getPresionArterialDiastolica() {
        return presionArterialDiastolica;
    }

    public void setPresionArterialDiastolica(Double presionArterialDiastolica) {
        this.presionArterialDiastolica = presionArterialDiastolica;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public String getSenalVitalFechaHora() {
        return senalVitalFechaHora;
    }

    public void setSenalVitalFechaHora(String senalVitalFechaHora) {
        this.senalVitalFechaHora = senalVitalFechaHora;
    }
}
