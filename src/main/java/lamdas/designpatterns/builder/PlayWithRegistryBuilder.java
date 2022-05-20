package lamdas.designpatterns.builder;

import lamdas.designpatterns.factory.Factory;
import lamdas.designpatterns.model.Rectangle;
import lamdas.designpatterns.model.Shape;
import lamdas.designpatterns.model.Square;

import java.util.function.Consumer;
import java.util.function.Function;

public class PlayWithRegistryBuilder {

    public static void main(String[] args) {
        Consumer<Builder<Shape>> rectangleConsumer = rectangleBuilder -> rectangleBuilder.register("rectangle", Rectangle::new);
        Consumer<Builder<Shape>> squareConsumer = rectangleBuilder -> rectangleBuilder.register("square", Square::new);
        Consumer<Builder<Shape>> consumer = rectangleConsumer.andThen(squareConsumer);

        Function<String, Factory<Shape>> errorFunction = s -> { throw new IllegalArgumentException("No shape with this name " + s);};
        Registry registry = Registry.createRegistry(consumer, errorFunction);
        Factory<Shape> factoryRectangle = registry.buildShapeFactory("rectangle");
        Factory<Shape> factorySquare = registry.buildShapeFactory("square");

        Shape rectangle = factoryRectangle.newIntance();
        Shape square = factorySquare.newIntance();

        System.out.println(rectangle);
        System.out.println(square);
        Factory<Shape> notShape = registry.buildShapeFactory("notAshape");
        Shape notExist = notShape.newIntance();
        System.out.println(notExist);


    }
}
