package com.example.hospitalapi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Nurse {

    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
     Integer id;
    private String name;

    public Nurse(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    Nurse() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Nurse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nurse nurse = (Nurse) o;
        return Objects.equals(id, nurse.id) && Objects.equals(name, nurse.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
