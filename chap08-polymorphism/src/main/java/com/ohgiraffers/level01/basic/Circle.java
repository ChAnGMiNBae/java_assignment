package com.ohgiraffers.level01.basic;

import java.util.Objects;

public class Circle extends Shape implements Resizable{

    private String name;
    private double radius;

    public Circle(double radius) {
        this.name = "Circle";
        this.radius = radius;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void resize(double factor) {
        this.radius *= factor;
    }

    @Override
    double calculateArea() {
        return radius * radius * Math.PI;
    }

    @Override
    double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return Double.compare(radius, circle.radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(radius);
    }
}
