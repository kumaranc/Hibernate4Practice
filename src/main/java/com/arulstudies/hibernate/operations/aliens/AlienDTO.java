package com.arulstudies.hibernate.operations.aliens;

import javax.persistence.Column;

public class AlienDTO {

    private int id;
    private String location;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AlienDTO{" +
                "id:" + id +
                ", location:'" + location + '\'' +
                ", name:'" + name + '\'' +
                '}';
    }
}
