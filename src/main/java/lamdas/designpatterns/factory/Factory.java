package lamdas.designpatterns.factory;

import java.util.function.Function;
import java.util.function.Supplier;

public interface Factory<T> extends Supplier<T> {

    default T newIntance() {
        return get();
    }

    static <T> Factory<T> createFactory(Supplier<T> supplier) {
        return supplier::get;
    }

    static <T, P> Factory<T> createFactory(Function<P, T> constructor, P parameter){
        return () -> constructor.apply(parameter);
    }
}
