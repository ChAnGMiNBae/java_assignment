package com.ohgiraffers.level01.basic;

import java.util.Objects;

public class Triangle extends Shape implements Resizable {

    private String name;
    private double base;
    private double height;
    private double side1;
    private double side2;
    private double side3;

    public Triangle(double base, double height, double side1, double side2, double side3) {
        this.name = "Triangle";
        this.base = base;
        this.height = height;
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    @Override
    public void resize(double factor) {
        this.base *= factor;
        this.height *= factor;
        this.side1 *= factor;
        this.side2 *= factor;
        this.side3 *= factor;
    }

    @Override
    double calculateArea() {
        return (base * height) / 2;
    }

    @Override
    double calculatePerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(base, triangle.base) == 0 && Double.compare(height, triangle.height) == 0 && Double.compare(side1, triangle.side1) == 0 && Double.compare(side2, triangle.side2) == 0 && Double.compare(side3, triangle.side3) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(base, height, side1, side2, side3);
    }
}
