package com.example.hospitalapi.services;

import com.example.hospitalapi.entity.Doctor;
import com.example.hospitalapi.entity.Patient;
import com.example.hospitalapi.exceptions.NotFoundException;
import com.example.hospitalapi.repositories.IDoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class DoctorService implements IDoctorService{

    @Autowired
    IDoctorRepository doctorRepository;

    @Override
    public Doctor addDoctor(String name, String specialization) {
        Integer doctorId = doctorRepository.addDoctor(name, specialization);
        return doctorRepository.findById(doctorId);
    }

    @Override
    public List<Doctor> getDoctors() {
        return doctorRepository.getDoctors();
    }

    @Override
    public Doctor updateDoctor(Integer id, String name, String specialization) throws NotFoundException {
        return doctorRepository.updateDoctor(id,name,specialization);
    }

    @Override
    public void deleteDoctor(Integer id) {
        doctorRepository.deleteDoctor(id);
    }
}
