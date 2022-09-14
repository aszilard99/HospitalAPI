package com.example.hospitalapi.services;

import com.example.hospitalapi.entity.Patient;
import com.example.hospitalapi.exceptions.EtAuthException;
import com.example.hospitalapi.exceptions.NotFoundException;
import com.example.hospitalapi.repositories.IPatientRepository;
import com.example.hospitalapi.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PatientService implements IPatientService{

    @Autowired
    IPatientRepository patientRepository;

    @Override
    public Patient validatePatient(String name, String symptom) throws EtAuthException {
        return null;
    }

    @Override
    public Patient addPatient(String name, String symptom) throws EtAuthException {
        Integer patientId = patientRepository.addPatient(name, symptom);
        return patientRepository.findById(patientId);
    }

    @Override
    public List<Patient> getPatients() {
        return patientRepository.getPatients();
    }

    @Override
    public Patient updatePatient(Patient updatedPatient) throws NotFoundException {
        return patientRepository.updatePatient(updatedPatient);
    }
}
