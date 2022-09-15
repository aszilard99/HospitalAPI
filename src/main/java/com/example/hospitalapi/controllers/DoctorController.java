package com.example.hospitalapi.controllers;

import com.example.hospitalapi.entity.Doctor;
import com.example.hospitalapi.entity.Patient;
import com.example.hospitalapi.exceptions.ServerException;
import com.example.hospitalapi.services.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {
    @Autowired
    IDoctorService doctorService;

    @PostMapping("/add")
    public ResponseEntity<Map<String, String>> addDoctor(@RequestBody Map<String, Object> doctorMap) {
        String name = (String) doctorMap.get("name");
        String specialization = (String) doctorMap.get("specialization");
        Doctor doctor = doctorService.addDoctor(name, specialization);
        Map<String,String> map = new HashMap<>();
        map.put("message", "added doctor successfully");
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Doctor>> getDoctors(){
        return new ResponseEntity<>(doctorService.getDoctors(), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Doctor> updateDoctor(@RequestBody Map<String, Object> updatedDoctorMap, @PathVariable Integer id){
        String name = (String) updatedDoctorMap.get("name");
        String specialization = (String) updatedDoctorMap.get("specialization");

        Doctor doctor = doctorService.updateDoctor(id, name, specialization);
        if (doctor == null){
            throw new ServerException("doctor not found");
        }
        else {
            return new ResponseEntity<>(doctor, HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String,String>> deleteDoctor(@PathVariable Integer id){

        doctorService.deleteDoctor(id);
        Map<String,String> map = new HashMap<>();
        map.put("message", "deleted doctor successfully");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }


}
