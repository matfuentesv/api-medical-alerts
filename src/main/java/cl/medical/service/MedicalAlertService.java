package cl.medical.service;

import cl.medical.model.Paciente;
import cl.medical.model.SignosVitales;

import java.util.List;

public interface MedicalAlertService {

    List<Paciente> findAllPatient();
    Paciente findPatient(Long id);
    Paciente createPatient(Paciente patient);
    Paciente updatePatient(Long id,Paciente patient);
    void deletePatient(Long id);
    List<SignosVitales> findSignVitalByPacientee(Long id);
}
