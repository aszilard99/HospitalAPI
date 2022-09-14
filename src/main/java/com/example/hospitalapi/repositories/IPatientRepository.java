package com.example.hospitalapi.repositories;

import com.example.hospitalapi.entity.Patient;
import com.example.hospitalapi.exceptions.EtAuthException;
import com.example.hospitalapi.exceptions.NotFoundException;

import java.util.List;

public interface IPatientRepository {

    Integer addPatient (String name, String symptom) throws EtAuthException;

    Patient findById(Integer patientId);

    List<Patient> getPatients();

    Patient updatePatient(Patient updatedPatient) throws NotFoundException;
}
