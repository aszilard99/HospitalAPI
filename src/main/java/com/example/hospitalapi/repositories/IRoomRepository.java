package com.example.hospitalapi.repositories;

import com.example.hospitalapi.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoomRepository extends JpaRepository<Room, Integer> {

}
