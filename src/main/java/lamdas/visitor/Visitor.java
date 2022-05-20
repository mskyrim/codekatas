package lamdas.visitor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public interface Visitor<R> {

    static <R> X<R> forType(Class<?> type) {
        return () -> type;
    }

    static <R> Visitor<R> of(Consumer<VisitorBuilder<R>> consumer) {
        Map<Class<?>, Function<Object, R>> registry = new HashMap<>();
        consumer.accept((type, function) -> registry.put(type, function));
        return o -> registry.get(o.getClass()).apply(o);
    }

    R visit(Object o);

    interface X<R> {

        default Y<R> execute(Function<Object, R> function){
            return visitorBuilder -> visitorBuilder.register(type(), function);
        }

        Class<?> type();
    }

    interface Y<R> extends Consumer<VisitorBuilder<R>> {
        default X<R> forType(Class<?> type) {
            return () -> type;
        }
    }
}
