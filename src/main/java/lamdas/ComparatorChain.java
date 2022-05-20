package lamdas;

import reflexionapi.Person;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ComparatorChain {

    public static void main(String[] args) {

        IntStream intStream = IntStream.range(0, 5);
        List<Person> personList = intStream.mapToObj(value -> new Person("Alex" + value, 10*value)).collect(Collectors.toList());
        personList.add(2, new Person("Alex1", 15));
        personList.forEach(System.out::println);
        Function<Person, String> getName = Person::getName;
        Function<Person, Integer> getAge = Person::getAge;
        Comparator<Person> nameComparator = ComparatorChain.comparing(getName);
        Comparator<Person> ageComparator = ComparatorChain.comparing(getAge);

        Comparator<Person> personComparator = nameComparator.thenComparing(ageComparator);

        System.out.println("Alex0 < Alex1 : " + (nameComparator.compare(personList.get(0), personList.get(1)) < 0));
        System.out.println("Alex1 < Alex2 : " + (personComparator.compare(personList.get(1), personList.get(2)) < 0));
        System.out.println("Alex2 < Alex3 : " + (nameComparator.compare(personList.get(2), personList.get(3)) < 0));
        System.out.println("Alex1 < Alex1Bis : " + (personComparator.compare(personList.get(1), personList.get(2)) < 0));


    }

    private static <T, U extends Comparable<U>> Comparator<T> comparing(Function<T, U> fieldExtractor) {
        Objects.requireNonNull(fieldExtractor);
        return (o1, o2) -> {
            U name1 = fieldExtractor.apply(o1);
            U name2 = fieldExtractor.apply(o2);
            return name1.compareTo(name2);
        };
    }
}
