package cl.medical.service.impl;

import cl.medical.model.Paciente;
import cl.medical.model.SignosVitales;
import cl.medical.repository.MedicalAlertRepository;
import cl.medical.repository.SignsVitalRepository;
import cl.medical.service.MedicalAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MedicalAlertServiceImpl implements MedicalAlertService {

    @Autowired
    private MedicalAlertRepository medicalAlertRepository;

    @Autowired
    private SignsVitalRepository signsVitalRepository;


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
    public Paciente updatePatient(Long id,Paciente entity) {
        entity.setId(id);
        return medicalAlertRepository.save(entity);
    }

    @Override
    public void deletePatient(Long id) {
        medicalAlertRepository.deleteById(id);
    }

    @Override
    public List<SignosVitales> findSignVitalByPacientee(Long id) {
        List<SignosVitales> list  = signsVitalRepository.findSignVitalByPacientee(id);
        return list;
    }


}
