package cl.medical.controller;

import cl.medical.exception.ApiResponse;
import cl.medical.model.Paciente;
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
@CrossOrigin
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

    @PutMapping("/updatePatient/{id}")
    public ResponseEntity<Object> updatePatient(@PathVariable Long id, @RequestBody Paciente entity,
                                                BindingResult bindingResult) throws MethodArgumentNotValidException {
        if (entity == null) {
            log.info("Algunos de los parámetros no se ingresaron");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Algunos de los parámetros no se ingresaron", false));
        }

        return ResponseEntity.ok(medicalAlertService.updatePatient(id,entity));
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

}
