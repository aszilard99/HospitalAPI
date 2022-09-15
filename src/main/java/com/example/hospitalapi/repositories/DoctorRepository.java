package com.example.hospitalapi.repositories;

import com.example.hospitalapi.entity.Doctor;
import com.example.hospitalapi.entity.Patient;
import com.example.hospitalapi.exceptions.EtAuthException;
import com.example.hospitalapi.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.print.Doc;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class DoctorRepository implements IDoctorRepository{

    private final static String SQL_ADD_DOCTOR = "INSERT INTO doctor(id,name,specialization) VALUES(NEXTVAL('doctor_id_seq'), ?, ?)";
    private final static String SQL_GET_ALL_DOCTORS = "SELECT id,name,specialization FROM doctor";

    private final static String SQL_FIND_BY_ID = "SELECT id,name,specialization FROM doctor WHERE id = ?";
    private final static String SQL_UPDATE_DOCTOR = "UPDATE doctor SET name=?, specialization = ? WHERE id = ?";

    private final static String SQL_DELETE_DOCTOR = "DELETE FROM doctor WHERE id = ?";
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Integer addDoctor(String name, String specialization) throws EtAuthException{
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(SQL_ADD_DOCTOR, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, name);
                ps.setString(2, specialization);
                return ps;

            }, keyHolder);
            return (Integer) keyHolder.getKeys().get("id");
        }catch (Exception e){
            throw new EtAuthException("Invalid details, failed to create doctor");
        }
    }

    @Override
    public Doctor findById(Integer doctorId) {
        return jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new Object[]{doctorId}, doctorRowMapper);
    }

    @Override
    public List<Doctor> getDoctors() {

        List<Doctor> doctors = jdbcTemplate.query(SQL_GET_ALL_DOCTORS, doctorRowMapper);
        return doctors;
    }

    @Override
    public Doctor updateDoctor(Integer id, String name, String specialization) throws NotFoundException {
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(SQL_UPDATE_DOCTOR, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, name);
                ps.setString(2, specialization);
                ps.setInt(3,id);
                return ps;

            }, keyHolder);

            return findById((Integer) keyHolder.getKeys().get("id"));

        }catch (Exception e){

            throw new NotFoundException("Doctor not found in database with this id");
        }
    }

    @Override
    public void deleteDoctor(Integer id) throws NotFoundException{

        try{
            jdbcTemplate.update(connection ->{
                PreparedStatement ps = connection.prepareStatement(SQL_DELETE_DOCTOR, Statement.NO_GENERATED_KEYS);
                ps.setInt(1, id);
                return ps;
            });
            //TODO on bad doctor_id it returns that delete is successfull, so it doesnt throw the exception below
        }catch(Exception e){
            throw new NotFoundException("Doctor with this id could not be found");
        }
    }


    private RowMapper<Doctor> doctorRowMapper = ((rs, rowNum) -> {
        return new Doctor(rs.getInt("id"), rs.getString("name"), rs.getString("specialization"));
    });
}
