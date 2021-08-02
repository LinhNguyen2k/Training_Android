package com.example.studentmanagement;

import java.util.Date;

public class Students {
    String name, phoneNumber, level, dOfBirth;


    public Students(String name, String phoneNumber, String level, String dOfBirth) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.level = level;
        this.dOfBirth = dOfBirth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setdOfBirth(String dOfBirth) {
        this.dOfBirth = dOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getLevel() {
        return level;
    }

    public String getdOfBirth() {
        return dOfBirth;
    }
}
