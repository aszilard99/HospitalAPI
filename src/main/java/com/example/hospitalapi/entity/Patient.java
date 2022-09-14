package com.example.hospitalapi.entity;

public class Patient {
    private Integer id;
    private String name;
    private String symptom;

    public Patient(Integer id, String name, String symptom) {
        this.id = id;
        this.name = name;
        this.symptom = symptom;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSymptom() {
        return symptom;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }
}
