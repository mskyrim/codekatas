package lamdas.designpatterns.model;

import java.awt.*;

public class Circle extends Shape {

    private Color color;

    public Circle(){}
    public Circle(Color color){
        this.color = color;
    }

    @Override
    public String toString() {
        return "Circle [] " + color;
    }
}
