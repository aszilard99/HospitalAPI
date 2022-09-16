package com.example.hospitalapi.repositories;

import com.example.hospitalapi.entity.Nurse;
import org.springframework.data.jpa.repository.JpaRepository;

//TODO: check if the request methods that rely on id dont work because in the db the id:Integer, here the id: Long
public interface INurseRepository extends JpaRepository<Nurse, Integer> {
}
