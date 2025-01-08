package cl.medical.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "SenalVital")
@AllArgsConstructor
@NoArgsConstructor
public class SenalVital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @Column(name = "frecuenciaCardiaca")
    private Double frecuenciaCardiaca;

    @Column(name = "presionArterialSistolica")
    private Double presionArterialSistolica;

    @Column(name = "presionArterialDiastolica")
    private Double presionArterialDiastolica;

    @Column(name = "temperatura")
    private Double temperatura;

    @Column(name = "fechaHora")
    private String fechaHora;


}
