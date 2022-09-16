package com.example.hospitalapi.controllers;

import com.example.hospitalapi.entity.Room;
import com.example.hospitalapi.exceptions.RoomNotFoundException;
import com.example.hospitalapi.repositories.IDoctorRepository;
import com.example.hospitalapi.repositories.IRoomRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoomController {
    private final IRoomRepository repository;

    RoomController(IRoomRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/room")
    List<Room> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/room")
    Room newRoom(@RequestBody Room newRoom) {
        return repository.save(newRoom);
    }

    // Single item

    @GetMapping("/room/{id}")
    Room one(@PathVariable Integer id) {

        return repository.findById(id)
                .orElseThrow(() -> new RoomNotFoundException(id));
    }

    @PutMapping("/room/{id}")
    Room replaceRoom(@RequestBody Room newRoom, @PathVariable Integer id) {

        return repository.findById(id)
                .map(room -> {
                    room.setBeds_available(newRoom.getBeds_available());
                    room.setBeds_total(newRoom.getBeds_total());
                    return repository.save(room);
                })
                .orElseGet(() -> {
                    newRoom.setId(id);
                    return repository.save(newRoom);
                });
    }

    @DeleteMapping("/room/{id}")
    void deleteRoom(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
