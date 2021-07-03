package com.arulstudies.hibernate.operations.aliens;

import javax.persistence.*;

@Entity
@Table(name = "alien")
public class Alien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
        return "{" +
                "id:" + id +
                ", location:'" + location + '\'' +
                ", name:'" + name + '\'' +
                '}';
    }
}
