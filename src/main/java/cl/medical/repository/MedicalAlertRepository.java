package cl.medical.repository;


import cl.medical.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalAlertRepository extends JpaRepository<Paciente,Long> {
}
