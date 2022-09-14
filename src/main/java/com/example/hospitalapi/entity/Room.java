package com.example.hospitalapi.entity;

public class Room {
    private Integer id;
    private Integer bedsTotal;
    private Integer bedsAvailable;


    public Room(Integer id, Integer bedsTotal, Integer bedsAvailable) {
        this.id = id;
        this.bedsTotal = bedsTotal;
        this.bedsAvailable = bedsAvailable;
    }


    public Integer getId() {
        return id;
    }
    public Integer getBedsTotal() {
        return bedsTotal;
    }
    public Integer getBedsAvailable() {
        return bedsAvailable;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setBedsTotal(Integer bedsTotal) {
        this.bedsTotal = bedsTotal;
    }
    public void setBedsAvailable(Integer bedsAvailable) {
        this.bedsAvailable = bedsAvailable;
    }
}
