package com.example.hospitalapi.controllers;

import com.example.hospitalapi.entity.Nurse;
import com.example.hospitalapi.entity.Room;
import com.example.hospitalapi.exceptions.NurseNotFoundException;
import com.example.hospitalapi.exceptions.RoomNotFoundException;
import com.example.hospitalapi.repositories.INurseRepository;
import com.example.hospitalapi.repositories.IRoomRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NurseController {

    private final INurseRepository repository;

    NurseController(INurseRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/nurse")
    List<Nurse> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/nurse")
    Nurse newNurse(@RequestBody Nurse newNurse) {
        return repository.save(newNurse);
    }

    // Single item

    @GetMapping("/nurse/{id}")
    Nurse one(@PathVariable Integer id) {

        return repository.findById(id)
                .orElseThrow(() -> new NurseNotFoundException(id));
    }

    @PutMapping("/nurse/{id}")
    Nurse replaceNurse(@RequestBody Nurse newNurse, @PathVariable Integer id) {

        return repository.findById(id)
                .map(nurse -> {
                    nurse.setName(newNurse.getName());
                    return repository.save(nurse);
                })
                .orElseGet(() -> {
                    newNurse.setId(id);
                    return repository.save(newNurse);
                });
    }

    @DeleteMapping("/nurse/{id}")
    void deleteNurse(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
