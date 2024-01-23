package com.example.fitnessapplication;

import com.j256.ormlite.field.DatabaseField;

public class UsersDTO {
    public UsersDTO() {
    }
    @DatabaseField(generatedId = true)
    private int Id;
    @DatabaseField
    private String email;
    @DatabaseField
    private String firstname;
    @DatabaseField
    private String lastname;
    @DatabaseField
    private int age;
    @DatabaseField
    private boolean gender;
    @DatabaseField
    private int fitnessgoal;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getFitnessgoal() {
        return fitnessgoal;
    }

    public void setFitnessgoal(int fitnessgoal) {
        this.fitnessgoal = fitnessgoal;
    }
}
