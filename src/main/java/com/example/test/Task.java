package com.example.test;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Indexed;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class Task {


    private String name;
    private int Power;

    public Task(String name, int power) {
        this.name = name;
        Power = power;
    }

    public int getPower() {
        return Power;
    }

    public void setPower(int power) {
        Power = power;
    }





    public Task() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
