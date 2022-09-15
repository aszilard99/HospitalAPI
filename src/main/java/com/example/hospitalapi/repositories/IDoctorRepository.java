package com.example.hospitalapi.repositories;

import com.example.hospitalapi.entity.Doctor;
import com.example.hospitalapi.entity.Patient;
import com.example.hospitalapi.exceptions.NotFoundException;

import java.util.List;

public interface IDoctorRepository {
    Integer addDoctor(String name, String specialization);

    Doctor findById(Integer doctorId);

    List<Doctor> getDoctors();

    Doctor updateDoctor(Integer id, String name, String specialization) throws NotFoundException;

    void deleteDoctor(Integer id);
}
