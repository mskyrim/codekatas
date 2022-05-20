package lamdas.visitor;

import lamdas.designpatterns.model.Body;
import lamdas.designpatterns.model.Car;
import lamdas.designpatterns.model.Engine;

import java.util.function.Consumer;

public class PlayWithVisitor {

    public static void main(String[] args) {
        Engine engine = new Engine();
        Body body = new Body();
        Car car = new Car();

        Consumer<VisitorBuilder<String>> consumer =
                Visitor.<String>forType(Car.class).execute(c -> "Visiting car: " + c)
                        .forType(Engine.class).execute(e -> "Visiting engine: " + e);
        Visitor<String> visitor = Visitor.of(consumer);

        String visitdedEngine = visitor.visit(engine);
        System.out.println("Engine : " + visitdedEngine);
        String visitdedCar = visitor.visit(car);
        System.out.println("Car : " + visitdedCar);
        //visitor.visit(engine);
    }
}
