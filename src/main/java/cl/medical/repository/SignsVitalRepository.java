package cl.medical.repository;

import cl.medical.model.SignosVitales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SignsVitalRepository extends JpaRepository<SignosVitales, Long> {

    @Query(value = "SELECT * FROM signos_vitales WHERE paciente_id = :pacienteId", nativeQuery = true)
    List<SignosVitales> findSignVitalByPacientee(@Param("pacienteId") Long pacienteId);

}
