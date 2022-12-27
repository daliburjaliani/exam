package com.example.exam;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Car {

    private String name;
    private int year;
    private String color;
    private int id;


    public Car(String name, String color, int year) {
        this.name = name;
        this.color = color;
        this.year = year;
    }
}
