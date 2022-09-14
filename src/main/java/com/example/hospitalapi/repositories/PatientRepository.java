package com.example.hospitalapi.repositories;

import com.example.hospitalapi.entity.Patient;
import com.example.hospitalapi.exceptions.EtAuthException;
import com.example.hospitalapi.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class PatientRepository implements IPatientRepository{



    private static final String SQL_ADD_PATIENT = "INSERT INTO patient(id, name, symptom) VALUES(NEXTVAL('patient_id_seq'), ?, ?)";

    private static final String SQL_FIND_BY_ID = "SELECT id, name, symptom FROM patient WHERE id = ?";

    private static final String SQL_GET_ALL_PATIENTS = "SELECT id, name, symptom FROM patient";

    private static final String SQL_UPDATE_PATIENT = "UPDATE patient SET name = ?, symptom = ? WHERE id = ?";
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Integer addPatient(String name, String symptom) throws EtAuthException {
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(SQL_ADD_PATIENT, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, name);
                ps.setString(2, symptom);
                return ps;

            }, keyHolder);
            return (Integer) keyHolder.getKeys().get("id");
        }catch (Exception e){
            throw new EtAuthException("Invalid details, failed to create patient");
        }
    }

    @Override
    public Patient findById(Integer patientId) {
        //"patientRowMapper takes a row/record from the database and turns it into a patient object, it is ORM"//
        return  (Patient)  jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new Object[]{patientId}, patientRowMapper);
    }

    @Override
    public List<Patient> getPatients() {

        List<Patient> patients = jdbcTemplate.query(SQL_GET_ALL_PATIENTS, patientRowMapper);
        return patients;
    }

    @Override
    public Patient updatePatient(Patient updatedPatient) throws NotFoundException {
        return null;
    }


    private RowMapper<Patient> patientRowMapper = ((rs, rowNum) -> {
        return new Patient(rs.getInt("id"), rs.getString("name"), rs.getString("symptom"));
    });
}
