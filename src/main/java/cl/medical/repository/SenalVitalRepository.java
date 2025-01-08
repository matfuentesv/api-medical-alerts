package cl.medical.repository;


import cl.medical.model.SenalVital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SenalVitalRepository extends JpaRepository<SenalVital,Long> {

    List<SenalVital> findByPacienteId(Long pacienteId);

    List<SenalVital> findByFechaHoraBetween(String start, String end);

    List<SenalVital> findByFrecuenciaCardiacaGreaterThan(Double frecuencia);
}
