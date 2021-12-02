package com.anbu.demo.cont;
import com.anbu.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class StudentController {
//    @Autowired
//    PatientService patientService;
//
//    @GetMapping("/getPatientDetails")
//    public Student getPatient(@RequestParam String name ) throws InterruptedException, ExecutionException{
//        return patientService.getPatientDetails(name);
//    }
//
//    @PostMapping("/createPatient")
//    public String createPatient(@RequestBody Student patient ) throws InterruptedException, ExecutionException {
//        return patientService.savePatientDetails(patient);
//    }
//
//    @PutMapping("/updatePatient")
//    public String updatePatient(@RequestBody Student patient  ) throws InterruptedException, ExecutionException {
//        return patientService.updatePatientDetails(patient);
//    }
//
//    @DeleteMapping("/deletePatient")
//    public String deletePatient(@RequestParam String name){
//        return patientService.deletePatient(name);
//    }
}
