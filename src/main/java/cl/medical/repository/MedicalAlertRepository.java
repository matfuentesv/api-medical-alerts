package cl.medical.repository;


import cl.medical.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicalAlertRepository extends JpaRepository<Paciente,Long> {

    List<Paciente> findByNombreContainingIgnoreCase(String nombre);
}
