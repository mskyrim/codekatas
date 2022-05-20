package lamdas.designpatterns.builder;

import lamdas.designpatterns.factory.Factory;
import lamdas.designpatterns.model.Shape;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public interface Registry {

    Factory<Shape> buildShapeFactory(String shape);

    static Registry createRegistry(Consumer<Builder<Shape>> builderConsumer, Function<String, Factory<Shape>> errorFunction) {
        Map<String, Factory<Shape>> map = new HashMap<>();
        Builder<Shape> builder = (label, factory) -> map.put(label, factory);
        builderConsumer.accept(builder);
        System.out.println("Map : " + map);

        return shape -> map.computeIfAbsent(shape, errorFunction);
    }
}
