package com.example.hospitalapi.entity;

public class Doctor {

    private Integer id;
    private String name;
    private String specialization;



    public Doctor(Integer id, String name, String specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }



    public void setId(Integer id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getSpecialization() {
        return specialization;
    }




}
