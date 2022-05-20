package reflexionapi;

import reflexionapi.annotation.Column;

public class PersonV2 {
    private String name;
    private int age;

    public PersonV2() {}

    public PersonV2(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "PersonV2{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static PersonV2 of(String name, int age){
        return new PersonV2(name, age);
    }
}
