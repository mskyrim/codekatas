package reflexionapi;

import reflexionapi.annotation.Column;
import reflexionapi.annotation.PrimaryKey;

public class Person {

    @PrimaryKey
    private long id;
    @Column
    private String name;
    @Column
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public static Person of(String name, int age){
        return new Person(name, age);
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
