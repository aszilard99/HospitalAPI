package com.example.hospitalapi.services;

import com.example.hospitalapi.entity.Patient;
import com.example.hospitalapi.exceptions.EtAuthException;
import com.example.hospitalapi.exceptions.NotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface IPatientService {
    Patient validatePatient(String name, String symptom) throws EtAuthException;

    Patient addPatient(String name, String symptom) throws EtAuthException;

    List<Patient> getPatients();

    Patient updatePatient(Patient updatedPatient) throws NotFoundException;
}
