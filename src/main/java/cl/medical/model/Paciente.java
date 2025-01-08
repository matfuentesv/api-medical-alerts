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


    private Paciente(Paciente.Builder builder) {
        this.id = builder.id;
    }

    public static class Builder {
        private Long id;
        private String nombre;
        private String apellido;
        private Integer edad;
        private String direccion;
        private String telefono;


        public Paciente.Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Paciente.Builder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Paciente.Builder apellido(String apellido) {
            this.apellido = apellido;
            return this;
        }

        public Paciente.Builder edad(Integer edad) {
            this.edad = edad;
            return this;
        }

        public Paciente.Builder direccion(String direccion) {
            this.direccion = direccion;
            return this;
        }

        public Paciente.Builder telefono(String telefono) {
            this.telefono = telefono;
            return this;
        }

        public Paciente build() {
            return new Paciente(this);
        }
    }
}
