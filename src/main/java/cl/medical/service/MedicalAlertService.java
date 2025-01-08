package cl.medical.service;

import cl.medical.model.Alerta;
import cl.medical.model.Paciente;
import cl.medical.model.SenalVital;

import java.util.List;

public interface MedicalAlertService {

    List<Paciente> findAllPatient();
    Paciente findPatient(Long id);
    Paciente createPatient(Paciente patient);
    Paciente updatePatient(Paciente patient);
    void deletePatient(Long id);
    List<SenalVital> findSenalByPacienteId(Long pacienteId);
    List<SenalVital> findByFechaHoraBetween(String start, String end);
    List<SenalVital> findByFrecuenciaCardiacaGreaterThan(Double frecuencia);
    List<Alerta> findByPacienteId(Long pacienteId);
    List<Alerta> findByNivel(String nivel);
    List<Alerta> findByFechaHoraAfter(String fechaHora);
}
