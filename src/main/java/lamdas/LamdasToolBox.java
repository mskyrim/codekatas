package lamdas;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LamdasToolBox {

    public static void main(String[] args) {
        Supplier<String> stringSupplier = () -> "hello Mehdi";
        stringSupplier.get();
        Consumer<String> stringConsumer = s -> System.out.println("Bienvenue");
        Consumer<String> msgConsumer = s -> System.out.println(s);
        Predicate<String> isEmptyPredicate = String::isEmpty;
        Predicate<String> isLargePredicate = s -> s.length() > 4;
        Consumer<String> aggregatorConsumer = s -> {
            if(isEmptyPredicate.negate().and(isLargePredicate).test(s)){
                stringConsumer.andThen(msgConsumer).accept(s);
            }
        };

        aggregatorConsumer.accept(stringSupplier.get());

    }
}
