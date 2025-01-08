package cl.medical.service.impl;

import cl.medical.model.Alerta;
import cl.medical.model.Paciente;
import cl.medical.model.SenalVital;
import cl.medical.repository.AlertaRepository;
import cl.medical.repository.MedicalAlertRepository;
import cl.medical.repository.SenalVitalRepository;
import cl.medical.service.MedicalAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MedicalAlertServiceImpl implements MedicalAlertService {

    @Autowired
    private MedicalAlertRepository medicalAlertRepository;

    @Autowired
    private SenalVitalRepository senalVitalRepository;

    @Autowired
    private AlertaRepository alertaRepository;


    @Override
    public List<Paciente> findAllPatient() {
        return medicalAlertRepository.findAll();
    }

    @Override
    public Paciente findPatient(Long id) {
        if(medicalAlertRepository.findById(id).isPresent()){
            return medicalAlertRepository.findById(id).get();
        } else {
            return new Paciente();
        }
    }

    @Override
    public Paciente createPatient(Paciente entity) {
        return medicalAlertRepository.save(entity);
    }

    @Override
    public Paciente updatePatient(Paciente entity) {
        return medicalAlertRepository.save(entity);
    }

    @Override
    public void deletePatient(Long id) {
        medicalAlertRepository.deleteById(id);
    }

    @Override
    public List<SenalVital> findSenalByPacienteId(Long pacienteId) {
        return senalVitalRepository.findByPacienteId(pacienteId);
    }

    @Override
    public List<SenalVital> findByFechaHoraBetween(String start, String end) {
        return senalVitalRepository.findByFechaHoraBetween(start, end);
    }

    @Override
    public List<SenalVital> findByFrecuenciaCardiacaGreaterThan(Double frecuencia) {
        return senalVitalRepository.findByFrecuenciaCardiacaGreaterThan(frecuencia);
    }

    @Override
    public List<Alerta> findByPacienteId(Long pacienteId) {
        return alertaRepository.findByPacienteId(pacienteId);
    }

    @Override
    public List<Alerta> findByNivel(String nivel) {
        return alertaRepository.findByNivel(nivel);
    }

    @Override
    public List<Alerta> findByFechaHoraAfter(String fechaHora) {
        return alertaRepository.findByFechaHoraAfter(fechaHora);
    }


}
