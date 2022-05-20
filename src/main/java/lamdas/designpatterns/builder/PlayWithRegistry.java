package lamdas.designpatterns.builder;

import lamdas.designpatterns.factory.Factory;
import lamdas.designpatterns.model.Rectangle;

public class PlayWithRegistry {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        SwitchRegistry registry = new SwitchRegistry();

        Factory<Rectangle> rectangleFactory = (Factory<Rectangle>) registry.buildShapeFactory("rectangle");
        System.out.println("Rectangle : " + rectangleFactory.newIntance());
    }
}
