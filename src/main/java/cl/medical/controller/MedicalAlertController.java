package cl.medical.controller;

import cl.medical.exception.ApiResponse;
import cl.medical.model.Alerta;
import cl.medical.model.Paciente;
import cl.medical.model.SenalVital;
import cl.medical.service.MedicalAlertService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
@Log
public class MedicalAlertController {

    @Autowired
    MedicalAlertService medicalAlertService;

    @GetMapping(value = "/findAllPatient", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Paciente>> findAllPatient() {
        log.info("Se solicita la lista de todas las entidades.");
        return ResponseEntity.ok(medicalAlertService.findAllPatient());
    }

    @GetMapping("/findPatient/{id}")
    public ResponseEntity<Object> findPatient(@PathVariable Long id) {
        if (StringUtils.containsWhitespace(String.valueOf(id)) || id == null) {
            log.info("El id no se ingresó");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Algunos de los parámetros no se ingresaron", false));
        }
        return ResponseEntity.ok(medicalAlertService.findPatient(id));
    }

    @PostMapping("/createPatient")
    public ResponseEntity<Object> createPatient( @RequestBody Paciente entity,
                                                BindingResult bindingResult) throws MethodArgumentNotValidException {
        if (entity == null) {
            log.info("Algunos de los parámetros no se ingresaron");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Algunos de los parámetros no se ingresaron", false));
        }

        return ResponseEntity.ok(medicalAlertService.createPatient(entity));
    }

    @PutMapping("/updatePatient")
    public ResponseEntity<Object> updatePatient( @RequestBody Paciente entity,
                                                BindingResult bindingResult) throws MethodArgumentNotValidException {
        if (entity == null) {
            log.info("Algunos de los parámetros no se ingresaron");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Algunos de los parámetros no se ingresaron", false));
        }

        return ResponseEntity.ok(medicalAlertService.updatePatient(entity));
    }

    @DeleteMapping("/deletePatient/{id}")
    public ResponseEntity<Object> deletePatient(@PathVariable Long id) {
        if (StringUtils.containsWhitespace(String.valueOf(id)) || id == null) {
            log.info("El id no se ingresó");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Algunos de los parámetros no se ingresaron", false));
        }

        Paciente entity = medicalAlertService.findPatient(id);

        if (entity.getId() != null) {
            medicalAlertService.deletePatient(id);
            return ResponseEntity.ok(new ApiResponse("Entidad eliminada", true));
        } else {
            log.info("Entidad no encontrada con id: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Entidad no encontrada", false));
        }
    }

    @GetMapping("/findSenalByPacienteId/{pacienteId}")
    public ResponseEntity<List<SenalVital>> findSenalByPacienteId(@PathVariable Long pacienteId) {
        log.info("Buscando señales vitales para el paciente con ID: " + pacienteId);
        return ResponseEntity.ok(medicalAlertService.findSenalByPacienteId(pacienteId));
    }

    @GetMapping("/findSenalByFechaHora")
    public ResponseEntity<List<SenalVital>> findByFechaHoraBetween(@RequestParam String start, @RequestParam String end) {
        log.info("Buscando señales vitales entre: " + start + " y " + end);
        return ResponseEntity.ok(medicalAlertService.findByFechaHoraBetween(start, end));
    }

    @GetMapping("/findSenalByFrecuenciaCardiaca")
    public ResponseEntity<List<SenalVital>> findByFrecuenciaCardiacaGreaterThan(@RequestParam Double frecuencia) {
        log.info("Buscando señales vitales con frecuencia cardiaca mayor a: " + frecuencia);
        return ResponseEntity.ok(medicalAlertService.findByFrecuenciaCardiacaGreaterThan(frecuencia));
    }

    @GetMapping("/findAlertByPacienteId/{pacienteId}")
    public ResponseEntity<List<Alerta>> findByPacienteId(@PathVariable Long pacienteId) {
        log.info("Buscando alertas para el paciente con ID: " + pacienteId);
        return ResponseEntity.ok(medicalAlertService.findByPacienteId(pacienteId));
    }

    @GetMapping("/findAlertByNivel")
    public ResponseEntity<List<Alerta>> findByNivel(@RequestParam String nivel) {
        log.info("Buscando alertas con nivel: " + nivel);
        return ResponseEntity.ok(medicalAlertService.findByNivel(nivel));
    }

    @GetMapping("/findAlertByFechaHora")
    public ResponseEntity<List<Alerta>> findByFechaHoraAfter(@RequestParam String fechaHora) {
        log.info("Buscando alertas con fecha y hora posterior a: " + fechaHora);
        return ResponseEntity.ok(medicalAlertService.findByFechaHoraAfter(fechaHora));
    }
}
