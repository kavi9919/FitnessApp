package com.example.fitnessapplication;
import com.j256.ormlite.field.DatabaseField;
public class FitnessDTO {
    public FitnessDTO() {
    }
    @DatabaseField(generatedId = true)
    private int Id;

    @DatabaseField
    private String email;
    @DatabaseField
    private int steps;

}
