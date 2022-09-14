package com.example.hospitalapi.controllers;

import com.example.hospitalapi.entity.Patient;
import com.example.hospitalapi.services.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ServerErrorException;

import com.example.hospitalapi.exceptions.ServerException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/patient")
public class PatientController {


    @Autowired
    IPatientService patientService;

    @PostMapping("/add")
    public ResponseEntity<Map<String, String>> addPatient(@RequestBody Map<String, Object> patientMap) {
        String name = (String) patientMap.get("name");
        String symptom = (String) patientMap.get("symptom");
        Patient patient = patientService.addPatient(name, symptom);
        Map<String,String> map = new HashMap<>();
        map.put("message", "added patient successfully");
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Patient>> getPatients(){
        return new ResponseEntity<>(patientService.getPatients(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Patient> updatePatient(@RequestBody final Patient updatedPatient){
        Patient patient = patientService.updatePatient(updatedPatient);
        if (patient == null){
            throw new ServerException("patient not found");
        }
        else {
            return new ResponseEntity<>(patient, HttpStatus.OK);
        }
    }


}
