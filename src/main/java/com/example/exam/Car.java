package com.example.exam;

public class Car {

    private String name;
    private int year;
    private String color;
    private int id;

    public Car() {
    }

    public Car(String name, int year, String color, int id) {
        this.name = name;
        this.year = year;
        this.color = color;
        this.id = id;
    }

    public Car(String name, String color, int year) {
        this.name = name;
        this.color = color;
        this.year = year;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", id=" + id +
                '}';
    }
}
