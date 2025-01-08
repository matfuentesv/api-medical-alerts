package cl.medical.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank(message = "No puede nombre ser vacio")
    @NotNull(message = "No puede nombre ser nulo")
    private String nombre;

    @Column(name = "apellido")
    @NotBlank(message = "No puede apellido ser vacio")
    @NotNull(message = "No puede apellido ser nulo")
    private String apellido;

    @Column(name = "edad")
    private String edad;

    @Column(name = "direccion")
    @NotBlank(message = "No puede direccion ser vacio")
    @NotNull(message = "No puede direccion ser nulo")
    private String direccion;

    @Column(name = "telefono")
    @NotBlank(message = "No puede telefono ser vacio")
    @NotNull(message = "No puede telefono ser nulo")
    private String telefono;





}
