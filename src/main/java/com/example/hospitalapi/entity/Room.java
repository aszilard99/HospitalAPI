package com.example.hospitalapi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Room {



    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer id;
    private Integer beds_total;
    private Integer beds_available;

    Room(){}

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", beds_total=" + beds_total +
                ", beds_available=" + beds_available +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(id, room.id) && Objects.equals(beds_total, room.beds_total) && Objects.equals(beds_available, room.beds_available);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, beds_total, beds_available);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBeds_total() {
        return beds_total;
    }

    public void setBeds_total(Integer beds_total) {
        this.beds_total = beds_total;
    }

    public Integer getBeds_available() {
        return beds_available;
    }

    public void setBeds_available(Integer beds_available) {
        this.beds_available = beds_available;
    }

    public Room(Integer id, Integer beds_total, Integer beds_available) {
        this.id = id;
        this.beds_total = beds_total;
        this.beds_available = beds_available;
    }
}
