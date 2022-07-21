package com.example.test;

import org.springframework.stereotype.Service;

@Service
public class Users {

    private Long id;
    private String Name;
    private String Surname;
    private String[] Events;

    public Users() {
    }

    public Users(Long id, String name, String surname, String[] events) {
        this.id = id;
        Name = name;
        Surname = surname;
        Events = events;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String[] getEvents() {
        return Events;
    }

    public void setEvents(String[] events) {
        Events = events;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", Events=" + Events +
                '}';
    }
}
