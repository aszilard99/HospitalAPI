package com.example.hospitalapi.services;

import com.example.hospitalapi.entity.Doctor;
import com.example.hospitalapi.entity.Patient;
import com.example.hospitalapi.exceptions.NotFoundException;

import java.util.List;

public interface IDoctorService {
    Doctor addDoctor(String name, String specialization);

    List<Doctor> getDoctors();

    Doctor updateDoctor(Integer id, String name, String specialization) throws NotFoundException;

    void deleteDoctor(Integer id);
}
