package lamdas.designpatterns.builder;

import lamdas.designpatterns.factory.Factory;
import lamdas.designpatterns.model.Rectangle;
import lamdas.designpatterns.model.Shape;
import lamdas.designpatterns.model.Square;
import lamdas.designpatterns.model.Triangle;

public class SwitchRegistry {

    public Factory<? extends Shape> buildShapeFactory(String shape){
        switch (shape) {
            case "square" : return Square::new;
            case "triangle" : return Triangle::new;
            case "rectangle" : return Rectangle::new;
            default:
                throw new IllegalArgumentException("Unknown shape : " + shape);

        }
    }
}
