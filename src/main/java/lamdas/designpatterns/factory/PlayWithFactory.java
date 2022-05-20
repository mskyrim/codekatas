package lamdas.designpatterns.factory;

import lamdas.designpatterns.model.Circle;

import java.awt.*;

public class PlayWithFactory {

    public static void main(String[] args) {
        Factory<Circle> circleFactory = Factory.createFactory(Circle::new);
        Factory<Circle> circleFactory2 = Factory.createFactory(Circle::new, Color.RED);

        Circle circle1 = circleFactory.newIntance();
        System.out.println(circle1);

        Circle circle2 = circleFactory2.newIntance();
        System.out.println(circle2);
    }
}
