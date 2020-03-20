package com.example.pies;

public class Point {
    double x;
    double y;


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Point(double a, double b){
        x=a;
        y=b;
    }
    public Point(){}
}
